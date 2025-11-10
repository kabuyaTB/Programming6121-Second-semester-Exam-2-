/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package productsales_q2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Q.2.5: Unit tests
 */
public class ProductSalesTest {
    
    private ProductSales instance;
    
    @BeforeEach
    public void setUp() {
        // Create a new instance for each test
        instance = new ProductSales();
    }

    /**
     * Test Name: GetSalesOverLimit_ReturnsNumberOfSales
     * Test Purpose: To determine that the correct values
     * are returned when the GetSalesOverLimit method is called.
     */
    @Test
    public void testGetSalesOverLimit_ReturnsNumberOfSales() {
        System.out.println("Test: GetSalesOverLimit");
        // From our data and logic, we expect 2 (700, 800)
        int expected = 2;
        int result = instance.GetSalesOverLimit();
        assertEquals(expected, result);
    }

    /**
     * Test Name: GetSalesUnderLimit_ReturnsNumberOfSales
     * Test Purpose: To determine that the correct values
     * are returned when the GetSalesUnderLimit method is called.
     */
    @Test
    public void testGetSalesUnderLimit_ReturnsNumberOfSales() {
        System.out.println("Test: GetSalesUnderLimit");
        // From our data and logic, we expect 4 (150, 250, 200, 600)
        int expected = 4;
        int result = instance.GetSalesUnderLimit();
        assertEquals(expected, result);
    }
}