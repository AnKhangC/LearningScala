package basics

object PolymorphicFuntions {

  /*
  Find index of first element that satisfy predicate p.
  Array arr can be any type (polymorphic).
   */
  def findFirst[A] (arr: Array[A], p: A => Boolean) : Unit = {
    @annotation.tailrec
    def go(cur: Int) : Int = {
      if (cur >= arr.length) -1
      else if ( p(arr(cur)) ) cur
      else go(cur+1)
    }
    val firstIndex = go(0)
    println(s"The first index that satisfy p is $firstIndex.")
  }

  /*
  Check whether array arr is sorting according to comparator.
   */
  def isSorted[A] (arr: Array[A], comp: (A,A) => Boolean): Unit = {
    @annotation.tailrec
    def go(cur: Int) : Boolean = {
      if (cur+1 >= arr.length) true
      else if ( !comp(arr(cur), arr(cur+1)) ) false
      else go(cur+1)
    }
    val b = go(0)
    if (b) println("The array is sorted.")
    else println("The array is not sorted.")
  }

  /*
  Curry function: from fct with 2 args to a partial function with 2 arg.
   */
  def curry[A,B,C] (f: (A,B) => C) : A => (B => C) = {
    (a: A) =>  (b: B) => f(a,b)
  }

  /*
  Uncurry function.
   */
  def uncurry[A,B,C] (f: A => (B => C)) : (A,B) => C = {
    (a: A, b: B) => f(a)(b)
  }

  /*
  Compose function: pipe output of g to input of f.
  compose(f, g)(a) = f(g(a))
   */
  def compose[A,B,C] (f: B => C, g: A => B): A => C = {
    (a:A) => f(g(a))
  }
}
