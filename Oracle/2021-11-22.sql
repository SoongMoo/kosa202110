select * from employees;
---대문자를 소문자로 , 소문자를 대문자로
select email, lower(email),initcap(email), first_name, upper(first_name), 
        lower(first_name), length(first_name), lengthb(first_name),
        length('이숭무'), lengthb('이숭무'), '이숭무'
from employees;

--- 1. 이름이 'steven'인 사람을  출력하시오.
select * from employees where lower(first_name) = 'steven';

-- 2. 성이 KING인 직원을 출력하세요.
select * from employees where upper(last_name) = 'KING';
select * from employees where last_name = INITCAP('KING');

-- 3. 이름의 글자의 갯수가 5인 사원들을 출력하세요.
select * from employees where length(first_name) = 5;

-- 4.  급여가 5자리 이상인 사원을 구하시오.
select * from employees where salary >= 10000; 
select * from employees where length(salary) >= 5;  

-- indexOf() :문자열에서 원하는 문자가 있는 위치 번호 str.indexOf('a')
--            원하는 문자가 없는 경우 : -1
-- instr() : 데이터베이스의 index는 1번부터 시작한다.
--           원하는 문자가 없는 경우 :0
-- 5. 이름에 's'를 가지 사원들 중 이름에 몇번째에 있는지 출력하세요.
select first_name, instr(first_name,'s')
from employees;

-- 6.  이름에 's'가 3번째에 있는 사원들을 출력하세요.
select * from employees where instr(first_name,'s') = 3;

--java :
--String str = "I love the java";
--//            01234567
--System.out.print(str.subString(7))
-- substr
-- 7. 이름과 성과 급여와 직무를 출력할 때 이메일은 3번째 글자 부터 출력하시오.
select first_name, last_name, salary, job_id,email, substr(email,3)
from employees;

-- 8. 이메일에 'S'부터 출력하고, 급여, 입사일, 이름 ,성을 출력하세요.
select email,substr(email, instr(email, 'S')) ,instr(email, 'S'),  salary, hire_date, 
    first_name, last_name
from employees;

-- 
--String str = "I love the java";
--              0123456789
-- System.out.println(str.subString(7, 7 + 3)
--9. 이름 , 급여, 직무, 부서를 출력할 때 이메일은 3번째 부터 4글짜를 출력하시오.
select  first_name, salary, job_id, department_id, 
        email, substr(email, 3, 4)
from employees;

--10. 이메일에 3번째부터 4글자에 'ARTS'가 있는 상원을 출력하세요.
select * from employees where substr(email, 3,4 ) = 'ARTS';

--11.이메일에 's'가 5번째에 있는 사원을 출력하시오.
select * from employees 
where instr(lower(email), 's') = 5;

--- lower, upper, length, lengthb, initcap, substr, instr

--print("나의 나이는 %10d이다" % 30);
--나의 나이는          30이다
select salary , rpad(salary, 10, '*'), lpad(salary, 10, '*')
from employees;

-- 아이디 찾기 highland0 : high*****
-- 12. 이메일에서 앞에서 2글자를 출력하고 나머지는 오른쪽에 *로 채워서 출력하세요.
select rpad('as', 10, '*') from dual;
select email, rpad(substr(email,1,2),length(email), '*' )
from employees;

-- 13. 입사일이 03/06/17 전화번호가 515.123.4567인 사원의 이메일을 
--     앞에서 3글자만 출력하고 나머지는 *로 출력하세요
select rpad(substr(email,1,3), length(email), '*')
from employees
where hire_date = '03/06/17' and phone_number = '515.123.4567';

-- str.replace("I", "You")
-- 14. 직무가 _AS가 있다면 abc로 변경하시오,
select replace(job_id, '_AS', 'abc') , job_id
from employees
where job_id like '%_AS%';

-- str.trim()
select ' 이 숭무 ' , trim(' 이 숭무 '), rtrim(' 이 숭무 '), ltrim(' 이 숭무 ')
from dual;
-- 15.이메일에 'A'가 처음과 끝에 있다면 이메일에서 삭제하여 출력하자.
select email, trim('A' from email), trim(email)
from employees;

--- str = 'abcdefg'
--         0123456
--         7654321 -    
-- print(str[4:7])
-- print(str[-3:])

-- 16. 이메일에서 뒤에서 한글자가지고 오고 또 이메일에서 뒤에서 부터 2글자 가지고 오며,
--     이메일에서 뒤에서 3번째부터 2글자만 출력하세요.
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

--- 18. 이름, 입사일, 부서번호, 급여, 년봉을 출력하세요.
select first_name, hire_date, department_id, salary, salary * 12
from employees;

-- 19. 이름, 입사일, 부서번호, 급여 그리고 년봉을 출력할 때 
-- 년봉에는 커미션이 포함되어야 한다.
SELECT first_name, hire_date, department_id, salary ,commission_pct,
       (salary + salary * commission_pct ) * 12
from employees;

select commission_pct, nvl(commission_pct, 0)
from employees;

-- 20. 커미션이 null이라면 커미션 값을 0으로 대입하여 이름, 부서, 입사일, 직무,
--     급여, 커미션, 그리고 년봉을 출력하세요.
select first_name, department_id, hire_date, job_id, salary
      , commission_pct, nvl(commission_pct,0)
      , (salary + salary * nvl(commission_pct,0)) *12
from employees;

select nvl(commission_pct, 100)
from employees;

--- 숫자함수 
--- round() : 반올림 
--- trunc() : 절삭       
--- mod() : 나머지

-- 21 . 반올림하세요.
--- 5부터 반올림된다.
select ROUND(15.19345,3),  ROUND(15.19355,3) , round(145.5554,2),
       round(145.5554,1), round(145.5554,0),  round(145.4554,0), 
       round(145.5554,-1), round(145.5554,-2)
from dual; 

-- 22. 절삭하세요.
select trunc(15.19345,3),  trunc(15.19355,3) , trunc(145.5554,2),
       trunc(145.5554,1), trunc(145.5554,0),  trunc(145.4554,0), 
       trunc(145.5554,-1), trunc(145.5554,-2)
from dual; 

-- 23. 입사일로부터 오늘날짜까지 몇일이 지났는지 일로 출력하세뇨.
--  입사일, 이름, 성, 직무도 같이 출력
select sysdate from dual;
select  hire_date, first_name, last_name, job_id, 
        trunc(sysdate - hire_date,0)
from employees;

-- 24. 입사일, 이름, 성, 직무을 출력할 때 입사일로 부터 몇 주가 지났는지 출력하시오.
select  hire_date, first_name, last_name, job_id, 
        round((sysdate - hire_date) / 7) week
from employees;

-- 25. 입사일, 이름, 성, 직무을 출력할 때 입사일로 부터 몇 년차인지 출력하시오.
select  employee_id, hire_date, first_name, last_name, job_id, 
        round((sysdate - hire_date) / 365) week
from employees;

-- 26.년차가 17년 이상인 사원을 출력하시오.
select * from employees where (sysdate - hire_date) / 365 >= 17;

-- 10 / 3 : 10 % 3 : mod(10, 3)
select mod(10 , 3) from dual;

-- 27. 이름, 성, 입사일 , 급여를 출력할 때 급여를 400으로 나눈 나머지를 출력하세요.
select first_name, last_name, hire_date, salary, mod(salary , 400) 
from employees;

-- 28. 급여를 500으로 나눈 나머지가 400 이상인 사원들을 출력하시오
select employee_id, first_name, hire_date, job_id, salary, mod(salary , 500)
from hr.employees
where mod(salary , 500) >= 400;

-- 10을 3으로 나눈 몫은  int i = 10; int j = 3; result = i / j
---                  double d = 10; double d1 = 3 ; int result = (int)(d / d1)
select trunc(11 / 3)
from dual;

--- 날짜 함수 
--29. 오늘 날짜부터 다음 금요일은 몇일입니까?
select next_day(sysdate, '금'), next_day(sysdate, '금요일')
from dual;

-- 30. 이름 , 성, 직무, 입사일을 출력할 때 입사일로부터 다음 목요일이 언제였는지 출력하세요.
select first_name, last_name job_id , hire_date, next_day(hire_date, '목')
from employees;

-- 오늘부터 5개월후는 몇일입니까?
select add_months(sysdate, 5)
from dual;

--31. Neena가 입사하고 3개월 후가 정직원이 되는 날이다.
--    정직원이 되는 날이 언제인지, 이름 , 성 , 입사일, 직무, 사원번호와 같이 출력하시오.
select first_name, last_name, hire_date, job_id, employee_id,
       add_months(hire_date, 3)
from employees
where first_name = 'Neena';

-- 32. 입사한 이후 다음 목요일이 '01/01/18'인사원을 구하시오.
select * from hr.employees
where next_day(hire_date, '목') = '01/01/18';

-- 마지막 날을 출력
select last_day(sysdate) from dual;

-- 33. 윤달에 입사한 사원을 출력하시오.
select hire_date, last_day(hire_date)
from employees;
select * from employees where last_day(hire_date) like '%/02/29';

-- 34. 입사일로 부터 현재까지 몇달이 지났나요, 이름, 성, 직무, 입사일도 같이 출력
select first_name, last_name, job_id, hire_date, 
       trunc(months_between(sysdate,hire_date))
from employees;

select * from job_history;
-- 35 각 상원이 직무를 담당한 달은 몇달인지 출력하시오.
select employee_id, job_id,start_date, end_date
        , round(months_between(end_date, start_date))
from job_history;

-- 36. 입사한지 200개월이 지난 사원들을 출력하시오.
select * from employees
where months_between(sysdate, hire_date) >= 200;

--- 숫자함수 , 문자함수, 날짜함수, 
-- 변환함수 
-- 날짜 변환 2021-05-14 11:10:35  (date)
-- 20    21    05   14   11    10    35
--세기    년    월   일    시    분    초
-- 21/05/14 : 2021/05/14 : 49년도까지가 현재 세기를 가져옴
-- 50/05/14 : 1950/05/14 : 50년 부터 99년까지는 이전 세기를 가져옴
-- 2050/05/14 

--'21-01-15' :년월일
select (sysdate - to_date('21-01-15','yy-mm-dd'))
from dual;

--'01-15-2021' :월일년
select (sysdate - to_date('01/15/2021', 'mm/dd/yyyy'))
from dual;

---37. 03/06/17이후에 입사한 사람은?
select * from employees where hire_date > '03/06/17';
select * from employees where hire_date > to_date('03/06/17','yy-mm-dd');

---38. 17/06/03(일월년)이후에 입사한 사람은?
select * from employees where hire_date > to_date('17/06/03','dd-mm-yy');
-- 06/17/03(월일년)이후에 입사한 사람은?
select * from employees where hire_date > to_date('06/17/03', 'mm-dd-yy');

-- 39. 문자 변환함수 : 날짜를 문자 변환
--               날짜         문자
---            RR-MM-DD =>  'yyyy-mm-dd'
---            RR-MM-DD =>  'dd-mm-yy'
---            RR-MM-DD =>  'mm-dd-yy'
select to_char(sysdate, 'yy-mm-dd'), sysdate, to_char(sysdate,'dd-mm-yy'),
       to_CHAR(sysdate, 'yyyy-mm-dd'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS.SSSSS AM'),
       TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS.SSSSS AM'),
       TO_CHAR(SYSDATE, 'YYYY-MONDD HH24:MI:SS.SSSSS AM')
from dual;

-- 날짜를 문자열로 변경하여 날짜 비교   -- 사전 순서 
-- 40. 25-04-2003 보다 늦게 입사한 사람을 출력 
--                                    RR-MM-DD
--- 잘못된 비교 방법
SELECT * FROM EMPLOYEES WHERE TO_CHAR(HIRE_DATE, 'DD-MM-YYYY') > '25-04-2003';

-- 문자열을 날짜로 변경하여 날짜 비교
SELECT * FROM EMPLOYEES WHERE HIRE_DATE > TO_DATE('25-04-2003', 'DD-MM-YYYY');

--숫자를 문자열로
--- 1,234,567 => W1,234,567, $1,234,567, $1,234,567-
SELECT TO_CHAR(1234567.890, '9,999,999'),
        TO_CHAR(1234567.890, '9,999,999.00'),
        TO_CHAR(1234567.890, '$9,999,999.00'),
        TO_CHAR(1234567.890, 'L9,999,999.00'),
        TO_CHAR(-1234567.890, 'L9,999,999.00MI')
FROM DUAL;

-- 41. 이름, 성, 직무 부서 그리고 급여를 세자리씩 ,를 찍고 $가 출력되게 하시오.
SELECT  first_name, last_name, job_id, department_id,
        to_char(salary, '$99,999,999mi'),
        to_char(-salary, '$99,999,999mi') --회계 파트
FROM EMPLOYEES;

-- 42. janette또는 JANETTE 또는 jaNette 값을 전달 받았다.
---   이름이 'Janette'인 사원을 출력하시오.
SELECT * FROM EMPLOYEES
WHERE first_name = INITCAT('janette') 
      OR first_name = INITCAT('JANETTE') 
      OR first_name = INITCAT('jaNette');

SELECT * FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) = LOWER('janette') ;
      
SELECT * FROM EMPLOYEES
WHERE LOWER(FIRST_NAME) = 'janette' OR UPPER(FIRST_NAME) = 'JANETTE'
    OR LOWER(FIRST_NAME) = LOWER('jaNette');

--- 표현식 :  SWITCH(변수) ~ CASE 조건 :  연산식; break; default :연산식
---          CASE 변수 WHEN 조건 THEN 연산식 else 연산식 end

-- 43. --- job_id이 'IT_PROG' 급여를 10%상승
--                  'ST_CLERK' 급여를 15%상승
--                  'SA_REP' 급여를 20%상승
--                   그이외는 급여
-- 성, 이름, 급여도 같이 출력
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

--- 44. 성, 이름, 직무, 급여, 급여에 따른 직책도 같이 출력하세요.
--- 급여가 3000이하이면 사원 
--        5000이하이면 주임
--        7000이하이면 대리
--        9000이하이면 과장
--       11000이하이면 차장
--       13000이하이면 부장
--       그 이상 이면 임원
select last_name, first_name, job_id, salary , 
        case  when salary <= 3000 then '사원'
              when salary <= 5000 then '주임'
              when salary <= 7000 then '대리'
              when salary <= 9000 then '과장'
              when salary <= 11000 then '차장'
              when salary <= 13000 then '부장'
              else '임원' end grade
from employees;

-- 45. 급여에 따른 세금을 출력하고 싶다. 이름 , 성, 급여, 직무, 세금을 출력하시오.
---  급여를 2000으로 나눈 몫이 0이면 급여의 0%
---                         1이면 급여의 9%
---                         2이면 급여의 20%
---                         3이면 급여의 30%
---                         4이면 급여의 40%
---                         5이면 급여의 42%
---                         6이면 급여의 44%
---                         이외 급여의 45% 세금이다.
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