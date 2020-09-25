import com.philips.sender.service.DataProcessing;
import com.philips.sender.service.PrintToConsole;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class SenderTest {
    private String testLine = "ReviewDate,Comments";
    private String[] testArray = testLine.split(",");
    @Test
    public void checkPrintToConsoleIsColoumnExists() throws FileNotFoundException {
        assertTrue(PrintToConsole.isColumnExists(0));
        assertFalse(PrintToConsole.isColumnExists(-1));
    }

    @Test
    public void checkCsvLineToArrayOfString() throws FileNotFoundException {

        String[] retArray = DataProcessing.csvLineToArrayOfString(testLine);
        assertEquals(testArray[0],retArray[0]);
        assertEquals(testArray[1],retArray[1]);
    }

    @Test
    public void checkGetColumnNumber() throws FileNotFoundException {
        assertEquals(0,DataProcessing.getColumnNumber(testArray,"ReviewDate"));
        assertEquals(1,DataProcessing.getColumnNumber(testArray,"Comments"));
        assertEquals(-1,DataProcessing.getColumnNumber(testArray,"wrongCol"));
    }

    @Test
    public void checkValidateColumnNumber() throws FileNotFoundException {
        assertEquals(-1,DataProcessing.validateColumnNumber(2,2));
        assertEquals(0,DataProcessing.validateColumnNumber(2,0));
        assertEquals(-1,DataProcessing.validateColumnNumber(2,3));
    }
}
