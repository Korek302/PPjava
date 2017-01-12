package list11;

public class Test 
{
	public static void main(String[] args)
	{
		PriorityQueue<Character> q = new PriorityQueue<Character>();
		
		q.enqueue('a', 10);
		q.enqueue('d', 2);
		q.enqueue('s', 3);
		q.enqueue('g', 5);
		q.enqueue('c', 3);
		q.enqueue('1', 12);
		q.enqueue('z', 4);
		q.enqueue('h', 8);
		
		
		System.out.println(q.toString());
		System.out.println(q.top());
		System.out.println(q.pop());
		System.out.println(q.toString());
		
		PriorityQueue<Character> q2 = new PriorityQueue<Character>();
		
		q2.enqueue('l', 11);
		q2.enqueue('k', 2);
		q2.enqueue('j', 6);
		q2.enqueue('i', -1);
		
		System.out.println(q2.toString());
		
		q.merge(q2);
		
		System.out.println(q.toString());
		System.out.println(q2.toString());
	}
}
