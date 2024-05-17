-- 11_Function.sql

-- [1] 샘플 테이블인 dual 테이블
select * from tab;
select * from dual;

-- [2] 임시 데이터 출력
select 1234*1234 from dual;

-- *** 문자열 처리 관련 함수 ***
-- lower(), upper(), initcap()
select lower('Hong Gil Dong') as 소문자 from dual;
select upper('Hong Gil Dong') as 대문자 from dual;
select initcap('hong gil dong') as "첫글자만 대문자" from dual;

select lower(ename) as "이름" from emp;
select empno, upper(ename) as "이름", job as "이름" from emp;