use library;

delimiter //
create procedure numberOfBooksWithAGivenGenreWithNumberOfPagesBetweenAGivenRange(genre varchar(30),
                                                                                 min_number_of_pages int,
                                                                                 max_number_of_pages int)
begin
    select *
    from books
    where (min_number_of_pages <= books.number_of_pages)
      and (books.number_of_pages <= max_number_of_pages)
      and (books.genre = genre)
    order by number_of_copies;
end //
delimiter ;

delimiter //
create procedure notReturnedBooksWithAGivenOverdue(overdue int)
begin
    select *
    from borrows
    where (datediff(borrows.return_date, borrows.borrow_date) + overdue - borrows.borrow_maximum_number_of_days > 0)
    order by borrows.borrow_date, borrows.borrow_maximum_number_of_days desc;
end //
delimiter ;

delimiter //
create procedure booksBorrowedFromAGivenGenreInTheLastGivenDays(genre varchar(30), number_of_days int)
begin
    select persons.first_last_name as first_last_name, persons.address as address, persons.phone_number as phone_number
    from persons
             join borrows on persons.id = borrows.person_id
             join books on borrows.book_id = books.id
    where (books.genre = genre)
      and (datediff(curdate(), borrows.borrow_date) <= number_of_days);
end //
delimiter ;


delimiter //
create procedure getMultipleAuthors()
begin
    select first_author.person_id as first_author, second_author.person_id as second_author
    from (select *
          from authors
                   join books on books.id = authors.book_id) first_author
             inner join
         (select *
          from authors
                   join books on books.id = authors.book_id) second_author
         on first_author.book_id = second_author.book_id
    where first_author.person_id < second_author.person_id
    order by first_author.person_id;
end //
delimiter ;

delimiter //
create procedure getBooksWithTitleContainingGivenKeyword(keyword varchar(30))
begin
    select *
    from books
    where books.title like concat('%', keyword, '%');
end //
delimiter ;

delimiter //
create procedure getTitleAndAuthorsThatHaveMaximumNumberOfCopies()
begin
    select books.title as title, group_concat(persons.first_last_name separator ',') as authors
    from books
             join authors on books.id = authors.book_id
             join persons on authors.person_id = persons.id
    where books.number_of_copies = (select max(books.number_of_copies) from books)
    group by books.title;
end //
delimiter ;

delimiter //
create procedure getPersonsNameForTheHighestOverdue()
begin
    select persons.first_last_name                       as first_last_name,
           max(datediff(curdate(), borrows.borrow_date)) as maximum_borrow_time
    from persons
             join borrows on persons.id = borrows.person_id
    where borrows.return_date is null
    group by persons.id;
end //
delimiter ;

delimiter //
create procedure getMinimumAverageAndMaximumNumberOfPagesForEachGenre()
begin
    select books.genre                as genre,
           min(books.number_of_pages) as minimum_number_of_pages,
           avg(books.number_of_pages) as avarage_number_of_pages,
           max(books.number_of_pages) as maximum_number_of_pages
    from books
    group by books.genre;
end //
delimiter ;