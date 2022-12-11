package ds.graph.dijkstra;

import java.util.*;

class Dijkstra {
    static int N = 5;
    static int M = 8;
    static int INF = Integer.MAX_VALUE;
    static List<Edge>[] route = new ArrayList[N+1];
    static int[] distance = new int[N+1];
    static void init(List<Edge>[] route, int[] distance){
        for (int i = 0; i < route.length; i++) {
            route[i] = new ArrayList<>();
        }
        route[1].add(new Edge(2,2));
        route[1].add(new Edge(3,3));
        route[1].add(new Edge(4,1));
        route[1].add(new Edge(5,10));
        route[2].add(new Edge(4,2));
        route[3].add(new Edge(4,1));
        route[3].add(new Edge(5,1));
        route[4].add(new Edge(5,3));

        for (int i = 0; i < distance.length; i++) {
            distance[i] = INF;
        }
    }

    public static void main(String[] args) {
        init(route,distance);
        solve(1, route, distance);
        System.out.println(Arrays.toString(distance));
    }
    static void solve(int start, List<Edge>[] route, int[] distance){
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1,0));
        distance[1] = 0;
        while(! queue.isEmpty()){
            Edge node = queue.poll();
            int idx = node.to;
            for(Edge next : route[idx]){
                queue.add(new Edge(next.to, next.cost + node.cost));
                distance[next.to] = Math.min(distance[next.to],next.cost + node.cost );
            }
        }
    }


}
class Edge implements Comparable<Edge>{
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return o.cost - this.cost;
    }
}