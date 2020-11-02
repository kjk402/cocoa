package week01;

import java.util.Scanner;

public class mon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("시작 단수:");
        int n = sc.nextInt();
        System.out.print("끝 단수:");
        int m = sc.nextInt();
        int i, j;
        for(i=n; i<=m; i++){
            System.out.println(i+"단");
                for(j=1; j<=9; j++){
                    int k = i*j;
                    System.out.println(i+"*"+j+"="+k);
                }
                System.out.println();
        }
    }
}
