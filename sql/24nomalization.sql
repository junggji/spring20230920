-- normalization : 정규화 책209페이지 atomic

-- atomic data (원자적 데이터)
-- 예) 이름, 최종학력, 특기
USE mydb1;

-- 규칙1
-- 원자적 데이터로 구성된 열은 그열에 같은 타입의 데이터를 여러 개 가질 수 없다.
CREATE TABLE my_table21_person
(
    name   VARCHAR(100) NOT NULL,
    school VARCHAR(100),
    skill  VARCHAR(1000)
);
INSERT INTO my_table21_person (name, school, skill)
    VALUE ('손흥민', '대학', '축구, 노래');
INSERT INTO my_table21_person (name, school, skill)
    VALUE ('이강인', '대학원', '야구, 농구');
INSERT INTO my_table21_person (name, school, skill)
    VALUE ('김민재', '대학원', '배구');
SELECT *
FROM my_table21_person;

-- 책 209쪽 규칙2
-- 원자적 데이터로 구성된 테이블은 같은 타입의 데이터를 여러 열에 가질 수 없다.
CREATE TABLE my_talbe22_person
(
    name    VARCHAR(20) NOT NULL,
    schools VARCHAR(100),
    skill1  VARCHAR(100),
    skill2  VARCHAR(100),
    skill3  VARCHAR(100)
);
INSERT INTO my_talbe22_person (name, schools, skill1, skill2, skill3)
    VALUE ('흥민', '대하교', '축구', '노래', null);
INSERT INTO my_talbe22_person (name, schools, skill1, skill2, skill3)
    VALUE ('강인', '대학원', '야구', '농구', null);
INSERT INTO my_talbe22_person (name, schools, skill1, skill2, skill3)
    VALUE ('민재', '대학원', '배구', null, null);
SELECT *
FROM my_talbe22_person;

CREATE TABLE my_talbe23_person
(
    name   VARCHAR(100) NOT NULL,
    school VARCHAR(100),
    skill  VARCHAR(1000)
);
INSERT INTO my_talbe23_person (name, school, skill)
    VALUE ('흥민', '대학', '축구');
INSERT INTO my_talbe23_person (name, school, skill)
    VALUE ('흥민', '대학', '노래');
INSERT INTO my_talbe23_person (name, school, skill)
    VALUE ('강인', '대학', '야구');
INSERT INTO my_talbe23_person (name, school, skill)
    VALUE ('강인', '대학', '농구');

SELECT *
FROM my_talbe23_person;

-- KEY : 각 행을 구분하는 컬럼(들) - 유일해야한다(중복가능성 없어야함).

-- 책 215 정규화
-- 각 행의 데이터들은 원자적 값을 가져야한다.
-- 각 행은 유일무이한 식별자인 기본키(primary key)를 가지고 있어야 한다.
CREATE TABLE my_table24
(
    ssn    VARCHAR(10) NOT NULL UNIQUE,
    name   VARCHAR(10) NOT NULL,
    school VARCHAR(10),
    skill  VARCHAR(10)
);

-- 책 216~
-- 기본키(primary key) 조건
-- 1. 기본키는 NULL이 될 수 없음.
-- 2. 기본키는 레코드가 삽입될 때 값이 있어야 함.
-- 3. 기본키는 간결해야 한다.(적은 컬럼으로 해야하는데, 1개 컬럼이 가장좋음)
-- 4. 기본키의 값은 변경 불가함

CREATE TABLE my_table25
(
    id     INT         NOT NULL UNIQUE AUTO_INCREMENT, -- AUTO_INCREMENT : 1부터 자동으로 증가된 값 삽입
    ssn    VARCHAR(10) NOT NULL,
    name   VARCHAR(10) NOT NULL,
    school VARCHAR(10),
    skill  VARCHAR(10)
);
DROP TABLE my_table25;

INSERT INTO my_table25 (ssn, name, school, skill)
    VALUE ('020040', '흥민', '대학', '축구');
INSERT INTO my_table25 (ssn, name, school, skill)
    VALUE ('020040', '흥민', '대학', '노래');
INSERT INTO my_table25 (ssn, name, school, skill)
    VALUE ('090410', '강인', '대학', '농구');
INSERT INTO my_table25 (ssn, name, school, skill)
    VALUE ('090410', '강인', '대학', '축구');

SELECT *
FROM my_table25;

CREATE TABLE my_table26_person (
    id     INT PRIMARY KEY UNIQUE AUTO_INCREMENT, -- PRIMARY KEY : NOT NULL UNIQUE
    ssn    VARCHAR(10) NOT NULL,
    name   VARCHAR(10) NOT NULL,
    school VARCHAR(10),
    skill  VARCHAR(10)
);
DESC my_table25;
DESC my_table26_person;
