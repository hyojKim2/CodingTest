import java.util.PriorityQueue;
import java.util.Collections;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
         String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 문자열을 비교하여 더 큰 순서로 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 두 문자열을 합쳐서 비교
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                // 내림차순으로 정렬
                return s2.compareTo(s1);
            }
        });

        // 정렬된 문자열을 이어붙여서 결과 생성
        StringBuilder sb = new StringBuilder();
        for (String str : strNumbers) {
            sb.append(str);
        }

        // 배열이 모두 0으로 이루어진 경우 예외 처리
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}