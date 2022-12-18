package xsolution.treeandgraph.hasways;

import java.util.ArrayList;
import java.util.List;

class Node {
    State state = State.Unvisited;
    List<Node> adjacents = new ArrayList<>();

    public List<Node> getAdjacents() {
        return adjacents;
    }
}
enum State {
    Unvisited, Visited, Visiting;
}