package Application.Model;

import Application.Controller.UnMarshal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ionel Carmen on 4/16/2017.
 */
public class CSVReport implements GenerateReport {
    @Autowired
    private BookStore books;

    private UnMarshal um = new UnMarshal();
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Title,Author";
    private static String FILE = "E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\CSVreport.csv";

    @Override
    public void generateRaport() throws JAXBException
    {
        FileWriter fileWriter = null;
        books=um.getBooks();
        try
        {
            fileWriter = new FileWriter(FILE);
            fileWriter.append("Report");
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(int i=0; i<books.getBooks().size(); i++)
                if(books.getBooks().get(i).getStock()==0)
                {
                    fileWriter.append(books.getBooks().get(i).getTitle());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(books.getBooks().get(i).getAuthor());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
