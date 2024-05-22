import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>(); //형변환 위한 arrayList 
        
        int start=0; //100% 완료 프로그레스 검사용 변수
        int done=0; // 완료한 프로그레스 수
        
        while(done<progresses.length){
            start=done; 
            
            for( int k=done;k<progresses.length; k++) //speeds 만큼 progresses에 더해줌
                progresses[k] = Math.min( 100, progresses[k] +speeds[k]);
            
            int finish=0; //100%완료된 프로그레스 임시 저장 변수 
            if(progresses[start] == 100){ //현재 progresses의 완료된 것 이후부터 검사 
                while(start<progresses.length){
                    if(progresses[start]!=100) //100이 아니면 break
                        break;
                    done++;  start++; finish++;
                }
                if(finish!=0) //finish된 progresses가 존재하면 answerList에 add
                    answerList.add(finish);
            }
        }

        answer = answerList.stream().mapToInt(i -> i).toArray(); //arrayList to array 형변환
        return answer;
    }
}
