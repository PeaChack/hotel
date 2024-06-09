package by.peachack.hotel.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelSearchCriteriaTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testCriteriaWithOneField() throws Exception {
        String jsonString = """
                {
                "name": "Hotel California"
                }""";

        HotelSearchCriteria criteria = mapper.readValue(jsonString, HotelSearchCriteria.class);

        assertNotNull(criteria);
        assertEquals("Hotel California", criteria.getName());
        assertNull(criteria.getBrand());
        assertNull(criteria.getCity());
        assertNull(criteria.getCountry());
        assertNull(criteria.getAmenities());
    }

    @Test
    public void testCriteriaWithMultipleFields() throws Exception {
        String jsonString = """
                {
                   "name": "Hotel California",
                   "city": "Los Angeles"
                }""";

        HotelSearchCriteria criteria = mapper.readValue(jsonString, HotelSearchCriteria.class);

        assertNotNull(criteria);
        assertEquals("Hotel California", criteria.getName());
        assertEquals("Los Angeles", criteria.getCity());
        assertNull(criteria.getBrand());
        assertNull(criteria.getCountry());
        assertNull(criteria.getAmenities());
    }

    @Test
    public void testCriteriaWithAllFields() throws Exception {
        String jsonString = """
                {
                    "name": "Hotel California",
                    "brand": "Luxury",
                    "city": "Los Angeles",
                    "country": "USA",
                    "amenities": ["Pool", "Gym"]
                }""";

        HotelSearchCriteria criteria = mapper.readValue(jsonString, HotelSearchCriteria.class);

        assertNotNull(criteria);
        assertEquals("Hotel California", criteria.getName());
        assertEquals("Luxury", criteria.getBrand());
        assertEquals("Los Angeles", criteria.getCity());
        assertEquals("USA", criteria.getCountry());
        assertNotNull(criteria.getAmenities());
        assertEquals(2, criteria.getAmenities().size());
        assertTrue(criteria.getAmenities().contains("Pool"));
        assertTrue(criteria.getAmenities().contains("Gym"));
    }

    @Test
    public void testCriteriaWithEmptyJson() {
        String jsonString = "{}";

        ValueInstantiationException exception = assertThrows(ValueInstantiationException.class, () -> {
            mapper.readValue(jsonString, HotelSearchCriteria.class);
        });

        Throwable cause = exception.getCause();
        assertInstanceOf(IllegalArgumentException.class, cause);
        assertEquals("At least one search criteria must be provided", cause.getMessage());
    }

    @Test
    public void testCriteriaWithNullFields() {
        String jsonString = """
                {
                    "name": null,
                    "brand": null,
                    "city": null,
                    "country": null,
                    "amenities": null
                }""";

        ValueInstantiationException exception = assertThrows(ValueInstantiationException.class, () -> {
            mapper.readValue(jsonString, HotelSearchCriteria.class);
        });

        Throwable cause = exception.getCause();
        assertInstanceOf(IllegalArgumentException.class, cause);
        assertEquals("At least one search criteria must be provided", cause.getMessage());
    }
}