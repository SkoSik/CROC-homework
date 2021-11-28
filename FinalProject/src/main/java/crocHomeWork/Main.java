package crocHomeWork;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GsonParser parser = new GsonParser();
        try {
            List<Product> products = parser.parseProducts();
            List<Seller> sellers = parser.parseSellers();
            List<SellerProduct> sellerProducts = parser.parseSellerProduct();
            List<Sale> sales = parser.parseSales();

            Market market = new Market(products, sellers, sellerProducts, sales);

            parser.writeNumberOfSoldProducts(market.numberOfProductsSold());
            parser.writeDistributionSalesByDate(market.distributionSalesByDate());

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
