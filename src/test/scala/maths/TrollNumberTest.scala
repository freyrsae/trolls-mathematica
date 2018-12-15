package maths

import utest._

object TrollNumberTest extends TestSuite {

  val trollOne = TrollNumber(1)
  val trollTwo = TrollNumber(2)
  val trollThree = TrollNumber(3)
  val trollFour = TrollNumber(4)

  val tests = Tests{

    "addition" - {
      "small sum correct" - assert(trollOne + trollTwo == trollThree)
      "small sum incorrect" - assert(trollOne + trollTwo != trollFour)
    }

    "subtraction" - {
      "small sum correct" - assert(trollThree - trollTwo == trollOne)
      "small sum incorrect" - assert(trollThree - trollTwo != trollFour)
    }

    "creation" - {
      "negative" - assert(TrollNumber(-5) == NowTrollEatYou)
      "max" - assert(TrollNumber(TrollNumber.maxTrollNumber) != VeryBig)
      "big" - assert(TrollNumber(TrollNumber.maxTrollNumber + 1) == VeryBig)
    }

  }
}
