/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesreports;

/**
 *
 * @author Kabuy
 */
public class ProductSalesReports {
//This is my main method
    public static void main(String[] args) {
         int[][] sales = {
            {300, 150, 700},  // Year 1
            {250, 200, 600}   // Year 2
        };

        ProductSales ps = new ProductSales();

        int total = ps.TotalSales(sales);
        double average = ps.AverageSales(sales);
        int max = ps.MaxSale(sales);
        int min = ps.MinSale(sales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("----------------------------");
        System.out.println("Total sales:   " + total);
        System.out.println("Average sales: " + Math.round(average));
        System.out.println("Maximum sale:  " + max);
        System.out.println("Minimum sale:  " + min);
    }
}
//@kabuya tambwe josue st10468057
