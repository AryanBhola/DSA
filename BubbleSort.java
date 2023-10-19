package dsa;

public class BubbleSort {

	
	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] bubbleSort(int arr[]) {
		int swapcount = 0;
		for(int i=0;i<arr.length;i++) {
			if(swapcount == 0 && i==1) {
				return arr;
			}
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					//swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapcount++;
				}
}
		}
		return arr;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,9,7,5};
		printarray(bubbleSort(arr));
		
		

	}

}
