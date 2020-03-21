package dataStructures

// Own implementation of List, there exista built in List class.
sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// Companion object for method concerning List.
object List {

  // Variadic function (accept variable amount of args).
  def apply[A](as: A*) : List[A] = {
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def tail[A](l: List[A]): List[A] = l match {
      case Nil => Nil
      case Cons(_,xs) => xs
  }

  def setHead[A](l: List[A], head: A): List[A] = {
    Cons(head, List.tail(l))
  }

  def removeLast[A](l: List[A]) : List[A] = {
    l match {
      case Nil => Nil
      case Cons(_, Nil) => Nil
      case Cons(x, xs) => Cons(x, removeLast(xs))
    }
  }

  def append[A](l1: List[A], l2: List[A]): List[A] = {
    l1 match {
      case Nil => l2
      case Cons(x, xs) => Cons(x, append(xs, l2))
    }
  }

  def reverse[A](l: List[A]): List[A] = {
    l match {
      case Nil => Nil
      case Cons(x, Nil) => Cons(x, Nil)
      case Cons(x, xs) => append(reverse(xs), Cons(x, Nil))
    }
  }

  def sum(l: List[Int]) : Int = {
    def go(l: List[Int], acc: Int): Int = {
      l match {
        case Nil => acc
        case Cons(x,xs) => go(xs, acc+x)
      }
    }
    go(l, 0)
  }
}
