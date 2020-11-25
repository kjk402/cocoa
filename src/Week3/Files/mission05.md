자바에서 cmd 혹은 리눅스 쉘 동작시키는 법
java.lang.Process 클래스 이용
https://cofs.tistory.com/365



자바 cp 기능 사용하기 인풋으로 기존파일 설정하고 아웃풋으로 파일명 설정해주기.
인풋파일 읽으면서 아웃파일에 write하기.
https://allmana.tistory.com/82

자바 rm 기능 (삭제하기)
file.delete(); 
이용

자바에서 network 기능 구현하기 (import java.net.*;)
1. ping 
InetAddress pingcheck = InetAddress.getByName(address);
boolean reachable = pingcheck.isReachable(2000);
isReachable 함수 활용하여 목적지까지 도달하는지 확인

2. nslookup
ping 과 마찬가지로 주소를 InetAddress 로 설정먼저 
.getHostname => 도메인주소
.getHostAddress => 아이피주소


property 기능 사용하기
시스템 속성을 조회할 수 있습니다.
public static void javaVersion() {
        String version = System.getProperty("java.version");
        System.out.println("Java " +version);
    }
자바 버전 확인 가능. 
https://unabated.tistory.com/entry/Java%EC%97%90%EC%84%9C-SystemgetProperty
참고

쓰레드
Thread.sleep(1000);
1초 쉬기