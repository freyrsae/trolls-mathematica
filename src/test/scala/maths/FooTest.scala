package maths

import utest._
import cats.Semigroup
import cats.implicits._

object FooTest extends TestSuite {

  val trollOne = TrollNumber(1)
  val trollTwo = TrollNumber(2)
  val trollThree = TrollNumber(3)
  val trollFour = TrollNumber(4)

  val tests = Tests{

   "cats" - {
     "foo" - assert(Semigroup[List[Int]].combine(List(1, 2, 3), List(4, 5, 6)) == List(1, 2, 3, 4, 5, 6))
     "foo2" - assert(Semigroup[Option[Set[String]]].combine(Some(Set("a")), Some(Set("b"))) == Some(Set("a", "b")))
     "foo3" - {
       Some("a").combine(Some("a"))
       println(Semigroup[Int => Int].combine(_ + 1, _ * 10).apply(6))
     }
   }

  }

}
