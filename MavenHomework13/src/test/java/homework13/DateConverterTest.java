package homework13;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.time.format.DateTimeParseException;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class DateConverterTest {

    @Test
    public void positiveTestConvertDate() {
        String inputDate = "03-11-2023";
        String expectedOutputDate = "11/03/2023";
        String inputFormat = "dd-MM-yyyy";
        String outputFormat = "MM/dd/yyyy";

        String result = DateConverter.convertDate(inputDate, inputFormat, outputFormat);

        assertEquals(expectedOutputDate, result);
    }

    @Test
    public void positiveTestDetectDateFormat() {
        String dateStr = "11/03/2023";
        String expectedFormat = "MM/dd/yyyy";

        String result = DateConverter.detectDateFormat(dateStr);

        assertEquals(expectedFormat, result);
    }

    @Test
    public void positiveTestConvertDateToFullMonth() {
        String inputDate = "2023-11-03";
        String expectedOutputDate = "03 ноября 2023";
        String inputFormat = "yyyy-MM-dd";
        String outputFormat = "dd MMMM yyyy";

        String result = DateConverter.convertDate(inputDate, inputFormat, outputFormat);

        assertEquals(expectedOutputDate, result);
    }

    @Test
    public void negativeTestInputFormatIsInvalid() {
        String inputDate = "2023-25-03";
        String inputFormat = "yyyy-MM-dd";
        String outputFormat = "dd MMMM yyyy";

        assertThrows(DateTimeParseException.class, () -> {
            DateConverter.convertDate(inputDate, inputFormat, outputFormat);
        });
    }

    @Test
    public void negativeTestInputDateIsNull() {
        String inputDate = null;
        String inputFormat = "yyyy-MM-dd";
        String outputFormat = "dd MMMM yyyy";

        assertThrows(NullPointerException.class, () -> {
            DateConverter.convertDate(inputDate, inputFormat, outputFormat);
        });
    }

    @Test
    public void negativeTestDateFormatDetection() {
        String inputDate = "03.11.2023";

        String result = DateConverter.detectDateFormat(inputDate);

        assertNull(result);
    }


}