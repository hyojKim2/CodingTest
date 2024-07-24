import java.util.*;


class Solution {
    
    static HashMap<String, String> map;  //영단어:숫자 해시맵
    
    public int solution(String s) {
        int answer = 0;
        String numbers="";
        String now="";
        
        map= new HashMap<>();
        makeMap();
        
        for(int i=0;i<s.length(); i++){
            char c= s.charAt(i);
            now+=c;
            if(map.containsKey(now)){
                now=map.get(now);
            }
            if(now.chars().allMatch(Character::isDigit)){ //문자열이 정수로 이루어져있다면
                numbers+=now;
                now="";
            }
            
            
        }
        
        return Integer.parseInt(numbers);
    }
    
    static private void makeMap(){ //영단어:숫자 해시맵 생성
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
    }
}