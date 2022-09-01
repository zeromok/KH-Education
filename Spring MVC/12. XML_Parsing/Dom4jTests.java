package org.zerock.myapp.dom4j;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.*;

import javax.xml.parsers.SAXParser;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Dom4jTests {

    @Test
    @Order(1)
    @DisplayName("1. learnDom4j() Test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void learnDom4j() throws DocumentException {
        log.trace("==== learnDom4j() ====");

        /*
        =====================  목표  ====================
        dom4j library 를 이용한 XML 문서 파일 파싱 수행하여,
        원하는 데이터만 획득하는 방법을 배우자
        */

        /*
        1. dom4j 가 제공하는 SAX parser 를 이용해서,
            지정된 파일을 파싱하여, 메모리에 DOM tree 생성

            자바스크립트 = document 내장객체
            Dom4j        = SAX parser 가 구현된 "SAXReader"
        */
        SAXReader reader = new SAXReader();     // SAX XML parser
        reader.setEncoding("UTF-8");            // Default
        log.debug("reader : {}", reader);

//        ---

        Document doc = reader.read("src/main/resources/Covid19DailyDetection.xml");
        log.debug("doc : {} ", doc);
        // org.dom4j.tree.DefaultDocument@5316e95f [Document: name src/main/resources/Covid19DailyDetection.xml]
        /*
        여기서 알수있는건 .read 가 돌려준 Document 타입은 인터페이스 or 추상클래스 이다.
        왜? debug 를 이용해 찍어봤을 때 다른객체가 찍혔으므로...
        */


//        ---

        log.info("\t - doc.getDocType : {}", doc.getDocType());             // null
        log.info("\t - doc.getName : {}", doc.getName());                   // src/main/resources/Covid19DailyDetection.xml
        log.info("\t - doc.getXMLEncoding : {}", doc.getXMLEncoding());     // UTF-8

//        ---

        // 2. 우리가 원하는 데이터를 획득 (DOM tree 에서 ROOT element 를 우선적으로 획득)
        Element root = doc.getRootElement();        // ROOT node (DOM tree 에서 ROOT element 를 얻는 방법)
        log.debug("root : {}", root);
        log.info("\t - 1. name : {}", root.getName());
        log.info("\t - 2. NodeType : {}", root.getNodeTypeName());
        log.info("\t - 3. Text : {}", root.getText());


        /*
        3. DOM tree 의 계층구조에 맞게 순회하여,
            우리가 원하는 최종적인 Elements 를 획득
        */
        Element body = root.element("body");
        Element items = body.element("items");

        List<Element> list = items.elements("item");

//        item.forEach(log::info);

        for(Element item :list) {
            Element seq = item.element("seq");
            Element createDt = item.element("createDt");
            Element deathCnt = item.element("deathCnt");
            Element decideCnt = item.element("decideCnt");
            Element stateDt = item.element("stateDt");
            Element stateTime = item.element("stateTime");
            Element updateDt = item.element("updateDt");

            String seqContent = seq.getStringValue();
            String seqText = seq.getText();

            log.info("\t - seqContent : {}", seqContent);
            log.info("\t - seqText : {}", seqText);
        }

    }

}
