import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.*;


public class Main {

    public static void main (String[] args) throws IOException{


        HashSet<String> set = new HashSet<>(); //가능한 문자열을 담는 해시셋


        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));

        

        String str = br.readLine();

        for(int i=0;i<str.length(); i++){
            String newStr="";
            for(int k=i; k<str.length();k++){
                newStr+=str.charAt(k);
                if(!set.contains(newStr)){ //newStr이 해시셋에 없다면
                    set.add(newStr);
                }
            }

        }

        System.out.println(set.size());

    }
    
}
