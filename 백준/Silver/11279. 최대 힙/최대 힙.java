import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{ //(String[] args는 명령줄 인수로, 터미널, cmd등에서 프로그램을 실행할 때 인수를 전달할 수 있는 기능

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //InputStreamReader은 system.in이 읽어들이는바이트 스트림을 문자 스트림으로 바꾸어줌.
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> MaxHeap=new PriorityQueue<>(Collections.reverseOrder()); //최대힙선언

        int n=Integer.parseInt(br.readLine());
        //br.read()는 한 문자를 읽어 아스키코드값을 반환하며, readLine()은 문자열을 읽어들임.

        for(int i=0;i<n;i++){
            int x= Integer.parseInt(br.readLine());

            if(x==0){
                if(MaxHeap.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(MaxHeap.poll()+"\n");
            }
            else{
                MaxHeap.add(x);
            }

        }

        bw.flush();
        bw.close();
        br.close();


    }
}