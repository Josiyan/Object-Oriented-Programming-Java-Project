public class Booking {
    private Passenger passenger;
    private Flight flight;
//Fix SonarQube issues and update Booking clas
    public Booking(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public Passenger getPassenger() {
<<<<<<< HEAD
        return passenger;
    }
    public Flight getFlight() {
        return flight;
    }

    @Override
    public String toString() {
        return passenger.getName() + "," + flight.getFlightNo();
=======
        return this.passenger;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public String toString() {
        String var10000 = this.passenger.getName();

        return var10000 + "," + this.flight.getFlightNo();
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
    }
}
