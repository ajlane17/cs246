package interfaces;

public class Cruise implements Expense {
    Destination destination;
    float cost;

    public Cruise(Destination destination) {

        this.destination = destination;

        switch (this.destination) {
            case Mexico:
                this.cost = 1000f;
                break;
            case Europe:
                this.cost = 2000f;
                break;
            case Japan:
                this.cost = 3000f;
                break;
        }
    }

    public float getCost() {
        return cost;
    }
}
