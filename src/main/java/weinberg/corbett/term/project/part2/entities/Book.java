package weinberg.corbett.term.project.part2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@SqlResultSetMapping(
	     name="bookResult",
	     entities=@EntityResult(entityClass=Book.class)
)
public class Book extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ISBN")
	private Long isbn;
	
	@Column(name = "TITLE")
    private String title;
    
	@Column(name = "PRICE")
	private Float price;
	
	@ManyToOne(fetch = FetchType.LAZY)
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
