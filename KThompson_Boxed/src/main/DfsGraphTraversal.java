package main;

import graphElements.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsGraphTraversal
{
	private List<List<Integer>> traversalList;
	private Stack<Integer> stack;
	private int currentTree;
	
	public DfsGraphTraversal()
	{
		traversalList = new ArrayList<List<Integer>>();
		stack = new Stack<Integer>();
		currentTree = 0;
	}
	
	/**Create DFS tree path*/
	public List<List<Integer>> traverse(Graph g)
	{
		for(int i = 0; i < g.getSize(); i++)
		{
			if(g.getMark(i) == 0)
			{
				DFS(g,i);
				currentTree++;
			}
			else if(g.getMark(i) < 0)
			{
				throw new IllegalArgumentException("Negative Mark on Node: " + i);
			}
			
		}
		return traversalList;
	}
	
	private void DFS(Graph g, int vertex)
	{
		stack.push(vertex);
		g.setMark(vertex, g.getMark(vertex)+1);
		for(int i = g.getFirstConnection(vertex); i < g.getSize(); i = g.getNextConnection(vertex, i))
		{
			System.out.println("Current vertex: " + vertex);
			if(g.getMark(i) == 0)
			{
				g.setMark(i, g.getMark(vertex)+1);
				DFS(g, i);
			}
		}
		postvisit();
	}
	
	private void postvisit()
	{
		if(traversalList.size() <= currentTree)
		{
			traversalList.add(new ArrayList<Integer>());
		}
		traversalList.get(currentTree).add(stack.pop());
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
