package maths

sealed case class GiantNumber(i: Int) extends Ordered[GiantNumber]{
  def add(that: GiantNumber): GiantNumber = GiantNumber(this.i + that.i)
  def +(that: GiantNumber): GiantNumber = add(that)

  def subtract(that: GiantNumber): GiantNumber = GiantNumber(this.i - that.i)
  def -(that: GiantNumber): GiantNumber = subtract(that)

  override def compare(that: GiantNumber) = this.i compare that.i
}

object GiantNumber {
  val giantZero = new GiantNumber(0)
  val max = 10
  val giantMax = new GiantNumber(max)

  def apply(i: Int): GiantNumber = i match {
    case j if j < 0 => giantZero
    case j if j <= max => new GiantNumber(j)
    case _ => GiantNumber(max)
  }
  // GiantNumber(Math.min(Math.max(zero, i), max))

}
