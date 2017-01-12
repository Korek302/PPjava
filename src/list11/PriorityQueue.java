package list11;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T> implements Queue<T>
{
	private List<Pair<T, Integer>> l = new ArrayList<Pair<T, Integer>>();
	
	public PriorityQueue()
	{}
	
	public PriorityQueue(List<Pair<T, Integer>> list)
	{
		l = list;
	}
	
	private void sortQ(List<Pair<T, Integer>> list)
	{	
		for(int i = 1; i < list.size(); i++)
		{
			int j;
			Pair<T, Integer> value = list.get(i);
			for(j = i; j > 0 && value.compareTo(list.get(j - 1)) < 0; j--)
			{
				list.set(j, list.get(j - 1));
			}
			list.set(j, value);
		}
	}
	
	public void enqueue(T t, int prio)
	{
		if(t == null)
		{}
		else
		{
			l.add(new Pair<T, Integer>(t, prio));
			sortQ(l);
		}
	}
	
	public Object top() 
	{
		return l.isEmpty()?null:l.get(0);
	}

	public Object pop() 
	{
		return l.isEmpty()?null:l.remove(0);
	}

	@SuppressWarnings("unchecked")
	public void merge(Queue<T> q)
	{
		while(!q.isEmpty())
		{
			l.add((Pair<T, Integer>) q.pop());
		}
		sortQ(l);
	}
	
	public int size()
	{
		return l.size();
	}
	
	public boolean isEmpty()
	{
		return l.isEmpty();
	}
	
	public String toString()
	{
		//return l.toString();
		
		StringBuffer buf = new StringBuffer();
		buf.append('[');
		if(!l.isEmpty())
		{
			for(int i = 0; i < l.size(); i++)
			{
				buf.append(l.get(i).toString()).append(", ");
			}
			buf.setLength(buf.length()-2);
		}
		buf.append(']');
		return buf.toString();
	}

	
}