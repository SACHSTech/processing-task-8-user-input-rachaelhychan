import processing.core.PApplet;
import processing.core.PImage;

/**
 * User Input Flower and Clouds Interactive Drawing
 * @author Rachael Chan
 *
 */
public class Sketch extends PApplet {

  // declaring variables
  PImage imgCloud;
  PImage imgRainCloud;

  boolean blnUpPressed = false;
  boolean blnDownPressed = false;
  boolean blnLeftPressed = false;
  boolean blnRightPressed = false;
  
  int intflowerX = 200;
  int intflowerY = 200;  

  public void settings() {
  	// size call
    size(400, 400);

    // upload cloud emojis and resize cloud emojis
    imgCloud = loadImage("https://static.vecteezy.com/system/resources/previews/009/302/650/original/white-cloud-clipart-design-illustration-free-png.png");
    imgCloud.resize(100, 50);

    imgRainCloud = loadImage("https://upload.wikimedia.org/wikipedia/commons/f/f7/Light_Rain_Cloud.png");
    imgRainCloud.resize(150, 75);

  }

  
  public void setup() {
    // setting background colour to blue
    background(100, 135, 255);

    // creating the rectangular grass
    rect(0, 300, 400, 200);
    fill(130, 200, 130);
  }

  public void draw() {
	  
    // if up pressed, flower moves up
    if (blnUpPressed) {
      intflowerY--;
    }
    
    // if down pressed, flower moves down
    if (blnDownPressed) {
      intflowerY++;
    }
    
    // if left pressed, flower moves left
    if (blnLeftPressed) {
      intflowerX--;
    }
    
    // if right pressed, flower moves right
    if (blnRightPressed) {
      intflowerX++;
    }

    // if key pressed, background darkens
    if(keyPressed){
      background(40, 0, 255);
      rect(0, 300, 400, 200);
      fill(130, 200, 130);
    }
    else{
      background(100, 135, 255);
      rect(0, 300, 400, 200);
      fill(130, 200, 130);
    }

    // if text is pressed, it will display the character in the bottom right hand corner of the screen
    textSize(96);
    text(key, 300, 350);

    // if mouse pressed, it will draw a house in the bottom right corner of the screen
    if(mousePressed) {
      drawHouseWithColorRGB(200, 150, 245, 245, 230);
    }  

    drawFlower(intflowerX, intflowerY);

  }
  


  public void mouseMoved() {
    // if mouse moved, a cloud will appear
    image(imgCloud, mouseX, mouseY);
  }

  public void mouseDragged() {
    // if mouse dragged, a rainy cloud will apear
    image(imgRainCloud, mouseX, mouseY);
  }


  public void keyPressed() {
    // if statements to set booleans to true for up, down, left, and right keys when pressed
    if (keyCode == UP) {
      blnUpPressed = true;
    }
    else if (keyCode == DOWN) {
      blnDownPressed = true;
    }
    else if (keyCode == LEFT) {
      blnLeftPressed = true;
    }
    else if (keyCode == RIGHT) {
      blnRightPressed = true;
    }
  }
  
  public void keyReleased() {
    // if statements to set booleans to false for up, down, left, and right keys when the key is released
    if (keyCode == UP) {
      blnUpPressed = false;
    }
    else if (keyCode == DOWN) {
      blnDownPressed = false;
    }
    else if (keyCode == LEFT) {
      blnLeftPressed = false;
    }
    else if (keyCode == RIGHT) {
      blnRightPressed = false;
    }
  }

  


   /**
    * Allows for input of location
    *
    * @param intX  x-coordinate location of flower
    * @param intY  y-coordinate location of flower
    * @return none
    *
    */
    public void drawFlower(int intX, int intY) {
        // Define a variable for the number of Petal
        int intPetalNum;

        // Set Colour of Stroke to Black
        stroke(0);

        // Use Translate Function to Move Origin to the X and Y coordinate from the input parameters
        translate(intX, intY);

        // Create the Eight Petals of the Flower
        for(intPetalNum = 1; intPetalNum <= 8; intPetalNum ++) {
            rotate(radians(45));
            fill(230, 120, 0);
            ellipse(0, -27, 16, 80);
        }

        // Create Center of the Flower
        fill(0, 77, 13);
        stroke(0, 77, 13);
        ellipse(0, 0, 36, 36);

        // Move Origin Back to the original location
        translate(-intX, -intY);
    }

    /**
    * Allows for input of location and colour using RGB
    *
    * @param intX  x-coordinate location of house
    * @param intY  y-coordinate location of house
    * @param intRColor red colour for RGB
    * @param intGColor green colour for RGB
    * @param intBColor blue colour for RBG
    * @return none
    *
    */
    public void drawHouseWithColorRGB(int intX, int intY, int intRColor, int intGColor, int intBColor) {

        // set the color with the input RGB parameters                        
        fill(intRColor, intGColor, intBColor);
                          
        // Triangle Roof
        triangle((float) 64 + intX, (float) 9 + intY, (float) intX, (float) 89 + intY, (float) 108 + intX, (float) 89 + intY);

        // Side Roof
        quad((float) 64 + intX, (float) 9 + intY, (float) 108 + intX, (float) 89 + intY, (float) 241 + intX, (float) 74 + intY, (float) 200 + intX, (float) intY);

        // Right Wall
        quad((float) 108 + intX, (float) 89 + intY, (float) 108 + intX, (float) 187 + intY, (float) 241 + intX, (float) 162 + intY, (float) 241 + intX, (float) 74 + intY);

        // Left Wall
        quad((float) intX, (float) 89 + intY, (float) 108 + intX, (float) 89 + intY, (float) 108 + intX, (float) 187 + intY, (float) intX, (float) 187 + intY);

        // Door
        quad((float) 35 + intX, (float) 132 + intY, (float) 65 + intX, (float) 132 + intY, (float) 65 + intX, (float) 187 + intY, (float) 35 + intX, (float) 187 + intY);
    }

 
}