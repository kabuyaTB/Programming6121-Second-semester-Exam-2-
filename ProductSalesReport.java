/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsales_q1;

/**
 * Q.1.1: Main Java application to produce the report.
 */
public class ProductSalesReport {

    public static void main(String[] args) {
        // 1. Supplied data from Q.1.1
        int[][] productSalesData = {
            {300, 150, 700}, // YEAR 1
            {250, 200, 600}  // YEAR 2
        };

        // 2. Use the class from Q.1.2
        ProductSales calculator = new ProductSales();

        // 3. Calculate all values
        int total = calculator.TotalSales(productSalesData);
        double average = calculator.AverageSales(productSalesData);
        int max = calculator.MaxSale(productSalesData);
        int min = calculator.MinSale(productSalesData);

        // 4. Display the report as per the example
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("---------------------------");
        System.out.printf("Total sales: \t%d%n", total);
        
        // The example screenshot rounds the average (366.66... to 367)
        // We use %.0f to round to the nearest whole number.
        System.out.printf("Average sales: \t%.0f%n", average); 
        System.out.printf("Maximum sale: \t%d%n", max);
        System.out.printf("Minimum sale: \t%d%n", min);
    }
}