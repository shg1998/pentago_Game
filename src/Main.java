import java.util.Scanner;

public class Main {


    public static boolean p1Won;
    public static boolean p2Won;
    public static plain map;
    public static player P1;
    public static player P2;
    public static boolean isWinner;



    public Main() {
        map = new plain();
        while (true) {
            System.out.println("first player.please choose your nut's color: ");
            Scanner scanner = new Scanner(System.in);
            String col = scanner.next();
            if (Coordinates.CoordinateT.fromString(col) != Coordinates.CoordinateT.ERROR) {
                P1 = new player(Coordinates.CoordinateT.fromString(col));
                if (col.equalsIgnoreCase("BLACK")) {
                    P2 = new player(Coordinates.CoordinateT.BLACK);
                } else {
                    P2 = new player(Coordinates.CoordinateT.RED);
                }
                break;
            } else {
                System.err.println("Please choose one color between BLACK and RED");
            }

        }
    }

    public static void main(String[] args) {
        int counter=0;
        Main play = new Main();
        while(!isWinner){
            if (counter >= 36){
                System.out.println("finish... . Draw!");
                break;
            }
            if (counter%2 == 0){
                System.out.println("first player should continue");
                Coordinates inp = P1.play();
                if (map.getCornersCoordinate(inp).isEmpty()){
                    map.setCornersCoordinate(inp);
                }
                else {
                    System.out.println("Wow! That location is in use!!");
                    P1.play();
                }
                map.rotation(inp.getCorners());
                map.start();
            }
            else {
                System.out.println("second player should continue");
                Coordinates inp = P2.play();
                if (map.getCornersCoordinate(inp).isEmpty()){
                    map.setCornersCoordinate(inp);
                }
                else {
                    System.out.println("Wow! That location is in use!!");
                    P2.play();
                }
                map.rotation(inp.getCorners());
                map.start();
            }
            p1Won = map.isWinner(P1);
            p2Won = map.isWinner(P2);
            isWinner = p1Won || p2Won;

            if (p1Won && p2Won){
                System.out.println("draw!");
                break;
            }
            else if (p1Won){
                System.out.println("player one won");
                break;
            }
            else if (p2Won){
                System.out.println("player two won");
                break;
            }

            counter++;
        }
    }



}
