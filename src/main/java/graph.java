import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class graph {

    private  Map<vertex, List<vertex>> adjacentVertices;

    public graph(Map<vertex, List<vertex>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }


    public Map<vertex, List<vertex>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<vertex, List<vertex>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }
    
    void addVertex(String node){
        adjacentVertices.putIfAbsent(new vertex(node),new ArrayList<>());
    }
    
    void  removeVertex(String node){
        vertex v = new vertex(node);
        adjacentVertices.values().stream().forEach(e -> e.remove(v));
        adjacentVertices.remove(new vertex(node));
    }

    void addEdge(String node1,String node2){
        vertex vertex1 = new vertex(node1);
        vertex vertex2 = new vertex(node2);
        adjacentVertices.get(vertex1).add(vertex2);
        adjacentVertices.get(vertex2).add(vertex1);


    }

    void removeEdge(String node1,String node2){
        vertex vertex1 = new vertex(node1);
        vertex vertex2 = new vertex(node2);
        List<vertex> listVertex1 = adjacentVertices.get(vertex1);
        List<vertex> listVertex2 = adjacentVertices.get(vertex2);

        if (listVertex1 !=null){
            listVertex1.remove(vertex1);

        }

        if (listVertex2 !=null){
            listVertex2.remove(vertex2);

        }

    }

    List<vertex> getAdjacentVertices(String node){
        return adjacentVertices.get(new vertex(node));
    }
    
}
