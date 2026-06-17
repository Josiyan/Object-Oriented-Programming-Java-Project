public class Flight {
    private String flightNo;
    private String origin;
    private String destination;
    private int seats;

    public Flight(String flightNo, String origin, String destination, int seats) {
        this.flightNo = flightNo;
        this.origin = origin;
        this.destination = destination;
        this.seats = seats;
    }

<<<<<<< HEAD
    public String getFlightNo() { return flightNo; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public int getSeats() { return seats; }

    public void setSeats(int seats) { this.seats = seats; }

    @Override
    public String toString() {
        return flightNo + "," + origin + "," + destination + "," + seats;
=======
    public String getFlightNo() {
        return this.flightNo;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String toString() {
        return this.flightNo + "," + this.origin + "," + this.destination + "," + this.seats;
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
    }
}
