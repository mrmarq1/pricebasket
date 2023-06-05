package basket

// Define the Basket class
class Calculator (val items: List[Item]) {

  // Calculate subtotal, qualifying discount(s) and total price
  def calculateBasket(): Unit = {
    val subtotal = items.map(_.price).sum
    val offers = List(Offers.ApplesOffer, Offers.SoupBreadOffer)
    try {
      offers.map(_.apply(items)) // Check apply method exists and implemented correctly when discount offers change (case objects modified)
    }
    catch {
      case e: Exception => println(s"Exception occurred: $e")
    }
    val allDiscounts = offers.map(_.apply(items))
    val qualifyingDiscounts = allDiscounts.flatMap(discount => discount match {
      case Seq(_, 0) => None
      case _ => Some(discount)
    })
    val totalDiscount = qualifyingDiscounts.flatten.collect{case discount: Double => discount}.sum
    val totalPrice = subtotal - totalDiscount
    val outputProcessor = OutputProcessor(subtotal, qualifyingDiscounts, totalPrice)
    outputProcessor.outputBasket()
  }
}