package list11;

public interface Queue<T>
{
	public void enqueue(T t, int prio);
	public Object top();
	public Object pop();
	public void merge(Queue<T> q);
	public int size();
	public boolean isEmpty();
}
