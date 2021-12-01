--- 1. 프로시져를 이용해서 emp3_7에 직원정보를 입력하세요.
CREATE OR REPLACE PROCEDURE proc_insert(
    empid in number,
    lname in varchar2,
    MAIL in varchar2,
    hdate in varchar2,
    jid in varchar2
)
is
begin 
    -- DML문 select, insert, update, delete, subquery
    insert into emp3_7(employee_id, last_name, email, hire_date,job_id)
    values(empid, lname, MAIL, hdate,jid); 
end;
/
exec proc_insert(310, 'Park', 'PARK', sysdate, 'AP');
select * from emp3_7 where employee_id = 310;
--- 2. jobs_exam을 만들어서 'AD_PRES'를 프로시저에 인자값으로 전달하고
--- 없으면 jobs 에서  insert 있으면 min_salary는 2000, max_salary는 6000
--- 으로 update 하시오
--- EXEC my_new_job_proc ('AD_PRES', 2000, 6000);

create table jobs_exam
as 
select * from jobs where 1=2;

delete from jobs_exam;

CREATE OR REPLACE PROCEDURE   my_new_job_proc(
    jid in varchar2,
    minsal number,
    maxsal number
)
is 
    cnt number;
begin
    select count(*) into cnt from jobs_exam where job_id =  jid;
    if cnt = 0 then
        insert into jobs_exam 
        select * from jobs where job_id = jid;
    else
        update jobs_exam
        set min_salary = minsal, max_salary = maxsal
        where job_id = jid;
    end if;
end;
/
desc jobs_exam;
EXEC my_new_job_proc ('AD_PRES', 2000, 6000);
select * from jobs_exam;

CREATE or REPLACE FUNCTION check_sal
RETURN boolean
is
    dept_id employees.department_id%type;
    emp_no employees.employee_id%type;
    sal employees.salary%type;
    avg_sal employees.salary%type;
begin
    emp_no := 100;
    select salary, department_id into sal, dept_id
    from employees
    where employee_id = emp_no;
    --- 100사원의 부서의 평균 급여
    select avg(salary) into avg_sal from employees
    where department_id = dept_id;
    DBMS_OUTPUT.PUT_LINE(avg_sal || '   ' || sal); 
    if sal > avg_sal then
        return true;
    else
        return false;
    end if;
end;
/
--var aaa varchar2(20);
--exec :aaa := check_sal();
--print aaa;

begin  --- 반환값이 boolean인 경우 if문 사용
    if (check_sal is null) then
        DBMS_OUTPUT.PUT_LINE('check_sal가 null입니다.');
    elsif (check_sal) then
        DBMS_OUTPUT.PUT_LINE('Salary > average');
    else 
        DBMS_OUTPUT.PUT_LINE('Salary < average');
    end if;
end;
/

CREATE OR REPLACE FUNCTION FC_update_sal
(v_empno         IN    NUMBER)
return number
is
    sal employees.salary%type;
begin
    update emp3_7
    set salary = salary * 1.1
    where employee_id = v_empno;
    
    select salary into sal from emp3_7 where employee_id = v_empno;
    return sal; -- 리턴문이 꼭 존재해야 합니다.
end;
/

var sal1 number; 
exec :sal1 := FC_update_sal(110);
print sal1;
-- EMP3_7 테이블에서 이름으로 부서 번호를 검색하는 함수를 작성하여라
CREATE OR REPLACE FUNCTION ename_deptno
(   v_ename IN      employees.first_name%TYPE)
RETURN NUMBER
is 
    emptid employees.department_id%type;
begin 
    select department_id into emptid from employees
    where first_name = v_ename;
    DBMS_OUTPUT.PUT_LINE(emptid);
    return emptid;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('데이터가 없습니다.');
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('2건 이상입니다.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('기타 에러입니다.');
end;
/
VAR g_deptno NUMBER;
EXECUTE :g_deptno := ename_deptno('Neena')
print g_deptno;


select * from employees;
    

-- EMP 테이블에서 이름을 입력 받아 부서번호,부서명,급여를 검색하는 FUNCTION을 작성하여라. 
-- 단 부서번호를 RETURN에 사용하여라.
CREATE OR REPLACE FUNCTION emp_disp(
        v_ename IN      employees.first_name%TYPE,
        v_dname OUT     departments.department_name%TYPE,
        v_sal   OUT     employees.salary%TYPE)
RETURN NUMBER
IS
        v_deptno       employees.department_id%TYPE;
        v_dname_temp   departments.department_name%TYPE;
        v_sal_temp     employees.salary%TYPE;
BEGIN
        SELECT salary,department_id
               INTO v_sal_temp,v_deptno
               FROM employees
               WHERE upper(first_name) = UPPER(v_ename);
        SELECT department_name
               INTO v_dname_temp
               FROM departments
               WHERE department_id = v_deptno;
        v_dname := v_dname_temp; -- output 변수에 저장
        v_sal := v_sal_temp; -- output변수에 저장
        DBMS_OUTPUT.PUT_LINE('성    명 : ' || v_ename);
        DBMS_OUTPUT.PUT_LINE('부서번호 : ' || TO_CHAR(v_deptno));
        DBMS_OUTPUT.PUT_LINE('부 서 명 : ' || v_dname_temp);
        DBMS_OUTPUT.PUT_LINE('급    여 : ' || TO_CHAR(v_sal_temp,'$999,999'));
        RETURN v_deptno;
EXCEPTION
        WHEN NO_DATA_FOUND THEN
               DBMS_OUTPUT.PUT_LINE('입력한 MANAGER는 없습니다.');
        WHEN TOO_MANY_ROWS THEN
               DBMS_OUTPUT.PUT_LINE('자료가 2건 이상입니다.');
        WHEN OTHERS THEN
               DBMS_OUTPUT.PUT_LINE('기타 에러입니다.');
END;
/

VAR g_deptno NUMBER;
VAR g_dname VARCHAR2(20);
VAR g_sal NUMBER;
EXECUTE :g_deptno := emp_disp('Neena',:g_dname,:g_sal)
PRINT g_dname;
print g_sal;
print g_deptno;

--- 입사일 구하는 함수를 만들어 보자 : 사원번호를 이용.
CREATE OR REPLACE FUNCTION get_hiredate 
( v_empno NUMBER , v_fmt VARCHAR2)
return VARCHAR2
IS 
    v_hiredate VARCHAR2(20);
begin
    select to_char(hire_date,v_fmt) into  v_hiredate 
    from employees
    where employee_id = v_empno;
    return v_hiredate;
end;
/
var hire_date varchar2
exec :hire_date := get_hiredate(100, 'dd-mm-yyyy');
print hire_date;

-- 연봉계산
CREATE OR REPLACE FUNCTION get_annual_sal 
(v_empno NUMBER)
RETURN NUMBER 
IS 
    v_sal NUMBER;
BEGIN
  SELECT salary *(1 + NVL(commission_pct,0)) * 12 INTO v_sal
  FROM emp WHERE employee_id = v_empno;
  RETURN v_sal;
END;
/
var v_sal number;
exec :v_sal := get_annual_sal(100);
print v_sal;

-- 퇴직급여계산
CREATE OR REPLACE FUNCTION get_refire_money(v_empno NUMBER)
RETURN NUMBER 
IS 
    v_sal NUMBER;
BEGIN
  SELECT ROUND (salary * (1+ NVL(commission_pct, 0))
    * ROUND(MONTHS_BETWEEN(SYSDATE, HIRE_DATE), 0) /12 , 0)
   INTO v_sal FROM employees WHERE employee_id = v_empno;
   RETURN v_sal;
END;
/

var refire_money number;
exec :refire_money := get_refire_money(100);
print refire_money;



