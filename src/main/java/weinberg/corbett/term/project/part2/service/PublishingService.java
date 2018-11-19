package weinberg.corbett.term.project.part2.service;

import java.util.List;

import weinberg.corbett.term.project.part2.entities.Book;

public interface PublishingService {
	public List<Book> findAllBooks();
	public void findAllBooksWithAuthorsAndCategoriesById(Long id);
	public void delete(long id);
	public void save(Book book);
}

