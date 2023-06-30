package site.xmy.projects.cs.search.lucene.service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.xmy.projects.cs.search.lucene.entity.Book;
import site.xmy.projects.cs.search.lucene.index.BookIndex;
import site.xmy.projects.cs.search.lucene.util.SearchUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SearchService {

    private String indexPath = "D:/lucene/index";

    @Autowired
    private BookIndex bookIndex;

    public void write(List<Book> books) throws Exception {
        bookIndex.indexDoc(books);
    }

    public List<Map> search(String value) {
        List<Map> list = new ArrayList<>();
        ExecutorService service = Executors.newCachedThreadPool();
        Analyzer analyzer = new WhitespaceAnalyzer();
        try {
            IndexSearcher searcher = SearchUtil.getIndexSearcher(indexPath, service);
            String[] fields = {"title", "summary"};

            MultiFieldQueryParser parser = new MultiFieldQueryParser(fields, analyzer);
            Query query = parser.parse(value);
            TopDocs results = searcher.search(query,1000);
            ScoreDoc[] hits = results.scoreDocs;

            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = searcher.doc(hits[i].doc);
                Map map = new HashMap();

                map.put("id",hitDoc.get("id"));

                map.put("summary",hitDoc.get("summary"));
                map.put("title",hitDoc.get("title"));

                list.add(map);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            service.shutdownNow();
        }

        return list;
    }
}
