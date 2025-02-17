package PCCP.프로그래머스;
import java.util.*;

public class 마법주문 {
    public static String solution(long n, String[] bans) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(bans)); // 삭제된 주문들을 저장
        long[] countByLength = new long[12]; // 길이별 주문 개수 저장 (1~11)

        // 길이별 문자열 개수 계산
        for (int i = 1; i <= 11; i++) {
            countByLength[i] = (long) Math.pow(26, i);
        }

        // 현재 n번째 주문이 몇 글자인지 찾기
        int length = 0;
        long total = 0;
        for (int i = 1; i <= 11; i++) {
            long validCount = countByLength[i] - countBanned(i, bannedSet);
            if (total + validCount >= n) {
                length = i;
                break;
            }
            total += validCount;
        }

        // n번째 주문 찾기
        StringBuilder order = new StringBuilder();
        long remaining = n - total; // 해당 길이에서 몇 번째인지 찾기
        findNthOrder(order, length, remaining, bannedSet);
        return order.toString();
    }

    // 특정 길이의 문자열 중 삭제된 개수를 반환
    private static long countBanned(int length, Set<String> bannedSet) {
        long count = 0;
        for (String ban : bannedSet) {
            System.out.println(ban);
            if (ban.length() == length) {
                count++;
            }
        }
        return count;
    }

    // n번째 주문 찾기 (DFS 방식)
    private static void findNthOrder(StringBuilder order, int length, long n, Set<String> bannedSet) {
        for (char c = 'a'; c <= 'z'; c++) {
            order.append(c);
            long count = countValidOrders(order.toString(), length, bannedSet);
            if (n <= count) {
                if (order.length() < length) {
                    findNthOrder(order, length, n, bannedSet);
                }
                return;
            }
            order.deleteCharAt(order.length() - 1);
            n -= count;
        }
    }

    // 현재 prefix로 시작하는 문자열 중 bans에 포함되지 않은 개수 계산
    private static long countValidOrders(String prefix, int targetLength, Set<String> bannedSet) {
        if (bannedSet.contains(prefix)) {
            return 0;
        }
        int remainingLength = targetLength - prefix.length();
        return (long) Math.pow(26, remainingLength);
    }

    // 테스트
    public static void main(String[] args) {
        System.out.println(solution(30, new String[]{"d", "e", "bb", "aa", "ae"})); // "ah"
        System.out.println(solution(7388, new String[]{"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"})); // "jxk"
    }
}




