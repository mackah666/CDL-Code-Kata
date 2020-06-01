package com.rightcode;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    public List<Sku> getSkuList() {
        return catalog;
    }

    List<Sku> catalog = new ArrayList<>();


    public void AddToCatalog(Sku item){
        this.catalog.add(item);
    }
}
