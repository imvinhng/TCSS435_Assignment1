/**
 * Source code that implements BFS, DFS, GBFS, AStar to solve n-by-n sliding puzzle.
 *
 * @author vnguye3
 * @version 1.0
 */
public class Solver {
    private static String searchMethod;

    private static Board myBoard;

    public Solver(Board theBoard, String theArg) {
        myBoard = theBoard;
        searchMethod = theArg;
        run();
    }

    public static void run() {
        System.out.println("The program will run using " + searchMethod + " method");

        // BFS alg
        if (searchMethod.equals("BFS")) {

        }

        // DFS
        if (searchMethod.equals("DFS")) {

        }

        // GBFS
        if (searchMethod.equals("GBFS")) {

        }

        // AStar
        if (searchMethod.equals("AStar")) {

        }

    }

}
