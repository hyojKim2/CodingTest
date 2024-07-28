import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<String[]> stack = new Stack<>(); // 수행할 과제를 담을 스택

        // 1. plans를 시작 시간에 대해 정렬
        Arrays.sort(plans, (d1, d2) -> {
            return makeM(d1[1]) - makeM(d2[1]);
        });

        int nowTime = makeM(plans[0][1]); // 현재 시각 초기화
        int answerIdx = 0;
        int i = 0;

        while (i < plans.length) {
            if (!stack.isEmpty() && nowTime == makeM(plans[i][1])) {
                // 스택에 멈춘 과제가 있고, 새로운 과제 시작 시간이 되면 새 과제 시작
                stack.push(new String[]{plans[i][0], String.valueOf(nowTime), plans[i][2]});
                i++;
            } else if (!stack.isEmpty() && nowTime + Integer.parseInt(stack.peek()[2]) <= makeM(plans[i][1])) {
                // 스택에 멈춘 과제가 있고, 그 과제를 끝낼 시간이 되면 멈춘 과제 재개
                String[] top = stack.pop();
                nowTime += Integer.parseInt(top[2]);
                answer[answerIdx++] = top[0];
            } else if (nowTime == makeM(plans[i][1])) {
                // 새로운 과제 시작 시간이 되면 새 과제 시작
                stack.push(new String[]{plans[i][0], String.valueOf(nowTime), plans[i][2]});
                i++;
            } else if (nowTime < makeM(plans[i][1]) && stack.isEmpty()) {
                // 새로운 과제 시작 시간이 되기 전까지 시간이 남아있고, 스택이 비어있으면 대기
                nowTime = makeM(plans[i][1]);
            } else if (!stack.isEmpty()) {
                // 스택에 멈춘 과제가 있으면 그 과제를 재개
                String[] top = stack.pop();
                int remainingTime = Integer.parseInt(top[2]) - (makeM(plans[i][1]) - nowTime);
                if (remainingTime > 0) {
                    stack.push(new String[]{top[0], String.valueOf(makeM(plans[i][1])), String.valueOf(remainingTime)});
                } else {
                    answer[answerIdx++] = top[0];
                }
                nowTime = makeM(plans[i][1]);
            }
        }

        // 남아있는 과제 처리
        while (!stack.isEmpty()) {
            String[] top = stack.pop();
            nowTime += Integer.parseInt(top[2]);
            answer[answerIdx++] = top[0];
        }

        return answer;
    }

    private static int makeM(String time) {
        String[] time_sp = time.split(":");
        return Integer.parseInt(time_sp[0]) * 60 + Integer.parseInt(time_sp[1]);
    }
}
