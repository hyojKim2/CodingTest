import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> defeat; //내가 이기는 선수
    static ArrayList<ArrayList<Integer>> lose; //내가 지는 선수
    //각 ArrayList를 BFS 탐색했을 때 방문한 노드의 수 합이 n이면 순위를 매길 수 있음
    static int people;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        people=n;
        
        defeat = new ArrayList<>(n + 1);
        lose = new ArrayList<>(n + 1);
        for(int i = 0 ; i <= n ; i++) { //선수 크기에 맞게 defeat, lose arrayList만들기 
            defeat.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        

        
        for (int[] result : results) {
			int me = result[0];
			int opponent = result[1];
			defeat.get(me).add(opponent); //내가 이긴 선수 추가 
			lose.get(opponent).add(me); //내가 지는 선수 추가 
		}

        
        for(int i=0;i<=n;i++){
            if(BFS(i, defeat) +BFS(i, lose)==n-1)
                answer++;
        }
        
        return answer;
    }
    
    static public int BFS( int me, ArrayList<ArrayList<Integer>> array){
        boolean []visit =new boolean[people+1];
        Queue<Integer> q  = new LinkedList<>(); 
        
        int answer=0;
        
        
        q.add(me); //큐에 추가
        visit[me]=true; //방문처리
        
        while(!q.isEmpty()){
            int now=q.poll();//큐에서 원소 빼기
            for(int opp:array.get(now)){
                if(!visit[opp]){
                    q.add(opp);
                    answer++;
                    visit[opp]=true;
                }
            }
        }
        
       // System.out.printf("me: %d, answer: %d\n", me, answer);

        return answer;
        
    }
}