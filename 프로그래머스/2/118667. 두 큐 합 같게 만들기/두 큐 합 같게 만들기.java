import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int limit=(queue1.length +queue2.length)*2; //두 큐의 합만큼 순회하하면 더 이상 진행불가 

        long sum1= Arrays.stream(queue1).sum();
        long sum2= Arrays.stream(queue2).sum();
        long target= (sum1+sum2)/2;

        Queue<Integer> q1= new LinkedList<Integer>();
        Queue<Integer> q2= new LinkedList<>();

        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }


        while(sum1!=target && answer<=limit){
            int temp=0;
            if(sum1>sum2){
                temp = q1.poll();
                q2.add(temp);
                sum1-=temp;
                sum2+=temp;
            }
            else{
                temp = q2.poll();
                q1.add(temp);
                sum2-=temp;
                sum1+=temp;

            }
            answer++;
        }

        if(answer>limit)
            return -1;
        return answer;
    }
}