package crocHomeWork;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Seller {
    @SerializedName("id")
    int id;
    @SerializedName("surname")
    String surname;
    @SerializedName("name")
    String name;

    Seller(int id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return id == seller.id && Objects.equals(surname, seller.surname) && Objects.equals(name, seller.name);
    }

    public int hashCode() {
        return Objects.hash(id, surname, name);
    }
}
