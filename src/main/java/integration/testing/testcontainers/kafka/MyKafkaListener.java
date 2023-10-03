package integration.testing.testcontainers.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
@Profile({"test","dev"})
public class MyKafkaListener {

    @KafkaListener(topics = "testRaw", groupId = "me")
    public void listenGroupFoo(String message) {
        log.info("Yes we received message in group testRaw with topic raw: " + message);
    }
}
