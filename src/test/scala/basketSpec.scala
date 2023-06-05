import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec

import java.io.{ByteArrayOutputStream, PrintStream}
import scala.Console.*
import basket.*

class basketSpec extends AnyWordSpec with should.Matchers {
  def captureOutput(block: => Unit): String = {
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(outputStream) {
      block
    }
    outputStream.toString.trim
  }

  "Basket" when {
    "given a valid basket" should {
      "trigger 2 bread-soup offers and 1 apples offer with apples offer" in {
        val userInput = "  Soup SOUp brEad   milk APPLES  "
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £4.40
            |Apples 10% off: 10p
            |Buy 2 soups get 1 bread half price: 40p
            |Total price: £3.90""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "trigger only the apples offer as no bread to get soup-bread discount" in {
        val userInput = "   AppLes Soup SOUP"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £2.30
            |Apples 10% off: 10p
            |Total price: £2.20""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "trigger only 1 soup-bread discount as only 1 bread" in {
        val userInput = "   Soup SOUP SOup Soup   BrEAd"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £3.40
            |Buy 2 soups get 1 bread half price: 40p
            |Total price: £3.00""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "trigger only 1 soup-bread discount as only 1 pair of soups" in {
        val userInput = "   Soup BREad bread bread SOup Soup   BrEAd"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £5.15
            |Buy 2 soups get 1 bread half price: 40p
            |Total price: £4.75""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "trigger no discounts (as only no bread) and subtotal should equal total price" in {
        val userInput = "   Soup SOUP   milk"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £2.60
            |(No offers available)
            |Total price: £2.60""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "trigger no discounts (as no qualifying items) and subtotal should equal total price" in {
        val userInput = "   bread milk milk   milk"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £4.70
            |(No offers available)
            |Total price: £4.70""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "trigger no discounts (as no qualifying items) and both subtotal and total price should be formatted in pence" in {
        val userInput = "   SOUP"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: 65p
            |(No offers available)
            |Total price: 65p""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "trigger 1 apples discount and subtotal should be formatted in pounds (as >=1) and total price should be formatted in pence" in {
        val userInput = "   AppLes "
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £1.00
            |Apples 10% off: 10p
            |Total price: 90p""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given a valid basket" should {
      "calculate price accurately and add commas per thousand when basket scales" in {
        val userInput = "  Soup SOUp brEad APPLES  " * 500000
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput =
          """Subtotal: £1,550,000.00
            |Apples 10% off: £50,000.00
            |Buy 2 soups get 1 bread half price: £200,000.00
            |Total price: £1,300,000.00""".stripMargin
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given an invalid basket" should {
      "generate an error message due to non-permitted item" in {
        val userInput = "Pineapples bRead milk"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput = "Error. Please only enter the items: 'Apples', 'Soup', 'Milk', 'Bread'."
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given an invalid basket" should {
      "generate an error message due to mis-spelt item" in {
        val userInput = "apple bRead milk"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput = "Error. Please only enter the items: 'Apples', 'Soup', 'Milk', 'Bread'."
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given an invalid basket" should {
      "generate an error message due to punctuation" in {
        val userInput = "Apples, bRead, milk"
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput = "Error. Please only enter the items: 'Apples', 'Soup', 'Milk', 'Bread'."
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
    "given an invalid basket" should {
      "generate an error message due to no input" in {
        val userInput = ""
        val formattedInput = userInput.toLowerCase().trim().split("\\s+")
        val expectedOutput = "Error. Please only enter the items: 'Apples', 'Soup', 'Milk', 'Bread'."
        val actualOutput = captureOutput {
          getBasket(formattedInput)
        }
        actualOutput should be(expectedOutput)
      }
    }
  }
}