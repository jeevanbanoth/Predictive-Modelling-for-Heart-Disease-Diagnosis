public class AllPairsShortestPath {

    public static void main(String[] args) {
        int V = 7; // Number of vertices
        double INF = Double.POSITIVE_INFINITY; // Infinity value for absent edges

        // Initialize the adjacency matrix or edge weights.
        double[][] graph = {
            {0, 5, 3, 2, INF, INF, INF},
            {5, 0, 2, INF, 3, INF, 1},
            {3, 2, 0, 7, 7, INF, INF},
            {2, INF, 7, 0, 2, 6, INF},
            {INF, 3, 7, 2, 0, 1, 1},
            {INF, INF, INF, 6, 1, 0, INF},
            {INF, 1, INF, INF, 1, INF, 0}
        };

        double[][] result = shortestPath(graph, V);

        // Print the result
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (result[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("INF ");
                } else {
                    System.out.printf("%.2f ", result[i][j]);
                }
            }
            System.out.println();
        }
    }

    static double[][] shortestPath(double[][] graph, int V) {
        double[][] distance = new double[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                distance[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        return distance;
    }
}
