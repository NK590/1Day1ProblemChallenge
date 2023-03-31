// 프로그래머스 - 혼자서 하는 틱택토

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int o = 0;
        int x = 0;
        boolean oWin = false;
        boolean xWin = false;
        
        String[][] board2 = new String[3][3];
        
        {
            int cnt = 0;
            
            for(String a : board) {
                board2[cnt] = a.split("");
                cnt++;
            }
        }
        
        for(String[] a : board2) {
            for(String b : a) {
                if(b.equals("O")) {
                    o++;
                } else if(b.equals("X")) {
                    x++;
                }
            }
        }
        
        for(int i = 0; i < 3; i++) {
            boolean oFlag = true;
            boolean xFlag = true;
            
            for(int j = 0; j < 3; j++) {
                oFlag = oFlag && board2[i][j].equals("O");
                xFlag = xFlag && board2[i][j].equals("X");
            }
            
            if(oFlag)
                oWin = true;
            
            if(xFlag)
                xWin = true;
        }
        
        for(int i = 0; i < 3; i++) {
            boolean oFlag = true;
            boolean xFlag = true;
            
            for(int j = 0; j < 3; j++) {
                oFlag = oFlag && board2[j][i].equals("O");
                xFlag = xFlag && board2[j][i].equals("X");
            }
            
            if(oFlag)
                oWin = true;
            
            if(xFlag)
                xWin = true;
        }
        
        {
            boolean oFlag = true;
            boolean xFlag = true;
            
            for(int j = 0; j < 3; j++) {
                oFlag = oFlag && board2[j][j].equals("O");
                xFlag = xFlag && board2[j][j].equals("X");
            }
            
            if(oFlag)
                oWin = true;
            
            if(xFlag)
                xWin = true;
        }
        
        {
            boolean oFlag = true;
            boolean xFlag = true;
            
            for(int j = 0; j < 3; j++) {
                oFlag = oFlag && board2[j][2-j].equals("O");
                xFlag = xFlag && board2[j][2-j].equals("X");
            }
            
            if(oFlag)
                oWin = true;
            
            if(xFlag)
                xWin = true;
        }
        
        System.out.println(oWin + "   " + xWin);
        
        // 둘 다 이긴 경우
        if(oWin && xWin) {
            return 0;
        }
        
        // 선공이 이긴 경우
        if(oWin) {
            if(o == x + 1)
                return 1;
            else
                return 0;
        }
        
        // 후공이 이긴 경우
        if(xWin) {
            if(o == x)
                return 1;
            else
                return 0;
        }
        
        // 그 외 경우
        if(o == x + 1 || o == x)
            return 1;
        else 
            return 0;
    }
}
