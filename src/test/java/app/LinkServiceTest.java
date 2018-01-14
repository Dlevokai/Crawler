package app;

import app.service.JSoupService;
import app.service.LinkService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class LinkServiceTest {

    private JSoupService jSoupService;
    private LinkService linkService;
    private static final String url = "https://www.mmafighting.com/2018/1/14/16870636/conor-mcgregors-nutritionist-george-lockhart-talks-irishmans-return-early-weigh-ins-more";

    @Before
    public void setup() {
        jSoupService = new JSoupService();
        linkService = new LinkService(jSoupService);
    }

    @Test
    public void getLinks(){
        linkService.getLinks("http://mmafighting.com", "McGregor").forEach(System.out::println);
    }

    @Test
    public void linkHasKey(){
        assertTrue(linkService.linkHasKey("UFC", url));
        assertFalse(linkService.linkHasKey("ROGGLE BLOGGLE HIT MY DOGGLE", url));
    }



}
