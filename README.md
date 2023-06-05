# Price Basket Project

This project aims to accurately calculate and output the subtotal, discounts (if applicable) and total prices of a shopping basket given items inputted by a user (inputs and outputs via the CLI). The project will be unit test driven with multiple basket scenarios driving the development and testing of the program to help ensure accuracy, validity and scalability.

## Key learning points
- IntelliJ configuration and use.
- Scala core principles and techniques.
- Scala Test unit testing (with AnyWordSpec)

## Project parameters
- Permitted shopping basket items and related prices:
  - Apples -> £1.00
  - Bread -> £0.80
  - Milk -> £1.30
  - Soup -> £0.65
  
- Available discounts and amount saved per discount:
  - 'Apples 10% off' -> £0.10 off each bag of apples
  - 'Buy 2 soups and get 1 bread half price' -> £0.40 off each qualifying loaf of bread

## Key example outputs from testing

- User enters valid shopping basket but no discounts are available:
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/504b3c64-a0a0-4a88-ab87-558c47ed7241" width="300">

- User enters valid shopping basket but only the apples discounts is available:
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/5636410c-75da-470b-86e9-e41d986e1c92" width="300">

- User enters valid shopping basket but only soup-bread discount is available:
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/40ca1194-ded1-4df8-9dd8-86fc3b93dacd" width="300">

- User enters valid shopping basket and both discounts are available:
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/0b609a3b-b843-45e7-88c8-2259c4a35fcf" width="300">
 
- User enters an invalid shopping basket:
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/cb4cfba9-667b-4cd4-9fd2-23d0622209dd" width="500">

- Unit tests run and all passed:
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/a69b105a-a396-4cca-b7ef-5ccb9178c3fb" width="500">

## Project installation

1.  Within IntelliJ, select 'File' -> 'New' -> 'Project from Version Control...'.
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/d7b1a02b-1767-4bcb-a3bc-689f53c66677" width="500">


2.  The following window should appear:
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/f43822dc-bb51-43a3-9850-6549da7e1e3c" width="500">

- Please complete as follows:
  -  Version Control dropdown menu: Select 'Git'.
  -  URL: Paste in the repository's URL (https://github.com/mrmarq1/pricebasket.git).  
  -  Directory: Either use the auto-filled directory or a custom one 
    -  Auto-filled directory: When pasting the URL, a 'pricebasket' directory may be injected  
    -  Custom directory: Click the folder icon and navigate to a desired empty directory.
  -  Click on 'Clone' and, if prompted, please select to trust the project.
  -  Open the project in the current window or a new one. 

3.  Please wait for the 'PriceBasket' project to build - compilation status is shown at the bottom of the IntelliJ window.
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/f9230a57-4641-4c52-b5fd-b865e3cc03a5" width="500">

4. Double click on the 'build.sbt' and check all the dependencies have been loaded. If not, click on the icon to the right of the screen to do so.
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/94269176-55b6-41ea-a4d5-2d93f0c3db5f" width="250">

## Project use

### Manually inputting items
- To input shopping basket items via the CLI, please double click on the file 'Main' in Project tree (src -> main -> basket -> Main).
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/cf5e65a4-d6b7-4d3b-9ca9-afdc7b54fd4a" width="250">

- Check that 'Current File' is selected in the top-right panel of IntelliJ screen and either press the green 'run' button or use the shortcut (Windows: Shift+F10 / Macs: ^R). Wait for the project to compile and the CLI to appear at the bottom of the screen.
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/341e3a4e-d0df-491b-9e68-88e344ad5b7f" width="300">

- Following the 'PriceBasket' prompt in the command line, click on the CLI and begin entering shopping basket items ('Apples', 'Bread', 'Soup', 'Milk') and press enter to run the program.
  - Note, input is not case or whitespace sensitive but mis-spelt items (e.g. 'Apple' not 'Apples'), invalid items (e.g. 'Rice') or the input of any characters not in the items listed will yield an error message. 
- Valid Basket: If the basket entered is valid the program will output the sutotal, discounts (if applicable) and total price.
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/3813645f-43ef-4463-82a1-1af70424cee4" width="300">

- Invalid Basket: If the basket is invalid, an error message will output.

<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/9b9ca280-0ad7-4181-86c2-25aac74b48e8" width="500">

- Regardless of output, to enter another sequence of items please re-run the program, as per previous steps.

### Unit testing
- Alternatively, to unit test the program please open the 'basketSpec' file by double clicking it in the project tree (src -> test -> scala -> basketSpec).
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/36210bc9-5405-4d02-a568-34894ca8ecef" width="500">

- Run this file, as per previous steps, and the CLI should output the result (Passed/Failed).
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/a69b105a-a396-4cca-b7ef-5ccb9178c3fb" width="500">
  
### Adding/removing permitted shopping basket items
- Accounting for scaling requirements, the program has been designed to allow a user to easily add/remove permitted shopping basket items.
- If wishing to modify, please open the 'Items' file using the project tree as before (src -> main -> basket -> Items) to see the items and their associated prices contained in a Map. 
- To remove an item: remove the line relating to it in the Map and, if it is the final item in the Map, please remember to remove the comma from the previous line.
- To add an item: add it to the Map in keeping with the format of previous entries i.e. (item_name[String] -> item_price[Double]), again remembering a comma at the end if necessary.
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/c1146a15-732a-4746-b8a0-b7ddaeedd44d" width="300">
  
- After modifying, open the Main file (src -> main -> basket -> Main), run it and any items added should be permitted and, conversely, any items removed should now lead to an invalid basket if entered. For example, permitting pineapples: 
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/207c9f96-3d46-438a-8360-1a632169f792" width="300">

*** Please note that if the permitted shopping basket items are modified then some of the current unit tests may fail if run. To pass, said tests may have to be modified in 'basketSpec' (src -> test -> scala -> basketSpec).

### Adding/removing available discount offers
- Again, like the adding/removing of permitted shopping basket items, this program has been designed to allow a user to easily add/remove discounts. Please bear in mind this change will require modifications to 2 files.
- Open the Offers file (src -> main -> basket -> Offers). 
- Adding a discount: 
  - Firstly, ensure the item the offer applies to has been permitted (see 'Adding/removing permitted shopping basket items' above)   
  - Add a new apply method for the discount in question and name it appropriately and be sure to return Seq(discount_text: String, discount_amount: Double). For example, a 'PinapplesOffer' is added:
  <img src="https://github.com/mrmarq1/pricebasket/assets/126958930/15668807-393b-49a7-bc01-fd86b8232449" width="500">
  
  *** Please ensure an 'apply' method is used and the return is correct to ensure proper implementation. A 'try-catch' clause has been added in the 'Calculator' file to prompt the user with a specific error if 'Offers' is modified incorrectly.
  
  <img src="https://github.com/mrmarq1/pricebasket/assets/126958930/077639ca-4db7-43ed-bc05-df36a76d25c5" width="500">

  
  - Open the 'Calculator' file (src -> main -> basket -> Calculator) and append the offer in format 'Offer.offer_name' to the 'val offers' field. For example:
  
  <img src="https://github.com/mrmarq1/pricebasket/assets/126958930/bb530226-9e6b-4d40-a2a9-1c5baafa2130" width="500">
  
  - Now open the 'Main' file (src -> main -> basket -> Main), run the program and the offer should be applied in the output if the items entered qualify for it. For example:
  
  <img src="https://github.com/mrmarq1/pricebasket/assets/126958930/2f6f0b8e-de16-48dd-ab26-ec6dffef5b45" width="300">

- Removing a discount:
  - With reference to the 'adding a discount' steps, simply remove the 'apply' method relating to the discount in the 'Offers' file and remove the related 'Offer.offer_name' reference in the Calculator file.

*** Please note that if the discounts are modified then some of the current unit tests may fail if run. To pass, said tests may have to be modified in 'basketSpec' (src -> test -> scala -> basketSpec).
