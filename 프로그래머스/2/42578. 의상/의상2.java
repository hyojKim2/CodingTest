import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> multiMap = new HashMap<String, List<String>>();

        for(int i=0;i<clothes.length; i++){
            if(multiMap.containsKey(clothes[i][1])==false){
                multiMap.put(clothes[i][1], new ArrayList<String>()); //의상종류 Key가 없으면 키 추가하고 빈 리스트 추가 
            }
            multiMap.get(clothes[i][1]).add(clothes[i][0]);//의상 종류에 의상 이름 value 추가
        }
    
        int answer = 1;
        
        
        for(String key: multiMap.keySet()){
            answer*= (multiMap.get(key).size() +1) ;
        }

        return answer-1;
    }
    
}
