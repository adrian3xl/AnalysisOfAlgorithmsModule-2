import java.util.*;

public class Node implements Comparable<Node> {
    // Id for readability of result purposes
    private static int idCounter = 0;
    public int id;

    //Name of the places
    String name;

    // Parent in the path
    public Node parent = null;

    public List<Edge> neighbors;

    // Evaluation functions
    public double f = Double.MAX_VALUE;
    public double g = Double.MAX_VALUE;
    // Hardcoded heuristic
    public double h;

    Node(double h){
        this.h = h;
        this.id = idCounter++;
        this.neighbors = new ArrayList<>();
    }
    Node(double h,String name){
        this.h = h;
        this.id = idCounter++;
        this.neighbors = new ArrayList<>();
        this.name = name;
    }



    @Override
    public int compareTo(Node n) {
        return Double.compare(this.f, n.f);
    }

    public static class Edge {
        Edge(int weight, Node node){
            this.weight = weight;
            this.node = node;
        }

        public int weight;
        public Node node;
    }

    public void addBranch(int weight, Node node){
        Edge newEdge = new Edge(weight, node);
        neighbors.add(newEdge);
    }

    public double calculateHeuristic(Node target){
        return this.h;
    }


    public static Node aStar(Node start, Node target){
        PriorityQueue<Node> closedList = new PriorityQueue<>();
        PriorityQueue<Node> openList = new PriorityQueue<>();

        start.f = start.g + start.calculateHeuristic(target);
        openList.add(start);

        while(!openList.isEmpty()){
            Node n = openList.peek();
            if(n == target){
                return n;
            }

            for(Edge edge : n.neighbors){
                Node m = edge.node;
                double totalWeight = n.g + edge.weight;

                if(!openList.contains(m) && !closedList.contains(m)){
                    m.parent = n;
                    m.g = totalWeight;
                    m.f = m.g + m.calculateHeuristic(target);
                    openList.add(m);
                } else {
                    if(totalWeight < m.g){
                        m.parent = n;
                        m.g = totalWeight;
                        m.f = m.g + m.calculateHeuristic(target);

                        if(closedList.contains(m)){
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }

            openList.remove(n);
            closedList.add(n);
        }
        return null;
    }

    public static void printPath(Node target){
        Node n = target;

        if(n==null)
            return;

        List<Integer> ids = new ArrayList<>(); // COLLECTING NODE ID

        List<String > names = new ArrayList<>();

        while(n.parent != null){
            ids.add(n.id);

            names.add(n.name); //Adding name

            n = n.parent;
        }
        ids.add(n.id);
        Collections.reverse(ids);

        names.add(n.name);
        Collections.reverse(names);

        for(int id : ids){
            System.out.print(id + " ");
        }
        System.out.println("\n\nNames\n");

        for (String name:names){
            System.out.print("{"+name+"}" + "");
        }
    }

    public static String returnPath(Node target){
        Node n = target;

        if(n==null)
            return null;

        List<Integer> ids = new ArrayList<>(); // COLLECTING NODE ID

        List<String > names = new ArrayList<>();

        double totalDistance = 0;

        while(n.parent != null){
            ids.add(n.id);

            names.add(n.name); //Adding name
             totalDistance =  (totalDistance + n.g);
            n = n.parent;
        }
        ids.add(n.id);
        Collections.reverse(ids);

        names.add(n.name);
        Collections.reverse(names);

        String fullPath = "";
        int index = 0;
        for (String name:names){
            if (index == 0){
                fullPath = name;
            }else{
                fullPath = fullPath + "<-====->"+name;
            }
            index++;
        }
        return fullPath + " Total Distance : "+ totalDistance;
    }



    public static void main(String[] args) {
//        Node head = new Node(4);
//        head.g = 0;
//
//        Node n1 = new Node(2);
//        Node n2 = new Node(2);
//        Node n3 = new Node(2);
//
//        head.addBranch(1, n1);
//        head.addBranch(5, n2);
//        head.addBranch(2, n3);
//        n3.addBranch(1, n2);
//
//        Node n4 = new Node(1);
//        Node n5 = new Node(1);
//        Node target = new Node(0);
//
//        n1.addBranch(7, n4);
//        n2.addBranch(4, n5);
//        n3.addBranch(6, n4);
//
//        n4.addBranch(3, target);
//        n5.addBranch(1, n4);
//        n5.addBranch(3, target);
//
//        Node res = aStar(head, target);
//        printPath(res);


        Node head = new Node(0,"A");
        head.g = 0;

        Node b = new Node(0,"B");
        Node c = new Node(0,"C");

        Node e = new Node(0,"E");
        Node d = new Node(0,"D");

        Node f = new Node(0,"F");
        Node z = new Node(0,"Z");
        z.g =0;


        head.addBranch(4, b);
        head.addBranch(3, c);

        b.addBranch(5, f);
        b.addBranch(12, e);

        c.addBranch(7, d);
        c.addBranch(10, e);

        d.addBranch(2,e);

        f.addBranch(16,z);

        e.addBranch(5,z);

        //second connection
        z.addBranch(16,f);
        z.addBranch(5,e);

        f.addBranch(5,b);


        e.addBranch(2,d);
        e.addBranch(10,c);
        e.addBranch(12,b);


        d.addBranch(7,c);

        c.addBranch(3,head);

        b.addBranch(4,head);

        Node res = aStar(z,head );
        printPath(res);



    }

    public static String startAStarSearch(String start, String target) {

        Node Lucea = new Node(0,"Lucea");
        Node BlackRiver = new Node(0,"Black River");
        Node MontegoBay = new Node(0,"Montego Bay");
        Node Falmouth = new Node(0,"Falmouth");
        Node SavannalaMar = new Node(0,"Savanna-la-Mar");
        Node MayPen = new Node(0,"May Pen");
        Node Mandeville = new Node(0,"Mandeville");
        Node SaintAnnsBay = new Node(0,"Saint Ann Bay");
        Node SpanishTown = new Node(0,"Spanish Town");
        Node PortMaria = new Node(0,"Port Maria");
        Node Kingston = new Node(0,"Kingston");
        Node PortAntonio = new Node(0,"Port Antonio");
        Node HalfWayTree = new Node(0,"Half Way Tree");
        Node MorantBay = new Node(0,"Morant Bay");
        Node Negril = new Node(0,"Negril");
        Node BethelTown = new Node(0,"Bethel Town");
        Node Balaclava = new Node(0,"Balaclava");
        Node StewartTown = new Node(0,"Stewart Town");
        Node BrownsTown = new Node(0,"Brown Town");
        Node Claremont = new Node(0,"Claremont");
        Node Linstead = new Node(0,"Linstead");

        //Node 1
         Negril.addBranch(43,Lucea);
         Negril.addBranch(31,SavannalaMar);
        //Node 2
         Lucea.addBranch(43,Negril);
         Lucea.addBranch(70,BethelTown);
         Lucea.addBranch(55,MontegoBay);
        //Node 3
         SavannalaMar.addBranch(31,Negril);
         SavannalaMar.addBranch(53,BethelTown);
         SavannalaMar.addBranch(60,BlackRiver);
        //Node 4
         BethelTown.addBranch(70,Lucea);
         BethelTown.addBranch(53,SavannalaMar);
         BethelTown.addBranch(55,BlackRiver);
         BethelTown.addBranch(87,Balaclava);
         BethelTown.addBranch(54,MontegoBay);
         //Node 5
        MontegoBay.addBranch(54,BethelTown);
        MontegoBay.addBranch(129,Balaclava);
        MontegoBay.addBranch(38,Falmouth);
        MontegoBay.addBranch(55,Lucea);

        //Node 6
        BlackRiver.addBranch(60,SavannalaMar);
        BlackRiver.addBranch(55,BethelTown);
        BlackRiver.addBranch(55,Balaclava);
        BlackRiver.addBranch(76,Mandeville);

        //Node 7
        Balaclava.addBranch(129,MontegoBay);
        Balaclava.addBranch(87,BethelTown);
        Balaclava.addBranch(55,BlackRiver);
        Balaclava.addBranch(99,StewartTown);

        // Node 8
        Falmouth.addBranch(38,MontegoBay);
        Falmouth.addBranch(43,StewartTown);
        Falmouth.addBranch(56,BrownsTown);
        Falmouth.addBranch(57,SaintAnnsBay);

        //Node9
        StewartTown.addBranch(99,Balaclava);
        StewartTown.addBranch(111,Mandeville);
        StewartTown.addBranch(16,BrownsTown);
        StewartTown.addBranch(43,Falmouth);

        //Node 10
        Mandeville.addBranch(76,BlackRiver);
        Mandeville.addBranch(111,StewartTown);
        Mandeville.addBranch(53,MayPen);

        //Node 11
        MayPen.addBranch(53,Mandeville);
        MayPen.addBranch(123,BrownsTown);
        MayPen.addBranch(34,SpanishTown);

        //Node 12
        BrownsTown.addBranch(16,StewartTown);
        BrownsTown.addBranch(123,MayPen);
        BrownsTown.addBranch(46,Claremont);
        BrownsTown.addBranch(56,Falmouth);


        //Node 13
        SaintAnnsBay.addBranch(57,Falmouth);
        SaintAnnsBay.addBranch(27,Claremont);
        SaintAnnsBay.addBranch(75,PortMaria);

        //Node 14
        Claremont.addBranch(27,SaintAnnsBay);
        Claremont.addBranch(46,BrownsTown);
        Claremont.addBranch(35,Linstead);

        //Node 15
        Linstead.addBranch(35,Claremont);
        Linstead.addBranch(30,SpanishTown);
        Linstead.addBranch(49,Kingston);

        //Node 16
        SpanishTown.addBranch(30,Linstead);
        SpanishTown.addBranch(34,MayPen);
        SpanishTown.addBranch(29,Kingston);

        //Node 17
        Kingston.addBranch(29,SpanishTown);
        Kingston.addBranch(49,Linstead);
        Kingston.addBranch(14,HalfWayTree);
        Kingston.addBranch(116,MorantBay);

        //Node 18
        MorantBay.addBranch(116,Kingston);
        MorantBay.addBranch(99,HalfWayTree);
        MorantBay.addBranch(140,PortAntonio);

        //Node 19
        PortAntonio.addBranch(140,MorantBay);
        PortAntonio.addBranch(139,HalfWayTree);
        PortAntonio.addBranch(73,PortMaria);

        //Node 20
        PortMaria.addBranch(73,PortAntonio);
        PortMaria.addBranch(75,SaintAnnsBay);
        PortMaria.addBranch(93,HalfWayTree);

        //Node 21
        HalfWayTree.addBranch(93,PortMaria);
        HalfWayTree.addBranch(139,PortAntonio);
        HalfWayTree.addBranch(99,MorantBay);
        HalfWayTree.addBranch(14,Kingston);


        switch (start){

            case "Lucea":
                Lucea.g =0;
                break;
            case "Black River":
                    BlackRiver.g=0;
                    break;
            case "Montego Bay":
                MontegoBay.g=0;
                break;
            case "Falmouth":
                Falmouth.g=0;
                break;
            case "Savanna-la-Mar":
                SavannalaMar.g=0;
                break;
            case "May Pen": MayPen .g=0;
                break;
            case "Mandeville": Mandeville.g=0;
                break;
            case "Saint Ann Bay": SaintAnnsBay .g=0;
                break;
            case "Spanish Town": SpanishTown .g=0;
                break;
            case "Port Maria": PortMaria .g=0;
                break;
            case "Kingston": Kingston .g=0;
                break;
            case "Port Antonio": PortAntonio .g=0;
                break;
            case "Half Way Tree": HalfWayTree .g=0;
                break;
            case "Morant Bay": MorantBay .g=0;
                break;
            case "Negril": Negril.g=0;
                break;
            case "Bethel Town": BethelTown.g=0;
                break;
            case "Balaclava": Balaclava  .g=0;
                break;
            case "Stewart Town": StewartTown.g=0;
                break;
            case "Brown Town": BrownsTown  .g=0;
                break;
            case "Claremont": Claremont .g=0;
                break;
            case "Linstead": Linstead.g=0;
                break;

        }

        Map<String,Node> nodeMap = new HashMap<>();

        nodeMap.put("Lucea",Lucea);
        nodeMap.put("Black River",BlackRiver);
        nodeMap.put("Montego Bay",MontegoBay);
        nodeMap.put("Falmouth",Falmouth);
        nodeMap.put("Savanna-la-Mar",SavannalaMar );
        nodeMap.put("May Pen",MayPen );
        nodeMap.put("Mandeville",Mandeville);
        nodeMap.put("Saint Ann Bay",SaintAnnsBay );
        nodeMap.put("Spanish Town",SpanishTown );
        nodeMap.put("Port Maria",PortMaria );
        nodeMap.put("Kingston",Kingston );
        nodeMap.put("Port Antonio",PortAntonio );
        nodeMap.put("Half Way Tree",HalfWayTree );
        nodeMap.put("Morant Bay",MorantBay );
        nodeMap.put("Negril",Negril );
        nodeMap.put("Bethel Town",BethelTown   );
        nodeMap.put("Balaclava",Balaclava  );
        nodeMap.put("Stewart Town",StewartTown  );
        nodeMap.put("Brown Town",BrownsTown  );
        nodeMap.put("Claremont",Claremont );
        nodeMap.put("Linstead",Linstead);

        Node res = aStar(nodeMap.get(start) ,nodeMap.get(target));
       return returnPath(res);
    }
}

