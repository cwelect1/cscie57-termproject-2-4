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
    	for(Book book : publishingDao.findAllBooks()) {
			logger.info(book.toString());
			logger.info("--------------------------------------------------------------------------------------------------------");
        }
    	
    	logger.info("");
		logger.info("--------------- Listing \"insert new book\" START: ------------------------------------- \n");
		
		Category category = new Category();
		category.setId(1L);
		category.setName("Finance");

		Book newBook = new Book();
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
		
		publishingDao.save(newBook);;
		
        logger.info("--------------- Listing \"insert new book\" END: -------------------------------------\n ");

    	
        logger.info("--------------- After Inserting - Books with Authors and Categories: ------------------------------------- \n");
    	for(Book book : publishingDao.findAllBooks()) {
			logger.info(book.toString());
			logger.info("--------------------------------------------------------------------------------------------------------");
        }

        ctx.close();
    }
}
