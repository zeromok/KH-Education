package Java.src.main.java.NetworkBasic;

import lombok.extern.log4j.Log4j2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class IPAddress {

    public static void main(String[] args) throws UnknownHostException {

        System.out.println(Arrays.toString(args)); // []

        // ===============================================================================
        InetAddress localhost = InetAddress.getLocalHost();

        System.out.println("localhost : " + localhost); // mokk-MacBookPro.local/127.0.0.1
        System.out.println("type : " + localhost.getClass().getName()); // java.net.Inet4Address

        // InetAddress 로부터 얻을 수 있는 부가정보가 많음을 보여주는 예제
        InetAddress addr = InetAddress.getByName("www.naver.com");

        System.out.println("1. addr : " + addr);                                    //  www.naver.com/23.45.60.223
        System.out.println("2. hostname : " + addr.getHostName());                  //  www.naver.com
        System.out.println("3. FQCN : " + addr.getCanonicalHostName());             //  a23-45-56-223.deploy.static.akamaitechnologies.com (FQCN : Fully-Qualified Domain name)
        System.out.println("4. hostAddress : " + addr.getHostAddress());            //  23.45.56.223 (Host IP Address)
        System.out.println("5. loopback : " + InetAddress.getLoopbackAddress());    //  localhost/127.0.0.1 (Loopback address of the current)
        System.out.println("6. localhost : " + InetAddress.getLocalHost());         //  mokk-MacBookPro.local/127.0.0.1 (localhost address of the current)

        // 주어진 도메인명이 DNS에 등록된 하나의 IP주소를 가져와서 주소를 구성하는 각 정수 출력하는 예제
		byte[] addrBytes = addr.getAddress();
        System.out.println("min : " + Byte.MIN_VALUE);
        System.out.println("max : " + Byte.MAX_VALUE);

        System.out.println("7. byteAddr : " + Arrays.toString(addrBytes));

		//Get normal Host Address when one byte < 0, the byte +256 required
		for(byte b : addrBytes) {
            System.out.println("b : " + ((b<0)?b+256 : b));
		} // enhanced for

        // -----------------------------------------------------------

        InetAddress[] addrs = InetAddress.getAllByName("www.naver.com");

        for(InetAddress address : addrs) {
            System.out.println("8. address : " + address);
            System.out.println("9. FQCN : " + address.getCanonicalHostName());
        }

    }// main()

}// end class
