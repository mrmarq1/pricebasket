# Price Basket Project

This project aims to accurately calculate and output the subtotal, discounts (if applicable) and total prices of a shopping basket given items inputted by a user (inputs and outputs via the CLI). The project will be unit test driven with multiple basket scenarios driving the development and testing of the program to help ensure accuracy, validity and scalability.

## Key learning points
- IntelliJ configuration and use.
- Scala core principles and techniques.
- Scala Test unit testing (with AnyWordSpec)

## Project parameters:
- Permitted shopping basket items and related prices:
  - Apples -> £1.00
  - Bread -> £0.80
  - Milk -> £1.30
  - Soup -> £0.65
  
- Available discounts and amount saved per discount:
  - 'Apples 10% off' -> £0.10 per bag of apples
  - 'Buy 2 soups and get 1 bread half price' -> £0.40 per loaf of bread 
 
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
  
### Adding new shopping basket items:
- Accounting for scaling requirements, the program has been designed to allow a user to easily add/remove permitted shopping basket items.
- If wishing to modify, please open the 'Items' file using the project tree as before (src -> main -> basket -> Items) to see the items and their associated prices contained in a Map. 
- To remove an item: remove the line relating to it in the Map and, if it is the final item in the Map, please remember to remove the comma from the previous line.
- To add an item: add it to the Map in keeping with the format of previous entries i.e. (item_name[String] -> item_price[Double]), again remembering a comma at the end if necessary.
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/c1146a15-732a-4746-b8a0-b7ddaeedd44d" width="300">
  
- After modifying, open the Main file (src -> main -> basket -> Main), run it and any items added should be permitted and, conversely, any items removed should now lead to an invalid basket if entered. For example, permitting pineapples: 
<img src="https://github.com/mrmarq1/pricebasket/assets/126958930/207c9f96-3d46-438a-8360-1a632169f792" width="300">

*** Please note, that if the permitted shopping basket items are modified then some of the current unit tests may fail if run. To pass said tests may have to be modified in 'basketSpec' (src -> test -> scala -> basketSpec).  
   
