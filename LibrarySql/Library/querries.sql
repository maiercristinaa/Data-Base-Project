use library;

select *
from books
where (100 <= books.number_of_pages)
  and (books.number_of_pages <= 300)
  and (books.genre = 'Tehnic')
order by number_of_copies;

select *
from borrows
where (datediff(borrows.return_date, borrows.borrow_date) + 14 - borrows.borrow_maximum_number_of_days > 0)
order by borrows.borrow_date, borrows.borrow_maximum_number_of_days desc;

select persons.first_last_name as first_last_name, persons.address as address, persons.phone_number as phone_number
from persons
         join borrows on persons.id = borrows.person_id
         join books on borrows.book_id = books.id
where (books.genre = 'Copii')
  and (datediff(curdate(), borrows.borrow_date) <= 14);

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

select *
from books
where books.title like '%Shogun%';

select books.title as title, group_concat(persons.first_last_name separator ',') as authors
from books
         join authors on books.id = authors.book_id
         join persons on authors.person_id = persons.id
where books.number_of_copies = (select max(books.number_of_copies) from books)
group by books.title;

select persons.first_last_name                       as first_last_name,
       max(datediff(curdate(), borrows.borrow_date)) as maximum_borrow_time
from persons
         join borrows on persons.id = borrows.person_id
where borrows.return_date is null
group by persons.id;

select books.genre                as genre,
       min(books.number_of_pages) as minimum_number_of_pages,
       avg(books.number_of_pages) as avarage_number_of_pages,
       max(books.number_of_pages) as maximum_number_of_pages
from books
group by books.genre;

