package crocHomeWork;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SellerProduct {
    @SerializedName("seller")
    int seller;
    @SerializedName("product")
    int product;
    @SerializedName("cost")
    int cost;
    @SerializedName("amount")
    int amount;

    SellerProduct(int seller, int product, int cost, int amount) {
        this.seller = seller;
        this.product = product;
        this.cost = cost;
        this.amount = amount;
    }

    public String toString() {
        return "SellerProduct{" +
                "seller=" + seller +
                ", product=" + product +
                ", cost=" + cost +
                ", amount=" + amount +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerProduct that = (SellerProduct) o;
        return seller == that.seller && product == that.product && cost == that.cost && amount == that.amount;
    }

    public int hashCode() {
        return Objects.hash(seller, product, cost, amount);
    }
}
