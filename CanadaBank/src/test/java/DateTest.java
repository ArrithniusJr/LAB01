import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateTest {
    @Test
    public void testValidDate() {
        Date date = new Date(2024, 5, 14);
        assertEquals(14, date.getDay());
        assertEquals(5, date.getMonth());
        assertEquals(2024, date.getYear());
        assertEquals("2024-05-14", date.getYYYYMMDD());
        assertEquals(Date.THURSDAY, date.getDayOfTheWeek());
    }

    @Test
    public void testInvalidYear() {
        assertThrows(IllegalArgumentException.class, () -> new Date(0, 5, 14));
    }

    @Test
    public void testInvalidMonth() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 13, 14));
    }

    @Test
    public void testInvalidDay() {
        assertThrows(IllegalArgumentException.class, () -> new Date(2024, 5, 32));
    }
}
