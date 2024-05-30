import java.util.*;

class Solution {
    
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0,0);
        return answer; 
        
    }
    
    static public void dfs(int[] numbers, int target, int depth, int sum){
        
        if(depth==numbers.length){ //DFS +-모두 탐색한 경우
            if(sum==target)
                answer++;
        }
        else{
            dfs(numbers, target, depth+1, sum + numbers[depth]);
            dfs(numbers, target, depth+1, sum - numbers[depth]);
        }
        
    }
           
}