import java.util.*;

class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(); //힙 선언

        for(int i: nums) //원소 offer 
            pq.offer(i);

        while(pq.size()>2){ //size가 2가 될때까지 poll
            pq.poll();
        }

        return (pq.poll()-1) * (pq.poll()-1) ;    
    }
}