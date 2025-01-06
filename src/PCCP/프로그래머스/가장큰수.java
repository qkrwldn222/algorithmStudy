package PCCP.프로그래머스;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 입출력 예
 * numbers	return
 * [6, 10, 2]	"6210"
 * [3, 30, 34, 5, 9]	"9534330"
 */

/**
 * 주의 list.add(Character.getNumericValue(a));
 * return Long.parseLong(list.stream()
 *                     .map(String::valueOf)
 *                     .collect(Collectors.joining()));
 * 보기에는 굉장히 쉬운 문제 같지만 숫자 하나하나 변환 후 다시 정렬 그리고 다시 숫자로 변환하는
 * 방법을 모를경우 쪼금 어려울 수 도 있을거 같다. 위와같은 방법과 다른 방법들을 기억해 놓자...!
 */
public class 가장큰수 {
        public static void main(String[] args) {
            int[] numbers = {3,30,34,5,9};
            long solution = solution(numbers);
            System.out.println(solution(numbers));
            System.out.println(solution2(numbers));
        }
        public static long solution(int[] nunbers){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i : nunbers){
                char[] charArray = String.valueOf(i).toCharArray();
                for (char a : charArray){
                    list.add(Character.getNumericValue(a));
                }
            }
            list.sort((o1, o2) -> o2 - o1);
            return Long.parseLong(list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining()));
        }

    /**
     * 내림차순 일때 y + x주의 해야함
     * result가 0부터 시작할 경우 주의
     * List<String> result = Arrays.stream(numbers).mapToObj(n -> String.valueOf(n)).collect(Collectors.toList());
     *         Collections.sort(result, (s1, s2) -> (s2+s1).compareTo(s1+s2)); 도 가능함
     *
     * @param nunbers
     * @return result
     */
    public static String solution2(int[] nunbers){
        String[] array = Arrays.stream(nunbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (x,y) -> (y+x).compareTo(x+y));
        String result = String.join("",array);

        return result.startsWith("0") ? "0" : result;
    }

}
