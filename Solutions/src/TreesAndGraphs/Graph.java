package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    int size;
    List<Node> nodes;

    public Graph(int size) {
        this.size = size;
        nodes = new ArrayList<>();
    }

    public void addAdjacencyList(Node node) {
        nodes.add(node);
    }

    public List<Node> getAllNodes() {
        return nodes;
    }

    public int size() {
        return nodes.size();
    }

}

class Node {

    public int value;
    LinkedList<Node> adjacentNodes;
    public State state;

    public Node(int value) {
        this.value = value;
        adjacentNodes = new LinkedList<>();
    }

    public LinkedList<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void addAdjacentNode(Node n) {
        adjacentNodes.addLast(n);
    }

}
