package Algorithm;
//https://www.hackerrank.com/challenges/compare-the-triplets/problem

import java.util.Scanner;

public class Comparing {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();
        String[] aa = a.split(" ");
        String[] bb = b.split(" ");

        int ascore = 0;
        int bscore = 0;
        for (int i = 0; i < aa.length; i++) {
            int as = Integer.parseInt(aa[i]);
            int bs = Integer.parseInt(bb[i]);

            if (as >bs ){
                ascore++;
            }
            if (as ==bs ) {
                continue;
            }
            if (as < bs) {
                bscore++;
            }
        }
        System.out.println(ascore+" "+bscore);
    }

}
