package Application.Model;

import Application.Controller.UnMarshal;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBException;
import java.awt.Font;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by Ionel Carmen on 4/16/2017.
 */
public class PDFReport implements GenerateReport
{

    @Autowired
    private BookStore books;

    private UnMarshal um=new UnMarshal();

    private static String FILE = "E:\\SemII\\PS\\Assignemnt2\\src\\main\\resources\\PDFreport.pdf";
    private static Font font = new Font("TimesRoman", Font.PLAIN, 20);


    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    private void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        preface.add("Report");
        addEmptyLine(preface,2);
        preface.add(new Paragraph());
        document.add(preface);
    }

    private void addContent(Document document, ArrayList<Book> books)throws DocumentException
    {
        //table
        PdfPTable table = new PdfPTable(2);

        PdfPCell c1 = new PdfPCell(new Phrase("Title"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Author"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        for(int i=0; i<books.size(); i++)
        {
            table.addCell(books.get(i).getTitle());
            table.addCell(books.get(i).getAuthor());
        }

        document.add(table);
    }

    private void addMetaData(Document document)
    {
        document.addTitle("PDF Report");
        document.addAuthor("Ionel Carmen");
        document.addCreator("Ionel Carmen");
    }

    @Override
    public void generateRaport() throws JAXBException
    {
        books=um.getBooks();
        ArrayList<Book> list=new ArrayList<Book>();
        for(int i=0; i<books.getBooks().size(); i++)
            if(books.getBooks().get(i).getStock()==0)
                if(!(list.contains(books.getBooks().get(i))))
                    list.add(books.getBooks().get(i));
        try
        {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document);
            addContent(document,list);
            document.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

