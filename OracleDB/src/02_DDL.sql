create table booklist (
	booknum varchar2(5),
	subject varchar2(30),
	makeyear number(4),
	inprice number(6),
	outprice number(6),
	constraint booklist_pk primary key (booknum)
);

select * from booklist;

create table MemberList(
    memberNum varchar2(5) not null,
    memberName varchar2(12) not null,
    phone varchar2(13) not null,
    birth date,
    bpoint number(6),
    constraint memberlist_pk primary key (memberNum)
);

-- 외래키(FOREIGN KEY) : 테이블 간의 필수 포함 관계에 있어
-- 	상대 테이블의 특정 필드값을 참조하면서 없는 값을 사용할 수 없도록 하는 규칙.
--	외래키로 유지되는 무결성을 :참조무결성:이라고 부릅니다
-- 예를 들면 booklist에 존재하지 않은 도서의 번호가 rentlist의 빌려간 도서의 번호로 등록되지 못하게 하느것을 말합니다

-- 테이블 생성 3
-- 테이블 이름 : rentlist
-- 필드 : idx(NUMBER(3)), rent_date(date), bnum(VARCHAR2(5)),
--		mnum(VARCHAR2(5)), discount(NUMBER(4))
-- 제약조건 : bnum, mnum : not null

create table rentlist (
	idx NUMBER(3), -- 대여기록번호
	rent_date date default SYSDATE, -- 대여날짜
	-- rent_seq number(3), -- 하나의 날짜안에서 지정된 순번
	bnum VARCHAR2(5) not null, -- 대여해간 도서번호
	mnum VARCHAR2(5) not null, -- 대여한 회원의 회원번호
	discount NUMBER(4) default 500, -- 할인금액
	-- constraint rent_pk primary key(rent_date, rent_seq)
	constraint rent_pk primary key(idx),
	constraint fk1 foreign key(bnum) references booklist(booknum),
	constraint fk2 foreign key(mnum) references MemberList(memberNum)
);

-- 제약조건(CONSTRAINT)
-- PRIMARY KEY
--	- 테이블에 저장된 레코드를 고유하게 식별하기 위한 키, 하나의 테이블에 하나의 기본키만 정의 할 수
--	  있습니다.
--	- 여러 필드가 조합된 기본키 생성 가능합니다
--	- 기본키는 중복된 값을 갖을 수 없으며 빈칸도 있을 수 없습니다
--	- PRIMARY KEY = UNIQUE KEY + NOT NULL
-- UNIQUE KEY
--	- 테이블에 저장된 행 데이터를 고유하게 식별하기 위한 고유키를 정의 합니다
--	- 단 NULL 은 고유키 제약의 대상의 아니므로, NULL 값을 가진 행이 여러개가 UNIQUE KEY
--	  제약에 위반하지는 않습니다
-- NOT NULL
--	- 비어있는 상태, 아무것도 없는 상태를 허용하지 않습니다. - 입력 필수
-- CHECK
--	- 입력할 수 있는 값의 범위를 제한한다. CHECK 제약으로는 TRUE or FALSE로 평가할 수 있는
--	  논리식을 지정합니다.
-- FOREIGN KEY
--	- 관계형 데이터 베이스에서 테이블간에 관계를 정의하기 위해 기본키를 다른 테이블의 외래키로
--	  복사하는 경우 외래키가 생성됩니다. - 참조 무결성 제약 옵션이 생성