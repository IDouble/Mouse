package Mouse;

/**
 * A simple Library for controlling the Mouse in Java.
 * License : Mozilla Public License 2.0  /  http://choosealicense.com/licenses/mpl-2.0/#
 *
 * @author AYIDouble
 * @version 1.1
 * @since 26.06.2016
 */

import java.awt.AWTException;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Mouse {
	
    private GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); // Get Screen Height & Width
    private final int MAX_Y = gd.getDisplayMode().getHeight(); // Gets the Monitor Height & Width (Works with multiple Monitors)
    private final int MAX_X = gd.getDisplayMode().getWidth(); 
    private int mouseX = MouseInfo.getPointerInfo().getLocation().x; // Gets the x Coordinate of the Mouse 
    private int mouseY = MouseInfo.getPointerInfo().getLocation().y; // Gets the y Coordinate of the Mouse 
    
    /**
     * you can use the methods of the robot and access his attributes
     */
    public Robot robot; //public for adjustments on the robot
    
    /**
     * robot of the class will be created at initialize
     */
    public Mouse() throws AWTException{
    	robot = new Robot();
    }
    
    /**
     * Initialize Keyboard with your own robot
     * Otherwise just initialize it with the no parameters
     *
     * @param  robot - use the robot of you class
     */
    public Mouse(Robot robot){
        this.robot = robot;
    }
    
    /**
     * This will refresh the Mouse Position and save it to the variables mouseX and mouseY , you can access them with the getter methods.
     */
    public void refreshMouseInfo(){ //updates the Actual Position of the Mouse
    	mouseX = MouseInfo.getPointerInfo().getLocation().x;
        mouseY = MouseInfo.getPointerInfo().getLocation().y;
    }
    
    /**
     * Moves the mouse to the position. You can see what the maximum of your monitor/s is in the MAX_Y and MAX_X variables.
     *
     * @param x , where the Mouse should move
     * @param y , where the Mouse should move
     * @throws AWTException the AWT exception
     */
    public void move(int x,int y) throws AWTException{ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(x,y);
    }
    
    //Moving Mouse in Directions
    
    /**
     * Moves the mouse 1 pixel up
     */
    public void moveUp(){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(mouseX,--mouseY );
    }
    
    /**
     * Moves the mouse 1 pixel down
     */
    public void moveDown(){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(mouseX,++mouseY );
    }
    
    /**
     * Moves the mouse 1 pixel to the left
     */
    public void moveLeft(){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(--mouseX,mouseY );
    }
    
    /**
     * Moves the mouse 1 pixel to the right
     */
    public void moveRight(){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(++mouseX,mouseY );
    }
    
    //Moving Mouse in Directions with adjustable Mouse Speed
    
    /**
     * Moves the mouse x pixel up
     * @param x , x stands for how many pixel to move
     */
    public void moveUp(Integer x){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(mouseX,mouseY -= x );
    }
    
    /**
     * Moves the mouse x pixel down
     * @param x , x stands for how many pixel to move
     */
    public void moveDown(Integer x){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(mouseX,mouseY += x );
    }
    
    /**
     * Moves the mouse x pixel to the left
     * @param x , x stands for how many pixel to move
     */
    public void moveLeft(Integer x){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(mouseX -= x,mouseY );
    }
    
    /**
     * Moves the mouse x pixel to the right
     * @param x , x stands for how many pixel to move
     */
    public void moveRight(Integer x){ //Moves the Mouse to the position
    	refreshMouseInfo();
    	robot.mouseMove(mouseX += x,mouseY );
    }
    
    //Mouse Left Click
    
    /**
     * performs a left click
     */
    public void click(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    
    /**
     * performs x left clicks
     *
     * @param repeat , does x left clicks.
     * @throws Exception the exception
     */
    public void click(int repeat) throws Exception{ //multiple clicks
    	if(repeat > 0){
	    	for (int i = 0; i < repeat; i++) {
	    		robot.mousePress(InputEvent.BUTTON1_MASK);
		        robot.mouseRelease(InputEvent.BUTTON1_MASK);
			}
    	}else{
    		throw new Exception("repeat can't be under 0");
    	}
    }
    
    //Mouse double left Click
    
    /**
     * performs a double left Click
     */
    public void doubleClick(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    
    // Press & Release (example: if you want to mark a Text) 
    
    /**
     * keeps the mouse pressed (example: if you want to mark a Text) , look at release()
     */
    public void press(){
    	robot.mousePress(InputEvent.BUTTON1_MASK);
    }
    /**
     * releases the mouse (example: if you want to mark a Text) , look at press()
     */
    public void release(){
    	robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    
    //Mouse Wheel
    
    /**
     * moves mouseWheel 1 down
     */
    public void mouseWheelDown(){
        robot.mouseWheel(1);
    }
    /**
     * moves mouseWheel 1 up
     */
    public void mouseWheelUp(){
        robot.mouseWheel(-1);
    }
    
    //Mouse Wheel (int move: -10 for up , 10 for down)
    
    /**
     * Mouse wheel.
     *
     * @param move , Move up with negative value ex: -3, Move down with positive value ex: 3
     */
    public void mouseWheel(int move){
        robot.mouseWheel(move);
    }
    
    //Mouse Wheel Click
    
    /**
     * performs a mouse wheel click
     */
    public void mouseWheelClick(){
        robot.mousePress(InputEvent.BUTTON2_MASK);
        robot.mouseRelease(InputEvent.BUTTON2_MASK);
    }
    
    //Mouse Right Click
    
    /**
     * performs a right click
     */
    public void rightClick(){
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }
    
    /**
     * Animates a Mouse move
     *
     * @param x , where the Mouse should move
     * @param y , where the Mouse should move
     * @param speed , the milliseconds between the next move
     * @throws InterruptedException the interrupted exception
     */
    public void animateMove(int x,int y,int speed) throws InterruptedException{ //Makes a Mouse animation to the Point
    	refreshMouseInfo();
    	
    	while(x != mouseX || y != mouseY){
    		Thread.sleep(speed);
    		refreshMouseInfo();
    		if(mouseX > x){
    			moveLeft();
    		}else if(mouseX < x){
    			moveRight();
    		}else if(mouseY < y){
    			moveDown();
    		}else if(mouseY > y){
    			moveUp();
    		}
    	}
    }
    
    /**
     * Animate move.
     *
     * @param x , where the Mouse should move
     * @param y , where the Mouse should move
     * @param speed , the milliseconds between the next move
     * @param step , length of a step in pixels
     * @throws InterruptedException the interrupted exception
     */
    public void animateMove(int x,int y,int speed,int step) throws InterruptedException{ //Makes a Mouse animation to the Point
    	refreshMouseInfo();
    	
    	while(x != mouseX || y != mouseY){
    		Thread.sleep(speed);
    		refreshMouseInfo();
    		if(mouseX > x){
    			moveLeft(step);
    		}else if(mouseX < x){
    			moveRight(step);
    		}else if(mouseY < y){
    			moveDown(step);
    		}else if(mouseY > y){
    			moveUp(step);
    		}
    	}
    }
    
    //Getters for Monitor Coordinates
    
    /**
     * MAX_Y is the maximal Y Value of the Monitor or the Monitors.
     *
     * @return the MAX_Y of the Monitor or Monitors
     */
    public int getMAX_Y() {
		return MAX_Y;
	}
    
    /**
     * MAX_Y is the maximal X Value of the Monitor or the Monitors.
     *
     * @return the MAX_X of the Monitor or Monitors
     */
	public int getMAX_X() {
		return MAX_X;
	}
	
	//Getters for Mouse Coordinates
	
    /**
     * Gets the mouse x position.
     *
     * @return the mouse x position
     */
	public int getMouseX() {
		refreshMouseInfo();
		return mouseX;
	}
	
	/**
     * Gets the mouse y position.
     *
     * @return the mouse y position
     */
	public int getMouseY() {
		refreshMouseInfo();
		return mouseY;
	}
	
	//Gets the color of the pixel, where your Mouse is. (example: useful for a color picker)
	
	/**
	 * Gets the pixel color of the current position. (example: useful for a color picker)
	 *
	 * @return the pixel color of the current mouse position.
	 */
	public Color getPixelColor(){
		refreshMouseInfo();
		return robot.getPixelColor(mouseX,mouseY);
	}
}


