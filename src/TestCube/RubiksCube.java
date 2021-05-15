package TestCube;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RubiksCube {
    List<char[][]> cube;
    Scanner sc;

    public RubiksCube() {
        sc = new Scanner(System.in);
        cube = new ArrayList<>();
    }

    public static void main(String[] args) {
        RubiksCube rc = new RubiksCube();
        rc.initCube();
        rc.printCube();
        rc.process();
    }

    private void process() {
        int cnt = 0;
        final long startTime = System.currentTimeMillis();
        while (true) {
            System.out.print("CUBE> ");
            String command = sc.nextLine();
            command = processCommand(command);

            if (command.charAt(0) == 'Q') break;
            cnt++;
            System.out.println(command);
            parse(command);
        }
        final long endTime = System.currentTimeMillis();
        printExit(endTime - startTime, cnt);
    }

    private void printExit(long runTime, int cnt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        //Date resultDate = new Date(runTime);

        //System.out.println("경과시간: " + simpleDateFormat.format(resultDate));
        System.out.println("조작갯수: " + cnt);
        System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
    }

    private String processCommand(String command) {
        command = command.toUpperCase();
        command = command.replace("F'", "f");
        command = command.replace("R'", "r");
        command = command.replace("U'", "u");
        command = command.replace("B'", "b");
        command = command.replace("L'", "l");
        command = command.replace("D'", "d");
        command = command.replace("F2", "1");
        command = command.replace("R2", "2");
        command = command.replace("U2", "3");
        command = command.replace("B2", "4");
        command = command.replace("L2", "5");
        command = command.replace("D2", "6");
        return command;
    }

    private void parse(String command) {
        for (char cmd : command.toCharArray()) {
            printCommand(cmd);

            if (cmd == 'F') rotateCW(2, 1);
            if (cmd == 'f') rotateCCW(2, 1);
            if (cmd == 'R') rotateSideCW(2, 1);
            if (cmd == 'r') rotateSideCCW(2, 1);
            if (cmd == 'U') rotateTopCW(0, 1);
            if (cmd == 'u') rotateTopCCW(0, 1);
            if (cmd == 'B') rotateCCW(0, 1);
            if (cmd == 'b') rotateCW(0, 1);
            if (cmd == 'L') rotateSideCW(0, 1);
            if (cmd == 'l') rotateSideCCW(0, 1);
            if (cmd == 'D') rotateTopCCW(2, 1);
            if (cmd == 'd') rotateTopCW(2, 1);

            if (cmd == '1') rotateCW(2, 2); // F2
            if (cmd == '2') rotateSideCW(2, 2); // R2
            if (cmd == '3') rotateTopCW(0, 2); // U2
            if (cmd == '4') rotateCCW(0, 2); // B2
            if (cmd == '5') rotateSideCW(0, 2); // L2
            if (cmd == '6') rotateTopCCW(2, 2); // D2

            printCube();
        }
    }

    private void printCommand(char cmd) {
        if (cmd >= 'a' && cmd <= 'z') {
            System.out.println(Character.toUpperCase(cmd) + "'");
        } else if (cmd >= '1' && cmd <= '6') {
            if (cmd == '1') System.out.println("F2");
            if (cmd == '2') System.out.println("R2");
            if (cmd == '3') System.out.println("U2");
            if (cmd == '4') System.out.println("B2");
            if (cmd == '5') System.out.println("L2");
            if (cmd == '6') System.out.println("D2");
        } else {
            System.out.println(cmd);
        }
    }

    private void rotateCW(int i, int count) { // rotate (ClockWise) Front / Reverse Backward
        while (count != 0) {
            char[] tempLine = cube.get(4)[i];
            cube.get(4)[i] = cube.get(3)[i];
            cube.get(3)[i] = cube.get(2)[i];
            cube.get(2)[i] = cube.get(1)[i];
            cube.get(1)[i] = tempLine;
            count--;
        }
    }

    private void rotateCCW(int i, int count) { // rotate (CounterClockWise) Reverse Front / Backward
        while (count != 0) {
            char[] tempLine = cube.get(1)[i];
            cube.get(1)[i] = cube.get(2)[i];
            cube.get(2)[i] = cube.get(3)[i];
            cube.get(3)[i] = cube.get(4)[i];
            cube.get(4)[i] = tempLine;
            count--;
        }
    }


    private void rotateSideCW(int i, int count) { // rotate Right / Reverse Left
        while (count != 0) {
            for (int j = 0; j < 3; j++) {
                char tempBlock = cube.get(0)[j][i];
                cube.get(0)[j][i] = cube.get(2)[j][i];
                cube.get(2)[j][i] = cube.get(5)[j][i];
                cube.get(5)[j][i] = cube.get(4)[j][i];
                cube.get(4)[j][i] = tempBlock;
            }
            count--;
        }
    }

    private void rotateSideCCW(int i, int count) { // rotate Reverse Right / Left
        while (count != 0) {
            for (int j = 0; j < 3; j++) {
                char tempBlock = cube.get(4)[j][i];
                cube.get(4)[j][i] = cube.get(5)[j][i];
                cube.get(5)[j][i] = cube.get(2)[j][i];
                cube.get(2)[j][i] = cube.get(0)[j][i];
                cube.get(0)[j][i] = tempBlock;
            }
            count--;
        }
    }

    private void rotateTopCW(int i, int count) { // rotate Up / Reverse Down
        while (count != 0) {
            for (int j = 0; j < 3; j++) {
                char tempBlock = cube.get(5)[i][j];
                cube.get(5)[i][j] = cube.get(3)[j][i];
                cube.get(3)[j][i] = cube.get(0)[2 - i][j];
                cube.get(0)[2 - i][j] = cube.get(1)[j][2 - i];
                cube.get(1)[j][2 - i] = tempBlock;
            }
            count--;
        }
    }

    private void rotateTopCCW(int i, int count) { // rotate Reverse Up / Down
        while (count != 0) {
            for (int j = 0; j < 3; j++) {
                char tempBlock = cube.get(1)[j][2 - i];
                cube.get(1)[j][2 - i] = cube.get(0)[2 - i][j];
                cube.get(0)[2 - i][j] = cube.get(3)[j][i];
                cube.get(3)[j][i] = cube.get(5)[i][j];
                cube.get(5)[i][j] = tempBlock;
            }
            count--;
        }
    }

    private void initCube() {
        for (int i = 0; i < 6; i++)
            cube.add(new char[3][3]);
        for (char[] row : cube.get(0))
            Arrays.fill(row, 'B');
        for (char[] row : cube.get(1))
            Arrays.fill(row, 'W');
        for (char[] row : cube.get(2))
            Arrays.fill(row, 'O');
        for (char[] row : cube.get(3))
            Arrays.fill(row, 'G');
        for (char[] row : cube.get(4))
            Arrays.fill(row, 'Y');
        for (char[] row : cube.get(5))
            Arrays.fill(row, 'R');
    }

    private void printCube() {
        printFace(cube.get(0));
        printBody();
        printFace(cube.get(5));
    }

    private void printBody() {
        for (int i = 0; i < 3; i++) {
            for (int idx = 1; idx <= 4; idx++) {
                char[][] face = cube.get(idx);
                for (int j = 0; j < 3; j++)
                    System.out.print(face[i][j] + " ");
                for (int j = 0; j < 6; j++)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printFace(char[][] face) {
        for (char[] line : face) {
            for (int i = 0; i < 18; i++)
                System.out.print(" ");
            for (char block : line)
                System.out.print(block + " ");
            System.out.println();
        }
        System.out.println();
    }

}