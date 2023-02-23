package chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
미로의 최단거리 통로(BFS)
설명

7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.

경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.

출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.

격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

위와 같은 경로가 최단 경로의 길이는 12이다.


입력
첫 번째 줄부터 7*7 격자의 정보가 주어집니다.


출력
첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.


예시 입력 1

0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0
예시 출력 1

12
 */
class Point{
    int x,y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class 미로의최단거리통로 {
    int[] dy = {1,-1,0,0};
    int[] dx = {0,0,1,-1};
    static int[][] arr;
    static int[][] dis = new int[8][8];
    static int answer = -1;

    public void DFS(int x,int y,int l){
        if (answer != -1 && l > answer) return;
        if (x == 7 && y== 7) {
            if (answer == -1) answer = l;
            else answer = Math.min(answer,l);
        }else{
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >=1 && nx <= 7 && ny >=1 && ny <= 7 && arr[nx][ny]==0){
                    arr[nx][ny] = 1;
                    DFS(nx,ny,l+1);
                }
            }
        }
    }

    public void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        arr[x][y] = 1;
        while (!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >=1 && nx <=7 && ny >=1 && ny <=7 && dis[nx][ny] == 0){
                    arr[nx][ny] = 1;
                    q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }
    public void DFS2(int x, int y,int sum){
        System.out.println("x : " + x + ", y : " + y + ", sum : " + sum);

        if (answer != -1 && sum > answer) return ;
        if (x == 7 && y == 7){
            System.out.println("Sum : " + sum);
            if(answer == -1) {
                answer = sum;
            }else{
                answer = Integer.min(answer,sum);
            }
            return;
        }
        for (int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=1 && nx<=7 && ny >=1 && ny<=7 && arr[nx][ny] == 0){
                System.out.println(arr[nx][ny]);
                arr[nx][ny] = 1;
                DFS2(nx,ny,sum+1);
                arr[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[8][8];
        for (int i = 1; i <= 7; i++){
            for (int j = 1; j <= 7; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        arr[1][1]=1;
        new 미로의최단거리통로().DFS2(1,1,0);
//        new 미로의최단거리통로().BFS(1,1);
//        if (dis[7][7] == 0) System.out.println(-1);
 //       else System.out.println(dis[7][7]);
        System.out.println(answer);
    }
}
