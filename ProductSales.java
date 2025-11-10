/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsales_q2;

/**
 * Q.2.4: ProductSales class
 */
public class ProductSales implements IProductSales {

    // Data from Q.2.1 data table
    private final int[][] productSales = {
        {800, 150, 700}, // Year 1
        {250, 200, 600}  // Year 2
    };

    // Deduced from the Q.2.2 screenshot (4 under, 2 over)
    // A limit of 650 gives 4 values <= 650 (150, 200, 250, 600)
    // and 2 values > 650 (700, 800).
    private static final int SALES_LIMIT = 650;

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                total += sale;
            }
        }
        return total; // 800+150+700+250+200+600 = 2650
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                if (sale > SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count; // 700, 800 (Count = 2)
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] yearSales : productSales) {
            for (int sale : yearSales) {
                if (sale <= SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count; // 150, 250, 200, 600 (Count = 4)
    }

    @Override
    public int GetProductsProcessed() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            count += productSales[i].length;
        }
        return count; // Total 6 products
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = GetProductsProcessed();
        if (count == 0) {
            return 0.0;
        }
        // 2650 / 6 = 441.66...
        return (double) total / count;
    }
}