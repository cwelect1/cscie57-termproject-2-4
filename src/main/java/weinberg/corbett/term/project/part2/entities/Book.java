package weinberg.corbett.term.project.part2.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@NamedQueries({
		@NamedQuery(name=Book.FIND_ALL_BOOKS_WITHOUT_AUTHORS_CATEGORIES,
				query="select distinct b from Book b"),
		@NamedQuery(name=Book.FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES,
				query="select distinct b from Book b " +
						"left join fetch b.authors a " +
						"left join fetch b.category c "), 
		@NamedQuery(name=Book.FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES_BY_BOOKID,
				query="select distinct b from Book b " +
						"left join fetch b.authors a " +
						"left join fetch b.category c " +
						"where b.id = :id"),
		@NamedQuery(name=Book.FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES_BY_AUTHORID,
						query="select distinct b from Book b " +
								"left join fetch b.authors a " +
								"left join fetch b.category c " +
								"where a.id = :id"),
})
@SqlResultSetMapping(
	     name="bookResult",
	     entities=@EntityResult(entityClass=Book.class)
)
public class Book implements Serializable {
	public static final String FIND_ALL_BOOKS_WITHOUT_AUTHORS_CATEGORIES = 
			"Book.findAllBooksWithoutAuthorsAndCategories";
	public static final String FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES = 
			"Book.findAllBooksWithAuthorsAndCategories";
	public static final String FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES_BY_BOOKID = 
			"Book.findAllBooksWithAuthorsAndCategoriesByBookId";
	public static final String FIND_ALL_BOOKS_WITH_AUTHORS_CATEGORIES_BY_AUTHORID = 
			"Book.findAllBooksWithAuthorsAndCategoriesByAuthorId";
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

	@Column(name = "ISBN")
	private Long isbn;
	
	@Column(name = "TITLE")
    private String title;
    
	@Column(name = "PRICE")
	private Float price;
	
	@ManyToOne()
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@ManyToMany (cascade = {CascadeType.ALL})
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "BOOK_ID"),
			inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	private List<Author> authors = new ArrayList<>();

	public List<Author> getAuthors() {
		return authors;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getIsbn() {
        return this.isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPrice() {
        return this.price;
    }

    public void addAuthor(List<Author> authors) {
    	this.authors.addAll(authors);
    }
    
    @Override
    public String toString() {
        return "Book - Id: " + id + ", Category Id: " + this.getCategory().getId() + " ISBN: " + isbn
            + ", Title: " + title + ", Price: " + price;
    }
}
