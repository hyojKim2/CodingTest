import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //우선순위 큐 선언, 루트노드가 가장 작은 최소힙
        PriorityQueue<Integer> pq= new PriorityQueue<>(); 
        
        for(int i: scoville)
            pq.offer(i); //우선순위 큐에 스코빌 삽입 
        
        while(pq.peek() < K){
            pq.offer(pq.poll() + pq.poll()*2); 
            answer++;
            if( pq.peek() < K && pq.size() ==1 )
                return -1; //얼리리턴
        }
        
        return answer;
    }
}