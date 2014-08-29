package graphElements;

public class Edge<E extends Comparable<E>>
{
	private Vertex<E> startVertex;
	private Vertex<E> endVertex;
	private int weight;
	
	public Edge(Vertex<E> start, Vertex<E> end)
	{
		startVertex = start;
		endVertex = end;
	}
	
	public Edge(Vertex<E> start, Vertex<E> end, int edgeWeight)
	{
		startVertex = start;
		endVertex = end;
		weight = edgeWeight;
	}
	
	public Vertex<E> getFirst()
	{
		return startVertex;
	}
	
	public Vertex<E> getSecond()
	{
		return endVertex;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public boolean containsVertex(Vertex<E> v)
	{
		return v == startVertex || v == endVertex;
	}
}
