package za.co.egis.assessment;

import junit.framework.TestCase;

public class HtmlReaderTestCase extends TestCase
{
    public void testReadHtmlTable()
    {
        String expected = "[{\"stack\":\"Programming\",\"technologies\":[\"Java 8 / JVM\",\"Groovy\",\"Egis Kernel\"," +
                "\"Hibernate / JPA\",\"Jetty\",\"Hazelcast\",\"PostgreSQL / MySQL / SQL Server\",\"Lucene\",\"TestNG\",\"C#\"," +
                "\"Golang\",\"Python\",\"Markdown\",\"Gitbook\",\"ES6 / Babel\",\"NPM\",\"Gulp\",\"Webdriver\",\"Karma / Jasmine\"," +
                "\"ExtJS\",\"Angular (1 or 2)\",\"Vue.js\",\"Polymer 2.0\",\"React\"]},{\"stack\":\"Build\",\"technologies\":[\"Gradle\"," +
                "\"Ant\",\"Babel Gulp\",\"npm\",\"Github\",\"CircleCI\",\"AppVeyor\",\"Jenkins\",\"Codacy\",\"Codecov\",\"Amazon S3\"]}," +
                "{\"stack\":\"Infrastructure\",\"technologies\":[\"Ubuntu LTS\",\"Docker\",\"PostgreSQL\",\"ansible\",\"VMWare ESXi\"," +
                "\"VMWare vCenter\",\"Amazon EC2\",\"Amazon S3\",\"Amazon DynomoDB\",\"Cloudflare\",\"Google Drive\",\"Sendgrid\",\"Google Apps\"," +
                "\"Hipchat\",\"Trello\",\"Fortigate\",\"Dell\",\"Docker Hub\"]},{\"stack\":\"monitoring\",\"technologies\":[\"Dripstat\",\"Plumbr\"," +
                "\"Newrelic\",\"Pagerduty\",\"Nodegrid\",\"health dashboard\"]}]";

        HtmlReader reader = new HtmlReader();
        String result = reader.readHtmlTable("https://github.com/egis/handbook/blob/master/Tech-Stack.md");

        assertEquals(expected, result);
    }
}
