public class corners {
    private Coordinates[][] coord;
    private Coordinates.corners corner;

    public corners(Coordinates.corners c){
        this.coord = new Coordinates[3][3];
        this.corner = c;

        for (int i = 0; i < coord.length; i++){
            for (int j = 0; j < coord[0].length; j++){
                coord[i][j] = new Coordinates(i, j, corner);
            }
        }
    }

    //rotates 3x3 grid counterclockwise
    public void ClockWise(){
        Coordinates[][] tmp = new Coordinates[3][3];
        for (int i = 0; i < coord.length; i++){
            for (int j = 0; j < coord[0].length; j++){
                tmp[j][2-i] = coord[i][j];
            }
        }
        coord = tmp;
    }

    //rotates 3x3 grid clockwise
    public void CounterClockwise(){
        Coordinates[][] tmp = new Coordinates[3][3];
        for (int i = 0; i < coord.length; i++){
            for (int j = 0; j < coord[0].length; j++){
                tmp[2-j][i] = coord[i][j];
            }
        }
        coord = tmp;
    }

    public int getSize(){
        return coord.length;
    }

    public Coordinates getCoord(int x, int y){
        return coord[x][y];
    }
    public Coordinates getCoord(Coordinates c) { return coord[c.getX()][c.getY()]; }

    public void setCoord(Coordinates s){
        coord[s.getX()][s.getY()] = s;
        return;
    }

    public Coordinates.corners getCorner(){return corner; }
}
