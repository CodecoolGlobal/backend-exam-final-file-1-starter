import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class ExamResultsTest {

    @Test
    void getStudentsNameOrderedByExamResultsAverageReturnsCorrectList(){
        List<String> expected = Arrays.asList(
                "Farkas László",
                "Végh János",
                "Kis Ferenc",
                "Kocsis Anna",
                "dr. Nagy Ivett",
                "Nagy Zoltán",
                "Kis Péter",
                "Kovács Lilla",
                "Csillag István",
                "Kertész József",
                "Kovács Károly Péter");
        List<String> results = ExamResults.getStudentsNameOrderedByExamResultsAverageFromFile("src/main/resources/results.txt");
        assertEquals(expected,results);
    }

    @Test
    void correctErrorMessageForFileNotFound(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        ExamResults.getStudentsNameOrderedByExamResultsAverageFromFile("src/main/resources/notExisting.txt");
        assertEquals("File not found!",outputStreamCaptor.toString()
                .trim());
    }
}