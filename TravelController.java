package sol;

import src.ITravelController;
import src.TravelCSVParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class TravelController implements ITravelController<City, Transport> {

    // Why is this field of type TravelGraph and not IGraph?
    // Are there any advantages to declaring a field as a specific type rather than the interface?
    // If this were of type IGraph, could you access methods in TravelGraph not declared in IGraph?
    // Hint: perhaps you need to define a method!
    private TravelGraph graph;

    public TravelController() {
    }

    @Override
    public String load(String citiesFile, String transportFile) {
        this.graph = new TravelGraph();
        TravelCSVParser parser = new TravelCSVParser();

        Function<Map<String, String>, Void> addVertex = map -> {
            this.graph.addVertex(new City(map.get("name")));
            return null; // need explicit return null to account for Void type
        };

        // TODO: create a variable that is of type Function<Map<String, String>, Void>
        //       that will build connections between nodes in a graph. Keep in mind
        //       that the input to this function is a hashmap that relates the
        //       COLUMN NAMES of the csv to the VALUE IN THE COLUMN of the csv.
        //       It might be helpful to write a method in this class that takes the
        //       information from the csv needed to create an edge and uses that to
        //       build the edge on the graph.

        try {
            // pass in string for CSV and function to create City (vertex) using city name
            parser.parseLocations(citiesFile, addVertex);
        } catch (IOException e) {
            return "Error parsing file: " + citiesFile;
        }

        // TODO: call parseTransportation with the second Function variable as an argument and
        //  the right file

        // hint: note that parseLocations and parseTransportation can
        //       throw IOExceptions. How can you handle these calls cleanly?

        return "Successfully loaded cities and transportation files.";
    }

    @Override
    public List<Transport> fastestRoute(String source, String destination) {
        // TODO: implement this method!
        return new ArrayList<>();
    }

    @Override
    public List<Transport> cheapestRoute(String source, String destination) {
        // TODO: implement this method!
        return new ArrayList<>();
    }

    @Override
    public List<Transport> mostDirectRoute(String source, String destination) {
        // TODO: implement this method!
        return new ArrayList<>();
    }
}
