package weinberg.corbett.term.project.part2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import weinberg.corbett.term.project.part2.entities.Book;

/*
	•	- Implement task Find All Books using @NamedQuery.
	•	Implement task Find All Books With Authors And Categories using @NamedQuery.
	•	Implement task Find Book with Authors And Category By Book Id using JPA 2 Criteria API.
	•	Create a new book with an author(s). Add it to a selected category. Save the book with an author(s) in your database using JPA 2, or JPA 2 Criteria API.
	•	Delete the newly created book and the author(s) from your database using JPA 2, or JPA 2 Criteria API.
	•	- Find all books for one author id who has more than one book in your database using @NamedQuery.
	•	- Implement task Find All Books By Native Query using Native Query.
*/

@SuppressWarnings("unchecked")
@Transactional
@Repository("publishingDao")
public class PublishingServiceImpl implements PublishingService {
	final static String ALL_BOOKS_NATIVE_QUERY =
	        "select id, category_id, isbn, title, price, version from book";
		
	@PersistenceContext
    private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Book> findAllBooksByNativeQuery(){
		return em.createNativeQuery(ALL_BOOKS_NATIVE_QUERY, "bookResult").getResultList();
	}
	
	@Transactional(readOnly = true)
	public List<Book> findAllBooksWithoutAuthorsAndCategories() {
		return em.createNamedQuery(Book.FIND_ALL_BOOKS_WITHOUT_AUTHORS_CATEGORIES, Book.class).getResultList();
	}
	
	@Transactional(readOnly = true)
	public List<Book> findAllBooksWithAuthorsAndCategories() {
		return em.createNamedQuery(Book.FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES, Book.class).getResultList();
	}
	
	@Transactional(readOnly = true)
	public Book findBookWithAuthorsAndCategoriesByBookId(long bookId) {
		return null;// (Book)sessionFactory.getCurrentSession().
				//getNamedQuery("Book.findAllBooksWithAuthorsAndCategoriesByBookId").
				//setParameter("id", bookId).getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public List<Book> findAllBooksWithAuthorAndCategoryByAuthorId(long authorId) {
		TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES_BY_AUTHORID, 
        		Book.class);
        query.setParameter("id", authorId);
        return query.getResultList();
	}
	
	// Homework said insert, but I decided to allow both inserts and updates.
	@Override
	public Book save(Book book) {
		return null;//sessionFactory.getCurrentSession().saveOrUpdate(book);
		//return book;
	}
		
	@Override
	public void deleteBookAndAuthor(Book book) {
		//sessionFactory.getCurrentSession().delete(book);
	}
	
	//Inject the SessionFactory
	//@Resource(name = "sessionFactory")
	//public void setSessionFactory(SessionFactory sessionFactory) {
		//this.sessionFactory = sessionFactory;
	//}
}