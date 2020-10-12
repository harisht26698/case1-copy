import com.philips.receiver.service.DataStorage;
import com.philips.receiver.service.ProcessingData;
import com.philips.receiver.service.Validation;
import com.philips.receiver.service.WriteToCSV;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    @Test
    public void checkDataStorage(){
        DataStorage.storeDataInMap("remove","4/7/2020");
        DataStorage.storeDataInMap("remove","5/7/2020");
        assertEquals(new Integer(2),DataStorage.wordCount.get("remove"));
        assertEquals("4/7/2020 5/7/2020",DataStorage.wordWithDate.get("remove"));
    }
    @Test
    public void checkMapToCsvWriter() throws IOException {
        DataStorage.wordCount.put("test",4);
        WriteToCSV.mapToCsvWriter();
        BufferedReader br = new BufferedReader(new FileReader("wordCount.csv"));
        assertEquals("Word,Count",br.readLine());
        assertEquals("remove,2",br.readLine());
        assertEquals("test,4",br.readLine());
        BufferedReader br1 = new BufferedReader(new FileReader("wordUsedOnDates.csv"));
        assertEquals("Word,Dates",br1.readLine());
    }
    @Test
    public void checkValidateDataThenSendValidDataToStore() throws IOException {
        String line= "4/27/2020 9:14 what does this help with";
        String[] words=line.split(" ");
        Validation.validateDataThenSendValidDataToStore(words);
        assertEquals(new Integer(1),DataStorage.wordCount.get("help"));
        assertEquals("4/27/2020",DataStorage.wordWithDate.get("help"));
        assertFalse(DataStorage.wordWithDate.containsKey("test"));

        line= "help with verify the string";
        words=line.split(" ");
        Validation.validateDataThenSendValidDataToStore(words);
        assertEquals(new Integer(2),DataStorage.wordCount.get("help"));
        assertEquals("4/27/2020",DataStorage.wordWithDate.get("verify"));
    }

}

