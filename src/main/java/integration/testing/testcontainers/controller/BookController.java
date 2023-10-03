package integration.testing.testcontainers.controller;


import integration.testing.testcontainers.models.Book;
import integration.testing.testcontainers.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/save")
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }
}
