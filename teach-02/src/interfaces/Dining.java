package interfaces;


public class Dining implements Expense {
    Destination destination;
    float cost;
    int nights;

    public Dining (Destination destination, int nights)
    {
        this.destination = destination;
        switch (this.destination) {
            case Mexico:
                this.cost = 10f;
                break;
            case Europe:
                this.cost = 20f;
                break;
            case Japan:
                this.cost = 30f;
                break;
        }

        this.nights = nights;
    }

    public float getCost() {
        return cost * nights;
    }
}
