import java.util.*;

public class TopologicalSort {
    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        List<String> stack = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> visiting = new HashSet<>(); // To detect cycles

        for (String node : graph.keySet()) {
            if (!visited.contains(node)) {
                if (hasCycle(graph, node, visited, visiting, stack)) {
                    throw new RuntimeException("Cycle found in the graph. Topological sort not possible.");
                }
            }
        }

        Collections.reverse(stack);
        return stack;
    }

    public static boolean hasCycle(Map<String, List<String>> graph, String node, Set<String> visited, Set<String> visiting, List<String> stack) {
        visiting.add(node);

        for (String edge : graph.getOrDefault(node, Collections.emptyList())) {
            if (visiting.contains(edge)) {
                return true; // Cycle detected
            }
            if (!visited.contains(edge)) {
                if (hasCycle(graph, edge, visited, visiting, stack)) {
                    return true; // Propagate the cycle detection
                }
            }
        }

        visiting.remove(node);
        visited.add(node);
        stack.add(node);
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("S", Arrays.asList("A", "D", "G"));
        graph.put("A", Arrays.asList("B", "E"));
        graph.put("B", Collections.singletonList("C"));
        graph.put("C", Collections.singletonList("t"));
        graph.put("D", Arrays.asList("A", "E"));
        graph.put("E", Arrays.asList("C", "F", "I"));
        graph.put("F", Arrays.asList("C", "t"));
        graph.put("G", Arrays.asList("D", "E", "H"));
        graph.put("H", Arrays.asList("E", "I"));
        graph.put("I", Arrays.asList("F", "t"));
        graph.put("t", Collections.emptyList());

        try {
            List<String> topologicalOrder = topologicalSort(graph);

            System.out.println("Topological Ordering:");
            for (String node : topologicalOrder) {
                System.out.print(node + " ");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
