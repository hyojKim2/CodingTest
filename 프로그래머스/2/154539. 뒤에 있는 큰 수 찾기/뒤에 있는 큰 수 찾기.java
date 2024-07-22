import java.util.*;

//이중 for문 시간초과->스택으로

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length]; //배열의 length는 속성이므로 괄호x
        
        Stack<Integer> stack = new Stack<>();//인덱스를 순서대로 담을 스택
        
        int idx=0; //answer용 인덱스
       
        for(int i=0;i<numbers.length-1;i++){
            stack.push(i);//인덱스를 넣어줌
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i+1]){ // 스택이 비어있지 않고, stack.peek() < 뒷큰수일때
                answer[stack.pop()]=numbers[i+1]; //answer의 해당 pop의 인덱스에 뒷 큰수를 넣어줌
            }
        }
       
        while(!stack.isEmpty()){ //스택을 비우고 -1넣어줌.
            answer[stack.pop()]=-1;
        }
        answer[numbers.length-1]=-1;
        
        return answer;
        
    }
}