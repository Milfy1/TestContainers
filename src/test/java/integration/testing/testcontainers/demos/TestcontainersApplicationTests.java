//package integration.testing.testcontainers;
//
//import org.junit.ClassRule;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import java.util.List;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//
//@Testcontainers
//@SpringBootTest
//class TestcontainersApplicationTests {
//
//	@Autowired
//	private BookRepo bookRepo;
//
//	// TODO: 30/08/2023 AD Check Kafka Container
////	@ClassRule
////	public static KafkaContainer kafka =
////			new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:5.4.3"));
//
//	@Container
//	public static  PostgreSQLContainer container = new PostgreSQLContainer("postgres:latest")
//				.withUsername("abdullah1")
//				.withPassword("password")
//				.withDatabaseName("test");
//	@DynamicPropertySource
//	static void properties(DynamicPropertyRegistry registry) {
//		registry.add("spring.datasource.url", container::getJdbcUrl);
//		registry.add("spring.datasource.password", container::getPassword);
//		registry.add("spring.datasource.username", container::getUsername);
//	}
//
//
//	@Test
//	@Order(1)
//	void when_using_a_clean_db_this_should_be_empty() {
//		List<Book> books = bookRepo.findAll();
//		System.out.println(books);
//		Assertions.assertFalse(books.isEmpty());
//	}
//
//
//	@Test
//	@Order(2)
//	void insert() {
//		Book book = new Book();
//		book.setName("firstBook");
//		book.setPages(23);
//		bookRepo.save(book);
//		System.out.println("Test Done!");
//	}
//
//
//}