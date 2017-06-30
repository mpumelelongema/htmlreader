package za.co.egis.assessment.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    public static String convertAndPrintObjectToJsonPrettyPrint(Object object) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed converting Object to JSON String" + e.getMessage());
        }
    }

    public static String convertAndPrintObjectToJson(Object object) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(object);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed converting Object to JSON String" + e.getMessage());
        }
    }
}
