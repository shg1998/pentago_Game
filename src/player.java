import java.util.Scanner;

public class player {
    private final Coordinates.CoordinateT color;

    public player(Coordinates.CoordinateT loc) {
        this.color = loc;
    }
    public Coordinates play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which quarter do want to play in? (c1 for up and left), " + "( c2 for up and right), " + "(c3 for down and left), or " + "(c4 for down and right");
        String inp = scanner.next();

        if (Coordinates.corners.fs(inp) != Coordinates.corners.ERROR){
            return chooseCoordinate(Coordinates.corners.fs(inp));
        }
        else {
            System.out.println("invalid input! try again!!");
            return play();
        }
    }
    public Coordinates chooseCoordinate(Coordinates.corners corner){
        Scanner scannerr = new Scanner(System.in);
        System.out.println("Which coordinate do want to play in? (pair number between 0 and 2) like 1 1");

        int x = -1;

        if (scannerr.hasNextInt()){
            x = scannerr.nextInt();
        }
        if(!((x >= 0 && x <= 2))){
            System.out.println("invalid x coordinate! please try again");
            return play();
        }

        int y = -1;

        if (scannerr.hasNextInt()){
            y = scannerr.nextInt();
        }
        if(!((y >= 0 && y <= 2))){
            System.out.println("invalid y coordinate! please try again");
            return play();
        }

        if (x >= 0 && y >= 0){
            Coordinates newC = new Coordinates(x, y, corner);
            newC.color(color);
            return newC;
        }

        return play();
    }

    public Coordinates.CoordinateT getColor(){
        return color;
    }
}
