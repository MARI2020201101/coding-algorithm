package xsolution.treeandgraph.createorder;

import java.util.*;

class Demo{
    public static void main(String[] args) {
        Project[] projectArr = {
                new Project("a"),
                new Project("b"),
                new Project("c"),
                new Project("d"),
                new Project("e"),
                new Project("f"),
                new Project("g"),
                new Project("h"),
                new Project("i"),
        };
        String[][] dependencies = {
                {"i","d"},
                {"i","b"},
                {"i","f"},
                {"d","c"},
                {"b","e"},
                {"c","a"},
                {"a","h"},
                {"h","g"},
        };
        Graph graph = Graph.buildProjectMap(projectArr, dependencies);
        Project[] projects = Graph.orderProject(graph);
        System.out.println(Arrays.toString(projects));
    }
}

class Project {
    String name;
    List<Project> childrens = new ArrayList<>();
    Map<String, Project> childrenMap = new HashMap<>();
    int dependency = 0;

    @Override
    public String toString() {
        return "Project [" +
                "" + name +"] " ;
    }

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project addOrGetChild(Project project){
       if(childrenMap.containsKey(project.name)){
           return childrenMap.get(project.name);
        }

       childrens.add(project);
       childrenMap.put(project.name, project);
       project.addDependency();
       return project;
    }

    public void addDependency() {
        this.dependency++;
    }
    public void minusDependency() {
        this.dependency--;
    }
}
class Graph {
    List<Project> projects = new ArrayList<>();
    Map<String, Project> projectMap = new HashMap<>();

    public static Graph buildProjectMap(Project[] projectArr, String[][] dependencies){
        Graph graph = new Graph();

        for (int i = 0; i < projectArr.length; i++) {
            graph.projects.add(projectArr[i]);
            graph.projectMap.put(projectArr[i].name, projectArr[i]);
        }
        for (int i = 0; i < dependencies.length; i++) {
            String start = dependencies[i][0];
            String end = dependencies[i][1];
            graph.addEdge(graph.projectMap.get(start), graph.projectMap.get(end));
        }
        return graph;
    }
    public void addEdge(Project start , Project end){
        start.addOrGetChild(end);
    }

    public static Project[] orderProject(Graph graph){
        Project[] order = new Project[graph.projects.size()];

        int processed = 0;
        int orderIdx = 0;

        for (Project project : graph.projects) {
            if(project.dependency == 0){
                order[orderIdx++] = project;
                System.out.println(Arrays.toString(order));
            }
        }
        while(processed < order.length){
            Project project = order[processed];
            for (Project children : project.childrens) {
                children.minusDependency();

                if(children.dependency == 0){
                    order[orderIdx++] = children;
                }
            }
            processed++;
        }
        return order;
    }
}
