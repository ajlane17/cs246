package interfaces;

import java.util.List;

public class VacationCalculator {

    public static void main(String[] args) {
        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float japanCost = vc.calculateVacationCost(Destination.Japan);

        // Print the cost...
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest)
    {
        return 0.0f;
    }

    /**
     * An internal method used by VacationCalculator to loop through
     * a List of items that implement the Expense interface and
     * determine their cost
     *
     * @param  expenses A list of items that implement the Expense interface
     * @return          the total cost calculated by the items
     */
    float tallyExpenses(List<Expense> expenses)
    {
        return 0.0f;
    }
}
