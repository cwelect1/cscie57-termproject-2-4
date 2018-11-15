package weinberg.corbett.term.project.part2.service;

import java.util.List;

import weinberg.corbett.term.project.part2.entities.Book;

public interface PublishingService {
	public List<Book> findAllBooksByNativeQuery();
	public List<Book> findAllBooksWithoutAuthorsAndCategories();
	public List<Book> findAllBooksWithAuthorsAndCategories();
	public Book findBookWithAuthorsAndCategoriesByBookId(long bookId);
	public List<Book> findAllBooksWithAuthorAndCategoryByAuthorId(long authorId);
	public Book save(Book book);
	public void deleteBookAndAuthor(Book book);	
}

