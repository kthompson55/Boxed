package graphElements;

public class Graph
{
	private int[][] matrix;
	private int[] marks; // graph coloring - indicate that a vertex is visited. Single array since it is per vertex, not edges
	
	public Graph(int size)
	{
		matrix = new int[size][size];
		marks = new int[size];
	}
	
	public int getSize()
	{
		return matrix[0].length;
	}
	
	/**Add path between two vertices*/ 
	public boolean addEdge(int startNode, int endNode, int weight)
	{
		if(startNode < getSize() && endNode < getSize())
		{
			matrix[startNode][endNode] = weight;
			matrix[endNode][startNode] = weight;
			return true;
		}
		else return false;
	}
	
	/**Remove path between two vertices, assuming the two vertices are within the matrix bounds*/
	public boolean removeEdge(int startNode, int endNode)
	{
		if(matrix[startNode][endNode] > 0)
		{
			matrix[startNode][endNode] = 0;
			matrix[endNode][startNode] = 0;
			return true;
		}
		else return false;
	}
	
	/**Retrieves path state between two nodes*/
	public boolean isEdge(int startNode, int endNode)
	{
		return matrix[startNode][endNode] != 0;
	}
	
	/**Find the first edge of the given value*/
	public int getFirstConnection(int vertex)
	{
		for(int i = 0; i < getSize(); i++)
		{
			if(matrix[vertex][i] > 0)
				return i;
		}
		return getSize(); // sentinel value
	}
	
	/**Find the next edge after the current edge*/
	public int getNextConnection(int vertex, int currentNeighbor)
	{
		for(int i = currentNeighbor+1; i < getSize(); i++)
		{
			if(matrix[vertex][i] > 0)
				return i;
		}
		return getSize();
	}
	
	public void setMark(int vertex, int mark)
	{
		marks[vertex] = mark;
	}
	
	public int getMark(int vertex)
	{
		return marks[vertex];
	}
}
