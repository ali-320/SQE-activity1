import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestScholarshipStub {

    // Test 11
    @Test
    void scholarshipEligibilityStub() {
        ScholarshipService service = new ScholarshipServiceStub();
        assertTrue(service.isEligible(3.6));
        assertFalse(service.isEligible(3.2));
    }

    // Test 12
    @Test
    void scholarshipAmountStub() {
        ScholarshipService service = new ScholarshipServiceStub();
        assertEquals(5000.0, service.getAmount(3.9));
        assertEquals(3000.0, service.getAmount(3.5));
        assertEquals(0.0, service.getAmount(3.0));
    }
}
