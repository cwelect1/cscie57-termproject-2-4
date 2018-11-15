package weinberg.corbett.term.project.part2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import weinberg.corbett.term.project.part2.entities.Author;
import weinberg.corbett.term.project.part2.entities.Book;
import weinberg.corbett.term.project.part2.service.PublishingService;

public class FindAllBooksWithAuthorsAndCategories {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksWithAuthorsAndCategories.class);
	
    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

    	PublishingService publishingDao = ctx.getBean(PublishingService.class);
    	
    	logger.info("");
		logger.info("--------------- Listing \"books with authors and categories\" START: ------------------------------------- \n");
		for(Book book : publishingDao.findAllBooksWithAuthorsAndCategories()) {
			logger.info(book.toString());
			logger.info(book.getCategory().toString());
			for(Author author : book.getAuthors()) {
				logger.info(author.toString());
			}
			logger.info("--------------------------------------------------------------------------------------------------------");
        }
        logger.info("--------------- Listing \"books with authors and categories\" END: ------------------------------------- ");

        ctx.close();
    }
}
