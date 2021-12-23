-- ���̺� (�ڷ���) , not null, default, primary key, unique
-- insert
-- number, char, varchar2, date, long, clob, timestemp
-- number(4), number(8, 2) => number(7,2)
-- print("���� Ű�� %8.2f�Դϴ�," % 17555.50 )
drop table departments;
create table departments( -- �μ� ����
    department_id number(4) primary key,
    department_name varchar2(30) not null,
    manager_id  NUMBER(6),
    location_id number(4)
);
--select * from employees;
--desc employees;
desc departments;

select * from user_constraints where table_name = 'DEPARTMENTS';

drop table departments;
create table departments( -- ������
    department_id number(4) constraint dep_depid_PK primary key,
    department_name varchar2(30) CONSTRAINT dep_depname_NN not null,
    manager_id number(6),
    location_id number(4)
);

desc departments;
select * from user_constraints where table_name = 'DEPARTMENTS';

drop table departments;
create table departments( -- table ����
    department_id number(4),
    department_name VARCHAR2(30) not null, --not null�� �������� ����
    manager_id number(6), -- �μ����ȣ -- ������ȣ 
    location_id number(4),
    constraint dep_depId_pk primary key(department_id) 
);

desc departments;
select * from user_constraints where table_name = 'DEPARTMENTS';

insert into departments
values(90, 'Executive', 100, 1700);

select * from departments;
select * from employees where employee_id = 100;

--- �ܷ�Ű
-- �⺻Ű�� �����Ѵ�.
drop table departments;
create table departments(
    department_id number(4) primary key,
    deparment_name varchar2(30) not null,
    manager_id number(6) REFERENCES employees(employee_id),
    location_id number(4)
);
select * from user_constraints where table_name = 'EMPLOYEES';

--- ������
drop table departments;
create table departments(
    department_id number(4) CONSTRAINT DEP_DEPID_PK primary key,
    deparment_name varchar2(30) not null,
    manager_id number(6) CONSTRAINT DEP_MNGID_FK 
                         REFERENCES employees(employee_id),
    location_id number(4)
);
-- TABLE ����
drop table departments;
create table departments(
    department_id number(4) ,
    deparment_name varchar2(30) not null,
    manager_id number(6),
    location_id number(4),
    CONSTRAINT DEP_DEPID_PK primary key(department_id),
    constraint dep_mngid_FK foreign key(manager_id)
    REFERENCES employees (employee_id)
);




select * from employees;
insert into departments values(90, 'Executive', 100, 1700);
select * from departments;
-- insert into departments values(100, 'Finance', 108, 1700);
delete from employees
where employee_id = 100;
-- employees �� �θ� ���̺�
-- departments �� �ڽ� ���̺�
-- �ڽ� ���̺� ����Ű�� �ִ� ��� �ڽ����̺� ������ ������ 
-- �θ����̺�(�⺻Ű)�� �����ʹ� ���� �� �� ����.
delete from departments -- �ڽ����̺�
where manager_id = 100;
delete from employees  -- �θ� ���̺�
where employee_id = 100;

-- ���սĺ���
create table a(
    a1 number primary key,
    a2 number
);
insert into a values(1,1);
create table b(
    a1 number, --�ܷ� Ű  -- �⺻Ű --- pk / fk
    b1 number,           -- �⺻Ű --- pk
    b2 number,
    CONSTRAINT b_a1_FK FOREIGN key(a1)REFERENCES a(a1),
    constraint b_a1_b1_pk primary key(a1, b1) -- ����Ű
    -- constraint b_b1_pk primary key(b1)
);
-- �⺻Ű�� ������ ���̺� �Ѱ��̴�.
-- ����Ű�� �ϳ��� �⺻Ű�� ������ �÷��� ���� ���� ���� ���Ѵ�.
-- ����Ű�� ��� �÷� ���� �ϳ��� �޶� �ߺ� ���� �ƴϴ�.
select * from a;
insert into b values(1 , 11, 11);
insert into b values(1 , 22, 22);
create table c(
    a1 number,  -- �ܷ�Ű -- fk 
    b1 number,  -- �ܷ�Ű -- fk
    c1 number,  -- �⺻Ű -- pk
    c2 number,
    constraint c_a1_b1_FK foreign key(a1,b1)
    REFERENCES b(a1, b1),
    constraint c_c1_PK primary key(c1)
);
--- check 
INSERT INTO employees VALUES 
( 100 , 'Steven' , 'King' , 'SKING' , '515.123.4567',
  '2003-06-17', 'AD_PRES'  , -24000 , NULL , NULL, 90 );
select * from employees;

create table C1(
    c1 number check (c1 > 0),
    c2 number
);

insert into c1 values( 0 , 1);
--- üũ ��������(KOSA.SYS_C008416)�� ����Ǿ����ϴ�
insert into c1 values( 1 , 1);
select * from c1;
create table c2(
    c1 number check (c1 > 0),
    c2 number check (c2 > c1)  --�� �����δ� �ȵ�
);
create table c2(
    c1 number,
    c2 number,
    check (c1 > 0),
    check (c2 > c1)
);
insert into c2 values(1, 1);
insert into c2 values(1, 2);
select * from user_constraints where table_name ='C2';

create table c2(
    c1 number check (c1 > 0),
    c2 number check (c2 > c1)  --�� �����δ� �ȵ�
);
create table c3(
    c1 number,
    c2 number,
    constraint c_c1_CK check (c1 > 0),
    constraint c_c2_CK check (c2 > c1)
);
select * from user_constraints where table_name='C3';
drop table c4;
create table c4(
    c1 number check (c1 between 1 and 100),
    c2 varchar2(20) check(c2 in ('a','b','c')),
    c3 varchar2(20) check(c3 in ('����','�λ�','�뱸','����'))
    -- c4 varchar2(20) check(c4 like '[a-f]%')
);
insert into c4(c1,c2,c3) values(100, 'c', '����');

-- ���̺� ���� : alter 
create table c5(
    c1 number,
    c2 number,
    c3 number 
);

-- c3�� name���� �÷��� ����
alter table c5
rename column c3 to name; 

desc c5;

-- name�÷��� number�� ������Ÿ���� varchar2�� ����
alter table c5
modify name varchar(20);

-- name�÷��� varchar2�� ������Ÿ���� number�� ����
alter table c5
modify name number;
--- '�̼���' 
alter table c5
modify name varchar(20);
desc c5;
alter table c5
modify name varchar(100);
desc c5;
--- �÷� �߰��ϱ�
alter table c5 
add (c4 number, c5 varchar2(30));
desc c5;
alter table c5 
add (c6 number);
desc c5;
--- �÷� ���� 
alter table c5
drop column c6;
desc c5;
---  ������ ������ �ϳ�����..
--alter table c5
--drop column (c4, c5)
drop table departments;
create table departments(
    department_id number(4) ,
    deparment_name varchar2(30),
    manager_id number(4)
);
desc departments;
alter table departments
add (location_id number(4));

alter table departments
modify manager_id number(6);
desc departments;

alter table departments
add first_name varchar2(25);
desc departments;

alter table departments
drop column first_name;
desc departments;

-- ���̺� ���� ���� �߰��ϱ�,
select * from user_constraints where table_name='DEPARTMENTS';
-- table ����
alter table departments
add constraint dep_depid_pk primary key (department_id);

alter table departments
drop constraint dep_depid_pk;

-- ������
alter table departments
modify department_id constraint dep_depid_pk primary key;

-- �ܷ�Ű
alter table departments -- table ����
add constraint dep_mng_fk FOREIGN key (manager_id)
    REFERENCES employees(employee_id);
    
alter table departments
drop constraint dep_mng_fk;

alter table departments -- ������
modify manager_id CONSTRAINT dep_mng_fk REFERENCES employees(employee_id);

select * from user_constraints where table_name='DEPARTMENTS';


alter table departments
add  (constraint dep_depid_pk primary key(department_id),
      constraint dep_mngid_fk foreign key(manager_id)
      		  REFERENCES employees (employee_id));
              
alter table departments
modify (manager_id number(4), location_id VARCHAR2(20));
--  ���ÿ� �������� �÷��� ������ �� �ִ�.
alter table departments
modify (manager_id number(6), location_id number(4));

--�������� �������� ���������� �߰��� �� �ִ�.
alter table departments
modify(
    department_id constraint dep_depid_pk primary key,
    manager_id CONSTRAINT dep_mng_fk REFERENCES employees(employee_id)
);

drop table departments;
drop table employees;

create table employees(
    employee_id number(6) ,
    first_name VARCHAR2(20),
    last_name VARCHAR2(25),
    email  VARCHAR2(25),
    phone_number  VARCHAR2(20),
    hire_date date,
    job_id  VARCHAR2(10),
    salary number(8,2),
    commission_pct number(2,2),
    manager_id number(6),
    department_id number(4)
);

create table departments(
    department_id number(4) ,
    deparment_name varchar2(30) not null,
    manager_id number(6),
    location_id number(4)
);

desc employees;
--- primary key
alter table employees
add constraint emp_empid_pk primary key(employee_id);

alter table departments
add constraint dep_depid_pk primary key(department_id);

--- foreign key
alter table employees
add constraint emp_deptid_fk foreign key(department_id)
    REFERENCES departments(department_id);

alter table departments
add constraint emp_mngid_fk FOREIGN key(manager_id)
    REFERENCES employees(employee_id);
    
--- unique
alter table employees
add constraint emp_email_UU unique(email);

-- check
alter table employees
add constraint emp_salary_CK check(salary > 0);

-- not null, default
alter table employees
modify (last_name not null, email not null, 
        hire_date default sysdate not null, job_id not null);

alter table departments
rename COLUMN deparment_name to department_name;

alter table departments
modify (department_name not null);

select * from user_constraintS where table_name = 'EMPLOYEES';
select * from user_constraintS where table_name = 'DEPARTMENTS';

---
DROP TABLE JOBS;
CREATE TABLE jobs
    ( job_id         VARCHAR2(10)
    , job_title      VARCHAR2(35) NOT NULL
    , min_salary     NUMBER(6)
    , max_salary     NUMBER(6)
    ) ;
ALTER TABLE jobs
ADD ( CONSTRAINT job_id_pk PRIMARY KEY(job_id) ) ;

CREATE TABLE job_history
    ( employee_id   NUMBER(6)NOT NULL
    , start_date    DATE NOT NULL
    , end_date      DATE  NOT NULL
    , job_id        VARCHAR2(10) NOT NULL
    , department_id NUMBER(4)
    , CONSTRAINT    jhist_date_interval
                    CHECK (end_date > start_date)
    ) ;

ALTER TABLE job_history
ADD ( CONSTRAINT jhist_emp_id_st_date_pk
      PRIMARY KEY (employee_id, start_date)) ;
      
ALTER TABLE JOB_HISTORY
ADD (CONSTRAINT     jhist_job_fk  FOREIGN KEY (job_id)
                     REFERENCES jobs
    , CONSTRAINT     jhist_emp_fk FOREIGN KEY (employee_id)
                     REFERENCES employees
    , CONSTRAINT     jhist_dept_fk FOREIGN KEY (department_id)
                     REFERENCES departments
 );
 
DESC JOBS;
INSERT INTO JOBS(JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
VALUES('AD_PRES', 'President' , 20080 , 40000);

INSERT INTO JOBS(JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY)
VALUES('AD_VP','Administration Vice President' , 15000, 30000 );

SELECT * FROM JOBS;

-- �������
ALTER TABLE departments 
DISABLE CONSTRAINT emp_mngid_fk;
desc departments;

insert into departments(DEPARTMENT_ID,DEPARTMENT_NAME,
                        MANAGER_ID, LOCATION_ID)
values(10, 'Administration', 200, 1700 );
select * from departments;
insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME,
                   MANAGER_ID, LOCATION_ID )
values(20, 'Marketing', 201, 1800);
select * from departments; -- 27
select * from employees; -- 107
 select * from jobs; -- 19
-- ���
ALTER TABLE departments 
ENABLE CONSTRAINT emp_mngid_fk;

desc job_history;

insert into job_history(
                EMPLOYEE_ID,START_DATE, END_DATE, JOB_ID, DEPARTMENT_ID)
values(102,'2001-01-13','2006-07-24','IT_PROG',60);
insert into job_history(
                EMPLOYEE_ID,START_DATE,END_DATE,JOB_ID, DEPARTMENT_ID)
values(101, '1997-09-21','2001-10-27', 'AC_ACCOUNT' , 110);
select * from job_history;
insert into job_history(
                EMPLOYEE_ID,START_DATE,END_DATE,JOB_ID, DEPARTMENT_ID)
values(101,'2001-10-28','2005-03-15','AC_MGR', 110);

select * from job_history;

select * from employees;
select * from jobs;
select * from user_constraints where table_name = 'EMPLOYEES';
SELECT * FROM user_cons_columns WHERE TABLE_NAME= 'EMPLOYEES';
ALTER TABLE EMPLOYEES
ADD CONSTRAINT EMP_JOBS_ID_fk FOREIGN KEY(JOB_ID)
   REFERENCES JOBS;
   
SELECT * FROM EMPLOYEES
WHERE FIRST_NAME = 'Lex';

DROP INDEX FIRST_NAME_IDX;

CREATE INDEX FIRST_NAME_IDX
ON EMPLOYEES(FIRST_NAME);
--- INDEX�� SELECT�� �ϸ� �ڵ����� ����ϰ� �ȴ�.
--- WHERE ���������� �ַ� ���Ǵ� �÷��� INDEX�� ����� �ش�.
--- INDEX�� SELECT�� �� ���ȴ�.
--- INDEX�� INSERT�� DELETE�� UPDATE�� INDEX�� ��ȸ�� �� �� ����ؾ� �Ǵ� ���
-- �ý��� ���ɿ� ������ ��ĥ �� �ִ�.

ALTER TABLE C
ADD CONSTRAINT C_pK PRIMARY KEY(C1,C3,C2); -- INDEX
---  ���ĵ� �÷����� �տ� ���� ���� ����
--- ���� ���Ǵ� �÷����� �տ� ���� ���� ����.

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;

--- ������ : ��ȣ �ڵ� ������
SELECT * FROM EMPLOYEES;
CREATE SEQUENCE SEQ_NUM
INCREMENT BY 10 --- ������
START WITH 207
MAXVALUE 99999999999
NOCYCLE 
NOCACHE;

CREATE SEQUENCE SEQ_NUM;
SELECT SEQ_NUM.NEXTVAL FROM DUAL;
SELECT SEQ_NUM.CURRVAL FROM DUAL;   

DESC C1;
INSERT INTO C1(C1, C2) VALUES(SEQ_NUM.NEXTVAL, 1);
SELECT * FROM C1;

SELECT * FROM DEPARTMENTS;
INSERT INTO DEPARTMENTS
VALUES(SEQ_NUM.NEXTVAL, 'TEST', 100, 1500);
SELECT * FROM DEPARTMENTS;