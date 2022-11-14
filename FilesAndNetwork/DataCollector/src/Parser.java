import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

import static org.apache.logging.log4j.core.util.ArrayUtils.remove;


public class Parser {
    protected final JSONArray numberNameLinesMsk;
    protected final JSONObject stationMsk;
    protected final JSONArray connectionStation;
    protected final JSONArray jsonData;
    protected final JSONArray csvData;


    protected final StringBuilder builderJson;

    public Parser() {
        csvData = new JSONArray();
        jsonData = new JSONArray();
        numberNameLinesMsk = new JSONArray();
        stationMsk = new JSONObject();
        connectionStation = new JSONArray();
        builderJson = new StringBuilder();

    }

    static String stringPath;

    public void CollectJson(Document pathURL) {
        getLinesMetro(pathURL);
        getConnections(pathURL);
        getStationsMetro(pathURL);
    }

    public void CollectData(File path) throws IOException {
        getJsonData(path);
        getCSVData(path);
    }

    private JSONArray getLinesMetro(Document pathURL) {
        Elements lines = pathURL.select("span.js-metro-line");

        lines.forEach(elementLines -> {
            String numberLine = elementLines.attr("data-line");
            String nameLine = elementLines.text();
            JSONObject LinesMsk = new JSONObject();
            LinesMsk.put("number", numberLine);
            LinesMsk.put("name", nameLine);
            numberNameLinesMsk.add(LinesMsk);

        });
        return numberNameLinesMsk;
    }

    private JSONObject getStationsMetro(Document pathURL) {
        final int[] i = {0};
        final Map[] numberNameLine = new Map[1];

        Elements stations = pathURL.select("div.js-metro-stations");
        stations.stream().map(Element::text).forEach(nameStation -> {
            JSONArray stationMetro = new JSONArray();
            String[] tokens = nameStation.split(" ?[0-9]+. ");
            tokens = remove(tokens, 0);
            for (int j = 0; j < tokens.length; j++) {
                stationMetro.add(tokens[j]);
            }
            numberNameLine[0] = (Map) numberNameLinesMsk.get(i[0]);
            i[0]++;
            stationMsk.put(numberNameLine[0].get("number"), stationMetro);

        });
        return stationMsk;
    }

    private JSONArray getConnections(Document pathURL) {
        Elements connection = pathURL.select("span.t-icon-metroln");

        connection.forEach(elementConnection -> {
            String connectionName = elementConnection.attr("title");
            String nameStation = String.valueOf(elementConnection.parent().select("span.name"));
            nameStation = nameStation.split("</span")[0];
            if (connectionName != "") {
                String[] tokens = nameStation.split(">+", 2);
                nameStation = tokens[1];
                JSONObject connectionMetro = new JSONObject();
                connectionMetro.put("connection", connectionName);
                connectionMetro.put("station connection", nameStation);
                connectionStation.add(connectionMetro);

            }
        });
        return connectionStation;
    }

    private static ArrayList getPathsCollector(File path) throws IOException {
        ArrayList paths;
        paths = (ArrayList) Files.walk(Paths.get(String.valueOf(path)))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        return paths;
    }

    private Object getJsonData(File path) throws IOException {
        Object jsonDataFile;

        stringPath = String.valueOf(getPathsCollector(path).size());
        for (int i = 0; i < getPathsCollector(path).size(); i++) {
            stringPath = getPathsCollector(path).get(i).toString().split(",\\s+")[0];
            int index = stringPath.indexOf('.');
            String typeFile = index == -1 ? null : stringPath.substring(index);

            if (typeFile.equals(".json")) {

                try {
                    jsonDataFile = new JSONParser().parse(new FileReader(String.valueOf(Paths.get(stringPath))));
                    jsonData.add(jsonDataFile);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return jsonData;
    }

    private JSONArray getCSVData(File path) throws IOException {

        stringPath = String.valueOf(getPathsCollector(path).size());
        for (int i = 0; i < getPathsCollector(path).size(); i++) {
            stringPath = getPathsCollector(path).get(i).toString().split(",\\s+")[0];
            int index = stringPath.indexOf('.');
            String typeFile = index == -1 ? null : stringPath.substring(index);
            if (typeFile.equals(".csv")) {
                List<String> lines = Files.readAllLines(Paths.get(stringPath));

                lines.forEach(line -> csvData.add(line));
            }
        }
        String string = (String) csvData.get(1);


        return csvData;
    }

    protected String[] getNumbersLinesConnections(Object fromStation, Object toStation) {
        JSONObject arrayLinesStations = stationMsk;
        String[] linesFromTo = new String[2];
        for (Object numberLine : arrayLinesStations.keySet()) {
            ArrayList stationList = (ArrayList) stationMsk.get(numberLine);
            for (Object station : stationList) {
                if (station.equals(fromStation)) {
                    linesFromTo[0] = (String) numberLine;
                }
            }
        }
        for (Object numberLine : arrayLinesStations.keySet()) {
            ArrayList stationList = (ArrayList) stationMsk.get(numberLine);
            for (Object station : stationList) {
                if (station.equals(toStation)) {
                    if (linesFromTo[0] != numberLine) {
                        linesFromTo[1] = (String) numberLine;
                    }
                }

            }
        }
        return linesFromTo;
    }
}