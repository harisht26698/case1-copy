import com.philips.sender.service.DataProcessing;
import com.philips.sender.service.PrintToConsole;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class SenderTest {
    private String testLine = "ReviewDate,Comments";
    private String[] testArray = testLine.split(",");
    @Test
    public void checkPrintToConsoleIsColoumnExists(){
        assertTrue(PrintToConsole.isColumnExists(0));
        assertFalse(PrintToConsole.isColumnExists(-1));
    }

    @Test
    public void checkCsvLineToArrayOfString(){

        String[] retArray = DataProcessing.csvLineToArrayOfString(testLine);
        assertEquals(testArray[0],retArray[0]);
        assertEquals(testArray[1],retArray[1]);
    }

    @Test
    public void checkGetColumnNumber(){
        assertEquals(0,DataProcessing.getColumnNumber(testArray,"ReviewDate"));
        assertEquals(1,DataProcessing.getColumnNumber(testArray,"Comments"));
        assertEquals(-1,DataProcessing.getColumnNumber(testArray,"wrongCol"));
    }

    @Test
    public void checkValidateColumnNumber(){
        assertEquals(-1,DataProcessing.validateColumnNumber(2,2));
        assertEquals(0,DataProcessing.validateColumnNumber(2,0));
        assertEquals(-1,DataProcessing.validateColumnNumber(2,3));
    }

    @Test
    public void checkPrintingArrayOfStringToConsole() throws IOException {
        PrintToConsole.lineData = testLine.split(",");
        PrintToConsole.printingArrayOfStringToConsole();
        BufferedReader br = new BufferedReader(new FileReader("console.csv"));
        assertEquals("ReviewDate Comments ",br.readLine());
        br.close();
    }

    @Test
    public void checkConsoleOutput() throws IOException {
        PrintToConsole.consoleOutput("test");
        BufferedReader br = new BufferedReader(new FileReader("console.csv"));
        assertEquals("ReviewDate Comments test",br.readLine());
        br.close();
    }

    @Test
    public void checkBufferDataIsPrintingToConsole() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("consoleTest.csv"));
        PrintToConsole.bufferDataIsPrintingToConsole(br);
        BufferedReader br1 = new BufferedReader(new FileReader("console.csv"));
        assertEquals("ReviewDate Comments testReviewDate Comments ",br1.readLine());
        br.close();
        br1.close();
    }
}
