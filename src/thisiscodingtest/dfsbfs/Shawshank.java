package thisiscodingtest.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

class Shawshank {
    public static void main(String[] args) {
        int[][] maze = {
                {1,0,1,0,1,0},
                {1,1,1,1,1,1},
                {0,0,0,0,0,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1},
        };
        solve(maze, 0,0);
    }
    static int solve(int[][] maze, int startX, int startY){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, maze[startX][startY]));
        while(! queue.isEmpty()){
            Point node = queue.poll();
            if(node.x == maze.length-1 && node.y == maze[0].length-1){
                System.out.println(node.val);
            }

            if(canGo(maze, node.x, node.y, node.x+1, node.y)){
                queue.add(new Point(node.x+1 , node.y, node.val+1));
            }
            if(canGo(maze, node.x, node.y, node.x, node.y+1)){
                queue.add(new Point(node.x , node.y+1, node.val+1));
            }
        }
        return 0;
    }

    private static boolean canGo(int[][] maze, int x, int y, int nextX, int nextY) {
        return maze[x][y]==1 && nextX >= 0 && nextX < maze.length && nextY>=0 && nextY < maze[0].length &&
                maze[nextX][nextY]==1;
    }
}
class Point {
    int x;
    int y;
    int val;

    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", val=" + val +
                '}';
    }
}
