/**
 * A tester file that connects your Board and Solver code.
 *
 * @author vnguye3
 * @version 1.0
 */

public class Tester {
    public static void main(String[] theArgs) {

        // connect Board and Solver
        Board myBoard = new Board(theArgs[0],theArgs[1]);

        // output to console
        Solver mySolver = new Solver(myBoard, theArgs[2]);

        // output to Readme.txt
//        System.out.println(mySolver.toConsole());
//        System.out.println(mySolver.toReadme());


    }
}
