package integration.testing.testcontainers;


import integration.testing.testcontainers.config.ContainersEnvironment;
import integration.testing.testcontainers.models.Book;
import integration.testing.testcontainers.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest(classes = TestcontainersApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookRepositoryTest extends ContainersEnvironment{

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    KafkaTemplate kafkaTemplate;

//
//    @BeforeAll
//    public static void beforeAll() {
//        kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"));
//        kafka.start();
//        String bootstrapServers = kafka.getBootstrapServers();
//        System.out.println("Bootstrap Abdullah " + bootstrapServers);
//        System.setProperty("kafka.bootstrapAddress", bootstrapServers);
//    }
    @Test
    public void When_GetProducts_Expect_EmptyList(){
        List<Book> list = bookRepo.findAll();
        assertEquals(0, list.size());
    }
    //Another Approach
   // SendResult<String, String> result = kafkaTemplate.send(producerRecord).get(10, SECONDS);

    @Test
    public void Test_Kafka() throws InterruptedException {
//        CompletableFuture send = kafkaTemplate.send("testRaw","me",  "First Message");
//        send.whenComplete((result, throwable) -> {
//            if (throwable == null) {
//                System.out.println("THIS"+ result);
//            } else {
//                System.out.println("THIS"+ result);
//            }
//        });
        kafkaTemplate.send("testRaw","me","First Message");
        kafkaTemplate.send("testRaw","me","Second Message");
        kafkaTemplate.send("content","me","3 Message");
        for (int i = 0; i<400 ; i++){
            if (i % 25 == 0){
                kafkaTemplate.send("testRaw","me", "send another message is " + i);
            }
            Thread.sleep(10);
        }
    }


    	@Test
        void Insert_Book() {
		Book book = new Book();
		book.setName("firstBook");
		book.setPages(23);
		bookRepo.save(book);
		System.out.println("Test Done!");
	}

}
