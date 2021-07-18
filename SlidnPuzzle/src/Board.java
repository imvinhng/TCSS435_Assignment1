import java.util.Arrays;

/**
 *Source code that models an n-by-n board with sliding tiles.
 * Your heuristic function resides in this file.
 *
 * @author vnguye3
 * @version 1.0
 */

public class Board {
    /** accept either 2,3, or 4. */
    private static int size;

    /** must characters, digits 1-9, letters A-F(only for size 4). */
    private static String initialState;

    /** can be BFS, DFS, GBFS, AStar. */
    private static String searchMethod;

    private static int inversions;

    private static int rowWithBlank;

    private static String[] rowMajor;

    private static String[][] myBoard;

    public Board(String theArg, String theArg1) {
        size = Integer.parseInt(theArg);
        initialState = theArg1;
        run();
    }

    public static void run() {

        // create board n-by-n with sliding tiles
        myBoard = new String[size][size];
        int index = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                myBoard[i][j] = Character.toString(initialState.charAt(index++));
            }
        }

        System.out.println(Arrays.deepToString(myBoard));

        // figure out row-major order
        rowMajor = calcRowMajor();
        System.out.println("Row Major Order: " + Arrays.deepToString(rowMajor));

        // count inversions
        // any pair (i,j) where i < j but i appears before j in row-major order
        System.out.print("Inversion: ");
        inversions = calcInversion();


        rowWithBlank = calcRowWithBlank();
        System.out.println("Row with Blank: " + rowWithBlank);

        // if n is odd
        if (size % 2 == 1) {
            if (inversions % 2 == 1) {
                System.out.println("Board is unsolvable");
            } else {
                System.out.println("Board is solvable");
            }
        // if n is even
        } else {
            if ((inversions + rowWithBlank) % 2 == 1) {
                System.out.println("Board is solvable");
            } else {
                System.out.println("Board is unsolvable");
            }
        }




    }

    /**
     * Utility method to calculate row major of the board.
     * @return rMajor
     */
    private static String[] calcRowMajor() {
        String[] rMajor = new String[initialState.length()];

        for (int i = 0; i < initialState.length(); i++) {
            rMajor[i] = Character.toString(initialState.charAt(i));
        }

        return rMajor;
    }

    /**
     * Utility method to help calculate inversions.
     * @return invers
     */
    private static int calcInversion() {
        int invers = 0;
        for (int i = 0; i < rowMajor.length; i++) {
            for (int j = 0; j < rowMajor.length; j++) {
                if (rowMajor[i].compareTo(rowMajor[j]) > 0
                        && !rowMajor[i].equals(" ")
                        && !rowMajor[j].equals(" ")
                        && i < j) {
                    System.out.print(rowMajor[i] + "-" + rowMajor[j] + " ");
                    invers += 1;
                }
            }
        }
        System.out.println();

        return invers;
    }

    /**
     * Utility method to help find row with blank.
     * @return
     */
    private static int calcRowWithBlank() {
        int target = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (myBoard[i][j].equals(" ")) {
                    target = i;
                }
            }
        }

        return target;
    }








}
