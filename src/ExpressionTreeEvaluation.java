import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/*+----------------------------------------------------------------------
 ||
 ||  Class ExpressionTreeEvaluation
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Split the inputted postfix string into stacks of
 ||                  operands and operators. Writes the output file.
 ||
 ++-----------------------------------------------------------------------*/

public class ExpressionTreeEvaluation {

  private NodeInterface node;
  private Stack<NodeInterface> nodeInterface;
  private String string;

  ExpressionTreeEvaluation() {
    nodeInterface = new Stack<>();
    string = "";
  }

  public void create(String expression) {
    if (expression.isEmpty()) {
      showMessageDialog(null, "Enter Postfix Expression.", "No Input",
          INFORMATION_MESSAGE);
      throw new RuntimeException("Blank Input");
    }

    int operatorCount = 0;

    for (int i = 0; i < expression.length(); i++) {
      char character = expression.charAt(i);

      if (isOperator(character)) {
        Operator operator = createOperator(character);
        NodeInterface a = nodeInterface.pop();
        NodeInterface b = nodeInterface.pop();
        nodeInterface.push(new OperatorNodeInterface(operator, a, b));
        updateAssembly(operator, a, b, operatorCount);
        operatorCount++;
      } else if (!Character.isWhitespace(character)) {
        if (Character.isDigit(character)) {
          nodeInterface
              .push(new OperandNodeInterface(Integer.parseInt(Character.toString(character))));
        } else {
          showMessageDialog(null, "You entered an invalid character " + character,
              "InvalidCharacter",
              ERROR_MESSAGE);
          throw new RuntimeException("Invalid Character");
        }
      }
    }
    node = nodeInterface.lastElement();
    writeToFile(string);
  }

  private boolean isOperator(char character) {
    return character == '+' || character == '-' || character == '*' || character == '/';
  }

  private Operator createOperator(char character) {
    switch (character) {
      case '+':
        return new AddOperator();
      case '-':
        return new SubtractOperator();
      case '*':
        return new MultiplyOperator();
    }
    return new DivideOperator();
  }

  public String infix() {
    if (node == null) {
      return "";
    }
    return node.inOrderWalk();
  }

  private void updateAssembly(Operator operator, NodeInterface a, NodeInterface b,
      int operatorCount) {
    string += operator.toInstruction() + " R" + operatorCount + " ";

    if (a instanceof OperandNodeInterface) {
      string += a.inOrderWalk() + " ";
      if (b instanceof OperandNodeInterface) {
        string += b.inOrderWalk() + " \n";
      } else {
        string += "R" + (operatorCount - 1) + " \n";
      }
    } else if (a instanceof OperatorNodeInterface) {
      operatorCount += (operatorCount <= 2) ? 1 : 0;
      string += "R" + (operatorCount - 2) + " ";

      if (b instanceof OperatorNodeInterface) {
        string += "R" + (operatorCount - 1) + " \n";
      } else {
        string += b.inOrderWalk() + " \n";
      }
    }
  }

  private void writeToFile(String content) {
    try (FileWriter writeInstruction = new FileWriter("ThreeAddress.txt", true)) {
      writeInstruction.write(content);
      writeInstruction.write("!!END OF RUN!!");
    } catch (IOException e) {
      // TODO: Throw exception dialog...
    }
  }

}