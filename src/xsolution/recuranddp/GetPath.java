package xsolution.recuranddp;

import java.util.ArrayList;
import java.util.List;

class GetPath {
    static List<Point> getPath(boolean[][] maze){
        List<Point> list = new ArrayList<>();
        getPath(maze, maze.length-1, maze.length-1, list);
        return list;
    }
    static boolean getPath(boolean[][] maze, int x, int y, List<Point> list){
        if(x < 0 || y < 0 || x >= maze.length || y >= maze.length || !maze[x][y]){
            return false;
        }
        boolean isEnd = (x ==0 && y ==0);
        if(isEnd || getPath(maze, x -1 , y, list) || getPath(maze, x, y-1, list)){
            list.add(new Point(x,y));
            return true;
        }
        return false;
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
