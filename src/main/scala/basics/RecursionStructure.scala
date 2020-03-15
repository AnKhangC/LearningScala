package basics

// object keyword creates a new singleton.
object RecursionStructure {

  /*
  Find the absolute value.
   */
  def abs(n: Int) : Unit = {
    val abs = {
      if (n < 0) -n
      else n
    }
    println(s"The absolute value of $n is $abs.")
  }

  /*
  Find the factorial.
   */
  def factorial(n: Int) : Unit = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go (n-1, n*acc)
    }
    val fact = go(n, 1)
    println(s"The factorial of $n is $fact.")
  }

  /*
  Find nth fibonacci number.
   */
  def fibonacci(n: Int): Unit = {
    @annotation.tailrec
    def go(n: Int, a1: Int, acc: Int) : Int = {
      if (n <= 1) acc
      else go(n-1, acc, a1+acc)
    }
    val fib = {
      if (n == 0) 0
      else if (n == 1) 1
      else go(n, 0, 1)
    }
    println(s"The position $n Fibonacci number is $fib.")
  }
}
