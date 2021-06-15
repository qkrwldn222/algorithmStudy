package chapter4;

import java.util.HashMap;
import java.util.Scanner;

/*

모든 아나그램 찾기
설명

S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


예시 입력 1

bacaAacba
abc
예시 출력 1

3

 */
public class 모든아나그램 {
    // map 끼리 equlas 가능, charAt 사용
    public int solution(String str1,String str2){
        int answer = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for (char x : str2.toCharArray()) map2.put(x,map2.getOrDefault(x,0)+1);

        char[] ch = str1.toCharArray();
        for (int i = 0 ; i < str2.length()-1; i++){
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
        }
        int lt = 0,count=0;
        for (int rt = str2.length()-1; rt < str1.length(); rt++){
            map.put(ch[rt],map.getOrDefault(ch[rt],0)+1);
            count = 0;

            for (char x : map2.keySet()){
                if (map.get(x) == map2.get(x)) count++;
            }
            if (map2.size() == count) answer++;

            map.put(ch[lt],map.get(ch[lt])-1);
            if (map.get(ch[lt])==0) map.remove(ch[lt]);
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(new 모든아나그램().solution(str1,str2));
    }
}
