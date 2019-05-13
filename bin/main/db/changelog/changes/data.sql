CREATE TABLE category (
  id bigserial NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE joke (
  id bigserial NOT NULL,
  category_id bigint NOT NULL references category (id),
  content text NOT NULL,
  likes bigint DEFAULT 0,
  dislikes bigint DEFAULT 0,
  PRIMARY KEY (id)
);

CREATE TABLE public.customer (
    id bigserial NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

INSERT INTO category(name, id) values ('Chuck Norris', 1);
INSERT INTO category(name, id) values ('Mujo i Haso', 2);

INSERT INTO joke(content,category_id) values ('Koliko sklekova moze napraviti Chuck Norris? Sve.', 1);
INSERT INTO joke(content,category_id) values ('Chuck Norris ne pali svjetlo on gasi mrak', 1);
INSERT INTO joke(content,category_id) values ('Chuck Norris moze podici stolac na kojem sjedi.', 1);

INSERT INTO joke(content,category_id) values ('Sta je Mujo, sjedis i razmisljas? Ne, samo sjedim.', 2);
INSERT INTO joke(content,category_id) values ('Dosao Mujo u pizzeriju i narucio pizzu. Konobar ga upita: Zelite da vam izrezem pizzu na 6 ili 12 komada? Ma na 6 komada, nema sanse da pojedem 12.', 2);
INSERT INTO joke(content,category_id) values ('Pita Mujo Fatu:Jesi li ti ikada pozelela biti musko? Fata ce: Ne, a ti?', 2);
INSERT INTO joke(content,category_id) values ('Fata jucer naucila da pliva, a eno je danas, vec sat vremena roni!', 2);
INSERT INTO joke(content,category_id) values ('Poslali Muju i tri svinje space shuttlom u svemir. Baza sa Zemlje daje uputstva: Svinjo br. 1, odbaci dodatne rezervoare! Svinjo br. 2, proveri stanje kiseonika u letelici! Svinjo br. 3, odrzavaj stalan kurs. Mujo, nahrani svinje i nista ne diraj!', 2);
