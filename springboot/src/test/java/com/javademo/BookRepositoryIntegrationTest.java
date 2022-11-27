package com.javademo;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.Mockito;
import com.javademo.model.Book;
import com.javademo.repository.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BookRepositoryIntegrationTest {

	@Test
	void contextLoads() {
	}
    @Autowired
    private BookRepository bookRepository;
    Autowired
    private TestRestTemplate restTemplate;
	
	@Test
    public void getBooks() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/api/books", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
		
	@Test
	public void testCreateReadDelete() {
		String url = "http://localhost::"+port+"/books";
		Book book = new Book("President", "Bill Clinton", "false");
		ResponseEntity<Book> entity = this.restTemplate.postForEntity(url, book, Book.class);
		Book[] books = this.restTemplate.getForObject(url, Book[].class);
		Assertions.assertThat(books).extracting(Book::getAuthor).containsOnly("Bill Clinton");
	}
 }


