package za.co.egis.assessment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import za.co.egis.assessment.util.JacksonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlReader {
    public static void main(String[] args) {

        HtmlReader reader = new HtmlReader();
        System.out.println(reader.readHtmlTable("https://github.com/egis/handbook/blob/master/Tech-Stack.md"));
    }

    public String readHtmlTable(String link) {
        List<TechnologyStack> technologyStacks = new ArrayList<>();

        try {

            Document doc = Jsoup.connect(link)
                    .validateTLSCertificates(false)
                    .get();

            for (Element html : doc.select("html"))
                for (Element body : html.select("body")) {

                    technologyStacks.add(getStack(body,"Programming", 0));
                    technologyStacks.add(getStack(body,"Build", 1));
                    technologyStacks.add(getStack(body,"Infrastructure", 2));
                    technologyStacks.add(getStack(body,"Monitoring", 3));
                }

            return JacksonUtil.convertAndPrintObjectToJson(technologyStacks);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed reading table from URL: "+e.getCause());
        }
    }

    private TechnologyStack getStack(Element body, String name, int index)
    {
        TechnologyStack stack = new TechnologyStack();
        stack.setStack(name);

        Element monitoringTable = body.select("table").select("tbody").get(index);
        for (Element row : monitoringTable.select("tr")) {
            Elements data = row.select("td");
            stack.getTechnologies().add(data.get(0).text());
        }

        return stack;
    }
}
