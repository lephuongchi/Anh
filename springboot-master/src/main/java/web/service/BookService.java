package web.service;

import org.springframework.stereotype.Service;
import web.model.Book;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    public List<Book> getAllBooks() {
        // Perform database operation
        Book b1 = new Book(101, "Java Tutorials", "Krishna");
        Book b2 = new Book(102, "Spring Tutorials", "Mahesh");
        Book b3 = new Book(103, "Angular Tutorials", "Shiva");
        return Arrays.asList(b1, b2, b3);
    }
}
