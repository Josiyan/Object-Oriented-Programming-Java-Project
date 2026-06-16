

import java.util.*;
import java.util.logging.Logger;

public class Project {
    private static final Logger LOGGER=Logger.getLogger(Project.class.getName());
    private static final String FLIGHTS_FILE = "flights.txt";
    private static final String BOOKINGS_FILE = "bookings.txt";
    private static final String CANCELLATIONS_FILE = "cancellations.txt";
    private static final String REPORT_FILE = "report.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightManager flightManager = new FlightManager();
        BookingManager bookingManager = new BookingManager();
        ReportManager reportManager = new ReportManager();

        ensureSampleFlightsExist();

        flightManager.loadFlights(FLIGHTS_FILE);
        Map<String, Flight> flights = flightManager.getFlights();

        LOGGER.info("Loaded " + flights.size() + " flights.");

        while (true) {
            showMenu();
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    LOGGER.info("Enter Flight No: ");
                    String fno = sc.nextLine().trim();
                    LOGGER.info("Enter Passenger Name: ");
                    Passenger p1 = new Passenger(sc.nextLine().trim());
                    if (bookingManager.bookTicket(flights, p1, fno, BOOKINGS_FILE))
                        flightManager.saveFlights(FLIGHTS_FILE);
                    break;

                case "2":
                    LOGGER.info("Enter Flight No: ");
                    String cno = sc.nextLine().trim();
                    LOGGER.info("Enter Passenger Name: ");
                    Passenger p2 = new Passenger(sc.nextLine().trim());
                    if (bookingManager.cancelTicket(flights, p2, cno, BOOKINGS_FILE, CANCELLATIONS_FILE))
                        flightManager.saveFlights(FLIGHTS_FILE);
                    break;

                case "3":
                    LOGGER.info("Enter Destination: ");
                    String dest = sc.nextLine().trim();
                    List<Flight> results = flightManager.searchFlightsByDestination(dest);
                    if (results.isEmpty()) {
                        LOGGER.info("No flights found to " + dest + ".");
                    } else {
                        LOGGER.info("Available flights to " + dest + ":");
                        for (Flight f : results) {
                            LOGGER.info(" - " + f.getFlightNo() + " : " + f.getOrigin() + " -> " + f.getDestination() + " (Seats: " + f.getSeats() + ")");
                        }
                    }
                    break;

                case "4":
                    reportManager.generateReport(BOOKINGS_FILE, CANCELLATIONS_FILE, REPORT_FILE);
                    break;

                case "5":
                    if (flights.isEmpty())
                        LOGGER.info("No flights loaded.");
                    else {
                        LOGGER.info("All flights:");
                        for (Flight f : flights.values()) {
                            LOGGER.info(" - " + f.getFlightNo() + " : " + f.getOrigin() + " -> " + f.getDestination() + " (Seats: " + f.getSeats() + ")");
                        }
                    }
                    break;

                case "6":
                    LOGGER.info("Exiting system... Goodbye!");
                    sc.close();
                    return;

                default:
                    LOGGER.info("Invalid choice. Enter 1–6.");
            }
        }
    }

    private static void showMenu() {
        LOGGER.info("\n--- Airline Reservation System ---");
        LOGGER.info("1. Book Ticket");
        LOGGER.info("2. Cancel Ticket");
        LOGGER.info("3. Search Flights (by Destination)");
        LOGGER.info("4. Generate Report");
        LOGGER.info("5. List All Flights");
        LOGGER.info("6. Exit");
        LOGGER.info("Enter choice: ");
    }

    private static void ensureSampleFlightsExist() {
        if (!FileUtils.exists(FLIGHTS_FILE)) {
            LOGGER.info("Creating sample flights.txt...");
            boolean success = FlightFileWriter.writeFile(FLIGHTS_FILE);
            if (success) LOGGER.info("flights.txt created successfully.");
            else  LOGGER.info("Failed to create flights.txt.");
        }
    }
}
