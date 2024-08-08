import java.util.*;
import java.io.*;

public class Main {


    static List<List<Integer>> graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k=Integer.parseInt(st.nextToken());//테스트케이스 K 입력


        for(int i=0;i<k;i++){
            String ans="YES";
            // V와 E 개수 입력받음
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            color=new int[v];//컬러 초기화
            graph=new ArrayList<>();
            for(int j=0;j<v;j++){ //정점 수만큼 그래프 초기화
                graph.add(new ArrayList<>());
            }
            for(int j=0;j<e;j++){ //노드-노드 연결
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) -1;
                int y = Integer.parseInt(st.nextToken())-1;
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            for(int j=0;j<v;j++){ //이분 그래프인지 확인
                if(color[j]==0){//방문하지 않았다면
                    if(!DFS(j, 1)){ //DFS를 통해 이분 그래프인지 판별
                        ans="NO";//이분 그래프가 아닐시
                        break;
                    }
                }
            }
            System.out.println(ans); //결과출력
        }

    }

    private static boolean DFS(int v, int c){
        color[v]=c;//색 칠해줌
        for(int neighbor:graph.get(v)){
            if(color[neighbor]==0){ //neighbor를 아직 칠하기전(방문전)이면
                if(!DFS(neighbor,-c))
                    return false;
            }
            else if(color[neighbor]==color[v]){
                return false;
            }
        }
        return true;

    }
}
