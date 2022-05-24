/*
	CASCADE : cascade 옵션이 적용된 foreign key는 
	상위(부모) 테이블의 정보 삭제시, 하위 테이블의 해당 레코드도 자동으로 삭제된다.
	
	ex) 부서 테이블(상위 테이블) 삭제시, 이를 참조하는 하위 테이블(사원 테이블)도 같이 삭제된다.

*/

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

--for demo test
create table demo_parent(
	id number primary key,
	name varchar2(100) not null
)

create table demo_child(
	child_no number primary key,
	content clob not null,
	id number not null,
	constraint fk_demo_id foreign key(id) references demo_parent(id)
)

insert into demo_parent(id, name) values(1, '점심메뉴');
insert into demo_child(child_no, content, id) values(1, '잔치국수', 1);
insert into demo_child(child_no, content, id) values(2, '돈가스', 1);

select * from demo_parent;
select * from demo_child;

delete from demo_parent where id=1; --demo_child가 참조하므로 삭제 불가

--for real test
insert into spring_department values(10, '전략기획', '판교');
insert into spring_employee values(1, '아이유', 300, 10);
insert into spring_employee values(2, '강하늘', 500, 10);

commit

delete from spring_department where deptno=10;