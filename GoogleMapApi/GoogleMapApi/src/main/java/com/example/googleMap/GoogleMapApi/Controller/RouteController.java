package com.example.googleMap.GoogleMapApi.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.ResponsePath;
import com.graphhopper.reader.osm.GraphHopperOSM;

import jakarta.annotation.PostConstruct;

@RestController
public class RouteController {
   private GraphHopperOSM graphHopperOSRM;

   @PostConstruct
   public void init() {
       graphHopperOSRM = new GraphHopperOSM();
       graphHopperOSRM.setUrl(OSMSettings.DEFAULT_GRAPH_HOPPER_DIRECTORY_GRAPH());
       graphHopperOSRM.load("path/to/your/tiles/folder");
       graphHopperOSRM.importOrLoad();
   }

   @PostMapping("/route")
   public String getRoute(@RequestBody Map<String, String> requestParams) {
       String source = requestParams.get("source");
       String destination = requestParams.get("destination");
       
       GHResponse ghResponse = graphHopperOSRM.route(new GHRequest());
       ResponsePath pathWrapper = ghResponse.getBest();
       
       // Process the response and return the route details as per your requirement
       return pathWrapper.getPoints().toString();
   }
}