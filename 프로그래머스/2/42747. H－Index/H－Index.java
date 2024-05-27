import java.util.*;



class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙선언

        for(int citation : citations)
            pq.add(citation);
        
        int h= 0; //h번 이상 인용된 논문 개수를 센다.  
        //  n>=h이다. 
        
        while(h < pq.peek() ){ //h가 힙의 루트 노트보다 작은 동안
            pq.poll(); // 루트 노트 삭제 
            h++;
            if(pq.size()==0) // 힙이 사이즈가 0일때, 런타임 에러 방지
                return h;
        }
        
        return h;
    }
}
