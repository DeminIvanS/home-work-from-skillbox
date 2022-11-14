import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static File path = new File("C:\\Users\\Ivan\\IdeaProjects\\" +
            "java_basics\\FilesAndNetwork\\DataCollector\\data");
    static Document pathURL;

    static {
        try {
            pathURL = Jsoup.connect("https://skillbox-java.github.io/").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {

            Files.write(Paths.get("map.json"), MapJsonBuilder.BuilderJson().toJSONString().getBytes());
            Files.write(Paths.get("stations.json"), StationJsonBuilder.BuilderJson().toJSONString().getBytes());

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

    }

}





