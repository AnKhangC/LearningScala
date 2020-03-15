import basics.{ObjectStructure, PolymorphicFuntions}

object Runner extends App {
  println("Exercises Runnner.")

  /*
   BASICS
   */

  // Recursion.
//  ObjectStructure.abs(-42)
//  ObjectStructure.factorial(5)
//  ObjectStructure.fibonacci(6)

  // Polymorphic Functions.
//  PolymorphicFuntions.findFirst(Array(2,3,4,5,3),
//    (x: Int) => x == 3)
//  PolymorphicFuntions.findFirst(Array("a", "b", "c"),
//    (x: String) => x == "c")
//  PolymorphicFuntions.isSorted(Array(2,2,4,5,8),
//    (a: Int, b: Int) => a <= b)
//  PolymorphicFuntions.isSorted(Array("a", "b", "a"),
//    (a: String, b: String) => a <= b)

  // Currying.
  def normalAdd(a: Int, b: Int): Int =
    a+b
  def curriedAdd: Int => Int => Int =
    PolymorphicFuntions.curry(normalAdd)
  def uncurriedAdd: (Int, Int) => Int =
    PolymorphicFuntions.uncurry(curriedAdd)
  println("Curried 1 + 2 = " + curriedAdd(1)(2))
  println("Uncurried 1 + 2 = " + uncurriedAdd(1, 2))
}
