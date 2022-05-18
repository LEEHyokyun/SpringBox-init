/*
 * Join : 하나 이상의 테이블 정보를 결합하기 위한 기능
 *  - INNER JOIN : 일반적으로 table간 결합하는 경우, 지정한 column의 data가 존재할때 join된다.
 * 		→ 부서번호가 일치할때 서로 참조
 *  - OUTER JOIN : 여러 테이블 중 한쪽에서는 data가 있고, 다른 한 쪽은 없을떄 있는 쪽의 테이블 내용을 모두 출력한다.
 * 		→ 기준 테이블을 왼쪽에 위치시키는 LEFT OUTER JOIN, 오른쪽에 위치시키는 RIGHT OUTER JOIN이 존재한다.
 * 		→ 부서번호는 있는데, 해당 사원정보가 없을 경우 해당 사원번호에 대한 부서정보를 조회할떄 
 * - SELF JOIN : 동일한 테이블 상에서의 조인
 * 		→ 사원테이블에서의 매니저 컬럼 정보는 또 다른 사원의 사원번호로, 사원정보와 그 사원의 관리자인 매니저 정보를 함께 조회할때
 * 		→ INNER join의 일종이다.
 */

-- 1. Inner join : 서로 연관성 있는 table을 서로 결합 및 상응할때

SELECT * FROM emp;
--사원은 10,20,30의 부서번호만 존재한다.
SELECT * FROM dept;
--사원정보와 그 사원이 속한 부서 정보를 조회할떄
--deptno = 40의 경우 data가 없으므로 조회불가
SELECT e.empno, e.ename, e.job, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno=d.deptno

-- ANSI(American National Standard Institute, 미국표준협회) - 데이터베이스 표준 SQL
--어떤 DB에서도 적용이 가능한 SQL
SELECT e.empno, e.ename, e.job, d.deptno, d.dname
FROM emp e
INNER JOIN dept d ON e.deptno = d.deptno;

-- emp, salary, emp table에서 salary grade를 참조하여 월급등급 기재하기
SELECT * FROM salgrade;
SELECT * FROM emp WHERE ename = 'SMITH';

-- smith 사원의 정보와 월급등급 조회(WHERE, INNER JOIN ANSI)
SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM emp e, salgrade s 
WHERE e.sal >= s.losal
AND e.sal <= s.hisal
AND e.ename = 'SMITH';

SELECT e.empno, e.ename, e.job, e.sal, s.grade, s.losal, s.hisal
FROM emp e
INNER JOIN salgrade s
ON e.sal >= s.losal AND e.sal <= s.hisal
WHERE e.ename = 'SMITH';

--empno = 7521
SELECT e.empno, e.ename, d.deptno, d.dname, s.grade 
FROM emp e, dept d, salgrade s 
WHERE e.deptno = d.deptno
AND e.sal >= s.losal
AND e.sal <= s.hisal
AND e.empno = 7521

SELECT e.empno, e.ename, d.deptno, d.dname, s.grade 
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
INNER JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
WHERE e.empno = 7521;

-- 2. Outer Join : data가 있는 테이블과 없는 테이블간의 결합
SELECT DISTINCT deptno FROM dept;
SELECT DISTINCT deptno FROM emp;

--기존 inner join시 deptno = 40 조회불가
SELECT d.deptno, d.dname, e.ename 
FROM dept d, emp e
WHERE d.deptno = e.deptno

--outer join시 deptno = 40 조회가능 : 결합정보가 없는 측에 + 기호 사용
SELECT d.deptno, d.dname, e.ename 
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);

--ANSI
SELECT d.deptno, e.deptno
FROM dept d
LEFT OUTER JOIN emp e ON d.deptno = e.deptno;

-- 3. Self Join : 동일한 table이지만, 개념적으로 다른 정보들을 결합한다.
SELECT * FROM emp;
SELECT empno, ename, mgr FROM emp WHERE empno = 7902;
SELECT empno, ename, mgr FROM emp WHERE empno = 7566;

--이때 empno에 해당하는 정보와 해당 mgr에 해당하는 매니저 정보까지 동시에 결합하여 조회할 경우
SELECT e.ename, e.mgr, m.empno, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno
AND e.empno = 7902;

-- 전 사원을 대상으로 empno, ename, mgr, mgr의 name
-- inner join의 일종이므로, mgr이 없는 사원에 대해서는 정보가 출력되지 않는다.
SELECT e.empno, e.ename, e.mgr, m.ename as 매니저명 
FROM emp e, emp m
WHERE e.mgr = m.empno 

--outer join을 통한 정보 조회
--사원의 매니저 정보가 존재하지 않는다 = 매니저 측 정보에 (+)기호 추가.
SELECT e.empno, e.ename, e.mgr, m.ename as 매니저명 
FROM emp e, emp m
WHERE e.mgr = m.empno(+) 	

--ASNI
SELECT e.empno, e.ename, e.mgr, m.ename as 매니저명 
FROM emp e
LEFT OUTER JOIN emp m
ON e.mgr = m.empno;

--empno = 7369인 사원의 ename, dname, grade, mgr에 해당하는 ename 조회
SELECT e.ename, d.dname, s.grade, m.ename as 매니저명
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
INNER JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
LEFT OUTER JOIN emp m
ON e.mgr = m.empno
WHERE e.empno = 7369;

SELECT e.ename, d.dname, s.grade, m.ename as 매니저명
FROM emp e, dept d, salgrade s, emp m
WHERE e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND e.mgr = m.empno
AND e.empno = 7369;

-- 매니저가 없는 사원까지 모두 정보 조회할 수 있도록 OUTER JOIN처리 할 경우
SELECT e.ename, d.dname, s.grade, m.ename as 매니저명
FROM emp e, dept d, salgrade s, emp m
WHERE e.deptno = d.deptno
AND e.sal BETWEEN s.losal AND s.hisal
AND e.mgr = m.empno(+)

SELECT e.ename, d.dname, s.grade, m.ename as 매니저명
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
INNER JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
LEFT OUTER JOIN emp m
ON e.mgr = m.empno;

--월급등급(salgrade의 grade)을 기준으로 사원테이블의 등급에 따라 사원수를 조회할때 
--key point : INNER JOIN까지 결합한 table까지 FROM table 조건으로 인식
SELECT s.grade, COUNT(*)
FROM emp e
INNER JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
GROUP BY s.grade
ORDER BY s.grade DESC

SELECT s.grade, COUNT(*)
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
GROUP BY s.grade

--view(s.grade를 table화하여 이용한다)
-- FROM subqeury를 이용하여, 결과자체를 하나의 table로 활용한다 → from 내부의 subquery가 먼저 실행된다.
-- group by는 별도로 이용
SELECT grade, count(*)
FROM(
SELECT s.grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal
) GROUP BY grade 

-- 월급 순위 기준으로 하여 조회 : RANK OVER(ORDER BY COLUMN)
SELECT ename, job, sal, rank() over(ORDER BY sal) as ranking FROM emp;

-- 월급 상위 5위까지 조회
SELECT ename, job, sal, rank() over(ORDER BY sal) as sal_ranking FROM emp WHERE sal_ranking<6;
--불가 : where가 먼저 실행되며, 순위는 select 시점에서 계산되어 계산 시점이 부적합하다.
SELECT ename, job, sal, sal_ranking
FROM (
	SELECT ename, job, sal, rank() over(ORDER BY sal) as sal_ranking FROM emp
)
WHERE sal_ranking < 6
--가능 : where이 먼저 실행된다는 점을 이용, where 시점에서 ranking까지 부여된 table을 view화하여 활용(from에 subquery로 이용)
--이후 해당 ranking을 6위까지 출력하도록 WHERE 조건절로 기술.













