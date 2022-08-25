import java.lang.reflect.Array;
import java.util.*;

public class graphV3 {

    private  Map<vertex, List<vertex>> adjacentVertices;

    public graphV3(Map<vertex, List<vertex>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public graphV3() {
        this.adjacentVertices = new HashMap<>();
    }


    public Map<vertex, List<vertex>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<vertex, List<vertex>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    void addVertex(vertex node){
        adjacentVertices.putIfAbsent(node,new ArrayList<>());
    }


   public void  removeVertex(String node){
        vertex v = new vertex(node);

        adjacentVertices.values().stream().forEach(e -> e.remove(v));
        adjacentVertices.remove(new vertex(node));

    }

    void addEdge(String node1,String node2){

        vertex vertex1 = new vertex(node1);
        vertex vertex2 = new vertex(node2);

        adjacentVertices.get(node1).add(vertex2);
        adjacentVertices.get(node2).add(vertex1);

    }

    void addEdge(String node1,String node2,int distane){

        vertex vertex1 = new vertex(node1);
        vertex1.setDistance(distane);
        vertex vertex2 = new vertex(node2);
        vertex2.setDistance(distane);

        adjacentVertices.get(node1).add(vertex2);
        adjacentVertices.get(node2).add(vertex1);

    }
    void addEdge(String node1,String node2,int distance, int heuristic){

        vertex vertex1 = new vertex(node1);
        vertex1.setDistance(distance);
        vertex vertex2 = new vertex(node2);
        vertex2.setDistance(distance);
        vertex2.setHeuristic(heuristic);

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

    List<String> closedList = new ArrayList<>();
    public List<String> findRoute(String start, String target) {

//        System.out.println("first loop");
//
//        for (String s: closedList
//             ) {
//            System.out.println(s);
//        }
//
//        System.out.println("loop end");

        if (closedList.contains(start)){
            System.out.println("already been here");
        }else{
            closedList.add(start);
            System.out.println(start + " Has Been Added");

            List<vertex> currentNode = adjacentVertices.get(start);

            vertex smallest = (vertex) currentNode.toArray()[0];

            System.out.println( smallest.getnode() + " smallest");

            //System.out.println("start :" + start);
    //        while (!(smallest.getnode().equals(target))) {        }

            for (int i = 0; i < currentNode.size(); i++) {
                    vertex check = (vertex) currentNode.toArray()[i];
                    System.out.println();
                    if (check.getDistance() < smallest.getDistance()) {
                        System.out.println("Swapping  "+check.getnode() +" For " + smallest.getnode());
                        if (closedList.contains(check)){

                        }else{
                            smallest = check;
                        }



                    }

                }

                if (!(closedList.contains(smallest.getnode()))) {
                    {

                        System.out.println( "before recursive loop :" + smallest.getnode());
                        findRoute(smallest.getnode(),target);
                    }

                }
        }
//        if (!(closedList.contains(smallest.getnode()))){
//
//            closedList.add(smallest.getnode());
//
//            if (smallest.getnode() == target){
//                closedList.add(smallest.getnode());
//                System.out.println("Target"+target);
//                return closedList;
//            }else {
//                System.out.println("Current Node.java "+ smallest.getnode());
//
//                findRoute(smallest.getnode(), target);
//            }
//        }


        /*
        if(!closedList.contains(start)){
            closedList.add(start);
        }


        vertex shortestRoute = currentNode.get(0);

        //System.out.println(shortestRoute.getnode());


            for (vertex cur : currentNode) {
               // System.out.println(cur.getnode());
//                if (!closedList.contains(cur.node)){}
                    if ( cur.getDistance() < shortestRoute.getDistance()) {
                        shortestRoute = cur;
                    }


            }
            if(shortestRoute.getnode() == target){
                closedList.add(shortestRoute.getnode());

                for (String arr: closedList){
                    System.out.println(arr);
                }
                return closedList;
            }
            if(!closedList.contains(shortestRoute.node)){
                closedList.add(shortestRoute.getnode());
                findRoute(shortestRoute.getnode(),target);
            }


*/
            return closedList;
        }


    List<String> traveledList = new ArrayList<>();
    Map<String, List<vertex>> openList;

    public void AStarSearch(String currentLocation, String target){

        if(traveledList.isEmpty()){
            System.out.println("traveled List first element is :" + currentLocation);
            traveledList.add(currentLocation);
            removeVertex(currentLocation);
        }

    }
    int i = 0;
    public List<String> findRouter(vertex currentNode,vertex target){


            if(traveledList.isEmpty()){
                System.out.println("traveled List first element is :" + currentNode.getnode());

                traveledList.add(currentNode.getnode());
                currentNode.setVisitedState(true);

//                removeVertex(currentLocation);

            }

//            if(traveledList.contains(target)){
//
//                System.out.println("have reached\n\n");
//
//                for (String st:traveledList){
//                    System.out.println(st);
//                }
//
//                System.out.println("End\n\n");
//                return traveledList;
//
//            }

//                System.out.println("checkpoint reached");
//
//                for (String st:traveledList){
//                    System.out.println(st);
//                }
//
//                System.out.println("checkpoint End\n");




                vertex newLocation = smallcheck(currentNode);

                traveledList.add(newLocation.getnode());
                System.out.println("\n"+newLocation.getnode()+" Has Been Added\n\n");


                  //  i++;
                findRouter(newLocation,target);

                  //  if(i<5){ }




        return traveledList;
    }

    public vertex smallcheck(vertex currentLocation){

        ArrayList<vertex> nodeGroup = new ArrayList<>();

        for (vertex vertexCheck: adjacentVertices.get(currentLocation)){
            nodeGroup.add(vertexCheck);
        }

        vertex[] objects = (vertex[]) nodeGroup.toArray();

        Arrays.sort(objects);

        vertex smallestDis = objects[0];

        for (int i = 0; i<objects.length; i++) {
            if (objects[i].isVisted() == false){
                smallestDis = objects[i+1];
                break;
            }

        }

        return smallestDis;

    }

//    public vertex smallcheck(String currentLocation){
//
////        vertex small = adjacentVertices.get(currentLocation).get(0);
////        System.out.println("checking distance");
////        for (vertex smallcheck: adjacentVertices.get(currentLocation)){
////
////            if (smallcheck.getDistance() < small.getDistance()){
////                System.out.println();
////            }
////
////        }
//
//
//        vertex smallest = adjacentVertices.get(currentLocation).get(0);
//
//        for (vertex sml: adjacentVertices.get(currentLocation)){
//            if (sml.getDistance() < smallest.getDistance()){
//                smallest = sml;
//            }
//        }
//
//        System.out.println("first in list " + smallest.getnode());
//
//
//        for (vertex listVertex:adjacentVertices.get(currentLocation)) {
//
//            if (traveledList.contains(smallest.getnode())){
//                System.out.println("already been here :: " + smallest.node);
//                if (!(smallest.getnode().equals(listVertex.getnode()))){
//                    smallest = listVertex;
//                }
//            }
//
//
//        }
//        int k = 0;
//
//
//        adjacentVertices.remove(currentLocation);
//
////        for (Map.Entry<String, List<vertex>> e: getAdjacentVertices().entrySet()) {
////            System.out.println("KEY : " + e.getKey() + "  Value : ");
////            List<vertex> nextNode = e.getValue();
////
////            for (vertex nNode: nextNode){
////                System.out.println(e.getKey() +"<-========->"+nNode.node + "  heuristic : "+ nNode.getHeuristic()+ "  Distance : "+nNode.getDistance());
////            }
////            System.out.println();
////        }
//
////        if (adjacentVertices.get(currentlocation).get(i).getDistance() < smallest.getDistance() &&
////                !(traveledList.contains(adjacentVertices.get(currentlocation).get(i).getnode()))){
////            smallest = adjacentVertices.get(currentlocation).get(i);
////        }
//
////        if(!traveledList.contains(currentlocation)){
////            for (int i =0; i < adjacentVertices.size()-1; i++){
////                if (adjacentVertices.get(currentlocation).get(i).getDistance() < smallest.getDistance() &&
////                        !(traveledList.contains(adjacentVertices.get(currentlocation).get(i).getnode()))){
////                    smallest = adjacentVertices.get(currentlocation).get(i);
////                }
////            }
////        }
//        return smallest;
//    }

}
