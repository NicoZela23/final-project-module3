import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraphTest {

    private Graph directedGraph;
    private Graph undirectedGraph;

    @BeforeEach
    public void setUp() {
        directedGraph = new Graph(true);
        undirectedGraph = new Graph(false);
    }

    @Test
    public void testAddEdgeDirected() {
        Node nodeA = new Node(1, "A");
        Node nodeB = new Node(2, "B");
        directedGraph.addNode(nodeA, nodeB);
        directedGraph.addEdge(nodeA, nodeB, 5.0);
        Assertions.assertTrue(directedGraph.hasEdge(nodeA, nodeB));
    }

    @Test
    public void testAddEdgeUndirected() {
        Node nodeA = new Node(1,"A");
        Node nodeB = new Node(2, "B");
        undirectedGraph.addNode(nodeA, nodeB);
        undirectedGraph.addEdge(nodeA, nodeB, 5.0);
        Assertions.assertTrue(undirectedGraph.hasEdge(nodeA, nodeB));
        Assertions.assertTrue(undirectedGraph.hasEdge(nodeB, nodeA));
    }

    @Test
    public void testShortestPath() {
        Node nodeA = new Node(1, "A");
        Node nodeB = new Node(2, "B");
        Node nodeC = new Node(3, "C");
        Node nodeD = new Node(4, "D");

        directedGraph.addNode(nodeA, nodeB, nodeC, nodeD);
        directedGraph.addEdge(nodeA, nodeB, 1.0);
        directedGraph.addEdge(nodeB, nodeC, 2.0);
        directedGraph.addEdge(nodeC, nodeD, 3.0);

        String shortestPath = directedGraph.shortestPath(nodeA, nodeD);
        Assertions.assertNotNull(shortestPath);
        System.out.println(shortestPath);
    }
}

