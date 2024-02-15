package main;

import java.util.*;
import java.text.DecimalFormat;

public class Graph {
    private Set<Node> nodes;
    private boolean directed;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    Graph(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }

    public void addNode(Node... n) {
        nodes.addAll(Arrays.asList(n));
    }

    public void addEdge(Node source, Node destination, double weight) {
        nodes.add(source);
        nodes.add(destination);

        addEdgeHelper(source, destination, weight);

        if (!directed && source != destination) {
            addEdgeHelper(destination, source, weight);
        }
    }

    public void addEdgeHelper(Node a, Node b, double weight) {
        for (Edge edge : a.edges) {
            if (edge.source == a && edge.destination == b) {
                edge.weight = weight;
                return;
            }
        }

        a.edges.add(new Edge(a, b, weight));
    }

    public void printEdges() {
        for (Node node : nodes) {
            LinkedList<Edge> edges = node.edges;

            if (edges.isEmpty()) {
                System.out.println("Node: " + node.name + " has no edges");
                continue;
            }

            System.out.println("Node: " + node.name + " has edges to: ");
            for (Edge edge : edges) {
                System.out.println(edge.destination.name + " with weight " + edge.weight);
            }

            System.out.println();
        }

    }

    public boolean hasEdge(Node source, Node destination) {
        LinkedList<Edge> edges = source.edges;
        for (Edge edge : edges) {
            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
    }

    public void resetNodesVisited() {
        for (Node node : nodes) {
            node.unvisit();
        }
    }

    public String shortestPath(Node start, Node end) {
        HashMap<Node, Node> changedAt = new HashMap<>();
        changedAt.put(start, null);

        HashMap<Node, Double> shortestPath = new HashMap<>();

        for (Node node : nodes) {
            if (node == start) {
                shortestPath.put(node, 0.0);
            } else {
                shortestPath.put(node, Double.POSITIVE_INFINITY);
            }
        }

        for (Edge edge : start.edges) {
            shortestPath.put(edge.destination, edge.weight);
            changedAt.put(edge.destination, start);
        }

        start.visit();

        while (true) {
            Node currentNode = closestReachableUnvisited(shortestPath);

            if (currentNode == null) {
                System.out.println("There isn't a path between " + start.name + " and " + end.name);
                return "There isn't a path between " + start.name + " and " + end.name;
            }

            if (currentNode == end) {
                System.out.println("The path with the smallest weight between " + start.name + " and " + end.name + " is:");

                Node child = end;
                String path = end.name;

                while (true) {
                    Node parent = changedAt.get(child);

                    if (parent == null) {
                        break;
                    }

                    path = parent.name + " -> " + path;
                    child = parent;
                }

                System.out.println(path);
                System.out.println("The path costs: " + shortestPath.get(end));
                System.out.printf(" The time it will take is: " + shortestPath.get(end) / 2 + " seconds");
                System.out.println();

                return path + "\n\n\n\t The path costs: " + df.format(shortestPath.get(end)) + ", The time it will take is: " + df.format(shortestPath.get(end) / 2) + " seconds";
            }

            currentNode.visit();

            for (Edge edge : currentNode.edges) {
                if (edge.destination.isVisited()) {
                    continue;
                }

                if (shortestPath.get(currentNode) + edge.weight < shortestPath.get(edge.destination)) {
                    shortestPath.put(edge.destination, shortestPath.get(currentNode) + edge.weight);
                    changedAt.put(edge.destination, currentNode);
                }
            }
        }
    }

    private Node closestReachableUnvisited(HashMap<Node, Double> shortestPathMap) {
        double shortestDistance = Double.POSITIVE_INFINITY;
        Node closestReachableNode = null;

        for (Node node : nodes) {
            if (node.isVisited()) {
                continue;
            }

            double currentDistance = shortestPathMap.get(node);

            if (currentDistance == Double.POSITIVE_INFINITY) {
                continue;
            }

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }

        return closestReachableNode;
    }
}
