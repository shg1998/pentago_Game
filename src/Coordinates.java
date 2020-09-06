public class Coordinates {
    private CoordinateT color;
    private corners corner;
    private int x;
    private int y;


    public Coordinates(int x, int y, corners c) {
        this.color = CoordinateT.EMPTY;
        this.corner = c;
        this.x = x;
        this.y = y;
    }

    public enum corners {
        ERROR,
        C1,
        C2,
        C3,
        C4;

        public static corners fs(String string) {
            if (string.equalsIgnoreCase("c1")) {
                return C1;
            } else if (string.equalsIgnoreCase("c2")) {
                return C2;
            } else if (string.equalsIgnoreCase("c3")) {
                return C3;
            } else if (string.equalsIgnoreCase("c4")) {
                return C4;
            }
            return ERROR;
        }
    }

    public enum CoordinateT {
        ERROR,
        EMPTY,
        BLACK,
        RED;

        public static CoordinateT fromString(String str) {
            if (str.equalsIgnoreCase("BLACK")) return BLACK;
            else if (str.equalsIgnoreCase("WHITE")) return RED;
            else if (str.equalsIgnoreCase("EMPTY")) return EMPTY;
            return ERROR;
        }
    }

    public void color(CoordinateT color) {
        this.color = color;
    }

    public CoordinateT getCoordinate() {
        return this.color;
    }

    public boolean isEmpty() {
        return (this.color == CoordinateT.EMPTY);
    }

    public corners getCorners() {
        return this.corner;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
