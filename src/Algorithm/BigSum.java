package Algorithm;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/a-very-big-sum/problem
// Long 으로 변환해서 더하기

public class BigSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String ar = sc.nextLine();
        sc.close();

        String[] as = ar.split(" ");
        long sum = 0;
        for (int i = 0; i < Integer.parseInt(a); i++) {
            long aa = Long.parseLong(as[i]);
            sum = sum+aa;
        }
        System.out.println(sum);
    }

}

/*
6
1000000001 1000000002 1000000003 1000000004 1000000005 1000000006

 */