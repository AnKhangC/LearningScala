import basics.{RecursionStructure, PolymorphicFuntions}
import dataStructures.{List}
import laziness.{Stream}

object Runner extends App {
  println("Exercises Runnner.")

  /*
   BASICS
   */

  // Recursion.
  // RecursionStructure.abs(-42)
  // RecursionStructure.factorial(5)
  // RecursionStructure.fibonacci(6)

  // Polymorphic Functions.
  // PolymorphicFuntions.findFirst(Array(2,3,4,5,3),
  //   (x: Int) => x == 3)
  // PolymorphicFuntions.findFirst(Array("a", "b", "c"),
  //   (x: String) => x == "c")
  // PolymorphicFuntions.isSorted(Array(2,2,4,5,8),
  //   (a: Int, b: Int) => a <= b)
  // PolymorphicFuntions.isSorted(Array("a", "b", "a"),
  //   (a: String, b: String) => a <= b)

  // Currying.
  // private def normalAdd(a: Int, b: Int): Int =
  //   a+b
  // private def curriedAdd: Int => Int => Int =
  //   PolymorphicFuntions.curry(normalAdd)
  // private def uncurriedAdd: (Int, Int) => Int =
  //   PolymorphicFuntions.uncurry(curriedAdd)
  // println("Curried 1 + 2 = " + curriedAdd(1)(2))
  // println("Uncurried 1 + 2 = " + uncurriedAdd(1, 2))

  // //Compose.
  // private def doubleTheSquare: Int => Int =
  //   PolymorphicFuntions.compose( (b: Int) => 2*b, (a: Int) => a*a )
  // println("2 * (3^2) = " + doubleTheSquare(3))


  /*
  DATA STRUCTURE
   */

  // List.
  // val l1 = List(1,2,3,4,5)
  // val l2 = List.tail(l1)
  // val l3 = List.setHead(l1, 5)
  // println("l1 = " + l1)
  // println("l2 = " + l2)
  // println("l3 = " + l3)
  // println("l1 + l1 = " + List.append(l1,l1))
  // println("Sum of l1 = " + List.sum(l1))
  // println("l1 and remove last = " + List.removeLast(l1))
  // println("reverse l1 = " + List.reverse(l1))

  // STD library for data structure.
  // val l4 = 1::2::3::4::5::Nil
  // println((1 :: l4.tail ::: l4.tail).map( (x: Int) => x*2 ))


  /*
  LAZYNESS
   */

  // Stream.
  val s1 = Stream.apply(1,2,3,4,5)
  println("s1 head = " + Stream.getHead(s1))
  print("s1 = "); Stream.printStream(s1)
}
