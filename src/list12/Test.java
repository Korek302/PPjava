package list12;

public class Test
{
	public static void main(String args[]) 
	{
		Multiplier mulitiplier = new Multiplier();
		int matrix1[][] = { { 1, 1, 1 }, { 1, 1, 1 }};
		int matrix2[][] = { { 4, 2, 5 }, { 1, 0, 1 }, { 2, 3, 9 } };
		int result[][] = mulitiplier.multiply(matrix1, matrix2);
 
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
