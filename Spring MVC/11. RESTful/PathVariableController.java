package org.zerock.myapp.controller;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Log4j2
@NoArgsConstructor

@RestController
// 이 어노테이션이 붙어있는 클래스의 핸들러 메소드는 순수한 데이터를 반환 할 수 있다.
@RequestMapping("/RESTful/")
public class PathVariableController {

    /*
    RESTful 방식의 Request Mapping => Request URI(대상특정자원) + HTTP method(CRUD)
    CREATE(**PUT**), READ(GET), UPDATE(POST), DELETE(**DELETE**) => 가장 일반적인 경우 소개
    => 개발주체마다 각 전송방식에 별도의 의미를 부여해서 사용
    HTTP protocol : 대락 15가지 정도의전송방식이 정의되어 있음
    */
    @GetMapping(
            path = "/product/{category}/{productId}",       // 경로의 일부분을 변수화
            //path = "/product/clothes/100"
            produces = MediaType.APPLICATION_JSON_VALUE)
//    public String[] getPathVariable(                      // 1. 배열
//    public Map<String , String > getPathVariable(         // 2. Map
    public Set<String > getPathVariable(                    // 3. Set
                                    @PathVariable("category") String category,
                                    // @PathVariable : 메소드의 매개변수를 URI 변수에 넣어준다.
                                    @PathVariable("productId") Integer productId) {
        log.trace("==== getPathVariable({}, {}) ====", category, productId);

        String productInfo = "Good product";

        // 1 []
//        String[] result = {
//                category,
//                String.valueOf(productId),
//                productInfo
//        };

        // 2 []
//        Map<String , String > result = new HashMap<>();
//        result.put("category", category);
//        result.put("productId", String.valueOf(productId));
//        result.put("productInfo", productInfo);

        // 3 []
        Set<String > result = new HashSet<>();
        result.add(category);
        result.add(String.valueOf(productId));
        result.add(productInfo);

        return result;
    }


}// end class
