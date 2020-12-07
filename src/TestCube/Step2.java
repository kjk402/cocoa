package TestCube;

import java.util.Scanner;

public class Step2 {
    private static String[][] left(Integer num, String[][] arr) {
        String temp = arr[num][0];
        for (int i=1; i<3; i++) {
            arr[num][i-1] =arr[num][i];
        }
        arr[num][2] = temp;
        return arr;
    }
    private static String[][] right(Integer num, String[][] arr) {
        String temp = arr[num][2];
        for (int i=2; i>0; i--) {
            arr[num][i] =arr[num][i-1];
        }
        arr[num][0] = temp;
        return arr;
    }

    private static String[][] up(Integer num, String[][] arr) {
        String temp = arr[0][num];
        for (int i=1; i<3; i++) {
            arr[i-1][num] = arr[i][num];
        }
        arr[2][num] = temp;
        return arr;
    }

    private static String[][] down(Integer num, String[][] arr) {
        String temp = arr[2][num];
        for (int i=2; i>0; i--) {
            arr[i][num] = arr[i-1][num];
        }
        arr[0][num] = temp;
        return arr;
    }

    private static void printing(String[][] arr) {
        for (String[] i : arr) {
            for (String j : i) {
                System.out.printf("%s\t", j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[][] cube = {
                {"R", "R", "W"},
                {"G", "C", "W"},
                {"G", "B", "B"}
        };
        printing(cube);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("CUBE> ");
            String command = sc.nextLine();
            if (command.equals("Q")) {
                System.out.println("Bye~");
                return;
            }
            String[] shell = command.split("");
            for (int t = 0; t<command.length(); t++) {
                if (shell[t].equals("'")) {
                    shell[t-1] = shell[t-1]+shell[t];
                }
            }
            for (int k = 0; k<command.length(); k++) {
                if (shell[k].equals("U")) {
                    left(0,cube);
                }
                if (shell[k].equals("U'")) {
                    right(0,cube);
                }
                if (shell[k].equals("B")) {
                    right(2,cube);
                }
                if (shell[k].equals("B'")) {
                    left(2,cube);
                }
                if (shell[k].equals("R")) {
                    up(2,cube);
                }
                if (shell[k].equals("R'")) {
                    down(2,cube);
                }
                if (shell[k].equals("L")) {
                    down(0,cube);
                }
                if (shell[k].equals("L'")) {
                    up(0,cube);
                }

                if (shell[k].equals("'")){
                    continue;
                }
                else {
                    System.out.println(shell[k]);
                }
                printing(cube);
            }

        }

    }
}