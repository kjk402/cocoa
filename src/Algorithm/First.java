package Algorithm;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/solve-me-first/problem
// 두수 입력 받고 더해주기
public class First {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("a: ");
//        int a = sc.nextInt();
//        System.out.print("b: ");
//        int b = sc.nextInt();
//        sc.close();
//        System.out.println(a+b);

        int x = 8;
        int ans = 0;
        while (x!=0) {
            x = x/2;
            ans++;
        }
        System.out.println(ans);

    }

}
