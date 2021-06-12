package chapter1;

import java.util.Scanner;

/*

가장 짧은 문자거리
설명

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


예시 입력 1

teachermode e
예시 출력 1

1 0 1 2 1 0 1 2 2 1 0

 */
public class 가장짧은문자거리 {
    public int[] solution(String str,char tar){
        int[] answer = new int[str.length()];
        int p = 100;
        for(int x = 0; x < str.length(); x++){
            if(str.charAt(x) == tar){
               p = 0;
               answer[x] = p;
            }else{
                p++;
                answer[x] = p;
            }
        }
        p = 100;
        for (int z = str.length()-1; z >= 0; z--){
            if(str.charAt(z) == tar){
                p = 0;
            }else{
                p++;
                answer[z] = Math.min(p,answer[z]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char ch = sc.next().charAt(0);
        System.out.println(str + " " + ch);
        for(int i : new 가장짧은문자거리().solution(str,ch)){
            System.out.print( i+ " " );
        }
    }
}
