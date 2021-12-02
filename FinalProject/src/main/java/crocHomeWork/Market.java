package crocHomeWork;

import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Задание #1 - Для каждого товара вывести в файл общее количество проданных товаров этого типа
     * <p>
     * Собираем и вовзвращаем LinkedHashMap результатов в виде пар (ID продукта - Кол-во проданных товаров)
     */
    public Map<Integer, Integer> numberOfProductsSold() {
        return sales.stream().collect(Collectors.groupingBy(Sale::getProductId, Collectors.summingInt(Sale::getNumberOfSold)));
    }

    /**
     * Задание #2 - Вывести в файл распределение общего количества продаж по датам
     * <p>
     * Собираем TreeMap результатов в виде пар (Дата - Кол-во проданных товаров)
     * Создаём, заполняем и вовзвращаем LinkedHashMap результатов в виде пар (Дата (В нужном формате) - Кол-во проданных товаров)
     */
    public Map<String, Integer> distributionSalesByDate() {
        return sales.stream()
                .collect(Collectors.groupingBy(Sale::getDateSold, Collectors.summingInt(Sale::getNumberOfSold)))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(k->Sale.getNormDate(k.getKey()), v -> v.getValue(),(a,b) -> a,LinkedHashMap::new));
    }
}
