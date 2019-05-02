package interfaces;

import java.util.ArrayList;
import java.util.List;

public class VacationCalculator {

    public static void main(String[] args) {
        VacationCalculator vc = new VacationCalculator();

        // Calculate some vacation costs...
        float japanCost = vc.calculateVacationCost(Destination.Japan, 5);

        // Print the cost...
        System.out.format("The vacation cost is: $%.2f.%n", japanCost);
    }

    /**
     * Calculates the total cost for vacationing at a given location for
     * a specific number of nights.
     *
     * @param  dest the destination of the vacation
     * @return      the total cost of the vacation
     */
    public float calculateVacationCost(Destination dest, int nights)
    {
        float totalCost = 0;

        Cruise cruise = new Cruise(dest);
        Dining dining = new Dining(dest, nights);
        Lodging lodging = new Lodging(dest, nights);

        ArrayList<Expense> expenseArrayList = new ArrayList<>();
        expenseArrayList.add(cruise);
        expenseArrayList.add(dining);
        expenseArrayList.add(lodging);

        totalCost = tallyExpenses(expenseArrayList);
        return totalCost;
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
        float total = 0;
        for (Expense expense : expenses) {
            total += expense.getCost();
        }
        return total;
    }

}
