use test;
drop database library;
create database library;
use library;

create table persons
(
    id              int,
    first_last_name varchar(30),
    phone_number    varchar(20),
    address         varchar(80),
    primary key (id)
);

create table books
(
    id               int         not null,
    title            varchar(30) not null,
    number_of_pages  int         not null,
    number_of_copies int         not null,
    genre            varchar(30) not null,
    primary key (id)
);

create table borrows
(
    book_id                       int  not null,
    person_id                     int  not null,
    borrow_date                   date not null,
    return_date                   date,
    borrow_maximum_number_of_days int  not null,
    primary key (book_id, person_id),
    foreign key (book_id) references books (id),
    foreign key (person_id) references persons (id)
);

create table authors
(
    book_id   int not null,
    person_id int not null,
    primary key (book_id, person_id),
    foreign key (book_id) references books (id),
    foreign key (person_id) references persons (id)
);

alter table persons
    add date_of_birth date not null;

alter table books
    add constraint genre_type check ( genre in ('Autobiografic', 'Copii', 'Fantastic', 'Tehnic', 'Mitologie') );

alter table books
    add constraint number_of_page_check check (
            (genre = 'Mitologie' and (number_of_pages >= 100 and number_of_pages <= 500)) or
            (genre != 'Mitologie' and number_of_pages >= 5));
