use library;

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (1, 'Starscourge Radahn', '+4076826335', 'Caelid', '1958-11-30');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (2, 'Malenia Blade of Miquella', '+65789753148', 'Haligtree', '1998-07-11');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (3, 'Godfrey First Elden Lord', '+69456789123', 'Leyndell Ashen Capital', '1996-04-20');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (4, 'Margit The Fell Omen', '+96753159741', 'Stormveil Castle', '2000-11-12');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (5, 'Rycard', '+56789456123', 'Mountain Gelmir', '1974-08-28');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (6, 'George Raymond Richard Martin', '+20789145235', 'New Jersey', '1948-10-20');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (7, 'Stephen King', '+20123456987', 'Portland', '1947-10-21');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (8, 'Margaret Wise Brown', '+58471582693', 'Brooklyn', '1910-05-23');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (9, 'Nelson Mandela', '+10741852369', 'Rolihlahla Mandela', '1918-07-18');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (10, 'Stuart Jonathan Russell', '+67537591777', 'Portsmouth', '1962-07-11');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (11, 'Peter Norvig', '+85159753456', 'California', '1956-12-14');

insert into persons(id, first_last_name, phone_number, address, date_of_birth)
values (12, 'James Clavell', '+87963147546', 'Sydney', '1921-10-07');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (1, 'A Song of Ice and Fire', 455, 65, 'Mitologie');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (2, 'Fire & Blood', 355, 1596, 'Mitologie');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (3, 'The Green Mile', 512, 77, 'Fantastic');

insert into books (id, title, number_of_pages, number_of_copies, genre)
values (4, 'Bag of Bones', 874, 588, 'Fantastic');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (5, 'Good Night Moon', 100, 5, 'Copii');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (6, 'The Noisy Book', 25, 5, 'Copii');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (7, 'Long Walk to Freedom', 468, 5655, 'Autobiografic');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (8, 'Conversation with Myself', 844, 15000, 'Autobiografic');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (9, 'Artificial Intelligence: A Modern Approach', 1256, 15000, 'Tehnic');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (10, 'Human Compatible', 259, 15, 'Tehnic');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (11, 'Do the Right Thing', 266, 99, 'Tehnic');

insert into books(id, title, number_of_pages, number_of_copies, genre)
values (12, 'Shogun', 888, 777, 'Fantastic');

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (1, 1, '2023-01-04', null, 15);

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (1, 2, '2022-12-05', '2022-12-15', 15);

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (1, 3, '2022-12-05', '2023-01-14', 15);

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (2, 4, '2022-11-05', '2023-01-13', 17);

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (2, 5, '2022-08-05', '2023-01-12', 19);

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (3, 5, '2022-08-05', '2023-01-11', 21);

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (5, 5, '2023-01-11', null, 28);

insert into borrows(book_id, person_id, borrow_date, return_date, borrow_maximum_number_of_days)
values (6, 3, '2023-01-12', null, 7);

insert into authors(book_id, person_id)
values (1, 6);

insert into authors(book_id, person_id)
values (2, 6);

insert into authors(book_id, person_id)
values (3, 7);

insert into authors(book_id, person_id)
values (4, 7);

insert into authors(book_id, person_id)
values (5, 8);

insert into authors(book_id, person_id)
values (6, 8);

insert into authors(book_id, person_id)
values (7, 9);

insert into authors(book_id, person_id)
values (8, 9);

insert into authors(book_id, person_id)
values (9, 10);

insert into authors(book_id, person_id)
values (10, 10);

insert into authors (book_id, person_id)
values (11, 10);

insert into authors(book_id, person_id)
values (9, 11);

insert into authors(book_id, person_id)
values (12, 12);
