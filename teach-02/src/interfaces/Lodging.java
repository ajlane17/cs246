package interfaces;

public class Lodging implements Expense {

    Destination destination;
    float cost;
    int nights;
    float tax;

    public Lodging(Destination destination, int nights) {

        this.destination = destination;
        switch (this.destination) {
            case Mexico:
                this.cost = 100f;
                this.tax = 1f;
                break;
            case Europe:
                this.cost = 200f;
                this.tax = 1.1f;
                break;
            case Japan:
                this.cost = 300f;
                this.tax = 1.3f;
                break;
        }

        this.nights = nights;

    }

    public float getCost() {
        return cost * nights * tax;
    }
}
