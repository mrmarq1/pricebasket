package basket

import scala.collection.immutable.Seq

class OutputProcessor(val subtotal: Double, val qualifyingDiscounts: List[Seq[Any]], val totalPrice: Double) {
  // Output calculations based on discount availability
  def outputBasket(): Unit = {
    println(s"Subtotal: ${formatPrice(subtotal)}")
    if qualifyingDiscounts.nonEmpty then {
      qualifyingDiscounts.foreach {
        case Seq(discountText: String, discountAmount: Double) => println(f"$discountText: ${formatPrice(discountAmount)}")
      }
      println(s"Total price: ${formatPrice(totalPrice)}")
    }
    else {
      println("(No offers available)")
      println(s"Total price: ${formatPrice(subtotal)}")
    }
  }

  // Convert price to pence if <£1
  private def formatPrice(price: Double): String = {
    if (price < 1.00) {
      val pence = (price * 100).toInt
      s"${pence}p"
    } else {
      f"£$price%,.2f"
    }
  }
}
