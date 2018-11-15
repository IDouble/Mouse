# 🖱 Mouse 🖱
A Simple **Java Library** for controlling the **Mouse**, it is:

- **Easy** to use
- **Powerful**
- **Works on multiple Monitors**
- And has **many Functions**

I searched long to find a simple **Mouse Library** for **Java** but I have found nothing that fits, 
so I wrote a simple **Java Library** to access the **Mouse**.

## 📝 Example 📝

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
