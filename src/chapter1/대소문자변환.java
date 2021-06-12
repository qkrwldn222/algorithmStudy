package chapter1;

//설명
//
//        대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
//
//
//        입력
//        첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
//
//        문자열은 영어 알파벳으로만 구성되어 있습니다.
//
//
//        출력

import java.util.Scanner;

public class 대소문자변환 {
    public String solution(String str){
        String answer = "";
        for(char a : str.toCharArray()){
            if(Character.isUpperCase(a)) answer += Character.toLowerCase(a);
            else answer += Character.toUpperCase(a);
        }

        return answer;
    }

    public static void main(String[] args) {
        대소문자변환 t = new 대소문자변환();
        Scanner sc = new Scanner(System.in);
        String search = sc.nextLine();
        System.out.println(t.solution(search));
    }
}
