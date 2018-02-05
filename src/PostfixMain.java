import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*=============================================================================
 |   Assignment:  Project 2:  Three Address Generator
 |       Author:  Lance Gundersen
 |       Grader:  Prof. Lynda Metallo
 |
 |       Course:  CMSC 350
 |   Instructor:  Lynda Metallo
 |     Due Date:  04FEB18
 |
 |  Description:   a program that accepts an arithmetic
 |                 expression of unsigned integers in postfix notation and
 |                 builds the arithmetic expression tree that represents that
 |                 expression. From that tree, the corresponding fully
 |                 parenthesized infix expression should be displayed and a
 |                 file should be generated that contains the three address
 |                 format instructions.
 |
 |     Language:  Java 9
 |
 *===========================================================================*/

public class PostfixMain {

  private JTextField expressionField;
  private JTextField resultField = new JTextField("", 20);

  public static void main(String[] args) {
    PostfixMain postfix = new PostfixMain();
    postfix.prepareGUI();
  }

  private void prepareGUI() {
    JFrame mainFrame = new JFrame("Three Address Generator");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel window = (JPanel) mainFrame.getContentPane();
    mainFrame.setLayout(null);

    JLabel promptLabel = new JLabel("Enter Postfix Expression");
    promptLabel.setBounds(25, 5, promptLabel.getPreferredSize().width,
        promptLabel.getPreferredSize().height);
    window.add(promptLabel);

    JLabel resultLabel = new JLabel("Infix Expression");
    resultLabel.setBounds(50, 100, resultLabel.getPreferredSize().width,
        resultLabel.getPreferredSize().height);
    window.add(resultLabel);

    expressionField = new JTextField("", 20);
    expressionField.setBounds(175, 5, expressionField.getPreferredSize().width,
        expressionField.getPreferredSize().height);
    window.add(expressionField);

    resultField.setBounds(175, 100, resultField.getPreferredSize().width,
        resultField.getPreferredSize().height);
    window.add(resultField);

    JButton constructButton = new JButton("Construct Tree");
    constructButton.setBounds(175, 50, constructButton.getPreferredSize().width,
        constructButton.getPreferredSize().height);

    constructButton.addActionListener((ActionEvent e) ->
        constructButtonAction());
    window.add(constructButton);
    window.getRootPane().setDefaultButton(constructButton);

    mainFrame.setSize(500, 175);
    mainFrame.setVisible(true);
  }

  private void constructButtonAction() {
    ExpressionTreeEvaluation expressionTree = new ExpressionTreeEvaluation();
    expressionTree.create(expressionField.getText());
    resultField.setText("" + expressionTree.infix());
  }
}