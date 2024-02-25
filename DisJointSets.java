package dsa;

public class DisJointSets {
	static int n = 7;
	static int par[] = new int[n];
	static int rank[] = new int[n];
	
	public static void initialise() {
		for(int i=0;i<n;i++) {
			par[i] = i;
		}
		
	}
	//O(1)
	public static int find(int x) {
		if(x == par[x]) {
			return x;
		}
		return find(par[x]);
	}
	//O(1)
	public static void union(int a, int b) {
		int parA = find(a);
		int parB = find(b);
		
		if(rank[a] == rank[b]) {
			par[parB] = parA;
			rank[parA]++;
		}else if(rank[a] < rank[b]) {
			par[parA] = parB;
		}else if (rank[a] > rank[b]) {
			par[parB] = parA;
		}
	}
	public static void main(String[] args) {
		initialise();
		union(1,3);
		System.out.println(find(3));
		union(2,4);
		union(3,6);
		union(1,4);
		System.out.println(find(3));
		System.out.println(find(4));
		
	}

}
