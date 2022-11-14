import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
public class StationJsonBuilder {
    static Parser parser = new Parser();
    public static JSONObject BuilderJson() throws IOException, ParseException {
        parser.CollectData(Main.path);
        parser.CollectJson(Main.pathURL);
        JSONObject station = new JSONObject();
        JSONArray stationsArray = new JSONArray();
        JSONObject stationsObject = new JSONObject();
        JSONObject keySetStations = parser.stationMsk;

        for (Object numberLine : keySetStations.keySet()) {
            JSONArray stations = (JSONArray) parser.stationMsk.get(numberLine);
            for (Object nameStation : stations) {
                Object receivedDate = getDateFromJson(nameStation);
                if (receivedDate == null) {
                    receivedDate = getDateFromCSV(nameStation);
                } else {
                    receivedDate = "данные отсутствуют";
                }
                station.put("name", nameStation);
                station.put("line", getNameLineStations(numberLine));
                station.put("date", receivedDate);
                Object receivedDepth = getDepthFromJson(nameStation);
                if (receivedDepth == null) {
                    receivedDepth = getDepthFromCSV(nameStation);
                } else if ((long) receivedDepth > 1000) {
                    receivedDepth = "данные отсутствуют";
                }
                station.put("depth", receivedDepth);
                station.put("hasConnection", getConnection(nameStation));
            }
            stationsArray.add(station);
        }
        stationsObject.put("stations", stationsArray);
        return stationsObject;
    }

    private static String getDateFromJson(Object nameStation) {
        String date = null;
        JSONArray arrayData = parser.jsonData;

        for (Object array : arrayData) {
            JSONArray arrayStation = (JSONArray) array;
            for (Object station1 : arrayStation) {
                JSONObject station = (JSONObject) station1;
                String name = (String) station.get("name");
                String station_name = (String) station.get("station_name");
                if (station_name == null) {
                    date = (String) station.get("date");
                    if (name.equals(nameStation) && date != null) {
                    }
                }
            }
            if (date != null) {
                return date;
            }
        }
        return null;
    }
    private static Object getDepthFromJson(Object nameStation) {

        Object depth;
        JSONArray arrayData = parser.jsonData;

        for (Object array : arrayData) {
            JSONArray arrayStation = (JSONArray) array;
            for (Object station1 : arrayStation) {
                JSONObject station = (JSONObject) station1;
                String name = (String) station.get("name");
                String station_name = (String) station.get("station_name");
                if (station_name == null) {
                    depth = station.get("depth");
                    if (name.equals(nameStation) && depth != null) {
                        depth = getDepthToInteger(depth);
                        return depth;
                    }
                }
                if (name == null) {
                    depth = station.get("depth_meters");
                    if (station_name.equals(nameStation) && depth != null) {
                        depth = getDepthToInteger(depth);

                        return depth;
                    }
                }
            }
        }
        return null;
    }

    private static String getNameLineStations(Object numberLine) {
        JSONArray arrayLines = parser.numberNameLinesMsk;

        for (Object nameNumber : arrayLines) {
            JSONObject lines = (JSONObject) nameNumber;
            String name = (String) lines.get("name");
            String number = (String) lines.get("number");
            if (number.equals(numberLine)) {
                return name;
            }
        }
        return null;
    }

    private static boolean getConnection(Object nameStation) {
        JSONArray stationsConnection = parser.connectionStation;

        for (Object station : stationsConnection) {
            JSONObject stationConnection = (JSONObject) station;
            String connection = (String) stationConnection.get("station connection");
            if (connection.equals(nameStation)) {
                return true;
            }
        }
        return false;
    }

    private static long getDepthToInteger(Object depth) {
        Long longDepth;
        double doubleDepth;

        if ((depth) instanceof String) {
            String stringDepthClear = depth.toString().replaceAll("\"", "");
            stringDepthClear = stringDepthClear.replaceAll(",", ".");
            if (stringDepthClear.equals("?")) {
                long i = 999999999;
                return i;
            }
            if (stringDepthClear.charAt(0) == '−') {
                doubleDepth = Double.parseDouble(stringDepthClear.substring(1));
                longDepth = (long) doubleDepth * (-1);
            } else {
                doubleDepth = Double.parseDouble(stringDepthClear);
                longDepth = (long) doubleDepth;
            }
            return longDepth;
        } else {
            longDepth = (Long) depth;
        }
        return longDepth;
    }

    private static Object getDepthFromCSV(Object nameStation) {
        String depth;
        String[] stringData;
        String station;
        JSONArray arrayData = parser.csvData;

        for (Object array : arrayData) {
            stringData = array.toString().split(",");
            station = stringData[0];
            depth = stringData[1];
            if (station.equals(nameStation) && depth.length() < 6) {
                getDepthToInteger(depth);
                return depth;
            }
        }
        return null;
    }

    private static String getDateFromCSV(Object nameStation) {
        String date;
        String[] stringData;
        String station;
        JSONArray arrayData = parser.csvData;

        for (Object array : arrayData) {
            stringData = array.toString().split(",");
            station = stringData[0];
            date = stringData[1];
            if (station.equals(nameStation) && date.length() > 4) {
                return date;
            }
        }
        return null;
    }
}
