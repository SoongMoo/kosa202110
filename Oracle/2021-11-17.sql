create table employees(
    employee_id  number,    -- 컬럼명
    first_name varchar2(20),
    last_name varchar2(20),
    hire_date date
);
drop table employees;
create table EMPLOYEES(
    EMPLOYEE_ID NUMBER(6) , ---컬럼 --- 직원번호
    FIRST_NAME VARCHAR2(20),    --- 컬럼 -- 이름
    LAST_NAME VARCHAR2(25),             -- 성
    EMAIL VARCHAR2(25),                 -- 이메일
    PHONE_NUMBER VARCHAR2(20),          -- 연락처
    HIRE_DATE  DATE,                    -- 입사일
    JOB_ID VARCHAR2(10),                -- 직무
    SALARY NUMBER(8,2),                 -- 급여
    COMMISSION_PCT NUMBER(2,2),         -- 커미션
    MANAGER_ID NUMBER(6),               -- 직속상사
    DEPARTMENT_ID NUMBER(4)             -- 부서번호
);

create table departments(
    DEPARTMENT_ID NUMBER(4),  ---  부서번호 
    DEPARTMENT_NAME VARCHAR2(30), -- 부서명
    MANAGER_ID NUMBER,    -- 부서장
    LOCATION_ID NUMBER(4)  -- 주소
);

--- 만들어진 테이블 정보 확인
DESCRIBE employees;
desc employees;

DESCRIBE departments;
desc departments;

insert into departments(
                department_id, department_name,manager_id,LOCATION_ID )
values        ( 300, 'Engineering',110, 1700);


select * from departments;

insert into departments(
                department_id, department_name,manager_id,LOCATION_ID )
values        ( 400, '영업부',100, 1700);

select * from departments;


drop table employees;
drop table departments;


create table departments(
    DEPARTMENT_ID NUMBER(4),  ---  부서번호 
    DEPARTMENT_NAME VARCHAR2(30), -- 부서명
    MANAGER_ID NUMBER,    -- 부서장
    LOCATION_ID NUMBER(4) default 1800  -- 주소
);

desc departments;

insert into departments(
                department_id, department_name,manager_id,LOCATION_ID )
values        ( 400, '영업부',100, 1700);

select * from departments;

insert into departments( -- 컬럼에 default값이 있는 경우에는 값을 주지 않았을
                         -- 경우 컬럼에 있는 default값이 들어간다.
                department_id, department_name,manager_id )
values        ( 400, '영업부',100);


insert into departments(
                department_id, department_name,manager_id,LOCATION_ID )
values        ( 400, '영업부',100, null);

insert into departments(
                department_id, department_name,LOCATION_ID )
values        ( 400, '영업부', null);

insert into departments(department_id, department_name )
values        ( 400, '영업부');

insert into departments( department_name )
values        ('영업부');

insert into departments(department_id )
values        ( 400 );

select * from departments;

drop table departments;
create table departments(
    DEPARTMENT_ID NUMBER(4) not null,  ---  부서번호 
    DEPARTMENT_NAME VARCHAR2(30) not null, -- 부서명
    MANAGER_ID NUMBER ,    -- 부서장
    LOCATION_ID NUMBER(4)  -- 주소
);
insert into departments( DEPARTMENT_ID, department_name )
values        (100, '영업부');

insert into departments( DEPARTMENT_ID , department_name)
values        (200, ' 기술부');
select * from departments;

drop table departments;
create table departments(
    DEPARTMENT_ID NUMBER(4) not null,  ---  부서번호 
    DEPARTMENT_NAME VARCHAR2(30) not null, -- 부서명
    MANAGER_ID NUMBER ,    -- 부서장
    LOCATION_ID NUMBER(4) default 1800 -- 주소
);

insert into departments(
                DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID)
values          (300, '영업부', 100, 1700);

-- MANAGER_ID에는  null 값이 저장
insert into departments(DEPARTMENT_ID,DEPARTMENT_NAME,LOCATION_ID )
values         (400, '기술부', 1800 );

insert into departments
values (500, '관리부', 120, 1600);

-- MANAGER_ID는 null,  LOCATION_ID는 default 값을 저장
insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME)
values(600,'개발부');
-- default값이 있는 컬럼(LOCATION_ID)에 null값을 저장
insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME, LOCATION_ID )
values(700, '경리부', null);

select * from departments;

drop table employees;
create table employees(
    employee_id NUMBER not null,
    first_name VARCHAR2( 255 ) ,
    last_name  VARCHAR2( 255 ) NOT NULL,
    email      VARCHAR2( 255 ) NOT NULL,
    phone      VARCHAR2( 50 ) NOT NULL ,
    hire_date  DATE NOT NULL          ,
    manager_id NUMBER        ,
    job_id  VARCHAR2( 255 ),
    salary number(8,2),
    commission_pct number(2,2),
    department_id NUMBER(4)
);
insert into employees
values(100, '숭무','이','highland0','010-7146-1970','1990-10-25',null,
        null, 1000, null, 10);
select * from employees;
insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME, EMAIL, PHONE,
            HIRE_DATE )
values(101, '상범', '이', 'sangbum', '010-1234-5678', '2000-11-10');

desc employees;


-- employees에 3개의 데이터 마음데로 입력해보세요.

insert into employees
values(114, 'Den', 'Raphealy', 'DRAPHEAL', '515.127.4561',  '2021/05/19' , 
        100,'AC_ACC', 11000, null,  30);

insert into employees 
values(115, 'Soong', 'Rhee', 'SRHEE', '010.7146.1970', '2021/05/19',  
 100,'AC_ACC', 11000, null, 30);

insert into employees(EMPLOYEE_ID,LAST_NAME,EMAIL,PHONE, HIRE_DATE )
values(116, '이', 'jangbum', '123-1235-456', '2020-10-05');
select * from employees;

-- sysdate 는 현재 날짜를 가지고 올때 사용
select sysdate from dual; -- dual은 가상의 테이블

drop table employees;

create table employees(
    employee_id NUMBER not null,
    first_name VARCHAR2( 255 ) ,
    last_name  VARCHAR2( 255 ) NOT NULL,
    email      VARCHAR2( 255 ) NOT NULL,
    phone      VARCHAR2( 50 ) NOT NULL ,
    hire_date  DATE default sysdate NOT NULL ,
    manager_id NUMBER        ,
    job_id  VARCHAR2( 255 ),
    salary number(8,2),
    commission_pct number(2,2),
    department_id NUMBER(4),
    hobby VARCHAR2(20)
);
insert into employees(employee_id,last_name,email,phone )
values(101, '이', 'highland0', '010-7146-1970');
select * from employees;

insert into employees
values(101,'숭무','이','highland0', '010-7146-1970',sysdate,null, 'AC_ACC',
1900,0.31, 30);

insert into employees(EMPLOYEE_ID, FIRST_NAME,FIRST_NAME,LAST_NAME,
        EMAIL,PHONE, HIRE_DATE, MANAGER_ID , JOB_ID, SALARY, COMMISSION_PCT,
       DEPARTMENT_ID )
values(102,'장범','이','jangbum', '010-7146-1970','2021-11-17',null,'AC_ACC',
1900,0.31);

select * from employees;
desc employees;


select employee_id,  first_name, length(first_name), 
       email, length(email)
from employees;

create table tb1(
    col1 VARCHAR2(3), -- 3 Byte
    col2 VARCHAR2(3 Byte),
    col3 VARCHAR2(3 char) -- 글자 갯수만 
);

insert into tb1(col1) values('abc');
insert into tb1(col1) values('이숭무'); -- (실제: 9, 최대값: 3)
insert into tb1(col2) values('abc');
insert into tb1(col2) values('이숭무'); --(실제: 9, 최대값: 3)
insert into tb1(col3) values('abc');
insert into tb1(col3) values('이숭무');
select * from tb1;


select * from employees;

--- 하나의 row가 하나의 데이터 
--- 컬럼들의 집합을 row라 한다.
-- 각 컬럼은 row의 해당 하는 하나의 데이터를 가지고 있다.

select last_name, email, phone
from employees; -- projection

select * from employees
where employee_id = 102; 
-- 원하는 행만 가지고 오는 것 selection 

select last_name, email, phone -- projection
from employees
where employee_id = 102; -- selection

select * from employees
where employee_id = 102;

select * from employees
where employee_id = 101;


select * from tb1;
insert into tb1(col1,col2,col3) 
values('abc', 'abc', '이숭무');

select * from tb1;

---            갯수            크기
select col1, length(col1), lengthb(col1),
       col2, length(col2), lengthb(col2),
       col3, length(col3), lengthb(col3)
from tb1;


create table tb2(
    col1 Integer,
    col2 decimal,
    col3 number
);

--- 테이블에 컬럼의 정보 확인 user_tab_cols: 
--- object를 만들때에는 소문자를 사용해도 
--- object 정보에는 모두 대문자로 들어간다.
-- object를 사용하는 경우에는 대소문자를 구별하지 않는다.
select * from user_tab_cols
where table_name = 'TB2';

insert into tb2 values(1,2,3);
insert into TB2 values(1,2,3);

CREATE table tb3(
    col1 float(32), 
    col2 float,     --- 정확도가 좋아진다. float(126)
    col3 number(10, 5) 
);
-- float : 0.123456789             : float(32)
-- double : 0.1234567890123456789  : float : float(126)
select * from user_tab_cols
where table_name= 'TB3';

create table tb4(   -- 20211119 
    col1 date,      -- 년월일시분초       - 세기 년 월 일 시 분 초
    col2 TIMESTAMP  -- 년월일시분초 미리초 
); -- 1970년 1월 1일부터 현재가지의 시간을 미리초로 계산 시간을 
---12331351545646496ms
insert into tb4 values(sysdate, sysdate);
select * from tb4;
insert into tb4 values(sysdate, SYSTIMESTAMP);



create table tb5(
    col1 NUMBER,
    col2 varchar2(20)
);
---                  학번   이름
insert into tb5 values(1, '이숭무');
insert into tb5 values(1, '이성범');
select * from tb5 where col1 = 1;
--- 중복값이 들어가지 못하도록 하자.

create table tb6(
    col1 number PRIMARY key, -- 중복을 허용하지 않겠다,.
    col2 varchar2(20)
);
insert into tb6 values(1, '이숭무');
insert into tb6 values(1,'이상범'); -- col1이 중복값이므로 저장되지 않는다.
insert into tb6 values(2,'이상범');
insert into tb6 values(3,'이상범');

select * from tb6;

create table tb7(
    col1 NUMBER primary key,
    email varchar2(20) primary key    -- Remove the extra primary key.
); -- primary key는 테이블에 오로지 하나만 존재해야 한다.

create table tb8(
    col1 number primary key, -- not null
                             -- NULL을 ("KOSA"."TB8"."COL1") 안에 삽입할 수 없습니다
    email varchar2(20) unique -- default가 null이다. null은 중복 허용
);
insert into tb8 values(1, '이숭무');
insert into tb8 values(2, '이숭무'); -- 무결성 제약 조건(KOSA.SYS_C008338)에 위배됩니다
insert into tb8 values(2, '이상범');
insert into tb8 values(null, '이장범');
insert into tb8 values(3, null);
insert into tb8 values(4, null);
select * from tb8;

drop table tb9;
create table tb9(
    col1 number primary key, 
    email varchar2(20) unique ,
    phone VARCHAR2(13) unique not null,-- NULL을 ("KOSA"."TB9"."PHONE") 안에 삽입할 수 없습니다
    first_name varchar2(20) 
);
insert into tb9 values(1, 'a' , '1234', '이숭무');
insert into tb9 values(2, null, '010-123-1234', '이숭무'); 
insert into tb9 values(3, '', '010-1234-1234', '이숭무'); 
insert into tb9 values(3, '', '', '이숭무'); 
-- ''는 null이다.
-- NULL을 ("KOSA"."TB9"."PHONE") 안에 삽입할 수 없습니다
select * from tb9;

---- 숙제
-- employees 테이블을 만들고
-- 컬럼.
-- employee_id인 사원번호가 있고 크기는 정수 6자리이다. primary key 를 갖는다.
-- first_name인 이름이 있고 크기는 문자 20이다.
-- last_name 인 성이 있고 크기는 25이며 null을 허용하지 않는다.
-- email이 있고 null 값을 허용하지 않으며 크기는 25이다. 중복을 허용하지 않는다.
-- 연락처인  phone_number가 있고 크기는 20이다.
-- 입사일인 hire_date가 있고 null을 허용하지 않으며 날짜 타입이다.
-- 직무인 job_id가 있으며 null을 허용하지 않고 크기는 10이다.문자 타입
-- 급여인 salary가 있으며 십진수 5자리와 소수점 이하 2자리가 필요하다.
-- 커미션인 commission_pct가 있고 소숫점이하 2자리가 필요하다.
-- 직속상사를 나타내는 manager_id  가 있고 크기는 십진수 6자리이다.
-- 부서를 나타내는 department_id가 있고 크기는 십진수 4이다.

-- 직원번호 100인 사원의 이름은 Steven이고 성은 King이며 이메일은 SKING 이고
--              전화번호는 515.123.4567, 입사일은 2003-06-17, 직무는 AD_PRES
--              급여는 24000, 부서는 90이다.
-- 직원번호 101인 사원의 이름은 Neena이고 성은 Kochhar이며 이메일은 NKOCHHAR 이고
--              전화번호는 515.123.4568, 입사일은 2005-09-21, 직무는 AD_VP
--              급여는 17000, 부서는 90이다, 직속상사는 100이다.
-- 직원번호 148인 사원의 이름은 Gerald이고 성은 Cambrault이며 이메일은 GCAMBRAU 이고
--              전화번호는 011.44.1344.619268, 입사일은 2007-10-15, 직무는 SA_MAN
--              급여는 11000, 부서는 80이다, 직속상사는 100, 커미션은 0.3이다.



