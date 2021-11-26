-- ex3_6란 테이블을 만들고, 사원테이블(employees)에서 관리자사번이 
--124번이고 급여가 2000에서 10000 사이에 있는 사원의 사번, 사원명, 급여, 
--관리자사번을 입력하는    INSERT문을 작성해보자.
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

-- 사원테이블(employees)에서 커미션(commission_pct) 값이 없는 
-- 사원의 사번과 사원명을 추출하는 쿼리를 작성해보자.
select employee_id, first_name
from employees
where commission_pct is null;

--  SELECT employee_id, salary 
--  FROM employees
--  WHERE salary BETWEEN 2000 AND 2500
--  ORDER BY employee_id;
--를 논리연산으로 변경
SELECT employee_id, salary 
FROM employees
WHERE salary >= 2000 and salary <= 2500;

--- SELECT employee_id, salary 
--  FROM employees
--  WHERE salary IN (2000, 3000, 4000)
--  ORDER BY employee_id;
--  any 변경하세요.
SELECT employee_id, salary 
FROM employees
WHERE salary = any (2000, 3000, 4000)
ORDER BY employee_id;

--- SELECT employee_id, salary 
--  FROM employees
--  WHERE salary not IN (2000, 3000, 4000)
--  ORDER BY employee_id;
--  all 변경하세요.
SELECT employee_id, salary 
FROM employees
WHERE salary <> all (2000, 3000, 4000)
ORDER BY employee_id;
-- 사원테이블(employees)에는 phone_number라는 컬럼에 사원의 전화번호가 
-- ###.###.#### 형태로 저장되어 있다.여기서 처음 3자리 숫자 대신 서울 지역번호인 
-- (02)를 붙여 전화번호를 출력하도록 쿼리를 작성해 보자. Lpad
select employee_id, lpad(substr(phone_number,5),length(phone_number), '(02)')
from employees;

--2. 현재일자 기준으로 사원테이블의 입사일자(hire_date)를 참조해서 근속년수가 
-- 10년 이상인 사원을 다음과 같은 형태의 결과를 출력하도록 쿼리를 작성해보자. 
-- (근속년수가 많은 사원순서대로 결과를 나오도록 하자)
-- 사원번호  사원명  입사일자 근속년수
select employee_id, first_name, hire_date , 
        round((sysdate - hire_date) / 365) "근속년수" 
from employees
where round((sysdate - hire_date) / 365) >= 10
order by "근속년수" desc;

--- 사원번호, 사원명, 급여, 전화번호를 출력할 때
-- 급여를 통화 단위로 전화번호는 .대신 -로 출력되게 쿼리문을 작성하시오.
select employee_id, first_name, to_char(salary,'$999,999,999'),
        replace(phone_number, '.','-')
from employees;

select * from employees;

--- 근속년수가 19년차 이상이면 이사 
---          18년차 이상이면 본부장
--           17년차 이상이면 부장
--           16년차 이상이면 차장
--           15년차 이상이면 과장
--           14년차 이상이면 대리
--                 이하이면 사원으로 출력하시오.
select employee_id, 
        case  when round((sysdate - hire_date)/365) >= 19 then '이사'
              when round((sysdate - hire_date)/365) >= 18 then '본부장'
              when round((sysdate - hire_date)/365) >= 17 then '부장'
              when round((sysdate - hire_date)/365) >= 16 then '차장'
              when round((sysdate - hire_date)/365) >= 15 then '과장'
              when round((sysdate - hire_date)/365) >= 14 then '대리'
              else '사원' end emp
from employees;
--- 급여를 1000으로 나눈 몫이 3이하면 사원 
--                          5이하면 주임
--                          7이하면 대리
--                          9이하면 과장
--                          10이하면 차장
--                          13이하면 부장
--                          15이하면 본부장
--                          그외엔 이사 로 출력하세요
select employee_id, 
        case when trunc(salary / 1000) <= 3 then '사원'
             when trunc(salary / 1000) between 4 and 5 then '주임'
             when trunc(salary / 1000) <= 7 then '대리'
             when trunc(salary / 1000) <= 9 then '과장'
             when trunc(salary / 1000) <= 10 then '차장'
             when trunc(salary / 1000) <= 13 then '부장'
             when trunc(salary / 1000) <= 15 then '본부장'
             else '이사' end emp
from employees;
             
-- 사원테이블에서 입사년도별 사원수를 구하는 쿼리를 작성해보자. 2004
select to_char(hire_date, 'yyyy') y , count(*)
from employees
-- group by substr(hire_date,1,2) 
group by to_char(hire_date, 'yyyy') 
order by y desc;


-- 아래의 쿼리는 분할 ROLLUP을 적용한 쿼리이다.
 SELECT department_id, job_id, SUM(salary) totl_jan
 FROM employees
 WHERE hire_date LIKE '03%' 
 GROUP BY  department_id, ROLLUP( job_id );
-- 
-- 이 쿼리를 ROLLUP을 사용하지 않고, 
-- 집합연산자를 사용해서 동일한 결과가 나오도록 쿼리를 작성해보자. 
 SELECT department_id, job_id, SUM(salary) totl_jan
 FROM employees
 WHERE hire_date LIKE '03%' 
 GROUP BY department_id, job_id 
 union 
 SELECT department_id, job_id, SUM(salary) totl_jan
 FROM employees
 WHERE hire_date LIKE '03%' 
 GROUP BY department_id;

--- 사번   사원명   job명칭 job시작일자  job종료일자   job수행부서명
--- 101번 사원만 출력하세요.
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

--- 각 부서의 급여를 제일 적게 받는 사원들을 구하세요.
select * 
from employees
where (department_id, salary) in 
(select department_id , min(salary)
 from employees
 group by department_id);

---- merge : insert, update
-- 원하는 데이블에 데이터가 없으면 insert
--               데이터가 있으면 update
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







--- 다음의 쿼리를 ANSI 문법으로 변경해 보자.
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









