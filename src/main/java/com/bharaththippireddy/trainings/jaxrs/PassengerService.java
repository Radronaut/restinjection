package com.bharaththippireddy.trainings.jaxrs;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.eclipse.jetty.server.Request;

import com.bharathippireddy.trainings.jaxrs.dto.Passenger;
import com.bharathippireddy.trainings.jaxrs.dto.PassengerList;

@Path("/Passenger")
@Produces("application/xml")
public class PassengerService {

	PassengerList passengersList = new PassengerList();

	public PassengerService() {
		init();
	}

	public void init() {
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setId(123);
		passenger.setName("Bharath");
		passengers.add(passenger);
		passengersList.setPassengers(passengers);
	}

	@GET
	public PassengerList getPassengers(@QueryParam("start") int start, @QueryParam("size") int size, @HeaderParam("agent") String agent,
			@Context HttpHeaders headers) {
		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		Set<String> headerNameSet = requestHeaders.keySet();
		
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> names = cookies.keySet();
		for(String name : names){
			cookies.get(name);
			System.out.println(names);
		}
		
		for (String eachHeader : headerNameSet) {
			System.out.println(headers.getHeaderString(eachHeader));
			}
		
		System.out.println(start);
		System.out.println(size);
		return passengersList;
	}

	@POST
	public void addPassenger(@FormParam("firstname") String firstName,@FormParam("lastname") String lastName) {
		System.out.print(firstName);
		System.out.print(lastName);	
	}

}
