/*+----------------------------------------------------------------------
 ||
 ||  Class AddOperator
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Adds two operators and returns.
 ||
 ++-----------------------------------------------------------------------*/

public class AddOperator extends Operator {

  public int evaluate(int a, int b) {
    return a + b;
  }

  public String toString() {
    return "+";
  }

  public String toInstruction() {
    return "Add";
  }
}
