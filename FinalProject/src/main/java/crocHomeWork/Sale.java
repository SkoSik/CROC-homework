package crocHomeWork;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Sale {
    int id;
    int seller;
    int product;
    int numberOfSold;
    Date date;

    Sale(int id, int seller, int product, int numberOfSold, Date date) {
        this.id = id;
        this.seller = seller;
        this.product = product;
        this.numberOfSold = numberOfSold;
        this.date = date;
    }

    public int getProduct() {
        return product;
    }

    public int getNumberOfSold() {
        return numberOfSold;
    }

    public String getDate() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(date);
    }

    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", seller=" + seller +
                ", product=" + product +
                ", numberOfSold=" + numberOfSold +
                ", date=" + date +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return id == sale.id && seller == sale.seller && product == sale.product && numberOfSold == sale.numberOfSold && Objects.equals(date, sale.date);
    }

    public int hashCode() {
        return Objects.hash(id, seller, product, numberOfSold, date);
    }

    public static Comparator<Sale> compareByProduct = new Comparator<Sale>() {
        public int compare(Sale o1, Sale o2) {
            return o1.getProduct() - o2.getProduct();
        }
    };

    public static Comparator<Sale> compareByDate = new Comparator<Sale>() {
        public int compare(Sale o1, Sale o2) {
            return o1.getDate().compareTo(o2.getDate());
        }
    };
}
