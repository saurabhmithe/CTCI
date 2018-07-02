package TreesAndGraphs;

import java.util.LinkedList;

public class RouteBetweenNodes {

    /*

    Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

    */

    public boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        for (Node node : g.getAllNodes()) node.state = State.UNVISITED;

        LinkedList<Node> q = new LinkedList<>();
        start.state = State.VISITING;
        q.addFirst(start);

        while (!q.isEmpty()) {
            Node node = q.removeLast();
            LinkedList<Node> adjNodes = node.getAdjacentNodes();
            for (Node adj : adjNodes) {
                if (adj == end) return true;
                else if (adj.state == State.UNVISITED) {
                    adj.state = State.VISITING;
                    q.addFirst(adj);
                }
            }
            node.state = State.VISITED;
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.addAdjacentNode(b);
        b.addAdjacentNode(c);
        c.addAdjacentNode(d);
        graph.addAdjacencyList(a);
        graph.addAdjacencyList(b);
        graph.addAdjacencyList(c);
        graph.addAdjacencyList(d);
        graph.addAdjacencyList(e);

        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        boolean res = routeBetweenNodes.search(graph, a, e);
        System.out.println(res);
    }
}

