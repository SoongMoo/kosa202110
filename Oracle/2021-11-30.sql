--- ���̺� ���� (���̺�� �����͸� ����)
create table emp3_7
as
select * from employees;

select * from emp3_7;

--- ���̺� ������ ����(�����ʹ� ���� �ȵ�)
create table emp3_8
as
select * from employees where 1=2;

select * from emp3_8;

-- employees�� �ִ� �����͸� emp3_8�� ����
insert into emp3_8 --- ���̺��� ������ �� �����ͺ��� 
select * from employees;

select * from emp3_8;

--�Ϻ� �÷��� ������ ����
insert into emp3_8(employee_id, last_name, email, hire_date, job_id,salary)
select employee_id, last_name, email, hire_date, job_id,salary
from employees;

-----���� ����� �ʱ�ȭ
DECLARE 
    Myname VARCHAR2(20);--- �������� 
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
    Myname := 'John'; --  ���� �ʱ�ȭ
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
END;
/
print Myname;


DECLARE 
    Myname VARCHAR2(20) := 'Rhee';--- �������� 
BEGIN
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
    Myname := q'\ John's day \'; --  ���� ����
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
    Myname := q'[ John's day ]'; --  ���� ����
    DBMS_OUTPUT.PUT_LINE('My name is: '||Myname);
END;
/

DECLARE
    first_name varchar2(20) := 'SoongMoo';
    last_name varchar2(20) default 'Rhee';--default�� �̿��ؼ� �����ʱ�ȭ
begin
    DBMS_OUTPUT.PUT_LINE(first_name);
    DBMS_OUTPUT.PUT_LINE(last_name);
end;
/

declare
    valid BOOLEAN := true;
BEGIN
    DBMS_OUTPUT.PUT_LINE(valid); --- ���ڳ� ���ڸ� ��°���
    valid := false;
end;
/


DECLARE --- %type:���̺��� �÷�Ÿ���� ����� �� 
    empno employees.employee_id%type;
BEGIN
    empno := 10;
    DBMS_OUTPUT.PUT_LINE(empno);
end;
/

--- ���ε� ����
VARIABLE emp_salary NUMBER
BEGIN
    select salary into :emp_salary
    from employees where employee_id = 107;
end;
/
print emp_salary; --- ���ε� ������ ����� ��� ���ν����� ����� �Ŀ��� ��밡��
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
SET AUTOPRINT ON --- ���ε� ������ ���� ���� ���
BEGIN
SELECT department_id INTO :deptno
FROM employees WHERE employee_id = 100; 
END;
/

--- PL/SQL ���ڵ� ����
-- �ʵ� ������ ���� ������ ó��
DECLARE
    TYPE emp_record_type  is RECORD( --- ����� �ڷ���
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
    TYPE emp_record_type  is RECORD( --- ����� �ڷ���
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
-- �⺻ �����ͺ��̽� ���� ������ ����
-- SELECT * ���� ����Ͽ� ���� �˻��� �� �����մϴ�.
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

--- ���ڵ带 ����Ͽ� ���̺��� �� ����
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

-- INDEX BY ���̺� : 
-- ���� �Ǵ� ���ڿ� ������ ������ Primary Key 
--   : BINARY_INTEGER �� PLS_INTEGER : ũ�� �۾ƾ� �ϹǷ�
DECLARE
    TYPE dept_table_type IS TABLE OF
        departments%ROWTYPE -- departments�� �ִ� ��� �÷�
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
    if not emp_cursor%isopen then -- Ŀ���� ���� �ִ��� �׽�Ʈ
        OPEN emp_cursor;
    end if;
    loop 
        FETCH emp_cursor into emp;
        -- %rowcount:Ŀ���� ������ �� ���� 1�� �����ϴ� ���� ������.
        --           ���ݱ��� ��ȯ�� ���� ��
        EXIT WHEN emp_cursor%notfound or emp_cursor%rowcount > 10;
        DBMS_OUTPUT.PUT_LINE(
            emp.first_name || '  ' || emp.last_name||' '
            ||emp.department_id);
    end loop;
    CLOSE emp_cursor;
end;
/

--- subquery�� ����ϴ� Ŀ�� FOR ����
BEGIN
    for emp_record in (select employee_id, last_name
                       from employees where department_id = 30) loop
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || '  ' 
                            || emp_record.last_name);
    end loop;
end;
/


--- �Ķ���Ͱ� ���Ե� Ŀ��
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


--- �Ķ���Ͱ� �ִ� Ŀ���� ���� �� �μ� ��ȣ�� ������ �޵��� �ϰ�
--- �̸�, ���� �μ���ȣ�� �μ���ȣ�� ������ �ش��ϴ� ����� ��µǰ� �ϼ���.
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

























