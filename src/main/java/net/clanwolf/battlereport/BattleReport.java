
package net.clanwolf.battlereport;

import java.io.IOException;
import java.util.Arrays;

// iText imports
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;


/// Generation of a battle report in PDF.
/// This class generates a PDF battle report for an alpha strike game. The data is taken from
/// ASCard through the MariaDB database.
///
/// Info  : [Clan Wolf](https://www.clanwolf.net)
/// GitHub : [GitHub Clan Wolf](https://github.com/ClanWolf)
/// @version 0.0
/// @author Hangtime-2000

public class BattleReport {

    /// default filename for main
    private static String pdfFilename = "DefaultOutputName.pfd";

    private String destinationFileName = "BattleReport.pdf";
    private String sourceDatabase = "127.0.0.1:3306";
    private PdfWriter writer;
    private PdfDocument pdf;
    private Document document;

    /// Main
    /// @param args main arguments
    public static void main(String[]args){
        System.out.println("Hallo Welt!");
        if (args != null && args.length > 0) {
            System.out.println("Args: " + Arrays.toString(args));
            pdfFilename = args[0];
        }
        else {
            System.out.println("Args = null or empty");
        }

        BattleReport report = null;

        try {
            report = new BattleReport();
            System.out.println("PDF generated: " + pdfFilename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (report != null) {
                report.CloseBattleReport();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /// Print current method name to std out
    public static void printCurrentMethodName() {
        String methodName = new Throwable().getStackTrace()[1].getMethodName();
        System.out.println("Current method: " + methodName);
    }

    /// Default constructor.
    /// Uses default output file name and default database.
    /// @todo Replace with factory
    public BattleReport()
    {
        printCurrentMethodName();
        OpenPdfWriter(destinationFileName);
    }

    /// Constructor.
    /// Uses default database.
    /// @param destination Output filename with path
    /// @todo Replace with factory
    public BattleReport(String destination)
    {
        printCurrentMethodName();
        OpenPdfWriter(destination);
    }

    /// Constructor.
    /// @param destination Output filename with path
    /// @param source Source database address
    /// @todo Replace with factory
    public BattleReport(String destination, String source)
    {
        printCurrentMethodName();
        OpenPdfWriter(destination);
    }

    ///
    /// @param destination
    private void OpenPdfWriter(String destination)
    {
        printCurrentMethodName();
        destinationFileName = destination;
        try {
            writer = new PdfWriter(destinationFileName);
            pdf = new PdfDocument(writer);
            document = new Document(pdf);
            System.out.println("pdf generated");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /// Closes the current BattleReport
    public void CloseBattleReport() throws IOException {
        printCurrentMethodName();
        document.close();
        document = null;
        pdf.close();
        pdf = null;
        writer.close();
        writer = null;
    }
}
