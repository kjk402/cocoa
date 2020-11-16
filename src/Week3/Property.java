package Week3;



public class Property {
    public static void pwd(){
        String rootPath = System.getProperty("user.dir");;
        System.out.println(rootPath);
    }

    public static void javaVersion() {
        String version = System.getProperty("java.version");
        System.out.println("Java " +version);
    }

    public static void osInfo() {
        String name = System.getProperty("os.name");
        String version = System.getProperty("java.home");

        System.out.println(name);
        System.out.println(version);
    }
}
