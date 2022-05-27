select * from spring_customer

create table spring_customer(
	id varchar2(100) primary key,
	name varchar2(100) not null,
	address varchar2(100) not null
)

insert into spring_customer values('java', '아이유', '오리');

commit

select * from spring_customer

--address list
select distinct address from spring_customer