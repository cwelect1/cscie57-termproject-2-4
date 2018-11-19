package weinberg.corbett.term.project.part2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import weinberg.corbett.term.project.part2.service.PublishingService;

public class FindBookWithAuthorsAndCategoriesByBookId {
	private static Logger logger = LoggerFactory.getLogger(FindBookWithAuthorsAndCategoriesByBookId.class);
	
    public static void main(String[] args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

    	PublishingService publishingDao = ctx.getBean(PublishingService.class);
    	
    	logger.info("");
		logger.info("--------------- Listing \"book byId with authors and categories\" START: ------------------------------------- \n");
		
		publishingDao.findAllBooksWithAuthorsAndCategoriesById(4l);
		
        logger.info("--------------- Listing \"book byId with authors and categories\" END: ------------------------------------- ");

        ctx.close();
    }
}
