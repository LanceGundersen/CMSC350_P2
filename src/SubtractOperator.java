/*+----------------------------------------------------------------------
 ||
 ||  Class SubtractOperator
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Subtracts two operators and returns.
 ||
 ++-----------------------------------------------------------------------*/

public class SubtractOperator extends Operator {

  public int evaluate(int a, int b) {
    return Math.abs(a - b);
  }

  public String toString() {
    return "-";
  }

  public String toInstruction() {
    return "Sub";
  }
}
