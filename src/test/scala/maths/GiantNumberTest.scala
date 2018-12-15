package maths

import utest._
import GiantNumber._
import helpers.UTestScalaCheck
import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Test.Parameters
import org.scalacheck.Prop.forAll

object GiantNumberTest extends TestSuite with UTestScalaCheck {
  override def tests = Tests{
    "creation" - {
      * - assert(0 == 0)
      * - assert(GiantNumber(1) == GiantNumber(1))
      * - assert(giantZero == GiantNumber(-1))
      * - assert(giantZero != GiantNumber(1))
      * - assert(giantMax == GiantNumber(max + 1))
      * - assert(giantMax != GiantNumber(max - 1))
    }

    implicit val params: Parameters = Parameters.default.withMinSuccessfulTests(20)
    implicit val giantNumArb: Arbitrary[GiantNumber] = Arbitrary{Gen.choose(-5, max + 5).map(GiantNumber(_))}

    "addition" - {
      * - forAll{ a: GiantNumber => a + giantMax == giantMax}.checkUTest
      * - forAll{ (a: GiantNumber, b: GiantNumber) => a + b - b <= a}.checkUTest
      * - forAll{ a: GiantNumber => a - a == giantZero}.checkUTest
    }
  }
}
