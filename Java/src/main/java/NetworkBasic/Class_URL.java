package Java.src.main.java.NetworkBasic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Class_URL {

    // URL : Uniform Resource Locator (단일화된 방법으로 웹상의 자원의 위치를 알려주는 자)
    // URI : Uniform Resource Indicator (단일화된 방법으로 웹상의 자원을 가리키는 지시자)
    public static void main(String[] args) throws IOException {

        java.net.URL url00 = new java.net.URL("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        System.out.println("url00 : " + url00);
        System.out.println("type : " + url00.getClass().getName());

        // ----

        URL url01 = new URL("https", "www.google.com", "/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        System.out.println("url01 : " + url01);

        // ----

        URL url02 = new URL("https", "www.google.com", 443, "/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        System.out.println("url02 : " + url02);

        // ----

        URL png = new URL("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        System.out.println("png : " + png);

        System.out.println("\t - getAuthority : " + png.getAuthority());
        System.out.println("\t - getProtocol : " + png.getProtocol());
        System.out.println("\t - getHost : " + png.getHost());
        System.out.println("\t - getPort : " + png.getPort());
        System.out.println("\t - getDefaultPort : " + png.getDefaultPort());
        System.out.println("\t - getFile : " + png.getFile());
        System.out.println("\t - getPath : " + png.getPath());
        System.out.println("\t - getQuery : " + png.getQuery());
        System.out.println("\t - getRef : " + png.getRef());
        System.out.println("\t - getUserInfo : " + png.getUserInfo());
        System.out.println("\t - getContent : " + png.getContent());

    }// main()

}// end class
