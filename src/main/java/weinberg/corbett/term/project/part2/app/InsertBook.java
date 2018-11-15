package weinberg.corbett.term.project.part2.app;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import weinberg.corbett.term.project.part2.entities.Author;
import weinberg.corbett.term.project.part2.entities.Book;
import weinberg.corbett.term.project.part2.entities.Category;
import weinberg.corbett.term.project.part2.service.PublishingService;

public class InsertBook {
	private static Logger logger = LoggerFactory.getLogger(InsertBook.class);
	
    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

    	PublishingService publishingDao = ctx.getBean(PublishingService.class);
    	
    	logger.info("--------------- Existing Books with Authors and Categories: ------------------------------------- \\n");
    	for(Book book : publishingDao.findAllBooksWithAuthorsAndCategories()) {
			logger.info(book.toString());
			logger.info(book.getCategory().toString());
			for(Author author : book.getAuthors()) {
				logger.info(author.toString());
			}
			logger.info("--------------------------------------------------------------------------------------------------------");
        }
    	
    	logger.info("");
		logger.info("--------------- Inserting New Book and Author START: ------------------------------------- \n");
		
		Category category = new Category();
		category.setId(1L);
		category.setName("Finance");

		Book newBook = new Book();
			 //newBook.setCategoryId(2l);
			 newBook.setCategory(category);
			 newBook.setTitle("Title");
			 newBook.setIsbn(1234567890l);
			 newBook.setPrice(49.69f);
			 
		Author newAuthor = new Author();
			   newAuthor.setFirstName("Bob");
			   newAuthor.setLastName("NewHart");
			   newAuthor.setDescription("description");
		
		List<Author> authors = new ArrayList<>();
		authors.add(newAuthor);
		
		newBook.addAuthor(authors);

		publishingDao.save(newBook);
		
		logger.info("Adding new Book and Author and associating with existing category: \n\t\t\t\t\t\t\t\t\t" 
					+ newBook.toString() + "\n\t\t\t\t\t\t\t\t\t"
					+ newAuthor.toString() + "\n\t\t\t\t\t\t\t\t\t"
					+ category.toString() + "\n");
		
		
        logger.info("--------------- Inserting New Book and Author END: ------------------------------------- ");

        logger.info("--------------- Books with Authors and Categories After Inserting New Book/Author: ------------------------------------- \\n");
    	for(Book book : publishingDao.findAllBooksWithAuthorsAndCategories()) {
			logger.info(book.toString());
			logger.info(book.getCategory().toString());
			for(Author author : book.getAuthors()) {
				logger.info(author.toString());
			}
			logger.info("--------------------------------------------------------------------------------------------------------");
        }
    	
        ctx.close();
    }
}
