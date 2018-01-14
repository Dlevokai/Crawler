package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LinkService {

    private JSoupService jSoupService;

    @Autowired
    public LinkService(JSoupService service){
        jSoupService = service;
    }

    public Set<String> getLinks(String url, String key) {
        Set<String> linkStrings = jSoupService.getLinksOnPage(url);
        linkStrings = linkStrings.stream().filter(link -> link.contains(todaysDate()) && !link.contains("#comments")).filter(link -> linkHasKey(key, link)).collect(Collectors.toSet());
        return linkStrings;
    }

    public boolean linkHasKey(String key, String url){
        String pageContent = jSoupService.getArticleContent(url);
        List<String> wordsInPage = Arrays.asList(pageContent.split(" "));
        return wordsInPage.contains(key);
    }

    private String todaysDate() {
        DateFormat dateFormat = new SimpleDateFormat("/yyyy/M/d");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
