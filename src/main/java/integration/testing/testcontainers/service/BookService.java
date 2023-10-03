package integration.testing.testcontainers.service;

import integration.testing.testcontainers.models.Book;
import integration.testing.testcontainers.repo.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepo bookRepo;
    private final RawEventProducer rawEventProducer;


    public BookService(BookRepo bookRepo, RawEventProducer rawEventProducer) {
        this.bookRepo = bookRepo;
        this.rawEventProducer = rawEventProducer;
    }

    public Book save(Book book){
        rawEventProducer.senMsg("This is a demo message");
        return bookRepo.save(book);
    }

}
