import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

int dir = 2;

public void setup()
{
	size(400,400);
	background(0);
	noStroke();
}
public void draw()
{
	background(0);
	if(dir == 0)
	{
		sierpinskiTop(0,0,400);
	}
	else if(dir == 1)
	{
		sierpinskiRight(400,400,400);
	}
	else if(dir == 2)
	{
		sierpinskiBottom(0,400,400);
	}
	else 
	{
		sierpinskiLeft(0,0,400);
	}		
}


public void keyPressed()
{
	if(key == CODED)
	{
		if(keyCode == UP)
		{
			dir = 0;
		}
		if(keyCode == RIGHT)
		{
			dir = 1;
		}
		if(keyCode == DOWN)
		{
			dir = 2;
		}
		if(keyCode == LEFT)
		{
			dir = 3;
		}
	}
}
public void mouseDragged()//optional
{

}
public void sierpinskiBottom(int x, int y, int len) 
{
	if(len > 20)
	{
		sierpinskiBottom(x,y,len/2);
		sierpinskiBottom(x+len/2,y,len/2);
		sierpinskiBottom(x+len/4,y-len/2,len/2);
	}
	else
	{
		fill((int)(Math.random()*255));
		triangle(x, y, x+len, y, x+len/2, y-len);
	}
}

public void sierpinskiTop(int x, int y, int len) 
{
	if(len > 20)
	{
		sierpinskiTop(x,y,len/2);
		sierpinskiTop(x+len/2,y,len/2);
		sierpinskiTop(x+len/4,y+len/2,len/2);
	}
	else
	{
		fill((int)(Math.random()*255));
		triangle(x, y, x+len, y, x+len/2, y+len);
	}
}

public void sierpinskiLeft(int x, int y, int len) 
{
	if(len > 20)
	{
		sierpinskiLeft(x,y,len/2);
		sierpinskiLeft(x,y+len/2,len/2);
		sierpinskiLeft(x+len/2,y+len/4,len/2);
	}
	else
	{
		fill((int)(Math.random()*255));
		triangle(x, y, x, y+len, x+len, y+len/2);
	}
}

public void sierpinskiRight(int x, int y, int len) 
{
	if(len > 20)
	{
		sierpinskiRight(x,y,len/2);
		sierpinskiRight(x,y-len/2,len/2);
		sierpinskiRight(x-len/2,y-len/4,len/2);
	}
	else
	{
		fill((int)(Math.random()*255));
		triangle(x, y, x, y-len, x-len, y-len/2);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
