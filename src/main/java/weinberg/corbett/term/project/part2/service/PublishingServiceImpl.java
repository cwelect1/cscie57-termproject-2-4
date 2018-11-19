package weinberg.corbett.term.project.part2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import weinberg.corbett.term.project.part2.app.FindBookWithAuthorsAndCategoriesByBookId;
import weinberg.corbett.term.project.part2.entities.Author;
import weinberg.corbett.term.project.part2.entities.Book;
import weinberg.corbett.term.project.part2.repos.BookRepository;

/*
	•	Find a book with author(s) and category by the book Id
	•	Find all books without details
	•	Create a new book with a new author(s) not persisted yet in your database. The book should belong to one of the category already persisted in your database.  Save the book and the author(s) in the database.
	•	Delete the added book and the author(s) from the database.
*/

@Transactional
@Repository("publishingDao")
public class PublishingServiceImpl implements PublishingService {
	private static Logger logger = LoggerFactory.getLogger(PublishingServiceImpl.class);
	
	@Autowired
    private BookRepository bookRepo;
	
	@Transactional(readOnly = true)
	@Override
	public List<Book> findAllBooks(){
		return Lists.newArrayList(bookRepo.findAll());
	}
	
	@Transactional(readOnly = true)
	@Override
	public void findAllBooksWithAuthorsAndCategoriesById(Long id){
		Book book = bookRepo.findBookById(id);
		logger.info(book.toString());
		logger.info(book.getCategory().toString());
		for(Author author : book.getAuthors()) {
			logger.info(author.toString());
		}
	}

	@Override
	public void save(Book book) {
		bookRepo.save(book);
	}

	@Override
	public void delete(long id) {
		bookRepo.deleteById(id);
	}
}