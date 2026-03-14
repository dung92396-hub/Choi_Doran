package GraphTheory.Task1;

public class Main {
    public static void main(String[] args) {
        // init new undirected graph
        Graph<Integer> graph = new UndirectedGraph<>();
        graph.addVertex(1, 1, true);
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
        graph.addVertex(1, 4);
        graph.addVertex(2, 3);
        graph.addVertex(2, 4);
        graph.addVertex(3, 4);
        System.out.println(graph);

        // check loop has contains int graph
        System.out.println("Check contains loop");
        System.out.println(graph.containsLoop());

        // count vertext levels
        System.out.println("Count vertex levels:");
        System.out.println(graph.countVertexLevels(1));
        System.out.println(graph.countVertexLevels(2));
        System.out.println(graph.countVertexLevels(3));
        System.out.println(graph.countVertexLevels(4));

        // count edges
        System.out.println("Total of edges:");
        System.out.println(graph.countEdges());

        // is complete graph
        System.out.println("Completed graph: " + graph.isComplete());

        // remove vertex
        System.out.println("After remove vertex 3");
        graph.removeVertex(3);
        System.out.println(graph);
    }
}
