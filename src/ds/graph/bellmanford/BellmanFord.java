package ds.graph.bellmanford;

import java.util.Arrays;

class BellmanFord {
    static int city = 3;
    static int route = 4;
    static Edge[] edges = {
            new Edge(1,2,4),
            new Edge(1,3,3),
            new Edge(2,3,-4),
            new Edge(3,1,-2),
    };
    static int INF = Integer.MAX_VALUE;
    static int[] distance = new int[city+1];

    public static void main(String[] args) {
        init(distance);
        solve(1, edges, distance);
        System.out.println(Arrays.toString(distance));
    }
    static void init(int[] distance){
        for (int i = 0; i < distance.length; i++) {
            distance[i] = INF;
        }
    }
    static void solve(int start, Edge[] edges, int[] distance){
        int n = edges.length;

        distance[start] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < edges.length; j++) {
                if(distance[edges[j].from] != INF
                        && distance[edges[j].to] > distance[edges[j].from] + edges[j].cost){
                    distance[edges[j].to] = distance[edges[j].from] + edges[j].cost;

                    if(i == n) System.out.println("음의 사이클 존재!");
                }
            }
        }
    }
}
class Edge{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}