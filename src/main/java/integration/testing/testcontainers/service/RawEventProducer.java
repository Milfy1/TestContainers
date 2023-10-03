package integration.testing.testcontainers.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
@Slf4j
@AllArgsConstructor
public class RawEventProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;


    public void senMsg(String message) {
        CompletableFuture<SendResult<String, String>> future
                = kafkaTemplate.send("tesRaw","1", message);

        future.whenComplete((result, ex) -> {//ex exception
            if (ex == null) {
                onSucess(message, result);

            } else {
                onFailed(message, ex);
            }
        });
    }

    private static void onFailed(String message, Throwable ex) {
        log.info(String.format("Unable to send message [%s] due to =[%s]"
                , message, ex.getMessage()));
    }

    private static void onSucess(String message, SendResult<String, String> result) {
        log.info(String.format("Sent msg [%s] with  offset =[%s]"
                , message, result.getRecordMetadata().offset()));
    }
}
