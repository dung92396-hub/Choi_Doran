package GraphTheory.Task1.test;

import GraphTheory.Task1.DirectedGraph;
import GraphTheory.Task1.Graph;
import GraphTheory.Task1.UndirectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Directed Graph Test")
public class UndirectedGraphTest {

    private Graph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new UndirectedGraph<>();
        graph.addVertex(1, 2);
        graph.addVertex(1, 3);
    }

    @Test
    @DisplayName("Test adding new vertex")
    void testAddingNewVertex() {
        assertTrue(graph.containsVertex(1));
        assertTrue(graph.containsVertex(2));
        assertTrue(graph.containsVertex(3));
    }

    @Test
    @DisplayName("Test graph complete")
    void testComplete() {
        assertFalse(graph.isComplete());
    }

    @Test
    @DisplayName("Test bipartite graph")
    void testCountEdges() {
        Graph<Integer> graph = new DirectedGraph<>();
        graph.addVertex(1, 2);
        graph.addVertex(1, 5);
        graph.addVertex(2, 4);
        graph.addVertex(2, 3);
        graph.addVertex(3, 4);
        graph.addVertex(3, 5);
        graph.addVertex(4, 5);
        graph.addVertex(5, 1);
        graph.addVertex(5, 2);

        assertFalse(graph.isBipartiteGraph());
    }
}
