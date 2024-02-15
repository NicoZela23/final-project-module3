public class Edge implements Comparable<Edge>{

    Node source;
    Node destination;
    double weight;

    public Edge(Node source, Node destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String toString(){
        return String.format("%s--> %s, %f", source.name, destination.name, weight);
    }

    @Override
    public int compareTo(Edge E) {
        if (this.weight > E.weight){
            return 1;
        }
        else {
            return -1;
        }
    }
}
