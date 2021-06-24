package chapter8;

import java.util.*;

/*
최대 수입 스케쥴(PriorityQueue 응용문제)
설명

현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.


예시 입력 1

6
50 2
20 1
40 2
60 3
30 3
30 1            30 + 60 + 50
예시 출력 1

150

 */
class Lecture implements Comparable<Lecture>{
    int date,money;
    public Lecture(int d,int m){
        this.date = d;
        this.money = m;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.date - this.date;
    }
}

public class 최대수입스케쥴 {
    public int solution(ArrayList<Lecture> list){
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);

        int max = list.get(0).date;

        int j = 0;
        for (int i = max; i >=1; i--){
            for (; j < list.size(); j++){
                System.out.println(j);
                if (i > list.get(j).date) break;
                q.offer(list.get(j).money);
            }
            if (!q.isEmpty()) {
                answer += q.poll();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Lecture> list =new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            list.add(new Lecture(d,m));
        }
        System.out.println(new 최대수입스케쥴().solution(list));
    }
}
