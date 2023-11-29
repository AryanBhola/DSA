package dsa;


public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		int arr[] = {4,5,6,7,0,1,2};
		System.out.println(search(arr,0,arr.length-1,0));

	}
	public static int search(int arr[],int low, int high,int key) {
		if(low>high) {
			return -1;
		}
		
		int mid  = (low+high)/2;
		if(key == arr[mid]) {
			return mid;
		}
		
		//Checking which part is sorted
		//leftpart is sorted
		if(arr[low] <= arr[mid]) {
			if(key >=arr[low] && key <=arr[mid]) {
				return search(arr,low,mid-1,key);
			}
			else {
				return search(arr,mid+1,high,key);
			}
		}
		//right part is sorted
		else {
			if(key >= arr[mid] && key <= arr[high] ) {
				return search(arr,low,mid,key);
			}
			else {
				return search(arr,mid+1,high,key);
			}
		}
		
	}
}
