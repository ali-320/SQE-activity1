import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class TestScholarshipMock {

    // Test 13
    @Test
    void mockSetupBehavior() {
        ScholarshipService mockService = mock(ScholarshipService.class);
        when(mockService.isEligible(3.8)).thenReturn(true);

        assertTrue(mockService.isEligible(3.8));
    }

    // Test 14
    @Test
    void mockVerifyCallTimes() {
        ScholarshipService mockService = mock(ScholarshipService.class);

        mockService.isEligible(3.6);
        mockService.isEligible(3.6);

        verify(mockService, times(2)).isEligible(3.6);
    }

    // Test 15
    @Test
    void mockVerifyParameters() {
        ScholarshipService mockService = mock(ScholarshipService.class);

        mockService.getAmount(3.9);

        verify(mockService).getAmount(3.9);
    }
}
