package weinberg.corbett.term.project.part2.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author extends AbstractEntity {
    
	private static final long serialVersionUID = 1L;
    
	@Column(name = "FIRST_NAME")
	private String firstName;
    
	@Column(name = "LAST_NAME")
	private String lastName;
    
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToMany
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "AUTHOR_ID"),
			inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private List<Book> books = new ArrayList<>();
	
    public String getDescription() {
    	return this.description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
    	return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author - Id: " + id + ", First Name: " + firstName + " Last Name: " + lastName + " Description: " + description;
    }
}
