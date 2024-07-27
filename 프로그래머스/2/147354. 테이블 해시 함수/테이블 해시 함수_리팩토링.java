import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        //1. 테이블의 튜플 정렬하기.
        Arrays.sort(data, (d1, d2)-> {
               if(d1[col-1]==d2[col-1]){ //두 값이 같으면 첫 번재 컬럼 값 기준으로 내림차순 정렬
                   return Integer.compare(d2[0], d1[0]);
               }
               return Integer.compare(d1[col-1], d2[col-1]);
        });

        
        
        //2. S_i구하기 + xor 연산
        
        for(int i=row_begin-1;i<row_end;i++){
            int temp=0;
            for(int number:data[i]){
                temp+=number%(i+1);
            }
            answer^=temp;
        }
        

        return answer;
    }
}
