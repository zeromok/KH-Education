-- sample7.sql


-- ******************************************************
-- SELECT 문의 기본구조와 각 절의 실행순서
-- ******************************************************
--  - Clauses -                 - 실행순서 -
--
-- SELECT clause                    (5)
-- FROM clause                      (1)
-- WHERE clause                     (2)
-- GROUP BY clause                  (3)
-- HAVING clause                    (4)
-- ORDER BY clause                  (6)
-- ******************************************************


-- ------------------------------------------------------
--        *** SELECT 문의 기본문법 구조 ***
-- ------------------------------------------------------
-- SELECT [DISTINCT] { *, column [AS] [alias], ... }
-- FROM <테이블명>
-- WHERE <predicates>
-- ------------------------------------------------------

-- ------------------------------------------------------
-- 1. LIKE Operators (패턴매칭연산자)
-- ------------------------------------------------------
-- WHERE column LIKE <패턴>
-- ------------------------------------------------------
-- <패턴>에 사용가능한 Wildcard 문자들:
--  (1) %       ( x >= 0,     x: 문자개수 )
--  (2) _       ( x == 1,     x: 문자개수 )
-- ------------------------------------------------------
SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE 'J%';        -- % : x >= 0 (x: 문자개수)
    -- 직원 중에 이름이 J로 시작하는 사람들을 뽑아보자


SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '%ai%';      -- % : x >= 0 (x: 문자개수)
    -- 사이에 ai가 들어가는 last_name을 뽑아보자


SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '%in';       -- % : x >= 0 (x: 문자개수)
    -- in 으로 끝나는 last_name를 구해보자


-- ------------------------------------------------------

SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '_b%';       -- % : x >= 0, _ : x == 1 (x: 문자개수)
    -- 두번째 문자가 b인 last_name을 뽑아보자

-- ------------------------------------------------------


SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '_____d';    -- _ : x == 1 (x: 문자개수)
    -- 6번째 문자가 d인 last_name를 뽑아보자


SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
    last_name LIKE '%d';        -- % : x >= 0 (x: 문자개수)
    -- d로 끝나는 last_name를 뽑아보자

-- ------------------------------------------------------


SELECT
    employee_id,
    last_name,
    salary
FROM
    employees
WHERE
     last_name LIKE '%';
    
     '%_%' '_'  '%%' '%';  -- % : x >= 0, _ : x == 1 (x: 문자개수)
                           -- 와일드카드로 인식하기 때문에 특수문자로 인식하게 하려면 탈출문자를 써야한다.


SELECT
    employee_id,
    last_name,
    salary,
    job_id
FROM
    employees
WHERE
    -- 탈출문자(Escape Character):
    -- 특수한 의미를 가지는 기호의 기능을 없애는 문자를 "탈출문자"라고 함.
    -- $다음에 오는 문자를 특수문자로 인식시킨다.(탈출문자) == 특수문자로 인식 _들어가는 값 뽑아옴
    job_id LIKE '%$_%' ESCAPE '$';      -- % : x >= 0, _ : x == 1 (x: 문자개수)


SELECT
    employee_id,
    last_name,
    salary,
    job_id
FROM
    employees
WHERE
    job_id LIKE '%E___' ESCAPE 'E';     -- % : x >= 0, _ : x == 1 (x: 문자개수)