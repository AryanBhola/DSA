package dsa;

public class TrappedRainwater {
	public static void rainwater(int arr[]){
		int leftmax[] = new int[arr.length];	
		leftmax[0] =arr[0];
		for (int i=1;i<arr.length;i++) {
			leftmax[i] = Math.max(arr[i],leftmax[i-1]);
		}
		int rightmax[] = new int[arr.length];
		rightmax[arr.length -1] = arr[arr.length -1];
		for (int i=arr.length -2;i>0;i--) {
			rightmax[i] = Math.max(arr[i],rightmax[i+1]);
		}
		int water = 0;
		int trap = 0;
	
		
		for(int i=0;i<arr.length;i++) {
			trap = Math.min(leftmax[i], rightmax[i]) - arr[i];
			if(trap>0) {
			water+=trap;
			}
		}
		System.out.print(water);
		
		
		
	}
	public static void main(String[] args) {
		int arr[] = {4,2,0,6,3,2,5};
		rainwater(arr);
		
		

	}

}
