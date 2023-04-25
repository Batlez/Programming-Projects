import java.util.Scanner;

public class CurrencyConverter {
    /**
     * This function converts an amount in one currency to another currency based on the exchange rate.
     *
     * @param amount The amount to be converted
     * @param fromCurrency The currency to convert from
     * @param toCurrency The currency to convert to
     * @param exchangeRate The exchange rate between the two currencies
     * @return The converted amount
     */
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency, double exchangeRate) {
        try {
            // Check if the amount is negative
            if (amount < 0) {
                throw new IllegalArgumentException("Amount cannot be negative");
            }
            
            // Check if the currencies are the same
            if (fromCurrency.equals(toCurrency)) {
                throw new IllegalArgumentException("Currencies cannot be the same");
            }
            
            // Calculate and return the converted amount
            return amount * exchangeRate;
        } catch (IllegalArgumentException e) {
            // Log the error
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();
        
        // Get the currency to convert from
        System.out.print("Enter the currency to convert from (e.g. USD): ");
        String fromCurrency = scanner.next();
        
        // Get the currency to convert to
        System.out.print("Enter the currency to convert to (e.g. EUR): ");
        String toCurrency = scanner.next();
        
        // Get the exchange rate
        System.out.print("Enter the exchange rate: ");
        double exchangeRate = scanner.nextDouble();
        
        // Convert the currency and print the result
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency, exchangeRate);
        System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
    }
}