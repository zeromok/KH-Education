package org.zerock.myapp.mapper;


import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.EmployeeVO;

import java.util.List;

public interface EmployeesMapper {
    // mybatis 가 SQL 문장을 처리하는 방식 중 2번째 방법인 자바 인테페이스를 사용해보자

    @Select(" SELECT * FROM employees WHERE employee_id > 0 ")
    public abstract List<EmployeeVO> getAllEmployees();

    // 마이바티스는, 아래의 자동실행규칙을 따르는 경우,
    // 1. 인터페이스 패키지와 동일한 폴더구조를 생성 main/resources 폴더에
    // 2. 1. 에 인터페이스의 타입명과 동일한 이름의 Mapper.xml 파일을 생성
    // 3. .xml 파일의 namespace 값을 인터페이스의 FQCN 과 동일하게 지어준다.
    // 4. .xml 파일에 등록할 SQL 문장의 id 속성의 값은 인터페이스의 추상메소드 이름과 동일하게 지어준다.
    public abstract List<String> getAllEmployeesNames();
}
