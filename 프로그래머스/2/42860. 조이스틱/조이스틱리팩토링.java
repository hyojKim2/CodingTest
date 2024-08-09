import java.util.*;
import java.io.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int maxChunk=0;//바꾸지 않을 'A...' 문자열 덩어리의 최대길이
        int tempChunk= 0; //Chunk의 임시길이
        int[] keyIdx = new int[2]; // tempChunk의 양 끝 idx
        int lastIdx=0;// 문자열에서 바꿔야할 문자의 마지막 idx를 저장

        /*
        1. 문자별로 바꿔야할 횟수를 구해야할 것 같다.
        2. 커서 변경 최소 횟수
            바꿔야할 문자들을, 최소로 접근할 수 있는 방법을 알아야할 것 같다.
            시작문자~keyIdx[0] 최소거리와 시작문자~keyIdx[1] 최소거리 중 작은 것을 a, 큰 것을 b라할때,  
            min(a*2 + b > lastIdx )
            ex)
            10000001 -> 1 vs 7 ->lastIdx인 7
            01001000 -> 6 vs 4 ->a*2+ b인 6
         */

        for(int i=0;i<name.length();i++){
            if(name.charAt(i)!='A'){ //문자가 A가 아닐때(바꿔야함)
                //상 or 하 커서 조작시 최소 거리 구하기
                int distance=Math.abs(name.charAt(i) - 'A');
                answer+= Math.min(distance, 26-distance);
                lastIdx=i;

                //좌우 조작시 거리 구하기 위한 요소 계산
                // 'A..' 최대길이 덩어리에 대해 좌우 인덱스 구하기
                if(tempChunk>maxChunk) {
                    maxChunk = tempChunk;
                    keyIdx[0] = i - tempChunk - 1;
                    keyIdx[1] = i;
                }
                tempChunk=0; //'A'가 나왔으므로 chunk 초기화해주기
            }
            else{
                tempChunk++; //'A'덩어리 길이 세어주기
            }
        }

        int a=Math.min(keyIdx[0], name.length()-keyIdx[1]); //시작~ keyIdx 원소 중 최소거리
        int b= Math.max(keyIdx[0], name.length()-keyIdx[1]); //시작~ keyIdx 원소 중 최대거리

        return answer+ Math.min( 2*a + b, lastIdx);
    }
}
