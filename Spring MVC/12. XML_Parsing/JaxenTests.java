package org.zerock.myapp.dom4j;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JaxenTests {
    @Test
    @Order(1)
    @DisplayName("1. learnJaxen() Test ")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void learnJaxen() throws DocumentException {
        log.trace("==== learnJaxen() ====");

        /*
        dom4j library 를 이용한 XML 문서 파일 파싱 수행하여,
        원하는 데이터만 획득하는 방법을 배우자
        */

        /*
        1. dom4j 가 제공하는 SAX parser 를 이용해서,
            지정된 파일을 파싱하여, 메모리에 DOM tree 생성
        */
        SAXReader reader = new SAXReader();     // SAX XML parser
        reader.setEncoding("UTF-8");            // Default
        log.debug("reader : {}", reader);

//        ---

        Document doc = reader.read("src/main/resources/Covid19DailyDetection.xml");
        log.debug("doc : {} ", doc);

//        ---

        log.info("\t - doc.getDocType : {}", doc.getDocType());             // null
        log.info("\t - doc.getName : {}", doc.getName());                   // src/main/resources/Covid19DailyDetection.xml
        log.info("\t - doc.getXMLEncoding : {}", doc.getXMLEncoding());     // UTF-8

//        ---

        // 2. XPath expression 대로 XPath engine 이 자동 순회하여, 우리가 원하는 데이터를 획득 (DOM tree 에서 ROOT element 를 우선적으로 획득)
        String xpath = "/response/body/items/item";

        List<Node> list = doc.selectNodes(xpath);

        for (Node node : list) {
            Element item = (Element) node;      // 부모타입객체 -> 자식인 Element 객체로 강제 형변환

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
