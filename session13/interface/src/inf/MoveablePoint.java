package inf;

public class MoveablePoint  implements  Movable,Hi{
    private int x,y;

    public MoveablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveDown() {
      y--;
    }

    @Override
    public void moveLeft() {
       x--;
    }

    @Override
    public void moveRight() {
       x++;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public void print() {

    }
}
