import java.util.*;

public class graphV4 {

    private  Map<String, List<vertex>> adjacentVertices;

    public graphV4(Map<String, List<vertex>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public graphV4() {
        this.adjacentVertices = new HashMap<>();
    }


    public Map<String, List<vertex>> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<String, List<vertex>> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    void addVertex(String node){
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

        adjacentVertices.get(node1).add(vertex2);
        adjacentVertices.get(node2).add(vertex1);

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

    public void alreadyVisted(String nodeName){
        for (Map.Entry<String, List<vertex>> e: getAdjacentVertices().entrySet()) {
//            System.out.println("KEY : " + e.getKey() + "  Value : ");
            List<vertex> nextNode = e.getValue();

            for (vertex nNode: nextNode){
                if (nNode.node == nodeName) {
                    nNode.setVisitedState(true);
                }
            }

        }
    }

//    public void AStarSearch(String currentLocation, String target){
//
//        if(traveledList.isEmpty()){
//            System.out.println("traveled List first element is :" + currentLocation);
//            traveledList.add(currentLocation);
//            removeVertex(currentLocation);
//        }
//
//    }

    public List<String> bestFirstSearchtest(String currentLocation, String target){


        if (currentLocation.equals(target)){


            traveledList.add(target);
            return traveledList;
        }else{




            if (traveledList.isEmpty()){
                alreadyVisted(currentLocation);
            }

            traveledList.add(currentLocation);
            removeVertex(currentLocation);
            vertex newLocation = smallcheck(currentLocation);

//            if (!traveledList.contains(target)){ }
            bestFirstSearch(newLocation.getnode(),target);

        }


        return traveledList;
    }


    public List<String> bestFirstSearch(String currentLocation, String target){


        if (currentLocation.equals(target)){


            traveledList.add(target);
            return traveledList;
        }

            if (traveledList.isEmpty()){
                alreadyVisted(currentLocation);
            }

            traveledList.add(currentLocation);
            removeVertex(currentLocation);
            vertex newLocation = smallcheck(currentLocation);

//            for (String hmm :traveledList){
//                System.out.println(hmm);
//            }

//            if (!traveledList.contains(target)){ }
        try{
            bestFirstSearch(newLocation.getnode(),target);
        }catch (StackOverflowError stackOverflowError){
            return traveledList;
        }




        return traveledList;
    }

//
//    public List<String> findRouter(String currentLocation, String target){
//
//
//        if(traveledList.isEmpty()){
//            System.out.println("traveled List first element is :" + currentLocation);
//            traveledList.add(currentLocation);
////                removeVertex(currentLocation);
//        }
//
//        if(traveledList.contains(target)){
//
//            System.out.println("have reached\n\n");
//
//            for (String st:traveledList){
//                System.out.println(st);
//            }
//
//            System.out.println("End\n\n");
//            return traveledList;
//
//        }
//
//        System.out.println("checkpoint reached");
//
//        for (String st:traveledList){
//            System.out.println(st);
//        }
//
//        System.out.println("checkpoint End\n");
//
//        vertex newLocation = smallcheck(currentLocation);
//
//        traveledList.add(newLocation.getnode());
//        System.out.println("\n"+newLocation.getnode()+" Has Been Added\n\n");
//
//
//        i++;
//
//        findRouter(newLocation.getnode(),target);
//
//        if(i<5){      }
//
//
//
//
//        return traveledList;
//    }

    public vertex smallcheck(String currentLocation){

        ArrayList<vertex> nodeGroup = new ArrayList<>();

        for (vertex vertexCheck: adjacentVertices.get(currentLocation)){
            nodeGroup.add(vertexCheck);
        }

        vertex[] vertexArr = new vertex[nodeGroup.size()];
        for (int i = 0; i< nodeGroup.size();i++){
            vertexArr[i] = nodeGroup.get(i);

        }

//        System.out.println("\n==================\nBefore sort");
//        for (vertex sort: vertexArr) {
//            System.out.println(sort.getnode()+"  "+sort.visited);
//        }

        Arrays.sort(vertexArr);


        LinkedHashSet<vertex> set = new LinkedHashSet<vertex>();



        // adding elements to LinkedHashSet
        for (int i = 0; i < vertexArr.length; i++) {
            set.add(vertexArr[i]);
        }


//        System.out.println("\n==================\nAfter Sort");
//        for (vertex sort: set) {
//            System.out.println(sort.getnode() +"  "+sort.visited);
//        }

        //vertex smallestDis = vertexArr[0];

        Iterator<vertex> vertexIterator = set.iterator();

        int io = 0;
        vertex smallestDis = null;

        while (vertexIterator.hasNext()){
            if (io == 0){
                smallestDis = vertexIterator.next();
            }else{
                if (vertexIterator.next().getDistance() < smallestDis.getDistance()){
                    smallestDis = vertexIterator.next();
                }
            }
            io++;
        }

//
//        for (vertex ArraySet: set) {
//            if (ArraySet.visited==false &&!traveledList.contains(ArraySet.getnode())){
//                if (ArraySet.getDistance() < smallestDis.getDistance()){
//                    smallestDis = ArraySet;
//                }
//            }
//        }

        for (int i = 0; i<vertexArr.length; i++) {
            if (!vertexArr[i].isVisted()){
                if (vertexArr[i].getDistance()<smallestDis.getDistance()){
                    smallestDis = vertexArr[i];
                }
            }

        }

//        System.out.println("smallets : " +smallestDis.getnode());

        if (smallestDis != null) {
            smallestDis.setVisitedState(true);
        }


//        System.out.println(smallestDis.visited);

        return smallestDis;
    }




    PriorityQueue<Map<String,List<vertex>>> priorityQueue = new PriorityQueue<>();

    List<String> greedyTraveledList = new ArrayList<>();

    public List<String> greedySearch(String currentLocation, String target){


        if(currentLocation != target){
            traveledList.add(currentLocation);
            String newLocation = randonPicker(currentLocation);

            removeVertex(currentLocation);

            greedySearch(newLocation,target);

        }else{

            traveledList.add(currentLocation);

        }

        return traveledList;
    }

    public String randonPicker(String currentNode){

        List<vertex> node =  adjacentVertices.get(currentNode);

        //System.out.println(node.size());

        int size = node.size();
        Random randomIndex= new Random();
        int randomNode = randomIndex.nextInt(size-0) + 0;

        String newLocation = adjacentVertices.get(currentNode).get(randomNode).node;

        return newLocation  ;
    }


    Map<String,String> fullPath = new HashMap<>();
    String fullPathString = "";
    int finalDistance;

    public List<String> aStarSearch(String currentLocation, String target) {

        if (!traveledList.isEmpty() && !traveledList.contains(target)){
            System.out.println(currentLocation);

            List<vertex> openlist = adjacentVertices.get(currentLocation);

            for (vertex vertexFromopenlist : openlist ){

                vertexFromopenlist.setFinalWeight(vertexFromopenlist.getDistance() + vertexFromopenlist.getHeuristic());
            }

            vertex smallestWeight = openlist.get(0);

            for (vertex vertexFromopenlist : openlist ){

                if (vertexFromopenlist.getFinalWeight()<smallestWeight.getFinalWeight());{
                    smallestWeight = vertexFromopenlist;
                }

            }
             removeVertex(smallestWeight.getNode());
            traveledList.add(smallestWeight.getnode());
            aStarSearch(smallestWeight.getNode(),target);


        }

        return traveledList;
    }




//    public Map<Integer, List<String>> newGraphMap = new HashMap<>();
//
//    public void newAStarSearch(vertex currentLocation, vertex target){
//
//        openListNode.add(currentLocation);
//
//        // while (the destination node has not been reached):
//        while (!currentLocation.equals(target)){
//
//
//            if (currentLocation.node.equals(target)){
//
//                break;
//            }else{
//
//                closeList.add(currentLocation);
//
//
//                vertex closetDistance =  adjacentVertices.get(currentLocation.getnode()).get(0);
//
//                for (vertex closetCheck:  adjacentVertices.get(currentLocation.getnode())){
//
//                    if (closetCheck.getDistance()< currentLocation.getDistance() && closeList.contains(currentLocation) ){
//                        closetDistance = closetCheck;
//                        currentLocation = closetDistance;
//                    }else if(currentLocation.getDistance() <closetCheck.getDistance() && openListNode.contains(closetCheck)){
//                        closetDistance = closetCheck;
//                        currentLocation = closetDistance;
//                    }else if(!openListNode.contains(closetCheck) && ! closeList.contains(closetCheck)) {
//                        openListNode.add(closetCheck);
//                    }
//
//                   // closetCheck.setFinalWeight(closetCheck.getDistance() + closetCheck.getHeuristic());
////                    if (closetCheck.getFinalWeight()<closetDistance.getFinalWeight()){
////                        closetDistance = closetCheck;
////                    }
//                }
//            }
//
//
//
//        }
//
//        for (vertex v1:closeList){
//            System.out.println(v1.getnode());
//        }
//
//    }
//
//
////    public  void starSearch(vertex currentLocation, vertex target){
////        List<vertex> listOpen = new ArrayList<>();
////        List<vertex> listClose = new ArrayList<>();
////
////        listOpen.add(currentLocation);
////
////        while (!listOpen.isEmpty()) {
////
////            listOpen.remove(currentLocation);
////            listClose.add(currentLocation);
////
////            shortFunction(currentLocation,target);
////
////            break;
////        }
////
////    }
//
////    private void shortFunction(vertex currentLocation, vertex target) {
////
////
////        vertex shortRoute = adjacentVertices.get(currentLocation.getnode()).get(0);
////
////        for (vertex ver: adjacentVertices.get(currentLocation.getnode())) {
////            int tempTotalEstimatedCost = ver.getDistance() + ver.getHeuristic();
////            if(tempTotalEstimatedCost < shortRoute.getTotalEstimatedCost()){
//////                shortRoute =
////            }
////        }
////
////    }
//

}
