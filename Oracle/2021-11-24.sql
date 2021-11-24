--1. 성이 Abel인 사원의 직무를 출력하세요.
select job_id from employees where last_name='Abel';

-- 2. 성이 Abel인 사원과 같은 직무를 하는 사원들을 출력하시오.
select * from employees
where job_id = 'SA_REP';
--- 서브 쿼리가 메인 쿼리보다 먼저 실행이 된다.
--- 서브쿼리는 소괄호 안에 있어야 한다.
select * from employees
where job_id = (select job_id from employees where last_name='Abel');

-- 3. 106번인 사원의 급여를 구하세요.
select salary from employees where employee_id = 106;

-- 4. 106번인 사원과 같은 급여를 받는 사원들은?
select * from employees where salary = 4800;

select * from employees where salary = 
        (select salary from employees where employee_id = 106);
        
-- 5. 성이 Austin이라는 사원과 같이 일하는 사원들을 구하시오.
select * from employees 
where department_id =
	(select department_id from employees where last_name = 'Austin') ;
    
--- 6. 141번의 직무를 출력하시오.
select job_id from employees where employee_id = 141;--ST_CLERK
--     143번의 급여를 출력하시오.
select salary from employees where employee_id = 143;--2600 

-- 7. 141번의 직무와 같고 143번의 급여와 같은 사원들은?
--즉, 직무가 ST_CLERK이고 급여가 2600 인사원을 구하시오.
select * from employees
where job_id = 'ST_CLERK'
and salary = 2600;

select * from employees
where job_id = 
    (select job_id from employees where employee_id = 141)
and salary = 
    (select salary from employees where employee_id = 143);

-- 8. 최저 급여를 받는 사원을 구하시오.
select min(salary) from employees;
select * from employees
where salary = (select min(salary) from employees); 

-- 9. 90인부서의 평균 급여보다 많은 급여를 받는 사원을 구하시오.
select avg(salary) from employees where department_id = 90;

select * from employees
where salary > 
    (select avg(salary) from employees where department_id = 90);

-- 10. 입사일이 178번보다 늦게 입사한 사원을 구하시오.
select hire_date from employees where employee_id = 178;

select * from employees
where hire_date > 
    (select hire_date from employees where employee_id = 178);

-- 11.50인 부서의 평균 급여
select avg(salary) from employees
where department_id = 50;

-- 12. 각 부서의 평균 급여가 3475보다 큰 부서는?
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) > 3475;

-- 13. 50인 부서의 평균 급여보다 평균급여가 많은 부서를 구하시오.
select department_id, avg(salary)
from employees
group by department_id
having avg(salary) > 
    (select avg(salary) from employees
     where department_id = 50);

-- 14.  60인 부서의 최저 급여보다 더 적은 급여를 받는 사원은
select min(salary) from employees where department_id = 60;
select * from employees 
where salary < 
    (select min(salary) from employees where department_id = 60);

-- 15. 50, 60, 70 인 부서의 최저 금액과 같은 급여 받는 사원들은?
select * from employees
where salary in (select min(salary) from employees
                 where department_id in (50,60,70)
                 group by department_id);


-- 16. 각 부서의 최저 금액을 구하고 그 최저 금액에 해당 되는 모든 사원들을 출력하시오.
select * from employees
where salary in (
    select min(salary) from employees
    group by department_id);
    
-- 17. 평균 급여가 가장 적은 업무를 찾으세요.
select job_id, avg(salary)
from employees
group by job_id
having avg(salary) = (select min(avg(salary)) from employees
                      group by job_id);

-- 18. 50인 부서의 급여를 출력하세요.
select salary from employees where department_id = 50
order by salary;
               |---------------------------------------->
      ---------|------------------------|------
             2100                     8200
-- 19. 50인 부서의 사원들의 급여 중 최저 금액보다 더 많이 받는 사원들을 찾으세요.
;--   작은 것 보다 크다.
select * from employees where salary > 2100;
select * from employees 
where salary >  (select min(salary) from employees
                    where department_id = 50);
select * from employees 
where salary > any (select salary from employees
                    where department_id = 50);
-- 20. 50인 부서의 사원들이 받는 급여 중 제일 많이 받는 급여보다 적은 급여를 받는 
--     사원들을 찾으세요.
select * from employees 
where salary < ( select max(salary) from employees
                  where department_id = 50);
select * from employees --- 큰것보다 작다.
where salary < any( select salary from employees
                  where department_id = 50);

-- 21. 90인부서의 급여중 제일 작은 급여보다 적은 급여를 받는 사원들을 구하시오.
select * from employees
where salary < (select min(salary) from employees
                where department_id = 90);
select * from employees
where salary < all(select salary from employees
                where department_id = 90);
-- 22. 50인부서의 급여중 제일 많은 급여보다 더 많은 급여를 받는 사원들을 구하시오.
select * from employees
where salary > (select max(salary) from employees
                where department_id = 50);

select * from employees
where salary > all(select salary from employees
                where department_id = 50);

--- 23. 30인 부서의 사원들이 받는 급여와 같은 급여를 받는 사원들을 찾으세요.
select salary from employees where department_id = 30;
select * from employees 
where salary in (select salary from employees where department_id = 30);

select * from employees 
where salary = any (select salary from employees where department_id = 30);


select * from testa;
select max(a1) + 1 from testa;
insert into testa values((select max(a1) + 1 from testa), 3);

-- 집합연산자 (set : union, intersect, minus)
--                 합집합  교집합
--select user_id 
--from employees
--where user_id = 'highland0'
--union
--select user_id
--from member
--where user_id = 'highland0'

-- 24. 사원 테이블에서 108번인 상사 출력
select manager_id from employees where employee_id = 108;
--    부서 테이블에서 80인 부서의 부서장을 출력
select manager_id from departments where department_id = 80;
-- 108번의 상사와 80 부서의 부서장을 출력하라.
select manager_id from employees where employee_id = 108
union 
select manager_id from departments where department_id = 80;

-- 25. 사원테이블에 사원번호와 직무를 출력
select employee_id, job_id from employees; --- 107
    -- 직무연역 테이블에서 사원번호와 직무를 출력
select employee_id, job_id from job_history; -- 10
--   사원테이블에 사원번호, 직무 그리고 직무연역 테이블에서 사원번호와 직무를 출력
select employee_id, job_id from employees
union
select employee_id, job_id from job_history; -- 115

select employee_id, job_id from employees
union all
select employee_id, job_id from job_history;  -- 117

-- 26. 사원테이블에 있는 직속 상사와 직무 그리고 직무연역테이블의 직원번호와 직무를 출력
select manager_id,  job_id from employees
union
select employee_id, job_id from job_history; 
-- 컬럼의 이름은 동일하지 않아도 된다.

-- 27. 사원테이블에서는 이름, 급여를 출력하고 부서 테이블 부서명과 부서장을 출력
--- 각 열의 데이터 타입이 일치하면 된다.
-- heading name은 첫번째 테이블의 열이름이 된다.
--       문자              숫자
select first_name,      salary     from employees
union
--      문자               숫자
select department_name, manager_id from departments;

-- 28. 첫번 째 테이블의 열이름에 별칭 주기
-- 별칭이 heading name에 적용
select first_name dname,      salary mng    from employees
union
select department_name, manager_id from departments;

--29. 사원 테이블에서는 급여와 부서번호 그리고 부서테이블에서는 부서장과 부서이름
  --         숫자        숫자
select     salary,   department_id from employees
union
 --       숫자           문자
select manager_id, department_name from departments;
--- ORA-01790: 대응하는 식과 같은 데이터 유형이어야 합니다

-- 30. 29번에서 유형을 맞혀서 출력
select     salary,   department_id ,    '문자'            from employees
union
select manager_id,      0        ,department_name from departments;
---------------------------------------
select     salary,   department_id ,    to_char(null) from employees
union
select manager_id,   to_number(null) ,department_name  from departments;

-- 31. 사원테이블에서 부서번호, 입사일 그리고 부서테이블에서 부서번호, 지역번호 출력
select department_id , hire_date  h_date  , to_number(null) l_id 
from employees
union
select department_id ,  to_date(null)     ,   location_id
from departments;

--- 32. 부서테이블에는 존재하지 않은 직원테이블에만 존재하는 상사.
---     부서장이 아닌 관리자를 출력
select distinct manager_id from employees 
where manager_id not in (select manager_id from departments 
                         where manager_id is not null);

select manager_id from employees
minus -- 차집합
select manager_id from departments;

--- 부서장인 상사를 출력하시오 
select manager_id from employees
intersect ---교집합
select manager_id from departments;
-------------------------- 기본 select --------------------
----- DML : insert, delete , update 
---- 확장 DML : select, insert, delete , update 
create table aa1(
    a1 number primary key,
    a2 number
);
insert into aa1 values(1,1);
select * from aa1;
create table bb1(
    a1 number references aa1(a1),
    b1 number
);
insert into bb1 values(1, 11);
select * from bb1;
--drop table bb1;
--drop table aa1;
delete from aa1 
where a1 = 1; -- 무결성 제약조건(KOSA.SYS_C008461)이 위배되었습니다- 자
delete from bb1
where a1 = 1;
delete from aa1 
where a1 = 1;


create table aa2(
    a1 number primary key,
    a2 number 
);
insert into aa2 values(1, 1);
select * from aa2;
drop table bb2;
create table bb2(
    a1 number references aa2(a1) on delete set null,
    b1 number      -- 부모가 삭제되어 자식은 null
);
insert into bb2 values(1, 11);
select * from bb2;
create table cc2(
    a1 number references aa2(a1) on delete cascade,
    c1 number --부모가 삭제가 되면 자식도 삭제
);
insert into cc2 values(1, 22);
select * from cc2;

insert into aa2 values(2,2);
insert into bb2 values(2, 111);
insert into cc2 values(2, 222);
select * from aa2;
select * from bb2;
select * from cc2;
delete from aa2
where a1 = 1;

create table aa3(
    a1 number,
    a2 number
);
alter table aa3
add constraint aa3_a1 primary key(a1)
create table bb3(
    a1 number,
    b1 number
);
alter table bb3
add constraint bb3_a1_fk foreign key (a1)
    references aa3(a1) on delete set null;
create table cc3(
    a1 number,
    c1 number
);
alter table cc3
add constraint cc3_a1_fk foreign key (a1)
    references aa3(a1) on delete cascade;
create table dd3(
    a1 number,
    d1 number
);
alter table dd3
add constraint dd3_a1_fk foreign key(a1)
    references a1(a1); -- 자식데이터가 먼저 삭제된 후 부모데이터가 삭제

-- 테이블 복사
create table emp
as
select * from employees; -- null을 제외한 제약조건은 복사되지 않는다.

select * from user_constraints where table_name = 'EMP';

select * from emp;
---- delete 
--- 33. 100사원 삭제 하세요.
delete from emp
where employee_id = 100;
select * from emp where employee_id = 100;

--34. 업무가 IT_PROG 인 사원 들을 삭제 하세요.
select * from emp where job_id = 'IT_PROG';
delete from emp where job_id = 'IT_PROG';

-- 35. Neena와 같은 급여를 받는 사원을 삭제 하시오.
select * from emp 
where salary = (select salary from emp where first_name = 'Neena');

delete from emp
where salary = (select salary from emp where first_name = 'Neena');

rollback;
--- DML작업들을 모두 취소하게 된다.
commit 
--- DML작업들을 모두 마무리하게 된다.
-- 자동 commit이 되는 경우 DDL(create, alter, drop)문을 사용한 경우,
-- 작업 창을 닫는 경우
select * from aa2;

create table dept
as 
select * from departments;

select * from dept;

--36. 부서명에 Public이 포함된 부서의 사원들을 모두 삭제 하세요.
select department_id from dept where department_name like '%Public%';

delete from emp
where department_id in (
  select department_id from dept where department_name like '%Public%'
  );
select * from emp
where department_id in (
    select department_id from dept where department_name like '%Public%'
    );
    
truncate table emp;
select * from emp;
rollback;

---37. 데이터 복사
insert into emp
select * from employees;

select * from emp;
commit;

--------------update------
-- 38. emp에서 60번 부서의 사원들을 출력하세요.
select * from emp where department_id = 60; 
      --  60인 부서를 120번 부서로 변경
update emp
set department_id = 120
where department_id = 60;

select * from emp where department_id = 60; 
select * from emp where department_id = 120; 

--- 38. 120인부서를 60부서변경
update emp
set department_id = 60
where department_id = 120;

-- 39.사원번호 113인 사원의 부서를 70부서로 변경
update emp
set department_id = 70
where employee_id = 113;
select * from emp where employee_id = 113;

update emp 
set department_id = 130;

select * from emp;
rollback;

--  40. 205번 사원의 직무 출력
select job_id from emp where employee_id = 205;
--      205번 사원의 급여를 출력
select salary from emp where employee_id = 205;
-- 이때 114번의 직무와 급여를 205번의 직무와 급여로 변경하시오.
update emp
set job_id = 
        (select job_id from emp where employee_id = 205),
    slary = 
        (select salary from emp where employee_id = 205)
where employee_id = 114;

-- 41. 200번 사원의 직무와 140번 사원의 직속상사를 
--     130번 사원에 적용시키세요.
select * from emp where employee_id = 130;-- ST_CLERK, 121

update emp
set job_id =(select job_id from emp where employee_id = 200),
    manager_id = (select manager_id from emp where employee_id = 140)
where employee_id = 130;

rollback;

-- 42. employees테이블에 있는 100번 사원의 급여와 
--     employees테이블에 있는 114번 사원의 직무를
--     emp테이블에 있는 130번 사원에게 적용시키세요.
update emp
set salary = (select salary from employees where employee_id = 100),
    job_id =(select job_id from employees where employee_id = 114)
where employee_id = 130;

--43. 200번 사원이 가진 직무와 같은 사원들의 부서를 사원번호 114인 부서로 변경하시오.
update emp
set department_id = 
        (select department_id from emp where employee_id = 114)
where job_id = (select job_id from emp where employee_id = 200);

-- 44. 114번의 직무와 급여를 205번 사원과 같게 변경하시오.
update emp
set job_id = (select job_id from emp where employee_id = 205), 
    salary = (select salary from emp where employee_id = 205)
where employee_id = 114;


rollback;
-- 45. 부서명에 대소문자 구분 없이 pu가 포함되어 있는 부서의 직원들을 
--    120번 사원의 급여로 변경하시오.
update emp 
set salary = (select salary from emp where employee_id = 120)
where department_id in (
    select department_id from dept 
    where lower(department_name) like '%pu%'  
);
--- insert, select , update, delete
---   C       R        U       D  : DML
insert into (select employee_id, first_name, last_name, hire_date, salary,
                    department_id, email, job_id
             from emp
             where department_id = 50)
values(300, 'SoongMoo', 'Rhee' , sysdate, 15000, 10, 'highland0','AP');

insert into (select employee_id, first_name, last_name, hire_date, salary,
                    department_id, email, job_id
             from emp
             where department_id = 50 with check option) --- 50부서만 insert 
values(300, 'SoongMoo', 'Rhee' , sysdate, 15000, 50, 'highland0','AP');

--DML문 끝----
-- DML -- insert, select , update, delete
-- DDL -- create, alter, drop
-- TCL -- rollback, commit, savepoint
-- DCL -- grant, revoke 
--grant resource, connect, dba to kosa;
-- revoke resource, connect, dba from kosa;
rollback;
commit;
select * from emp;
--------------------------------------------------
delete from emp
where job_id like '%REP';
select * from emp;
savepoint a; ---------------------------------------
delete from emp
where department_id = 90;
select * from emp;
savepoint b; ---------------------------------------
delete from emp;
select * from emp;
rollback to a;
select * from emp;
rollback;
---- TCL 끝 -------
--- view object -----
---  46. 사원번호, 이름 , 이메일, 입사일, 급여 , 커미션,
--       커미션을 포함한 년봉을 출력하는데 null값은 0으로 적용
--      부서 이름이 대소문자 구분없이 'pu'가 있는 부서의 사원
select employee_id, first_name, email, hire_date, commission_pct,
        (salary + salary * nvl(commission_pct,0)) * 12
from emp
where department_id in 
    (select department_id from dept 
      where lower(department_name) like '%pu%');
    
--47. 46번을  view로 만들자.
create view vw_pu
as
select employee_id, first_name, email, hire_date, commission_pct,
        (salary + salary * nvl(commission_pct,0)) * 12 year_sal
from emp
where department_id in 
    (select department_id from dept 
      where lower(department_name) like '%pu%');

select * from emp;

select * from vw_pu;

--- 48. 90번부서의 사원들 정보 중에 이름 전화번호 부서, 사원번호를 출력
select first_name, phone_number, department_id, employee_id
from employees
where department_id = 90;

create view vw_90
as 
select first_name, phone_number, department_id, employee_id
from employees
where department_id = 90;

select * from vw_90;

select * from employees;






