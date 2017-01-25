package list12;

public class Test
{
	public static void main(String args[]) throws InterruptedException 
	{
		int matrix1[][] = { { 3, 6, 7 }, { 1, 7, 0 }};
		int matrix2[][] = { { 4, 2, 5 }, { 1, 0, 1 }, { 2, 3, 9 } };
		
		int result[][] = new int[matrix1.length][matrix2.length];
		Row[] rows = new Row[matrix1.length];
			
		for(int i = 0; i < matrix1.length; i++) 
		{   
			rows[i] = new Row(matrix1, matrix2, result, i);
		}
		
		for(Row t: rows) { t.start(); } // fork
		for(Row t: rows) { t.join(); } // join
		
		for(int i = 0; i < result.length; i++)
		{     
			System.out.print("|");
			for (int j = 0; j < result[0].length; j++)
			{     
				System.out.print(result[i][j] + "\t");  
			} 
			System.out.println("|");
		}
	}
}
