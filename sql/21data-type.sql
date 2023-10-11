-- 수형(정수, 실수)
-- 문자열
-- 날짜(날짜 시간)

-- 정수 : int
CREATE TABLE my_table3 (
  col1 int
);

INSERT INTO my_table3 (col1)
VALUE (292424);
INSERT INTO my_table3 (col1)
VALUE ('12344');
INSERT INTO my_table3 (col1)
VALUE ('two'); -- 안됨
SELECT * FROM my_table3;

-- 실수 : DEC(DECIMAL)
CREATE TABLE my_table4 (
    col1 DEC
);
INSERT INTO my_table4 (col1)
VALUE (3.14);
SELECT * FROM my_table4;

CREATE TABLE my_table5 (
  col1 DEC(5, 3) -- 총길이 5, 소숫점이하 길이 3
);
INSERT INTO my_table5 (col1)
VALUE (10.123);
INSERT INTO my_table5 (col1)
VALUE (10.1234);

SELECT * FROM my_table5;

-- 예) my_table6 만들기
-- age컬럼 정수 타입
-- score 컬럼 총길이 7 소숫점 이하길이 2
CREATE TABLE my_table6(
    age int,
    score DEC(7, 2)
);

INSERT INTO my_table6 (age, score)
VALUE (20, 2024.12);
SELECT * FROM my_table6;


-- 문자열 : VARCHAR
CREATE TABLE my_table7 (
    col1 VARCHAR(1), -- 1글자 제한
    col2 VARCHAR(2), -- 2글자 제한
    col3 VARCHAR(16000) -- 16000글자 제한
);
INSERT INTO my_table7 (col1)
VALUE ('a');

-- 예) my_table9 만들기
-- name 문자열 최대길이 100자
-- 주소 문자열 최대길이 200자
-- 전화번호 문자열 최대길이 100자
CREATE TABLE my_table9(
    name VARCHAR(100),
    address VARCHAR(200),
    phoneNum VARCHAR(100)
);

INSERT INTO my_table9 (name, address, phoneNum)
VALUE ('가나다', '서울싣ㄷㄷㄷㄷㄷㄷㄷㄷ', '010202020020');
SELECT * FROM my_table9;

-- 날짜
CREATE TABLE my_table10 (
    col1 DATE
);
INSERT INTO my_table10 (col1)
VALUE ('2000-01-01');

-- 날짜시간 : DATETIME
CREATE TABLE my_table11 (
  col1 DATETIME
);

INSERT INTO my_table11 (col1)
VALUE ('2002-12-30 14:04:12');
SELECT * FROM my_table11;

SELECT NOW();