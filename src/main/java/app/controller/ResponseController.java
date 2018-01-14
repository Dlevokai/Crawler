package app.controller;

import app.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ResponseController {

    @Autowired
    LinkService urlGetter;

    private static final String url = "http://mmafighting.com";

    @GetMapping("/getLinks/{key}")
    public String getUrl(@PathVariable String key) {
        Set<String> linksWithKeyReference = urlGetter.getLinks(url, key);
        StringBuilder sb = new StringBuilder();
        for (String s : linksWithKeyReference){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
