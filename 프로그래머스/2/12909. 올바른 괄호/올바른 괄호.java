import java.util.Stack; //스택 라이브러리 

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<Character> stack = new Stack<>(); //주어진 s의 문자를 담을 빈 스택 생성.
        
        // stack에 차례대로 삽입하여 알맞은 '()'꼴이 생기면 pop하기. for문을 모두 통과했을 때 stack이 empty면 올바른 문장
        for( int i=0;i<s.length() ; i++){ //String에 대하여 한 문자씩 접근
            
            if(stack.isEmpty()== true && s.charAt(i) == ')') //스택이 비어있는데 ) 가 push되면 틀린 문장
                return answer;
            if(stack.isEmpty()!= true && stack.peek()=='(' && s.charAt(i)==')'){ 
                //스택이 비어져 있지 않고, 스택의 top과 s.charAt[i]가 알맞은 괄호 짝이면 스택 top을 pop
                stack.pop();
            }
            else 
                stack.push(s.charAt(i));//스택에 push
            
        }
        
        if(stack.isEmpty()==true) //스택이 비어있는지 검사. 
            answer=true;
        
        return answer;
    }
}
