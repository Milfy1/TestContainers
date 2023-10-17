package integration.testing.testcontainers.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "book_seq")
    @Column(name = "id")
    private Long id;
    @Column(length = 100)
    private String name;

    private Integer pages;
}
