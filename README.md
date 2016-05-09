# Mouse
A Simple Java API for controlling the mouse

- works on multiple monitors
- powerfull
- easy to use

I searched long for a simple Mouse class in Java but i found nothing who fitted my needs,so i writted a simple Java API for accessing the Mouse.

# Example

import java.awt.AWTException;

import Mouse.Mouse;

public class Main {
	
	private static Mouse mouse;
	
	public static void main(String [] args) throws Exception {
		mouse = new Mouse();
		mouse.animateMove(100, 150, 1);
		mouse.click();
		
    	/*for(int i = 0; i < 100; i++) {
    		Thread.sleep(3);
    		mouse.moveLeft();
		}*/
	}

}

# Commands
# TODO
