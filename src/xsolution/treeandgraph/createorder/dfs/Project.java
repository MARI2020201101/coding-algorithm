package xsolution.treeandgraph.createorder.dfs;

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
        Stack<Project> projects = Graph.orderProject(graph.projects);
        while(! projects.isEmpty()){
            System.out.print(projects.pop()+ ",");
        }
    }
}
enum State {
    Visited, UnVisited;
}
class Project {
    String name;
    List<Project> childrens = new ArrayList<>();
    Map<String, Project> childrenMap = new HashMap<>();
    State state = State.UnVisited;

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
       return project;
    }

    public void setState(State state) {
        this.state = state;
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

    public static Stack<Project> orderProject(List<Project> projects){
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if(project.state == State.UnVisited){
                dfs(project, stack);
            }
        }
        return stack;
    }

    private static void dfs(Project project, Stack<Project> stack ) {
        project.setState(State.Visited);
        for (Project children : project.childrens) {
            if(children.state == State.UnVisited) {
                dfs(children, stack);
            }
        }
        stack.push(project);
    }
}
