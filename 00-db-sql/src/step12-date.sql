/*
 * Date type, 데이터베이스의 시간 정보
 *  1. to_char() : DB에 저장된 date 형의 정보를 문자열로 변환할때 사용
 *  2. to_date() : 문자열 형태의 시간정보를 DB의 Date type으로 변환할때 사용
 *  3. sysdate 예약어 : 현재 시간을 표현하는 예약어(키워드)
 * 
 * Oracle dual 테이블 : Oracle에서 제공하는 기본 table, 함수와 예약어를 실행할때 사용
*/

--SYSDATE
SELECT SYSDATE FROM DUAL;
--TO_CHAR()
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'yyyy.mm.dd') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'yyyy') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'day') FROM DUAL;

CREATE TABLE date_test(
	id VARCHAR2(100) PRIMARY KEY,
	mydate DATE NOT NULL
)

INSERT INTO date_test(id, mydate) VALUES('java', sysdate);

SELECT id, TO_CHAR(mydate, 'yyyy-mm-dd') FROM date_test;
--TO_DATE()
--문자열에서 db date type
INSERT INTO date_test(id, mydate) VALUES('JSP', TO_DATE('2022.1.4','yyyy-mm-dd'));
INSERT INTO date_test(id, mydate) VALUES('FRONT', TO_DATE('2000.4.7','yyyy-mm-dd'));
--date 연산
SELECT id, mydate, mydate-1 FROM date_test;

--현재를 기준으로 며칠이 경과하였는가
SELECT id, mydate, sysdate-mydate FROM date_test;
SELECT id, mydate, trunc(sysdate-mydate) FROM date_test;

--몇개월 경과하였는가
SELECT id, mydate, trunc(months_between(sysdate, mydate)) FROM date_test;

--몇년 경과
SELECT id, mydate, trunc(months_between(sysdate, mydate)/12) FROM date_test;

SELECT TO_DATE(SYSDATE, 'yyyy-mm--dd') FROM DUAL;