package dsa;

public class CountingSort {
	public static void printarray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static int[] countingSort(int arr[]) {
		//find the largest element to find the count size length
		int largest = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			largest = Math.max(largest, arr[i]);
		}
		
		//create count array with size largest
		int[] count = new int[largest+1];
		// use loop to input frequencies of the elements
		for(int j=0;j<arr.length;j++) {
			
			count[arr[j]]++;
		}
		
		//Sorting part of code
		int index= 0;
		for(int i=0;i<count.length;i++) {
			while(count[i]>0) {
				arr[index] = i;
				index++;
				count[i]--;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[] = {1,4,1,3,2,4,3,7};
		printarray(countingSort(arr));

	}

}
