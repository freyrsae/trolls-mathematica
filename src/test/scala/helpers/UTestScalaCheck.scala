package helpers

import org.scalacheck.util.Pretty
import org.scalacheck.{Prop, Test}
import utest._

// https://github.com/lihaoyi/utest/issues/2
trait UTestScalaCheck {

  protected[this] object UTestReporter extends Test.TestCallback {
    private val prettyParams = Pretty.defaultParams

    override def onTestResult(name: String, res: org.scalacheck.Test.Result): Unit = {
      val scalaCheckResult = if (res.passed) "" else Pretty.pretty(res, prettyParams)
      assert(scalaCheckResult.isEmpty)
    }
  }

  implicit protected[this] class PropWrapper(prop: Prop) {
    def checkUTest(implicit params: Test.Parameters = Test.Parameters.default): Unit = {
      prop.check(params.withTestCallback(UTestReporter))
    }
  }

}