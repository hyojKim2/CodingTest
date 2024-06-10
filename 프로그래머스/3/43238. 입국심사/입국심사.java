import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        //left는 0, right는 최대시간, mid는 right로 초기 세팅한다
        long left=0; 
        long right=  (long) times[times.length-1] * n ; // 최악의 경우, 배열이니까 length
        long mid ;
        long answer= right ;
        
        while(left<=right){ //이진탐색
            mid=(left+right) / 2; //중간값
            long entryPeople= calcuEntry( mid, times); //mid시간일때 통과한 사람들
            
            
            if (entryPeople >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid+1 ;
            }
            
        }
        
        return answer;
        
    }
    
    static private long calcuEntry(long mid, int[]times){ //mid시간을 times 요소들로 나눈 값을 더했을 때, 몇명인지 반환
        
        long sum=0;
        for(int time:times){
            sum+= mid/time ;
        }
        return sum;
        
    }
}