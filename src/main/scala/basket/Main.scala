package basket

import scala.io.StdIn.readLine

// Entry point
@main def runCode(): Unit = getBasket()

def getBasket(testBasket: Array[String] = Array.empty): Unit = {
  val processedItemsList = if testBasket.isEmpty then {
    print("PriceBasket ")
    val userInput = readLine()
    val inputProcessor = InputProcessor()
    inputProcessor.processInput(userInput)
  } else {
    testBasket
  }
  val validator = Validator()
  if validator.validateBasket(processedItemsList) then
  {
    val basket = Basket(processedItemsList)
    val listValidItems = basket.itemList
    val calculator = Calculator(listValidItems)
    calculator.calculateBasket()
  }
  else
  {
    println("Error. Please only enter the items: 'Apples', 'Soup', 'Milk', 'Bread'.")
  }

}