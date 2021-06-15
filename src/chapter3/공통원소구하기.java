package chapter3;

import java.util.*;

/*
공통원소 구하기
설명

A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

각 집합의 원소는 1,000,000,000이하의 자연수입니다.


출력
두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


예시 입력 1

5
1 3 9 5 2
5
3 2 5 7 8
예시 출력 1

2 3 5

 */
public class 공통원소구하기 {
    public List<Integer> solution(int[] a, int[] b){
        ArrayList<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < a.length; i++){
//            for (int j = 0; j < b.length; j++){
//                if (a[i] == b[j]) {
//                    list.add(a[i]);
//                }
//            }
//        }
//        Collections.sort(list);
        // -> two pointers
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0,p2=0;
        while (p1 < a.length && p2 < b.length){
            if (a[p1] == b[p2]) {
                list.add(a[p1++]);
                p2++;
            }else if(a[p1] < b[p2]) p1++;
            else p2++;
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr1 = new int[x];
        for (int i = 0; i < x; i++){
            arr1[i] = sc.nextInt();
        }
        int y = sc.nextInt();
        int[] arr2 = new int[y];
        for (int j = 0; j < y; j++){
            arr2[j] = sc.nextInt();
        }
        for (int z : new 공통원소구하기().solution(arr1,arr2)) System.out.print(z + " ");
    }
}
