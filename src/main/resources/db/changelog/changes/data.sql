create table category (
  id bigserial not null,
  name varchar(50) not null,
  primary key (id)
);
create table joke (
  id bigserial not null,
  category_id bigint not null references category (id),
  content text not null,
  likes bigint default 0,
  dislikes bigint default 0,
  primary key (id)
);
insert into category(name, id) values ('Chuck Norris', 1);
insert into category(name, id) values ('Mujo i Haso', 2);

insert into joke(content,category_id) values ('Koliko sklekova moze napraviti Chuck Norris? Sve.', 1);
insert into joke(content,category_id) values ('Chuck Norris ne pali svjetlo on gasi mrak', 1);
insert into joke(content,category_id) values ('Chuck Norris moze podici stolac na kojem sjedi.', 1);

insert into joke(content,category_id) values ('Sta je Mujo, sjedis i razmisljas? Ne, samo sjedim.', 2);
insert into joke(content,category_id) values ('Dosao Mujo u pizzeriju i narucio pizzu. Konobar ga upita: Zelite da vam izrezem pizzu na 6 ili 12 komada? Ma na 6 komada, nema sanse da pojedem 12.', 2);
insert into joke(content,category_id) values ('Pita Mujo Fatu:Jesi li ti ikada pozelela biti musko? Fata ce: Ne, a ti?', 2);
insert into joke(content,category_id) values ('Fata jucer naucila da pliva, a eno je danas, vec sat vremena roni!', 2);
insert into joke(content,category_id) values ('Poslali Muju i tri svinje space shuttlom u svemir. Baza sa Zemlje daje uputstva: Svinjo br. 1, odbaci dodatne rezervoare! Svinjo br. 2, proveri stanje kiseonika u letelici! Svinjo br. 3, odrzavaj stalan kurs. Mujo, nahrani svinje i nista ne diraj!', 2);
