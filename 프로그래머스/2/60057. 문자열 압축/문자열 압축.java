import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        
        
        int s_length= s.length();

        if(s_length==1)
            return 1;
        ArrayList<Integer> numbers=new ArrayList<>(); //길이를 저장
        for (int i=s_length/2 ; i >0 ;i--){

            
            String recentString =s.substring(0, i); //이전에 자른 substring
            int loc = i;
            int cnt=1;
            int zip=0;
            int converted = 0; //압축된 총 길이 result를 담는 변수

            while(loc<=s_length){

                String currentString = "";
                if(loc + i > s_length){
                    currentString = s.substring(loc, s_length);
                }
                else {
                    currentString = s.substring(loc, i+loc);
                }

                if(recentString.equals(currentString)){
                    cnt++;
                }
                else{
                    if(cnt!=1){
                        converted+=Integer.toString(cnt).length()+recentString.length();
                    }
                    else{
                        converted+=recentString.length();
                    }

                    zip+=cnt*i;

                    recentString = currentString;
                    cnt = 1;
                }

                loc += i;
            }

            converted += s_length -zip;

            numbers.add(converted);
           

        }

        int answer= Collections.min(numbers);
        return answer;

    }
}