package site.xmy.projects.cs.search.lucene.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.xmy.projects.cs.search.lucene.entity.Book;
import site.xmy.projects.cs.search.lucene.service.SearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    SearchService searchService;

    @GetMapping("/index")
    public String createIndex() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"hello","this is hello book"));
        books.add(new Book(2,"yellow sky","this is yellow sky book"));

        searchService.write(books);
        return "创建索引成功";
    }

    @GetMapping("/search/{query}")
    public List<Map> queryIndex(@PathVariable("query") String query){
        return searchService.search(query);
    }
}
