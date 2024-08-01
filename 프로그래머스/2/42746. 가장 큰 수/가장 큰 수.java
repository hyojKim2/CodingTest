import java.util.*;

class Solution {
    public String solution(int[] numbers)
    {
        String answer="";
        String[] nums=new String[numbers.length];

        for(int i=0;i<numbers.length;i++)
            nums[i]=String.valueOf(numbers[i]);

        Arrays.sort(nums , (o1, o2)->{
            return (o2+o1).compareTo(o1+o2); //
        });

        for(String num:nums)
            answer+=num;

        return (answer.charAt(0)=='0')? "0" : answer; //입력이 모두 0인 경우 처리
    }

}