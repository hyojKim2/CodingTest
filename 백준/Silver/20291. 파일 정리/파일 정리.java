import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.*;


public class Main {

    public static void main (String[] args) throws IOException{


        HashMap<String, Integer> hashMap = new HashMap<>();


        BufferedReader br= new BufferedReader(new InputStreamReader((System.in)));

        int n=Integer.parseInt(br.readLine());

        

        for(int i=0;i<n;i++){

            String str = br.readLine();
            String[] parts = str.split("\\.");
            String rightPart = parts[parts.length - 1];

            if(!hashMap.containsKey(rightPart)){
                hashMap.put(rightPart, 1);
            }
            else{
                hashMap.put(rightPart, hashMap.get(rightPart)+1);
            }
            
        }

        
        Set<String> keySet = hashMap.keySet();

        String[] keyArray=keySet.toArray(new String[0]);
        Arrays.sort(keyArray);

        for(String key:keyArray){
            System.out.println(key+ " " + hashMap.get(key));

        }

    }
    
}
