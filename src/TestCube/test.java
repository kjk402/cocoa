package TestCube;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class test {


    public static void main(String[] args) {
        String[] arr={"F", "F'", "R", "R'", "U", "U'", "B", "B'", "L", "L'", "D", "D'"};
        Random r=new Random();
        int randomValue = (int) (Math.random() * 10 +4);
        String command = "";
        for (int i=0; i<randomValue; i++){
            command = command + arr[r.nextInt(arr.length)];
        }

//        int randomNumber1=r.nextInt(arr.length);
//        int randomNumber2=r.nextInt(arr.length);
//
//        System.out.println(arr[randomNumber1]);
//        System.out.println(arr[randomNumber2]);
//        System.out.println(randomValue);
        System.out.println(command);

    }
}
