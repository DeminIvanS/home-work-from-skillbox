import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


public class Main {
    static FileWriter fileWriter = new FileWriter();
    public static String withoutProtocol;
    static Document pathURL;
    private static final String SITEMAP_TXT = "data/SiteMap.txt";
    public static HashSet hashSet;

    static {
        try {
            pathURL = Jsoup.connect("https://skillbox.ru").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String[] siteLink = pathURL.location().toString().split("://");
        withoutProtocol = siteLink[1];
        ParserSite parser = new ParserSite();
        hashSet = parser.linkedList(pathURL);
        List<Node> firstList = new LinkedList<>();
        firstList.addAll(hashSet);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        forkJoinPool.invoke(new LinksCollector(firstList));
        fileWriter.fileWriter(hashSet);
    }
}


