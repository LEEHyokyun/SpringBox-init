CREATE table director(
	director_id number primary key,
	director_name varchar2(100) not null,
	intro varchar2(100) not null
)

CREATE sequence director_seq;

CREATE table movie(
	movie_id number primary key,
	title varchar2(100) not null,
	genre varchar2(100) not null,
	attendance number default 0,
	director_id number not null,
	constraint fk_spring_director foreign key(director_id) references director(director_id)
)

CREATE sequence movie_seq	;

select * from director
select * from movie

--movie title, director name
select m.title, d.director_name
from movie m
inner join director d
on d.director_id = m.director_id

--all information
select m.movie_id, m.title, m.genre, m.attendance, d.director_id, d.director_name, d.intro
from movie m
inner join director d
on d.director_id = m.director_id
and m.movie_id = 2