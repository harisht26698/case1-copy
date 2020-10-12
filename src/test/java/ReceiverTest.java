import com.philips.receiver.service.ProcessingData;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiverTest {

    @Test
    public void checkIsNumber(){
        assertTrue(ProcessingData.isNumber("4"));
        assertFalse(ProcessingData.isNumber("a"));
        assertFalse(ProcessingData.isNumber("@"));
        assertFalse(ProcessingData.isNumber("name"));
    }
    @Test
    public void checkIsDate(){
        assertTrue(ProcessingData.isDate("4/31/2020"));
        assertFalse(ProcessingData.isDate("13/31/2020"));
        assertTrue(ProcessingData.isDate("11.11.2020"));
        assertFalse(ProcessingData.isDate("a.b.c"));
    }
    @Test
    public void checkIsStopWord(){
        assertTrue(ProcessingData.isStopWord("the"));
        assertFalse(ProcessingData.isStopWord("rename"));
        assertFalse(ProcessingData.isStopWord("import"));
    }

}

