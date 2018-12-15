package maths

sealed trait TrollNumber extends Ordered[TrollNumber]{

  def add(t: TrollNumber): TrollNumber
  def +(t: TrollNumber): TrollNumber = add(t)

  def subtract(t:TrollNumber): TrollNumber
  def -(t: TrollNumber): TrollNumber = subtract(t)

}

object TrollNumber {
  val maxTrollNumber = 25
  def apply(i: Int): TrollNumber = i match {
    case n if n > maxTrollNumber => VeryBig
    case n if n > 0 => TrollUnderstand(n)
    case _ => NowTrollEatYou
  }
}

private case class TrollUnderstand(i: Int) extends TrollNumber {
  override def add(that: TrollNumber): TrollNumber = that match {
    case TrollUnderstand(x) => TrollNumber(x+i)
    case VeryBig => VeryBig
    case NowTrollEatYou => NowTrollEatYou
  }

  override def subtract(that: TrollNumber): TrollNumber = that match {
    case TrollUnderstand(x) => TrollNumber(i - x)
    case VeryBig => VeryBig
    case NowTrollEatYou => NowTrollEatYou
  }

  override def compare(that: TrollNumber) = that match {
    case NowTrollEatYou => 1
    case TrollUnderstand(j) => i.compare(j)
    case VeryBig => -1
  }
}

object VeryBig extends TrollNumber {
  override def add(t: TrollNumber): TrollNumber = VeryBig

  override def subtract(t: TrollNumber): TrollNumber = t match {
    case TrollUnderstand(_) => VeryBig
    case VeryBig => NowTrollEatYou
    case NowTrollEatYou => NowTrollEatYou
  }

  override def compare(that: TrollNumber) = 1
}

object NowTrollEatYou extends TrollNumber {
  override def add(t: TrollNumber): TrollNumber = NowTrollEatYou

  override def subtract(t: TrollNumber): TrollNumber = NowTrollEatYou

  override def compare(that: TrollNumber): Int = -1
}
