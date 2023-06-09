package June;

public class Jaehyuck_1w_1 {

	public static void main(String[] args) {
		    int answer = 0;
		    int [][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		    int n = 3;
	        boolean[] visited = new boolean[n];
	        
	        for(int i=0;i<n;i++){
	            if(!visited[i]){
	            	// 새로운 네트워크 시작시 
	                answer++;
	                dfs(computers,visited,i);
	            }
	        }
	       System.out.println(answer);
	}
	
	 public static void dfs(int[][] computers,boolean[] visited,int i){
		   // 네트워크에 연결 되어있으면 pass
	        if(visited[i]) return;
	        // 새방문지 
	        visited[i] = true;
	        // 현재 computer 에서 연결된곳 계속방문 
	        for(int j=0;j<computers[i].length;j++){
	            if(computers[i][j] == 1 ){
	                dfs(computers,visited,j);
	            }
	        }
	    }

}
