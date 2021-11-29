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
--    c_comm CONSTANT number := 1400; -- ���
    vn_num1 NUMBER := 1; --- �ʱⰪ
    vn_num2 NUMBER := 2 ;
BEGIN
    if vn_num1 >= vn_num2 then 
        DBMS_OUTPUT.PUT_LINE(vn_num1 || '�� ū �� �Դϴ�');
    else
        DBMS_OUTPUT.PUT_LINE(vn_num2 || '�� ū �� �Դϴ�');
    end if;
end;
/
        
DECLARE
    employee_id number(6);--���� �̸��� �ĺ��ڴ� ������� �ʴ� ���� ����
BEGIN
    select employee_id --- ���� ���̺��� �ƴ� �ٸ� ���̺��� ���
    into employee_id  -- ���������� ����ϴ� ���� ����.
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
-- NUMBER ������ �������� ������ �� �ִ� �� ������ ���
-- ���� �����մϴ�

--- %TYPE �Ӽ�
-- �����ͺ��̽� �� ����
-- ����� �ٸ� ����
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

--- ���ε� ����
-- ȣ��Ʈ �������  ��
-- VARIABLE Ű���带 ����Ͽ� ����
-- PL/SQL ����� ����� �Ŀ��� �׼����� �� �ִ�.
--VARIABLE return_code NUMBER
--VARIABLE return_msg VARCHAR2(30)

VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
BEGIN
    SELECT salary 
    INTO :emp_salary  --- VARIABLE����
    from employees
    where employee_id = 143;
    -- DBMS_OUTPUT.PUT_LINE(emp_salary);
    -- emp_salary�� declare�� �����Ǿ� �־�� �Ѵ�.
end;
/
--- ġȯ����
-- ���� �Է��� ��� �� ���
-- �տ� ���ۻ���(&)�� �ٿ� PL/SQL ��� ������ ����
-- ���� �߿� ���� �� �ִ� ���� ���� �ڵ��ϴ� ���� ���� �� �ִ�.


VARIABLE emp_salary NUMBER
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6):= &empno; -- ġȯ����
BEGIN
SELECT salary INTO :emp_salary 
FROM employees WHERE employee_id = empno; 
END;
/

SET VERIFY OFF
VARIABLE emp_salary NUMBER
ACCEPT empno PROMPT '�����ȣ�� �Է����ּ��� : '
SET AUTOPRINT ON
DECLARE
    empno NUMBER(6):= &empno; -- ġȯ����
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
        DBMS_OUTPUT.PUT_LINE(hdate); -- ���� �̸��� ������ ����Ȱ��
                                     -- ���� ���ȿ� �ִ� ���� �켱�Ѵ�.
        DBMS_OUTPUT.PUT_LINE(fname); 
    end;
    DBMS_OUTPUT.PUT_LINE(hdate);
end;
/

BEGIN <<outer>> -- �ĺ����� ��Ȯ�� ����
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
    DBMS_OUTPUT.PUT_LINE ('60�μ��� �޿��� �հ谩�� : '|| sum_sal);
END;
/

DECLARE -- ��ȣ���� ����
-- �����ͺ��̽� �� �̸��� �ĺ��ڷ� ������� �ʴ´�
-- ���� ������ ���� �Ķ������ �̸��� �����ͺ��̽� ���̺��� �̸����� �켱
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
ACCEPT fname PROMPT '����̸��� �Է����ּ��� : '
ACCEPT lname PROMPT '������� �Է����ּ��� : '
ACCEPT mail PROMPT '����̸����� �Է����ּ��� : '
ACCEPT hdate PROMPT '����Ի����� yyyy-mm-dd �������� �Է����ּ��� : '
ACCEPT jid PROMPT '��� ������ �Է����ּ��� : '
ACCEPT sal PROMPT '��� �޿��� �Է����ּ��� : '
SET AUTOPRINT ON
DECLARE
    fname emp.first_name%type := &fname;  -- ġȯ����
    lname emp.last_name%type:= &lname;
    mail emp.email%type:= &mail;
    hdate emp.hire_date%type := &hdate;
    jid emp.job_id%type := &jid;
    sal emp.salary%type := &sal;
BEGIN
    INSERT INTO emp
    (employee_id, first_name, last_name, email, hire_date, job_id, salary)
    VALUES(employees_seq.NEXTVAL,fname,lname,mail,hdate, jid,sal);
    DBMS_OUTPUT.PUT_LINE ('���������� ����Ǿ����ϴ�.');
END;
/


DECLARE
    sal_increase employees.salary%TYPE := 800; 
BEGIN
    UPDATE employees
    SET salary = salary + sal_increase
    WHERE job_id = 'ST_CLERK';
    DBMS_OUTPUT.PUT_LINE('ST_CLERK �����Ͱ� �����Ǿ����ϴ�');
END;
/

DECLARE
    empid emp.employee_id%TYPE := 3; 
BEGIN
    DELETE FROM emp
    WHERE employee_id = empid;
    DBMS_OUTPUT.PUT_LINE(empid || '�� ����� �����Ǿ����ϴ�.');
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
        DBMS_OUTPUT.put_line('���� 11�� �̸��Դϴ�.');
    else
        DBMS_OUTPUT.put_line('���� ���̴� ' || myage ||'�Դϴ�.');
    end if;
end;
/
--- �޿��� 1000���� ���� ���� 3���ϸ� ��� 
--                          5���ϸ� ����
--                          7���ϸ� �븮
--                          9���ϸ� ����
--                          10���ϸ� ����
--                          13���ϸ� ����
--                          15���ϸ� ������
--                          �׿ܿ� �̻� �� ����ϼ���
-- �� ���ν����� ���� ����ϼ���.
DECLARE 
    empid emp.employee_id%type := 130; 
    sal number;
BEGIN
    SELECT trunc(salary / 1000) 
    INTO sal
    FROM employees
    WHERE employee_id = empid; 
    if sal <= 3 then 
        DBMS_OUTPUT.put_line('���');
    elsif sal <= 5 then
        DBMS_OUTPUT.put_line('����');
    elsif sal <= 7 then
        DBMS_OUTPUT.put_line('�븮');
    elsif sal <= 9 then
        DBMS_OUTPUT.put_line('����');
    elsif sal <= 10 then
        DBMS_OUTPUT.put_line('����');
    elsif sal <= 13 then
        DBMS_OUTPUT.put_line('����');
    elsif sal <= 15 then
        DBMS_OUTPUT.put_line('������');
    else
        DBMS_OUTPUT.put_line('�̻�');
    end if;        
END;
/


--- �޿��� 1000���� ���� ���� 3���ϸ� ��� 
--                          5���ϸ� ����
--                          7���ϸ� �븮
--                          9���ϸ� ����
--                          10���ϸ� ����
--                          13���ϸ� ����
--                          15���ϸ� ������
--                          �׿ܿ� �̻� �� ����ϼ���
-- �� ���ν����� ���� ����ϼ���.
-- case ������


DECLARE 
    empid emp.employee_id%type := 130; 
    grade varchar2(20); 
BEGIN
    select
    case when trunc(salary / 1000) <= 3 then '���'
             when trunc(salary / 1000) between 4 and 5 then '����'
             when trunc(salary / 1000) <= 7 then '�븮'
             when trunc(salary / 1000) <= 9 then '����'
             when trunc(salary / 1000) <= 10 then '����'
             when trunc(salary / 1000) <= 13 then '����'
             when trunc(salary / 1000) <= 15 then '������'
             else '�̻�' end
    into grade
    from emp
    where employee_id = empid;
    DBMS_OUTPUT.put_line('������ ��å�� : ' || grade);
end;
/

DECLARE
    grade CHAR(1)  := UPPER('&grade');
    result1  VARCHAR2(30);
BEGIN
    result1 :=
    case grade 
        when 'A' then '90�� �̻��Դϴ�.'
        when 'B' then '80�� �̻��Դϴ�.'
        when 'C' then '70�� �̻��Դϴ�.'
        when 'D' then '60�� �̻��Դϴ�.'
        when 'F' then '60�� �̸��Դϴ�.'
    end;
    DBMS_OUTPUT.PUT_LINE( 'grade : ' || grade || ' �� �� ' || result1) ; 
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
    /* case�� �����Ͻÿ� */
    result1 :=
    case when sal <= 3 then '���'
        when sal <= 5 then  '����'
        when sal <= 7 then '�븮'
        when sal <= 9 then '����'
        when sal <= 10 then '����'
        when sal <= 13 then '����'
        when sal <= 15 then '������'
        else '�̻�'
    end;        
    DBMS_OUTPUT.PUT_LINE('������ ��å�� : ' || result1 || '�Դϴ�');
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
---- �μ����ȣ�� �Է� �޾Ƽ� �μ����� �μ���ȣ�� �μ��̸��� ��������
--- �� �μ��� ������� ������ ������. 
--- 108��� �μ����� �μ��� 90���̰� �μ����� �������̸� ������� 20���Դϴ�.
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
     mngid || '�μ����� �μ���' ||deptid||'���̰� �μ�����' ||deptname
     ||'�̸� ������� '||emps||'���Դϴ�.');
end;
/
select * from employees where department_id = 10;








