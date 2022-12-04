package Java.src.main.java.NetworkBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ReadURLContent {

    public static void main(String[] args) throws IOException {

        String url00 = "https://www.kita.net/cmmrcInfo/cmmrcNews/goodMornKita/goodMornKitaDetail.do";
        URL kita = new URL(url00);

//        // Step 1. 실제 접속 및 자원요청
//        URLConnection urlConn = kita.openConnection();
//        // Step 2. 요청에 대한 응답 얻어내기
//        InputStream is = urlConn.getInputStream();

        // 위 2단계를 한번에 처리 : URL 에 대한 연결을 열고 해당 연결에서 읽을 입력 스트림을 반환
        InputStream is = kita.openStream();

        // 응답내용 꺼내오기
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try(is; br) {
            String line;

            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
            }
        }

    }// main()

}// end class
