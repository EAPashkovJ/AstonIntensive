package PatternTest;


import Pattern.Proxy.ProxyTimeParse;
import Pattern.Proxy.TimeParse;
import Pattern.Proxy.TimeParseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TimeParseImplTest {
    TimeParse timeParse;

    @BeforeEach
    public void getNewParser () {
        timeParse = new ProxyTimeParse();
    }

    @Test
    public void parserShouldReturnFalseCompareOrdinaryAndProxyParser(){
      String resultProxy = timeParse.parseElement();
      TimeParse resultOrdinary = new TimeParseImpl();
      Assertions.assertNotEquals(resultOrdinary, resultProxy);

    }


}
