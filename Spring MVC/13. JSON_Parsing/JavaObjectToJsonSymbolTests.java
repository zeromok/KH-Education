package org.zerock.myapp.test;

import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.zerock.myapp.domain.Bar;
import org.zerock.myapp.domain.Foo;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JavaObjectToJsonSymbolTests {

    @Test
    @Order(1)
    @DisplayName("1. POJO")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testPOJO() {
        /*
        자바객체를 JSON 으로 매핑하기위한 간단한 예제
        1. 일반 POJO 클래스와 로컬클래스 를 매핑해보자
        */
        log.trace("==== Test > testPOJO() ====");

//        @Data
//        class Person {
//            private String name;
//            private int age;
//            private double weight;
//            private double height;
//
//        }// end class

        Person person = new Person();
        person.setName("name");
        person.setAge(30);
        person.setWeight(70.0);
        person.setHeight(175.0);
        log.debug("person : {}", person);

//        ----

        Gson gson = new Gson();
        String json = gson.toJson(person);
        log.debug("json : {}", json);
        // {"name":"name","age":30,"weight":70.0,"height":175.0} == {}


    }


    @Test
    @Order(2)
    @DisplayName("2. Array")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testArray() {
        /*
        자바객체를 JSON 으로 매핑하기위한 간단한 예제
        2. 배열로 매핑해보자
        */
        log.trace("==== Test > testArray() ====");

        int[] arr = {1, 2, 3, 4, 5};
        log.debug("arr : {}", arr);


//        ----

        Gson gson = new Gson();
        String json = gson.toJson(arr);
        log.debug("json : {}", json);
        // json : [1,2,3,4,5]   == []


    }


    @Test
    @Order(3)
    @DisplayName("3. List")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testList() {
        /*
        자바객체를 JSON 으로 매핑하기위한 간단한 예제
        3, List<> 로 매핑해보자
        */
        log.trace("==== Test > testList() ====");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        log.debug("list : {}", list);


//        ----

        Gson gson = new Gson();
        String json = gson.toJson(list);
        log.debug("json : {}", json);
        // json : [1,2,3,4,5]   == []


    }


    @Test
    @Order(4)
    @DisplayName("4. Set")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testSet() {
        /*
        자바객체를 JSON 으로 매핑하기위한 간단한 예제
        4. Set<> 으로 매핑해보자
        */
        log.trace("==== Test > testSet() ====");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        log.debug("set : {}", set);

//        ----

        Gson gson = new Gson();
        String json = gson.toJson(set);
        log.debug("json : {}", json);
        // json : [1,2,3,4,5]  == []


    }


    @Test
    @Order(5)
    @DisplayName("5. Map>")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testMap() {
        /*
        자바객체를 JSON 으로 매핑하기위한 간단한 예제
        5. Map<> 으로 매핑해보자
        */

        log.trace("==== Test > testMap() ====");

        Map<Integer, Integer> map = new HashMap();
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        log.debug("arr : {}", map);
        // arr : {1=2, 3=4, 5=6}


//        ----

        Gson gson = new Gson();
        String json = gson.toJson(map);
        log.debug("json : {}", json);
        //  json : {"1":2,"3":4,"5":6}  == {}
        // 키는 문자열로 나오는 구나?


    }


    @Test
    @Order(6)
    @DisplayName("6. testPojoInPojo")
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testPojoInPojo() {
        /*
        자바객체를 JSON 으로 매핑하기위한 간단한 예제
        6. 중첩된 객체를 매핑해보자
        */
        log.trace("==== Test > testPojoInPojo() ====");

        Person pojo = new Person();
        pojo.setName("name");
        pojo.setAge(20);
        pojo.setWeight(70.0);
        pojo.setHeight(175.0);
        pojo.setFoo(new Foo(77, "fooName"));
        pojo.setBar(new Bar().id(33).name("barName"));

        log.debug("pojo : {}", pojo);
        /*
        pojo : Person(
                        name=name, age=20, weight=70.0, height=175.0,
                        foo=Foo(id=77, name=fooName),
                        bar=Bar(id=33, name=barName)
                      )
        Person 객체 안 요소는 6개 그 중 객체 2개
        */


//        ----

        Gson gson = new Gson();
        String json = gson.toJson(pojo);
        log.debug("json : {}", json);
        /*
        json : {
                "name":"name","age":20,"weight":70.0,"height":175.0,
                "foo":{"id":77,"name":"fooName"},
                "bar":{"id":33,"name":"barName"}
                }

         */


    }

}// end class

@Data
class Person {      // 외부클래스로 바꾸면 JSON 으로 변환이 된다.
    private String name;
    private int age;
    private double weight;
    private double height;

    // 부품 집합 관계필드
    private Foo foo;
    private Bar bar;

}// end class

