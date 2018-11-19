package weinberg.corbett.term.project.part2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import weinberg.corbett.term.project.part2.entities.Book;
import weinberg.corbett.term.project.part2.service.PublishingService;

public class FindAllBooks {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooks.class);
	
    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

    	PublishingService publishingDao = ctx.getBean(PublishingService.class);
    	
    	logger.info("");
		logger.info("--------------- Listing \"All books\" START: ------------------------------------- \n");
		
		
		for(Book book : publishingDao.findAllBooks()) {
			logger.info(book.toString());
			logger.info("--------------------------------------------------------------------------------------------------------");
        }
        
        logger.info("--------------- Listing \"All books\" END: ------------------------------------- ");

        ctx.close();
    }
}
