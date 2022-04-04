--- 테이블 복사 (테이블과 데이터를 복사)
create table emp3_7
as
select * from employees;

select * from emp3_7;

--- 테이블 구조만 복사(데이터는 복사 안됨)
create table emp3_8
as
select * from employees where 1=2;

select * from emp3_8;

-- employees에 있는 데이터를 emp3_8에 복사
insert into emp3_8 --- 데이블이 존재할 때 데이터복사 
select * from employees;

select * from emp3_8;

--일부 컬럼만 데이터 복사
insert into emp3_8(employee_id, last_name, email, hire_date, job_id,salary)
select employee_id, last_name, email, hire_date, job_id,salary
from employees;

-----변수 선언과 초기화
DECLARE 
    Myname VARCHAR2(20);--- 변수선언 
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
    Myname := 'John'; --  값을 초기화
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
END;
/


DECLARE 
    Myname VARCHAR2(20) := 'Rhee';--- 변수선언 
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
    Myname := q'\ John's day \'; --  값을 대입
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
    Myname := q'[ John's day ]'; --  값을 대입
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
END;
/

DECLARE
    first_name varchar2(20) := 'SoongMoo';
    last_name varchar2(20) default 'Rhee';--default를 이용해서 변수초기화
begin
    DBMS_OUTPUT.PUT_LINE(first_name);
    DBMS_OUTPUT.PUT_LINE(last_name);
end;
/

declare
    valid BOOLEAN := true;
BEGIN
    DBMS_OUTPUT.PUT_LINE(valid); --- 문자나 숫자만 출력가능
    valid := false;
end;
/


DECLARE --- %type:테이블의 컬럼타입을 사용할 때 
    empno employees.employee_id%type;
BEGIN
    empno := 10;
    DBMS_OUTPUT.PUT_LINE(empno);
end;
/

--- 바인드 변수
VARIABLE emp_salary NUMBER
BEGIN
    select salary into :emp_salary
    from employees where employee_id = 107;
end;
/
print emp_salary; --- 바인드 변수를 사용한 경우 프로시져가 종료된 후에도 사용가능
select * from employees
where salary = :emp_salary;


VARIABLE fname NUMBER
VARIABLE lname NUMBER
begin
    :fname := 45;
    :lname := 15;
end;
/
print fname
print lname
    

VARIABLE deptno NUMBER
SET AUTOPRINT ON --- 바인드 변수가 가진 값을 출력
BEGIN
SELECT department_id INTO :deptno
FROM employees WHERE employee_id = 100; 
END;
/

--- PL/SQL 레코드 생성
-- 필드 모음을 논리적 단위로 처리
DECLARE
    TYPE emp_record_type  is RECORD( --- 사용자 자료형
        employee_id NUMBER  NOT NULL := 100, 
        last_name employees.last_name%TYPE,
        job_id employees.job_id%TYPE
    );
    emp_record emp_record_type;
BEGIN
    emp_record.employee_id := 10;
    emp_record.last_name := 'Rhee';
    emp_record.job_id := 'AP';
    DBMS_OUTPUT.PUT_LINE(emp_record.employee_id);
    DBMS_OUTPUT.PUT_LINE(emp_record.last_name);
    DBMS_OUTPUT.PUT_LINE(emp_record.job_id);
end;
/

DECLARE
    TYPE emp_record_type  is RECORD( --- 사용자 자료형
        employee_id NUMBER  NOT NULL := 100, 
        last_name employees.last_name%TYPE,
        job_id employees.job_id%TYPE
    );
    emp_record emp_record_type;
BEGIN
    select employee_id, last_name, job_id
    into emp_record.employee_id, emp_record.last_name,emp_record.job_id
    from employees where employee_id = emp_record.employee_id;
    DBMS_OUTPUT.PUT_LINE(emp_record.employee_id);
    DBMS_OUTPUT.PUT_LINE(emp_record.last_name);
    DBMS_OUTPUT.PUT_LINE(emp_record.job_id);
end;
/

--- %ROWTYPE
-- 기본 데이터베이스 열과 데이터 유형
-- SELECT * 문을 사용하여 행을 검색할 때 유용합니다.
DECLARE
    emp_rec employees%ROWTYPE;
BEGIN
    select * into emp_rec
    from employees where employee_id = &employee_id;
    insert into emp3_7(
    employee_id, last_name, email, hire_date, salary, job_id)
    values(emp_rec.employee_id, emp_rec.last_name,
    emp_rec.email,emp_rec.hire_date, emp_rec.salary,
    emp_rec.job_id);
end;
/
select * from emp3_7;
desc employees;

DECLARE
    emp_rec emp3_7%rowtype;
BEGIN
    select * into emp_rec from employees
    where employee_id = &empid;
    insert into emp3_7 values emp_rec;
end;
/
    
select * from emp3_7 where employee_id = 178;

--- 레코드를 사용하여 테이블의 행 갱신
DECLARE 
    emp_rec emp3_7%rowtype;
BEGIN
    emp_rec.hire_date := sysdate;
    update emp3_7 
    set hire_date = emp_rec.hire_date
    where employee_id = &empid;
end;
/
select * from emp3_7 where employee_id = 100;

-- INDEX BY 테이블 : 
-- 정수 또는 문자열 데이터 유형의 Primary Key 
--   : BINARY_INTEGER 및 PLS_INTEGER : 크기 작아야 하므로
DECLARE
    TYPE dept_table_type IS TABLE OF
        departments%ROWTYPE -- departments에 있는 모든 컬럼
        INDEX BY PLS_INTEGER;
    dept_table dept_table_type;
    max_count NUMBER(3) := 20;
BEGIN
    for i in 1..max_count  loop   
        select * into  dept_table(i) from departments
        where department_id = i * 10;
    end loop;
    for i in dept_table.first..dept_table.last loop
        insert into dept3_1 values dept_table(i);
    end loop;
end;
/
select count(*) from departments;
create table dept3_1
as 
select * from departments where 1=2;
select * from dept3_1;

DECLARE
    CURSOR emp_cursor IS 
        SELECT employee_id, last_name FROM employees
        WHERE department_id =30;
    empno employees.employee_id%TYPE;
    lname employees.last_name%TYPE;
BEGIN
    OPEN emp_cursor;
    FETCH emp_cursor INTO empno, lname;
    DBMS_OUTPUT.PUT_LINE( empno ||' '||lname); 
END;
/

DECLARE
    CURSOR emp_cursor is 
        select * from employees where department_id = &deptid;
    emp employees%rowtype;
BEGIN
    if not emp_cursor%isopen then -- 커서가 열려 있는지 테스트
        OPEN emp_cursor;
    end if;
    loop 
        FETCH emp_cursor into emp;
        -- %rowcount:커서가 움직일 때 마다 1씩 증가하는 값을 가진다.
        --           지금까지 반환된 행의 수
        EXIT WHEN emp_cursor%notfound or emp_cursor%rowcount > 10;
        DBMS_OUTPUT.PUT_LINE(
            emp.first_name || '  ' || emp.last_name||' '
            ||emp.department_id);
    end loop;
    CLOSE emp_cursor;
end;
/

--- subquery를 사용하는 커서 FOR 루프
BEGIN
    for emp_record in (select employee_id, last_name
                       from employees where department_id = 30) loop
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || '  ' 
                            || emp_record.last_name);
    end loop;
end;
/


--- 파라미터가 포함된 커서
DECLARE
    CURSOR emp_cursor(deptno NUMBER) is
        SELECT * FROM employees
        WHERE department_id = deptno;
    emp employees%rowtype;
BEGIN
    OPEN emp_cursor (10);
    loop 
        FETCH emp_cursor into emp;
        EXIT when emp_cursor%notfound;
        DBMS_OUTPUT.PUT_LINE(emp.employee_id || ' ' || emp.first_name 
            || '   ' || emp.department_id);
    end loop;
end;
/

DECLARE
    CURSOR emp_cursor(deptno NUMBER) is
        select * from employees 
        where department_id = deptno;
begin
    for emp in emp_cursor (10) loop
        DBMS_OUTPUT.PUT_LINE(emp.employee_id || ' ' || emp.first_name 
            || '   ' || emp.department_id);
    end loop;
end;
/


--- 파라미터가 있는 커서를 만들 때 부서 번호와 직무를 받도록 하고
--- 이름, 직무 부서번호를 부서번호와 직무에 해당하는 사원이 출력되게 하세요.
DECLARE
    CURSOR emp_cursor(deptno NUMBER, jobid varchar2) is
        SELECT * FROM employees
        WHERE department_id = deptno and job_id = jobid;
    emp employees%rowtype;
BEGIN
    OPEN emp_cursor (30 , 'PU_CLERK');
    loop 
        FETCH emp_cursor into emp;
        EXIT when emp_cursor%notfound;
        DBMS_OUTPUT.PUT_LINE(emp.first_name || ' ' || emp.job_id 
            || '   ' || emp.department_id);
    end loop;
end;
/
select * from employees where department_id = 30;

DECLARE
    CURSOR emp_cursor(deptno NUMBER, jobid varchar2) is
        SELECT * FROM employees
        WHERE department_id = deptno and job_id = jobid;
BEGIN
    for emp in emp_cursor (30 , 'PU_CLERK') loop
        DBMS_OUTPUT.PUT_LINE(emp.first_name || ' ' || emp.job_id 
            || '   ' || emp.department_id);
    end loop;
end;
/

select * from emp3_7
for update nowait; --- 잠금

DECLARE
    CURSOR emp_cursor IS 
        select * from emp3_7
        where department_id = 80 for update of salary;
        emp emp3_7%rowtype;
BEGIN
    OPEN emp_cursor ;
    loop 
    fetch emp_cursor into emp;
    EXIT when emp_cursor%notfound;
     DBMS_OUTPUT.PUT_LINE(emp.last_name || '  ' || emp.salary);
    end loop;
end;
/

DECLARE
    CURSOR emp_cursor(deptno NUMBER) is
        select * from emp3_7 where department_id = deptno
        for update;
    emp emp3_7%rowtype;
begin
    OPEN emp_cursor (10);
    loop
        FETCH emp_cursor into emp;
        EXIT when emp_cursor%notfound;
        update emp3_7 
        set salary = salary * 1.1
        where  CURRENT of emp_cursor; -- 현재 커서에 해당하는 행을 update
    end loop;
end;
/

DECLARE
    lname VARCHAR2(200);
BEGIN
    SELECT last_name INTO lname FROM employees 
    WHERE first_name='John'; 
    DBMS_OUTPUT.PUT_LINE (lname);
    EXCEPTION 
    when TOO_MANY_ROWS then
    DBMS_OUTPUT.PUT_LINE('행의 수가 너무 많아요');     
    when NO_DATA_FOUND then
    DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');   
    when INVALID_CURSOR or  ZERO_DIVIDE  or DUP_VAL_ON_INDEX then
    DBMS_OUTPUT.PUT_LINE('커서가 정확하지 않다. 0으로 나누지 못함.');
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('나머지.');
END;
/

create SEQUENCE dept_NUM
INCREMENT BY 10
start WITH 400;

-- 프로시저 및 함수
CREATE or REPLACE PROCEDURE add_dept 
is
    dept_id dept.department_id%TYPE;
    dept_name dept.department_name%TYPE;
BEGIN
    dept_id := 320;
    dept_name:='개발부';
    INSERT INTO dept(department_id, department_name)
    values(DEPT_NUM.nextval, dept_name);
    DBMS_OUTPUT.PUT_LINE(' Inserted '|| SQL%ROWCOUNT ||' row ');
end;
/
exec add_dept;
select * from dept where department_id = 320;

CREATE OR REPLACE PROCEDURE update_sal 
(v_empno    IN    NUMBER) 
is 
begin
    update emp3_7
    set salary = salary * 1.1
    where employee_id =  v_empno;
end;
/
exec update_sal(100);
select * from emp3_7 where employee_id = 100;

CREATE OR REPLACE PROCEDURE prc_tree 
(
    v_emp_code IN VARCHAR2,
    p_code OUT VARCHAR2,
    t_code OUT VARCHAR2
)    
is 
begin
    select department_id, job_id  into p_code, t_code
    from employees
    where employee_id = v_emp_code;
end prc_tree;
/

declare
    aaa VARCHAR2(20);
    bbb VARCHAR2(20);
begin
    prc_tree ('100', aaa, bbb);
    dbms_output.put_line(aaa || '   ' || bbb);
end;
/

CREATE OR REPLACE PROCEDURE sal_mng
(
    empid in varchar2,
    sal out number,
    mng out number    
)
is
begin 
    select salary, manager_id into sal, mng
    from employees where employee_id = empid;
end;
/

DECLARE
    aaa number;
    bbb number;
begin
    sal_mng('110', aaa, bbb);
    dbms_output.put_line(aaa || '   ' || bbb);
end;
/

CREATE OR REPLACE PROCEDURE emp_del_proc
(empid in number)
is
begin
    delete from emp3_7
    where employee_id = empid;
    commit;
end;
/
exec emp_del_proc(300);

--- 1. 프로시져를 이용해서 emp3_7에 직원정보를 입력하세요.

--- 2. jobs_exam을 만들어서 'AD_PRES'를 프로시저에 인자값으로 전달하고
--- 없으면 jobs 에서  insert 있으면 min_salary는 2000, max_salary는 6000
--- 으로 update 하시오
--- EXEC my_new_job_proc ('AD_PRES', 2000, 6000);




