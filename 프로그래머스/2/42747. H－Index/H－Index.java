import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int citation : citations)
            pq.add(citation);
        
        int cnt= 0; //h번 이상 인용된 논문 개수 
        
        int preCit=pq.peek(); 
        while(cnt < pq.peek() ){
            preCit = pq.poll(); // 탑반환 
            cnt++;
            if(pq.size()==0)
                return cnt;
        }
        
        
        return cnt;
    }
}