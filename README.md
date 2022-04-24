# CSCD 212 S22 Lab2 (Test Driven Design)

## What you will be doing for this lab

> There will be a many commits (it will feel like too many commits)

1. You will write a test (then make a commit)
2. You run the test confirming the test you wrote failed 
3. Write the **simplest** code that passes the new tests (then make a commit)
4. You run the test confirming the test you wrote will now pass
5. and repeat (also check if you need to refactor)

> There is a great likelihood that you will write multiple tests into one which will violate the Single-responsibility principle

When this happens refactor your code and make a commit.

To help test if your have done this correctly use ![img.png](img.png) to see what portion of you test runs and also try to have only one assertion for each method.

### The class we will test and write
1. [Canvas class (if it help think of it as a display)](#Canvas class)

2. [Pixel class](#Pixel class)

3. [Color class](#Color class)
    
---

## [Color class](src/cscd212classes/lab2/Color.java)
An color that can be on this Canvas.

> Note: we are not using built in color (Ex. java.awt.Color)

### Static Variables

- `ArrayList<Color> allColors;` - A array to store all know colors, so we do not have any repeating colors

### Instance Variables
- `String name;` - The name of the color.
- `short[4] rgba;` - The red green blue alpha.
### Methods
- `String getName()` - Returns the name of the color.
- `short getRed()` - Returns the rgba[0]
- `short getGreen()` - Returns the rgba[1]
- `short getBlue()` - Returns the rgba[2]
- `short getAlpha()` - Returns the rgba[3]

## [Pixel class](src/cscd212classes/lab2/Pixel.java)
Keeps track of a Color, can be added on to keep track of other objects as well.
### Instance Variables
- `Color color;` – The Color located in this pixel
### Methods
- `boolean setColor(Color cr)` Sets(add) a Color to this Pixel. Will not set if a Color is already in the Pixel. Returns true if added, false otherwise.
- `Color resetColor()`– Reset(remove) the Color at Pixel. Returns the Color before reset, null if no Color is set in the Pixel.
- `Color getColor()`– Returns the Color in the Pixel.

## [Canvas class](src/cscd212classes/lab2/Canvas.java)
Keep track of a small screen of pixels in which a color exist.
These pixels are arranged in a simple grid.
### Instance Variables
- `Pixel[][] thePixels;` – A 2D array of individual pixels (Note: the filled will be final)
### Methods
- `boolean setColor(int row, int col, Color color);` - Sets(add) a color to the pixel `thePixels[row][col]`. Will not set the color if the row and col are invalid or if a color is already set in that pixel. Returns true if successfully set, false otherwise.
- `Color resetColor(int row, int col)`– Reset(remove) the Color at `thePixels[row][col]`. Returns the Color before reset, null if no Color is set in the Pixel.

---

## Help With Setting Up Your Tests

### [ExampleTests](tests/cscd212examples/lab2/ExampleTests.java)

Here is some Examples of JUnit Tests

### [JUnit Assertions PDF](JUnit-Assertions.pdf)

Here is a list of Assertions and what they do.

---

## The junit test class you need to write
1. [Canvas Tests](#Canvas Tests)

2. [Pixel Tests](#Pixel Tests)

3. [Color Tests](#Color Tests)

---

> NOTE: this may not be all the test you need

## [Color Tests](tests/cscd212classes/lab2/ColorTest.java)
- [ ] PreCheck
  - [ ] Constructor
    - [ ] Name is not null
    - [ ] Name is not Empty
    - [ ] rgba length is right size
    - [ ] rgba grader then 0
    - [ ] rgba less than 255
    - [ ] allColors does not have this name already
- [ ] Does not crash in normal uses
  - [ ] Constructor
    - [ ] does not crash when adding and checking allColors
- [ ] Make a list **rest** of the junit tests

## [Pixel Tests](tests/cscd212classes/lab2/PixelTest.java)
- [ ] Make your own list of Tests

## [Canvas Tests](tests/cscd212classes/lab2/CanvasTest.java)
- [ ] Make your own list of Tests


## Here is all the files that can help you
 - [Readme](README.md)
 - [JavaDoc](docs/index.html)
 - [Junit Assertions](JUnit-Assertions.pdf)
 - [Example Junit Tests](tests/cscd212examples/lab2/ExampleTests.java)
