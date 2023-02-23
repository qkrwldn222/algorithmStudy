package CodingTest;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KakaoInternShip2021_3 {
    public static void main(String[] args) {

    }
    static String[] arr;// = {"무지","콘","어피치","제이지","프로도","네오","튜브","라이언"};
    public String solution(int n, int k, String[] cmd){
        String answer ="";
        arr = new String[n];
        for (int i = 0; i < n; i++){
            arr[i] = String.valueOf(i);
        }
        Queue<String> q = new LinkedList<>();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < arr.length; i++){
            q.offer(arr[i]);
        }
        for (int i = 0; i < cmd.length; i++){
            String[] a = cmd[i].split(" ");
            if (a[0] == "Z"){
                stack.pop();
            }
            if (a[0] == "C"){
                stack.push();
            }
            if (a[0] == "U"){

            }
            if (a[0] == "D"){

            }
        }


        return answer;
    }
}
