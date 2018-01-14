package app.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class ContentCheckerService {

    @Autowired
    JSoupService jSoupService;

    public boolean linkHasKey(String key, String url){
        String pageContent = jSoupService.getArticleContent(url);
        List<String> wordsInPage = Arrays.asList(pageContent.split(" "));
        return wordsInPage.contains(key);
    }
}
