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

select * from emp3_7
for update nowait; --- ���

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
        where  CURRENT of emp_cursor; -- ���� Ŀ���� �ش��ϴ� ���� update
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
    DBMS_OUTPUT.PUT_LINE('���� ���� �ʹ� ���ƿ�');     
    when NO_DATA_FOUND then
    DBMS_OUTPUT.PUT_LINE('�����Ͱ� �����ϴ�.');   
    when INVALID_CURSOR or  ZERO_DIVIDE  or DUP_VAL_ON_INDEX then
    DBMS_OUTPUT.PUT_LINE('Ŀ���� ��Ȯ���� �ʴ�. 0���� ������ ����.');
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('������.');
END;
/

create SEQUENCE dept_NUM
INCREMENT BY 10
start WITH 400;

-- ���ν��� �� �Լ�
CREATE or REPLACE PROCEDURE add_dept 
is
    dept_id dept.department_id%TYPE;
    dept_name dept.department_name%TYPE;
BEGIN
    dept_id := 320;
    dept_name:='���ߺ�';
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

--- 1. ���ν����� �̿��ؼ� emp3_7�� ���������� �Է��ϼ���.

--- 2. jobs_exam�� ���� 'AD_PRES'�� ���ν����� ���ڰ����� �����ϰ�
--- ������ jobs ����  insert ������ min_salary�� 2000, max_salary�� 6000
--- ���� update �Ͻÿ�
--- EXEC my_new_job_proc ('AD_PRES', 2000, 6000);




