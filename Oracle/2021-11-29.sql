DECLARE
    v_fname varchar2(20);
begin 
    select first_name
    into v_fname
    from employees
    where employee_id = 100;
    DBMS_OUTPUT.PUT_LINE(v_fname);
end;
/

DECLARE
--    emp_hiredate date;
--    emp_deptno number(2) not null := 10;
--    c_comm CONSTANT number := 1400; -- 상수
    vn_num1 NUMBER := 1; --- 초기값
    vn_num2 NUMBER := 2 ;
BEGIN
    if vn_num1 >= vn_num2 then 
        DBMS_OUTPUT.PUT_LINE(vn_num1 || '이 큰 수 입니다');
    else
        DBMS_OUTPUT.PUT_LINE(vn_num2 || '이 큰 수 입니다');
    end if;
end;
/
        
DECLARE
    employee_id number(6);--같은 이름의 식별자는 사용하지 않는 것이 좋다
BEGIN
    select employee_id --- 같은 테이블이 아닌 다른 테이블인 경우
    into employee_id  -- 제한적으로 사용하는 것이 좋다.
    from employees
    where last_name= 'Kochhar';
    DBMS_OUTPUT.PUT_LINE(employee_id);
end;
/
DECLARE
    num1 number(10,3);
    bf_var BINARY_FLOAT;
    bd_var BINARY_DOUBLE;
BEGIN
    num1  := 270/35;
    bf_var := 270/35f;
    bd_var := 140d/0.35;
    DBMS_OUTPUT.PUT_LINE('number: '|| num1);
    DBMS_OUTPUT.PUT_LINE('bf: '|| bf_var);
    DBMS_OUTPUT.PUT_LINE('bd: '|| bd_var);
END;
/
-- NUMBER 데이터 유형에서 저장할 수 있는 값 범위를 벗어난
-- 값을 저장합니다

--- %TYPE 속성
-- 데이터베이스 열 정의
-- 선언된 다른 변수
--emp_lname employees.last_name%TYPE;
--balance NUMBER(7,2);
--min_balance balance%TYPE := 1000;

DECLARE
    v_lastname employees.last_name%type;
    v_firstname employees.first_name%type;
BEGIN
    select last_name, first_name
    into v_lastname, v_firstname
    from employees
    where employee_id = 143;
    DBMS_OUTPUT.PUT_LINE(v_lastname);
    DBMS_OUTPUT.PUT_LINE(v_firstname);
end;
/

DECLARE 
    flag BOOLEAN := FALSE;
BEGIN 
    flag := TRUE;
    -- DBMS_OUTPUT.PUT_LINE(flag);
END;
/

--- 바인드 변수
-- 호스트 변수라고도  함
-- VARIABLE 키워드를 사용하여 생성
-- PL/SQL 블록이 실행된 후에도 액세스할 수 있다.
--VARIABLE return_code NUMBER
--VARIABLE return_msg VARCHAR2(30)

VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
BEGIN
    SELECT salary 
    INTO :emp_salary  --- VARIABLE변수
    from employees
    where employee_id = 143;
    -- DBMS_OUTPUT.PUT_LINE(emp_salary);
    -- emp_salary가 declare로 선연되어 있어야 한다.
end;
/
--- 치환변수
-- 유저 입력을 얻는 데 사용
-- 앞에 앰퍼샌드(&)를 붙여 PL/SQL 블록 내에서 참조
-- 실행 중에 얻을 수 있는 값을 직접 코딩하는 것을 피할 수 있다.


VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6):= &empno; -- 치환변수
BEGIN
SELECT salary INTO :emp_salary 
FROM employees WHERE employee_id = empno; 
END;
/

SET VERIFY OFF
VARIABLE emp_salary NUMBER
ACCEPT empno PROMPT '사원번호를 입력해주세요 : '
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6):= &empno; -- 치환변수
BEGIN
SELECT salary INTO :emp_salary 
FROM employees WHERE employee_id = empno; 
END;
/

DECLARE
    outer_variable VARCHAR2(20):= 'GLOBAL VARIABLE';
BEGIN
    DECLARE
        inner_variable VARCHAR2(20):='LOCAL VARIABLE';
    BEGIN
        DBMS_OUTPUT.PUT_LINE(inner_variable);
        DBMS_OUTPUT.PUT_LINE(outer_variable);
    END;
    DBMS_OUTPUT.PUT_LINE(outer_variable); 
    ---DBMS_OUTPUT.PUT_LINE(inner_variable);
END;
/


DECLARE
    fname VARCHAR2(20) := 'Patrick';
    hdate date := '2000-01-20';
BEGIN
    DECLARE
        lname VARCHAR2(20) := 'Mike';
        hdate date := '2001-12-25';
    BEGIN
        DBMS_OUTPUT.PUT_LINE(lname);
        DBMS_OUTPUT.PUT_LINE(hdate); -- 같은 이름의 변수가 선언된경우
                                     -- 같은 블럭안에 있는 것이 우선한다.
        DBMS_OUTPUT.PUT_LINE(fname); 
    end;
    DBMS_OUTPUT.PUT_LINE(hdate);
end;
/

BEGIN <<outer>> -- 식별자의 명확한 지정
DECLARE
    fname VARCHAR2(20) := 'Patrick';
    hdate date := '2000-01-20';
BEGIN
    DECLARE
        lname VARCHAR2(20) := 'Mike';
        hdate date := '2001-12-25';
    BEGIN
        DBMS_OUTPUT.PUT_LINE(lname);
        DBMS_OUTPUT.PUT_LINE(hdate);
        DBMS_OUTPUT.PUT_LINE(outer.hdate);
        DBMS_OUTPUT.PUT_LINE(fname); 
    end;
    DBMS_OUTPUT.PUT_LINE(hdate);
end;
end outer;
/



SET SERVEROUTPUT ON
DECLARE 
    sum_sal NUMBER(10,2); 
    deptno NUMBER NOT NULL := 60; 
BEGIN
    SELECT SUM(salary) -- group function
    INTO sum_sal FROM employees
    WHERE department_id = deptno;
    DBMS_OUTPUT.PUT_LINE ('60부서의 급여의 합계갑은 : '|| sum_sal);
END;
/

DECLARE -- 모호성을 방지
-- 데이터베이스 열 이름을 식별자로 사용하지 않는다
-- 로컬 변수와 형식 파라미터의 이름은 데이터베이스 테이블의 이름보다 우선
    hire_date employees.hire_date%TYPE;
    sysdate hire_date%TYPE;
    employee_id employees.employee_id%TYPE := 176; 
BEGIN
    SELECT hire_date, sysdate
    INTO hire_date, sysdate
    FROM employees
    WHERE employee_id = employee_id; 
END;
/

create SEQUENCE employees_seq;

BEGIN
INSERT INTO emp
    (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES(employees_seq.NEXTVAL,'Ruth','Cores','RCORES',sysdate, 'AD_ASST', 4000);
END;
/

select * from emp;


SET VERIFY OFF
ACCEPT fname PROMPT '사원이름을 입력해주세요 : '
ACCEPT lname PROMPT '사원성을 입력해주세요 : '
ACCEPT mail PROMPT '사원이메일을 입력해주세요 : '
ACCEPT hdate PROMPT '사원입사일을 yyyy-mm-dd 형식으로 입력해주세요 : '
ACCEPT jid PROMPT '사원 업무를 입력해주세요 : '
ACCEPT sal PROMPT '사원 급여를 입력해주세요 : '
SET AUTOPRINT ON
DECLARE
    fname emp.first_name%type := &fname;  -- 치환변수
    lname emp.last_name%type:= &lname;
    mail emp.email%type:= &mail;
    hdate emp.hire_date%type := &hdate;
    jid emp.job_id%type := &jid;
    sal emp.salary%type := &sal;
BEGIN
    INSERT INTO emp
    (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES(employees_seq.NEXTVAL,fname,lname,mail,hdate, jid,sal);
    DBMS_OUTPUT.PUT_LINE ('정상적으로 저장되었습니다.');
END;
/


DECLARE
    sal_increase employees.salary%TYPE := 800; 
BEGIN
    UPDATE employees
    SET salary = salary + sal_increase
    WHERE job_id = 'ST_CLERK';
    DBMS_OUTPUT.PUT_LINE('ST_CLERK 데이터가 수정되었습니다');
END;
/

DECLARE
    empid emp.employee_id%TYPE := 3; 
BEGIN
    DELETE FROM emp
    WHERE employee_id = empid;
    DBMS_OUTPUT.PUT_LINE(empid || '번 사원이 삭제되었습니다.');
END;
/

DECLARE
    empno EMP.EMPLOYEE_ID%TYPE := 200;
BEGIN
merge into ex3_6 a
    using (select * from emp where employee_id = empno) b
    on (a.employee_id = b.employee_id)
WHEN MATCHED THEN 
    update set salary = salary * 1.1
WHEN not MATCHED THEN
    insert (a.EMPLOYEE_ID, a.EMP_NAME, a.SALARY, a.MANAGER_ID )
    values (b.employee_id, b.first_name, 15000, 100);
END;
/    
select * from ex3_6;



DECLARE
    myage number:=31;
BEGIN
    if myage < 11 then
        DBMS_OUTPUT.put_line('저는 11살 미만입니다.');
    else
        DBMS_OUTPUT.put_line('저의 나이는 ' || myage ||'입니다.');
    end if;
end;
/
--- 급여를 1000으로 나눈 몫이 3이하면 사원 
--                          5이하면 주임
--                          7이하면 대리
--                          9이하면 과장
--                          10이하면 차장
--                          13이하면 부장
--                          15이하면 본부장
--                          그외엔 이사 로 출력하세요
-- 를 프로시져로 만들어서 사용하세요.
DECLARE 
    empid emp.employee_id%type := 130; 
    sal number;
BEGIN
    SELECT trunc(salary / 1000) 
    INTO sal
    FROM employees
    WHERE employee_id = empid; 
    if sal <= 3 then 
        DBMS_OUTPUT.put_line('사원');
    elsif sal <= 5 then
        DBMS_OUTPUT.put_line('주임');
    elsif sal <= 7 then
        DBMS_OUTPUT.put_line('대리');
    elsif sal <= 9 then
        DBMS_OUTPUT.put_line('과장');
    elsif sal <= 10 then
        DBMS_OUTPUT.put_line('차장');
    elsif sal <= 13 then
        DBMS_OUTPUT.put_line('부장');
    elsif sal <= 15 then
        DBMS_OUTPUT.put_line('본부장');
    else
        DBMS_OUTPUT.put_line('이사');
    end if;        
END;
/


--- 급여를 1000으로 나눈 몫이 3이하면 사원 
--                          5이하면 주임
--                          7이하면 대리
--                          9이하면 과장
--                          10이하면 차장
--                          13이하면 부장
--                          15이하면 본부장
--                          그외엔 이사 로 출력하세요
-- 를 프로시져로 만들어서 사용하세요.
-- case 문으로


DECLARE 
    empid emp.employee_id%type := 130; 
    grade varchar2(20); 
BEGIN
    select
    case when trunc(salary / 1000) <= 3 then '사원'
             when trunc(salary / 1000) between 4 and 5 then '주임'
             when trunc(salary / 1000) <= 7 then '대리'
             when trunc(salary / 1000) <= 9 then '과장'
             when trunc(salary / 1000) <= 10 then '차장'
             when trunc(salary / 1000) <= 13 then '부장'
             when trunc(salary / 1000) <= 15 then '본부장'
             else '이사' end
    into grade
    from emp
    where employee_id = empid;
    DBMS_OUTPUT.put_line('직원의 직책은 : ' || grade);
end;
/

DECLARE
    grade CHAR(1)  := UPPER('&grade');
    result1  VARCHAR2(30);
BEGIN
    result1 :=
    case grade 
        when 'A' then '90점 이상입니다.'
        when 'B' then '80점 이상입니다.'
        when 'C' then '70점 이상입니다.'
        when 'D' then '60점 이상입니다.'
        when 'F' then '60점 미만입니다.'
    end;
    DBMS_OUTPUT.PUT_LINE( 'grade : ' || grade || ' 일 때 ' || result1) ; 
end;
/

DECLARE 
    empid emp.employee_id%type := &empid; 
    sal number;
    result1 varchar2(30);
BEGIN
    SELECT trunc(salary / 1000) 
    INTO sal
    FROM employees
    WHERE employee_id = empid; 
    /* case로 변경하시오 */
    result1 :=
    case when sal <= 3 then '사원'
        when sal <= 5 then  '주임'
        when sal <= 7 then '대리'
        when sal <= 9 then '과장'
        when sal <= 10 then '차장'
        when sal <= 13 then '부장'
        when sal <= 15 then '본부장'
        else '이사'
    end;        
    DBMS_OUTPUT.PUT_LINE('직원의 직책은 : ' || result1 || '입니다');
END;
/

DECLARE
    grade CHAR(1) := UPPER('&grade');
BEGIN
    case 
        when grade = 'A' THEN DBMS_OUTPUT.PUT_LINE('Excellent');
        when grade in ('B','C') THEN DBMS_OUTPUT.PUT_LINE('Good');
        else DBMS_OUTPUT.PUT_LINE('No such grade');
    end case;
end;
/
---- 부서장번호를 입력 받아서 부서장의 부서번호와 부서이름을 가져오고
--- 그 부서의 사원수도 가지고 오세요. 
--- 108사원 부서장의 부서는 90번이고 부서명은 영업부이며 사원수는 20명입니다.
select * from departments where manager_id is not null;

DECLARE
    deptid NUMBER;
    deptname VARCHAR2(20);
    emps NUMBER;
    mngid NUMBER:= &mngid; 
BEGIN
    case mngid 
        WHEN 200 then 
            select department_id , department_name 
            into deptid, deptname
            from departments
            where manager_id =  mngid;
            select count(*) into emps
            from employees where department_id = deptid;
        WHEN 201 then 
            select department_id , department_name 
            into deptid, deptname
            from departments
            where manager_id =  mngid;
            select count(*) into emps
            from employees where department_id = deptid;
        WHEN 114 then 
            select department_id , department_name 
            into deptid, deptname
            from departments
            where manager_id =  mngid;
            select count(*) into emps
            from employees where department_id = deptid;
     end case;
     DBMS_OUTPUT.PUT_LINE(
     mngid || '부서장의 부서는' ||deptid||'번이고 부서명은' ||deptname
     ||'이며 사원수는 '||emps||'명입니다.');
end;
/
select * from employees where department_id = 10;








