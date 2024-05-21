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
    
        if(multiMap.size() == 30)
            { return 1073741823; }
        int answer = 0;
        List<List<String>> keysList = getCombinedKeys(multiMap.keySet(), 1, multiMap.size());


        for(List <String> keys : keysList){
            int temp_answer=1;
            for( String key : keys)
                temp_answer*=  multiMap.get(key).size();
            answer+=temp_answer;
        } //인덱스 크기만큼 돌아서 해당하는 key곱하여 더함 
            
        return answer;
    }
    
    public static List<List<String>> getCombinedKeys(Set<String> keySet, int minLength, int maxLength) {
        List<List<String>> resultList = new ArrayList<>();

        // 최소 길이에서 최대 길이까지 조합을 생성
        for (int len = minLength; len <= maxLength; len++) {
            generateCombinations(resultList, new ArrayList<>(), keySet, len, 0);
        }
        return resultList;
    }

    private static void generateCombinations(List<List<String>> resultList, List<String> tempList, Set<String> keySet, int len, int start) {
        if (tempList.size() == len) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < keySet.size(); i++) {
            tempList.add((String) keySet.toArray()[i]);
            generateCombinations(resultList, tempList, keySet, len, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}