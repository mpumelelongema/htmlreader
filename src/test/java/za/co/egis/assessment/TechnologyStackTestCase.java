package za.co.egis.assessment;

import junit.framework.TestCase;

import java.util.List;

public class TechnologyStackTestCase extends TestCase
{
    public void testOutputValues()
    {
        TechnologyStack technologyStack = new TechnologyStack();
        technologyStack.setStack("Programming");
        technologyStack.getTechnologies().add("Java");
        technologyStack.getTechnologies().add("COBOL");

        List<String> technologies = technologyStack.getTechnologies();

        assertEquals("Programming", technologyStack.getStack());
        assertTrue(2 == technologies.size());

        assertEquals("Java", technologies.get(0));
        assertEquals("COBOL", technologies.get(1));
    }
}
