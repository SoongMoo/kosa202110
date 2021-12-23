select * from employees;
select * from departments;
select * from jobs;
select * from job_history;
-- �������� : ���ϴ� ���� ���������� �Ѵ�.
-- * : ��� �÷��� ���������ϰڴ�.
-- 1. ������ȣ, �̸� , �̸���, �Ի��� 
select employee_id, first_name, email, hire_date
from employees;

-- 2. ������ȣ, �̸� , �޿�, �� ��� �޿��� 100���Ͻÿ�
select employee_id, first_name, salary, salary + 100
from employees;

-- 3. ������ȣ, ��, �Ի���, ����, ������ ����Ͻÿ�
select employee_id, last_name, hire_date, salary, salary * 12
from employees; -- ���࿡ �ִ� ���� ������ ��밡��
-- �μ�����
select * from departments;
--- 4. �ּ�, �μ���ȣ, �μ����ȣ, �μ�������� ���
select location_id, department_id, manager_id, department_name
from departments; -- �÷��� ������ �������� ��밡��

-- 5. ������̺��� ������ȣ , �Ի���, ��, �޿������� ���
select employee_id, hire_date, last_name, salary 
from employees; -- �÷��� ������ �������� ��밡��

-- 6. ����:
-- ������̺��� �����ȣ, �μ���ȣ , ����, ������ ����ϴµ� 
-- �ſ� 300�� ���ʽ��� ������ �ȴ�.
select employee_id, department_id, job_id, salary, (salary + 300) * 12
from employees;

-- 7. ������̺��� �����ȣ, �μ���ȣ , ����, ������ ����ϴµ� 
-- ������ �޿� 300�� Ư�� ���ʽ��� ������ �ȴ�.
select employee_id, department_id, job_id, salary, salary * 12 + 300
from employees;

-- 8. ������̺��� �����ȣ, ��, �̸��� , �޿��� ���� Ŀ�̼��� 30%�� �����̵� ��
-- Ŀ�̼� ���� ����Ͻÿ�.
select employee_id, last_name, email, salary , salary * 0.3
from employees;

-- 9.  ������̺��� ������ȣ �̸��� �̸� �Ի��� �޿�, Ŀ�̼��ۼ�Ʈ�� ���
select  employee_id, first_name, salary, commission_pct
from employees; 

-- 10�� ����Ͻÿ�
select 10 from dual;
-- 10��  null�� ���Ͻÿ�.
select 10 * null from dual;

-- 10.  ������̺��� ������ȣ �̸��� �̸� �Ի��� �޿�, Ŀ�̼��ۼ�Ʈ�� ����ϴµ�
-- �� ����� �޴� Ŀ�̼��� �ݾ׵� ���� ����Ͻÿ�.
select employee_id, email, hire_date, first_name, salary, commission_pct
      , salary * commission_pct
from employees;

select employee_id, email, hire_date, salary + null
from employees;

select employee_id , email, hire_date, department_id, job_id
      ,commission_pct * null  
from employees;

-- 11. ������ȣ, �̸���, �̸�, �Ի���, ����ó, �μ���ȣ, �޿�, Ŀ�̼��ۼ�Ʈ, 
-- �׸��� Ŀ�̼��� ���ѵ� ������ ����Ͻÿ�,
select employee_id, email, last_name, hire_date, phone_number, department_id
       , salary, commission_pct, (salary + salary * commission_pct) * 12 
from employees;

--12.  heading name�� ��Ī �ֱ�

select employee_id eid, email, last_name lname, hire_date hd, phone_number ph
      , department_id did, salary sal, commission_pct comm
      ,(salary + salary * commission_pct) * 12 year_sal
from employees;
-- 13. ��Ī�� as ���
select employee_id as eid, email, first_name as fname, salary sal
from employees;
--14.  ��Ī�� ���鹮�ڿ� ��ҹ��� �����ϱ�
select employee_id, first_name , salary, commission_pct
       , salary + salary * 12 as "year sal"
       , salary + salary * 12  "year sal"
       ,salary + salary * 12 as Year_Sal
       ,salary + salary * 12 as "Year Sal"
from employees;
-- �ڹٿ��� ������ ����� �־ ��Ī�� ���鹮�ڸ� ���� �۰� ��ҹ��ڸ� ��������
-- �ʴ� ���� ����.
select '�̼���' from dual;

--- 15. ���ڿ� ���̱� ������( || )
select '��' || '����' from dual;

select employee_id, '���� ���� ' || last_name , first_name, salary
from employees;

select employee_id, last_name, salary, '2021-11-19' , 35
from employees;

--- 16. ������ȣ, last_name first_name(KingSteven),�޿�, ����
select employee_id, last_name || first_name, salary, job_id
from employees;

--17. 16���������� ���� �̸��� ���鹮�ڸ� ����.
select employee_id, last_name || ' ' || first_name, salary, job_id
from employees;

-- 18. �����ȣ�� �޿��� ����ϴ� ���̿� �Ʒ� ������ ��µǰ� �Ͻÿ�. 
-- "KingSteven�� ������ AD_PRES�Դϴ�"�� �������.
select employee_id,last_name||first_name||'�� ������ '||job_id||'�Դϴ�',salary
from employees;
-- 19. ������ �μ���ȣ�� ����Ͻÿ�.
select department_id from employees;
-- 20. ������ �μ��� ��� ������� ���� �ѹ����� ����Ͻÿ�.
--     ������ �����ִ� �μ��� ��� �μ������� �˰� �ʹ�.
select DISTINCT department_id from employees;

select DISTINCT job_id, department_id
from employees;
--- ���� ���� ��� ���� ��� ���Ű� ������ ��� �ϳ��� �÷� ���� �ٸ��ٸ� ��µȴ�.

--      107                 12
--select  job_id, DISTINCT department_id
--from employees;
-- DISTINCT�� �߰��� ����� �� ���� �� �տ��� ����ؾ� �Ѵ�.

-- 21. ������ �Ի����� �ߺ����� ���� �͸� ����Ͻÿ�.
select DISTINCT job_id, hire_date
from employees;
---- select �÷�,..., �����
---- from ���̺��

---- selection------ ���ϴ� ���� ��������
-- ������ : where�� 
-- select �÷�,..., �����
-- from ���̺��
-- where ���ǽ�

-- 22. 90�� �μ��� ������� ����Ͻÿ�. 
select * 
from employees
where department_id = 90; --���ǽ�

-- 23. �����ȣ, ��, �̸�, �޿��� ���
select employee_id, last_name, first_name, salary
from employees;

-- 24. 90�� �μ��� ������� ����� �� �����ȣ, �̸� , ��, �޿� ���
select employee_id, first_name, last_name, salary
from employees
where department_id = 90; 

-- 25. �̸��� 'Nancy'�� ����� �Ի��� , ����, �޿�, Ŀ�̼��ۼ�Ʈ�� ����ϼ���.
select hire_date, job_id, salary, commission_pct
from employees
where first_name = 'Nancy';

Select Hire_Date, Job_id, salary, commission_pct
from EmployeeS;

select hire_date, job_id, salary, commission_pct
from employees
where first_name = 'nancy';
-- ���ڿ� ���ͳ��� ��쿡�� ��ҹ��ڸ� �����Ͽ� ����ؾ� �Ѵ�.

-- 26. �Ի����� 06/01/03�� ����� ����Ͻÿ�.
-- hire_date�� ������ Ÿ���� date �� timestamp
select * from employees
where hire_date = '06/01/03';
select * from employees
where hire_date = '06-01-03';
select * from employees
where hire_date = '06.01.03';
select * from employees
where hire_date = '2006-01-03';

-- �� ����(���迬��) :  =, >, >=, <, <=, <>, !=, ^=
-- 27. �޿��� 3000�̻��� ������� ��, �޿��� ����Ͻÿ�.
select last_name, salary
from employees
where salary >= 3000;

-- 28. �Ի����� 06/01/03���� �ʰ� �Ի��� ������ �����ȣ �̸� �޿��� ����Ͻÿ�.
select employee_id, first_name, salary
from employees
where hire_date > '06/01/03';
-- 30. �޿��� 3000�� �ƴ� ����� ��� ����Ͻÿ�.
select * from employees where salary != 3000;
select * from employees where salary <> 3000;
select * from employees where salary ^= 3000;

-- 31. �޿��� 2500���� 3500������ ����� �� �����ȣ�� �̸�, �޿�, ����, �Ի����� ���
select employee_id , first_name, salary, job_id, hire_date
from employees
where salary between 2500 and 3500;

-- 32. ���� King����  Smith���̿� �ִ� ������� ����Ͻÿ�.
select * from employees
where last_name between 'King' and 'Smith';

-- 33. �Ի����� 02/06/07���� 06/01/03���̿� �Ի��� ������� ����Ͻÿ�.
select * from employees
where hire_date between '2002/06/07' and '2006.01.03';

--- 50�� �μ��� ����� ���
select * from employees where department_id = 50;
-- 70�� �μ��� ����� ���
select * from employees where department_id = 70;
-- 90�� �μ��� ����� ���
select * from employees where department_id = 90;

-- 34. 50, 70, 90�� �μ��� ������� ����ϼ���.
select * from employees where department_id in (50,70,90);

-- 35. ��簡 100,101,102�� ������� ���Ͻÿ�.
select * from employees
where manager_id in (100,101,102);
-- 36. ���� 'Hartstein', 'Vargas'�� ������� ����Ͻÿ�.
select * from employees
where last_name in ('Hartstein', 'Vargas');

-- 37. ������ ������ȣ�� 100���̴�. ������ ���ӻ���� �����?
select * from employees
where manager_id = 100;

-- like
-- 38. ���� s�� ���ԵǾ� �ִ� ������ ����ϼ���.
select * from employees where last_name like '%s%';
-- select * from board where contents like '%�̼���%';

-- 39. ������ 'CL'�� �����ѵ� ������� ����Ͻÿ�.
select * from employees where job_id like '%CL%';

-- 40. ������ 'ST'�� �����ѵ� ������� ����Ͻÿ�
select * from employees where job_id like '%ST%';

-- 41. �̸��� 'B'�� �����ϴ� ������ ����ϼ���.
select * from employees where first_name like 'B%';
select * from employees where first_name like 'b%';

-- 42. �̸��� 'a'�� ������ ������ ����ϼ���.
select * from employees where first_name like '%a';

-- 43. 02�⵵�� �Ի��� ���?
select * from employees where hire_date like '02%';

-- 44. 02���� �Ի��� �����? --52���� ��
-- select * from employees where hire_date like '%02%';
--02/01/01 , 01/02/01, 05/01/02

-- 45. �̸��Ͽ� �ι�° ���ڰ� 'K'�� ����� ����Ͻÿ�.
select * from employees where email like '_K%';

-- 46. ���� �ι�° ���ڰ� 'o'�� ����� ����Ͻÿ�.
select * from employees where last_name like '_o%';

-- 47. �̸��Ͽ� ����° ���ڰ� 'A'�����ϴ� ���?
select * from employees where email like '__A%';

-- 48. �̸��Ͽ� ����° ���ڰ� 'O'�����ϴ� ���?
select * from employees where email like '__O%';

-- 49. �̸����� ���������� �ι�° ���� 'O'�� �����?
select * from employees where email like '%O_';

-- 50. �̸����� �տ��� �ι��簡 K�̰� �ڿ��� �ι�°�� 'O'�� ����� ����Ͻÿ�.
select * from employees where email like '_K%O_';

-- 51. IT_�� �����ϴ� ������ ���Ͻÿ�
select * from employees where job_id like 'IT\_%' escape '\';

-- 52. 02���� �Ի��� ������� ����ϼ���.
select * from employees where hire_date like '___02%';

-- null
-- 53. Ŀ�̼��� ���� ���ϴ� �������� ����Ͻÿ�.
-- select * from employees where commission_pct = null;
select * from employees where commission_pct is null;

-- 54. ��簡 ���� ������ ����Ͻÿ�.
select * from employees where manager_id is null;

-- 55. �μ��� �μ����� ���� �μ������� ����ϼ���.
select * from departments where manager_id is null;

---56. �μ��� ���� ������ ����Ͻÿ�.
select * from employees where department_id is null;

--- �� ������.. or, and : �ο�Ÿ�԰��� ����
-- 57. ������ AD_VP�̸鼭 �μ���ȣ�� 90�� ������� ����ϼ���.
select * from employees where job_id = 'AD_VP'; 
select * from employees where job_id = 'AD_VP' and department_id = 90;

-- 58. �޿��� 10000�̻��̸鼭 ������ 'MAN'���ԵǾ� �ִ� �����?
select * from employees where salary >= 10000;
select * from employees where job_id like '%MAN%';

select * from employees where salary >= 10000 and job_id like '%MAN%';

-- 59. �޿��� 5000�μ� 10000 ������ ����� ���Ͻÿ�.
select * from employees where salary >= 5000;
select * from employees where salary <= 10000;
select * from employees where salary between 5000 and 10000;
select * from employees where salary >= 5000 and salary <=10000;

-- 60. �Ի����� 03/06/17���� 05/09/21���̿� �Ի��� ����� ����Ͻÿ�.and���
select * from employees where hire_date >= '03/06/17' and hire_date <= '05/09/21';

-- 61. �޿��� 10000�̻��� ����� ���
select * from employees where salary >= 10000;
-- 62. ������ 'MAN'�� �����ϰ� �ִ� ����� ���
select * from employees where job_id like '%MAN%';
-- 63. 61�� ����� 62�� ����� ���� ����ϼ���.
-- �޿��� 10000�̻��� ����� ������ MAN�� �����ϰ� �ִ� ����� ����ϼ���.
select * from employees where salary >= 10000 or job_id like '%MAN%';

---64. �μ��� 100�� ����� ������ 'SA_REP'�� ����� ����Ͻÿ�.
select * from employees where department_id = 100 or job_id = 'SA_REP';

-- 65.  �μ��� 100�̸鼭 ������ 'SA_REP'�� ����� ����Ͻÿ�.
select * from employees where department_id = 100  and job_id = 'SA_REP';

-- 66. ������ 'AD_PRES', 'AD_VP', 'IT_PROG'�� ����� ����ϼ���
select * from employees where job_id in ('AD_PRES', 'AD_VP', 'IT_PROG');
--or
select * from employees where job_id='AD_PRES' or job_id='AD_VP' or job_id='IT_PROG';

--- ������ IT_PROG�̰ų� ������ ST_MAN�̸鼭 �޿��� 6000�̻��� ����� ����Ͻÿ�.
select * from employees where job_id = 'IT_PROG' and salary >= 6000
                           or job_id = 'ST_MAN' and salary >= 6000 ;
select * from employees
where (job_id = 'IT_PROG' or job_id = 'ST_MAN') and salary >= 6000;
-- in 
select * from employees
where job_id in ('IT_PROG' ,'ST_MAN') and salary >= 6000;

-- and�� or���� �켱 ������ ����.
select * from employees
where job_id = 'IT_PROG' or job_id = 'ST_MAN' and salary >= 6000;

select * from employees
where salary >= 6000 and job_id = 'IT_PROG' or job_id = 'ST_MAN';

-- 67. ������ 'AD_PRES', 'AD_VP', 'IT_PROG'�� �ش����� ���� ����� ����ϼ���
select * from employees where job_id!='AD_PRES' and job_id!='AD_VP' and job_id!='IT_PROG';
select * from employees where job_id not in ('AD_PRES', 'AD_VP', 'IT_PROG');

-- 68. �޿��� 6000���� �۰ų�  10000���� ū ����� ����ϼ���.
select * from employees where salary < 6000 or salary > 10000;
select * from employees where salary not between 6000 and  10000;

-- 69. Ŀ�̼��� �����ʴ� ������� ���Ͻÿ�.
select * from employees where commission_pct is null;
-- Ŀ�̼��� �޴� ������� ����ϼ���.
select * from employees where commission_pct is not null;

-- 70.  �μ����̺��� �μ����� �ִ� �μ��� ����Ͻÿ�.
select * from departments where manager_id is not null;

---  ���� (��������, ��������)
select * from employees;

select salary , employee_id , first_name, hire_date
from employees;

-- 71. �޿��� �������� ������������ ���ĵǾ� �޿�, �����ȣ, �̸� �Ի����� ����ϼ���.
select salary , employee_id , first_name, hire_date
from employees
order by salary ;

-- 72. 80�� �μ��� ������� ����� �� �Ի����� ���� ���� ������� ����Ͻÿ�.
select * from employees
where department_id = 80
order by hire_date asc; -- asc �⺻�����̹Ƿ� ������ �����ϴ�. 

--- �⺻ ����
--select       4
--from         1
--where        2
--order by     3
---
-- 73. 50�� �μ��� ������� ����� �� �Ի����� ���� ���� ������� ����Ͻÿ�.
select * from employees
WHERE department_id = 50
order by hire_date desc;

-- 74. 50�� �μ��� ������� ����� ��  �޿��� ���� ���� ������� ����Ͻÿ�.
select * from employees
where department_id = 50
order by salary asc;

-- 75. �޿��� 6000�̻��̰� 10000������ ������� �Ի����� ���� ������� �������� ����ϼ���.
select * from employees
where salary between 6000 and 10000
order by hire_date asc;

-- 76. 
--- �����ȣ, �̸�, �Ի��� , �޿�, �μ���ȣ �� ����� �� �޿��� ���� ���� �޴� 
--- ������� ����Ͻÿ�. �޿��� sal�� ��Ī�� ����Ѵ�.
select employee_id, first_name, hire_date, salary sal, department_id
from employees
order by salary desc; 
-- ���Ŀ� ��Ī ���
select employee_id, first_name, hire_date, salary sal, department_id
from employees
order by sal desc; 
--          1            2         3          4           5
select employee_id, first_name, hire_date, salary sal, department_id
from employees
order by 4 desc; -- ���Ŀ� �÷� ���� ��ȣ ��� 

-- 77. �μ��� ������������ ���ĵ� ���¿��� �μ����� �ִ� ������ ������������ ����������.
select * from employees 
order by department_id asc, job_id ;

-- 78. �μ��� ������������ ���ĵ� ���¿��� �μ����� �ִ� ������ ������������ ����
select * from employees 
order by department_id asc, job_id desc;

-- 79. �μ��� ������������ �����ϰ� ���μ����� ������ ������������ ���ĵ� ���¿���
--- ������ ���� �޿��� ���� ���� �޴� ������� ��µǰ� �ϼ���.
select * from employees
order by department_id , job_id desc, salary desc;

select * from employees
order by 11 , 7 desc, 8 desc;

-- 80 �μ��� ������������ �����Ͽ� ����ϰ� ���� �μ����� �ٸ� ������ ���� ������� �ִٸ�
--- ������ ������������ �����ϰ� ���� ���������� �޿��� ���� �ٸ��Ƿ� �޿��� ������������
--- �����ϵ� �޿��� �޴� ������� �Ի����� ������������ �����Ͻÿ�. 

select * from employees
order by department_id , job_id desc, salary , hire_date;

--- ���� Austin���� Sciarra���̿� �ִ� ������� �μ��� �޿��� ��� ������������ �����ϼ���.
select * from employees where last_name between 'Austin' and 'Sciarra'
order by department_id desc, salary desc;
--- ���� Austin���� Sciarra���̿� �ִ� ������� ������ �޿��� ��� ������������ �����ϼ���.
select * from employees where last_name between 'Austin' and 'Sciarra'
order by job_id desc, salary desc;




