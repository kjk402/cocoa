package Week3;



public class Property {
    public static void pwd(){
        String rootPath = System.getProperty("user.dir");;
        System.out.println(rootPath);
    }

    public static void javaVersion() {
        String version = System.getProperty("java.version");
        String vendor = System.getProperty("java.vendor");
        System.out.print(" " +version +" " +vendor);
    }

    public static void osInfo() {
        String name = System.getProperty("os.name");
        String version = System.getProperty("os.arch");

        System.out.println(name);
        System.out.println(version);
    }
}
