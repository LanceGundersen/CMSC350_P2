/*+----------------------------------------------------------------------
 ||
 ||  Class MultiplyOperator
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Multiply two operators and returns.
 ||
 ++-----------------------------------------------------------------------*/

public class MultiplyOperator extends Operator {

  public int evaluate(int a, int b) {
    return a * b;
  }

  public String toString() {
    return "*";
  }

  public String toInstruction() {
    return "Mul";
  }

}
