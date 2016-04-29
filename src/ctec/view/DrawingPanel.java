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
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		addRectangleButton = new JButton("add a rectangle");
		addPolygonButton = new JButton("add a polygon");
		rectangleList = new ArrayList<Rectangle>();
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
		this.add(addRectangleButton);
		this.add(addPolygonButton);
		this.add(shapePanel);
		this.add(clearButton);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, addRectangleButton, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 50, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 50, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectangleButton, 0, SpringLayout.NORTH, addPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, addRectangleButton, 0, SpringLayout.NORTH, addPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.EAST, clearButton, -15, SpringLayout.WEST, addRectangleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -45, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -50, SpringLayout.EAST, this);
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
