select * from employees;
select * from departments;
select * from jobs;
select * from job_history;
-- 프로젝션 : 원하는 열만 가져오도록 한다.
-- * : 모든 컬럼을 프로젝션하겠다.
-- 1. 직원번호, 이름 , 이메일, 입사일 
select employee_id, first_name, email, hire_date
from employees;

-- 2. 직원번호, 이름 , 급여, 각 사원 급여에 100더하시오
select employee_id, first_name, salary, salary + 100
from employees;

-- 3. 직원번호, 성, 입사일, 직무, 연봉을 출력하시오
select employee_id, last_name, hire_date, salary, salary * 12
from employees; -- 각행에 있는 열에 수식을 사용가능
-- 부서정보
select * from departments;
--- 4. 주소, 부서번호, 부서장번호, 부서명순으로 출력
select location_id, department_id, manager_id, department_name
from departments; -- 컬럼의 순서를 무작위로 사용가능

-- 5. 사원테이블에서 직원번호 , 입사일, 성, 급여순으로 출력
select employee_id, hire_date, last_name, salary 
from employees; -- 컬럼의 순서를 무작위로 사용가능

-- 6. 연산:
-- 사원테이블에서 사원번호, 부서번호 , 직무, 연봉을 출력하는데 
-- 매월 300씩 보너스가 지급이 된다.
select employee_id, department_id, job_id, salary, (salary + 300) * 12
from employees;

-- 7. 사원테이블에서 사원번호, 부서번호 , 직무, 연봉을 출력하는데 
-- 마지막 달에 300이 특별 보너스로 지급이 된다.
select employee_id, department_id, job_id, salary, salary * 12 + 300
from employees;

-- 8. 사원테이블에서 사원번호, 성, 이메일 , 급여에 대한 커미션이 30%씩 지급이될 때
-- 커미션 까지 출력하시오.
select employee_id, last_name, email, salary , salary * 0.3
from employees;

-- 9.  사원테이블에서 직원번호 이메일 이름 입사일 급여, 커미션퍼센트를 출력
select  employee_id, first_name, salary, commission_pct
from employees; 

-- 10을 출력하시오
select 10 from dual;
-- 10에  null을 곱하시오.
select 10 * null from dual;

-- 10.  사원테이블에서 직원번호 이메일 이름 입사일 급여, 커미션퍼센트를 출력하는데
-- 각 사원이 받는 커미션의 금액도 같이 출력하시오.
select employee_id, email, hire_date, first_name, salary, commission_pct
      , salary * commission_pct
from employees;

select employee_id, email, hire_date, salary + null
from employees;

select employee_id , email, hire_date, department_id, job_id
      ,commission_pct * null  
from employees;

-- 11. 직원번호, 이메일, 이름, 입사일, 연락처, 부서번호, 급여, 커미션퍼센트, 
-- 그리고 커미션이 포한된 연봉을 출력하시오,
select employee_id, email, last_name, hire_date, phone_number, department_id
       , salary, commission_pct, (salary + salary * commission_pct) * 12 
from employees;

--12.  heading name에 별칭 주기

select employee_id eid, email, last_name lname, hire_date hd, phone_number ph
      , department_id did, salary sal, commission_pct comm
      ,(salary + salary * commission_pct) * 12 year_sal
from employees;
-- 13. 별칭에 as 사용
select employee_id as eid, email, first_name as fname, salary sal
from employees;
--14.  별칭에 공백문자와 대소문자 구분하기
select employee_id, first_name , salary, commission_pct
       , salary + salary * 12 as "year sal"
       , salary + salary * 12  "year sal"
       ,salary + salary * 12 as Year_Sal
       ,salary + salary * 12 as "Year Sal"
from employees;
-- 자바에서 문제가 생길수 있어서 별칭에 공백문자를 쓰지 앟고 대소문자를 구별하지
-- 않는 것이 좋다.
select '이숭무' from dual;

--- 15. 문자열 붙이기 연산자( || )
select '이' || '숭무' from dual;

select employee_id, '나의 성은 ' || last_name , first_name, salary
from employees;

select employee_id, last_name, salary, '2021-11-19' , 35
from employees;

--- 16. 직원번호, last_name first_name(KingSteven),급여, 직무
select employee_id, last_name || first_name, salary, job_id
from employees;

--17. 16번문제에서 성과 이름에 공백문자를 넣자.
select employee_id, last_name || ' ' || first_name, salary, job_id
from employees;

-- 18. 사원번호와 급여를 출력하는 사이에 아래 내용이 출력되게 하시오. 
-- "KingSteven의 직무는 AD_PRES입니다"로 출력하자.
select employee_id,last_name||first_name||'의 직무는 '||job_id||'입니다',salary
from employees;
-- 19. 직원의 부서번호만 출력하시오.
select department_id from employees;
-- 20. 직원의 부서를 모두 출력하지 말고 한번씩만 출력하시오.
--     직원이 속해있는 부서가 어떠한 부서들인지 알고 싶다.
select DISTINCT department_id from employees;

select DISTINCT job_id, department_id
from employees;
--- 행의 값이 모두 같은 경우 제거가 되지만 적어도 하나의 컬럼 값이 다르다면 출력된다.

--      107                 12
--select  job_id, DISTINCT department_id
--from employees;
-- DISTINCT는 중간에 사용할 수 없고 맨 앞에만 사용해야 한다.

-- 21. 직무와 입사일이 중복되지 않은 것만 출력하시오.
select DISTINCT job_id, hire_date
from employees;
---- select 컬럼,..., 연산식
---- from 테이블명

---- selection------ 원하는 행을 가져오기
-- 조간식 : where절 
-- select 컬럼,..., 연산식
-- from 테이블명
-- where 조건식

-- 22. 90인 부서의 사원들을 출력하시오. 
select * 
from employees
where department_id = 90; --조건식

-- 23. 사원번호, 성, 이름, 급여를 출력
select employee_id, last_name, first_name, salary
from employees;

-- 24. 90인 부서의 사원들을 출력할 때 사원번호, 이름 , 성, 급여 출력
select employee_id, first_name, last_name, salary
from employees
where department_id = 90; 

-- 25. 이름이 'Nancy'인 사원의 입사일 , 직무, 급여, 커미션퍼센트를 출력하세요.
select hire_date, job_id, salary, commission_pct
from employees
where first_name = 'Nancy';

Select Hire_Date, Job_id, salary, commission_pct
from EmployeeS;

select hire_date, job_id, salary, commission_pct
from employees
where first_name = 'nancy';
-- 문자열 리터널인 경우에는 대소문자를 구분하여 사용해야 한다.

-- 26. 입사일이 06/01/03인 사원을 출력하시오.
-- hire_date의 데이터 타입이 date 나 timestamp
select * from employees
where hire_date = '06/01/03';
select * from employees
where hire_date = '06-01-03';
select * from employees
where hire_date = '06.01.03';
select * from employees
where hire_date = '2006-01-03';

-- 비교 연산(관계연산) :  =, >, >=, <, <=, <>, !=, ^=
-- 27. 급여가 3000이상인 사원들의 성, 급여를 출력하시오.
select last_name, salary
from employees
where salary >= 3000;

-- 28. 입사일이 06/01/03보다 늦게 입사한 직원의 사원번호 이름 급여를 출력하시오.
select employee_id, first_name, salary
from employees
where hire_date > '06/01/03';
-- 30. 급여가 3000이 아닌 사원을 모두 출력하시오.
select * from employees where salary != 3000;
select * from employees where salary <> 3000;
select * from employees where salary ^= 3000;

-- 31. 급여가 2500에서 3500사이인 사원들 중 사원번호와 이름, 급여, 직무, 입사일을 출력
select employee_id , first_name, salary, job_id, hire_date
from employees
where salary between 2500 and 3500;

-- 32. 성이 King부터  Smith사이에 있는 사원들을 출력하시오.
select * from employees
where last_name between 'King' and 'Smith';

-- 33. 입사일이 02/06/07부터 06/01/03사이에 입사한 사원들을 출력하시오.
select * from employees
where hire_date between '2002/06/07' and '2006.01.03';

--- 50인 부서의 사원을 출력
select * from employees where department_id = 50;
-- 70인 부서의 사원을 출력
select * from employees where department_id = 70;
-- 90인 부서의 사원을 출력
select * from employees where department_id = 90;

-- 34. 50, 70, 90인 부서의 사원들을 출력하세요.
select * from employees where department_id in (50,70,90);

-- 35. 상사가 100,101,102인 사원들을 구하시오.
select * from employees
where manager_id in (100,101,102);
-- 36. 성이 'Hartstein', 'Vargas'인 사원들을 출력하시오.
select * from employees
where last_name in ('Hartstein', 'Vargas');

-- 37. 사장의 직원번호는 100번이다. 사장이 직속상사인 사원은?
select * from employees
where manager_id = 100;

-- like
-- 38. 성에 s가 포함되어 있는 직원을 출력하세요.
select * from employees where last_name like '%s%';
-- select * from board where contents like '%이숭무%';

-- 39. 직무에 'CL'이 포함한된 사원들을 출력하시오.
select * from employees where job_id like '%CL%';

-- 40. 직무에 'ST'이 포함한된 사원들을 출력하시오
select * from employees where job_id like '%ST%';

-- 41. 이름이 'B'로 시작하는 지원을 출력하세요.
select * from employees where first_name like 'B%';
select * from employees where first_name like 'b%';

-- 42. 이름이 'a'로 끝나는 지원을 출력하세요.
select * from employees where first_name like '%a';

-- 43. 02년도에 입사한 사원?
select * from employees where hire_date like '02%';

-- 44. 02월에 입사한 사원은? --52번에 답
-- select * from employees where hire_date like '%02%';
--02/01/01 , 01/02/01, 05/01/02

-- 45. 이메일에 두번째 글자가 'K'인 사원을 출력하시오.
select * from employees where email like '_K%';

-- 46. 성에 두번째 글자가 'o'인 사원을 출력하시오.
select * from employees where last_name like '_o%';

-- 47. 이메일에 세번째 글자가 'A'시작하는 사원?
select * from employees where email like '__A%';

-- 48. 이메일에 세번째 글자가 'O'시작하는 사원?
select * from employees where email like '__O%';

-- 49. 이메일의 마지막에서 두번째 글자 'O'인 사원은?
select * from employees where email like '%O_';

-- 50. 이메일의 앞에서 두번재가 K이고 뒤에서 두번째가 'O'인 사원을 출력하시오.
select * from employees where email like '_K%O_';

-- 51. IT_로 시작하는 직무를 구하시오
select * from employees where job_id like 'IT\_%' escape '\';

-- 52. 02월에 입사한 사원들을 출력하세요.
select * from employees where hire_date like '___02%';

-- null
-- 53. 커미션을 받지 못하는 직원들을 출력하시오.
-- select * from employees where commission_pct = null;
select * from employees where commission_pct is null;

-- 54. 상사가 없는 직원을 출력하시오.
select * from employees where manager_id is null;

-- 55. 부서에 부서장이 없는 부서정보를 출력하세요.
select * from departments where manager_id is null;

---56. 부서가 없는 직원을 출력하시오.
select * from employees where department_id is null;

--- 논리 연산자.. or, and : 부울타입과의 연산
-- 57. 직무가 AD_VP이면서 부서번호가 90인 사원들을 출력하세요.
select * from employees where job_id = 'AD_VP'; 
select * from employees where job_id = 'AD_VP' and department_id = 90;

-- 58. 급여가 10000이상이면서 직무에 'MAN'포함되어 있는 사원은?
select * from employees where salary >= 10000;
select * from employees where job_id like '%MAN%';

select * from employees where salary >= 10000 and job_id like '%MAN%';

-- 59. 급여가 5000부서 10000 사이인 사원을 구하시오.
select * from employees where salary >= 5000;
select * from employees where salary <= 10000;
select * from employees where salary between 5000 and 10000;
select * from employees where salary >= 5000 and salary <=10000;

-- 60. 입사일이 03/06/17에서 05/09/21사이에 입사한 사원을 출력하시오.and사용
select * from employees where hire_date >= '03/06/17' and hire_date <= '05/09/21';

-- 61. 급여가 10000이상인 사원을 출력
select * from employees where salary >= 10000;
-- 62. 직무에 'MAN'을 포함하고 있는 사원을 출력
select * from employees where job_id like '%MAN%';
-- 63. 61의 결과와 62의 결과를 같이 출력하세요.
-- 급여가 10000이상인 사람과 직무가 MAN을 포함하고 있는 사람을 출력하세요.
select * from employees where salary >= 10000 or job_id like '%MAN%';

---64. 부서가 100인 사원과 직무가 'SA_REP'인 사원을 출력하시오.
select * from employees where department_id = 100 or job_id = 'SA_REP';

-- 65.  부서가 100이면서 직무가 'SA_REP'인 사원을 출력하시오.
select * from employees where department_id = 100  and job_id = 'SA_REP';

-- 66. 직무가 'AD_PRES', 'AD_VP', 'IT_PROG'인 사원을 출력하세요
select * from employees where job_id in ('AD_PRES', 'AD_VP', 'IT_PROG');
--or
select * from employees where job_id='AD_PRES' or job_id='AD_VP' or job_id='IT_PROG';

--- 직무가 IT_PROG이거나 직무가 ST_MAN이면서 급여가 6000이상인 사원을 출력하시오.
select * from employees where job_id = 'IT_PROG' and salary >= 6000
                           or job_id = 'ST_MAN' and salary >= 6000 ;
select * from employees
where (job_id = 'IT_PROG' or job_id = 'ST_MAN') and salary >= 6000;
-- in 
select * from employees
where job_id in ('IT_PROG' ,'ST_MAN') and salary >= 6000;

-- and가 or보다 우선 순위가 높다.
select * from employees
where job_id = 'IT_PROG' or job_id = 'ST_MAN' and salary >= 6000;

select * from employees
where salary >= 6000 and job_id = 'IT_PROG' or job_id = 'ST_MAN';

-- 67. 직무가 'AD_PRES', 'AD_VP', 'IT_PROG'에 해당하지 않은 사원을 출력하세요
select * from employees where job_id!='AD_PRES' and job_id!='AD_VP' and job_id!='IT_PROG';
select * from employees where job_id not in ('AD_PRES', 'AD_VP', 'IT_PROG');

-- 68. 급여가 6000보다 작거나  10000보다 큰 사원을 출력하세요.
select * from employees where salary < 6000 or salary > 10000;
select * from employees where salary not between 6000 and  10000;

-- 69. 커미션을 받지않는 사원들을 구하시오.
select * from employees where commission_pct is null;
-- 커미션을 받는 사원들을 출력하세요.
select * from employees where commission_pct is not null;

-- 70.  부서테이블에서 부서장이 있는 부서를 출력하시오.
select * from departments where manager_id is not null;

---  정렬 (내림차순, 오름차순)
select * from employees;

select salary , employee_id , first_name, hire_date
from employees;

-- 71. 급여를 기준으로 오름차순으로 정렬되어 급여, 사원번호, 이름 입사일을 출력하세요.
select salary , employee_id , first_name, hire_date
from employees
order by salary ;

-- 72. 80번 부서의 사원들을 출력할 때 입사일이 제일 빠른 사람부터 출력하시오.
select * from employees
where department_id = 80
order by hire_date asc; -- asc 기본설정이므로 생략이 가능하다. 

--- 기본 문법
--select       4
--from         1
--where        2
--order by     3
---
-- 73. 50번 부서의 사원들을 출력할 때 입사일이 제일 늦은 사람부터 출력하시오.
select * from employees
WHERE department_id = 50
order by hire_date desc;

-- 74. 50번 부서의 사원들을 출력할 때  급여가 제일 작은 사람부터 출력하시오.
select * from employees
where department_id = 50
order by salary asc;

-- 75. 급여가 6000이상이고 10000이하인 사원들을 입사일이 빠른 사원들을 기준으로 출력하세요.
select * from employees
where salary between 6000 and 10000
order by hire_date asc;

-- 76. 
--- 사원번호, 이름, 입사일 , 급여, 부서번호 를 출력할 때 급여를 제일 많이 받는 
--- 사원부터 출력하시오. 급여에 sal로 별칭을 사용한다.
select employee_id, first_name, hire_date, salary sal, department_id
from employees
order by salary desc; 
-- 정렬에 별칭 사용
select employee_id, first_name, hire_date, salary sal, department_id
from employees
order by sal desc; 
--          1            2         3          4           5
select employee_id, first_name, hire_date, salary sal, department_id
from employees
order by 4 desc; -- 정렬에 컬럼 순서 번호 사용 

-- 77. 부서가 오름차순으로 정렬된 상태에서 부서내에 있는 직무를 오름차순으로 정렬히세요.
select * from employees 
order by department_id asc, job_id ;

-- 78. 부서가 오름차순으로 정렬된 상태에서 부서내에 있는 직무를 내림차순으로 정렬
select * from employees 
order by department_id asc, job_id desc;

-- 79. 부서를 오름차순으로 정렬하고 각부서에서 직무가 내림차순으로 정렬된 상태에서
--- 직무에 따른 급여를 제일 많이 받는 사람부터 출력되게 하세요.
select * from employees
order by department_id , job_id desc, salary desc;

select * from employees
order by 11 , 7 desc, 8 desc;

-- 80 부서를 오름차순으로 정렬하여 출력하고 같은 부서에서 다른 직무를 가진 사원들이 있다면
--- 직무를 내림차순으로 정렬하고 같은 직무에서도 급여가 서로 다르므로 급여를 오름차순으로
--- 정렬하되 급여를 받는 사람들의 입사일을 오름차순으로 정렬하시오. 

select * from employees
order by department_id , job_id desc, salary , hire_date;

--- 성이 Austin부터 Sciarra사이에 있는 사원들을 부서별 급여를 모두 내림차순으로 정렬하세요.
select * from employees where last_name between 'Austin' and 'Sciarra'
order by department_id desc, salary desc;
--- 성이 Austin부터 Sciarra사이에 있는 사원들을 직무별 급여를 모두 내림차순으로 정렬하세요.
select * from employees where last_name between 'Austin' and 'Sciarra'
order by job_id desc, salary desc;




