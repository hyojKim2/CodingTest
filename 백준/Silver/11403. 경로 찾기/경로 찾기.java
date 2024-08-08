import java.util.*;
import java.io.*;

public class Main {

    static int[][] graph;
    static int[] visit;
    static int[][]answer;
    static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n= Integer.parseInt(br.readLine());
        graph = new int[n][n];
        answer = new int [n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) 
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0;i<n;i++)
            BFS(i);

        for(int i=0;i<n;i++){ //결과 출력
            for(int k=0;k<n;k++)
                System.out.print(answer[i][k]+ " ");
            System.out.println();
        }


    }

    private static void BFS(int i){
        Queue<Integer> queue = new LinkedList<>();
        visit = new int[n]; //visit초기화
        queue.add(i);

        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int k=0;k< n; k++){
                if(graph[node][k]==1 && visit[k]==0){
                    visit[k]=1;
                    queue.add(k);
                    answer[i][k]=1; //i에 대하여 경로 생성
                }
            }
        }

    }
}
