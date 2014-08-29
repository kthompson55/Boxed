package graphElements;

public class Vertex<E extends Comparable<E>> implements Comparable<Vertex<E>>
{
	private E value;
	
	public Vertex(E setValue)
	{
		value = setValue;
	}
	
	public E getValue()
	{
		return value;
	}

	@Override
	public int compareTo(Vertex<E> other)
	{
		return value.compareTo(other.getValue());
	}
}
