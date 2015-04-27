package com.bangla.store.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.bangla.store.domain.Product;
import com.bangla.store.repository.ProductRepository;
import com.bangla.store.exception.ProductNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Masudur Rahman <masud.java@gmail.com>
 */
@Repository
@Transactional
public class InMemoryProductRepository implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

//    private List<Product> listOfProducts = new ArrayList<Product>();
    public InMemoryProductRepository() {
        /*Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
         iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
         //iphone.setCategory("Smart Phone");
         iphone.setManufacturer("Apple");
         iphone.setUnitsInStock(1000);
         Product laptop_dell = new Product("P1235", "Dell Inspiron",
         new BigDecimal(700));
         laptop_dell
         .setDescription("Dell Inspiron 14-inch Laptop(Black) with 3rd Generation Intel Core processors");
         laptop_dell.setCategory("Laptop");

         laptop_dell.setManufacturer("Dell");
         laptop_dell.setUnitsInStock(1000);
         Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(
         300));
         tablet_Nexus
         .setDescription("Google Nexus 7 is the lightest7 inch tablet With a quad-core Qualcomm Snapdragon� S4 Pro-processor");
         tablet_Nexus.setCategory("Tablet");
         tablet_Nexus.setManufacturer("Google");
         tablet_Nexus.setUnitsInStock(1000);
                
         Product laptop_dell2 = new Product("P1237", "Dell Inspiron 2",
         new BigDecimal(700));
         laptop_dell2
         .setDescription("Dell Inspiron 14-inch Laptop(Black) with 3rd Generation Intel Core processors");
         laptop_dell2.setCategory("Laptop");

         laptop_dell2.setManufacturer("Dell");
         laptop_dell2.setUnitsInStock(1000);
                
         listOfProducts.add(iphone);
         listOfProducts.add(laptop_dell);
         listOfProducts.add(tablet_Nexus);
         listOfProducts.add(laptop_dell2);*/
    }

    @Override @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product getProductById(String productId) {
        Product product = null;
        product = (Product) sessionFactory.getCurrentSession().createQuery("from Product where productId=:productId")
                .setParameter("productId", productId).uniqueResult();
                
//        for (Product product : listOfProducts) {
//            if (product != null && product.getProductId() != null
//                    && product.getProductId().equals(productId)) {
//                productById = product;
//                break;
//            }
//        }
//        if (productById == null) {
//            throw new ProductNotFoundException(
//                    "No products found with		the product id: " + productId);
//        }
        return product;
    }

    @Override @SuppressWarnings("unchecked")
    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();
//        for (Product product : listOfProducts) {
//            if (category.equalsIgnoreCase(product.getCategory().getCategoryName())) {
//                productsByCategory.add(product);
//            }
//        }
        return productsByCategory;
    }

    @Override
    public Set<Product> getProductsByFilter(
            Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();
//        if (criterias.contains("brand")) {
//            for (String brandName : filterParams.get("brand")) {
//                for (Product product : listOfProducts) {
//                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
//                        productsByBrand.add(product);
//                    }
//                }
//            }
//        }
//        if (criterias.contains("category")) {
//            for (String category : filterParams.get("category")) {
//                productsByCategory.addAll(this.getProductsByCategory(category));
//
//            }
//        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }

    @Override @SuppressWarnings("unchecked")
    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<Product>();
//        for (Product product : listOfProducts) {
//            if (manufacturer.equalsIgnoreCase(product.getCategory().getCategoryName())) {
//                productsByManufacturer.add(product);
//            }
//        }
        return productsByManufacturer;
    }

    @Override
    public void addProduct(Product product) {

        sessionFactory.getCurrentSession().persist(product);
        //listOfProducts.add(product

    }

}
