package programmers.level0;

import java.util.*;

// 2의 영역 : https://school.programmers.co.kr/learn/courses/30/lessons/181894
public class Solution181894 {
    public static int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> idxQ = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                idxQ.add(i);
            }
        }

        if (!idxQ.isEmpty()) {
            for (int i = idxQ.getFirst(); i <= idxQ.getLast(); i++) {
                answer.add(arr[i]);
            }
        }
        else {
            answer.add(-1);
        }
        return answer.stream().mapToInt(i -> i).toArray();


        /* DFS 풀이
        // 앞쪽 2의 위치 저장용 변수
        int front = -1;
        // 각 원소를 앞에서부터 살펴본다
        for (int i = 0; i < arr.length; i++) {
            // 2를 찾으면
            if (arr[i] == 2) {
                // 위치를 기록하고 반복 종료
                front = i;
                break;
            }
        }
        // 만약 2르 찾지 못했다면 front는 여전히 -1일 것이다.
        if (front == -1) {
            return new int[]{-1};
        }

        // 뒤쪽 2의 위치 저장용 변수
        int back = 0;
        // 각 원소를 뒤에서부터 살펴본다.
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] == 2) {
                back = i;
                break;
            }
        }

        // 필요한 길이의 배열을 만들고 수동으로 값을 넣어주기
        int[] answer = new int[back - front + 1];
        // arr[front] - arr[back] 까지 answer 에 할당한다.
        for (int i = 0; i < back - front + 1; i++) {
            answer[i] = arr[i + front];
        }

        // 배열 복사 (자동)
        Arrays.copyOfRange(arr, front, back + 1);

        return answer;
        * */
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 4, 5, 2, 9};
        int[] arr2 = {1, 2, 1};
        int[] arr3 = {1, 1, 1};
        int[] arr4 = {1, 2, 1, 2, 1, 10, 2, 1};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
        System.out.println(Arrays.toString(solution(arr3)));
        System.out.println(Arrays.toString(solution(arr4)));
    }
}
