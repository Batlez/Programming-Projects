/**
 * This function takes a list of expenses and a budget limit as input and returns a summary of the expenses.
 * 
 * @param expenses An array of integers representing the expenses
 * @param budget An integer representing the budget limit
 * @return A string summarizing the expenses and whether the budget limit was exceeded or not
 */
public static String budgetTracker(int[] expenses, int budget) {
    int totalExpenses = 0;
    for (int expense : expenses) {
        totalExpenses += expense;
    }
    String summary = "Total expenses: " + totalExpenses + "\n";
    if (totalExpenses > budget) {
        summary += "Budget limit exceeded!";
    } else {
        summary += "Budget limit not exceeded.";
    }
    return summary;
}