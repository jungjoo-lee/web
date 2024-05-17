-- 06_DML.sql

-- DML (Data Management Language) 데이터 조작 언어

-- 테이블에 레코드를 조작(추가, 수정, 삭제, 조회)하기 위한 명령어들
-- INSERT(추가)
-- UPDATE(수정)
-- DELETE(삭제)
-- SELECT(조회 및 선택)

-- [1] 샘플 테이블 생성
create table exam01 (
	deptno number(2),
	dname varchar2(15),
	loc varchar2(15)
);

select * from exam01;

-- [2] 레코드 추가

-- 레코드 추가 방법 #1
insert into 테이블이름(필드명1, 필드명2, 필드명3, ...) values (값1, 값2, 값3, ...);

-- 레코드 추가 방법 #2
insert into 테이블이름 values (값1, 값2, 값3, ...);

-- #1과 #2의 차이점
-- #1 : 필드명과 입력되어야 하는 값들이 1:1 매칭되어 입력됩니다
--		필드명의 순서는 반드시 지켜야하는 것은 아니지만 나열된 필드명대로 값들의 순서는 맞춰서 입력합니다.
insert into exam01(deptno, dname, loc) values ('기획부', 10, '서울'); -- X
insert into exam01(deptno, dname, loc) values (10, '기획부', '서울'); -- O
insert into exam01(loc, deptno, dname) values ('서울', 10, '기획부'); -- O

-- null 값을 허용하는 필드나 defualt 값이 있는 필드는 생략하고 구성할 수 있습니다.
insert into exam01(deptno, dname) values (10, '기획부'); -- O

-- #2 모든 필드에 해당하는 값들을 최초에 테이블 생성시에 기술한 필드 순서에 맞게 모두 입력하는 방법입니다.
insert into exam01 values (10, '서울', '기획부'); -- O
-- #2는 null을 허용하는 곳을 비우고 입력할 수 없으며, null 이라도 직접 지정해야합니다.
insert into exam01 values (10, null, '기획부'); -- O

-- #1과 #2 공통으로 숫자는 그냥 쓰고, 문자는 작은 따옴표로 묶어서 표현합니다.

delete from booklist; -- 테이블 내의 모든 레코드를 삭제하는 명령

-- 위 두가지 방법 중 자유롭게 선택하여서, booklist 테이블에 10개의 레코드를 추가해주세요.
-- booknum은 시퀀스를 이용합니다.
-- grade는 'all' '12' '18' 세가지만 골라서 입력해주세요. 자신이 만든 테이블에 grade가 없으면 입력하지 않아도 됩니다.

insert into booklist values(book_seq.nextVal, '일곱해의 마지막', 2020, 12150, 2000, 'all');
insert into booklist values(book_seq.nextVal, '봉제인형 살인사건', 2019, 13150, 2000, '18');
insert into booklist values(book_seq.nextVal, '쇼코의 미소', 2023, 13420, 2000, '12');

insert into booklist(booknum, subject, makeyear, inprice, rentprice, grade) values(book_seq.nextVal, '좀비아이', 2020, 12000, 2500, 'all');


insert into booklist values(book_seq.nextVal, '가면산장 살인사건', 2018, 13320, 1500, '12');
insert into booklist values(book_seq.nextVal, '나미야 잡화점의 기적', 2017, 13320, 2000, '18');
insert into booklist values(book_seq.nextVal, '유튜브영상편집', 2020, 20700, 2500, 'all');
insert into booklist values(book_seq.nextVal, '이것이자바다', 2017, 30000, 3000, '18');
insert into booklist values(book_seq.nextVal, 'JSP웹프로그래밍', 2016, 25000, 2500, '12');
insert into booklist values(book_seq.nextVal, '오라클데이터베이스', 2020, 30000, 3000, 'all');

select * from booklist;

-- memberlist에 10명의 데이터를 추가해주세요.(member_seq 이용)
insert into memberlist(membernum, name, phone) values (member_seq.nextVal, '홍길동', '010-1111-2222');
insert into memberlist(membernum, name, phone) values (member_seq.nextVal, '홍길서', '010-3333-4444');
insert into memberlist(membernum, name, phone) values (member_seq.nextVal, '홍길남', '010-5555-6666');
insert into memberlist(membernum, name, phone) values (member_seq.nextVal, '홍길북', '010-7777-8888');
insert into memberlist values (member_seq.nextVal, '추신수', '010-5656-1234', '84/07/07', 240, 'M', 28);
insert into memberlist values (member_seq.nextVal, '류현진', '010-3333-1234', '83/08/08', 142, 'F', 27);
insert into memberlist values (member_seq.nextVal, '손흥민', '010-4444-1234', '82/09/23', 220, 'M', 23);
insert into memberlist values (member_seq.nextVal, '이청용', '010-6666-1234', '81/06/14', 440, 'F', 36);
insert into memberlist values (member_seq.nextVal, '이영표', '010-2580-1234', '82/03/16', 140, 'M', 31);
insert into memberlist values (member_seq.nextVal, '최지만', '010-7777-1234', '83/04/14', 340, 'F', 29);
select * from memberlist;

-- rentlist 테이블도 rent_seq를 이용해서 10개의 데이터를 추가해주세요
insert into rentlist values (rent_seq.nextVal, '2021/10/01', 26, 1, 100);
insert into rentlist values (rent_seq.nextVal, '2022/10/01', 31, 2, 100);
insert into rentlist values (rent_seq.nextVal, '2023/10/02', 26, 5, 200);
insert into rentlist values (rent_seq.nextVal, '2022/10/02', 28, 2, 100);
insert into rentlist values (rent_seq.nextVal, '2023/10/03', 30, 3, 200);
insert into rentlist values (rent_seq.nextVal, '2023/10/03', 33, 2, 300);
insert into rentlist values (rent_seq.nextVal, '2022/10/04', 27, 1, 100);
insert into rentlist values (rent_seq.nextVal, '2023/10/04', 31, 9, 300);
insert into rentlist values (rent_seq.nextVal, '2022/10/05', 31, 7, 100);
insert into rentlist values (rent_seq.nextVal, '2023/10/05', 32, 8, 200);
select * from RENTLIST;

commit; -- 현재창에서 commit은 세미콜론을 붙이지 않습니다. 단일 명령이고 다른 명령과 함께 사용하지 않는 다는 뜻입니다.

-- 데이터베이스 백업명령
exp userid=scott/1234 file=abc.dmp log=abc.log

-- 데이터베이스 복원명령
imp userid=scott/1234 file=abc.dmp log=abc.log full=y

-- 오라클의 