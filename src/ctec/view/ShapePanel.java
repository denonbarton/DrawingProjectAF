package ctec.view;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class ShapePanel extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;

	public ShapePanel()
	{
		triangleList = new ArrayList<Polygon>();
		polygonList = new ArrayList<Polygon>();
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		circleList = new ArrayList<Ellipse2D>();
		ellipseList = new ArrayList<Ellipse2D>();
	}

	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 500);
		int yPosition = (int)(Math.random() * 850);

	}

	public void addSquare()
	{
	
	}

	public void addEllipse()
	{
		int xPosition = (int)(Math.random()* 1500);
		int yPosition = (int)(Math.random() * 1000);
		int width = (int)(Math.random() * 2000);
		int height = (int)(Math.random() * 1000);
		
	Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
	ellipseList.add(currentEllipse);
	}

	public void addCircle()
	{
		int xPosition = (int)(Math.random()* 1000);
		int yPosition = (int)(Math.random() * 1000);
		int width = (int)(Math.random() * 1000);
		int height = (int)(Math.random() * 1000);
		
		Ellipse2D currentEllipse = new Ellipse2D.Double(xPosition, yPosition, width, height);
		ellipseList.add(currentEllipse);
	}

	public void addTriangle()
	{
		int[] xPoints = new int[3];
		xPoints[0] = (int) (Math.random() * 150);
		xPoints[1] = (int) (Math.random() * 250);
		xPoints[2] = (int) (Math.random() * 350);

		int[] yPoints = { (int) (Math.random() * 250), (int) (Math.random() * 450), (int) (Math.random() * 250) };

		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		triangleList.add(triangle);
	}

	public void addPolygon()
	{
		int numberOfSides = (int) (Math.random() * 9) + 3;
		int[] xPoints = new int[numberOfSides];
		int[] yPoints = new int[numberOfSides];

		for (int side = 0; side < numberOfSides; side++)
		{
			xPoints[side] = (int) (Math.random() * 200);
			yPoints[side] = (int) (Math.random() * 200);
		}
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
	}

	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		// loops to do lists.

		for (Polygon currentTriangle : triangleList)
		{
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);

			int penSize = (int) (Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));

			mainGraphics.draw(currentTriangle);
		}
		
		for(Polygon current : polygonList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
						
			int penSize = (int) (Math.random() * 10) + 3;
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(penSize));
			mainGraphics.draw(current);
			
		}
	}

	public void clear()
	{
		polygonList.clear();
		squareList.clear();
		rectangleList.clear();
		triangleList.clear();
		ellipseList.clear();
		circleList.clear();
	}
}
