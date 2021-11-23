-- 1. ���� �̸��� �ٿ��� ����Ͻÿ�.
select '���� �̸��� ' || last_name || first_name || '�Դϴ�.'
from employees;
--concat
select concat('���� �̸��� ',CONCAT(last_name, concat(first_name,'�Դϴ�'))) 
from employees;

-- 2. nvl
-- ��, �̸�, ����, �޿�, Ŀ�̼��� ������ ���
select last_name, first_name, job_id, salary, 
       (salary + salary * nvl(commission_pct,0)) * 12 year_sal
from employees;

-- 3. nvl2
select last_name, first_name, job_id, salary,
--           ���� �ƴϸ� �ι�° �� ���
--           ���̸� ����° �� ���
       nvl2(commission_pct, (salary + salary *  commission_pct) * 12,
                            salary * 12)
from employees;

-- 4. nullif
select first_name, length(first_name),
       last_name, length(last_name),
       --       exp1                  exp2
       nullif(length(first_name), length(last_name)) result
       -- exp1�� exp2�� ������  null���
       -- exp1�� exp2�� �ٸ��� exp1�� ���
from employees;

---5.coalesce�Լ�
--                          exp1           exp2  exp3  exp4
select last_name, coalesce(commission_pct, salary, 10) comm
           --             exp1�� ���� �ƴϸ� exp1�� ���
           --             exp1�� ���̸� exp2�� ��� 
           --             exp1�� exp2�� ��� null�̸� exp3���
from employees;

--  ������ �Լ�
---6. �޿��� ���� ���� �޴� ����� ���� �޴� ����� ���, �޿� ���
select max(salary), min(salary) ,  avg(salary)
from employees;

--- 7. �޿��� �޴� ����� ����, �μ��� ������ �ִ� ����� ���� ����Ͻÿ�.
select * from employees;
select count(salary), count(department_id)
from employees;
--- ������ �Լ��� null���� �����ϰ� ����� �Ѵ�.

-- 8. Ŀ�̼��� �޴� ������� Ŀ�̼��� ��հ� ���� ��ü�� Ŀ�̼� ����� ���Ͻÿ�.
select avg(commission_pct), sum(commission_pct) / count(*)
from employees;
-- ������ �Լ��� null���� �������� �����Ƿ� ��ü�� ���� ���Ҷ� ���� �ٸ� �� �ִ�.

--9. ��ü�� ����� ���� ���Ͻÿ�. (�� ��ü�� ����)
select count(*) from employees;

-- 10. ���� �ʰ� �Ի��� ����� ���� ó���� �Ի��� ����� ����Ͻÿ�.
select max(hire_date), min(hire_date)
from employees;

--11.������ 'REP'�� ������ �ִ� ����� �� ���� ���� �޴� �޿��� ���� �޴� �޿��� ���,
--    ��� �޿��� ����� ��, �޿��� �հ� 
select max(salary), min(salary), avg(salary), count(*), sum(salary) 
from employees
where job_id like '%REP%';

---       107                 107
select first_name,salary, to_char(hire_date, 'dd-mm-yyyy')
from employees;

--������ �Լ��� ����ϴ� ��� ������ �Լ��� ����ؾ� �Ѵ�. �÷��� �߰� �� �� ����.
--select first_name, sum(salry)
--from employees;

-- 12.80�� �μ����� Ŀ�̼��� �޴� ����� ���� �ִ� Ŀ�̼� ���� �ּ� Ŀ�̼� ���� ���
--     �μ��� ���� �ִ� ����� �� 
select count(commission_pct), max(commission_pct), min(commission_pct),
       count(*)
from employees
where department_id = 80;

-- 13. �ߺ����� ���� �μ���?
select  distinct(department_id)
from employees;

-- 14. �ߺ����� ���� �μ��� ����?
select count(distinct(department_id))
from employees; -- null �� �μ��� �ƴϹǷ� ����

-- 15. Ŀ�̼��� �޴� ����� Ŀ�̼� ��հ� 
--    Ŀ�̼��� ���� �ʴ� ����� Ŀ�̼��� ����� ���Ͻÿ�.
select trunc(avg(commission_pct), 4), 
       trunc(sum(commission_pct) / count(*),4),
       trunc(avg(nvl(commission_pct,0)),4)
from employees;

--- 16. 90�κμ��� �޿��� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary),count(*)
from employees
where department_id = 90;
--      80�κμ��� �޿��� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary),count(*)
from employees
where department_id = 80;
--      70�κμ��� �޿��� ���, �հ�, �ִ�, �ּ�, ����� ��
--      ...
select avg(salary), sum(salary), max(salary), min(salary),count(*)
from employees
where department_id = 70;

-- 17. �� �μ��� �μ��� �޿��� ���, �հ�, �ִ�, �ּ�, ����� ��
select department_id, --  group by���� �ִ� �÷��� select���� ��� �����ϴ�.
       trunc(avg(salary),2), sum(salary), max(salary), min(salary),count(*)
from employees
group by department_id
order by  department_id;

-- 18. ���� ������ �ϴ� ����� �� ���� ���� ��� �� ����� ���� �ʰ� ���� ����� 
---    �Ի����� ����Ͻÿ�.
---             �ʰ� ���� ��    ���� ���� ��
select job_id, max(hire_date), min(hire_date)
from employees
group by job_id
order by job_id;

-- 19. �����ȣ,  �̸�, �Ի���, ����, �μ��� ����� ��.
-- �μ��� ������������ �����ϰ� �� �μ��� ������ ������������ �����Ͽ� ����Ͻÿ�.   
select department_id, job_id, employee_id, first_name, hire_date
from employees
order by department_id, job_id;

-- 20.  �� �μ��� ������ �޿� ��� , �հ�, ����ϴ� ����� ���� ���
select department_id, job_id , trunc(avg(salary)), sum(salary), count(*)
from employees
group by department_id, job_id
order by department_id, job_id;

-- 20. 90�μ����� ������ �޿� �հ�� ��� ���Ͻÿ�.
select job_id, avg(salary), sum(salary) 
from employees                  -- 1
where department_id = 90        -- 2
group by job_id ;                -- 3

-- 21. ���μ����� ������ ���� ����� �� �Ի����� ���� ����� ���� ���Ͻÿ�.
-- ������� 2���̻� ���
select department_id, job_id, hire_date, count(*)
from employees                            --1                     
group by department_id, job_id, hire_date
having count(*) >= 2;  -- group �Լ��� ������ �ִ� ��� having���� ���                   

-- 22. ��ձ޿��� 7000�̻��� �μ��� ����Ͻÿ�.��� �޿� ���� �� ���� ����Ͻÿ�.
select department_id, avg(salary) sal
from employees
group by department_id
having avg(salary) >= 7000
-- order by avg(salary) desc;
-- order by sal desc;
order by 2 desc;

-- 23. �μ��� ���� ���� 10�� �̸��� �μ��� ����Ͻÿ�.
select department_id , count(*)
from hr.employees
group by department_id
having count(*) < 10;

-- 25. ������ 'REP'�� ���ԵǾ� ���� ���� ������ �޿��� ���, �հ�, �ּ�, 
--- �ִ� ���� ����Ҷ� �޿��� �հ谡 13000�̻��� ������ ����Ͻÿ�.
select job_id, avg(salary), sum(salary), min(salary), max(salary)
from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000;

--- ������ �Լ�, group by, having
--- sum, avg, max, min, count
select max(employee_id) + 1 from employees;
-- select max(board_num) + 1 from  board
                                   -- 90
select employee_id, first_name, department_id 
from employees
where employee_id = 100;

select department_id , department_name
from departments
where department_id = 90;

--      26                             90
select employee_id, first_name, departments.department_id , 
       department_name, location_id 
from employees , departments
where employee_id = 100
---     90                   =    90
and employees.department_id  = departments.department_id;


-- 27. ��� ����� ��, �̸�, �޿� , ����, �μ���ȣ, ������ȣ, �μ����� ����Ͻÿ�.
select employee_id, last_name, first_name, salary, job_id,     --3
       d.department_id, location_id, department_name
from employees e, departments d                                      -- 1
--           10                         10
--            20                        20
where e.department_id = d.department_id;      --2

--- īƼ�þ� ����
select employee_id, last_name, first_name, salary, job_id,     --3
       departments.department_id, location_id, department_name
from employees, departments;

--28. ����� ��, �޿� , �Ի���, ������ ����� �� ������ ���� ����Ͻÿ�.
select last_name , salary, hire_date, employees.job_id, job_title
from employees, jobs
where employees.job_id = jobs.job_id;

-- �μ� ���̺��� 90�� �μ������� ����Ͻÿ�.
select * from departments where departments.department_id = 90;
-- 90�� �μ��� ������ ���Ͻÿ�,.
select * from employees where department_id = 90;
--- 100�� ��� ������ ����Ͻÿ�.
select * from employees where employee_id = 100;

--T-SQL join
select employee_id, last_name, first_name, salary, job_id,     
       d.department_id, location_id, department_name
from employees e, departments d  
where e.department_id= d.department_id;
-- Ansi - join
-- 29. ������ȣ, ��, �̸�, �޿�, ����, �μ���ȣ, ������ȣ, �μ����� Anti-join
select employee_id, last_name, first_name, salary, job_id,     
       d.department_id, location_id, department_name
from employees e join departments d  
on e.department_id= d.department_id;

-- 30. anti-join���� ������ȣ .��, �̸� �޿� �μ���ȣ, �μ����� 100����� ����Ͻÿ�.
select last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id -- join���� ����
where employee_id = 100;

-- 31. natural join
-- ���� ��ȣ, ��, �̸� , ����, �������� ����ϼ���.
select employee_id, last_name, firat_name, job_id, job_title
from employees e, jobs j
where e.job_id = j.job_id; -- �Ϲ������� join������ primary key = foreign key
-- ansi - join 
select employee_id, last_name, firat_name, job_id, job_title
from employees e join jobs j
on e.job_id = j.job_id;
-- natual join
select employee_id, last_name, first_name, job_id, job_title
from employees natural join jobs; -- ��Ī�� ���� ���� ����.
--- ���̺� ���� �̸��� �÷��� ���ϴ� ���̹Ƿ� ���������� �ʿ� ����.  

-- 32. �μ����� ����� ������ ���Ͻÿ�.
-- ������ȣ, ��, �޿� �Ի���, �μ���ȣ, �μ����ȣ�� ����Ͻÿ�.
-- t-sql join
select employee_id, last_name, salary, hire_date, 
       d.department_id, d.manager_id
from employees e, departments d
where e.department_id = d.department_id and d.manager_id = e.manager_id;
-- ansi-join 
select employee_id, last_name, salary, hire_date, 
       d.department_id, d.manager_id
from employees e join departments d
on e.department_id = d.department_id and d.manager_id = e.manager_id;

--natural join
select employee_id, last_name, salary, hire_date, 
        department_id, manager_id
from employees natural join departments;

-- using�� ���
select employee_id, last_name, salary, hire_date, 
        department_id, manager_id
from employees join departments  using(department_id, manager_id);

----------
select last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id;
-- ���� �̸��� �÷��� �ΰ� �̹Ƿ� natural join���� ���� �� �� ����.
-------------
-- 33. �� �̸� ������ȣ , ��ȭ��ȣ , �޿� �μ���ȣ, �μ��� �� anti-join���� ����Ͻÿ�.
select last_name, first_name, employee_id, phone_number, salary,
       d.department_id , department_name
from employees e join departments d
on e.department_id = d.department_id;
--- using�� ���
select last_name, first_name, employee_id, phone_number, salary,
       department_id , department_name
from employees join departments using(department_id);

-- 34. �� �μ��� �μ��� ������ �μ����� �̸��� ��� �Ͻÿ�.
select d.department_id, department_name, location_id, d.manager_id ,
       employee_id, first_name
from departments d, employees e
where d.manager_id = e.employee_id;
--    foreign key  =   primary key

--- 35. 
--- ���� ��ȣ, ���� ��ȣ , ��������
select employee_id, j.job_id, job_title
from employees e, jobs j
where e.job_id = j.job_id;
--- ������ȣ, �μ���ȣ, �μ���
select employee_id, e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

--- �� ������ ������ȣ, ������ȣ, ���� ����, �μ���ȣ, �μ���
-- t-sql
select employee_id, e.job_id, job_title, e.department_id, department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id and e.department_id = d.department_id;
--- ���̺� 3���̸� ���� ������ �ּ� 2��.
-- ���̺��� n���̸� �������� �ּ� n-1��

-- ansi-join
select employee_id, e.job_id, job_title, e.department_id, department_name
from employees e join jobs j
on e.job_id = j.job_id join  departments d 
on e.department_id = d.department_id;

select employee_id, job_id, job_title, department_id, department_name
from employees NATURAL join jobs join departments using (department_id);

--- 36. �μ����� ���������� ����Ͻÿ�. �μ��� ��ȣ, ��������,
select  d.manager_id, job_title
from jobs j,  employees e ,departments d
where e.job_id = j.job_id and e.employee_id = d.manager_id
and e.department_id = d.department_id;

--- 37. �μ��� ���� ������ ���� ���
select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from employees e left outer join departments d
on e.department_id = d.department_id;
select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from employees e , departments d
--where e.department_id = d.department_id(+);
where d.department_id(+) = e.department_id ;

select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from departments d right outer join employees e
on e.department_id = d.department_id;

--- 38. ������ ���� �μ� �� ���
select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from departments d left outer join employees e
on e.department_id = d.department_id;

select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from employees e right outer join departments d 
on e.department_id = d.department_id;

select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from employees e , departments d 
where e.department_id(+) = d.department_id;

-- 39. �μ��� ���� ������ ������ ���� �μ��� ���
select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from employees e full outer join departments d 
on e.department_id = d.department_id;
--
--select first_name, last_name, salary, e.department_id, 
--       d.department_id, department_name
--from employees e , departments d 
--where e.department_id(+) = d.department_id(+);