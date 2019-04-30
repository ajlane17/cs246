package interfaces;

public class Cruise implements Expense {
    Destination destination;
    double cost;

    public Cruise(Destination destination) {

        this.destination = destination;

        switch (this.destination) {
            case Mexico:
                this.cost = 1000;
                break;
            case Europe:
                this.cost = 2000;
                break;
            case Japan:
                this.cost = 3000;
                break;
        }
    }
}
