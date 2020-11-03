package week01;

import java.util.Scanner;

public class TueGugudanRefatoring {


    public static int[] getGugudanInput() {
        int ret[] = new int[2];
        Scanner sc = new Scanner(System.in);
        System.out.print("시작 단:");
        ret [0] = sc.nextInt();
        System.out.print("끝 단:");
        ret [1] = sc.nextInt();
        sc.close();
        return ret;

    }

    public static void main(String[] args) {
        int[] arr = getGugudanInput();

        for(int i=arr[0]; i<=arr[1]; i++){
            System.out.println("=========="+i+"단=========");
            for(int j=1; j<=9; j++){
                int k = i*j;
                System.out.println(i+"*"+j+"="+k);
            }
            System.out.println();
        }
    }
}
