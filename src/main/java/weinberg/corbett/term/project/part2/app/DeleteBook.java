package weinberg.corbett.term.project.part2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import weinberg.corbett.term.project.part2.entities.Book;
import weinberg.corbett.term.project.part2.service.PublishingService;

public class DeleteBook {
	private static Logger logger = LoggerFactory.getLogger(DeleteBook.class);
	
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
		logger.info("--------------- Deleting Book and Author START: ------------------------------------- \n");
				
		publishingDao.delete(8l);
		
		logger.info("Deleted book!");
		
        logger.info("--------------- Deleting Book and Author END: ------------------------------------- ");

        logger.info("--------------- Books with Authors and Categories After Deleting: ------------------------------------- \\n");
        for(Book book : publishingDao.findAllBooks()) {
			logger.info(book.toString());
			logger.info("--------------------------------------------------------------------------------------------------------");
        }
    	
        ctx.close();
    }
}
