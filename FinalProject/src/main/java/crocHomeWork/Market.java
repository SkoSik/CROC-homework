package crocHomeWork;

import java.util.*;

public class Market {
    List<Product> products;
    List<Seller> sellers;
    List<SellerProduct> sellersProducts;
    List<Sale> sales;

    Market(List<Product> products, List<Seller> sellers, List<SellerProduct> sellersProducts, List<Sale> sales) {
        this.products = products;
        this.sellers = sellers;
        this.sellersProducts = sellersProducts;
        this.sales = sales;
    }

    public HashMap<Integer, Integer> numberOfProductsSold() {
        HashMap<Integer, Integer> results = new HashMap<>();
        Collections.sort(sales, Sale.compareByProduct);
        int tmpid = sales.get(0).getProduct(), sum = 0;
        for (Sale sale : sales) {
            if (tmpid != sale.getProduct()) {
                results.put(tmpid, sum);
                tmpid = sale.getProduct();
                sum = 0;
            }
            sum += sale.getNumberOfSold();
        }
        results.put(tmpid, sum);
        return results;
    }

    public HashMap<String, Integer> distributionSalesByDate() {
        HashMap<String, Integer> results = new HashMap<>();
        Collections.sort(sales, Sale.compareByDate);
        int sum = 0;
        String date = sales.get(0).getDate();
        for (Sale sale : sales) {
            if (!date.equals(sale.getDate())) {
                results.put(date, sum);
                date = sale.getDate();
                sum = 0;
            }
            sum += sale.getNumberOfSold();
        }
        results.put(date, sum);
        return results;
    }
}
