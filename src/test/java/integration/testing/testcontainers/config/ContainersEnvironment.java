//package integration.testing.testcontainers.config;
//
//import integration.testing.testcontainers.containers.KafkaTestContainer;
//import integration.testing.testcontainers.containers.PostgresTestContainer;
//import org.testcontainers.containers.KafkaContainer;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//@Testcontainers
//public class ContainersEnvironment {
//
//    @Container
//    public static PostgreSQLContainer postgreSQLContainer = PostgresTestContainer.getInstance();
//
//    @Container
//    public static KafkaContainer kafkaContainer;
//
//    static {
//        try {
//            kafkaContainer = KafkaTestContainer.getInstance();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
