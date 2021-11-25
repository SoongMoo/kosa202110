select employee_id, last_name, salary
from employees
where department_id = 80;

create view vw_80
as 
select employee_id, last_name, salary
from employees
where department_id = 80;

select * from vw_80;

desc vw_80;

create view vw_50
as 
select employee_id eid, last_name lname, salary sal
from employees
where department_id = 50;

select * from vw_50;

create view vw_70
(eid, lname, sal)
as 
select employee_id , last_name , salary 
from employees
where department_id = 70;

select * from vw_70;

create or REPLACE view vw_70
(eid, lname, year_sal)
as 
select employee_id , last_name , salary * 12
from employees
where department_id = 70;

create or REPLACE view vw_year_sal
(eid, fname, hire_date, year_sal)
as
select employee_id, first_name, hire_date, 
    (salary + salary * nvl(commission_pct,0)) * 12
from employees
where job_id like '%MAN%';

--- �� �μ��� ���� �ӱݰ� �ִ� �ӱ� �׸��� ��� �ӱ��� ����ϼ���.
-- department_name
create or REPLACE view dept_sal_vw --- ���� ��
(dname, minsal, maxsal, avgsal)
as
select department_name, min(salary), max(salary), avg(salary)
from employees e, departments d
group by department_name;

select * from dept_sal_vw;


-- ������ȣ , �̸� , �Ի��� , �޿�, �μ���ȣ , �μ����� ����ϴ� �並 ������.
create or REPLACE view vw_emp_dept
as
select employee_id, first_name, hire_date, salary, e.department_id,
       department_name
from employees e, departments d
where e.department_id = d.department_id;

select * from vw_emp_dept;

create or REPLACE view vw_30
as 
select EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID, department_id
from emp
where department_id = 30;

select * from vw_30;

insert into vw_30 -- �並 ���ؼ� ���� ���̺� �����Ͱ� �� �� �ִ�.
values(310, 'Rhee', 'SRhee', sysdate, 'AP', 210); 

select * from emp;

insert into vw_30( --�並 ���� �������� �ʴ� �÷��� ������ �����͸� ������ �� ����.
  EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID, department_id, manager_id)
values(320, 'Park', 'JPARK', sysdate, 'AP', 210, 110);

update vw_30 -- �並 ���ؼ� �������� �ʴ� �����ʹ� ������ �� ����. 
set LAST_NAME =  'SRHEE'
where employee_id = 310;

update vw_30 ---- �並 ���ؼ� �������� �����ʹ� ������ �����ϴ�.
set hire_date = sysdate
where employee_id = 115;

select * from vw_30;

update vw_30 ---- �並 ���ؼ� �������� �ʴ� �÷��� �����ʹ� ������ �� ����.
set manager_id = 100
where employee_id = 115;

delete from vw_30
where employee_id = 115;

select * from vw_30;

delete from vw_30 --- ��� �������� ������ ������ �ȵȴ�.
where employee_id = 310;

--- �並 ���ؼ� DML���� ����� �� �ִ�.
-- �� insert�� �信�� ������ �ʾƵ� ������ �ȴ�.
create table viewup1
(
    c1 number primary key,
    c2 number
);
create table viewup2
(
    c1 number primary key,
    c3 number
);

insert into viewup1 values(1, 1);
insert into viewup2 values(1, 1);

create view v_viewup
as 
select t1.c1, t1.c2, t2.c3
from viewup1 t1, viewup2 t2
where t1.c1 = t2.c1;

select * from v_viewup;

update v_viewup
set c2 = 10    -- ���� �信�� �� ���̺� �ִ� �÷��� ���� ������ �ȴ�.
where c1 = 1;

select * from v_viewup;
select * from viewup1;


update v_viewup
set c3 = 10
where c1 = 1;
select * from v_viewup;
select * from viewup2;

update v_viewup -- �並 ���ؼ� �� ���̺��� �����͸� ������ �� ����.
set c3 = 20, c2 = 20
where c1 = 1;

insert into v_viewup values(2,2,2); 
-- �並 ���ؼ� �� ���̺��� �����͸� �Է� �� �� ����
insert into v_viewup(c1, c2) values(2,2);
select * from v_viewup;
select * from viewup1;
-- c1�� viewup1�� �ִ� ���� ����ϹǷ� viewup2������ c1�� ����� �� ����.
insert into v_viewup(c1, c3) values(2,2);
select * from v_viewup;
select * from viewup2;

delete from v_viewup
where c1 = 1; -- viewup1�� c1�� �����ϰڴ�.
select * from v_viewup;
select * from viewup1;
select * from viewup2;
--- ���� ��� DML���� ���� ������ ����� �ȴ�.

create or REPLACE view empvw20
as
select * from emp where department_id = 20
with CHECK OPTION CONSTRAINT empvw20_ck;
--- with CHECK OPTION�� �信�� ���̰� �Ǵ� �����ͷθ� ���� ���� ������ ����

select * from empvw20;
insert into empvw20(employee_id, last_name, email, hire_date, job_id, 
                    department_id)
values(330, 'Park', 'JPARK', sysdate, 'AP', 210);

select * from emp where employee_id = 320;

update empvw20
set department_id = 50 ---���� �� �������� �ʴ� �����ʹ� ���� �� �� ����.
where employee_id = 201;

create view empvw80
as
select * from emp
where department_id = 80
with read ONLY; -- �б� ���� �� -- ��� DML���� �ź�

delete from empvw80 
where employee_id = 147;

-- �� ����
drop view empvw80;
select * from  empvw80; -- select�� ���̺� �Ǵ� �信 ������ �˻��ϱ� ���ؼ� ���

--- ��, �޿�, �μ���ȣ, �μ��� �ּұ޿�
select last_name, salary, e.department_id, minsal
from employees e, (select department_id, min(salary) minsal
                   from employees
                   group by department_id ) d -- �ζ��� ��
where e.department_id = d.department_id;


-- ������ȣ,�̸�, ����, �Ի���, �޿� �׸��� �� �μ��� ����� �� ��� �޿��� ���
select employee_id, first_name, job_id, hire_date, salary, cnt, avgsal
from employees e, (select department_id, count(*) cnt, avg(salary) avgsal
                   from employees
                   group by department_id) d
where e.department_id = d.department_id;

--  �����ȣ, �̸�, �޿�, �μ�, ������ �޿��� ���� ���� �޴� ������� ����ϼ���.
select employee_id, first_name, salary, department_id, job_id
from employees
order by salary desc;

--- top-n
-- �޿��� ���� ���� �޴� ��� 5���� �������ÿ�.
select rownum , rn, employee_id, first_name, salary, department_id, job_id
from ( select rownum rn, employee_id, first_name, salary, department_id, job_id
       from employees
       order by salary desc)
where rownum <= 5;

--select rownum , subject
--from (select subject , reg_date 
--      from board
--      order by reg_date desc)
--where rownum <= 5;


-- �޿��� ���� ���� �޴� ��� 10������ 15�� ���� ����ϼ���.
-- �����ȣ, �̸�, �޿�, �μ�, ����
select rownum, rn, employee_id, first_name, salary, department_id, job_id
from(select rownum rn, employee_id, first_name, salary, department_id, job_id
     from (select employee_id, first_name, salary, department_id, job_id
          from employees
          order by salary desc)
)
where rn >= 10 and rn <= 15; --- paging�� �� ���


-- �����ȣ, �̸�, �޿�, �μ�, ������ ����� �� 
-- Ŀ�̼��� ���� ���� �޴� ��� 5���� ����ϼ���.
select rownum , rn, employee_id, first_name, salary, department_id, job_id,
      commission_pct
from ( select rownum rn, employee_id, first_name, salary, department_id, job_id
             , commission_pct
       from employees where commission_pct is not null
       order by  commission_pct desc)
where rownum <= 5;
--  �����ȣ, �̸�, �޿�, �μ�, ������ ����� �� 
--- Ŀ�̼��� ������ ����� ���� ������ �޴� ��� 6������ 10�������� ���
select  *
from( select rownum rn , employee_id, first_name, salary, department_id, job_id,
          year_sal
      from ( select employee_id, first_name, salary, department_id, job_id
                 , salary * ( 1+ nvl(commission_pct, 0)) * 12  year_sal
           from employees
           order by  year_sal desc)
    )
where rn >= 6 and rn <= 10;

--group by ���� ���� ���
-- �μ��� ������ ���� �޿��� �հ��  �μ���ȣ, ������ ����ϼ���.
select department_id, job_id, sum(salary)
from employees
group by  department_id, job_id;
--�μ��� �޿��� ����� 9500�̻��� �μ��� ����ϼ���.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) >= 9500;

-- �μ��� ������ �޿��� ��հ� �μ��� �޿��� ��� �׸��� ��ü ����� ����ϼ���.
select department_id, job_id, avg(salary)
from employees
group by department_id, job_id
union
select department_id, to_char(null) , avg(salary)
from employees
group by department_id
union
select to_number(null),to_char(null),  avg(salary)
from employees;

-------------------------------
select department_id, job_id, avg(salary)
from employees
group by ROLLUP (department_id, job_id);
--- (department_id, job_id)
--- (department_id)
--- ()

--- �� �μ����� ���� ������ �ϸ鼭 �Ի����� ���� ����� ��, �޿� ���
--- �� �μ��� ������ ����� ��, �޿� ���
--- �� �μ��� ����� ��, �޿� ���
--- ��ü ����� ��, �޿� ���
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by department_id, job_id, hire_date
union
select department_id, job_id, null, count(*), avg(salary)
from employees
group by department_id, job_id
union
select department_id, null, null, count(*), avg(salary)
from employees
group by department_id
UNION
select null, null, null, count(*), avg(salary)
from employees;
---------------------------------
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by rollup (department_id, job_id, hire_date);
--- (department_id, job_id, hire_date)
--- (department_id, job_id)
--- (department_id)
--- ()

-- �μ��� ������ �޿� �հ�
-- �μ��� �޿��� �հ�
-- ������ �޿��� �հ�
-- ��ü �޿��� �հ�
select department_id, job_id, sum(salary)
from employees
group by department_id, job_id
union
select department_id, null, sum(salary)
from employees
group by department_id
union
select null        , job_id, sum(salary)
from employees
group by  job_id
union
select null        , null, sum(salary)
from employees;
--------------------------------------
select department_id, job_id, sum(salary)
from employees
group by cube (department_id, job_id);
-- (department_id, job_id)
-- (department_id)
-- (job_id)
-- ()
----------------------------------
--- �� �μ����� ���� ������ �ϸ鼭 �Ի����� ���� ����� ��, �޿� ���
--- �� �μ��� ������ ����� ��, �޿� ���
--- �� ������ �Ի��� ���� ����� ��, �޿��� ���
--- �� �μ����� �Ի��� ���� ����� �� , �޿� ���
--- �� �μ��� ����� ��, �޿� ���
--- �� ������ ����� ��, ��� �޿�
--- �Ի����� ���� ����� ��, �׿� ���
--- ��ü ����� ��, �޿� ���
select department_id, job_id, hire_date, count(*), avg(salary)
from employees
group by cube (department_id, job_id, hire_date);
-- department_id, job_id, hire_date
-- department_id, job_id
-- job_id, hire_date
-- department_id, hire_date
-- department_id, 
-- job_id, 
-- hire_date
-- ()









