package main;

import graphElements.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BfsGraphTraversal
{
	private List<List<Integer>> traversalList;
	private PriorityQueue<Integer> queue;
	private int currentTree;
	
	public BfsGraphTraversal()
	{
		traversalList = new ArrayList<List<Integer>>();
		queue = new PriorityQueue<Integer>();
		currentTree = 0;
	}
	
	/**Create BFS tree path*/
	public List<List<Integer>> traverse(Graph g)
	{
		for(int i = 0; i < g.getSize(); i++)
		{
			if(g.getMark(i) == 0)
			{
				BFS(g,i);
				currentTree++;
			}
			else if(g.getMark(i) < 0)
			{
				throw new IllegalArgumentException("Negative mark for Node " + i);
			}
		}
		return traversalList;
	}
	
	/**Generate Breadth-First search based on current node*/
	private void BFS(Graph g, int vertex) 
	{
		queue.offer(vertex);
		g.setMark(vertex, g.getMark(vertex)+1);
		while (queue.size() > 0) 
		{
			int v = queue.poll();
			previsit(g, v);
			for (int w = g.getFirstConnection(v); w < g.getSize(); w = g.getNextConnection(v, w))
			{
				if(g.getMark(w) == 0) // Put neighbors into queue
				{
					g.setMark(w, g.getMark(w)+1);
					queue.offer(w);
				}
			}
		}
	}
	
	/**Adds vertex visit to adjacencyList*/
	private void previsit(Graph g,int v)
	{
		if(traversalList.size() <= currentTree)
		{
			traversalList.add(new ArrayList<Integer>());
		}
		traversalList.get(currentTree).add(v);
	}
	
	@Override
	public String toString()
	{
		String retStr = "";
		for(List<Integer> l : traversalList)
		{
			retStr += "[";
			for(Integer i : l)
			{
				retStr += i + ",";
			}
			retStr += "]";
		}
		return retStr;
	}
}
