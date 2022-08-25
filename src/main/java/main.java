import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {




        vertex KING = new vertex("KING");
        vertex HWT = new vertex("HWT");
        vertex PAPINE = new vertex("PAPINE");
        vertex SPAIN = new vertex("SPAIN");
        vertex MAYPEN = new vertex("MAY PEN ");
        vertex DOWNTOWN = new vertex("DOWNTOWN");
        vertex FF = new vertex("FF");
        vertex CROSSROAD = new vertex("CROSS ROAD");

        // First Node - HWT
        List<vertex> HWTNextTown = new ArrayList<>();
        PAPINE.setDistance(6);
        PAPINE.setHeuristic(8);
        HWTNextTown.add(PAPINE);
        KING.setHeuristic(9);
        KING.setDistance(7);
        HWTNextTown.add(KING);

        // Second Node - PAPIN
        List<vertex> PAPINENextTown = new ArrayList<>();
        HWT.setDistance(6);
        HWT.setHeuristic(10);
        PAPINENextTown.add(HWT);
        MAYPEN.setHeuristic(7);
        MAYPEN.setDistance(2);
        PAPINENextTown.add(MAYPEN);
        SPAIN.setHeuristic(5);
        SPAIN.setDistance(4);
        PAPINENextTown.add(SPAIN);

        // Third Node - SPAIN
        List<vertex> SPAINNextTown = new ArrayList<>();
        SPAINNextTown.add(PAPINE);
        SPAINNextTown.add(FF);

        // Forth Node - FF
        List<vertex> FFNextTown = new ArrayList<>();
        FFNextTown.add(SPAIN);
        FFNextTown.add(DOWNTOWN);
        FFNextTown.add(CROSSROAD);


        // Third Node - DOWNTOWN
        List<vertex> DOWNTOWNNextTown = new ArrayList<>();
        DOWNTOWNNextTown.add(MAYPEN);
        DOWNTOWNNextTown.add(FF);
        DOWNTOWNNextTown.add(KING);

        // Third Node - MAYPEN
        List<vertex> MAYPENNextTown = new ArrayList<>();
        MAYPENNextTown.add(DOWNTOWN);
        MAYPENNextTown.add(PAPINE);

        // Third Node - MAYPEN
        List<vertex> kingNextTown = new ArrayList<>();
        kingNextTown.add(HWT);
        kingNextTown.add(DOWNTOWN);

        // Third Node - CROSSROAD
        List<vertex> CROSSROADNextTown = new ArrayList<>();
        SPAINNextTown.add(FF);

        Map<vertex, List<vertex>> map = new HashMap<>();

//        map.put(KING,kingNextTown);
        map.put(HWT,HWTNextTown);
        map.put(PAPINE,PAPINENextTown);
//        map.put(MAYPEN,MAYPENNextTown);
//        map.put(DOWNTOWN,DOWNTOWNNextTown);
//        map.put(SPAIN,SPAINNextTown);
//        map.put(FF,FFNextTown);
//        map.put(CROSSROAD,CROSSROADNextTown);

        graph newGraph = new graph(map);



        for ( Map.Entry<vertex, List<vertex>> e : newGraph.getAdjacentVertices().entrySet()){
            // Printing key-value pairs
            System.out.println(e.getKey().getnode() + " "
                    + e.getValue());
            for (vertex val: e.getValue()){
                System.out.println(e.getKey().getnode()+"------"+val.getnode()+" --- Distance "+ val.getDistance() +" --- Heuristic " + val.getHeuristic());
            }

        }

    }
}
