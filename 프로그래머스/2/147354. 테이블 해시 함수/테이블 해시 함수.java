import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        //1. 테이블의 튜플 정렬하기.
        Arrays.sort(data, new Comparator<int[]>() {
           @Override
           public int compare(int [] d1, int[] d2){
               int colCompare= Integer.compare(d1[col-1], d2[col-1]);
               if(colCompare!=0){ //두 값이 같지 않으면
                   return colCompare;
               }
               // 두 값이 같으면 첫 번재 컬럼 값 기준으로 내림차순 정렬
               return Integer.compare(d2[0], d1[0]);
           }
        });

        
        
        //2. S_i구하기
        int[] S= new int [row_end - row_begin +1];
        
        for(int i=0;i<S.length;i++){
            for(int number:data[row_begin-1]){
                S[i]+=number%row_begin;
            }
            row_begin++;
        }
        
        //3. S_i값들의 비트 XOR연산 값 구하기
        int temp=S[0];
        for(int i=1;i<S.length;i++){
            temp^= S[i];
        }

        return temp;
    }
}