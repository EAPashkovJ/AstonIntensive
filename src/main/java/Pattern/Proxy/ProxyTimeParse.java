package Pattern.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProxyTimeParse implements TimeParse {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyTimeParse.class);
    TimeParseImpl timeParse = new TimeParseImpl();


    /*
    Add new functional Logger
     */
    @Override
    public String parseElement() {
        try {
            LOGGER.info("Current time:");
            String result = timeParse.parseElement();
            return result + " ";
        } catch (Exception e) {
            LOGGER.error("Parse error");
        }
        return "Parse error";
    }
}
