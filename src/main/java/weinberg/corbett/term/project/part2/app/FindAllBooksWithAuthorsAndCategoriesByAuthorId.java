package weinberg.corbett.term.project.part2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import weinberg.corbett.term.project.part2.entities.Author;
import weinberg.corbett.term.project.part2.entities.Book;
import weinberg.corbett.term.project.part2.service.PublishingService;

public class FindAllBooksWithAuthorsAndCategoriesByAuthorId {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksWithAuthorsAndCategoriesByAuthorId.class);
	
    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

    	PublishingService publishingDao = ctx.getBean(PublishingService.class);
    	
    	logger.info("");
		logger.info("--------------- Listing \"books found BY AUTHORID with authors and categories\" START: ------------------------------------- \n");
		for(Book book : publishingDao.findAllBooksWithAuthorAndCategoryByAuthorId(7)) {
			logger.info(book.toString());
			logger.info(book.getCategory().toString());
			for(Author author : book.getAuthors()) {
				logger.info(author.toString());
			}
			logger.info("--------------------------------------------------------------------------------------------------------");
        }
        logger.info("--------------- Listing \"books found BY AUTHORID with authors and categories\" END: ------------------------------------- ");

        ctx.close();
    }
}
