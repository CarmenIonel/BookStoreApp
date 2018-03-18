package Application;

import Application.Model.PDFReport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.xml.bind.JAXBException;

/**
 * Created by Ionel Carmen on 4/10/2017.
 */
@SpringBootApplication
public class Main
{
    public static void main(String[] args) throws JAXBException
    {
           SpringApplication.run(Main.class, args);
    }
}
