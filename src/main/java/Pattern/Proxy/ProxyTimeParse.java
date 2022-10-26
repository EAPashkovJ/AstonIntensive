package Pattern.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProxyTimeParse implements TimeParse{


    private static final Logger LOGGER = LoggerFactory.getLogger(TimeParse.class);
    TimeParseImpl timeParse = new TimeParseImpl();


    /*
    Add new functional Logger
     */
    @Override
    public void parseElement() {
        try {
            LOGGER.info("Time:");
            timeParse.parseElement();
        }catch (Exception e){
            LOGGER.error("Parse error");
        }

    }
}
