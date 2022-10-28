package PatternTest.ProxyTest;


import Pattern.Proxy.ProxyTimeParse;
import Pattern.Proxy.TimeParse;
import Pattern.Proxy.TimeParseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    @Test
    public void returnResultMatchedRegexAndInputData(){
        String resultRes = timeParse.parseElement();
        boolean res = resultRes.matches("^(?!.*0-9.*$)(.*)$");
        Assertions.assertTrue(res, resultRes);
    }


}
