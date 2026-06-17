public class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
<<<<<<< HEAD
        return name;
    }

    @Override
    public String toString() {
        return name;
=======
        return this.name;
    }

    public String toString() {
        return this.name;
>>>>>>> e2b56e2 (Resolve SonarQube issues and update Passenger class)
    }
}
