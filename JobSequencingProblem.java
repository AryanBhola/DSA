package dsa;

import java.util.*;

public class JobSequencingProblem {

	public static void main(String[] args) {
		int jobs[][] = {{4,20},{1,10},{1,40},{1,30}};
		Arrays.sort(jobs,Comparator.comparingDouble(o -> o[1]));
		
		ArrayList<Integer> job = new ArrayList<>();
		job.add(1);
		int time = jobs[jobs.length-1][0];
		int profit = jobs[jobs.length-1][1];
		
		for(int i=jobs.length-1;i>=0;i--) {
			if(jobs[i][0] > time) {
				profit += jobs[i][1];
				time = jobs[i][0];
				job.add(i+1);
			}
		}
		
			System.out.print(profit);
			System.out.print(job);
	}

}
