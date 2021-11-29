package crocHomeWork;

import java.util.List;

/**
 * Итоговый проект
 *
 * @author IlyaSlobodyan (SKoSik)
 */
public class Main {
    /**
     * 15 номер в списке
     * Задача, согласно варианту:
     * <p>
     * реализовать JSON парсер
     * #1 Для каждого товара вывести в файл общее количество проданных товаров этого типа
     * #2 Вывести в файл распределение общего количества продаж по датам
     */
    public static void main(String[] args) {
        GsonParser parser = new GsonParser();
        try {
            List<Product> products = parser.parse(Product[].class, "products.json");
            List<Seller> sellers = parser.parse(Seller[].class, "sellers.json");
            List<SellerProduct> sellersProducts = parser.parse(SellerProduct[].class, "sellersProducts.json");
            List<Sale> sales = parser.parse(Sale[].class, "sales.json");

            Market market = new Market(products, sellers, sellersProducts, sales);

            //#1 Файл - numberOfSoldProducts.json
            parser.write(market.numberOfProductsSold(), "numberOfSoldProducts.json");
            //#2 Файл - distributionSalesByDate.json
            parser.write(market.distributionSalesByDate(), "distributionSalesByDate.json");

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
