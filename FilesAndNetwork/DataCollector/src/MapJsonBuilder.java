import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class MapJsonBuilder {
    static Parser parser = new Parser();

    public static JSONObject BuilderJson() throws IOException {
        parser.CollectJson(Main.pathURL);
        JSONObject mapJson = new JSONObject();

        mapJson.put("stations", parser.stationMsk);
        mapJson.put("connections", BuilderConnection());
        mapJson.put("lines", parser.numberNameLinesMsk);

        return mapJson;
    }

    private static JSONArray BuilderConnection() {

        JSONArray stationsConnection = parser.connectionStation;
        String[] linesFromTo;
        String fromStation;
        String toStation;
        JSONArray connectFromTo = new JSONArray();
        JSONArray connect = null;

        for (Object station : stationsConnection) {
            JSONObject stationConnection = (JSONObject) station;
            fromStation = (String) stationConnection.get("station connection");
            String secondToken = (String) stationConnection.get("connection");
            String[] stations = secondToken.split("«");
            secondToken = stations[1];
            toStation = secondToken.split("»")[0];
            linesFromTo = parser.getNumbersLinesConnections(fromStation, toStation);
            connect = new JSONArray();
            JSONObject fromConnections = new JSONObject();
            JSONObject toConnections = new JSONObject();
            fromConnections.put("line", linesFromTo[0]);
            fromConnections.put("station", fromStation);
            toConnections.put("line", linesFromTo[1]);
            toConnections.put("station", toStation);
            connect.add(fromConnections);
            connect.add(toConnections);
            connectFromTo.add(connect);
        }
        connectFromTo.add(connect);
        return connectFromTo;
    }
}
