// 2910 빈도정렬

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(" ");
		
		int N = Integer.valueOf(str[0]);
		int C = Integer.valueOf(str[1]);
		int idx = 1;
		Map<String, Integer> cntMap = new HashMap<>();
		Map<String, Integer> idxMap = new HashMap<>();
		
		str = br.readLine().split(" ");
		
		for(String x : str) {
			cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
			
			if(!idxMap.containsKey(x))
				idxMap.put(x, idx++);
		}
		
		List<Obj> list = new ArrayList<>();
		
		for(String key : cntMap.keySet()) {
			list.add(new Obj(key, idxMap.get(key), cntMap.get(key)));
		}
		
		Collections.sort(list, (o1, o2) -> {
				if(o1.cnt == o2.cnt)
					return o1.idx - o2.idx;
				else
					return o2.cnt - o1.cnt;
				
			});
		
		for(Obj obj : list) {
			for(int i = 0; i < obj.cnt; i++) {
				bw.append(obj.num + " ");
			}
//			System.out.println(obj.num + " : " + obj.cnt + " : " + obj.idx);
		}
		
		bw.flush();
		bw.close(); 
	}
	
	public static class Obj {
		String num;
		int idx;
		int cnt;
		
		Obj(String num, int idx, int cnt) {
			this.num = num;
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}
