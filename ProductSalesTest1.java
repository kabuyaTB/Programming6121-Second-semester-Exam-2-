/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package productsales_q1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Q.1.3: Unit tests for the application.
 */
public class ProductSalesTest1 {

    // Test data from Q.1.1
    private final int[][] testData = {
        {300, 150, 700},
        {250, 200, 600}
    };
    
    // Expected results
    // Total = 300+150+700+250+200+600 = 2200
    // Avg = 2200 / 6 = 366.66...
    private final int expectedTotal = 2200;
    private final double expectedAverage = 2200.0 / 6.0;

    /**
     * Test Name: CalculateTotalSales_ReturnsTotalSales
     * Test Purpose: Supply the product sales data to the total product
     * sales method... [determines] correct total sales value is returned.
     */
    @Test
    public void testCalculateTotalSales_ReturnsTotalSales() {
        System.out.println("Test: TotalSales");
        ProductSales instance = new ProductSales();
        int result = instance.TotalSales(testData);
        assertEquals(expectedTotal, result);
    }

    /**
     * Test Name: AverageSales_ReturnsAverageProductSales
     * Test Purpose: Supply the product sales data to the average sales
     * method... [determines] correct average sales value is returned.
     */
    @Test
    public void testAverageSales_ReturnsAverageProductSales() {
        System.out.println("Test: AverageSales");
        ProductSales instance = new ProductSales();
        double result = instance.AverageSales(testData);
        // Use a "delta" (margin of error) for comparing doubles
        assertEquals(expectedAverage, result, 0.01);
    }
}