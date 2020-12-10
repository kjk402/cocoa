package TestCube;

public class MovingCube {
    public static String[][] left(Integer num, String[][] arr) {
        String temp1 = arr[num][0];
        String temp2 = arr[num][1];
        String temp3 = arr[num][2];
        for (int i=3; i<12; i++) {
            arr[num][i-3] = arr[num][i];
        }
        arr[num][9] =temp1;
        arr[num][10] =temp2;
        arr[num][11] = temp3;
        return arr;
    }
    public static String[][] right(Integer num, String[][] arr) {
        String temp1 = arr[num][9];
        String temp2 = arr[num][10];
        String temp3 = arr[num][11];

        for (int i=11; i>2; i--) {
            arr[num][i] =arr[num][i-3];
        }
        arr[num][0] = temp1;
        arr[num][1] = temp2;
        arr[num][2] = temp3;
        return arr;
    }
    public static String[][] up(Integer num1, Integer num2, String[][] arr) {
        String temp1 = arr[0][num1];
        String temp2 = arr[1][num1];
        String temp3 = arr[2][num1];
        String temp4 = arr[3][num2];
        String temp5 = arr[4][num2];
        String temp6 = arr[5][num2];
        for (int i=3; i<9; i++) {
            arr[i-3][num1] = arr[i][num1];
        }
        arr[3][num2] = temp3;
        arr[4][num2] = temp2;
        arr[5][num2] = temp1;
        arr[6][num1] = temp6;
        arr[7][num1] = temp5;
        arr[8][num1] = temp4;
        return arr;
    }
    public static String[][] down(Integer num1, Integer num2, String[][] arr) {
        //5 9
        String temp1 = arr[6][num1];
        String temp2 = arr[7][num1];
        String temp3 = arr[8][num1];

        String temp4 = arr[3][num2];
        String temp5 = arr[4][num2];
        String temp6 = arr[5][num2];

        for (int i=8; i>2; i--) {
            arr[i][num1] = arr[i-3][num1];
        }
        arr[3][num2] = temp3;
        arr[4][num2] = temp2;
        arr[5][num2] = temp1;
        arr[0][num1] = temp6;
        arr[1][num1] = temp5;
        arr[2][num1] = temp4;
        return arr;
    }
    public static String[][] leftswift(Integer num1, Integer num2, String[][] arr) {
        String temp1 = arr[3][num2];
        String temp2 = arr[4][num2];
        String temp3 = arr[5][num2];
        String temp4 = arr[num1][5];
        String temp5 = arr[num1][4];
        String temp6 = arr[num1][3];
        String temp7 = arr[3][num1];
        String temp8 = arr[4][num1];
        String temp9 = arr[5][num1];
        String temp10 = arr[num2][5];
        String temp11 = arr[num2][4];
        String temp12 = arr[num2][3];
        arr[num1][3] = temp1;
        arr[num1][4] = temp2;
        arr[num1][5] = temp3;
        arr[3][num1] = temp4;
        arr[4][num1] = temp5;
        arr[5][num1] = temp6;
        arr[num2][3] = temp7;
        arr[num2][4] = temp8;
        arr[num2][5] = temp9;
        arr[3][num2] = temp10;
        arr[4][num2] = temp11;
        arr[5][num2] = temp12;
        return arr;
    }
    public static String[][] rightswift(Integer num1, Integer num2, String[][] arr) {
        String temp1 = arr[3][num2];
        String temp2 = arr[4][num2];
        String temp3 = arr[5][num2];
        String temp4 = arr[num1][5];
        String temp5 = arr[num1][4];
        String temp6 = arr[num1][3];
        String temp7 = arr[3][num1];
        String temp8 = arr[4][num1];
        String temp9 = arr[5][num1];
        String temp10 = arr[num2][5];
        String temp11 = arr[num2][4];
        String temp12 = arr[num2][3];
        arr[num1][3] = temp9;
        arr[num1][4] = temp8;
        arr[num1][5] = temp7;
        arr[3][num1] = temp12;
        arr[4][num1] = temp11;
        arr[5][num1] = temp10;
        arr[num2][3] = temp3;
        arr[num2][4] = temp2;
        arr[num2][5] = temp1;
        arr[3][num2] = temp6;
        arr[4][num2] = temp5;
        arr[5][num2] = temp4;
        return arr;
    }
    public static String[][] rightRotate(Integer num1, Integer num2,String[][] arr) {
        String[][] B = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                B[i][j] = arr[num2+3-j-1][num1+i];
            }
        }
        for (int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                arr[num2+i][num1+j]=B[i][j];
            }
        }
        System.out.println();
        return arr;
    }
    public static String[][] leftRotate(Integer num1, Integer num2,String[][] arr) {
        String[][] B = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                B[i][j] = arr[num1+j][num2+3-i-1];
            }
        }
        for (int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                arr[num1+i][num2+j]=B[i][j];
            }
        }
        return arr;
    }
}
