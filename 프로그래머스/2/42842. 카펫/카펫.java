class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        /*
        a=가로의 길이
        b=세로의 길이
        brown_x = 가로의 길이= a
        brown_y = 세로의 길이 =b
        yellow_x=가로의 길이-2 =a-2
        yellow_y=세로의 길이-2=b-2
        brown 개수 = 2a+2(b-2) = 2(a+b)-4
        yellow 개수 = 2(a-2) + 2((b-2)-2) = 2(a+b) - 12
        a*b= brown_개수+yellow_개수 = 2(a+b) -16
        
        a>=b
        */
        int a=0; //가로
        int b=0; //세로
        
        answer = new int[2];
        
        //a+b= (brown+4)/2; //이 안에서 조합구하기
        a=(brown+4)/2-1; b=1; //기본 세팅
        while(a>=b){
            if(a*b==brown+yellow)
            {
                answer[0]=a;
                answer[1]=b;
                return answer;
            }
            a--;
            b++;
        }
        
        
        
        return answer;
    }
}