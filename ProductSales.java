package com.mycompany.productsalesreports;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class ProductSales implements IproductSales{


    private int[][] salesData;
    private int salesLimit;
    private int yearsProcessed;
    
    public ProductSales(int[][] salesData, int salesLimit) {
        this.salesData = salesData;
        this.salesLimit = salesLimit;
        this.yearsProcessed = salesData.length;
    }
    
    @Override
    public int[][] GetProductSales() {
        return salesData;
    }
    
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int year = 0; year < salesData.length; year++) {
            for (int product = 0; product < salesData[year].length; product++) {
                total += salesData[year][product];
            }
        }
        return total;
    }
    
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int year = 0; year < salesData.length; year++) {
            for (int product = 0; product < salesData[year].length; product++) {
                if (salesData[year][product] > salesLimit) {
                    count++;
                }
            }
        }
        return count;
    }
    
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int year = 0; year < salesData.length; year++) {
            for (int product = 0; product < salesData[year].length; product++) {
                if (salesData[year][product] <= salesLimit) {
                    count++;
                }
            }
        }
        return count;
    }
    
    @Override
    public int GetProductsProcessed() {
        return yearsProcessed;
    }
    
    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int year = 0; year < salesData.length; year++) {
            count += salesData[year].length;
        }
        return count > 0 ? (double) total / count : 0.0;
    }
}

//@kabuya tambwe josue st10468057


