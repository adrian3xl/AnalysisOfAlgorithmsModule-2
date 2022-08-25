import javax.swing.*;
import java.util.List;
import java.util.Map;

public  class test {
    public static void main(String[] args) {
        graphV4 map = new graphV4();

//        map.addVertex("HWT");
//        map.addVertex("PAPINE");
//        map.addVertex("DT");
//        map.addVertex("MAY PEN");
//        map.addVertex("SPAIN");
//
//        map.addEdge("HWT","PAPINE",5);
//        map.addEdge("HWT","DT",10);
//        map.addEdge("PAPINE","MAY PEN",2);
//        map.addEdge("DT","MAY PEN",3);
//


//        map.addVertex("S");
//        map.addVertex("A");
//        map.addVertex("B");
//        map.addVertex("C");
//        map.addVertex("D");
//        map.addVertex("X");
//        map.addVertex("Y");
//        map.addVertex("E");
//
//        //S
//        map.addEdge("S","A",1,10);
//        map.addEdge("S","B",2,8);
//        //A
////        map.addEdge("A","S",1);
//        map.addEdge("A","Y",4,8);
//        map.addEdge("A","X",7,3);
//        //B
////        map.addEdge("B","S",2);
//        map.addEdge("B","C",3,1);
//        map.addEdge("B","D",1,4);
//        //C
////        map.addEdge("C","B",7);
//        map.addEdge("C","E",5);
//        //D
////        map.addEdge("D","B",1);
//        map.addEdge("D","E",12);
//        //Y
////        map.addEdge("Y","A",7);
//        map.addEdge("Y","E",7);
//        //X
////        map.addEdge("X","A",4);
//        map.addEdge("X","E",2);
//        //E
//        map.addEdge("E","Y",4);
//        map.addEdge("E","X",2);
//        map.addEdge("E","D",4);
//        map.addEdge("E","C",2);


//
//        for (Map.Entry<String, List<vertex>> e : map.getAdjacentVertices().entrySet() ){
//            System.out.println("KEY :: "+e.getKey());
//            System.out.println("VALUE :: -===============-\n");
//            for (vertex v : e.getValue()){
//                System.out.println(v.getnode());
//            }
//        }

//        for (String string: map.findRouter("HWT","MAY PEN")) {
//        String start = "D";
//
//            List<String> newMap = map.bestFirstSearch(start,"E");
//
//        for (String string: newMap) {
//            System.out.println(string);
//        }


        map.addVertex("S");
        map.addVertex("A");
        map.addVertex("B");
        map.addVertex("C");
        map.addVertex("D");
        map.addVertex("G");

        //S
        map.addEdge("S","A",1,3);
        map.addEdge("S","G",1,10);
        //A
//        map.addEdge("A","S",1);
        map.addEdge("A","B",2,4);
        map.addEdge("A","C",1,2);
        //B
//        map.addEdge("B","S",2);
        map.addEdge("B","D",5,6);

        map.addEdge("C","D",3,6);
        //C
//        map.addEdge("C","B",7);
        map.addEdge("C","G",4);
        //D
//        map.addEdge("D","B",1);
        map.addEdge("D","G",2);

      //  map.traveledList.add("S");

        System.out.println("Best First Search");
        for (String route: map.bestFirstSearch("S","G")){
            System.out.println("["+route+"]");
        }
        System.out.println("Greedy Search");
       for (String route: map.greedySearch("S","G")){
           System.out.println("["+route+"]");
       }



        //map.newAStarSearch(new vertex("S"),new vertex("G"));
//      for (String str: ){
//          System.out.println("["+str+"]");
//      }




    }

    public static String startbestFirstSearch(String start,String target){

        graphV4 node = new graphV4();


        node.addVertex("Lucea");
        node.addVertex("Black River");
        node.addVertex("Montego Bay");
        node.addVertex("Falmouth");
        node.addVertex("Savanna-la-Mar");
        node.addVertex("May Pen");
        node.addVertex("Mandeville");
        node.addVertex("Saint Ann Bay");
        node.addVertex("Spanish Town");
        node.addVertex("Port Maria");
        node.addVertex("Kingston");
        node.addVertex("Port Antonio");
        node.addVertex("Half Way Tree");
        node.addVertex("Morant Bay");
        node.addVertex("Negril");
        node.addVertex("Bethel Town");
        node.addVertex("Balaclava");
        node.addVertex("Stewart Town");
        node.addVertex("Brown Town");
        node.addVertex("Claremont");
        node.addVertex("Linstead");

        //Node 1
        node.addEdge("Negril","Lucea",43);

        node.addEdge("Negril","Savanna-la-Mar",31);

        //Node 2
        node.addEdge("Lucea","Negril",43);
        node.addEdge("Lucea","Bethel Town",70);
        node.addEdge("Lucea","Montego Bay",55);
        //Node 3
        node.addEdge("Savanna-la-Mar","Negril",31);
        node.addEdge("Savanna-la-Mar","Bethel Town",53);
        node.addEdge("Savanna-la-Mar","Black River",60);
        //Node 4
        node.addEdge("Bethel Town","Lucea",70);
        node.addEdge("Bethel Town","Savanna-la-Mar",53);
        node.addEdge("Bethel Town","Black River",55);
        node.addEdge("Bethel Town","Balaclava",87);
        node.addEdge("Bethel Town","Montego Bay",54);
        //Node 5
        node.addEdge("Montego Bay","Bethel Town",54);
        node.addEdge("Montego Bay","Balaclava",129);
        node.addEdge("Montego Bay","Falmouth",38);
        node.addEdge("Montego Bay","Lucea",55);

        //Node 6
        node.addEdge("Black River","Savanna-la-Mar",60);
        node.addEdge("Black River","Bethel Town",55);
        node.addEdge("Black River","Balaclava",55);
        node.addEdge("Black River","Mandeville",76);

        //Node 7
        node.addEdge("Balaclava","Montego Bay",129);
        node.addEdge("Balaclava","Bethel Town",87);
        node.addEdge("Balaclava","Black River",55);
        node.addEdge("Balaclava","Stewart Town",99);

        // Node 8
        node.addEdge("Falmouth","Montego Bay",38);
        node.addEdge("Falmouth","Stewart Town",43);
        node.addEdge("Falmouth","Brown Town",56);
        node.addEdge("Falmouth","Saint Ann Bay",57);

        //Node9
        node.addEdge("Stewart Town","Balaclava",99);
        node.addEdge("Stewart Town","Mandeville",111);
        node.addEdge("Stewart Town","Brown Town",16);
        node.addEdge("Stewart Town","Falmouth",43);

        //Node 10
        node.addEdge("Mandeville","Black River",76);
        node.addEdge("Mandeville","Stewart Town",111);
        node.addEdge("Mandeville","May Pen",53);

        //Node 11
        node.addEdge("May Pen","Mandeville",53);
        node.addEdge("May Pen","Brown Town",123);
        node.addEdge("May Pen","Spanish Town",34);

        //Node 12
        node.addEdge("Brown Town","Stewart Town",16);
        node.addEdge("Brown Town","May Pen",123);
        node.addEdge("Brown Town","Claremont",46);
        node.addEdge("Brown Town","Falmouth",56);


        //Node 13
        node.addEdge("Saint Ann Bay","Falmouth",57);
        node.addEdge("Saint Ann Bay","Claremont",27);
        node.addEdge("Saint Ann Bay","Port Maria",75);

        //Node 14
        node.addEdge("Claremont","Saint Ann Bay",27);
        node.addEdge("Claremont","Brown Town",46);
        node.addEdge("Claremont","Linstead",35);

        //Node 15
        node.addEdge("Linstead","Claremont",35);
        node.addEdge("Linstead","Spanish Town",30);
        node.addEdge("Linstead","Kingston",49);

        //Node 16
        node.addEdge("Spanish Town","Linstead",30);
        node.addEdge("Spanish Town","May Pen",34);
        node.addEdge("Spanish Town","Kingston",29);

        //Node 17
        node.addEdge("Kingston","Spanish Town",29 );
        node.addEdge("Kingston","Linstead",49 );
        node.addEdge("Kingston","Half Way Tree",14 );
        node.addEdge("Kingston","Morant Bay",116);

        //Node 18
        node.addEdge("Morant Bay","Kingston",116);
        node.addEdge("Morant Bay","Half Way Tree",99);
        node.addEdge("Morant Bay","Port Antonio",140);

        //Node 19
        node.addEdge("Port Antonio","Morant Bay",140);
        node.addEdge("Port Antonio","Half Way Tree",139);
        node.addEdge("Port Antonio","Port Maria",73);

        //Node 20
        node.addEdge("Port Maria","Port Antonio",73);
        node.addEdge("Port Maria","Saint Ann Bay",75);
        node.addEdge("Port Maria","Half Way Tree",93);

        //Node 21
        node.addEdge("Half Way Tree" ,"Port Maria"  ,93 );
        node.addEdge("Half Way Tree" ,"Port Antonio",139);
        node.addEdge("Half Way Tree" ,"Morant Bay"  ,99 );
        node.addEdge("Half Way Tree" ,"Kingston"   ,14 );

//       for(String name:  node.bestFirstSearch(start,target)){
//           System.out.println(name);
//        }
        String returningPath = "";
        for (String name:  node.bestFirstSearch(start,target)){
            returningPath = returningPath +"<===>"+ name;
        }
        return returningPath;
    }

    public static String startGreddySearch(String start,String target){

        graphV4 node = new graphV4();


        node.addVertex("Lucea");
        node.addVertex("Black River");
        node.addVertex("Montego Bay");
        node.addVertex("Falmouth");
        node.addVertex("Savanna-la-Mar");
        node.addVertex("May Pen");
        node.addVertex("Mandeville");
        node.addVertex("Saint Ann Bay");
        node.addVertex("Spanish Town");
        node.addVertex("Port Maria");
        node.addVertex("Kingston");
        node.addVertex("Port Antonio");
        node.addVertex("Half Way Tree");
        node.addVertex("Morant Bay");
        node.addVertex("Negril");
        node.addVertex("Bethel Town");
        node.addVertex("Balaclava");
        node.addVertex("Stewart Town");
        node.addVertex("Brown Town");
        node.addVertex("Claremont");
        node.addVertex("Linstead");

        //Node 1
        node.addEdge("Negril","Lucea",43);

        node.addEdge("Negril","Savanna-la-Mar",31);

        //Node 2
        node.addEdge("Lucea","Negril",43);
        node.addEdge("Lucea","Bethel Town",70);
        node.addEdge("Lucea","Montego Bay",55);
        //Node 3
        node.addEdge("Savanna-la-Mar","Negril",31);
        node.addEdge("Savanna-la-Mar","Bethel Town",53);
        node.addEdge("Savanna-la-Mar","Black River",60);
        //Node 4
        node.addEdge("Bethel Town","Lucea",70);
        node.addEdge("Bethel Town","Savanna-la-Mar",53);
        node.addEdge("Bethel Town","Black River",55);
        node.addEdge("Bethel Town","Balaclava",87);
        node.addEdge("Bethel Town","Montego Bay",54);
        //Node 5
        node.addEdge("Montego Bay","Bethel Town",54);
        node.addEdge("Montego Bay","Balaclava",129);
        node.addEdge("Montego Bay","Falmouth",38);
        node.addEdge("Montego Bay","Lucea",55);

        //Node 6
        node.addEdge("Black River","Savanna-la-Mar",60);
        node.addEdge("Black River","Bethel Town",55);
        node.addEdge("Black River","Balaclava",55);
        node.addEdge("Black River","Mandeville",76);

        //Node 7
        node.addEdge("Balaclava","Montego Bay",129);
        node.addEdge("Balaclava","Bethel Town",87);
        node.addEdge("Balaclava","Black River",55);
        node.addEdge("Balaclava","Stewart Town",99);

        // Node 8
        node.addEdge("Falmouth","Montego Bay",38);
        node.addEdge("Falmouth","Stewart Town",43);
        node.addEdge("Falmouth","Brown Town",56);
        node.addEdge("Falmouth","Saint Ann Bay",57);

        //Node9
        node.addEdge("Stewart Town","Balaclava",99);
        node.addEdge("Stewart Town","Mandeville",111);
        node.addEdge("Stewart Town","Brown Town",16);
        node.addEdge("Stewart Town","Falmouth",43);

        //Node 10
        node.addEdge("Mandeville","Black River",76);
        node.addEdge("Mandeville","Stewart Town",111);
        node.addEdge("Mandeville","May Pen",53);

        //Node 11
        node.addEdge("May Pen","Mandeville",53);
        node.addEdge("May Pen","Brown Town",123);
        node.addEdge("May Pen","Spanish Town",34);

        //Node 12
        node.addEdge("Brown Town","Stewart Town",16);
        node.addEdge("Brown Town","May Pen",123);
        node.addEdge("Brown Town","Claremont",46);
        node.addEdge("Brown Town","Falmouth",56);


        //Node 13
        node.addEdge("Saint Ann Bay","Falmouth",57);
        node.addEdge("Saint Ann Bay","Claremont",27);
        node.addEdge("Saint Ann Bay","Port Maria",75);

        //Node 14
        node.addEdge("Claremont","Saint Ann Bay",27);
        node.addEdge("Claremont","Brown Town",46);
        node.addEdge("Claremont","Linstead",35);

        //Node 15
        node.addEdge("Linstead","Claremont",35);
        node.addEdge("Linstead","Spanish Town",30);
        node.addEdge("Linstead","Kingston",49);

        //Node 16
        node.addEdge("Spanish Town","Linstead",30);
        node.addEdge("Spanish Town","May Pen",34);
        node.addEdge("Spanish Town","Kingston",29);

        //Node 17
        node.addEdge("Kingston","Spanish Town",29 );
        node.addEdge("Kingston","Linstead",49 );
        node.addEdge("Kingston","Half Way Tree",14 );
        node.addEdge("Kingston","Morant Bay",116);

        //Node 18
        node.addEdge("Morant Bay","Kingston",116);
        node.addEdge("Morant Bay","Half Way Tree",99);
        node.addEdge("Morant Bay","Port Antonio",140);

        //Node 19
        node.addEdge("Port Antonio","Morant Bay",140);
        node.addEdge("Port Antonio","Half Way Tree",139);
        node.addEdge("Port Antonio","Port Maria",73);

        //Node 20
        node.addEdge("Port Maria","Port Antonio",73);
        node.addEdge("Port Maria","Saint Ann Bay",75);
        node.addEdge("Port Maria","Half Way Tree",93);

        //Node 21
        node.addEdge("Half Way Tree" ,"Port Maria"  ,93 );
        node.addEdge("Half Way Tree" ,"Port Antonio",139);
        node.addEdge("Half Way Tree" ,"Morant Bay"  ,99 );
        node.addEdge("Half Way Tree" ,"Kingston"   ,14 );

//       for(String name:  node.bestFirstSearch(start,target)){
//           System.out.println(name);
//        }
        String returningPath = "";
        for (String name:  node.greedySearch(start,target)){
            returningPath = returningPath + " <===> "+ name;
        }
        return returningPath;
    }

}