package 백준.Knapsack;

import java.util.Scanner;

/*
입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스의 첫 번째 줄에는 동전의 가지 수 N(1 ≤ N ≤ 20)이 주어지고 두 번째 줄에는 N가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다. 각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다. 세 번째 줄에는 주어진 N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)이 주어진다.

편의를 위해 방법의 수는 231 - 1 보다 작고, 같은 동전이 여러 번 주어지는 경우는 없다.
 */
public class 동전 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0; i < testCase; i++){
            int coinCnt = sc.nextInt();
            int[] coin = new int[coinCnt];
            for (int j = 0; j < coinCnt; j++) {
                coin[j] = sc.nextInt();
            }
            int amount = sc.nextInt();
            System.out.println(solution(coin, amount));
        }
        sc.close();
    }

    public static int solution(int coins[], int amount){
        int[] dp = new int[amount + 1];  // dp[i] : i원을 만드는 방법의 개수
        dp[0] = 1;  // 0원을 만드는 방법은 아무 동전도 사용하지 않는 경우 1가지

        // 각 동전별로 DP 배열 업데이트
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];  // M원을 만드는 방법의 개수 반환
    }

}
