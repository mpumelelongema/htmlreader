package za.co.egis.assessment.util;

import junit.framework.TestCase;
import za.co.egis.assessment.TechnologyStack;

public class JacksonUtilTestCase extends TestCase
{
    public void testConvertAndPrintObjectToJson()
    {
        TechnologyStack technologyStack = new TechnologyStack();
        technologyStack.setStack("Programming");
        technologyStack.getTechnologies().add("Java");
        technologyStack.getTechnologies().add("COBOL");

        String result = "{\"stack\":\"Programming\",\"technologies\":[\"Java\",\"COBOL\"]}";

        String converted = JacksonUtil.convertAndPrintObjectToJson(technologyStack);
        assertEquals(result, converted);
    }
}
