package Week3;

import java.io.File;

public class Pwd {
    public static void pwd(){
        String rootPath = System.getProperty("user.dir");;
        System.out.println("현재 프로젝트의 경로 : "+rootPath );


    }
}
