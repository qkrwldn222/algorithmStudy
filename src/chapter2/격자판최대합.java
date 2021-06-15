package chapter2;

import java.util.Scanner;

/*
5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
최대합을 출력합니다.


예시 입력 1

5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19
예시 출력 1

155
 */
public class 격자판최대합 {
    public int solution(int[][] arr, int n){
        int answer = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                tmp1 += arr[i][j];
                tmp2 += arr[j][i];
            }
            answer = Math.max(tmp1,answer);
            answer = Math.max(tmp2,answer);
            tmp1 = 0;
            tmp2 = 0;
        }
        for (int y = 0; y < n ; y++){
            tmp1 += arr[y][y];
            tmp2 += arr[y][n-y-1];
        }
        answer = Math.max(tmp1,answer);
        answer = Math.max(tmp2,answer);

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(new 격자판최대합().solution(arr,n));
    }
}

