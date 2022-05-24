CREATE TABLE spring_department(
	deptno number primary key,
	dname varchar2(100) not null,
	loc varchar2(100) not null
)

CREATE TABLE spring_employee(
	empno number primary key,
	ename varchar2(100) not null,
	sal number not null,
	deptno number not null,
	constraint fk_spring_deptno foreign key(deptno) references spring_department(deptno) 
	on delete cascade
)

--for real test
insert into spring_department values(10, '전략기획', '판교');
insert into spring_department values(20, '해양수산', '부산');
insert into spring_department values(30, '공공사', '판교');

insert into spring_employee values(1, '아이유', 300, 10);
insert into spring_employee values(2, '강하늘', 500, 10);
insert into spring_employee values(3, '손흥민', 800, 20);
insert into spring_employee values(4, '이강인', 600, 20);

commit

delete from spring_department where deptno=10;

select * from spring_department
select * from spring_employee

--inner join
--empno = 1인 사원의 ename, 부서의 dname, 부서의 loc 조회
select se.ename, sd.dname, sd.loc
from spring_employee se 
inner join spring_department sd
on sd.deptno = se.deptno

--outer join
--조인 조건에 부합하지 않는 정보까지 모두 조회(LEFT/RIGHT OUTER JOIN)
--oracle join : 정보가 존재하지 않는 측에 (+), 
--ansi join : 기준이 되는 측을 from에(*left outer -> left에 부가 테이블을 추가)
select se.empno, se.ename, sd.deptno, sd.dname
from spring_department sd
left outer join spring_employee se 
on sd.deptno = se.deptno

--※self join : 테이블 자체적으로 조인

--집계
--10번 부서 전략기획 사원수 *명
--20번 부서 해양수산 사원수 *명
--30번 부서 공공사업 사원수 *명
select d.deptno, d.dname, nvl(g.emp_count, 0) as emp_count
from(
select deptno, count(*) as emp_count
from spring_employee
group by deptno
) g
right outer join spring_department d
on g.deptno = d.deptno
order by d.deptno desc