package thisiscodingtest.dfsbfs;

class CountIce2 {
    public static void main(String[] args) {
        int[][] iceTray = {
                {0,0,0,0,0,1,1,1,1,0,0,0,0,0},
                {1,1,1,1,1,1,0,1,1,1,1,1,1,0},
                {1,1,0,1,1,1,0,1,1,0,1,1,1,0},
                {1,1,0,1,1,1,0,1,1,0,0,0,0,0},
                {1,1,0,1,1,1,1,1,1,1,1,1,1,1},
                {1,1,0,1,1,1,1,1,1,1,1,1,0,0},
                {1,1,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,1,1,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,1,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,0,0,1,1},
                {1,1,1,0,0,0,1,1,1,1,1,1,1,1},
                {1,1,1,0,0,0,1,1,1,1,1,1,1,1},
        };
        System.out.println(count(iceTray));
    }
    static int[] nx = {-1,0,1,0};
    static int[] ny = {0,1,0,-1};
    static int count(int[][] iceTray){
        int count = 0;
        for (int x = 0; x < iceTray.length; x++) {
            for (int y = 0; y < iceTray[0].length; y++) {
                if(iceTray[x][y] == 0){
                    for (int i = 0; i < nx.length; i++) {
                        int nextX = x + nx[i];
                        int nextY = y + ny[i];

                        if(canMove(iceTray, x, y, nextX, nextY)){
                            iceTray[x][y] = -1;
                            count(iceTray, nextX, nextY);
                        }
                    }
                    count++;
                }

            }
        }
        return count;
    }

    private static boolean canMove(int[][] iceTray, int x, int y, int nextX, int nextY) {
        return nextX >= 0 && nextX < iceTray.length && nextY>=0 && nextY < iceTray[0].length
                 && iceTray[nextX][nextY] == 0;
    }

    private static boolean count(int[][] iceTray, int x, int y) {
        iceTray[x][y] = -1;
        for (int i = 0; i < nx.length; i++) {
            int nextX = x + nx[i];
            int nextY = y + ny[i];

            if(canMove(iceTray, x, y, nextX, nextY)){
                count(iceTray, nextX, nextY);
            }
        }
        return true;
    }
}
