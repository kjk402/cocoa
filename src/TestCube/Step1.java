package TestCube;

import java.util.Scanner;

public class Step1 {
    public static String[] left(Integer count, String[] arr, String word) {
        count = Math.abs(count);
        while (count !=0) {
            String temp = arr[0];
            for (int i=1; i<word.length(); i++) {
                arr[i-1] =arr[i];
            }
            arr[word.length()-1] = temp;
            count--;
        }
        return arr;
    }
    public static String[] right(Integer count, String[] arr, String word) {
        count = Math.abs(count);
        while (count !=0) {
            String temp = arr[word.length()-1];
            for (int i=word.length()-1; i>0; i--) {
                arr[i] =arr[i-1];
            }
            arr[0] = temp;
            count--;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> ");
        String command = sc.nextLine();
        sc.close();
        String word = command.split(" ")[0];
        String num = command.split(" ")[1];
        String direc = command.split(" ")[2];
        int count = Integer.parseInt(num);

        String[] arr = word.split("");
        if (direc.equals("l") || direc.equals("L")) {
            if (count >0){
                left(count, arr, word);
            }
            if (count <0) {
                right(count, arr, word);
            }
        }
        if (direc.equals("r") || direc.equals("R")) {
            if (count >0) {
                right(count, arr, word);
            }
            if (count <0) {
                left(count, arr, word);
            }
        }

        for (int j =0; j<word.length(); j++) {
            System.out.print(arr[j]);
        }

    }
}
