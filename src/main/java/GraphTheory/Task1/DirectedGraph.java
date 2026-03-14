package GraphTheory.Task1;


import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

public class DirectedGraph<T> extends UndirectedGraph<T> implements Graph<T> {

    @Override
    public void addVertex(T v1, T v2) {
        adjacencyList.putIfAbsent(v1, new ArrayList<>());
        adjacencyList.get(v1).add(v2);
    }

    @Override
    public void removeVertex(T v) {
        super.removeVertex(v);
    }

    @Override
    public boolean containsLoop() {
        return super.containsLoop();
    }

    public HalfLevelVertex countHalfLevelVertex(T v) {
        if (!adjacencyList.containsKey(v))
            throw new IllegalArgumentException();

        var adj = adjacencyList.get(v);
        int out = adj.size();
        int in = 0;

        // tinh nua bac trong cua dinh khuyen
        for (final var vertex : adjacencyList.get(v)) {
            if (vertex.equals(v)) in += 1;
        }

        // tinh nua bac trong cua cac dinh huong toi dinh hien tai
        for (final var entry : adjacencyList.entrySet()) {
            if (entry.getKey().equals(v))
                continue;
            for (final var vertex : entry.getValue()) {
                if (vertex.equals(v)) in += 1;
            }
        }

        return HalfLevelVertex.builder()
                .in(in)
                .out(out)
                .build();
    }

    @Override
    public GraphType getType() {
        return super.getType();
    }

    @Override
    public boolean isComplete() {
        return super.isComplete();
    }

    @Override
    public boolean isBipartiteGraph() {
        return super.isBipartiteGraph();
    }

    @Builder
    @Getter
    public static class HalfLevelVertex {
        private int in;
        private int out;
    }
}
