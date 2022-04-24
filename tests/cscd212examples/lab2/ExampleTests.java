package cscd212examples.lab2;


import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * This is to show some example Junit tests not just for lab 2
 * NOTE: this is java doc comments
 */
@DisplayName("Example Junit Tests")
public class ExampleTests {

    /**
     * Showing of assertEquals that will fail with a message
     * @see org.junit.Assert#assertEquals(String, Object, Object)
     */
    @Test
    @DisplayName("Show assert equals")
    void showEquals() {
        assertEquals("Expected", "Actual",
                "Message: The string \"Actual\" is not equal to \"Expected\"");
    }

    /**
     * Showing of assertThrows
     * @see org.junit.Assert#assertThrows(String, Class, ThrowingRunnable)
     * @see org.junit.Assert#assertEquals(String, Object, Object)
     */
    @Test
    @DisplayName("Show assert Throws")
    void showThrows() {
        Throwable exception = assertThrows(
                "Failed - Code did not throw IllegalArgumentException",
                IllegalArgumentException.class, () -> {
                    // Some code that throw
                    throw new IllegalArgumentException("Throws Message");
                });

        assertEquals("Failed - message is wrong",
                "Throws Message",
                exception.getMessage());
    }

    /**
     * Showing how to write one test for testing mutable things
     * @param first first value to add
     * @param second second value to add
     * @param expectedResult the result from the add
     * @see org.junit.Assert#assertEquals(String, Object, Object)
     */
    @ParameterizedTest(name = "Mutable test: {0} + {1} = {2}")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3"
    })
    @DisplayName("Doing mutable Test using one method")
    void mutableTestsInOneMethod(final int first, final int second, final int expectedResult) {
        assertEquals(expectedResult, first+second);
    }

    /**
     * Showing a nested that lets us group up junit tests
     */
    @Nested
    @DisplayName("Nested junit tests")
    class NestedTests {

        String testString;
        private ByteArrayOutputStream bos;
        private PrintStream originalOut;

        /**
         * Before each junit test in this nested test it will run this code
         */
        @BeforeEach
        void setUp() {
            this.testString = "Spokane";

            this.originalOut = System.out;
            this.bos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(this.bos));
        }

        /**
         * After each of these junit test it will run this code to not mess with other junit tests
         */
        @AfterEach
        void teardown() {
            this.testString = null;
            System.setOut(this.originalOut);
        }


        /**
         * Showing both a test in Nested and show how we can test print out
         * @see org.junit.Assert#assertEquals(String, Object, Object)
         */
        @Test
        @DisplayName("Showing both a test in Nested and show how we can test print out")
        void testPrint() {
            System.out.print(this.testString);
            assertEquals(this.testString, this.bos.toString());
        }

    }
}
