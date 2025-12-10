package Graph;

import java.util.*;

public class Graph<E> {
    private final HashMap<E, ArrayList<E>> mapNode;


    public Graph() {
        this.mapNode = new HashMap<>();
    }

    public void addNode(E a, E b) {
        this.mapNode.putIfAbsent(a, new ArrayList<>());
        this.mapNode.putIfAbsent(b, new ArrayList<>());
        this.mapNode.get(a).add(b);
        this.mapNode.get(b).add(a);
    }

    public void removeNode(E a) {
        this.mapNode.remove(a);
        this.mapNode.forEach((key ,value) -> {
            value.removeIf(n -> n == a);
        });
    }

    public void display() {
        this.mapNode.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    public void dfs(E start) {
        HashSet<E> visited = new HashSet<>();
        Stack<E> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            E node = stack.pop();
            if (!visited.contains(node))
                visited.add(node);
            else
                continue;
            System.out.print(node + ", ");
            this.mapNode.forEach((key, value) -> {
                value.forEach(e -> {
                    if (!visited.contains(e))
                        stack.push(e);
                });
            });
        }
    }

    public static void main(String[] args) {
        Graph<Character> graph = new Graph<Character>();
        graph.addNode('E', 'D');
        graph.addNode('E', 'C');
        graph.addNode('E', 'B');
        graph.addNode('B', 'C');
        graph.addNode('D', 'C');
        graph.dfs('E');
    }
}
