package GraphTheory.Task1;

import java.util.List;

public interface Graph<T> {
    void addVertex(T v1, T v2);
    void addVertex(T v1, T v2, boolean loop);
    void removeVertex(T v);
    boolean containsLoop();
    int countVertexLevels(T v);
    int countEdges();
    boolean isComplete();
    boolean containsVertex(T v);
    List<T> getAdjacency(T v);
    boolean isBipartiteGraph();

    enum ColorMarker {
        RED, BLUE
    }
}
