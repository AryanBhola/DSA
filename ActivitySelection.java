package dsa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

	public static void main(String[] args) {
		int start[] = {1,3,0,5,8,5};
		int end[] = {2,4,6,7,9,9};
		
		// since the end array has to be sorted the code is below
		// we will use 2d array sorting where we ca  sort according to a column
		int activities[][] = new int[start.length][3];
		
		for(int i=0;i<start.length;i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}
		// Lambda funtion in java
		
		Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
		
		
		
		//-----sorting over
		int maxAct = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		
		//1st activity is selected always 
		maxAct = 1;
		ans.add(1);
		
		for(int i=1;i<end.length;i++) {
			if(start[i] >= end[i-1]) {
				ans.add(i+1);
				maxAct++;
			}
		}
		
		System.out.print(maxAct + " " + ans);

	}

}
