/*+----------------------------------------------------------------------
 ||
 ||  Class DivideOperator
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Divides two operators and returns.
 ||
 ++-----------------------------------------------------------------------*/

public class DivideOperator extends Operator {

  public int evaluate(int a, int b) throws DivideByZeroException {
    return a / b;
  }

  public String toString() {
    return "/";
  }

  public String toInstruction() {
    return "Div";
  }
}
