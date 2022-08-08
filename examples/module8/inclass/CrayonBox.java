package inclass;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class CrayonBox
{
	private ArrayList<Color> colors;
	
	public CrayonBox()
	{
		colors = new ArrayList<Color>();
	}
	
	public CrayonBox(int n)
	{
		colors = new ArrayList<Color>();
		Random rand = new Random();
		for(int i = 0; i < n; i++)
		{
			Color c = new Color(rand.nextInt(256),
								rand.nextInt(256), 
								rand.nextInt(256));
			colors.add(c);
		}
	}
	
	public void addColor(Color color)
	{
		colors.add(color);
	}
	
	public int getNumColors()
	{
		return colors.size();
	}
	
	public Color[] getColorArray()
	{
		Color[] copy = new Color[colors.size()];
		for(int i = 0; i < copy.length; i++)
		{
			copy[i] = colors.get(i);
		}
		return copy;
	}
}
