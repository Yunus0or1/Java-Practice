package com.example;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.omg.CORBA.portable.InputStream;
import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        try {
            String domainName = "http://dummyjson.com/products";

            URL url = new URL(domainName);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            if (conn.getResponseCode() == 200) {
                String result = "";
                Scanner scan = new Scanner(url.openStream());
                while (scan.hasNext()) {
                    String temp = scan.nextLine();
                    result = result + temp;
                }

                Product product = new Product();
                Gson gson = new Gson();
                product = gson.fromJson(result, Product.class);

                List<Item> items = product.getItems();

                Collections.sort(items, new Comparator<Item>() {
                    public int compare(Item i1, Item i2) {
                        return Integer.compare(i1.getPrice(), i2.getPrice());
                    }
                });

                for (Item item : items) {
                    System.out.println(item.getTitle() + " " + item.getPrice());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
