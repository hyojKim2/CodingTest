import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a=Math.max(arrayA[0], arrayB[0]); //각 배열에서 최소수 중 더 큰 수로 처음 검사.. 점점 작아짐
        
        int A_a=a;
        int A_b=a;
        
        while(a>=2){
            
            A_a=a;
            A_b=a;
            a--;

            //가장 작은수로 나눌 수 모든 배열의 수를 나눌 수 있는지 체크 
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i]%A_a!=0 || arrayB[i]%A_a==0)
                {
                    A_a=0;
                    break;
                }
            }

            for(int i=0;i<arrayB.length;i++){
                if(arrayB[i]%A_b!=0 || arrayA[i]%A_b==0 )
                {
                    A_b=0;
                    break;
                }
            }
            
            if(A_b!=0 || A_a!=0)
                return Math.max(A_b, A_a);
            
        }
        
      
        
        return 0;
        
    }
}