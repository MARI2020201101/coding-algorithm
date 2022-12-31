package xsolution.recuranddp;

import java.util.*;

class CreateNamenodes {
    public static void main(String[] args) {
        Map<String , Integer> map = new HashMap<>();
        map.put("John", 10);
        map.put("Jon", 3);
        map.put("Davis", 2);
        map.put("Kari", 3);
        map.put("Johnny",11);
        map.put("Carlton", 8);
        map.put("Carleton", 2);
        map.put("Jonathan", 9);
        map.put("Carrie", 5);

        String[][] equipNames = {
                {"Jonathan","John"},
                {"Jon","Johnny"},
                {"Johnny","John"},
                {"Kari","Cari"},
                {"Carleton","Carlton"},
        };
        Graph graph = new Graph();
        graph.initNodes(map);
        graph.initEdges(equipNames);
        Map<String, NameNode> integratedNodeMap = graph.updateNodeMap();
        integratedNodeMap.forEach((k,v)-> System.out.println(k + " : " + v));
    }
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
                node.frequency=__dfs(node);
            }
        }
        return nodeMap;
    }

    private int __dfs(NameNode node) {
        int frequency = node.frequency;
        if(! node.visited){
            node.visited = true;
            for (NameNode adjacent : node.adjacents) {
                adjacent.names.add(node.name);
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
    Set<String> names = new HashSet<>();
    HashMap<String , NameNode> map = new HashMap<>();
    boolean visited = false;
    int frequency = 0;

    public NameNode(String name, Integer frequency){
        this.name = name;
        this.frequency = frequency;
        this.names.add(name);
    }

    @Override
    public String toString() {
        return "NameNode{" +
                "name='" + name + '\'' +
                ", names=" + names +
                ", frequency=" + frequency +
                '}';
    }

    public void addNeighbor(NameNode neighbor){
        this.adjacents.add(neighbor);
        names.add(neighbor.name);
        map.put(neighbor.name, neighbor);
    }
}