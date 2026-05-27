package baylinux.tierList;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class MyVBox extends VBox
{
	
	
	
	public MyVBox() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public MyVBox(double spacing, Node... children) {
		
		super(spacing, children);
		// TODO Auto-generated constructor stub
	}
	public MyVBox(double spacing) 
	{
		super(spacing);
		// TODO Auto-generated constructor stub
	}
	public MyVBox(Node... children) 
	{
		super(children);
		// TODO Auto-generated constructor stub
	}
	
	
	private int lastRightParentRowIndex=-1;
	private int lastRightQueueIndex=-1;
	private int lastLeftParentRowIndex=-1;
	private int lastLeftQueueIndex=-1;
	
	public int getLastRightParentRowIndex() 
	{
		return lastRightParentRowIndex;
	}
	public void setLastRightParentRowIndex(int lastRightParentRowIndex) 
	{
		this.lastRightParentRowIndex = lastRightParentRowIndex;
	}
	public int getLastRightQueueIndex() 
	{
		return lastRightQueueIndex;
	}
	public void setLastRightQueueIndex(int lastRightQueueIndex) 
	{
		this.lastRightQueueIndex = lastRightQueueIndex;
	}
	public int getLastLeftParentRowIndex() 
	{
		return lastLeftParentRowIndex;
	}
	public void setLastLeftParentRowIndex(int lastLeftParentRowIndex) 
	{
		this.lastLeftParentRowIndex = lastLeftParentRowIndex;
	}
	public int getLastLeftQueueIndex() 
	{
		return lastLeftQueueIndex;
	}
	public void setLastLeftQueueIndex(int lastLeftQueueIndex) 
	{
		this.lastLeftQueueIndex = lastLeftQueueIndex;
	}
	
	
	
	
	
	
	
}
