package list11;

@SuppressWarnings("hiding")
public class Pair<L, Integer> 
{
	private final L left;
	private final int right;

	public Pair(L left, int right) 
	{
		this.left = left;
	    this.right = right;
	}

	public L getLeft() 
	{ 
		return left; 
	}
	
	public int getRight() 
	{ 
		return right; 
	}

	public int compareTo(Pair<L, Integer> pair) 
	{
		return pair.getRight() - this.right;
	}
	
	public String toString()
	{
		return "[" + left + ", " + right + "]";
	}
}
