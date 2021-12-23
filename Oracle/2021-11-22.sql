select * from employees;
---�빮�ڸ� �ҹ��ڷ� , �ҹ��ڸ� �빮�ڷ�
select email, lower(email),initcap(email), first_name, upper(first_name), 
        lower(first_name), length(first_name), lengthb(first_name),
        length('�̼���'), lengthb('�̼���'), '�̼���'
from employees;

--- 1. �̸��� 'steven'�� �����  ����Ͻÿ�.
select * from employees where lower(first_name) = 'steven';

-- 2. ���� KING�� ������ ����ϼ���.
select * from employees where upper(last_name) = 'KING';
select * from employees where last_name = INITCAP('KING');

-- 3. �̸��� ������ ������ 5�� ������� ����ϼ���.
select * from employees where length(first_name) = 5;

-- 4.  �޿��� 5�ڸ� �̻��� ����� ���Ͻÿ�.
select * from employees where salary >= 10000; 
select * from employees where length(salary) >= 5;  

-- indexOf() :���ڿ����� ���ϴ� ���ڰ� �ִ� ��ġ ��ȣ str.indexOf('a')
--            ���ϴ� ���ڰ� ���� ��� : -1
-- instr() : �����ͺ��̽��� index�� 1������ �����Ѵ�.
--           ���ϴ� ���ڰ� ���� ��� :0
-- 5. �̸��� 's'�� ���� ����� �� �̸��� ���°�� �ִ��� ����ϼ���.
select first_name, instr(first_name,'s')
from employees;

-- 6.  �̸��� 's'�� 3��°�� �ִ� ������� ����ϼ���.
select * from employees where instr(first_name,'s') = 3;

--java :
--String str = "I love the java";
--//            01234567
--System.out.print(str.subString(7))
-- substr
-- 7. �̸��� ���� �޿��� ������ ����� �� �̸����� 3��° ���� ���� ����Ͻÿ�.
select first_name, last_name, salary, job_id,email, substr(email,3)
from employees;

-- 8. �̸��Ͽ� 'S'���� ����ϰ�, �޿�, �Ի���, �̸� ,���� ����ϼ���.
select email,substr(email, instr(email, 'S')) ,instr(email, 'S'),  salary, hire_date, 
    first_name, last_name
from employees;

-- 
--String str = "I love the java";
--              0123456789
-- System.out.println(str.subString(7, 7 + 3)
--9. �̸� , �޿�, ����, �μ��� ����� �� �̸����� 3��° ���� 4��¥�� ����Ͻÿ�.
select  first_name, salary, job_id, department_id, 
        email, substr(email, 3, 4)
from employees;

--10. �̸��Ͽ� 3��°���� 4���ڿ� 'ARTS'�� �ִ� ����� ����ϼ���.
select * from employees where substr(email, 3,4 ) = 'ARTS';

--11.�̸��Ͽ� 's'�� 5��°�� �ִ� ����� ����Ͻÿ�.
select * from employees 
where instr(lower(email), 's') = 5;

--- lower, upper, length, lengthb, initcap, substr, instr

--print("���� ���̴� %10d�̴�" % 30);
--���� ���̴�          30�̴�
select salary , rpad(salary, 10, '*'), lpad(salary, 10, '*')
from employees;

-- ���̵� ã�� highland0 : high*****
-- 12. �̸��Ͽ��� �տ��� 2���ڸ� ����ϰ� �������� �����ʿ� *�� ä���� ����ϼ���.
select rpad('as', 10, '*') from dual;
select email, rpad(substr(email,1,2),length(email), '*' )
from employees;

-- 13. �Ի����� 03/06/17 ��ȭ��ȣ�� 515.123.4567�� ����� �̸����� 
--     �տ��� 3���ڸ� ����ϰ� �������� *�� ����ϼ���
select rpad(substr(email,1,3), length(email), '*')
from employees
where hire_date = '03/06/17' and phone_number = '515.123.4567';

-- str.replace("I", "You")
-- 14. ������ _AS�� �ִٸ� abc�� �����Ͻÿ�,
select replace(job_id, '_AS', 'abc') , job_id
from employees
where job_id like '%_AS%';

-- str.trim()
select ' �� ���� ' , trim(' �� ���� '), rtrim(' �� ���� '), ltrim(' �� ���� ')
from dual;
-- 15.�̸��Ͽ� 'A'�� ó���� ���� �ִٸ� �̸��Ͽ��� �����Ͽ� �������.
select email, trim('A' from email), trim(email)
from employees;

--- str = 'abcdefg'
--         0123456
--         7654321 -    
-- print(str[4:7])
-- print(str[-3:])

-- 16. �̸��Ͽ��� �ڿ��� �ѱ��ڰ����� ���� �� �̸��Ͽ��� �ڿ��� ���� 2���� ������ ����,
--     �̸��Ͽ��� �ڿ��� 3��°���� 2���ڸ� ����ϼ���.
select email, substr(email, -1,1), substr(email, -2,2), substr(email,-3, 2)
from employees;

select instr('010-7146-1970', '-', -1)
from dual;

-- 17. 010-7146-1970 , 010-****-1970, 02-314-1970 02-***-1970
select rpad(
        substr('010-1146-1970', 1, instr('010-1146-1970', '-')),
        length(substr('010-1146-1970', 1, instr('010-1146-1970', '-', -1)-1))
       ,'*') ||  substr('010-1146-1970', -5, 5)
from dual;

--- 18. �̸�, �Ի���, �μ���ȣ, �޿�, ����� ����ϼ���.
select first_name, hire_date, department_id, salary, salary * 12
from employees;

-- 19. �̸�, �Ի���, �μ���ȣ, �޿� �׸��� ����� ����� �� 
-- ������� Ŀ�̼��� ���ԵǾ�� �Ѵ�.
SELECT first_name, hire_date, department_id, salary ,commission_pct,
       (salary + salary * commission_pct ) * 12
from employees;

select commission_pct, nvl(commission_pct, 0)
from employees;

-- 20. Ŀ�̼��� null�̶�� Ŀ�̼� ���� 0���� �����Ͽ� �̸�, �μ�, �Ի���, ����,
--     �޿�, Ŀ�̼�, �׸��� ����� ����ϼ���.
select first_name, department_id, hire_date, job_id, salary
      , commission_pct, nvl(commission_pct,0)
      , (salary + salary * nvl(commission_pct,0)) *12
from employees;

select nvl(commission_pct, 100)
from employees;

--- �����Լ� 
--- round() : �ݿø� 
--- trunc() : ����       
--- mod() : ������

-- 21 . �ݿø��ϼ���.
--- 5���� �ݿø��ȴ�.
select ROUND(15.19345,3),  ROUND(15.19355,3) , round(145.5554,2),
       round(145.5554,1), round(145.5554,0),  round(145.4554,0), 
       round(145.5554,-1), round(145.5554,-2)
from dual; 

-- 22. �����ϼ���.
select trunc(15.19345,3),  trunc(15.19355,3) , trunc(145.5554,2),
       trunc(145.5554,1), trunc(145.5554,0),  trunc(145.4554,0), 
       trunc(145.5554,-1), trunc(145.5554,-2)
from dual; 

-- 23. �Ի��Ϸκ��� ���ó�¥���� ������ �������� �Ϸ� ����ϼ���.
--  �Ի���, �̸�, ��, ������ ���� ���
select sysdate from dual;
select  hire_date, first_name, last_name, job_id, 
        trunc(sysdate - hire_date,0)
from employees;

-- 24. �Ի���, �̸�, ��, ������ ����� �� �Ի��Ϸ� ���� �� �ְ� �������� ����Ͻÿ�.
select  hire_date, first_name, last_name, job_id, 
        round((sysdate - hire_date) / 7) week
from employees;

-- 25. �Ի���, �̸�, ��, ������ ����� �� �Ի��Ϸ� ���� �� �������� ����Ͻÿ�.
select  employee_id, hire_date, first_name, last_name, job_id, 
        round((sysdate - hire_date) / 365) week
from employees;

-- 26.������ 17�� �̻��� ����� ����Ͻÿ�.
select * from employees where (sysdate - hire_date) / 365 >= 17;

-- 10 / 3 : 10 % 3 : mod(10, 3)
select mod(10 , 3) from dual;

-- 27. �̸�, ��, �Ի��� , �޿��� ����� �� �޿��� 400���� ���� �������� ����ϼ���.
select first_name, last_name, hire_date, salary, mod(salary , 400) 
from employees;

-- 28. �޿��� 500���� ���� �������� 400 �̻��� ������� ����Ͻÿ�
select employee_id, first_name, hire_date, job_id, salary, mod(salary , 500)
from hr.employees
where mod(salary , 500) >= 400;

-- 10�� 3���� ���� ����  int i = 10; int j = 3; result = i / j
---                  double d = 10; double d1 = 3 ; int result = (int)(d / d1)
select trunc(11 / 3)
from dual;

--- ��¥ �Լ� 
--29. ���� ��¥���� ���� �ݿ����� �����Դϱ�?
select next_day(sysdate, '��'), next_day(sysdate, '�ݿ���')
from dual;

-- 30. �̸� , ��, ����, �Ի����� ����� �� �Ի��Ϸκ��� ���� ������� ���������� ����ϼ���.
select first_name, last_name job_id , hire_date, next_day(hire_date, '��')
from employees;

-- ���ú��� 5�����Ĵ� �����Դϱ�?
select add_months(sysdate, 5)
from dual;

--31. Neena�� �Ի��ϰ� 3���� �İ� �������� �Ǵ� ���̴�.
--    �������� �Ǵ� ���� ��������, �̸� , �� , �Ի���, ����, �����ȣ�� ���� ����Ͻÿ�.
select first_name, last_name, hire_date, job_id, employee_id,
       add_months(hire_date, 3)
from employees
where first_name = 'Neena';

-- 32. �Ի��� ���� ���� ������� '01/01/18'�λ���� ���Ͻÿ�.
select * from hr.employees
where next_day(hire_date, '��') = '01/01/18';

-- ������ ���� ���
select last_day(sysdate) from dual;

-- 33. ���޿� �Ի��� ����� ����Ͻÿ�.
select hire_date, last_day(hire_date)
from employees;
select * from employees where last_day(hire_date) like '%/02/29';

-- 34. �Ի��Ϸ� ���� ������� ����� ��������, �̸�, ��, ����, �Ի��ϵ� ���� ���
select first_name, last_name, job_id, hire_date, 
       trunc(months_between(sysdate,hire_date))
from employees;

select * from job_history;
-- 35 �� ����� ������ ����� ���� ������� ����Ͻÿ�.
select employee_id, job_id,start_date, end_date
        , round(months_between(end_date, start_date))
from job_history;

-- 36. �Ի����� 200������ ���� ������� ����Ͻÿ�.
select * from employees
where months_between(sysdate, hire_date) >= 200;

--- �����Լ� , �����Լ�, ��¥�Լ�, 
-- ��ȯ�Լ� 
-- ��¥ ��ȯ 2021-05-14 11:10:35  (date)
-- 20    21    05   14   11    10    35
--����    ��    ��   ��    ��    ��    ��
-- 21/05/14 : 2021/05/14 : 49�⵵������ ���� ���⸦ ������
-- 50/05/14 : 1950/05/14 : 50�� ���� 99������� ���� ���⸦ ������
-- 2050/05/14 

--'21-01-15' :�����
select (sysdate - to_date('21-01-15','yy-mm-dd'))
from dual;

--'01-15-2021' :���ϳ�
select (sysdate - to_date('01/15/2021', 'mm/dd/yyyy'))
from dual;

---37. 03/06/17���Ŀ� �Ի��� �����?
select * from employees where hire_date > '03/06/17';
select * from employees where hire_date > to_date('03/06/17','yy-mm-dd');

---38. 17/06/03(�Ͽ���)���Ŀ� �Ի��� �����?
select * from employees where hire_date > to_date('17/06/03','dd-mm-yy');
-- 06/17/03(���ϳ�)���Ŀ� �Ի��� �����?
select * from employees where hire_date > to_date('06/17/03', 'mm-dd-yy');

-- 39. ���� ��ȯ�Լ� : ��¥�� ���� ��ȯ
--               ��¥         ����
---            RR-MM-DD =>  'yyyy-mm-dd'
---            RR-MM-DD =>  'dd-mm-yy'
---            RR-MM-DD =>  'mm-dd-yy'
select to_char(sysdate, 'yy-mm-dd'), sysdate, to_char(sysdate,'dd-mm-yy'),
       to_CHAR(sysdate, 'yyyy-mm-dd'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS.SSSSS AM'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS.SSSSS AM'),
       TO_CHAR(SYSDATE, 'YYYY-MONDD HH24:MI:SS.SSSSS AM')
from dual;

-- ��¥�� ���ڿ��� �����Ͽ� ��¥ ��   -- ���� ���� 
-- 40. 25-04-2003 ���� �ʰ� �Ի��� ����� ��� 
--                                    RR-MM-DD
--- �߸��� �� ���
SELECT * FROM EMPLOYEES WHERE TO_CHAR(HIRE_DATE, 'DD-MM-YYYY') > '25-04-2003';

-- ���ڿ��� ��¥�� �����Ͽ� ��¥ ��
SELECT * FROM EMPLOYEES WHERE HIRE_DATE > TO_DATE('25-04-2003', 'DD-MM-YYYY');

--���ڸ� ���ڿ���
--- 1,234,567 => W1,234,567, $1,234,567, $1,234,567-
SELECT TO_CHAR(1234567.890, '9,999,999'),
        TO_CHAR(1234567.890, '9,999,999.00'),
        TO_CHAR(1234567.890, '$9,999,999.00'),
        TO_CHAR(1234567.890, 'L9,999,999.00'),
        TO_CHAR(-1234567.890, 'L9,999,999.00MI')
FROM DUAL;

-- 41. �̸�, ��, ���� �μ� �׸��� �޿��� ���ڸ��� ,�� ��� $�� ��µǰ� �Ͻÿ�.
SELECT  first_name, last_name, job_id, department_id,
        to_char(salary, '$99,999,999mi'),
        to_char(-salary, '$99,999,999mi') --ȸ�� ��Ʈ
FROM EMPLOYEES;

-- 42. janette�Ǵ� JANETTE �Ǵ� jaNette ���� ���� �޾Ҵ�.
---   �̸��� 'Janette'�� ����� ����Ͻÿ�.
SELECT * FROM EMPLOYEES
WHERE first_name = INITCAT('janette') 
      OR first_name = INITCAT('JANETTE') 
      OR first_name = INITCAT('jaNette');

SELECT * FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) = LOWER('janette') ;
      
SELECT * FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) = 'janette' OR UPPER(FIRST_NAME) = 'JANETTE'
    OR LOWER(FIRST_NAME) = LOWER('jaNette');

--- ǥ���� :  SWITCH(����) ~ CASE ���� :  �����; break; default :�����
---          CASE ���� WHEN ���� THEN ����� else ����� end

-- 43. --- job_id�� 'IT_PROG' �޿��� 10%���
--                  'ST_CLERK' �޿��� 15%���
--                  'SA_REP' �޿��� 20%���
--                   ���ܴ̿� �޿�
-- ��, �̸�, �޿��� ���� ���
SELECT LAST_NAME, FIRST_NAME, salary, job_id,
       CASE job_id when 'IT_PROG' then salary + salary * 0.1
                   when 'ST_CLERK' then salary + salary * 0.15
                   when 'SA_REP' then salary + salary * 0.2
                   else salary end sal
from employees;

SELECT LAST_NAME, FIRST_NAME, salary, job_id,
       decode ( job_id , 'IT_PROG'  , salary + salary * 0.1
                       , 'ST_CLERK' , salary + salary * 0.15
                       , 'SA_REP'   , salary + salary * 0.2
                       , salary ) sal
from employees;


SELECT LAST_NAME, FIRST_NAME, salary, job_id,
       CASE  when job_id ='IT_PROG' then salary + salary * 0.1
             when job_id = 'ST_CLERK' then salary + salary * 0.15
             when job_id = 'SA_REP' then salary + salary * 0.2
             else salary end sal
from employees;

--- 44. ��, �̸�, ����, �޿�, �޿��� ���� ��å�� ���� ����ϼ���.
--- �޿��� 3000�����̸� ��� 
--        5000�����̸� ����
--        7000�����̸� �븮
--        9000�����̸� ����
--       11000�����̸� ����
--       13000�����̸� ����
--       �� �̻� �̸� �ӿ�
select last_name, first_name, job_id, salary , 
        case  when salary <= 3000 then '���'
              when salary <= 5000 then '����'
              when salary <= 7000 then '�븮'
              when salary <= 9000 then '����'
              when salary <= 11000 then '����'
              when salary <= 13000 then '����'
              else '�ӿ�' end grade
from employees;

-- 45. �޿��� ���� ������ ����ϰ� �ʹ�. �̸� , ��, �޿�, ����, ������ ����Ͻÿ�.
---  �޿��� 2000���� ���� ���� 0�̸� �޿��� 0%
---                         1�̸� �޿��� 9%
---                         2�̸� �޿��� 20%
---                         3�̸� �޿��� 30%
---                         4�̸� �޿��� 40%
---                         5�̸� �޿��� 42%
---                         6�̸� �޿��� 44%
---                         �̿� �޿��� 45% �����̴�.
-- trunc(salary / 2000)
                   
select first_name, last_name, salary, job_id, 
    case trunc(salary / 2000, 0) when 0 then salary * 0.00
                                 when 1 then salary * 0.09
                                 when 2 then salary * 0.20
                                 when 3 then salary * 0.30
                                 when 4 then salary * 0.40
                                 when 5 then salary * 0.42
                                 when 6 then salary * 0.44
                                 else salary * 0.45 end tex
from employees;

select first_name, last_name, salary, job_id, 
    decode ( trunc(salary / 2000, 0) , 0 , salary * 0.00
                                     , 1 , salary * 0.09
                                     , 2 , salary * 0.20
                                     , 3 , salary * 0.30
                                     , 4 , salary * 0.40
                                     , 5 , salary * 0.42
                                     , 6 , salary * 0.44
                                     , salary * 0.45 ) tex
from employees;