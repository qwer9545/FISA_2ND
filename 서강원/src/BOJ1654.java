import java.util.*;

public class BOJ1654 {

    public static void main(String[] args) {
        // 입력 처리
        Scanner sc = new Scanner(System.in);
        // 주어진 랜선 K개
        int K = sc.nextInt();
        // 구하려는 개수 N개
        int N = sc.nextInt();        
        // System.out.println(K + " " + N);

        // K개의 데이터 배열로 저장
        int[] arr = new int[K];
        long max = 0; 
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        sc.close();
        // System.out.println(Arrays.toString(arr));
        // System.out.println(max);

        // (1) 완전 탐색
        // ...

        // (2) 이분 탐색
        // 1. 최소값 2. 최대값 3. 중앙값.
        // 최소 + 최대 / 2 => 중앙값
        // 최대값 + 1
        // 1, 1, 1, 1, .... 1 ~ 2
        long start = 0; // 탐색을 시작 길이
        long mid = 0; // 중간 길이
        // 이분 탐색을 위해 최대값에 1을 더해줌 (탐색 시 범위 문제)
        long end = max + 1; // 탐색의 끝점

        // 이분 탐색 진행
        // 시작값과 종료값이 일치하는가?
        while (start < end) { // start : min, end: max
            // 중간 길이를 계산
            mid = (start + end) / 2; // long -> 정수

            // 중간 길이로 잘랐을 때 만들어지는 랜선 개수 계산
            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid); // 남는 건 버려지기 때문에
                // 몫으로 count를 진행
            }

            // 이진 탐색의 조건
            if (count < N) { // 중간길이로 나눴을 때의 랜선의 길이가
                // 목표하는 N보다 작다 -> 목표하는 최적 길이보다 중간값 길이가 길다
                // 중간값이 우리가 찾는 최적 길이보다 크다
                end = mid; // 끝점을 중간값으로 옮겨옴 (커서를 왼쪽으로 붙여서 더 짧은 쪽의 범위를 탐색)
            } else { // 크거나 같을 때 
                // 왼쪽 커서를 중앙점으로 옮기는 작업
                start = mid + 1; // 최대값을 찾는 작업
            }

            // 최종적으로 탐색이 멈추는 경우
            // start, end가 일치해서 더이상 탐색되지 않는 길이
            // max -> end. 탐색을 위한 범위를 만들려고 +.
        }
        System.out.println(start - 1);        
    }
}