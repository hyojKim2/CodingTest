import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] answer = {};
         ArrayList<Integer> answerList = new ArrayList<>();
        
        
        int start=0;
        int done=0;
        int idx=0;
        while(done<progresses.length){
            start=done;
            
            for( int k=done;k<progresses.length; k++){
                progresses[k] = Math.min( 100, progresses[k] +speeds[k]);
            System.out.print(progresses[k]+" ");
            }
            System.out.println();
            
            int finish=0;
            if(progresses[start] == 100){
                while(start<progresses.length){
                    if(progresses[start]!=100)
                        break;
                    done++;
                    start++;
                    finish++;
                    
                }
                if(finish!=0)
                    answerList.add(finish);
            }
        }

        System.out.println(answerList);
        answer = new int[answerList.size()];
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}