package list12;

public class Row extends Thread
{
	private int index;
	private int matrix1[][];
	private int matrix2[][];
	private int result[][];
	
	public Row(int[][] matrix1, int[][] matrix2, int[][] result, int index) 
	{
		this.index = index;    
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.result = result;
	}
	
	@Override
	public void run()
	{   
		if(matrix1[0].length == matrix2.length)
		{    
			for(int j = 0; j < matrix2[0].length; j++)
			{          
				for(int k = 0; k < matrix1[0].length; k++)                  
					result[index][j] += (matrix1[index][k] * matrix2[k][j]);
			}
		}       
		else 
			System.out.println("The number of columns of the 1st matrix does not match the number of rows of the 2nd matrix");
	}
}