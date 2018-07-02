package TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {

    public void bfs(Graph graph) {
        if (graph.size() == 0) return;

        List<Node> allNodes = graph.getAllNodes();

        for (Node node : allNodes) {
            node.state = State.UNVISITED;
        }

        LinkedList<Node> q = new LinkedList<>();
        Node start = graph.getAllNodes().get(0);
        start.state = State.VISITING;
        q.addFirst(start);

        while (!q.isEmpty()) {
            Node n = q.removeLast();
            n.state = State.VISITING;
            System.out.println(n.value);
            LinkedList<Node> adj = n.getAdjacentNodes();
            for (Node adjNode : adj) {
                if (adjNode.state == State.UNVISITED) {
                    adjNode.state = State.VISITING;
                    q.addFirst(adjNode);
                }
            }
            n.state = State.VISITED;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        graph.addAdjacencyList(one);
        graph.addAdjacencyList(two);
        graph.addAdjacencyList(three);
        graph.addAdjacencyList(four);
        graph.addAdjacencyList(five);

        one.addAdjacentNode(two);
        two.addAdjacentNode(one);
        one.addAdjacentNode(three);
        three.addAdjacentNode(one);

        two.addAdjacentNode(three);
        three.addAdjacentNode(two);
        two.addAdjacentNode(four);
        four.addAdjacentNode(two);

        three.addAdjacentNode(four);
        four.addAdjacentNode(three);
        three.addAdjacentNode(five);
        five.addAdjacentNode(three);

        four.addAdjacentNode(one);
        one.addAdjacentNode(four);
        four.addAdjacentNode(five);
        five.addAdjacentNode(four);

        BreadthFirstSearch breadthfirstSearch = new BreadthFirstSearch();
        breadthfirstSearch.bfs(graph);
    }
}
