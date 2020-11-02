package week01;

import java.util.Scanner;

// 1번
/*
public class mon_star {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/

// 2번

/*
public class mon_star {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print("");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

 */

//3번

/*
public class mon_star {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        for (int i = 1; i <= N; i++) {
            for (int j = N; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/


//4번
/*
public class mon_star {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        for (int i = 0; i < N; i++) {
            for (int j =0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < N-i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/


//5번
/*
public class mon_star {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i*2-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/

//6번
/*
public class mon_star {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        for (int i = N-1; i >=0; i--) {
            for (int j =1; j < N-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i*2+1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/

//7번

/*
public class mon_star {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        in.close();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < i*2-1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = N-2; i >=0; i--) {
            for (int j =1; j < N-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i*2+1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/

//8번


















