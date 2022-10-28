package Pattern.Proxy;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

/**
 * Class for get actual Time
 */
public class TimeParseImpl implements TimeParse {

    /**
     * get page from URL and read in file
     *
     * @return Read page with JSoup
     */
    private Document getPage() {
        String url = "https://time100.ru/Moscow";

        try {
            return Jsoup.parse(new URL(url), 3000);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get read page and parsed
     * field Time and Date
     *
     * @return Strings current time and current date
     */

    @Override
    public String parseElement() {

        Document page = getPage();

        Element tableTime = page.select("header").first();

        String currentTime = null;
        String currentDate = null;
        if (tableTime != null) {
            Element valueTime = tableTime.select("span.time").first();
            Element valueDate = tableTime.select("span.time").last();

            if (valueTime != null) {
                for (Element e : valueTime.select("span.time")) {
                    currentTime = e.text();
                }
            }
            if (valueDate != null) {
                for (Element e : valueDate.select("span.time")) {
                    currentDate = e.text().toUpperCase();
                }
            }
        }
        return currentTime + " " + currentDate;
    }

}
