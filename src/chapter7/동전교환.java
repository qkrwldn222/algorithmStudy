package chapter7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
동전교환
설명

다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

각 단위의 동전은 무한정 쓸 수 있다.


입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,

그 다음금액 M(줄에 거슬러 줄 1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.


출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.


예시 입력 1

3
1 2 5
15
예시 출력 1
3

 */
public class 동전교환 {
    static int m, answer = Integer.MAX_VALUE, depth;

    public void DFS(int depth,int sum,int[] arr){
        if (sum > m) return;
        if(depth >= answer) return;

        if (sum == m){
            answer = Integer.min(answer,depth);
        }
        for (int i = 0; i < arr.length; i++){
            DFS(depth+1,sum + arr[i],arr);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        new 동전교환().DFS(0,0,arr);
        System.out.println(answer);
    }
}
