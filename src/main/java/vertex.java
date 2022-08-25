import java.util.Objects;

public class vertex implements  Comparable<vertex>{


    //TODO: Try adding DISTINATION AND heuristics TO VEXTER CLASS

    String node;
    int distance;
    int heuristic;

    boolean visited;

    //Test
    int finalWeight;


    public vertex(String node) {
        this.node = node;
    }

    public String getnode() {
        return node;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public void setVisitedState(boolean state){
        this.visited = state;
    }

    public boolean isVisted(){
        return this.visited;
    }

    public void setnode(String node) {
        this.node = node;
    }

    public int getFinalWeight() {
        return finalWeight;
    }

    public void setFinalWeight(int finalWeight) {
        this.finalWeight = finalWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        vertex vertex = (vertex) o;
        return Objects.equals(node, vertex.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }

    @Override
    public int compareTo(vertex vertex) {
        return distance - vertex.getDistance();
    }

    public int getTotalEstimatedCost() {

        return this.heuristic+this.distance;
    }
}
