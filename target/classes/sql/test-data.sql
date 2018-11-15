insert into category (name) values ('Finance');
insert into category (name) values ('Business');
insert into category (name) values ('Health');
insert into category (name) values ('Programming');

insert into book (CATEGORY_ID, ISBN, TITLE, PRICE, VERSION) values ((select id from category where name = 'Business'), '0307951540', 'One hundred dollar startup', '1.99',0);
insert into book (CATEGORY_ID, ISBN, TITLE, PRICE, VERSION) values ((select id from category where name = 'Finance'), '0135058724', 'Trading Options at Expiration-Strategies and Models for Winning the Endgame', '59.99',0);
insert into book (CATEGORY_ID, ISBN, TITLE, PRICE, VERSION) values ((select id from category where name = 'Finance'), '0887308767', 'Pit bull : lessons from Wall Street\'s champion trader / Martin "Buzzy" Schwartz with Dave Morine and Paul Flint', '1.99',0);
insert into book (CATEGORY_ID, ISBN, TITLE, PRICE, VERSION) values ((select id from category where name = 'Programming'), '1783987221', 'Maven Build Customization [eBook]', '0.00',0);
insert into book (CATEGORY_ID, ISBN, TITLE, PRICE, VERSION) values ((select id from category where name = 'Health'), '1403329974', 'THE AMAZING LIVER CLEANSE', '19.95',0);
insert into book (CATEGORY_ID, ISBN, TITLE, PRICE, VERSION) values ((select id from category where name = 'Programming'), '0134757599', 'Refactoring: Improving the Design of Existing Code (2nd Edition)', '59.99',0);
insert into book (CATEGORY_ID, ISBN, TITLE, PRICE, VERSION) values ((select id from category where name = 'Programming'), '0321127420', 'Patterns of Enterprise Application Architecture', '69.99',0);

insert into author (first_name, last_name, description, version) values ('Jeff', 'Augen', 'Private investor and writer',0);
insert into author (first_name, last_name, description, version) values ('Chris', 'Guillebeau', 'Self made entrepreneur',0);
insert into author (first_name, last_name, description, version) values ('Martin', 'Schwartz', 'Champion trader',0);
insert into author (first_name, last_name, description, version) values ('Andreas', 'Moritz', 'Medical intuitive and practitioner of Ayurveda',0);
insert into author (first_name, last_name, description, version) values ('Giacomo', 'Veneri', 'Expert in computer-assisted diagnosis',0);
insert into author (first_name, last_name, description, version) values ('Lorenzo', 'Anardu', 'Developer and expert in optimization and high-performance computing',0);
insert into author (first_name, last_name, description, version) values ('Martin', 'Fowler', 'Chief Scientist at ThoughtWorks',0);

insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Chris' and last_name = 'Guillebeau'),
	(select id from book where isbn = '0307951540')
);
insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Jeff' and last_name = 'Augen'),
	(select id from book where isbn = '0135058724')
);
insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Martin' and last_name = 'Schwartz'),
	(select id from book where isbn = '0887308767')
);
insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Lorenzo' and last_name = 'Anardu'),
	(select id from book where isbn = '1783987221')
);
insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Giacomo' and last_name = 'Veneri'),
	(select id from book where isbn = '1783987221')
);
insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Andreas' and last_name = 'Moritz'),
	(select id from book where isbn = '1403329974')
);
insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Martin' and last_name = 'Fowler'),
	(select id from book where isbn = '0134757599')
);
insert into author_book (author_id, book_id) values(
	(select id from author where first_name = 'Martin' and last_name = 'Fowler'),
	(select id from book where isbn = '0321127420')
);

show tables;
select * from category;
select * from book;
select * from author;
select * from author_book;



