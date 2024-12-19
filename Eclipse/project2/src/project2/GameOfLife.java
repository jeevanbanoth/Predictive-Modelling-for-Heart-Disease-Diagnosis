package project2;
public class GameOfLife implements GameInterface {
    private boolean[][] originalMap,    // The initial cell configuration
                                map,    // The current cell configuration
                             newMap;    // The next generation configuration
    private GameGUI gui;
    private int generation = 0;
    private FileIO fileIO;

    // GameOfLife constructor
    public GameOfLife() {
        originalMap = new boolean[MAX_ROWS][MAX_COLS];
        map = new boolean[MAX_ROWS][MAX_COLS];
        newMap = new boolean[MAX_ROWS][MAX_COLS];
        gui = new GameGUI(this, map);
        gui.setTitle("CIS 181 Array Based Game Of Life");
        fileIO = new FileIO("life", "Game of Life Text Files");
        readExample(2);
    }

    //  ====>>>>> Complete the methods below this line! <<<<<====

    // copyMap:
    // Precondtions: None.
    // Postcondtion: 'map' is a deep copy of 'sourceMap'.
    
        private void copyMap(boolean sourceMap[][]) {
            for (int i = 0; i < sourceMap.length; i++) {
                for (int j = 0; j < sourceMap[0].length; j++) {
                    map[i][j] = sourceMap[i][j];
                }
            }
        }

        private void clearMap(boolean targetMap[][]) {
            for (int i = 0; i < targetMap.length; i++) {
                for (int j = 0; j < targetMap[0].length; j++) {
                    targetMap[i][j] = DEAD;
                }
            }
        }

        private int getFlatNeighborCount(int row, int col) {
            int count = 0;
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < map.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < map[0].length && (i != row || j != col) && map[i][j]) {
                            count++;
                        }
                    }
                }
            }
            return count;
        }
        private void swapMaps() {
            boolean[][] temp = map;
            map = newMap;
            newMap = temp;
        }

        public void nextGenerationForFlatGrid() {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    int neighbors = getFlatNeighborCount(i, j);
                    boolean currentState = map[i][j];
                    if (currentState) {
                        newMap[i][j] = !(neighbors <= SURV_NBR_COUNTS_2 || neighbors >= SURV_NBR_COUNTS_3);
                    } else {
                        newMap[i][j] = neighbors == BIRTH_NBR_COUNTS;
                    }
                }
            }
            swapMaps();
            generation++;
        }

    // ==> 5. Implement the game of life for torus grid.

 // nextGenerationForTorusGrid:
 // Preconditions: None.
 // Postconditions: The next generation of live and dead cells is calculated for the torus grid,
 // considering the wrap-around behavior at the edges. The current 'map' is updated to the
 // next generation's configuration of live and dead cells.
 public void nextGenerationForTorusGrid() {
     boolean[][] tempMap = new boolean[MAX_ROWS][MAX_COLS];

        for (int row = 0; row < MAX_ROWS; row++) {
            for (int col = 0; col < MAX_COLS; col++) {
                int neighbors = getTorusNeighborCount(row, col);
                boolean currentState = map[row][col];

                if (currentState) {
                    tempMap[row][col] = !(neighbors <= SURV_NBR_COUNTS_2 || neighbors >= SURV_NBR_COUNTS_3);
                } else {
                    tempMap[row][col] = neighbors == BIRTH_NBR_COUNTS;
                }
            }
        }

        // Update the 'map' with the new generation
        for (int row = 0; row < MAX_ROWS; row++) {
            for (int col = 0; col < MAX_COLS; col++) {
                map[row][col] = tempMap[row][col];
            }
        }

        generation++;
    }

 // Helper method to get the count of live neighbors in a torus grid
 private int getTorusNeighborCount(int row, int col) {
     int count = 0;
     int numRows = map.length;
     int numCols = map[0].length;

     for (int i = row - 1; i <= row + 1; i++) {
         for (int j = col - 1; j <= col + 1; j++) {
             if (i == row && j == col) {
                 continue; // Skip the current cell
             }

             // Wrap around at the torus grid edges
             int torusRow = (i + numRows) % numRows;
             int torusCol = (j + numCols) % numCols;

             if (map[torusRow][torusCol]) {
                 count++;
             }
         }
     }
     return count;
 }





    //  ====>>>>> Don't touch the code below this line! <<<<<====

    // Return the next generation
    public int getGeneration() {
        return generation;
    }

    // Reset the map to the original map
    public void reset() {
        copyMap(originalMap);
        generation = 0;
        gui.repaint();
    }

    // Game of life examples 1-4: Fish, Plus, Glider, FlyingMachine
    public void readExample(int n) {
        System.out.println("Initializing with example " + n + " ...");
        clearMap(originalMap);

        switch (n) {
           case 1: // Example 1: Fish
             for (int col = 23; col <= 26; col++)
                 originalMap[13][col] = ALIVE;
             originalMap[14][22] = ALIVE;
             originalMap[14][26] = ALIVE;
             originalMap[15][26] = ALIVE;
             originalMap[16][22] = ALIVE;
             originalMap[16][25] = ALIVE;
             break;
           case 2: // Example 2: Plus
               for (int col = 6; col < 43; col++)
                 originalMap[24][col] = ALIVE;
             for (int row = 6; row < 43; row++)
                 originalMap[row][24] = ALIVE;
             break;
           case 3: // Example 3: Glider
                originalMap[14][23] = ALIVE;
             originalMap[15][24] = ALIVE;
             for (int row = 13; row <= 15; row++)
                 originalMap[row][25] = ALIVE;
             break;
           case 4: // Example 4: FlyingMachine
                for (int col = 22; col <= 25; col++) {
                 originalMap[11][col] = ALIVE;
                 originalMap[19][col] = ALIVE;
             }
             for (int row = 14; row <= 16; row++)
                 for (int col = 17; col <= 18; col++)
                     originalMap[row][col] = ALIVE;
             originalMap[15][19] = ALIVE;
             for (int row = 12; row <= 18; row = row+2)
                 originalMap[row][21] = ALIVE;
             originalMap[14][24] = ALIVE;
             originalMap[16][24] = ALIVE;
             originalMap[12][25] = ALIVE;
             originalMap[13][25] = ALIVE;
             originalMap[17][25] = ALIVE;
             originalMap[18][25] = ALIVE;
             break;
           default: // Default Example: ClearSpace
             break;
        }

        copyMap(originalMap);
        generation = 0;
        gui.repaint();
    }

    //  Read map from file
    public void readInMap() {
        clearMap(originalMap);
        if (fileIO.read(originalMap)) {
            copyMap(originalMap);
            generation = 0;
        } else
            readExample(2);
        gui.repaint();
    }

    // Write map to file
    public void writeMap() {
       fileIO.write(map);
    }

    // Change the state of a cell
    public void updateMap(int row, int col) {
        map[row][col] = !map[row][col];

    }

    // Destroy the GUI window
    public void destroy() {
        gui.dispose();
    }

    // The main method of GameOfLife
    public static void  main(String[] args) {
        GameOfLife game = new GameOfLife();
    }
}
