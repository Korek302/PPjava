package list12;

/*public class Multiplier
{
	public int[][] multiply(int[][] matrix1, int[][] matrix2) throws InterruptedException
	{
		int result[][] = new int[matrix1.length][matrix2.length];
		
		Row[] rows = new Row[matrix1.length];
		
		for(int i = 0; i < matrix1.length; i++) 
		{   
			rows[i] = new Row(matrix1, matrix2, result, i);
			rows[i].start();
		}
		for(Row t: rows) { t.start(); } // fork
		for(Row t: rows) { t.join(); } // join
		return result;
	}
}
*/