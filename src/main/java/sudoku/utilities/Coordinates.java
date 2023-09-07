package sudoku.utilities;

public class Coordinates {
    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(Integer x, Integer y) {
        if(x != null && y != null)
        {
            this.x = x.intValue();
            this.y = y.intValue();
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        Coordinates temp = (Coordinates)  obj;
        return (this.x == temp.x) &&
                (this.y == temp.y);
    }

    @Override
    public String toString() {
        return "{" + this.getX() + ", " + this.getY() + "}";
    }
}
