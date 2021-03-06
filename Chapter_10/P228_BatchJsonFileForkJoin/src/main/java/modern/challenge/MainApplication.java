package modern.challenge;

import modern.challenge.service.TransferService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final TransferService transferService;

    public MainApplication(TransferService transferService) {
        this.transferService = transferService;
    }

    private static final String FILE_NAME = "citylots.json";

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            transferService.transferFile(FILE_NAME);
        };
    }
}
