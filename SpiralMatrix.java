package dsa;

public class SpiralMatrix {
	//Print 2D array in spiral pattern
	
	public static void spiralMatrix(int arr[][]) {
		//border by border
		int startRow = 0;
		int endRow = arr.length-1;
		int startCol = 0;
		int endCol = arr[0].length-1;
		
		while(startRow <= endRow && startCol <= endCol) {
			//Print top border row
			for(int j=startCol;j<=endCol;j++) {
				System.out.print(arr[startRow][j] + " ");
			}
			//Print right Border
			for(int i=startRow+1;i<=endRow;i++) {
				System.out.print(arr[i][endCol] + " ");
			}
			//Print bottom border
			for(int j=endCol-1;j>=startCol;j--) {
				//so as to not print top or bottom border in special cases
				if(startCol == endCol) {
					return;
				}
				System.out.print(arr[endRow][j] + " ");
			}
			// Print left border
			for(int i=endRow-1;i>=startRow+1;i--) {
				//so as to not print left or right border in special cases
				if(startRow == endRow) {
					return;
				}
				System.out.print(arr[i][startCol] + " ");
			}
			
			//go inward 
			startRow++;
			endRow--;
			startCol++;
			endCol--;
		
			
			
			
		}
	}
	public static void main(String[] args) {
		int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		spiralMatrix(matrix);
	}

}
