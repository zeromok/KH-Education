-- sample1.sql


-- ******************************************************
-- SELECT 문의 기본구조와 각 절의 실행순서
-- ******************************************************
--  - Clauses(절) -                 - 실행순서 -
--
-- SELECT clause                      (5)
-- FROM clause                        (1)
-- [WHERE clause]                     (2)
-- [GROUP BY clause]                  (3)
-- [HAVING clause]                    (4)
-- [ORDER BY clause]                  (6)
-- ******************************************************


-- ------------------------------------------------------
--        *** SELECT 문의 기본문법 구조 ***
-- ------------------------------------------------------
-- SELECT [DISTINCT] { * | column [AS] [alias], ... }
-- FROM <테이블명>
-- ------------------------------------------------------

-- ------------------------------------------------------
-- 1. To project all columns of the table
-- 테이블의 모든 컬럼 조회
-- ------------------------------------------------------
-- SELECT *
-- FROM table;
-- ------------------------------------------------------
SELECT *
FROM employees;

SELECT *
FROM departments;

-- ------------------------------------------------------
-- 2. To project only the specified columns of the table
-- 테이블의 선택 컬럼 조회
-- ------------------------------------------------------
-- SELECT column1[, column2, ..., columnN]
-- FROM table;
-- ------------------------------------------------------
DESC employees;

-- 사원아이디, 이름, 고용날짜, 봉급 뽑아오기 employees테이블에서...
-- 질문자의 의도를 잘 파악해서 쿼리 짜기*****
SELECT
    employee_id,
    last_name,
    hire_date,
    salary
FROM
    employees;


-- ------------------------------------------------------
-- 3. 산술연산자의 활용 ( +, - , *, / )
-- 이항연산자 피연산자2개는 컬럼들
-- ------------------------------------------------------
-- SELECT column1 + column2 FROM table;
-- SELECT column1 - column2 FROM table;
-- SELECT column1 * column2 FROM table;
-- SELECT column1 / column2 FROM table;
-- ------------------------------------------------------
SELECT
    salary AS salary01,
    salary + 100 AS salary02
    -- 하드코딩 된 값 = 리터럴
    -- 100 : 정수 리터럴
FROM
    employees;

SELECT
    salary,
    salary - 100
FROM
    employees;

SELECT
    salary,
    salary * 100 
FROM
    employees;

SELECT
    salary,
    salary / 100
FROM
    employees;

-- 이름, 급여, 연봉
SELECT
    last_name,
    salary,
    salary * 12
    -- 연봉은 급여만 알면 나오므로 연봉=유도속성
FROM
    employees;


-- ------------------------------------------------------
-- 4. About SYS.DUAL table
-- SYS.DUAL table = Dummy table. 의미가 전혀 없는 테이블 왜만듦? FROM절을 생략할 수 없다는 제약 때문에 등장
-- ------------------------------------------------------
-- SYS account owns this DUAL table.
-- If you don't need a table, the DUAL table needed.
-- ------------------------------------------------------
-- dual테이블의 컬럼정보 확인
DESC dual;

-- dual테이블의 모든 컬럼 확인
SELECT
    *
FROM
    dual;

-- 이렇게 하는게 정석
SELECT
    *
FROM
    sys.dual;

SELECT
    245 * 567 
FROM
    dual;          -- 참고로, MySQL/Mariadb/Postgresql 에서는 생략가능!
