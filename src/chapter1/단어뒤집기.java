package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
4. 단어 뒤집기
설명
N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.

예시 입력 1
3
good
Time
Big

예시 출력 1

doog
emiT
giB
 */
public class 단어뒤집기 {
    public List solution(String[] str){
        ArrayList<String> list = new ArrayList<String>();
        // StringBuilder 리버스 사용코드
        for(String x : str){
            list.add(new StringBuilder().reverse().toString());
        }
        // 직접 교환
        for(String x : str){
            char[] a = x.toCharArray();
            int lt = 0; int rt = a.length-1;
            while(lt < rt){
                char tmp = a[lt];
                a[lt] = a[rt];
                a[rt] = tmp;
                lt++;
                rt--;
            }
            list.add(String.valueOf(a));
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] str = new String[a];
        for(int i = 0; i < a; i++){
            str[i] = sc.nextLine();
        }
        List list = new 단어뒤집기().solution(str);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
