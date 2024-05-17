-- 12_GroupFunction.sql

-- 테이블내의 하나의 필드값들 전체로 하는 함수
-- 합계(SUM)
select sum(inprice) from booklist;
select sum(rentprice) from booklist where inprice >= 18000;

-- 갯수(COUNT)
select count(*) from memberlist;
select count(*) from memberlist where bpoint >= 100;

select a.bnum, b.subject, count(*) from rentlist a inner join booklist b on a.bnum = b.booknum group by a.bnum, b.subject;