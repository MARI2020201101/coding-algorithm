package ds.binarytree.getroot;

import java.util.*;

class GetRoot {
    static int N = 7;
    static List<Integer>[] edges = new ArrayList[N+1];
    static boolean[] visited = new boolean[N+1];
    static int[] parent = new int[N+1];

    public static void main(String[] args) {
        solve();
        System.out.println(Arrays.toString(parent));
    }
    static void solve(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while(! queue.isEmpty()){
            Integer parentIdx = queue.poll();
            for (Integer child : edges[parentIdx]) {
                if(! visited[child]){
                    visited[child] = true;
                    parent[child] = parentIdx;
                    queue.add(child);
                }
            }

        }
    }
    static {
        for (int i = 1; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        edges[1].add(6);
        edges[1].add(4);
        edges[6].add(1);
        edges[4].add(1);
        edges[6].add(3);
        edges[3].add(6);
        edges[3].add(5);
        edges[5].add(3);
        edges[2].add(4);
        edges[4].add(2);
        edges[4].add(7);
        edges[7].add(4);

        parent[0] = -1;
        parent[1] = -1;
    }
}
