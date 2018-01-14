package app.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class JSoupService {

    public Set<String> getLinksOnPage(String url) {
        Set<String> linkStrings = new HashSet<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for(Element link: links){
                linkStrings.add(link.attr("abs:href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linkStrings;
    }

    public String getArticleContent(String url) {
        String content = "";
        try {
            Document doc = Jsoup.connect(url).get();
            Element elContent = doc.select("div.c-entry-content").first();
            content = elContent.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
