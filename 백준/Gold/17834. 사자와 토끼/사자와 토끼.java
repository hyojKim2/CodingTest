import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> graph; // 인접 리스트로 그래프 표현
    static int[] color; // 0: 방문하지 않음, 1: 색상 1, -1: 색상 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 수풀의 수 N과 오솔길의 수 M을 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // M개의 오솔길 정보를 입력받아 그래프를 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1; // 0-based index로 변환
            int v = Integer.parseInt(st.nextToken()) - 1; // 0-based index로 변환
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 색상 배열 초기화 (모든 노드를 방문하지 않은 상태로 설정)
        color = new int[n];
        Arrays.fill(color, 0); // 처음에는 모두 방문하지 않은 상태

        boolean isBipartite = true;
        // 모든 노드를 방문하면서 이분 그래프인지 확인
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) { // 해당 노드를 방문하지 않았다면
                if (!dfs(i, 1)) { // DFS를 사용하여 이분 그래프인지 판별
                    isBipartite = false;
                    break;
                }
            }
        }

        if (isBipartite) {
            long count1 = 0, count2 = 0;
            // 색상 배열을 확인하여 두 집합의 크기를 계산
            for (int i = 0; i < n; i++) {
                if (color[i] == 1) count1++;
                else if (color[i] == -1) count2++;
            }
            // 가능한 초기 위치의 조합 수를 계산하여 출력
            System.out.println(count1 * count2 * 2);
        } else {
            // 이분 그래프가 아니면 게임이 끝나지 않는 경우는 없음
            System.out.println(0);
        }
    }

    // DFS를 사용하여 그래프가 이분 그래프인지 판별하는 함수
    static boolean dfs(int node, int c) {
        color[node] = c; // 현재 노드에 색상을 지정
        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == 0) { // 이웃 노드를 방문하지 않았다면
                if (!dfs(neighbor, -c)) { // 이웃 노드를 반대 색상으로 칠함
                    return false;
                }
            } else if (color[neighbor] == color[node]) {
                // 이웃 노드가 현재 노드와 같은 색상이라면 이분 그래프가 아님
                return false;
            }
        }
        return true;
    }
}
