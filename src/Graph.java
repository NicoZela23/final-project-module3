import java.util.*;
import java.text.DecimalFormat;

public class Graph {
    private final Set<Node> nodes;
    private final boolean directed;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Graph(boolean directed) {
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

    public boolean hasEdge(Node source, Node destination) {
        LinkedList<Edge> edges = source.edges;
        for (Edge edge : edges) {
            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
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
                StringBuilder path = new StringBuilder(end.name);

                while (true) {
                    Node parent = changedAt.get(child);

                    if (parent == null) {
                        break;
                    }

                    path.insert(0, parent.name + " -> ");
                    child = parent;
                }

                System.out.println(path);
                System.out.println("The path costs: " + shortestPath.get(end));
                System.out.println("The time it will take is: " + shortestPath.get(end) / 2.6 + " hours");
                System.out.println();

                double totalTimeInHours = shortestPath.get(end)/3.2;
                int hours = (int) totalTimeInHours;
                int minutes = (int) ((totalTimeInHours - hours) * 60);
                int seconds = (int) (((totalTimeInHours - hours) * 60 - minutes) * 60);

                return path + "\nThe approximate distance is: " + df.format(shortestPath.get(end) * 14.5) + " Km. The time it will take is: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
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
