package site.xmy.projects.cs.search.lucene.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.index.LogMergePolicy;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class IndexUtil {
    public static IndexWriter getIndexWriter(String indexPath,boolean create) throws IOException {
        Directory dir = FSDirectory.open(Paths.get(indexPath,new String[0]));
        Analyzer analyzer = new WhitespaceAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        LogMergePolicy mergePolicy = new LogByteSizeMergePolicy();

        mergePolicy.setMergeFactor(50);
        mergePolicy.setMaxMergeDocs(5000);
        if (create)
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        else
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);

        IndexWriter writer = new IndexWriter(dir,iwc);
        return writer;
    }
}
