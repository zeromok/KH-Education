package org.zerock.myapp.jsonIo;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import com.owlike.genson.Genson;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.zerock.myapp.domain.Foo;

import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JsonIoTests {

    @Test
    @Order(1)
    @DisplayName("1.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testSerialize() {
        log.trace("==== Test > testSerialize() ====");

        // ==== Java Object -> JSON String 으로 변환 (Serialize) ====

        // 1. JSON 문자열로 변환, 자바객체 생성
//        Foo obj = new Foo();
//        obj.setId(100);
//        obj.setName("mero");
//        log.debug("obj : {}", obj);

        // @Value
        Foo obj = new Foo(100, "meroo");

        // 2. 생성한 자바객체를 JSON 문자열로 변환
        String json = JsonWriter.objectToJson(obj);
        log.debug("json : {}", json);
        // json : {"@type":"org.zerock.myapp.domain.Foo","id":100,"name":"mero"}
        // 역변환을 위해 FQCN 을 같이 넣어준다.

    }// testSerialize()



    @Test
    @Order(2)
    @DisplayName("2.")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testDeSerialize() {
        log.trace("==== Test > testDeSerialize() ====");

        // ==== JSON Object -> java String 으로 변환 (De-Serialize) ====

        /*
        1. JSON -> 자바객체로 역변환 할 JSON 문자열 확보
        \ : 오른쪽에 나오는 1개문자가 가지는 특수한 기능을 없애고,  그저 단순한 문자로 만든다.
        */
//        String json = "{\"@type\":\"org.zerock.myapp.domain.Foo\",\"id\":100,\"name\":\"mero\"}";
        String json = "{\"@type\":\"org.zerock.myapp.domain.Foo\",\"id\":100,\"name\":\"meroo\"}";      // @Value

        // 2. JsonIo 라이브러리를 이용해서, 1.의 JSON 문자열을 역변환
        Object obj = JsonReader.jsonToJava(json);
        log.debug("obj : {}", obj);

    }// testDeSerialize()


}
