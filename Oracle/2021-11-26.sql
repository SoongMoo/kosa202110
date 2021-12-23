-- ex3_6�� ���̺��� �����, ������̺�(employees)���� �����ڻ���� 
--124���̰� �޿��� 2000���� 10000 ���̿� �ִ� ����� ���, �����, �޿�, 
--�����ڻ���� �Է��ϴ�    INSERT���� �ۼ��غ���.
CREATE TABLE ex3_6 ( 
          employee_id  NUMBER(6),
          emp_name     VARCHAR2(80),
          salary       NUMBER(8,2),
          manager_id   NUMBER(6) 
);
insert into ex3_6
select employee_id, first_name, salary,  manager_id
from employees
where employee_id = 124 and salary between 2000 and 10000;

-- ������̺�(employees)���� Ŀ�̼�(commission_pct) ���� ���� 
-- ����� ����� ������� �����ϴ� ������ �ۼ��غ���.
select employee_id, first_name
from employees
where commission_pct is null;

--  SELECT employee_id, salary 
--  FROM employees
--  WHERE salary BETWEEN 2000 AND 2500
--  ORDER BY employee_id;
--�� ���������� ����
SELECT employee_id, salary 
FROM employees
WHERE salary >= 2000 and salary <= 2500;

--- SELECT employee_id, salary 
--  FROM employees
--  WHERE salary IN (2000, 3000, 4000)
--  ORDER BY employee_id;
--  any �����ϼ���.
SELECT employee_id, salary 
FROM employees
WHERE salary = any (2000, 3000, 4000)
ORDER BY employee_id;

--- SELECT employee_id, salary 
--  FROM employees
--  WHERE salary not IN (2000, 3000, 4000)
--  ORDER BY employee_id;
--  all �����ϼ���.
SELECT employee_id, salary 
FROM employees
WHERE salary <> all (2000, 3000, 4000)
ORDER BY employee_id;
-- ������̺�(employees)���� phone_number��� �÷��� ����� ��ȭ��ȣ�� 
-- ###.###.#### ���·� ����Ǿ� �ִ�.���⼭ ó�� 3�ڸ� ���� ��� ���� ������ȣ�� 
-- (02)�� �ٿ� ��ȭ��ȣ�� ����ϵ��� ������ �ۼ��� ����. Lpad
select employee_id, lpad(substr(phone_number,5),length(phone_number), '(02)')
from employees;

--2. �������� �������� ������̺��� �Ի�����(hire_date)�� �����ؼ� �ټӳ���� 
-- 10�� �̻��� ����� ������ ���� ������ ����� ����ϵ��� ������ �ۼ��غ���. 
-- (�ټӳ���� ���� ���������� ����� �������� ����)
-- �����ȣ  �����  �Ի����� �ټӳ��
select employee_id, first_name, hire_date , 
        round((sysdate - hire_date) / 365) "�ټӳ��" 
from employees
where round((sysdate - hire_date) / 365) >= 10
order by "�ټӳ��" desc;

--- �����ȣ, �����, �޿�, ��ȭ��ȣ�� ����� ��
-- �޿��� ��ȭ ������ ��ȭ��ȣ�� .��� -�� ��µǰ� �������� �ۼ��Ͻÿ�.
select employee_id, first_name, to_char(salary,'$999,999,999'),
        replace(phone_number, '.','-')
from employees;

select * from employees;

--- �ټӳ���� 19���� �̻��̸� �̻� 
---          18���� �̻��̸� ������
--           17���� �̻��̸� ����
--           16���� �̻��̸� ����
--           15���� �̻��̸� ����
--           14���� �̻��̸� �븮
--                 �����̸� ������� ����Ͻÿ�.
select employee_id, 
        case  when round((sysdate - hire_date)/365) >= 19 then '�̻�'
              when round((sysdate - hire_date)/365) >= 18 then '������'
              when round((sysdate - hire_date)/365) >= 17 then '����'
              when round((sysdate - hire_date)/365) >= 16 then '����'
              when round((sysdate - hire_date)/365) >= 15 then '����'
              when round((sysdate - hire_date)/365) >= 14 then '�븮'
              else '���' end emp
from employees;
--- �޿��� 1000���� ���� ���� 3���ϸ� ��� 
--                          5���ϸ� ����
--                          7���ϸ� �븮
--                          9���ϸ� ����
--                          10���ϸ� ����
--                          13���ϸ� ����
--                          15���ϸ� ������
--                          �׿ܿ� �̻� �� ����ϼ���
select employee_id, 
        case when trunc(salary / 1000) <= 3 then '���'
             when trunc(salary / 1000) between 4 and 5 then '����'
             when trunc(salary / 1000) <= 7 then '�븮'
             when trunc(salary / 1000) <= 9 then '����'
             when trunc(salary / 1000) <= 10 then '����'
             when trunc(salary / 1000) <= 13 then '����'
             when trunc(salary / 1000) <= 15 then '������'
             else '�̻�' end emp
from employees;
             
-- ������̺��� �Ի�⵵�� ������� ���ϴ� ������ �ۼ��غ���. 2004
select to_char(hire_date, 'yyyy') y , count(*)
from employees
-- group by substr(hire_date,1,2) 
group by to_char(hire_date, 'yyyy') 
order by y desc;


-- �Ʒ��� ������ ���� ROLLUP�� ������ �����̴�.
 SELECT department_id, job_id, SUM(salary) totl_jan
 FROM employees
 WHERE hire_date LIKE '03%' 
 GROUP BY  department_id, ROLLUP( job_id );
-- 
-- �� ������ ROLLUP�� ������� �ʰ�, 
-- ���տ����ڸ� ����ؼ� ������ ����� �������� ������ �ۼ��غ���. 
 SELECT department_id, job_id, SUM(salary) totl_jan
 FROM employees
 WHERE hire_date LIKE '03%' 
 GROUP BY department_id, job_id 
 union 
 SELECT department_id, job_id, SUM(salary) totl_jan
 FROM employees
 WHERE hire_date LIKE '03%' 
 GROUP BY department_id;

--- ���   �����   job��Ī job��������  job��������   job����μ���
--- 101�� ����� ����ϼ���.
select a.employee_id, a.first_name, 
       d.job_title, 
       b.start_date, b.end_date, 
       c.department_name
from employees a, job_history b,  departments c,jobs d
 where a.employee_id = b.employee_id
 and   b.job_id = d.job_id
 and   b.department_id = c.department_id
 and a.employee_id = 101;  

desc jobs;    desc job_history;  desc employees;     desc departments;
JOB_ID        EMPLOYEE_ID  ----   EMPLOYEE_ID        DEPARTMENT_ID
JOB_TITLE     START_DATE          JOB_ID             DEPARTMENT_NAME
MIN_SALARY    END_DATE            DEPARTMENT_ID      MANAGER_ID
MAX_SALARY    JOB_ID                                 LOCATION_ID
    |         DEPARTMENT_ID   --------------------------|
    |------------|

--- �� �μ��� �޿��� ���� ���� �޴� ������� ���ϼ���.
select * 
from employees
where (department_id, salary) in 
(select department_id , min(salary)
 from employees
 group by department_id);

---- merge : insert, update
-- ���ϴ� ���̺� �����Ͱ� ������ insert
--               �����Ͱ� ������ update
desc ex3_6;
select * from ex3_6;
merge into ex3_6 a
      using (select * from employees where employee_id = 103) b
      on (a.employee_id = b.employee_id)
WHEN MATCHED THEN 
    update set salary = salary * 1.1
WHEN not MATCHED THEN
    insert (a.EMPLOYEE_ID, a.EMP_NAME, a.SALARY, a.MANAGER_ID )
    values (b.employee_id, b.first_name, 15000, 100);

select * from ex3_6;







--- ������ ������ ANSI �������� ������ ����.
-- SELECT a.department_id, a.department_name
-- FROM departments a, employees b
-- WHERE a.department_id = b.department_id
-- AND b.salary > 3000
-- ORDER BY a.department_name;

 SELECT a.department_id, a.department_name
 FROM departments a join employees b
 on a.department_id = b.department_id
 where b.salary > 3000
 ORDER BY a.department_name;









