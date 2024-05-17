-- 03_DataType.sql

-- 1. 정수형 타입
--	NUMBER(숫자자리수) : 자리수는 바이트가 아니고 표시되는 숫자의 자리수
--	NUMBER(2) -99 ~ 99

-- 2. 실수형 타입
--	NUMBER(6, 2) : 소수점을 포함한 전체자리수가 6자리, 소수점이 한자리를 차지하고, 소수점 아래가 2자리를 차지

-- 3. 가변형 문자(최대 4000 Byte)
--	varchar2(XX)
--	지정한 숫자를 저장할 수 있는 최대 글자수를 지정하고 할당되는 용량은 실제 글자수만큼 할당되어 저장됩니다.
--	varchar2(10)에 "abcd"를 저장하면 4글자만큼의 용량만 소비됩니다.

-- 4. 고정형 문자(최대 2000 Byte)
--	char(xx)
--	char(10)에 "abcd"를 저장하면 "abcf      " 가 저장

-- 5. 고정형 유니코드 문자
--	nchar(xx): 다국어를 입력하기 위한 고정형 자료형 최대 2000 Byte

-- 6. 가변형 유니코드 문자
--	nvarchar(xx) : 다국어를 입력하기 위한 가변형 자료형 최대 4000 Byte

-- 7. 날짜 데이터
--	DATE : java.sql.Date 자료형과 같은 형식	=> 년월일시분초 표현가능
--	TIMESTAMP : java.sql.Timestamp 자료형과 같은 형식 => 년월일시분초 + 밀리초까지 표현 가능
--	- 가장 일반적이고 많이 사용하는 날짜 데이터 타입은 DATE
--	SYSDATE : DATE 형식의 오늘 날짜 현재시간을 발행하는 키워드
--	SYSTIMESTAMP 형식의 오늘 날짜 현재시간(밀리초포함)을 발생하는 키워드

-- 8. LOB 타입
--	Large OBject의 약자로 대용량 데이터를 저장할 수 있는 타입
--	CLOB, NCLOB, BLOB 등등이 있지만, 요새는 대용량 파일은 별도의 서버에 저장하고 경로와 이름을 데이터베이스로
--	관리하는 형식을 많이 사용

-- 9. 지금 잘 사용되지 않는 자료형
--	-varchar : varchar2와 같은 형식이지만 용량에서 varchar2가 업그레이드 되었으며,
--			   이 때문에 잘 사용하지 않습니다
--	- LONG 형 : 최대 2GB 의 가변 길이 문자형. 잘 사용하지 않음
--	- FLOAT : number의 하위타입, 2진수 기준 22바이트
--	- BINARY_FLOAT : 32비트 부동 소수점
--	- BINARY_DOUBLE : 64비트 부동 소수점 수