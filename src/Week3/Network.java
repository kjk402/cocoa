package Week3;


import java.net.InetAddress;
import java.util.Enumeration;
import java.util.List;
import java.net.*;

public class Network {

    public static void ping(String add) {
        try {
            InetAddress pingcheck = InetAddress.getByName(add);
            boolean reachable = pingcheck.isReachable(2000);

            for (int i = 0; i<6; i++) {
                if (reachable) {
                    System.out.print("!");
                    Thread.sleep(500);
                }
                else {
                    System.out.print(".");
                    Thread.sleep(500);
                }
            }



            System.out.println(" ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void nsLookUp(String add) {
        InetAddress inetaddr[] = null;
        try {
            inetaddr = InetAddress.getAllByName( add );
        } catch( UnknownHostException e ) {
            e.printStackTrace();
        }
        for( int i = 0; i < inetaddr.length; i++ ) {
            System.out.println( inetaddr[i].getHostName() );
            System.out.println( inetaddr[i].getHostAddress() );
            System.out.println( "----------------------------------" );
        }
    }

    public static String getHostAddress() {
        InetAddress localAddress = getLocalAddress();
        if (localAddress == null) {
            try {
                return Inet4Address.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                ;
            }
        } else {
            return localAddress.getHostAddress();
        }


        return "";
    }

    private static InetAddress getLocalAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                List<InterfaceAddress> interfaceAddresses = networkInterfaces.nextElement().getInterfaceAddresses();
                for (InterfaceAddress interfaceAddress : interfaceAddresses) {
                    InetAddress address =interfaceAddress.getAddress();
                    if (address.isSiteLocalAddress()) {
                        System.out.println(address);
                    }
                }
            }
        } catch (Exception e) {
            ;
        }


        return null;
    }

}
