import java.util.*;
import java.io.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int chunkLen= 0; //안 바꿀 문자열 덩어리의 최대길이
        int maxChunk=0;
        int[] keyIdx = new int[2]; // chunkLen의 양 끝 idx
        int lastIdx=0;// 문자열에서 바꿔야할 문자의 마지막 idx를 저장

        /*
        1. 문자별로 바꿔야할 횟수를 구해야할 것 같다.
        2. 커서 변경 횟수
            바꿔야할 문자들을, 최소로 접근할 수 있는 방법을 알아야할 것 같다.
             min( keyIdx[0]*2 + (name.len() - keyIdx[1]) > lastIdx )
            10000001 -> 1 vs 7
            01001000 -> 6 vs 4
         */

        for(int i=0;i<name.length();i++){
            if(name.charAt(i)!='A'){ //문자가 A가 아닐때(바꿔야함)
                int distance=Math.abs(name.charAt(i) - 'A');
                answer+= Math.min(distance, Math.abs(26-distance));
                System.out.println(distance + " "  +answer);
                //상 or 하 커서 조작시 더 빨리 도달할 수 있는 방향의 이동횟수
                lastIdx=i;

                if(chunkLen>maxChunk){ //좌우 조작 관련
                    maxChunk=chunkLen;
                    keyIdx[0]=i-chunkLen -1;
                    keyIdx[1]=i;
                    chunkLen=0;
                }
                else{ //chunkLen<=maxChunk면 초기화해주기
                    chunkLen=0;
                }
            }
            else{
                chunkLen++;
            }

        }

        System.out.println(keyIdx[0] + " " + keyIdx[1] + " " + lastIdx +" answer: "+answer );
        int a=Math.min(keyIdx[0], name.length()-keyIdx[1]);
        int b= Math.max(keyIdx[0], name.length()-keyIdx[1]);
        answer+= Math.min( 2*a + b, lastIdx);


        return answer;
    }
}