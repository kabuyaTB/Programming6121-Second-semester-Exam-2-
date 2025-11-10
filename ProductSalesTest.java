/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


package productsalesapplication;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductSalesTest {
    
    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},  // Year 1
            {250, 200, 600}   // Year 2
        };
        int salesLimit = 500;
        ProductSales productSales = new ProductSales(testData, salesLimit);
        
        // Act
        int result = productSales.GetSalesOverLimit();
        
        // Assert
        assertEquals(2, result); // 700 and 600 are over 500
    }
    
    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},  // Year 1
            {250, 200, 600}   // Year 2
        };
        int salesLimit = 500;
        ProductSales productSales = new ProductSales(testData, salesLimit);
        
        // Act
        int result = productSales.GetSalesUnderLimit();
        
        // Assert
        assertEquals(4, result); // 300, 150, 250, 200 are under/equal to 500
    }
    
    @Test
    public void GetTotalSales_ReturnsCorrectTotal() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},
            {250, 200, 600}
        };
        ProductSales productSales = new ProductSales(testData, 500);
        
        // Act
        int result = productSales.GetTotalSales();
        
        // Assert
        assertEquals(2200, result);
    }
    
    @Test
    public void GetAverageSales_ReturnsCorrectAverage() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},
            {250, 200, 600}
        };
        ProductSales productSales = new ProductSales(testData, 500);
        
        // Act
        double result = productSales.GetAverageSales();
        
        // Assert
        assertEquals(366.67, result, 0.01);
    }
    
    @Test
    public void GetProductsProcessed_ReturnsNumberOfYears() {
        // Arrange
        int[][] testData = {
            {300, 150, 700},
            {250, 200, 600}
        };
        ProductSales productSales = new ProductSales(testData, 500);
        
        // Act
        int result = productSales.GetProductsProcessed();
        
        // Assert
        assertEquals(2, result);
    }
}