import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class LinksCollector extends RecursiveTask<HashSet> {

    HashSet linksRequest = new HashSet<>();
    LinkedList<LinksCollector> taskList = new LinkedList<>();

    public LinksCollector(List linkedList) {
        this.linksRequest.addAll(linkedList);

    }

    @Override
    protected HashSet compute() {
        taskList.addAll(linksRequest);
        LinksCollector linksCollector;
        linksCollector = new LinksCollector(taskList);
        linksCollector.fork();
        Document path = null;
        for (Object link : linksRequest) {
            String s = link.toString();
            try {
                Thread.sleep(140);
                if (!link.toString().isEmpty() && ParserSite.validateLinks(link.toString())) {
                    path = Jsoup.connect(s)
                            .ignoreHttpErrors(true)
                            .get();
                }
            } catch (HttpStatusException h) {
                throw new RuntimeException(h);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            addLinkedList(path);
        }

        return linksRequest;
    }

    private HashSet addLinkedList(Object addToLinkedList) {
        HashSet receivedLinkedList;
        receivedLinkedList = ParserSite.linkedList((Document) addToLinkedList);
        return receivedLinkedList;

    }

}
