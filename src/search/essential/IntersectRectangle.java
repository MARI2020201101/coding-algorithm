package search.essential;

class IntersectRectangle {
    static Rectangle intersectRectangle(Rectangle r1, Rectangle r2){
        if(!isIntersect(r1, r2)){
            return new Rectangle(0,0,-1,-1);
        }
        int x = Math.max(r1.x, r2.x);
        int y = Math.max(r1.y, r2.y);
        int width = Math.min(r1.x + r1.width, r2.x + r2.width) - x;
        int height = Math.min(r1.y + r1.height, r2.y + r2.height) - y;
        return new Rectangle(x,y,width,height);
    }

    private static boolean isIntersect(Rectangle r1, Rectangle r2) {
        return r1.x + r1.width >= r2.x && r1.x <= r2.x + r2.width
                && r1.y + r1.height >= r2.y && r1.y <= r2.y + r2.height;
    }
}
class Rectangle{
    int x;
    int y;
    int width;
    int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}