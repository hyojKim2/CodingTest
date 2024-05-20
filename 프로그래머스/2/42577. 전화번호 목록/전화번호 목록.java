import java.util.Scanner;
import java.util.Arrays;


class Solution {
    public boolean solution(String[] phone_book) {
        Scanner sc = new Scanner(System.in);
        
        Arrays.sort(phone_book); //sort 
        boolean answer = true;
        
        for(int i=0;i< phone_book.length-1; i++){
        
            if(phone_book[i+1].startsWith(phone_book[i])){
                    answer=false;
                    break;
                }
        }
        
        return answer;
    }
}