package week01;

import java.util.Scanner;

public class mon_gugu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("시작 단:");
        int n = sc.nextInt();
        System.out.print("끝 단:");
        int m = sc.nextInt();

        for(int i=n; i<=m; i++){
            System.out.println(i+"단");
                for(int j=1; j<=9; j++){
                    int k = i*j;
                    System.out.println(i+"*"+j+"="+k);
                }
                System.out.println();
        }
    }
}


