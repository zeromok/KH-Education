package Java.NetworkBasic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class URLConnection {

    public static void main(String[] args) throws IOException {

        String url = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";

        // URL 객체의 메소드 중에+ 실제로 지정된 URL 로 접속을 시도하는 메소드
        URL png = new URL(url);
        java.net.URLConnection urlConn = png.openConnection();

        System.out.println("1. png: " + png);
        System.out.println("2. urlConn:  "+ urlConn);
        System.out.println("3. getAllowUserInteraction:  "+ urlConn.getAllowUserInteraction());
        System.out.println("4. getDefaultAllowUserInteraction:  "+ java.net.URLConnection.getDefaultAllowUserInteraction());
        System.out.println("5. getConnectTimeout:  "+ urlConn.getConnectTimeout());
        System.out.println("6. getContent:  "+ urlConn.getContent());
        System.out.println("7. getContentEncoding:  "+ urlConn.getContentEncoding());
        System.out.println("8. getContentLength:  "+ urlConn.getContentLength());
        System.out.println("9. getContentLength:  "+ urlConn.getContentLength());
        System.out.println("10. getDate :  "+ new Date(urlConn.getDate()));
        System.out.println("11. getDefaultUseCaches :  "+ urlConn.getDefaultUseCaches());
        System.out.println("12. getDoInput :  "+ urlConn.getDoInput());
        System.out.println("13. getDoOutput :  "+ urlConn.getDoOutput());
        System.out.println("14. getExpiration :  "+ urlConn.getExpiration());
        System.out.println("15. getHeaderFields :  "+ urlConn.getHeaderFields());
        System.out.println("16. getIfModifiedSince :  "+ urlConn.getIfModifiedSince());
        System.out.println("17. getLastModified :  "+ new Date(urlConn.getLastModified()));
        System.out.println("18. getReadTimeout :  "+ urlConn.getReadTimeout());
        System.out.println("19. getURL :  "+ urlConn.getURL());
        System.out.println("20. getUseCaches :  "+ urlConn.getUseCaches());

    }// main()

}// end class
