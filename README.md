# 🖱 Mouse 🖱
A Simple Java Library for controlling the mouse

- works on multiple monitors
- easy to use
- powerful
- many functions

I searched long to find a simple Mouse Library for Java but I have found nothing that fits, 
so I wrote a simple Java Library to access the Mouse.

# Example

([**As an example, I used it to program a game controller with Arduino (JArduino).**](https://github.com/AYIDouble/IOT-Arduino-Game-Controller-Java))

```
import java.awt.AWTException;

import Mouse.Mouse;

public class Main {
	
	private static Mouse mouse;
	
	public static void main(String [] args) throws Exception {
		mouse = new Mouse();
		mouse.animateMove(100, 150, 1);
		mouse.click();
	}

}
```
# LICENSE

- Mozilla Public License Version 2.0
- More Informations at   http://choosealicense.com/licenses/mpl-2.0/#
