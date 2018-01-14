package app;

import app.service.JSoupService;
import org.junit.Before;
import org.junit.Test;

public class JSoupServiceTest {

    private JSoupService service;

    @Before
    public void setup() {
        service = new JSoupService();
    }

    @Test
    public void getRelatedText() {
        String url = "https://www.mmafighting.com/2018/1/14/16870636/conor-mcgregors-nutritionist-george-lockhart-talks-irishmans-return-early-weigh-ins-more";
        System.out.println(service.getArticleContent(url));
    }
}
