package basis.solution.skyline;

import java.util.Arrays;

class SkyLine {
    public static void main(String[] args) {
        Rectangle[] rectangles = {
                new Rectangle(0,3,1),
                new Rectangle(1,6,3),
                new Rectangle(4,8,4),
                new Rectangle(5,9,2),
                new Rectangle(7,14,3),
                new Rectangle(10,12,6),
                new Rectangle(11,16,2),
                new Rectangle(13,17,1),
        };
        System.out.println(Arrays.toString(solve(rectangles)));
    }
    static int[] solve(Rectangle[] rectangles){
        int minLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE;
        for (int i = 0; i < rectangles.length; i++) {
            minLeft = Math.min(minLeft, rectangles[i].left);
            maxRight = Math.max(maxRight, rectangles[i].right);
        }
        int[] skyline = new int[maxRight+1];
        for (int i = 0; i < skyline.length; i++) {
            skyline[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = rectangles[i].left; j <= rectangles[i].right; j++) {
                skyline[j] = Math.max(skyline[j], rectangles[i].height);
            }
        }

        return skyline;
    }
}
class Rectangle {
    int left;
    int right;
    int height;

    public Rectangle(int left, int right, int height) {
        this.left = left;
        this.right = right;
        this.height = height;
    }
}