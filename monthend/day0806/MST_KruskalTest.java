import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST_KruskalTest {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
			
	}
	
	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(bf.readLine(), " ");
		V = Integer.parseInt(stt.nextToken());
		E = Integer.parseInt(stt.nextToken());
		edgeList = new Edge[E];
		parents = new int[V];
		
		int from, to, weight;
		for(int i = 0; i < E; i++) {
			stt = new StringTokenizer(bf.readLine(), " ");
			from = Integer.parseInt(stt.nextToken());
			to = Integer.parseInt(stt.nextToken());
			weight = Integer.parseInt(stt.nextToken());
			
			edgeList[i] = new Edge(from, to, weight);
			
		}
		
		Arrays.sort(edgeList);
		
		make();
		
		int cnt = 0 , result = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt == V-1) break;
			}
		}
		System.out.println(result);
		
	}

	private static void make() {
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
		
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
