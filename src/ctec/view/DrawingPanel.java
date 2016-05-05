package ctec.view;

import javax.swing.*;

import ctec.controller.*;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel
{
	private DrawingController baseController;
	private ShapePanel shapePanel;
	private JButton addRectangleButton;
	private JButton addCirlceButton;
	private JButton addTriangleButton;
	private JButton addEllipseButton;
	private JButton addPolygonButton;
	private JButton clearButton;
	private SpringLayout baseLayout;
	private ArrayList<Rectangle> rectangleList;
	
	
	public DrawingPanel(DrawingController baseController)
	{
		rectangleList = new ArrayList<Rectangle>();
		addEllipseButton = new JButton("add an Ellipse");
		addRectangleButton = new JButton("add a Rectangle");
		addPolygonButton = new JButton("add a polygon");
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		
		
		shapePanel = new ShapePanel();
		
		
		clearButton = new JButton("clear the lists");
		
		setupPanel();
		setupLayout();
		setupListeners();
		//shapePanel = new ShapePanel();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.DARK_GRAY);
		this.add(addPolygonButton);
		this.add(addEllipseButton);
		this.add(shapePanel);
		this.add(clearButton);
		addRectangleButton = new JButton("add a rectangle");
				
		
		add(addEllipseButton);
		add(addRectangleButton);
		
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, addEllipseButton, 19, SpringLayout.EAST, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -32, SpringLayout.NORTH, clearButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addEllipseButton, 0, SpringLayout.NORTH, addPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addPolygonButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, addPolygonButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 29, SpringLayout.SOUTH, addPolygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 268, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -49, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectangleButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectangleButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, addRectangleButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, clearButton, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, addPolygonButton, 156, SpringLayout.EAST, addRectangleButton);
	}

	private void setupListeners()
	{
		addRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			}
		});
		
		addPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			}
			
		});
		
			addRectangleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					int xPosition = (int)(Math.random() * getWidth());
					int yPosition = (int)(Math.random() * getHeight());
					int width = (int) (Math.random() * 100);
					int height = (int) (Math.random() * 100);
					
					rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
					repaint();
				}
			});
	}
	
	@Override
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		Graphics2D mainGraphics = (Graphics2D) currentGraphics;
		mainGraphics.setStroke(new BasicStroke(2));
		mainGraphics.setColor(Color.CYAN);
		mainGraphics.drawRect(50,  70 , 200, 400);
		
		
		for(Rectangle current : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			
			mainGraphics.setColor(new Color(red,green,blue));
			mainGraphics.fill(current);
		}
	}
}
