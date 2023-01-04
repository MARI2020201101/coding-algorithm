package thisiscodingtest.implementation;

class Game {
    public static void main(String[] args) {
        int[][] map = {
                {1,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {1,1,1,1},
        } ;
        int x = 1; int y = 1;
        System.out.println(move(x,y,map));
        print(map);
    }
    static int direction = 0;
    static int[] nx = {-1,0,1,0};
    static int[] ny = {0,1,0,-1};
    static int move(int x, int y , int[][] map){
        int turnCount = 0;
        int island = 1;
        while(true){
            int nextX = x + nx[direction];
            int nextY = y + ny[direction];
            direction = (direction+1) % nx.length;
            if(canMove(map, nextX, nextY)){//섬이다
                map[nextX][nextY] = -1; //방문표시
                x = nextX;
                y = nextY;
                turnCount = 0;
                island++;
                continue;
            }
            turnCount++;
            if(turnCount == 4){
                nextX = x - nx[direction];
                nextY = y - ny[direction];
                if(canMove(map, nextX, nextY)){
                    map[nextX][nextY] = -1;
                    x = nextX;
                    y = nextY;
                    turnCount = 0;
                    island++;
                }else break;
            }
        }
        return island;
    }

    private static boolean canMove(int[][] map, int nextX, int nextY) {
        return nextX >=0 && nextX >=0 && nextX < map.length && nextY < map[0].length && map[nextX][nextY] == 0;
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
