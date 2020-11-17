package Week3;

import java.io.*;
import java.util.NoSuchElementException;

public class FileControl {
    public static void ls(){
        File dir = new File("src\\Week3\\Files\\");
        File files[] = dir.listFiles();



        for (int i = 0; i < files.length; i++) {
            int idx = files[i].toString().indexOf("Files");
            System.out.print(files[i].toString().substring(idx+6)+"  ");
        }
    }
    public static void vi(String add) {
        { File file = new File(add);


            String getLine;
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while((getLine = br.readLine())!=null) {
                    System.out.print(getLine+"\r\n");

                }
                System.out.println(" ");
            } catch (IOException e) {
                e.printStackTrace();

            } catch (NoSuchElementException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void cp(String add1, String add2) {
        String origin = add1;
        String cp = add2;

        //파일객체생성
        File oriFile = new File(origin);
        //복사파일객체생성
        File copyFile = new File(cp);

        try {

            FileInputStream fis = new FileInputStream(oriFile); //읽을파일
            FileOutputStream fos = new FileOutputStream(copyFile); //복사할파일

            int fileByte = 0;
            while((fileByte = fis.read()) != -1) {
                fos.write(fileByte);
            }
            //자원사용종료
            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void rm(String add) {
        String filePath = add;

        File deleteFile = new File(filePath);
        if(deleteFile.exists()) {
            deleteFile.delete();
        }
    }
}

