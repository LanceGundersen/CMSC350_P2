import static java.lang.String.valueOf;

/*+----------------------------------------------------------------------
 ||
 ||  Class OperandNodeInterface
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Provides interface for supporting methods and classes
 ||                  for evalution and order walking for operand.
 ||
 ++-----------------------------------------------------------------------*/

public class OperandNodeInterface implements NodeInterface {

  private int nodeValue;

  OperandNodeInterface(int value) {
    this.nodeValue = value;
  }

  public int evaluate() {
    return nodeValue;
  }

  public String preOrderWalk() {
    return valueOf(nodeValue);
  }

  public String inOrderWalk() {
    return valueOf(nodeValue);
  }

  public String postOrderWalk() {
    return valueOf(nodeValue);
  }
}
