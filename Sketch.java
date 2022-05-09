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

  }
  
  // define other methods down here.

  public void keyPressed() {
    if (keyCode == LEFT || key == 'a')  {
      leftPressed = true;
    }
    else if (keyCode == RIGHT || key == 'd') {
      rightPressed = true;
    }
    else if (keyCode == UP || key == 'w') {
      upPressed = true;
    }
    else if (keyCode == DOWN || key == 's') {
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
    if (keyCode == LEFT || key == 'a')  {
      leftPressed = false;
    }
    else if (keyCode == RIGHT || key == 'd') {
      rightPressed = false;
    }
    else if (keyCode == UP || key == 'w') {
      upPressed = false;
    }
    else if (keyCode == DOWN || key == 's') {
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