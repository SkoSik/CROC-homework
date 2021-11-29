package crocHomeWork;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Product {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    public int hashCode() {
        return Objects.hash(id, name);
    }
}
