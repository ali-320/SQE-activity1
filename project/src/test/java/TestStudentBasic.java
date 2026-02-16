import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStudentBasic {

    private Student student;

    @BeforeEach
    void setup() {
        student = new Student("S001", "Ali", 3.6);
    }

    // Test 1
    @Test
    void constructorCreatesStudent() {
        Student s = new Student("S002", "Sara", 3.2);
        assertEquals("S002", s.getStudentId());
        assertEquals("Sara", s.getName());
        assertEquals(3.2, s.getGpa());
    }

    // Test 2
    @Test
    void constructorThrowsForEmptyId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("", "Ali", 3.0));
    }

    // Test 3
    @Test
    void constructorThrowsForInvalidGpa() {
        assertThrows(IllegalArgumentException.class,
                () -> new Student("S003", "Ali", 4.5));
    }

    // Test 4
    @Test
    void getGradeLetterReturnsA() {
        Student s = new Student("S004", "Ali", 3.7);
        assertEquals("A", s.getGradeLetter());
    }

    // Test 5
    @Test
    void getGradeLetterVarious() {
        assertEquals("B", new Student("S1", "X", 3.2).getGradeLetter());
        assertEquals("C", new Student("S2", "X", 2.5).getGradeLetter());
        assertEquals("D", new Student("S3", "X", 1.5).getGradeLetter());
        assertEquals("F", new Student("S4", "X", 0.8).getGradeLetter());
    }

    // Test 6
    @Test
    void isPassedReturnsTrue() {
        assertTrue(new Student("S5", "Ali", 2.5).isPassed());
    }

    // Test 7
    @Test
    void isPassedReturnsFalse() {
        assertFalse(new Student("S6", "Ali", 1.9).isPassed());
    }

    // Test 8
    @Test
    void updateGpaSucceeds() {
        assertTrue(student.updateGpa(3.9));
        assertEquals(3.9, student.getGpa());
    }

    // Test 9
    @Test
    void updateGpaFails() {
        assertFalse(student.updateGpa(5.0));
        assertEquals(3.6, student.getGpa());
    }

    // Test 10
    @Test
    void updateGpaBoundaryValues() {
        assertTrue(student.updateGpa(0.0));
        assertTrue(student.updateGpa(4.0));
        assertFalse(student.updateGpa(-0.1));
        assertFalse(student.updateGpa(4.1));
    }
}
