package Application.Model;

/**
 * Created by Ionel Carmen on 4/16/2017.
 */
public class ReportFactory
{
    public GenerateReport getType(String type)
    {
        if(type==null)
            return null;
        if(type.equalsIgnoreCase("pdf"))
            return new PDFReport();
        else
            if(type.equalsIgnoreCase("csv"))
                return new CSVReport();
        return null;
    }
}
