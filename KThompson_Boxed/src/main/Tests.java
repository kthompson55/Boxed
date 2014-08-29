package main;

import static org.junit.Assert.*;
import graphElements.Graph;

import org.junit.Test;

import dotsAndBoxes.DotsAndBoxes;

public class Tests
{
	private BfsGraphTraversal bfs;
	private DfsGraphTraversal dfs;
	private Graph g;
	
	private DotsAndBoxes dots;
	
	public void setUp()
	{
		bfs = new BfsGraphTraversal();
		dfs = new DfsGraphTraversal();
	}
	
	public void fillInGraphTraversal()
	{
		g = new Graph(5);
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(0, 3, 1);
		g.addEdge(0, 4, 1);
		g.addEdge(3, 4, 1);
	}
	
	public void multiTrees()
	{
		g = new Graph(4);
		g.addEdge(0,1,1);
		g.addEdge(2,3,1);
	}
	
	public void mileStoneOneGraph()
	{
		g = new Graph(8);
		g.addEdge(0,1,1);
		g.addEdge(0,2,1);
		g.addEdge(0, 3, 1);
		g.addEdge(1,2,1);
		g.addEdge(3,4,1);
		g.addEdge(3,5,1);
		g.addEdge(4,5,1);
		g.addEdge(6,7,1);
	}
	
	@Test
	/**Test BFS Traversal*/
	public void BFSTraversalTest()
	{
		setUp();
		fillInGraphTraversal();
		bfs.traverse(g);
		String desired = "[0,1,2,3,4,]";
		assertEquals(desired, bfs.toString());
	}

	@Test
	/**Test DFS Traversal*/
	public void DFSTraversalTest()
	{
		setUp();
		fillInGraphTraversal();
		dfs.traverse(g);
		String desired = "[1,2,4,3,0,]";
		assertEquals(desired, dfs.toString());
	}
	
	@Test
	/**Test BFS Multi-Tree*/
	public void BFSMultiTraversalTest()
	{
		setUp();
		multiTrees();
		bfs.traverse(g);
		String desired = "[0,1,][2,3,]";
		assertEquals(desired, bfs.toString());
	}
	
	@Test
	/**Milestone One Test*/
	public void BFSMileStoneTest()
	{
		setUp();
		mileStoneOneGraph();
		bfs.traverse(g);
		String desired = "[0,1,2,3,4,5,][6,7,]";
		assertEquals(desired, bfs.toString());
	}
	
	@Test
	/**Milestone One Test*/
	public void DFSMileStoneTest()
	{
		setUp();
		mileStoneOneGraph();
		dfs.traverse(g);
		String desired = "[2,1,5,4,3,0,][7,6,]";
		assertEquals(desired, dfs.toString());
	}

	// MILESTONE TWO
	public void setUpDAB()
	{
		dots = new DotsAndBoxes(4);
	}
	
	public void drawLines()
	{
		dots.drawLine(0, 0, 0, 1);
		dots.drawLine(0, 0, 1, 0);
		dots.drawLine(0, 1, 1, 1);
	}
	
	public void drawSingleBox()
	{
		dots.drawLine(0, 0, 0, 1);
		dots.drawLine(0, 1, 1, 1);
		dots.drawLine(1, 1, 1, 0);
		dots.drawLine(0, 0, 1, 0);
	}
	
	public void drawTwoBoxes()
	{
		dots.drawLine(0, 0, 0, 1);
		dots.drawLine(0, 1, 1, 1);
		dots.drawLine(1, 1, 1, 0);
		dots.drawLine(0, 0, 1, 0);
		dots.drawLine(1,0,2,0);
		dots.drawLine(2,0,2,1);
		dots.drawLine(2,1,1,1);
	}
	
	public void drawTwoBoxesTwoPlayers()
	{
		dots.drawLine(0, 0, 0, 1);
		dots.drawLine(0, 1, 1, 1);
		dots.drawLine(1, 1, 1, 0);
		dots.drawLine(0, 0, 1, 0);
		dots.setPlayerTurn(2);
		dots.drawLine(1,0,2,0);
		dots.drawLine(2,0,2,1);
		dots.drawLine(2,1,1,1);
	}
	
	public void drawEveryLine()
	{
		dots.drawLine(0,0,0,1);
		dots.drawLine(0,0,1,0);
		dots.drawLine(1,0,2,0);
		dots.drawLine(1,0,1,1);
		dots.drawLine(2,0,3,0);
		dots.drawLine(2,0,2,1);
		dots.drawLine(3,0,3,1);
		dots.drawLine(0,1,1,1);
		dots.drawLine(1,1,2,1);
		dots.drawLine(2,1,3,1);
		dots.drawLine(0,1,0,2);
		dots.drawLine(0,2,0,3);
		dots.drawLine(1,1,1,2);
		dots.drawLine(1,2,1,3);
		dots.drawLine(2,1,2,2);
		dots.drawLine(2,2,2,3);
		dots.drawLine(3,1,3,2);
		dots.drawLine(3,2,3,3);
		dots.drawLine(0,2,1,2);
		dots.drawLine(1,2,2,2);
		dots.drawLine(2,2,3,2);
		dots.drawLine(0,3,1,3);
		dots.drawLine(1,3,2,3);
		dots.drawLine(2,3,3,3);
	}
	
	public void drawOneDoubleCross()
	{
		dots.drawLine(0,0,1,0);
		dots.drawLine(1,0,2,0);
		dots.drawLine(2,0,2,1);
		dots.drawLine(2,1,1,1);
		dots.drawLine(1,1,0,1);
		dots.drawLine(0,1,0,0);
	}
	
	public void drawTwoDoubleCross()
	{
		dots.drawLine(0,0,1,0);
		dots.drawLine(1,0,2,0);
		dots.drawLine(2,0,2,1);
		dots.drawLine(2,1,1,1);
		dots.drawLine(1,1,0,1);
		dots.drawLine(0,1,0,0);
		
		dots.drawLine(1,2,2,2);
		dots.drawLine(2,2,3,2);
		dots.drawLine(3,2,3,3);
		dots.drawLine(3,3,2,3);
		dots.drawLine(2,3,1,3);
		dots.drawLine(1,3,1,2);
	}
	
	@Test
	public void DABGraphCreationTest()
	{
		setUpDAB();
		String desired = "[4,4,4,]\n[4,4,4,]\n[4,4,4,]\n";
		assertEquals(desired, dots.toString());
	}
	
	@Test
	public void testMovesLeftAtFull()
	{
		setUpDAB();
		assert(dots.areMovesLeft());
	}
	
	@Test
	public void testDrawLine()
	{
		setUpDAB();
		drawLines();
		String desired = "[1,3,4,]\n[4,4,4,]\n[4,4,4,]\n";
		assertEquals(desired, dots.toString());
	}
	
	@Test
	public void testScore()
	{
		setUpDAB();
		drawSingleBox();
		int playerScore = dots.getScore(1);
		assertEquals(1,playerScore);
	}
	
	@Test
	public void testMultiScore()
	{
		setUpDAB();
		drawTwoBoxes();
		int playerScore = dots.getScore(1);
		assertEquals(2,playerScore);
	}
	
	@Test
	public void testMultiPlayerScoring()
	{
		setUpDAB();
		drawTwoBoxesTwoPlayers();
		int p1Score = dots.getScore(1);
		int p2Score = dots.getScore(2);
		assertEquals(1,p1Score);
		assertEquals(1,p2Score);
	}
	
	@Test
	public void testFullGrid()
	{
		setUpDAB();
		drawEveryLine();
		assertFalse(dots.areMovesLeft());
	}
	
	@Test
	public void testSingleCross()
	{
		setUpDAB();
		drawOneDoubleCross();
		assertEquals(1,dots.countDoubleCrosses());
	}
	
	@Test
	public void testDoubleCross()
	{
		setUpDAB();
		drawTwoDoubleCross();
		assertEquals(2,dots.countDoubleCrosses());
	}
}
