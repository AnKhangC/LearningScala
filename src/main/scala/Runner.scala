import basics.{RecursionStructure, PolymorphicFuntions}

object Runner extends App {
  println("Exercises Runnner.")

  /*
   BASICS
   */

  // Recursion.
  RecursionStructure.abs(-42)
  RecursionStructure.factorial(5)
  RecursionStructure.fibonacci(6)

  // Polymorphic Functions.
  PolymorphicFuntions.findFirst(Array(2,3,4,5,3),
    (x: Int) => x == 3)
  PolymorphicFuntions.findFirst(Array("a", "b", "c"),
    (x: String) => x == "c")
  PolymorphicFuntions.isSorted(Array(2,2,4,5,8),
    (a: Int, b: Int) => a <= b)
  PolymorphicFuntions.isSorted(Array("a", "b", "a"),
    (a: String, b: String) => a <= b)

  // Currying.
  private def normalAdd(a: Int, b: Int): Int =
    a+b
  private def curriedAdd: Int => Int => Int =
    PolymorphicFuntions.curry(normalAdd)
  private def uncurriedAdd: (Int, Int) => Int =
    PolymorphicFuntions.uncurry(curriedAdd)
  println("Curried 1 + 2 = " + curriedAdd(1)(2))
  println("Uncurried 1 + 2 = " + uncurriedAdd(1, 2))

  //Compose.
  private def doubleTheSquare: Int => Int =
    PolymorphicFuntions.compose( (b: Int) => 2*b, (a: Int) => a*a )
  println("2 * (3^2) = " + doubleTheSquare(3))
}
