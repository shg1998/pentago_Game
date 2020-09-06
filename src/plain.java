import java.util.Scanner;

public class plain {
    private corners c1;
    private corners c2;
    private corners c3;
    private corners c4;
    private Coordinates[][] plain1;

    public plain() {

        c1 = new corners(Coordinates.corners.C1);
        c2 = new corners(Coordinates.corners.C2);
        c3 = new corners(Coordinates.corners.C3);
        c4 = new corners(Coordinates.corners.C4);

        plain1 = new Coordinates[6][6];

        for (int i = 0; i < c1.getSize(); i++) {
            for (int j = 0; j < c1.getSize(); j++) {
                c1.setCoord(new Coordinates(i, j, Coordinates.corners.C1));
            }
        }
        start();
    }
    public void setCornersCoordinate(Coordinates c) {
        if (c.getCorners() == c1.getCorner()) {
            c1.setCoord(c);
        } else if (c.getCorners() == c2.getCorner()) {
            c2.setCoord(c);
        } else if (c.getCorners() == c3.getCorner()) {
            c3.setCoord(c);
        } else if (c.getCorners() == c4.getCorner()) {
            c4.setCoord(c);
        }
    }
    public Coordinates getCornersCoordinate(Coordinates c) {
        if (c.getCorners() == c1.getCorner()) {
            return c1.getCoord(c);
        } else if (c.getCorners() == c2.getCorner()) {
            return c2.getCoord(c);
        } else if (c.getCorners() == c3.getCorner()) {
            return c3.getCoord(c);
        } else if (c.getCorners() == c4.getCorner()) {
            return c4.getCoord(c);
        }
        return null;
    }
    public void rotation(Coordinates.corners corner) {

        if (corner == c1.getCorner()) {
            rotation2(c1);
        } else if (corner == c2.getCorner()) {
            rotation2(c2);
        } else if (corner == c3.getCorner()) {
            rotation2(c3);
        } else if (corner == c4.getCorner()) {
            rotation2(c4);
        } else {
            return;
        }
    }


    public void rotation2(corners c) {

        Scanner scanner = new Scanner(System.in);
        System.err.println("Do you want to rotate this quarter? enter y for yes and n for no");
        String in = scanner.next();

        if (in.equalsIgnoreCase("y")) {
            System.out.println("please enter how rotate? 1 for rotate counterClockwise and 2 for clockWise ");
            int which=scanner.nextInt();
            if (which==1) {
                c.CounterClockwise();
            } else if (which==2) {
                c.ClockWise();
            }
        }else if (in.equalsIgnoreCase("n")) {

            } else {
                System.out.println("invalid input! try again");
                rotation2(c);
                return;
            }

    }

    public void start() {

        for (int i = 0; i < c1.getSize(); i++) {
            for (int j = 0; j < c1.getSize(); j++) {
                plain1[i][j] = c1.getCoord(i, j);
            }
        }

        for (int i = 0; i < c2.getSize(); i++) {
            for (int j = 0; j < c2.getSize(); j++) {
                plain1[i][j + 3] = c2.getCoord(i, j);
            }
        }

        for (int i = 0; i < c3.getSize(); i++) {
            for (int j = 0; j < c3.getSize(); j++) {
                plain1[i + 3][j] = c3.getCoord(i, j);
            }
        }

        for (int i = 0; i < c4.getSize(); i++) {
            for (int j = 0; j < c4.getSize(); j++) {
                plain1[i + 3][j + 3] = c4.getCoord(i, j);
            }
        }
        System.err.println(toString());
    }





    public boolean isWinner(player p) {
        int counter = 0;
        Coordinates.CoordinateT color = p.getColor();


        for (int i = 0; i < plain1.length; i++) {
            counter = 0;
            for (int j = 0; j < plain1.length; j++) {
                if (plain1[i][j].getCoordinate() == color) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 5) {
                    return true;
                }
            }
        }
        for (int i = 0; i < plain1.length; i++) {
            counter = 0;
            for (int j = 0; j < plain1.length; j++) {
                if (plain1[j][i].getCoordinate() == color) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == 5) {
                    return true;
                }
            }
        }


        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 2; j++) {
                counter = 0;
                for (int i = 0; i < plain1.length - 1 - k; i++) {
                    if (!(plain1[i + k][i + j + k].isEmpty())) {
                        if (plain1[i + k][i + j + k].getCoordinate() == color) {
                            counter++;
                        }
                    }
                }
                if (counter == 5) {
                    return true;
                }
            }
        }

       
        for (int k = 0; k < 2; k++) {
            for (int j = 0; j < 2; j++) {
                counter = 0;
                for (int i = 0; i < plain1.length - 1; i++) {
                    if (!(plain1[(4 - i) + k][i + j].isEmpty())) {
                        if (plain1[(4 - i) + k][i + j].getCoordinate() == color) {
                            counter++;
                        }
                    }
                }
                if (counter == 5) {
                    return true;
                }
            }
        }


        return false;
    }

    public String toString() {
        String d = "";
        for (int i = 0; i < plain1.length; i++) {
            for (int j = 0; j < plain1.length; j++) {
                if (plain1[i][j].getCoordinate() == Coordinates.CoordinateT.BLACK) {
                    d += "B ";
                } else if (plain1[i][j].getCoordinate() == Coordinates.CoordinateT.RED) {
                    d += "R ";
                } else if (plain1[i][j].getCoordinate() == Coordinates.CoordinateT.EMPTY) {
                    d += "O ";
                }
            }
            d += '\n';
        }
        return d;
    }
}
