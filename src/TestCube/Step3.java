package TestCube;

import java.util.*;

public class Step3 {

    public static String[] commandChange(String[] shell) {
        int cnt1 = 0;
        for (int t= 0; t<shell.length; t++) {
            if (shell[t].equals("'")) {
                shell[t-1] = shell[t-1]+shell[t];
                cnt1 = cnt1 +1;
            }
        }
        List<String> list = new ArrayList<>(Arrays.asList(shell));
        while (cnt1 !=0) {
            list.remove("'");
            cnt1 --;
        }
        shell = list.toArray(new String[list.size()]);

        for (int j= 0; j<shell.length; j++) {
            if (shell[j].equals("2")) {
                shell[j] = shell[j-1];
            }
        }
        return shell;
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
    public static String random() {
        String[] arr={"F", "F'", "R", "R'", "U", "U'", "B", "B'", "L", "L'", "D", "D'"};
        Random r=new Random();
        int randomValue = (int) (Math.random() * 10 +1);
        String randomCommand = "";
        for (int i=0; i<randomValue; i++){
            randomCommand = randomCommand + arr[r.nextInt(arr.length)];
        }
        return randomCommand;
    }
    public static void commandExcution(String[] shell, int k, String[][] cube) {
        if (shell[k].equals("U")) {
            MovingCube.left(3,cube);
            MovingCube.rightRotate(3,0,cube);
        }
        if (shell[k].equals("U'")){
            MovingCube.right(3,cube);
            MovingCube.leftRotate(0,3,cube);
        }
        if (shell[k].equals("D'")) {
            MovingCube.left(5,cube);
            MovingCube.leftRotate(6,3,cube);
        }
        if (shell[k].equals("D")){
            MovingCube.right(5,cube);
            MovingCube.rightRotate(3,6,cube);
        }
        if (shell[k].equals("R")) {
            MovingCube.up(5,9,cube);
            MovingCube.rightRotate(6,3,cube);
        }
        if (shell[k].equals("R'")) {
            MovingCube.down(5,9,cube);
            MovingCube.leftRotate(3,6,cube);
        }
        if (shell[k].equals("L'")) {
            MovingCube.up(3,11,cube);
            MovingCube.leftRotate(3,0,cube);
        }
        if (shell[k].equals("L")) {
            MovingCube.down(3,11,cube);
            MovingCube.rightRotate(0,3,cube);
        }
        if (shell[k].equals("F'")) {
            MovingCube.leftswift(2,6,cube);
            MovingCube.leftRotate(3,3,cube);
        }
        if (shell[k].equals("F")) {
            MovingCube.rightswift(2,6,cube);
            MovingCube.rightRotate(3,3,cube);
        }
        if (shell[k].equals("B")) {
            MovingCube.leftswift(0,8,cube);
            MovingCube.rightRotate(9,3,cube);
        }
        if (shell[k].equals("B'")) {
            MovingCube.rightswift(0,8,cube);
            MovingCube.leftRotate(3,9,cube);
        }
    }

    public static Integer compare(String[][] arr) {
        String[][] origin = {
                {" "," "," ", "B", "B", "B1"},
                {" "," "," ","B", "B", "B2"},
                {" "," "," ","B", "B", "B3"},
                {"W1", "W2", "W3", "O", "O", "O1", "G1", "G", "G", "Y1", "Y", "Y"},
                {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y2", "Y", "Y"},
                {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y3", "Y", "Y"},
                {" "," "," ",   "R", "R", "R1"},
                {" "," "," ","R", "R", "R"},
                {" "," "," ","R", "R", "R"}
        };
        int c= 0;
        for (int i =0; i<9; i++) {
            for (int j = 0; j<6; j++){
                if(arr[i][j].equals(origin[i][j])){
                    c ++;
                }
            }
        }
        for (int q=3; q<6; q++) {
            for (int w=6; w<12; w++) {
                if(arr[q][w].equals(origin[q][w])){
                    c ++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String[][] cube = {
                {" "," "," ", "B", "B", "B1"},
                {" "," "," ","B", "B", "B2"},
                {" "," "," ","B", "B", "B3"},
                {"W1", "W2", "W3", "O", "O", "O1", "G1", "G", "G", "Y1", "Y", "Y"},
                {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y2", "Y", "Y"},
                {"W", "W", "W", "O", "O", "O", "G", "G", "G", "Y3", "Y", "Y"},
                {" "," "," ",   "R", "R", "R1"},
                {" "," "," ","R", "R", "R"},
                {" "," "," ","R", "R", "R"}
        };
        printing(cube);
        System.out.println();
        int finalcount = 0;

        long beforeTime = System.currentTimeMillis();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("CUBE> ");
            String command = sc.nextLine();

            if (command.equals("Q")) {
                long afterTime = System.currentTimeMillis();
                long min = (afterTime - beforeTime)/60000;
                long sec = (afterTime - beforeTime)/1000;
                if (sec>59) {
                    sec = sec%60;
                }
                System.out.println("경과시간: "+min +":"+sec);
                System.out.println("조작 갯수: "+finalcount);
                System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
                return;
            }
            if (command.equals("random")) {
                command = random();
            }
            String[] shell = command.split("");
            shell = commandChange(shell);
            for (int k = 0; k<shell.length; k++) {
                commandExcution(shell,k,cube);


                System.out.println(shell[k]);
                finalcount ++;
                printing(cube);

                int count = compare(cube);
                if (count==72) {
                    long afterTime = System.currentTimeMillis();
                    long min = (afterTime - beforeTime)/60000;
                    long sec = (afterTime - beforeTime)/1000;
                    if (sec>59) {
                        sec = sec%60;
                    }
                    System.out.println("경과시간: "+min +":"+sec);
                    System.out.println("모든 면을 맞추셨습니다. 축하드립니다.!!");
                    return;
                }
            }
        }
    }
}
