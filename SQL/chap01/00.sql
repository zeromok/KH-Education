-- sample1.sql


-- ------------------------------------------------------
-- 1. To change the password of the specified user
-- 지정된 사용자의 암호 변경
-- ------------------------------------------------------
-- ALTER USER <사용자명> IDENTIFIED BY <비밀번호>;
-- ------------------------------------------------------
ALTER USER hr identified by hr;


-- ------------------------------------------------------
-- 2. To lock the specified user
-- 지정된 사용자 잠금
-- ------------------------------------------------------
-- ALTER USER <사용자명> ACCOUNT LOCK;
-- ------------------------------------------------------
ALTER USER hr ACCOUNT LOCK;

DESC dba_users;

SELECT username, account_status FROM dba_users;


-- ------------------------------------------------------
-- 3. To unlock the specified user
-- 지정된 사용자 언락
-- ------------------------------------------------------
-- ALTER USER <사용자명> ACCOUNT UNLOCK;
-- ------------------------------------------------------
ALTER USER hr ACCOUNT UNLOCK;

DESC dba_users;

SELECT username, account_status FROM dba_users;


-- ------------------------------------------------------
-- 4. To change the password and [un]lock 
--    of the specified user
-- 지정된 사용자의 암호변경 & 언락
-- ------------------------------------------------------
-- ALTER USER <사용자명> ACCOUNT LOCK   IDENTIFIED BY <비밀번호>;
-- ALTER USER <사용자명> ACCOUNT UNLOCK IDENTIFIED BY <비밀번호>;
--
-- ALTER USER <사용자명> IDENTIFIED BY <비밀번호> ACCOUNT LOCK ;
-- ALTER USER <사용자명> IDENTIFIED BY <비밀번호> ACCOUNT UNLOCK ;
-- ------------------------------------------------------
ALTER USER hr ACCOUNT LOCK IDENTIFIED BY oracle;
ALTER USER hr ACCOUNT UNLOCK IDENTIFIED BY oracle;

ALTER USER hr IDENTIFIED BY oracle ACCOUNT LOCK;
ALTER USER hr IDENTIFIED BY oracle ACCOUNT UNLOCK;

DESC dba_users;

SELECT username, password, account_status FROM dba_users;


-- ------------------------------------------------------
-- 5. To describe the specified table or
--    To show the specified table schema
-- 테이블 컬럼 조회
-- ------------------------------------------------------
-- DESC[RIBE] <테이블명>;
-- ------------------------------------------------------

DESC departments;

DESCRIBE employees;