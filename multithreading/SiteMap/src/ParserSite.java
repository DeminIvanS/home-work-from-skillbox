import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;

public class ParserSite {

    static HashSet set = new HashSet<>();

    public static long i = 0;

    public static HashSet linkedList(Document pathURL) {

        Elements links;
        links = pathURL.select("a");

        for (Element link : links) {
            String siteLink = link.attr("abs:href");
            String[] path = siteLink.split(":\\\\");
            String pathSite = path[0];
            if (pathSite.contains(Main.withoutProtocol) && !pathSite.isEmpty() && validateLinks(pathSite) && pathSite.contains("http")) {

                if (set.add(pathSite)) {
                    i++;
                    System.out.println(i + " - " + siteLink);
                }

            }
        }

        return set;
    }

    public static boolean validateLinks(String link) {
        boolean s = true;
        if (link.contains(".pdf") || link.contains(".txt") || link.contains(".jp")
                || link.contains("+7") || link.contains(".png")
                || link.contains("800") || (link.charAt(link.length() - 1) != '/') || link.contains("?") || link.contains("malito") || link.isEmpty() || link.contains("tg")
                || link.contains("xml") || !link.contains("//" + Main.withoutProtocol) || link.contains("#") ||
                link.contains(" ") || link.contains("(") || link.contains(")") || link == null) {
            s = false;
        }

        return s;

    }

}
