import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.io.FilterOutputStream;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
    Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport);


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        List<Flight> flightList = new ArrayList<>();
        airport.getTerminals().forEach((t -> t.getFlights().stream()
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> f.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime()
                        .isBefore(LocalTime.now().plusHours(2))&&
                                f.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalTime()
                                        .isAfter(LocalTime.now()))
                .forEach(flightList::add)));

        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        return flightList;
    }

}