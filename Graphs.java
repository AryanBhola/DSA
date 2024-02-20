package dsa;
import java.util.*;

public class Graphs {
	static class Edge{
		int src;
		int dest;
		int wt;
		 Edge(int src,int dest){
			 this.src = src;
			 this.dest = dest;
			
			 
		 }
	}
	// BFS for non conected components
	public static void bfsNon(ArrayList<Edge>[] graph) {
		boolean visited[] = new boolean[graph.length];
		for(int i=0;i<graph.length;i++) {
			if(!visited[i]){
				bfs(graph,visited);
			}
		}
	}
		public static void bfs(ArrayList<Edge>[] graph,boolean visited[]) {
		//O(V+E) -> O {vertices + edges}
		Queue<Integer> q = new LinkedList<>();
		
		
		q.add(0);
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			if(visited[curr] == false) {
				System.out.print(curr);
				visited[curr] = true;
				
				//adding neighbours
				for(int i=0;i<graph[curr].size();i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
				
			}
		}
	}
		public static void dfsNon(ArrayList<Edge>[] graph) {
			boolean visited[] = new boolean[graph.length];
			for(int i=0;i<graph.length;i++) {				
					dfs(graph,i,visited);
				
			}
		}	
	public static void dfs(ArrayList<Edge>[] graph, int curr,boolean visited[]) {
		System.out.print(curr + " ");
		visited[curr] = true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			if(!visited[e.dest]) {
				dfs(graph,e.dest,visited);
			}
}
		
	}
	
	public static boolean hasPath(ArrayList<Edge> graph[],int src, int dest, boolean visited[]) {
		if(src == dest) {
			return true;
		}
		visited[src] = true;
		for(int i=0;i<graph[src].size();i++) {
			Edge e = graph[src].get(i);
			if(!visited[e.dest] && hasPath(graph,e.dest,dest,visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 CYCLE DETECTION
	 START
	 */
	
	public static boolean detectCycle(ArrayList<Edge> graph[]) {
		boolean visited[] = new boolean[graph.length];
		for(int i=0;i<graph.length;i++) {
			if(!visited[i]) {
				if(detectCycleUtil(graph,visited,i,-1)) 
					return true;
				
			}
		}
		
		return false;
	}
	public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean visited[], int curr,int parent) {
		visited[curr] = true;
		//call for neighbours
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			
			//Case 3 - not visited (we call for neighbor and check for cycle if not visited)
			if(!visited[e.dest]) {
				if(detectCycleUtil(graph,visited,e.dest,curr)) { 
					return true;
				}
			}
			//CASE 1 - visited and parent (always cycle)
			else if(visited[e.dest] && e.dest != parent ) {
				return true;
			}
			// CASE 2 - visited and parent (no definite answer)
			
		}
		return false;
	}
	/*
	 CYCLE DETECTION
	 END
	 */
	/*
	 BIPARTITE GRAPH 
	 START
	 */
	//BFS modification
	public static boolean isBipartite(ArrayList<Edge> graph[]) {
		int color[] = new int[graph.length];
		for(int i=0;i<color.length;i++) {
			color[i] = -1;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<graph.length;i++) {
			if(color[i] == -1) {
				q.add(i);
				color[i] = 0;
				while(!q.isEmpty()) {
					int curr = q.remove();
					for(int j=0;j<graph[curr].size();j++) {
						Edge e = graph[curr].get(j);
						if(color[e.dest]== -1 ) {
							int nextCol = color[curr]==0 ? 1:0;
							color[e.dest] = nextCol;
							q.add(e.dest);
						}
						else if(color[e.dest] == color[curr] ) {
							return false;
						}
						
					}
				}
			}
		}
		return true;
	}
	public static boolean isBipartiteUtil() {
		return false;
	}
	
	/*
	 BIPARTITE GRAPH 
	 END
	 */
	
	/*
	 CYCLE DETECTION IN DIRECTED GRAPHS
	 START
	 */
	public static boolean cycleInDirected(ArrayList<Edge> graph[]) {
		boolean vis[] = new boolean[graph.length];
		boolean stack[] = new boolean[graph.length];
		
		for(int i=0;i<graph.length;i++) {		
			if(vis[i]) {
				if(isCycleUtiL(graph,i,vis,stack)) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean isCycleUtiL(ArrayList<Edge> graph[],int curr, boolean vis[], boolean stack[] ) {
		vis[curr] = true;
		stack[curr] = true;
		for(int i=0;i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			if(stack[e.dest]) {
				return true;
			}
			else if(!vis[e.dest] && isCycleUtiL(graph,e.dest,vis,stack)) {
				return true;
			}
		}
		stack[curr] = false;
		return false;
	}
	/*
	 CYCLE DETECTION IN DIRECTED GRAPHS
	 END
	 */
	public static void main(String[] args) {
	    int vertices = 5;
	    ArrayList<Edge> graph[] = new ArrayList[vertices];

	    // create an empty graph
	    for (int i = 0; i < vertices; i++) {
	        graph[i] = new ArrayList<>();
	    }

	    // store all the edges now
	    graph[0].add(new Edge(0, 1));
	    graph[1].add(new Edge(1, 0));
	    graph[1].add(new Edge(1, 2));
	    graph[1].add(new Edge(1, 3));
	    graph[2].add(new Edge(2, 1));
	    graph[2].add(new Edge(2, 4));
	    graph[2].add(new Edge(2, 3));
	    graph[3].add(new Edge(3, 2));
	    graph[3].add(new Edge(3, 1));
	    graph[4].add(new Edge(4, 2));

	    // Print the neighbors of 2
	    for (int i = 0; i < graph[2].size(); i++) {
	        Edge e = graph[2].get(i);
	        System.out.println(e.dest);
	    }

	    // bfs(graph);
	    System.out.println();

	    // dfs(graph,0,new boolean[graph.length]);
	    boolean hasPath = hasPath(graph, 0, 5, new boolean[graph.length]);
	    System.out.println(hasPath);

	    // Cycle detect
	    // ArrayList<Edge> graphWithoutCycle[] = new ArrayList[5];
	    // ... (commented out for brevity)

	    ArrayList<Edge> nonBipartiteGraph[] = new ArrayList[5];

	    for (int i = 0; i < 5; i++) {
	        nonBipartiteGraph[i] = new ArrayList<>();
	    }

	    nonBipartiteGraph[0].add(new Edge(0, 1));
	    nonBipartiteGraph[1].add(new Edge(1, 0));
	    nonBipartiteGraph[1].add(new Edge(1, 2));
	    nonBipartiteGraph[1].add(new Edge(1, 3));
	    nonBipartiteGraph[2].add(new Edge(2, 1));
	    nonBipartiteGraph[2].add(new Edge(2, 4));
	    nonBipartiteGraph[2].add(new Edge(2, 3));
	    nonBipartiteGraph[3].add(new Edge(3, 2));
	    nonBipartiteGraph[3].add(new Edge(3, 1));
	    nonBipartiteGraph[4].add(new Edge(4, 2));
	    // Add edges within the same set to make it non-bipartite
	    nonBipartiteGraph[0].add(new Edge(0, 3));
	    nonBipartiteGraph[3].add(new Edge(3, 4));

	    // Now, the graph has edges within the same set (0-3, 3-4), making it non-bipartite.

	    ArrayList<Edge> bipartiteGraph[] = new ArrayList[5];

	    for (int i = 0; i < 5; i++) {
	        bipartiteGraph[i] = new ArrayList<>();
	    }

	    // Vertices in set A
	    bipartiteGraph[0].add(new Edge(0, 1));
	    bipartiteGraph[1].add(new Edge(1, 0));
	    bipartiteGraph[1].add(new Edge(1, 2));
	    bipartiteGraph[3].add(new Edge(3, 2));
	 
	    // Vertices in set B
	    bipartiteGraph[2].add(new Edge(2, 1));
	    bipartiteGraph[2].add(new Edge(2, 3));

	    // Now, all edges go between the two sets (A and B), making it a bipartite graph.

	    
	    System.out.println("Bipartite -> " + isBipartite(bipartiteGraph));
	    
	    
	    //Directed graph with cycle
	    
	    
	    
	}


}
