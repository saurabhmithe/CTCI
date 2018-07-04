package TreesAndGraphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BuildOrder {

    public Stack<Node> sort(Graph graph) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> explored = new Stack<>();
        for (Node n : graph.getAllNodes()) {
            if (!visited.contains(n)) {
                explore(n, explored, visited);
            }
        }
        return explored;
    }

    public void explore(Node n, Stack<Node> explored, Set<Node> visited) {
        visited.add(n);
        for (Node node : n.getAdjacentNodes()) {
            if (!visited.contains(node)) {
                explore(node, explored, visited);
            }
        }
        explored.add(n);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.addAdjacentNode(c);
        b.addAdjacentNode(c);
        b.addAdjacentNode(e);
        c.addAdjacentNode(d);
        d.addAdjacentNode(f);
        e.addAdjacentNode(f);
        f.addAdjacentNode(g);

        graph.addAdjacencyList(a);
        graph.addAdjacencyList(b);
        graph.addAdjacencyList(c);
        graph.addAdjacencyList(d);
        graph.addAdjacencyList(e);
        graph.addAdjacencyList(f);
        graph.addAdjacencyList(g);

        BuildOrder buildOrder = new BuildOrder();
        Stack<Node> sorted = buildOrder.sort(graph);
        while (!sorted.isEmpty()) {
            System.out.println(sorted.pop().value);
        }
    }
}
