import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY = new float[30];
  float[] circleX = new float[30];
  boolean[] ballHideStatus = new boolean[30];

  int intSnowballSpeed = 2;

  float fltPlayerX = 400;
  float fltPlayerY = 400;

  boolean boolUpPressed = false;
  boolean boolDownPressed = false;
  boolean boolLeftPressed = false;
  boolean boolRightPressed = false;

  boolean boolPlayerStatus = true;
  int intLives = 3;

  boolean boolMouseClicked = false;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
      circleX[i] = random(width);
      ballHideStatus[i] = false;
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // check to see if player is still alive
    if (boolPlayerStatus == true) {
      background(0);
    
      fill(255);

      // draw snowballs to the screen if ballHideStatus is false
      for (int i = 0; i < circleY.length; i++) {
        if (ballHideStatus[i] == false) {
          ellipse(circleX[i], circleY[i], 50, 50);

          circleY[i] += intSnowballSpeed;
        }
    
        // resets snowball once it reaches end of screen
        if (circleY[i] > height - 25) {
          circleY[i] = 0;
        }

        // if player circle collides with snowball, stop drawing snowball to screen and remove 1 life
        if (dist(fltPlayerX, fltPlayerY, circleX[i], circleY[i]) <= 37.5 && ballHideStatus[i] == false) {
          ballHideStatus[i] = true;
          intLives--;
        }
        
        // if snowball is clicked, stop drawing snowball to screen
        if (dist(mouseX, mouseY, circleX[i], circleY[i]) <= 25 && boolMouseClicked) {
            ballHideStatus[i] = true;
        }
        
      }

      fill(168, 209, 223);

      // draw player circle
      ellipse(fltPlayerX, fltPlayerY, 25, 25);
      
      // keyboard controls for player using w, a, s, d
      if (boolLeftPressed) {
        fltPlayerX += -5;
      }
      if (boolRightPressed) {
        fltPlayerX += 5;
      }
      if (boolUpPressed) {
        fltPlayerY += -5;
      }
      if (boolDownPressed) {
        fltPlayerY += 5;
      }
  
      fill(246, 7, 17);

      // draw three squares to indicate player intLives
      for (int i = 1; i <= intLives; i++) {
        rect(70 * i, 50, 50, 50);
      }

      if (intLives == 0) {
        boolPlayerStatus = false;
      }
    }

    // screen clears to white when all lives are lost
    else {
      background(255);
    }
  }

  
  // define other methods down here.

  public void keyPressed() {
    if (key == 'a')  {
      boolLeftPressed = true;
    }
    else if (key == 'd') {
      boolRightPressed = true;
    }
    else if (key == 'w') {
      boolUpPressed = true;
    }
    else if (key == 's') {
      boolDownPressed = true;
    }

    if (keyCode == UP) {
      intSnowballSpeed = 1;
    }
    if (keyCode == DOWN) {
      intSnowballSpeed = 5;
    }
  }

  public void keyReleased() {
    if (key == 'a')  {
      boolLeftPressed = false;
    }
    else if (key == 'd') {
      boolRightPressed = false;
    }
    else if (key == 'w') {
      boolUpPressed = false;
    }
    else if (key == 's') {
      boolDownPressed = false;
    }

    if (keyCode == UP) {
      intSnowballSpeed = 2;
    }
    
    if (keyCode == DOWN) {
      intSnowballSpeed = 2;
    }
  }

  public void mousePressed() {
    boolMouseClicked = true;
  }

  public void mouseReleased() {
    boolMouseClicked = false;
  }

}
