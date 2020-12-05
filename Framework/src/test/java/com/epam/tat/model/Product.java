package com.epam.tat.model;

import java.util.Objects;

public class Product {
    private String url;
    private String name;

    public Product(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return url.equals(product.url) &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, name);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("url='").append(url).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
