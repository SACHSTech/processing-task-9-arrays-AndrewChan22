import processing.core.PApplet;

public class Sketch extends PApplet {
	
	float[] circleY = new float[30];
  float[] circleX = new float[30];
  boolean[] ballHideStatus = new boolean[30];

  int snowballSpeed = 2;

  float playerX = 400;
  float playerY = 400;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  int Lives = 3;


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

    background(0);

    fill(255);
    for (int i = 0; i < circleY.length; i++) {
      if (ballHideStatus[i] == false) {
        float circleX = width * i / circleY.length;
        ellipse(circleX, circleY[i], 50, 50);
        circleY[i] += snowballSpeed;
      }
  
      if (circleY[i] > height) {
        circleY[i] = 0;
      }
    }
    fill(168, 209, 223);
    ellipse(playerX, playerY, 25, 25);
    if (leftPressed) {
      playerX += -5;
    }
    if (rightPressed) {
      playerX += 5;
    }
    if (upPressed) {
      playerY += -5;
    }
    if (downPressed) {
      playerY += 5;
    }


  }
  
  // define other methods down here.

  public void keyPressed() {
    if (key == 'a')  {
      leftPressed = true;
    }
    else if (key == 'd') {
      rightPressed = true;
    }
    else if (key == 'w') {
      upPressed = true;
    }
    else if (key == 's') {
      downPressed = true;
    }

    if (keyCode == UP) {
      snowballSpeed = 1;
    }
    if (keyCode == DOWN) {
      snowballSpeed = 5;
    }
  }

  public void keyReleased() {
    if (key == 'a')  {
      leftPressed = false;
    }
    else if (key == 'd') {
      rightPressed = false;
    }
    else if (key == 'w') {
      upPressed = false;
    }
    else if (key == 's') {
      downPressed = false;
    }

    if (keyCode == UP) {
      snowballSpeed = 2;
    }
    
    if (keyCode == DOWN) {
      snowballSpeed = 2;
    }
  }

}