// 프로그래머스 - 호텔 대실

import java.text.*;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) throws Exception {
        int answer = 0;
        
        PriorityQueue<Book> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        
        for(String[] book : book_time) {
            pq.add(new Book(parse(book[0]), parse(book[1]) + 10));
        }
        
        while(!pq.isEmpty()) {
            Book book = pq.poll();
            
            while(!pq2.isEmpty()) {
                if(pq2.peek() <= book.start)
                    pq2.poll();
                else
                    break;
            }            
            
            pq2.add(book.end);
            
            answer = Math.max(answer, pq2.size());            
        }
        
        
        return answer;
    }
    
    class Book {
        int start;
        int end;
        
        Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int parse(String time) {
        String[] str = time.split(":");
        
        return Integer.valueOf(str[0]) * 60 + Integer.valueOf(str[1]);
    }
}
