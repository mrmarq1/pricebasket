package basket

// Define the Offers trait's fields and methods
trait Offers {
  def apply(items: List[Item]): Seq[Any]
}

object Offers {
  case object ApplesOffer extends Offers {
    override def apply(items: List[Item]): Seq[Any] = {
      val offerText = "Apples 10% off"
      val totalApplesPrice = items.collect { case Item("apples", price) => price }.sum
      val totalDiscount = totalApplesPrice * 0.1
      Seq(offerText, totalDiscount)
    }
  }

  case object SoupBreadOffer extends Offers {
    override def apply(items: List[Item]): Seq[Any] = {
      val offerText = "Buy 2 soups get 1 bread half price"
      val soupCount = items.count { case Item("soup", _) => true; case _ => false }
      val breadCount = items.count { case Item("bread", _) => true; case _ => false }
      val applicableDiscounts = Math.min(soupCount / 2, breadCount)
      val totalDiscount = applicableDiscounts * (Items.itemsRepository("bread") / 2)
      Seq(offerText, totalDiscount)
    }
  }
}
