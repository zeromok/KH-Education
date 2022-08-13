package org.zerock.myapp.domain;

import lombok.Value;

import java.util.Date;

@Value
public class EmployeeVO {

    // 대전제 : VO 클래스의 필드는 타겟테이블의 스키마에 나오는 컬럼의 순서/이름/타입에 맞게 선언하자

    // 1. method
//	private Integer EMPLOYEE_ID;
//	private String FIRST_NAME;
//	private String LAST_NAME;
//	private String EMAIL;
//	private String PHONE_NUMBER;
//	private Date HIRE_DATE;
//	private String JOB_ID;
//	private Double SALARY;
//	private Double COMMISSION_PCT;
//	private Integer MANAGER_ID;
//	private Integer DEPARTMENT_ID;


    // 2. method
    // 1. 번의 규칙은 상수식별자 규칙(대문자+복합단어인 경우, _ 로 이어준다.)이라 오류날수 있음 (실행은 된다.)
    // 자바 식별자 규칙에 맞게 _ 삭제 첫단어는 소문자, 두번째 단어부터는 camel 기법 적용
    private Integer employeeId;
    private String firstNname;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private Double salary;
    private Double commissionPct;
    private Integer managerId;
    private Integer departmentId;
}
