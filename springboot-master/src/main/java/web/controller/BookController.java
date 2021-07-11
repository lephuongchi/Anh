package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.model.Book;
import web.service.BookService;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "bookABC", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody
    List<Book> getBooksABC() {
        List<Book> list = bookService.getAllBooks();
        return list;
    }

    @GetMapping(value = "bookXYZ", produces = { MediaType.APPLICATION_XML_VALUE })
    public @ResponseBody List<Book> getBooksXYZ() {
        List<Book> list = bookService.getAllBooks();
        return list;
    }
}
