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

--- 각 부서명별 최저 임금과 최대 임금 그리고 평균 임금을 출력하세요.
-- department_name
create or REPLACE view dept_sal_vw --- 복합 뷰
(dname, minsal, maxsal, avgsal)
as
select department_name, min(salary), max(salary), avg(salary)
from employees e, departments d
group by department_name;

select * from dept_sal_vw;


-- 직원번호 , 이름 , 입사일 , 급여, 부서번호 , 부서명을 출력하는 뷰를 만들자.
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

insert into vw_30 -- 뷰를 통해서 실제 테이블에 데이터가 들어갈 수 있다.
values(310, 'Rhee', 'SRhee', sysdate, 'AP', 210); 

select * from emp;

insert into vw_30( --뷰를 통해 보여지지 않는 컬럼이 있으면 데이터를 저장할 수 없다.
  EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID, department_id, manager_id)
values(320, 'Park', 'JPARK', sysdate, 'AP', 210, 110);

update vw_30 -- 뷰를 통해서 보여지지 않는 데이터는 수정할 수 없다. 
set LAST_NAME =  'SRHEE'
where employee_id = 310;

update vw_30 ---- 뷰를 통해서 보여지는 데이터는 수정이 가능하다.
set hire_date = sysdate
where employee_id = 115;

select * from vw_30;

update vw_30 ---- 뷰를 통해서 보여지지 않는 컬럼의 데이터는 수정할 수 없다.
set manager_id = 100
where employee_id = 115;

delete from vw_30
where employee_id = 115;

select * from vw_30;

delete from vw_30 --- 뷰로 보여지지 않으면 삭제가 안된다.
where employee_id = 310;

--- 뷰를 통해서 DML문을 사용할 수 있다.
-- 단 insert만 뷰에서 보이지 않아도 저장이 된다.
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
set c2 = 10    -- 복합 뷰에서 한 테이블에 있는 컬럼의 값은 수정이 된다.
where c1 = 1;

select * from v_viewup;
select * from viewup1;


update v_viewup
set c3 = 10
where c1 = 1;
select * from v_viewup;
select * from viewup2;

update v_viewup -- 뷰를 통해서 두 테이블의 데이터를 수정할 수 없다.
set c3 = 20, c2 = 20
where c1 = 1;

insert into v_viewup values(2,2,2); 
-- 뷰를 통해서 두 테이블의 데이터를 입력 할 수 없다
insert into v_viewup(c1, c2) values(2,2);
select * from v_viewup;
select * from viewup1;
-- c1은 viewup1에 있는 것을 사용하므로 viewup2에서는 c1을 사용할 수 없다.
insert into v_viewup(c1, c3) values(2,2);
select * from v_viewup;
select * from viewup2;

delete from v_viewup
where c1 = 1; -- viewup1에 c1을 삭제하겠다.
select * from v_viewup;
select * from viewup1;
select * from viewup2;
--- 복합 뷰는 DML문이 제한 적으로 사용이 된다.

create or REPLACE view empvw20
as
select * from emp where department_id = 20
with CHECK OPTION CONSTRAINT empvw20_ck;
--- with CHECK OPTION은 뷰에서 보이게 되는 데이터로만 수정 삭제 삽입이 가능

select * from empvw20;
insert into empvw20(employee_id, last_name, email, hire_date, job_id, 
                    department_id)
values(330, 'Park', 'JPARK', sysdate, 'AP', 210);

select * from emp where employee_id = 320;

update empvw20
set department_id = 50 ---수정 후 보여지지 않는 데이터는 수정 할 수 없다.
where employee_id = 201;

create view empvw80
as
select * from emp
where department_id = 80
with read ONLY; -- 읽기 전용 뷰 -- 모든 DML문을 거부

delete from empvw80 
where employee_id = 147;

-- 뷰 삭제
drop view empvw80;
select * from  empvw80; -- select는 테이블 또는 뷰에 데이터 검색하기 위해서 사용

--- 성, 급여, 부서번호, 부서의 최소급여
select last_name, salary, e.department_id, minsal
from employees e, (select department_id, min(salary) minsal
                   from employees
                   group by department_id ) d -- 인라인 뷰
where e.department_id = d.department_id;


-- 직원번호,이름, 직무, 입사일, 급여 그리고 각 부서의 사원수 및 평균 급여를 출력
select employee_id, first_name, job_id, hire_date, salary, cnt, avgsal
from employees e, (select department_id, count(*) cnt, avg(salary) avgsal
                   from employees
                   group by department_id) d
where e.department_id = d.department_id;

--  사원번호, 이름, 급여, 부서, 직무를 급여가 제일 많이 받는 사람부터 출력하세요.
select employee_id, first_name, salary, department_id, job_id
from employees
order by salary desc;

--- top-n
-- 급여를 제일 많이 받는 사람 5명을 가져오시오.
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


-- 급여를 제일 많이 받는 사원 10위부터 15위 까지 출력하세요.
-- 사원번호, 이름, 급여, 부서, 직무
select rownum, rn, employee_id, first_name, salary, department_id, job_id
from(select rownum rn, employee_id, first_name, salary, department_id, job_id
     from (select employee_id, first_name, salary, department_id, job_id
          from employees
          order by salary desc)
)
where rn >= 10 and rn <= 15; --- paging할 때 사용


-- 사원번호, 이름, 급여, 부서, 직무를 출력할 때 
-- 커미션을 제일 많이 받는 사원 5명을 출력하세요.
select rownum , rn, employee_id, first_name, salary, department_id, job_id,
      commission_pct
from ( select rownum rn, employee_id, first_name, salary, department_id, job_id
             , commission_pct
       from employees where commission_pct is not null
       order by  commission_pct desc)
where rownum <= 5;
--  사원번호, 이름, 급여, 부서, 직무를 출력할 때 
--- 커미션을 포함한 년봉을 제일 많ㅇ리 받는 사람 6위에서 10위까지만 출력
select  *
from( select rownum rn , employee_id, first_name, salary, department_id, job_id,
          year_sal
      from ( select employee_id, first_name, salary, department_id, job_id
                 , salary * ( 1+ nvl(commission_pct, 0)) * 12  year_sal
           from employees
           order by  year_sal desc)
    )
where rn >= 6 and rn <= 10;

--group by 절의 향상된 기능
-- 부서별 직무에 대한 급여의 합계와  부서번호, 직무를 출력하세요.
select department_id, job_id, sum(salary)
from employees
group by  department_id, job_id;
--부서별 급여의 평균이 9500이상인 부서만 출력하세요.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) >= 9500;

-- 부서별 직무의 급여의 평균과 부서별 급여의 평균 그리고 전체 평균을 출력하세요.
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

--- 각 부서에서 같은 직무를 하면서 입사일이 같은 사원의 수, 급여 평균
--- 각 부서의 직무별 사원의 수, 급여 평균
--- 각 부서의 사원의 수, 급여 평균
--- 전체 사원의 수, 급여 평균
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

-- 부서와 직무의 급여 합계
-- 부서의 급여의 합계
-- 직무의 급여의 합계
-- 전체 급여의 합계
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
--- 각 부서에서 같은 직무를 하면서 입사일이 같은 사원의 수, 급여 평균
--- 각 부서의 직무별 사원의 수, 급여 평균
--- 각 직무별 입사일 같은 사원의 수, 급여의 평균
--- 각 부서에서 입사일 같은 사원의 수 , 급여 평균
--- 각 부서의 사원의 수, 급여 평균
--- 각 직무의 사원의 수, 평균 급여
--- 입사일이 같은 사원의 수, 그여 평균
--- 전체 사원의 수, 급여 평균
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









