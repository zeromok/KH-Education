package org.zerock.myapp.mapper;


import org.apache.ibatis.annotations.Select;

// Mybatis Mapper Interface #2
// 동적인 추가를 위한 예제
public interface TimeMapper {

    @Select("SELECT to_char(current_date, 'yyyy/MM/dd HH24:mi:ss') AS now FROM dual")
    public abstract String getCurrentTime();

    // 자동 SQL 문장 실행방식으로 쿼리 수행 : 단 이 방식은 몇가지 규칙을 지켜야함
    // 1. 이 메소드가 수행할 SQL 문장을 Mapper XML 파일에 등록                    == TimeMapper.xml 안 코드 작성
    // 2. 파일의 위치는, 이 Mapper Interface 이름과 동일하게 만들어야 한다.         == TimeMapper.xml 위치를 패키지에 맞춰서 저장
    // 3. 파일의 이름은, 반드시 이 Mapper Interface 이름과 동일하게 만들어야 한다.    == TimeMapper.xml
    // 4. 파일의 namespace 의 값은, 반드시 Mapper Interface 의 FQCN 으로 지정    == "org.zerock.myapp.mapper.TimeMapper"
    // 5. 자동실행시킬 SQL 문장을 가지고 있는 태그의 id 속성의 값은, 반드시 아래의 추상메소드의 이름과 동일하게 지정하라     == "getCurrentTime1"
    public abstract String getCurrentTime1();

}