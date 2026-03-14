package GraphTheory.Task1;

import java.util.*;

public class UndirectedGraph<T> implements Graph<T> {
    protected final Map<T, List<T>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (final var entry : adjacencyList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ");
            for (final var value : entry.getValue()) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean containsVertex(T v) {
        return adjacencyList.containsKey(v);
    }

    @Override
    public List<T> getAdjacency(T v) {
        return adjacencyList.get(v);
    }

    @Override
    public void addVertex(T v1, T v2) {
        adjacencyList.putIfAbsent(v1, new ArrayList<>());
        adjacencyList.putIfAbsent(v2, new ArrayList<>());
        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1);
    }

    @Override
    public void addVertex(T v1, T v2, boolean loop) {
        if (!loop)
            addVertex(v1, v2);
        adjacencyList.putIfAbsent(v1, new ArrayList<>());
        adjacencyList.get(v1).add(v2);
    }

    @Override
    public void removeVertex(T v) {
        if (!adjacencyList.containsKey(v))
            throw new IllegalArgumentException("Vertex " + v + " not found exception");
        adjacencyList.remove(v);
        for (final var entry : adjacencyList.entrySet()) {
            entry.getValue().remove(v);
        }
    }

    @Override
    public boolean containsLoop() {
        return adjacencyList.entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue().stream()
                        .anyMatch(v -> v.equals(entry.getKey())));
    }

    @Override
    public int countVertexLevels(T v) {
        if (!adjacencyList.containsKey(v))
            throw new IllegalArgumentException("Cannot found vertex " + v);
        int count = 0;
        for (final var vertex : adjacencyList.get(v)) {
            count += vertex.equals(v) ? 2 : 1;
        }
        return count;
    }

    @Override
    public int countEdges() {
        int count = 0;
        for (final var entry : adjacencyList.entrySet()) {
            count += countVertexLevels(entry.getKey());
        }
        return count / 2;
    }

    /**
     * simple graph: khong khuyen khong song song
     * multi graph: khong khuyen, co the co song song
     * pseudo graph: co the co khuyen, co the song song
     * @return
     */
    public GraphType getType() {
        for (final var entry : adjacencyList.entrySet()) {
            Set<T> set = new HashSet<>();
            for (final var vertex : entry.getValue()) {
                if (vertex.equals(entry.getKey()))
                    return GraphType.PSEUDO_GRAPH;
                if (!set.add(vertex))
                    return GraphType.MULTI_GRAPH;
            }
        }
        return GraphType.SIMPLE_GRAPH;
    }

    @Override
    public boolean isComplete() {
        int vertexesCount = adjacencyList.size();
        var keySet = adjacencyList.keySet();
        for (final var vertex : keySet) {
            if (vertexesCount > countVertexLevelWithoutLoop(vertex)) {
                return false;
            }
        }
        return true;
    }

    protected int countVertexLevelWithoutLoop(T v) {
        if (!adjacencyList.containsKey(v))
            throw new IllegalArgumentException("Cannot get vertex with " + v);
        int count = countVertexLevels(v);
        var list = adjacencyList.get(v);
        for (final var vertex : list) {
            if (vertex.equals(v))
                count -= 2;
        }
        return count;
    }

    @Override
    public boolean isBipartiteGraph() {
        Map<T, ColorMarker> colorMarkers = new HashMap<>();
        for (final var entry : adjacencyList.entrySet()) {
            colorMarkers.putIfAbsent(entry.getKey(), ColorMarker.RED);
            for (final var v : entry.getValue()) {
                colorMarkers.putIfAbsent(v, ColorMarker.BLUE);
                if (colorMarkers.get(entry.getKey()).equals(colorMarkers.get(v)))
                    return false;
            }
        }
        return true;
    }
}
