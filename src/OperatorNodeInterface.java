/*+----------------------------------------------------------------------
 ||
 ||  Class OperatorNodeInterface
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Provides interface for supporting methods and classes
 ||                  for evalution and order walking for operators.
 ||
 ++-----------------------------------------------------------------------*/

public class OperatorNodeInterface implements NodeInterface {

  private NodeInterface a, b;
  private Operator operator;

  OperatorNodeInterface(Operator op, NodeInterface a, NodeInterface b) {
    this.operator = op;
    this.a = a;
    this.b = b;
  }

  public int evaluate() {
    int a = this.a.evaluate();
    int b = this.b.evaluate();
    return operator.evaluate(a, b);
  }

  public String preOrderWalk() {
    String aValue = a.preOrderWalk();
    String bValue = b.preOrderWalk();
    return new StringBuilder().append("").append(operator).append(" ").append(aValue).append(" ")
        .append(bValue).toString();
  }

  public String inOrderWalk() {
    String aValue = a.inOrderWalk();
    String bValue = b.inOrderWalk();
    return new StringBuilder().append("(").append(aValue).append(" ").append(operator).append(" ")
        .append(bValue).append(")").toString();
  }

  public String postOrderWalk() {
    String aValue = a.postOrderWalk();
    String bValue = b.postOrderWalk();
    return new StringBuilder().append(aValue).append(" ").append(bValue).append(" ")
        .append(operator).toString();
  }
}
