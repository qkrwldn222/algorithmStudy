package chapter7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
섬나라 아일랜드
설명

N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

Image1.jpg

만약 위와 같다면 섬의 개수는 5개입니다.


입력
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 격자판 정보가 주어진다.


출력
첫 번째 줄에 섬의 개수를 출력한다.


예시 입력 1

7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
예시 출력 1

5

 */

public class 섬나라아일랜드BFS {
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int[][] arr;
    static int answer = 0,n;
    static Queue<Point> q = new LinkedList<>();

    public void BFS(){
        while (!q.isEmpty()){
            Point p = q.poll();
            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (nx >=0 && nx < n && ny>=0 && ny<n && arr[nx][ny]==1){
                       arr[nx][ny] = 0;
                       q.offer(new Point(nx,ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j]==1){
                    answer++;
                    arr[i][j] = 0;
                    q.offer(new Point(i,j));
                    new 섬나라아일랜드BFS().BFS();
                }
            }
        }
        System.out.println(answer);
    }
}
