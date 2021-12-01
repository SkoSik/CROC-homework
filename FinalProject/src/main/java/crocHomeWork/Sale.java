package crocHomeWork;

import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Sale {
    @SerializedName("id")
    int id;
    @SerializedName("seller")
    int sellerId;
    @SerializedName("product")
    int productId;
    @SerializedName("numberOfSold")
    int numberOfSold;
    @SerializedName("date")
    Date dateSold;

    Sale(int id, int seller, int product, int numberOfSold, Date date) {
        this.id = id;
        this.sellerId = seller;
        this.productId = product;
        this.numberOfSold = numberOfSold;
        this.dateSold = date;
    }

    public int getProductId() {
        return productId;
    }

    public int getNumberOfSold() {
        return numberOfSold;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public static String getNormDate(Date date) {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(date);
    }

    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", seller=" + sellerId +
                ", product=" + productId +
                ", numberOfSold=" + numberOfSold +
                ", date=" + dateSold +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id && sellerId == sale.sellerId && productId == sale.productId && numberOfSold == sale.numberOfSold && Objects.equals(dateSold, sale.dateSold);
    }

    public int hashCode() {
        return Objects.hash(id, sellerId, productId, numberOfSold, dateSold);
    }

    public static Comparator<Sale> compareByProduct = new Comparator<Sale>() {
        public int compare(Sale o1, Sale o2) {
            return o1.getProductId() - o2.getProductId();
        }
    };

    public static Comparator<Sale> compareByDate = new Comparator<Sale>() {
        public int compare(Sale o1, Sale o2) {
            return o1.getDateSold().compareTo(o2.getDateSold());
        }
    };
}
