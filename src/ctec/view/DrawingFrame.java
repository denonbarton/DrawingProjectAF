package ctec.view;

import javax.swing.JFrame;

import ctec.controller.DrawingController;
public class DrawingFrame extends JFrame
{
	private DrawingPanel basePanel;
	private DrawingController baseController;
	
	public DrawingFrame(DrawingController baseController)
	{
		this.baseController= baseController;
		basePanel = new DrawingPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Drawing stuff in java");
		this.setSize(500,500);
		this.setVisible(true);
	}
}