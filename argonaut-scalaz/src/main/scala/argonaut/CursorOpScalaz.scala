package argonaut

import scalaz._, syntax.show._
import CursorOpElementScalaz._

object CursorOpScalaz extends CursorOpScalazs {
}

trait CursorOpScalazs {
  implicit val CursorOpInstances: Show[CursorOp] with Equal[CursorOp] = {
    new Show[CursorOp] with Equal[CursorOp] {
      override def show(x: CursorOp) = x match {
        case Reattempt => ".?."
        case El(o, s) => if(s) o.show else '*' -: '.' -: o.show
      }
      def equal(a1: CursorOp, a2: CursorOp) = {
        a1 == a2
      }
    }
  }
}