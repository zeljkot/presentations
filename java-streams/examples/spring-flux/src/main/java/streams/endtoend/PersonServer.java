package streams.endtoend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PersonServer {

    public static void main(String[] args) {
        SpringApplication.run(PersonServer.class, args);
    }
}
