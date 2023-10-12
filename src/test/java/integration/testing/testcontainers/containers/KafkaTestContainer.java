//package integration.testing.testcontainers.containers;
//
//import org.springframework.test.context.ActiveProfiles;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
////@Testcontainers
////@ActiveProfiles("test")
//public class KafkaTestContainer extends KafkaContainer {
//
//    public static final String IMAGE_VERSION = "confluentinc/cp-kafka:6.2.1";
//    public static KafkaContainer container;
//
//
//
//
//    public static KafkaContainer getInstance() throws InterruptedException {
//        if (container == null) {
//            container = new KafkaContainer(DockerImageName.parse(IMAGE_VERSION));
//            container.start();
//            String bootstrapServers = container.getBootstrapServers();
//            System.out.println("TEST Abdullah"+ bootstrapServers);
//            System.setProperty("spring.kafka.bootstrapAddress", bootstrapServers);
//        }
//        return container;
//    }
//}
