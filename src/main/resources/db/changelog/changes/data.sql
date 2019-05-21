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

INSERT INTO category(name, id) values ('Chuck Norris', 1);
INSERT INTO category(name, id) values ('Mujo i Haso', 2);

INSERT INTO joke(content,category_id) values ('Koliko sklekova moze napraviti Chuck Norris? Sve.', 1);
INSERT INTO joke(content,category_id) values ('Chuck Norris ne pali svjetlo on gasi mrak', 1);
INSERT INTO joke(content,category_id) values ('Chuck Norris može podići stolac na kojem sjedi.', 1);
INSERT INTO joke(content,category_id) values ('Chuck Norris je zabio dva gola jednim udarcem.', 1);
INSERT INTO joke(content,category_id) values ('Chuck Norris može dijeliti s nulom.', 1);

INSERT INTO joke(content,category_id) values ('Šta je Mujo, sjediš i razmisljaš? Ne, samo sjedim.', 2);
INSERT INTO joke(content,category_id) values ('Došao Mujo u pizzeriju i narucio pizzu. Konobar ga upita: Želite da vam izrezem pizzu na 6 ili 12 komada? Ma na 6 komada, nema šanse da pojedem 12.', 2);
INSERT INTO joke(content,category_id) values ('Pita Mujo Fatu:Jesi li ti ikada poželela biti muško? Fata će: Ne, a ti?', 2);
INSERT INTO joke(content,category_id) values ('Fata jučer naučila da pliva, a danas već 3 sata vremena roni!', 2);
INSERT INTO joke(content,category_id) values ('Poslali Muju i tri svinje space shuttlom u svemir. Baza sa Zemlje daje uputstva: Svinjo br. 1, odbaci dodatne rezervoare! Svinjo br. 2, provjeri stanje kisika u letjlici! Svinjo br. 3, održavaj stalan kurs. Mujo, nahrani svinje i nista ne diraj!', 2);
