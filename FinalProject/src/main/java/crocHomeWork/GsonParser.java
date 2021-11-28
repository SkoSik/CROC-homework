package crocHomeWork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GsonParser {
    Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();
    FileReader reader;


    public List<Product> parseProducts() throws FileNotFoundException {
        reader = new FileReader("products.json");
        return Arrays.asList(gson.fromJson(reader, Product[].class));
    }

    public List<Seller> parseSellers() throws FileNotFoundException {
        reader = new FileReader("sellers.json");
        return Arrays.asList(gson.fromJson(reader, Seller[].class));
    }

    public List<SellerProduct> parseSellerProduct() throws FileNotFoundException {
        reader = new FileReader("sellersProducts.json");
        return Arrays.asList(gson.fromJson(reader, SellerProduct[].class));
    }

    public List<Sale> parseSales() throws FileNotFoundException {
        reader = new FileReader("sales.json");
        return Arrays.asList(gson.fromJson(reader, Sale[].class));
    }

    public void writeNumberOfSoldProducts(HashMap<Integer, Integer> results) throws FileNotFoundException {
        Type gsonType = new TypeToken<HashMap>() {
        }.getType();
        String result = gson.toJson(results, gsonType);
        PrintWriter fout = new PrintWriter("numberOfSoldProducts.json");
        fout.println(result);
        fout.close();
    }

    public void writeDistributionSalesByDate(HashMap<String, Integer> results) throws FileNotFoundException {
        Type gsonType = new TypeToken<HashMap>() {
        }.getType();
        String result = gson.toJson(results, gsonType);
        PrintWriter fout = new PrintWriter("distributionSalesByDate.json");
        fout.println(result);
        fout.close();
    }
}
