-- 1. 성과 이름을 붙여서 출력하시오.
select '나의 이름은 ' || last_name || first_name || '입니다.'
from employees;
--concat
select concat('나의 이름은 ',CONCAT(last_name, concat(first_name,'입니다'))) 
from employees;

-- 2. nvl
-- 성, 이름, 직무, 급여, 커미션을 포함한 년봉
select last_name, first_name, job_id, salary, 
       (salary + salary * nvl(commission_pct,0)) * 12 year_sal
from employees;

-- 3. nvl2
select last_name, first_name, job_id, salary,
--           널이 아니면 두번째 값 출력
--           널이면 세번째 값 출력
       nvl2(commission_pct, (salary + salary *  commission_pct) * 12,
                            salary * 12)
from employees;

-- 4. nullif
select first_name, length(first_name),
       last_name, length(last_name),
       --       exp1                  exp2
       nullif(length(first_name), length(last_name)) result
       -- exp1과 exp2가 같으면  null출력
       -- exp1과 exp2가 다르면 exp1를 출력
from employees;

---5.coalesce함수
--                          exp1           exp2  exp3  exp4
select last_name, coalesce(commission_pct, salary, 10) comm
           --             exp1가 널이 아니면 exp1를 출력
           --             exp1가 널이면 exp2를 출력 
           --             exp1과 exp2가 모두 null이면 exp3출력
from employees;

--  다중행 함수
---6. 급여를 제일 많이 받는 사람과 적게 받는 사람을 출력, 급여 평균
select max(salary), min(salary) ,  avg(salary)
from employees;

--- 7. 급여를 받는 사람의 수와, 부서를 가지고 있는 사람의 수를 출력하시오.
select * from employees;
select count(salary), count(department_id)
from employees;
--- 다중행 함수는 null값은 제외하고 계산을 한다.

-- 8. 커미션을 받는 사원들의 커미션의 평균과 직원 전체의 커미션 평균을 구하시오.
select avg(commission_pct), sum(commission_pct) / count(*)
from employees;
-- 다중행 함수는 null값을 포함하지 않으므로 전체의 값을 구할때 값이 다를 수 있다.

--9. 전체의 사원의 수를 구하시오. (행 전체의 갯수)
select count(*) from employees;

-- 10. 제일 늦게 입사한 사원과 제일 처음에 입사한 사원을 출력하시오.
select max(hire_date), min(hire_date)
from employees;

--11.직무에 'REP'를 가지고 있는 사원들 중 제일 많이 받는 급여와 적게 받는 급여를 출력,
--    평균 급여와 사원의 수, 급여의 합계 
select max(salary), min(salary), avg(salary), count(*), sum(salary) 
from employees
where job_id like '%REP%';

---       107                 107
select first_name,salary, to_char(hire_date, 'dd-mm-yyyy')
from employees;

--다중행 함수를 사용하는 경우 다중행 함수만 사용해야 한다. 컬럼을 추가 할 수 없다.
--select first_name, sum(salry)
--from employees;

-- 12.80번 부서에서 커미션을 받는 사원의 수와 최대 커미션 값과 최소 커미션 값을 출력
--     부서에 속해 있는 사원의 수 
select count(commission_pct), max(commission_pct), min(commission_pct),
       count(*)
from employees
where department_id = 80;

-- 13. 중복되지 않은 부서는?
select  distinct(department_id)
from employees;

-- 14. 중복되지 않은 부서의 수는?
select count(distinct(department_id))
from employees; -- null 은 부서가 아니므로 제외

-- 15. 커미션의 받는 사원의 커미션 평균과 
--    커미션을 받지 않는 사원의 커미션의 평균을 구하시오.
select trunc(avg(commission_pct), 4), 
       trunc(sum(commission_pct) / count(*),4),
       trunc(avg(nvl(commission_pct,0)),4)
from employees;

--- 16. 90인부서의 급여의 평균, 합계, 최대, 최소, 사원의 수
select avg(salary), sum(salary), max(salary), min(salary),count(*)
from employees
where department_id = 90;
--      80인부서의 급여의 평균, 합계, 최대, 최소, 사원의 수
select avg(salary), sum(salary), max(salary), min(salary),count(*)
from employees
where department_id = 80;
--      70인부서의 급여의 평균, 합계, 최대, 최소, 사원의 수
--      ...
select avg(salary), sum(salary), max(salary), min(salary),count(*)
from employees
where department_id = 70;

-- 17. 각 부서별 부서의 급여의 평균, 합계, 최대, 최소, 사원의 수
select department_id, --  group by절에 있는 컬럼은 select절에 사용 가능하다.
       trunc(avg(salary),2), sum(salary), max(salary), min(salary),count(*)
from employees
group by department_id
order by  department_id;

-- 18. 같은 직무를 하는 사원들 중 제일 먼저 들어 온 사원가 제일 늦게 들어온 사원의 
---    입사일을 출력하시오.
---             늦게 들어온 날    빨리 들어온 날
select job_id, max(hire_date), min(hire_date)
from employees
group by job_id
order by job_id;

-- 19. 사원번호,  이름, 입사일, 직무, 부서를 출력할 때.
-- 부서는 오름차순으로 정렬하고 각 부서의 직무를 오름차순으로 정렬하여 출력하시오.   
select department_id, job_id, employee_id, first_name, hire_date
from employees
order by department_id, job_id;

-- 20.  각 부서의 직무별 급여 평균 , 합계, 담당하는 사원의 수를 출력
select department_id, job_id , trunc(avg(salary)), sum(salary), count(*)
from employees
group by department_id, job_id
order by department_id, job_id;

-- 20. 90부서에서 직무별 급여 합계와 평균 구하시오.
select job_id, avg(salary), sum(salary) 
from employees                  -- 1
where department_id = 90        -- 2
group by job_id ;                -- 3

-- 21. 각부서에서 직무가 같은 사원들 중 입사일이 같은 사원의 수를 구하시오.
-- 사원수가 2명이상만 출력
select department_id, job_id, hire_date, count(*)
from employees                            --1                     
group by department_id, job_id, hire_date
having count(*) >= 2;  -- group 함수의 조건이 있는 경우 having절을 사용                   

-- 22. 평균급여가 7000이상인 부서만 출력하시오.평균 급여 높은 것 부터 출력하시오.
select department_id, avg(salary) sal
from employees
group by department_id
having avg(salary) >= 7000
-- order by avg(salary) desc;
-- order by sal desc;
order by 2 desc;

-- 23. 부서의 직원 수가 10명 미만이 부서를 출력하시오.
select department_id , count(*)
from hr.employees
group by department_id
having count(*) < 10;

-- 25. 직무에 'REP'가 포함되어 있지 않은 직무별 급여의 평균, 합계, 최소, 
--- 최대 값을 출력할때 급여의 합계가 13000이상인 직무만 출력하시오.
select job_id, avg(salary), sum(salary), min(salary), max(salary)
from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000;

--- 다중행 함수, group by, having
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


-- 27. 모든 사원의 성, 이름, 급여 , 직무, 부서번호, 지역번호, 부서명을 출력하시오.
select employee_id, last_name, first_name, salary, job_id,     --3
       d.department_id, location_id, department_name
from employees e, departments d                                      -- 1
--           10                         10
--            20                        20
where e.department_id = d.department_id;      --2

--- 카티시안 조인
select employee_id, last_name, first_name, salary, job_id,     --3
       departments.department_id, location_id, department_name
from employees, departments;

--28. 사원의 성, 급여 , 입사일, 직무를 출력할 대 직무명도 같이 출력하시오.
select last_name , salary, hire_date, employees.job_id, job_title
from employees, jobs
where employees.job_id = jobs.job_id;

-- 부서 테이블에서 90인 부서정보를 출력하시오.
select * from departments where departments.department_id = 90;
-- 90인 부서의 직원을 구하시오,.
select * from employees where department_id = 90;
--- 100번 사원 정보를 출력하시오.
select * from employees where employee_id = 100;

--T-SQL join
select employee_id, last_name, first_name, salary, job_id,     
       d.department_id, location_id, department_name
from employees e, departments d  
where e.department_id= d.department_id;
-- Ansi - join
-- 29. 직원번호, 성, 이름, 급여, 직무, 부서번호, 지역번호, 부서명을 Anti-join
select employee_id, last_name, first_name, salary, job_id,     
       d.department_id, location_id, department_name
from employees e join departments d  
on e.department_id= d.department_id;

-- 30. anti-join으로 직원번호 .성, 이름 급여 부서번호, 부서명을 100사원만 출력하시오.
select last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id -- join조인 조건
where employee_id = 100;

-- 31. natural join
-- 직원 번호, 성, 이름 , 직무, 직무명을 출력하세요.
select employee_id, last_name, firat_name, job_id, job_title
from employees e, jobs j
where e.job_id = j.job_id; -- 일반적으로 join조건은 primary key = foreign key
-- ansi - join 
select employee_id, last_name, firat_name, job_id, job_title
from employees e join jobs j
on e.job_id = j.job_id;
-- natual join
select employee_id, last_name, first_name, job_id, job_title
from employees natural join jobs; -- 별칭을 가질 수가 없다.
--- 테이블에 같은 이름의 컬럼을 비교하는 것이므로 조인조건이 필요 없다.  

-- 32. 부서장이 상사인 직원을 구하시오.
-- 직원번호, 성, 급여 입사일, 부서번호, 부서장번호를 출력하시오.
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

-- using절 사용
select employee_id, last_name, salary, hire_date, 
        department_id, manager_id
from employees join departments  using(department_id, manager_id);

----------
select last_name, first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id;
-- 같은 이름의 컬럼이 두개 이므로 natural join으로 변경 할 수 없다.
-------------
-- 33. 성 이름 직원번호 , 전화번호 , 급여 부서번호, 부서명 을 anti-join으로 출력하시오.
select last_name, first_name, employee_id, phone_number, salary,
       d.department_id , department_name
from employees e join departments d
on e.department_id = d.department_id;
--- using절 사용
select last_name, first_name, employee_id, phone_number, salary,
       department_id , department_name
from employees join departments using(department_id);

-- 34. 각 부서의 부서의 정보와 부서장의 이름을 출력 하시오.
select d.department_id, department_name, location_id, d.manager_id ,
       employee_id, first_name
from departments d, employees e
where d.manager_id = e.employee_id;
--    foreign key  =   primary key

--- 35. 
--- 직원 번호, 직무 번호 , 직무내용
select employee_id, j.job_id, job_title
from employees e, jobs j
where e.job_id = j.job_id;
--- 직원번호, 부서번호, 부서명
select employee_id, e.department_id, department_name
from employees e, departments d
where e.department_id = d.department_id;

--- 각 직원의 직원번호, 직무번호, 직무 내용, 부서번호, 부서명
-- t-sql
select employee_id, e.job_id, job_title, e.department_id, department_name
from employees e, jobs j, departments d
where e.job_id = j.job_id and e.department_id = d.department_id;
--- 테이블 3개이면 조인 조건은 최소 2개.
-- 테이블이 n개이면 조인조건 최소 n-1개

-- ansi-join
select employee_id, e.job_id, job_title, e.department_id, department_name
from employees e join jobs j
on e.job_id = j.job_id join  departments d 
on e.department_id = d.department_id;

select employee_id, job_id, job_title, department_id, department_name
from employees NATURAL join jobs join departments using (department_id);

--- 36. 부서장의 직무내용을 출력하시오. 부서장 번호, 직무내용,
select  d.manager_id, job_title
from jobs j,  employees e ,departments d
where e.job_id = j.job_id and e.employee_id = d.manager_id
and e.department_id = d.department_id;

--- 37. 부서가 없는 직원도 같이 출력
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

--- 38. 직원이 없는 부서 를 출력
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

-- 39. 부서가 없는 직원과 직원이 없는 부서를 출력
select first_name, last_name, salary, e.department_id, 
       d.department_id, department_name
from employees e full outer join departments d 
on e.department_id = d.department_id;
--
--select first_name, last_name, salary, e.department_id, 
--       d.department_id, department_name
--from employees e , departments d 
--where e.department_id(+) = d.department_id(+);