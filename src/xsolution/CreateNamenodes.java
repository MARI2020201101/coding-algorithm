package xsolution;

import java.util.*;

class CreateNamenodes {
}
class Graph{
    Map<String, NameNode> nodeMap = new HashMap<>();

    public void initNodes(Map<String, Integer> map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String name = entry.getKey();
            Integer frequency = entry.getValue();
            NameNode nameNode = new NameNode(name, frequency);
            nodeMap.put(name, nameNode);
        }
    }
    public void initEdges(String[][] equips){
        for (int i = 0; i < equips[0].length; i++) {
            String name1 = equips[0][i];
            String name2 = equips[1][i];
            NameNode nameNode1 = nodeMap.get(name1);
            NameNode nameNode2 = nodeMap.get(name2);
            nameNode1.addNeighbor(nameNode2);
            nameNode2.addNeighbor(nameNode1);

        }
    }
    public Map<String, NameNode> updateNodeMap(){
        Set<Map.Entry<String, NameNode>> entries = nodeMap.entrySet();
        for (Map.Entry<String, NameNode> entry : entries) {
            NameNode node = entry.getValue();
            if(! node.visited){
                __dfs(node);
            }
        }
        return nodeMap;
    }

    private int __dfs(NameNode node) {
        int frequency = node.frequency;
        if(! node.visited){
            node.visited = true;
            for (NameNode adjacent : node.adjacents) {
                frequency+=__dfs(adjacent);
            }
        }else{
            return 0;
        }
        return frequency;
    }
}
class NameNode{
    String name;
    List<NameNode> adjacents = new ArrayList<>();
    HashMap<String , NameNode> map = new HashMap<>();
    boolean visited = false;
    int frequency = 0;

    public NameNode(String name, Integer frequency){
        this.name = name;
        this.frequency = frequency;
    }

    public void addNeighbor(NameNode neighbor){
        this.adjacents.add(neighbor);
        map.put(neighbor.name, neighbor);
    }
}