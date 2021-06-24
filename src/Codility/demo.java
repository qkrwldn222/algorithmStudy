package Codility;

import java.util.Arrays;
import java.util.Scanner;

public class demo {
    int solution(int[] a){
        Arrays.sort(a);
        if (a[0] < 0) return 1;
        else {
            for (int i = 1; i < a.length; i++){

                if (a[i] - a[i-1] >= 2){
                    return a[i-1]+1;
                }
            }
        }
        return 1;
    }
//[1, 3, 6, 4, 1, 2]
//WRONG ANSWER (got 2 expected 5)
//
//Example test:   [1, 2, 3]
//WRONG ANSWER (got 1 expected 4)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(new demo().solution(arr));
    }
}
