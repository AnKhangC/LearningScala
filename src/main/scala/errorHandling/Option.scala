package errorHandling

sealed trait Option[+A] {

  // Apply f if not None.
  def map[B](f: A => B): Option[B] = this match {
      case Some(x) => Some(f(x))
      case None    => None
  }

  // Apply f to option if not none.
  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case Some(x) => f(x)
    case None    => None
  }
  def flatMap2[B](f: A => Option[B]): Option[B] = {
    this.map(f) getOrElse None // same as this.map(f).getOrElse(None)
  }

  // Return value if Some else return default.
  def getOrElse[B >: A](default: => B): B = this match {
    case Some(x) => x
    case None    => default
  }

  // Evaluate ob if not none.
  def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
    case Some(x) => Some(x)
    case None    => ob
  }

  // Return None unless satisfy the predicate and not None.
  def filter(p: A => Boolean): Option[A] = {
    this.flatMap(x => if (p(x)) Some(x) else None)
  }
  def filter2(p: A => Boolean): Option[A] = this match {
    case Some(x) => if ( p(x) ) Some(x)
                    else None
    case None    => None
  }

  // If a and b are both not None apply f else return None
  def map2[A,B,C](a: Option[A], b: Option[B], f: (A, B) => Option[C]): Option[C] = {
    a flatMap( elemA => b flatMap( elemB => f(elemA, elemB) ) )
  }

  // Create a option containing all Some values of a.
  def sequence[A](list: List[Option[A]]): Option[List[A]] = {
    
    val listWithoutNone: List[A] =
      list.filter(x => x match {
        case None => false
        case _ => true
      }).map(x => x match {
        case Some(x) => x
      })

    listWithoutNone match {
      case Nil   => Some(Nil)
      case x :: xs => Some(x :: xs)
    }
  }
}

case class Some[+A](value: A) extends Option[A]
case object None extends Option[Nothing]


