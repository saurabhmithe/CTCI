package TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

    public void dfs(Node node) {
        if (node == null) return;
        System.out.println(node.value);
        node.state = State.VISITED;
        LinkedList<Node> list = node.getAdjacentNodes();
        for (Node adjNode : list) {
            if (adjNode.state != State.VISITED) {
                dfs(adjNode);
            }
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

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(graph.getAllNodes().get(0));
    }
}
