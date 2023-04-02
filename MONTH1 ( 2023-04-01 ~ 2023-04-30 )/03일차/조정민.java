// 프로그래머스 - 광물캐기

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        answer = fn(picks[0], picks[1], picks[2], minerals, -5, "");
        
        return answer;
    }
    
    public int fn(int dia, int iron, int stone, String[] minerals, int cnt, String pick) {        
        int cost = 0;
        int min = Integer.MAX_VALUE;            
        
        if(!pick.equals("")) {
            for(int i = 0; i < 5; i++) {
                if(i+cnt == minerals.length) {                    
                    // System.out.println(cost + " dia = " + dia + " iron = " + iron + " stone = " + stone);
                    return cost;}
                
                if(minerals[i+cnt].equals("diamond")) {
                    if(pick.equals("dia")) {
                        cost += 1;
                    } else if(pick.equals("iron")) {
                        cost += 5;
                    } else if(pick.equals("stone")) {
                        cost += 25;
                    }           
                } else if(minerals[i+cnt].equals("iron")) {
                    if(pick.equals("stone")) {
                        cost += 5;
                    } else {
                        cost += 1;
                    }
                } else if(minerals[i+cnt].equals("stone")) {
                    cost += 1;
                }
            }
        }        
        
        // System.out.println(cost + " dia = " + dia + " iron = " + iron + " stone = " + stone);
        
        if(dia > 0) {
            min = Math.min(fn(dia - 1, iron, stone, minerals, cnt + 5, "dia"), min);
        }
        
        if(iron > 0) {
            min = Math.min(fn(dia, iron - 1, stone, minerals, cnt + 5, "iron"), min);
        }
        
        if(stone > 0) {
            min = Math.min(fn(dia, iron, stone - 1, minerals, cnt + 5, "stone"), min);
        }
        
        if(min == Integer.MAX_VALUE)
            return cost;       
        
        return min + cost;
    }
}
