package PCCP.프로그래머스;

import java.util.Arrays;

/**
 *
 * 문제 설명
 * A도둑과 B도둑이 팀을 이루어 모든 물건을 훔치려고 합니다. 단, 각 도둑이 물건을 훔칠 때 남기는 흔적이 누적되면 경찰에 붙잡히기 때문에, 두 도둑 중 누구도 경찰에 붙잡히지 않도록 흔적을 최소화해야 합니다.
 *
 * 물건을 훔칠 때 조건은 아래와 같습니다.
 *
 * 물건 i를 훔칠 때,
 * A도둑이 훔치면 info[i][0]개의 A에 대한 흔적을 남깁니다.
 * B도둑이 훔치면 info[i][1]개의 B에 대한 흔적을 남깁니다.
 * 각 물건에 대해 A도둑과 B도둑이 남기는 흔적의 개수는 1 이상 3 이하입니다.
 * 경찰에 붙잡히는 조건은 아래와 같습니다.
 *
 * A도둑은 자신이 남긴 흔적의 누적 개수가 n개 이상이면 경찰에 붙잡힙니다.
 * B도둑은 자신이 남긴 흔적의 누적 개수가 m개 이상이면 경찰에 붙잡힙니다.
 * 각 물건을 훔칠 때 생기는 흔적에 대한 정보를 담은 2차원 정수 배열 info, A도둑이 경찰에 붙잡히는 최소 흔적 개수를 나타내는 정수 n, B도둑이 경찰에 붙잡히는 최소 흔적 개수를 나타내는 정수 m이 매개변수로 주어집니다. 두 도둑 모두 경찰에 붙잡히지 않도록 모든 물건을 훔쳤을 때, A도둑이 남긴 흔적의 누적 개수의 최솟값을 return 하도록 solution 함수를 완성해 주세요. 만약 어떠한 방법으로도 두 도둑 모두 경찰에 붙잡히지 않게 할 수 없다면 -1을 return해 주세요.
 *
 * 제한사항
 * 1 ≤ info의 길이 ≤ 40
 * info[i]는 물건 i를 훔칠 때 생기는 흔적의 개수를 나타내며, [A에 대한 흔적 개수, B에 대한 흔적 개수]의 형태입니다.
 * 1 ≤ 흔적 개수 ≤ 3
 * 1 ≤ n ≤ 120
 * 1 ≤ m ≤ 120
 * 테스트 케이스 구성 안내
 * 아래는 테스트 케이스 구성을 나타냅니다. 각 그룹 내의 테스트 케이스를 모두 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.
 *
 * 그룹	총점	테스트 케이스 그룹 설명
 * #1	15%	info[i][1] = 1
 * #2	40%	info의 길이 ≤ 20
 * #3	45%	추가 제한 사항 없음
 * 입출력 예
 * info	n	m	result
 * [[1, 2], [2, 3], [2, 1]]	4	4	2
 * [[1, 2], [2, 3], [2, 1]]	1	7	0
 * [[3, 3], [3, 3]]	7	1	6
 * [[3, 3], [3, 3]]	6	1	-1
 *
 * 풀이
 * ->  배열의 길이만큼 for문을 돌리고
 * N,M을 넘지 않는 모든 수중에 작은 수를 구한다(A를 선택한 경우와, B를 선택한 경우)
 * 에서 A의 값을 배열에 저장 후 가장 작은 배열A의 값을 찾음
 */
public class 완전범죄 {
    public static void main(String[] arr){
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 4, 4)); // 2
        System.out.println(solution(new int[][]{{1, 2}, {2, 3}, {2, 1}}, 1, 7)); // 0
        System.out.println(solution(new int[][]{{3, 3}, {3, 3}}, 7, 1)); // 6
        System.out.println(solution(new int[][]{{3, 3}, {3, 3}}, 6, 1)); // -1
    }

    public static int solution(int arr[][],int n, int m){
        int result = Integer.MAX_VALUE;

        int[][] dp = new int[121][121];

        for(int[] array : dp){
            Arrays.fill(array, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for(int i = 0; i < arr.length; i++){
            int traceA = arr[i][0];
            int traceB = arr[i][1];

            // 정방향 업데이트 (0 → n-1 방향으로 진행)
            int[][] newDP = new int[n][m];
            for (int[] row : newDP) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            for(int a = 0; a < n; a++){
               for(int b = 0; b < m; b++){
                    if(dp[a][b] == Integer.MAX_VALUE) continue;

                    int newA = a + traceA;
                    if(newA < n ){
                        newDP[newA][b] = Math.min(newDP[newA][b], dp[a][b] + traceA);
                    }

                   int newB = b + traceB;
                   if(newB < m ){
                       newDP[a][newB] = Math.min(newDP[a][newB], dp[a][b]);
                   }
               }
            }
            dp = newDP;
        }

        for(int a = 0; a < n; a++ ){
            for(int b = 0; b < m; b++){
                if(dp[a][b] != Integer.MAX_VALUE) result = Math.min(result, dp[a][b]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
