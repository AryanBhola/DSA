package dsa;
import java.util.*;
public class FractionalKnapsack {

	public static void main(String[] args) {
		int value[] = {60,100,120};
		int weight[] = {10,20,30};
		int W = 50;
		double ratio[][] = new double[value.length][2];
		
		// col 1= idx ,col2 = ratio
		for (int i=0;i<value.length;i++) {
			ratio[i][0] = i;
			ratio[i][1] = value[i]/ (double)weight[i];		
			
}
		Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));
	/*----------------------------*/
		int cap = W;
		int answer = 0;
		for(int i=ratio.length-1;i>=0;i--) {
			int idx = (int)ratio[i][0];
			if(cap >= weight[idx]) {
				answer += value[idx];
				cap -= weight[idx];
			}else {
				answer += (ratio[i][1] * cap);
				cap = 0;
				break;
			}
			
		}
		
	System.out.print(answer);
	}

}
