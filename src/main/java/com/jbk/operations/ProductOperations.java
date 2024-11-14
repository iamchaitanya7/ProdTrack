package com.jbk.operations;

import com.jbk.entity.Product;
import com.jbk.exceptions.InvalidProductException;
import com.jbk.validations.ProductValidator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductOperations {
    /*private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public String addProduct(Product product) {
        try {
            ProductValidator.validateProduct (product);
            Session session = sessionFactory.openSession ( );
            Product dbProduct = session.get (Product.class, product.getProductId ( ));
            if (dbProduct == null) {
                session.save (product);
                session.beginTransaction ( ).commit ( );
                return "Product added successfully.";
            } else {
                return "Product already exists";
            }
        } catch (InvalidProductException e) {
            System.err.println ("Validation error: " + e.getMessage ( ));
        } catch (Exception e) {
            return "Error adding product";
        }
    }

    public static void deleteProduct(int productId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.get(Product.class, productId);
            if (product != null) {
                session.delete(product);
                transaction.commit();
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }
    }

    public static void updateProduct(int productId, int quantity, double price) {
        ProductValidator.validateQuantity(quantity);
        ProductValidator.validatePrice(price);

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Product product = session.get(Product.class, productId);
            if (product != null) {
                product.setProductQuantity(quantity);
                product.setProductPrice(price);
                session.update(product);
                transaction.commit();
                System.out.println("Product updated successfully.");
            } else {
                System.out.println("Product not found.");
            }
        } catch (InvalidProductException e) {
            System.err.println("Validation error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error updating product: " + e.getMessage());
        }
    }

    public static Product viewProduct(int productId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, productId);
        } catch (Exception e) {
            System.err.println("Error viewing product: " + e.getMessage());
            return null;
        }
    }

    public static List<Product> viewAllProducts() {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(Product.class);
            criteria.list();


            return session.createQuery("from Product", Product.class).list();
        } catch (Exception e) {
            System.err.println("Error viewing all products: " + e.getMessage());
            return null;
        }
    }

    public static List<Product> viewAllProductsByPrice() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Product order by productPrice asc", Product.class).list();
        } catch (Exception e) {
            System.err.println("Error viewing products by price: " + e.getMessage());
            return null;
        }
    }*/
}
