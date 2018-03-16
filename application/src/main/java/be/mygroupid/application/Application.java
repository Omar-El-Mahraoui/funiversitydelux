package be.mygroupid.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;
// copied code from switchfully example

@SpringBootApplication(scanBasePackages = {"be.mygroupid"})
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }

}
