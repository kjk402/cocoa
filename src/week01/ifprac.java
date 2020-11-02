package week01;

import java.util.Scanner;


//1번 (1330 두수 비교하기)
/*
public class ifprac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        if(n>m) System.out.println(">");
        else if (n<m) System.out.println("<");
        else System.out.println("==");


    }

}
*/

//2번 (9498 시험 성적)
/*
public class ifprac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n>=90) System.out.println("A");
        else if (n>=80) System.out.println("B");
        else if (n>=70) System.out.println("C");
        else if (n>=60) System.out.println("D");
        else System.out.println("F");
    }

}

 */


//3번 (2753 윤년)
/*
public class ifprac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n%4==0 && (n%100 !=0 || n%400 ==0)) System.out.println(1);
        else System.out.println(0);

    }

}

*/

//4번 (14681 사분면 고르기)
/*
public class ifprac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        if(n>1 && m>1) System.out.println(1);
        else if (n>1 && m<1) System.out.println(4);
        else if (n<1 && m>1) System.out.println(2);
        else if (n<1 && m<1) System.out.println(3);
    }

}

 */

//5번 (2753 알람시계)

/*
public class ifprac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();


        if(m<45) {
            n--;
            m= 60 - (45-m);
            if (n<0) {
                n =23;
            }
            System.out.println(n+" "+m);
        }
        else {
            System.out.println(n+" "+(m-45));
        }
    }

}
*/


// 6번 (11720 숫자의합)

/*
public class ifprac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String a = sc.next();
        // 문자열로 받아서 한 글자씩 받기

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a.charAt(i) - '0';
        }
        System.out.print(sum);
    }
}

*/





