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

    /**
     * Задание #1 - Для каждого товара вывести в файл общее количество проданных товаров этого типа
     * <p>
     * Собираем и вовзвращаем LinkedHashMap результатов в виде пар (ID продукта - Кол-во проданных товаров)
     */
    public LinkedHashMap<Integer, Integer> numberOfProductsSold() {
        LinkedHashMap<Integer, Integer> results = new LinkedHashMap<>();
        sales.sort(Sale.compareByProduct);
        int tempId = sales.get(0).getProductId(), sum = 0;
        for (Sale sale : sales) {
            if (tempId != sale.getProductId()) {
                results.put(tempId, sum);
                tempId = sale.getProductId();
                sum = 0;
            }
            sum += sale.getNumberOfSold();
        }
        results.put(tempId, sum);
        return results;
    }

    /**
     * Задание #2 - Вывести в файл распределение общего количества продаж по датам
     * <p>
     * Собираем TreeMap результатов в виде пар (Дата - Кол-во проданных товаров)
     * Создаём, заполняем и вовзвращаем LinkedHashMap результатов в виде пар (Дата (В нужном формате) - Кол-во проданных товаров)
     */
    public LinkedHashMap<String, Integer> distributionSalesByDate() {
        //Используем TreeMap, чтобы отсортировать даты
        TreeMap<Date, Integer> results = new TreeMap<>();
        sales.sort(Sale.compareByDate);
        int sum = 0;
        Date date = sales.get(0).getDateSold();
        for (Sale sale : sales) {
            if (!date.equals(sale.getDateSold())) {
                results.put(date, sum);
                date = sale.getDateSold();
                sum = 0;
            }
            sum += sale.getNumberOfSold();
        }
        results.put(date, sum);

        LinkedHashMap<String, Integer> normResults = new LinkedHashMap<>();

        results.entrySet()
                .stream()
                .forEach(k -> normResults.put(Sale.getNormDate(k.getKey()), k.getValue()));

        return normResults;
    }
}
