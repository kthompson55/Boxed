package dotsAndBoxes;

import graphElements.Graph;

public class DotsAndBoxes
{
	private Graph boxGraph;
	private int graphWidth;
	private int player1Score = 0, player2Score = 0;
	private int currentPlayer = 1;
	private int totalCompletedBoxes = 0;
	
	public DotsAndBoxes(int size)
	{
		graphWidth = size + 1;
		boxGraph = new Graph((int)Math.pow(size+1,2));
		generateFullGraph();
	}
	
	// creates and coin and strings graph of size+1
	private void generateFullGraph()
	{
		// columns
		for(int y = 1; y < graphWidth-1; y++)
		{
			// rows
			for(int x = 1; x < graphWidth-1; x++)
			{
				int currentBox = x + (graphWidth * y);
				// generate all four edges
				boxGraph.addEdge(currentBox, currentBox - graphWidth, 1); // up
				boxGraph.addEdge(currentBox, currentBox + graphWidth, 1); // down
				boxGraph.addEdge(currentBox, currentBox - 1, 1); // left
				boxGraph.addEdge(currentBox, currentBox + 1, 1); // right
				boxGraph.setMark(currentBox, 4);
			}
		}
	}
	
	/**Set the player that earns the points*/
	public void setPlayerTurn(int player)
	{
		currentPlayer = player;
	}
	
	/**Draw line between two boxes*/
	public int drawLine(int x1, int y1, int x2, int y2)
	{
		int boxX1 = 0;
		int boxY1 = 0;
		int boxX2 = 0;
		int boxY2 = 0;
		// vertical line (turns into horizontal)
		if(Math.abs(x1 - x2) == 0 && Math.abs(y1-y2) == 1)
		{
			// point 1 on top
			if(y1 < y2)
			{
				boxX1 = x2;
				boxY1 = y2;
				boxX2 = x2+1;
				boxY2 = boxY1;
			}
			// point 2 on top
			else
			{
				boxX1 = x1;
				boxY1 = y1;
				boxX2 = x1+1;
				boxY2 = boxY1;
			}
		}
		// horizontal line (turns into vertical)
		else if(Math.abs(x1 - x2) == 1 && Math.abs(y1-y2) == 0)
		{
			// point 1 on left
			if(x1 < x2)
			{
				boxX1 = x2;
				boxY1 = y2;
				boxX2 = boxX1;
				boxY2 = y2+1;
			}
			// point 2 on left
			else
			{
				boxX1 = x1;
				boxY1 = y1;
				boxX2 = boxX1;
				boxY2 = y1+1;
			}
		}
		else 
		{
			throw new IllegalArgumentException("Not a line of length one");
		}
		System.out.println("Box One: <" + boxX1 + "," + boxY1 + ">");
		System.out.println("Box Two: <" + boxX2 + "," + boxY2 + ">");
		int boxOneLocation = boxX1 + (graphWidth * boxY1);
		int boxTwoLocation = boxX2 + (graphWidth * boxY2);
		
		if(Math.abs(boxOneLocation - boxTwoLocation) != 1 && Math.abs(boxOneLocation - boxTwoLocation) != graphWidth)
			throw new IllegalArgumentException("Boxes are not adjacent.\nBox One: " + boxOneLocation + "\nBox Two: " + boxTwoLocation);
		
		if(!boxGraph.removeEdge(boxOneLocation,boxTwoLocation)) 
			throw new IllegalArgumentException("Line does not exist");
		boxGraph.setMark(boxOneLocation,boxGraph.getMark(boxOneLocation)-1);
		boxGraph.setMark(boxTwoLocation,boxGraph.getMark(boxTwoLocation)-1);
		
		int newTotalBoxes = 0;
		//Calculate completedBoxes_
		for(int y = 1; y < graphWidth-1; y++)
		{
			for(int x = 1; x < graphWidth-1; x++)
			{
				int currentBox = x + (graphWidth * y);
				if(boxGraph.getMark(currentBox) == 0)
				{
					newTotalBoxes++;
				}
			}
		}
		//_Calculate completedBoxes
		int newBoxes = newTotalBoxes - totalCompletedBoxes;
		totalCompletedBoxes = newTotalBoxes;
		if(currentPlayer == 1)
		{
			player1Score += newBoxes;
		}
		else
		{
			player2Score += newBoxes;
		}
		return newBoxes;
	}
	
	/**Get boxes completed by the corresponding player*/
	public int getScore(int player)
	{
		if(player == 1)
		{
			return player1Score;
		}
		else if (player == 2)
		{
			return player2Score;
		}
		else
		{
			throw new IllegalArgumentException("Player number must be 1 or 2");
		}
	}
	
	public boolean areMovesLeft()
	{
		// loop through edges, if one has a weight, return true
		for(int y = 1; y < graphWidth-1; y++)
		{
			for(int x = 1; x < graphWidth-1; x++)
			{
				if(boxGraph.isEdge(x+(graphWidth*y),(x+1)+(graphWidth*y+1)))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**Count the number of double crosses in the game*/
	public int countDoubleCrosses()
	{
		// loop through all the boxes. When finding one half of a double cross, add .5 to double cross count
		float crossCount = 0;
		for(int x = 1; x < graphWidth-1; x++)
		{
			for(int y = 1; y < graphWidth-1; y++)
			{
				int currentBox = x + (graphWidth * y);
				if(boxGraph.getMark(currentBox) == 1)
				{
					crossCount += .5f;
				}
			}
		}
		System.out.println(crossCount);
		return (int)crossCount;
	}
	
//	/**Find the number of cycles, where if you start, you must finish*/
//	public int countCycles()
//	{
//		
//	}
//	
//	/**Find the number of chains that end in a double-cross*/
//	public int countOpenChains()
//	{
//		
//	}
	
	@Override
	public String toString()
	{
		String retString = "";
		for(int x = 1; x < graphWidth-1; x++)
		{
			retString += "[";
			for(int y = 1; y < graphWidth-1; y++)
			{
				int currentBox = x + (graphWidth * y);
				retString += boxGraph.getMark(currentBox) + ",";
			}
			retString += "]\n";
		}
		return retString;
	}
}
