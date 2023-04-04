import java.util.*;

/**
 *
 * url : https://school.programmers.co.kr/learn/courses/30/lessons/172928
 *
 * */

public class sangwoo{

    private static int width = 0;

    private static int line = 0;

    private static List<Node> nodeList = new ArrayList<Node>();

    public static void main(String[] args) {

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        System.out.println(solution3(park,routes));

    }

    public static int[] solution3(String[] park, String[] routes){
        int[] result = new int[2];

        line = park.length;
        width = park[0].length();

        int peak = 0;
        for(int i =0; i < park.length;i++){
            String[] tmpArr = park[i].split("");
            for(int j =0; j < tmpArr.length; j++){
                Node tmpNode = new Node(j,i,tmpArr[j]);
                nodeList.add(tmpNode);
                if("S".equals(tmpArr[j])) peak = nodeList.size()-1;
            }
        }

        System.out.println("peak : "+peak);

        for(String route : routes) {
            peak = movePark2(peak, route);
            System.out.println(" ing Peak : "+peak);
        }

        result[0] = nodeList.get(peak).getY();
        result[1] = nodeList.get(peak).getX();


        System.out.println(result[0]);
        System.out.println(result[1]);

        return result;
    }
    public static int movePark2(int peak, String route){

        String[] routeArr = route.split(" ");

        String derection = routeArr[0];
        int move = Integer.parseInt(routeArr[1]);

        int tmpPeak = peak;

        System.out.println("route "+route +" peak : "+peak);

        try {
            for (int i = 0; i < move; i++) {

                Node prevNode = nodeList.get(tmpPeak);
                Node thisNode = null;

                if ("W".equals(derection)) {
                    tmpPeak = tmpPeak - 1;
                } else if ("E".equals(derection)) {
                    tmpPeak = tmpPeak + 1;
                } else if ("S".equals(derection)) {
                    tmpPeak = tmpPeak + width;
                } else if ("N".equals(derection)) {
                    tmpPeak = tmpPeak - width;
                }

                thisNode = nodeList.get(tmpPeak);

                if(thisNode == null || "X".equals(thisNode.getName())) return peak;

                if("W".equals(derection) || "E".equals(derection)) {
                    if (prevNode.getY() != thisNode.getY()) return peak;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return peak;
        }

        return tmpPeak;
    }



}

class Node{

    int x;
    int y;
    String name;

    public Node(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String getName(){
        return this.name;
    }

    public String toString(){
        return " x ["+x +"] y ["+y+"] name ["+name+"]";
    }

}