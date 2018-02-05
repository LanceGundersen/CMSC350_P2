/*+----------------------------------------------------------------------
 ||
 ||  Abstract Class Operator
 ||
 ||         Author:  Lance Gundersen
 ||
 ||        Purpose:  Abstract classes for evaluate and to instruction.
 ||
 ++-----------------------------------------------------------------------*/

public abstract class Operator {

  abstract public int evaluate(int a, int b);

  abstract public String toInstruction();
}
