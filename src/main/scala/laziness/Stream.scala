package laziness

sealed trait Stream[+A]
case object Empty extends Stream[Nothing]
case class Cons[+A] (h: () => A, t: () => Stream[A]) extends Stream[A]// Has to be forced to be eval.

object Stream {
  // Cons constructor.
  def cons[A] (hd: => A, tl: => Stream[A]) : Stream[A] = {
    lazy val head = hd // to avoid re eval.
    lazy val tail = tl // to avoid re eval.
    Cons( () => head, () => tail)
  }
  // Cons multi-variable constructor.
  def apply[A] (as: A*): Stream[A] = {
    as.isEmpty match  {
      case true  => Empty
      case false => cons(as.head, apply(as.tail: _*))
    }
  }
  // Empty constructor.
  def empty[A]: Stream[A] = Empty

  // Returns Option with head.
  def getHead[A] (s: Stream[A]) : Option[A] = {
    s match {
      case Empty      => None
      case Cons(h, t) => Some(h())
    }
  }

  // Show content of stream.
  def printStream[A] (s: Stream[A]) : Unit = {
    s match {
      case Empty      => print("Empty.")
      case Cons(h, t) => print(h() + ", "); printStream(t());
    }
  }
}

