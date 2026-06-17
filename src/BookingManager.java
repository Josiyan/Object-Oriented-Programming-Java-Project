<<<<<<< HEAD
import java.util.*;
=======
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)

public class BookingManager {
    public boolean bookTicket(Map<String, Flight> flights, Passenger passenger, String flightNo, String bookingFile) {
        if (!flights.containsKey(flightNo)) {
            System.out.println("Invalid Flight Number!");
            return false;
<<<<<<< HEAD
        }
        Flight flight = flights.get(flightNo);
        if (flight.getSeats() <= 0) {
            System.out.println("No seats available!");
            return false;
        }
        flight.setSeats(flight.getSeats() - 1);

        Booking booking = new Booking(passenger, flight);
        FileUtils.writeFile(bookingFile, Arrays.asList(booking.toString()), true);
        System.out.println("Booking successful for " + passenger.getName() + " on flight " + flightNo);
        return true;
=======
        } else {
            Flight flight = (Flight)flights.get(flightNo);
            if (flight.getSeats() <= 0) {
                System.out.println("No seats available!");
                return false;
            } else {
                flight.setSeats(flight.getSeats() - 1);
                Booking booking = new Booking(passenger, flight);
                FileUtils.writeFile(bookingFile, Arrays.asList(booking.toString()), true);
                PrintStream var10000 = System.out;
                String var10001 = passenger.getName();
                var10000.println("Booking successful for " + var10001 + " on flight " + flightNo);
                return true;
            }
        }
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
    }

    public boolean cancelTicket(Map<String, Flight> flights, Passenger passenger, String flightNo, String bookingFile, String cancelFile) {
        List<String> bookings = FileUtils.readFile(bookingFile);
<<<<<<< HEAD
        List<String> updated = new ArrayList<>();
        boolean found = false;

        for (String line : bookings) {
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[0].trim().equals(passenger.getName()) && parts[1].trim().equals(flightNo) && !found) {
                found = true;
                continue; // skip (remove booking)
            }
            updated.add(line);
=======
        List<String> updated = new ArrayList();
        boolean found = false;

        for(String line : bookings) {
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[0].trim().equals(passenger.getName()) && parts[1].trim().equals(flightNo) && !found) {
                found = true;
            } else {
                updated.add(line);
            }
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
        }

        if (!found) {
            System.out.println("Booking not found!");
            return false;
<<<<<<< HEAD
        }

        FileUtils.writeFile(bookingFile, updated, false);
        FileUtils.writeFile(cancelFile, Arrays.asList(passenger.getName() + "," + flightNo), true);
        Flight f = flights.get(flightNo);
        if (f != null) f.setSeats(f.getSeats() + 1);
        System.out.println("Ticket for " + passenger.getName() + " on flight " + flightNo + " cancelled.");
        return true;
=======
        } else {
            FileUtils.writeFile(bookingFile, updated, false);
            String[] var10001 = new String[1];
            String var10004 = passenger.getName();
            var10001[0] = var10004 + "," + flightNo;
            FileUtils.writeFile(cancelFile, Arrays.asList(var10001), true);
            Flight f = (Flight)flights.get(flightNo);
            if (f != null) {
                f.setSeats(f.getSeats() + 1);
            }

            PrintStream var10000 = System.out;
            var10001 = new String[]{passenger.getName()};
            var10000.println("Ticket for " + var10001 + " on flight " + flightNo + " cancelled.");
            return true;
        }
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
    }
}
