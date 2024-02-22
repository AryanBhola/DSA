package dsa;
import java.util.*;
//TOPOLOGICAL SORTING

public class GraphAlgorithms {
	
		static class Edge{
			int src;
			int dest;
			int wt;
			 Edge(int src,int dest){
				 this.src = src;
				 this.dest = dest;				 
			 }
			 Edge(int src,int dest,int wt){
				 this.src = src;
				 this.dest = dest;
				 this.wt = wt;
				
				 
			 }
		}
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		graph[2].add(new Edge(2,3));
		
		graph[3].add(new Edge(3,1));
		
		graph[4].add(new Edge(4,0));
		graph[4].add(new Edge(4,1));
		
		graph[5].add(new Edge(5,0));
		graph[5].add(new Edge(5,2));
	}
	public static void createGraph2(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0,1,2));
		graph[0].add(new Edge(0,2,4));
		
		graph[1].add(new Edge(1,3,7));
		graph[1].add(new Edge(1,2,1));
		
		graph[2].add(new Edge(2,4,3));
		
		graph[3].add(new Edge(3,5,1));
		
		graph[4].add(new Edge(4,3,2));
		graph[4].add(new Edge(4,5,5));
	}
	
	public static void topologicalSort(ArrayList<Edge> graph[]){ {
		boolean vis[] = new boolean[graph.length];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<graph.length;i++){			
			if(!vis[i]) {
				topSort(graph,i,vis,s);//modified DFS Function
			}
		}
		System.out.print("Topological Sort Order = " );
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		
	}
}
	public static void topSort(ArrayList<Edge> graph[],int curr, boolean vis[],Stack<Integer> s) {
		vis[curr] = true;
		//Neighbour Call
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			if(!vis[e.dest]) {
				topSort(graph,e.dest,vis,s);
			}
		}
		//Push into Stack
		s.push(curr);
	}
		
	/*
	 KAHN'S ALGO 
	 START
	 */
	public static void calcIndeg(ArrayList<Edge> graph[],int indeg[]) {
		for(int i=0;i<graph.length;i++) {
			int vertex = i;
			for(int j=0;j<graph[vertex].size();j++) {
				Edge e = graph[vertex].get(j);
				indeg[e.dest]++;
			}
		}
	}
	public static void kahn(ArrayList<Edge> graph[]) {
		int indeg[] = new int[graph.length];
		calcIndeg(graph,indeg);
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<indeg.length;i++) {
			if(indeg[i] == 0) {
				q.add(i);
			}
		}
		
		//bfs
		while(!q.isEmpty()) {
			int curr = q.remove();
			System.out.print(curr + " ");
			
			for(int i=0;i<graph[curr].size();i++) {
				Edge e = graph[curr].get(i);
				indeg[e.dest]--;
				if(indeg[e.dest] == 0) {
					q.add(e.dest);
				}
			}
		}
		System.out.println();
	}
	/*
	 KAHN'S ALGO 
	 END
	 */
	/*
	 All Paths from src to dest
	 START
	 */
	public static void allPaths(ArrayList<Edge> graph[],int src, int dest, String path) {
		if(src == dest) {
			System.out.println(path+dest);
			return;
		}
		
		for(int i=0;i<graph[src].size();i++) {
			Edge e = graph[src].get(i);
			allPaths(graph,e.dest,dest,path+src);
}
	}
	/*
	 All Paths from src to dest
	 END
	 */
	/*
	 DIJKSTRA'S ALGO
	 START
	 */
	static class Pair implements Comparable<Pair>{
		int n;
		int path;
		
		public Pair(int n,int path) {
			this.n = n;
			this.path = path;
		}
		
		

		@Override
		public int compareTo(Pair p) {
			return this.path - p.path;// sorting based on path
		}
	}
	public static void shortestPathDij(ArrayList<Edge> graph[], int src, int dest) {
		//Initialize all Distances
		int dist[] = new int[graph.length];
		for(int i=0;i<graph.length;i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;//Infinity
			}
		}
		// Create Priority Queue
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src,0));
		
		boolean vis[] = new boolean[graph.length];
		while(!pq.isEmpty()) {
			Pair smallest = pq.poll();
			if(!vis[smallest.n]) {
				vis[smallest.n] = true;
				//neighbours
				for(int i=0;i<graph[smallest.n].size();i++) {
					Edge e = graph[smallest.n].get(i);
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					
					if(dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
						pq.add(new Pair(v,dist[v]));
					}
}
			}
		}
		//Print smallest path
		for(int i=0;i<dist.length;i++) {
			System.out.print(dist[i]);
		}
		System.out.println();
	}
	/*
	 DIJKSTRA'S ALGO
	 END
	 */
	public static void main(String[] args) {
		ArrayList<Edge> graph[] = new ArrayList[6];
		createGraph(graph);
		topologicalSort(graph);
		System.out.println();
		
		System.out.print("Kahn = ");
		kahn(graph);
		System.out.println();
		
		int src = 5, dest = 1;
		System.out.print("Paths from src to dest : ");
		allPaths(graph,src,dest,"");
		
		//DIJKSTRA'S ALGO
		System.out.println();
		ArrayList<Edge> graph2[] = new ArrayList[6];
		createGraph2(graph2);
		int srcc = 0,destt = 5;
		System.out.print("Shortest Path from src to dest : ");
		shortestPathDij(graph2,srcc,destt);
		}

	}

