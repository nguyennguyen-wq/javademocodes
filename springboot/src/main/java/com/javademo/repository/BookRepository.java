package com.javademo.repository;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javademo.model.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {
  List<Book> findByPublished(boolean published);
  List<Book> findByTitle(String title);
  List<Book> findByAuthor(String author);
  List<Book> findByISBN(long isbn);
}