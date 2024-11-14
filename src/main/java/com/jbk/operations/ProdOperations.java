package com.jbk.operations;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import com.jbk.config.HibernateUtil;
import com.jbk.entity.Product;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ProdOperations {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory ( );

    public String addProduct (Product product) {
        try {
            Session session = sessionFactory.openSession ( );
            Product dbProduct = session.get (Product.class, product.getProductId ( ));
            if (dbProduct == null) {
                session.save (product);
                session.beginTransaction ( ).commit ( );
                return "Added Successfully";
            } else {
                return "Product already exists";
            }
        } catch (Exception e) {
            return "Something went wrong";
        }
    }

    public String deleteProduct (int productId) {
        Session session = sessionFactory.openSession ( );
        try {
            Product dbProduct = session.get (Product.class, productId);
            if (dbProduct != null) {
                session.delete (dbProduct);
                session.beginTransaction ( ).commit ( );
                return "Product Deleted";
            } else {
                return "Product Not exists to delete";
            }

        } catch (Exception e) {
            return "Something Went Wrong";
        }

    }

    public Object getProductById (int productId) {
        Session session = sessionFactory.openSession ( );
        try {
            Product dbProduct = session.get (Product.class, productId);
            if (dbProduct != null) {

                return dbProduct;
            } else {
                return "Product Not exists";
            }

        } catch (Exception e) {
            return "Something Went Wrong";
        }
    }

    public String updateProduct (Product product) {
        try {
            Session session = sessionFactory.openSession ( );
            Product dbProduct = session.get (Product.class, product.getProductId ( ));
            if (dbProduct != null) {
                session.evict (dbProduct);
                session.update (product);
                session.beginTransaction ( ).commit ( );
                return "Updated Successfully";
            } else {
                return "Product Not exists to update";
            }
        } catch (Exception e) {
            e.printStackTrace ( );
            return "Something went wrong";
        }
    }

    public List<Product> viewAllProducts () {
        Session session = sessionFactory.openSession ( );
        List<Product> list = null;
        try {
            Criteria criteria = session.createCriteria (Product.class);
            list = criteria.list ( );
            return list;
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    /*public List<Product> viewAllProductsByOrder () {
        Session session = sessionFactory.openSession ( );
        List<Product> list = null;
        try {
            Criteria criteria = session.createCriteria (Product.class);

            criteria.addOrder (Order.asc ("productName"));
            list = criteria.list ( );
            return list;
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }*/

    public List<Product> viewAllProductsByOrder () {
        Session session = sessionFactory.openSession ( );
        List<Product> list = null;
        try {
            list = session.createCriteria (Product.class).addOrder (Order.asc ("productName")).list ();
            return list;
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    public List<Product> viewLimitedProducts () {
        Session session = sessionFactory.openSession ( );
        List<Product> list = null;
        try {
            list = session.createCriteria (Product.class).addOrder (Order.asc("productName")).setMaxResults (2).list ();
            return list;
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    public List<Product> getProductByName (String productName) {
        Session session = sessionFactory.openSession ( );
        List<Product> list = null;
        try {
            list = session.createCriteria (Product.class).add (Restrictions.eq("productName", productName)).list ();
            return list;
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    //Getting Products which have Price greater than a Specific Price.
    public List<Product> getProductByPriceGreaterThan (double productPrice) {
        Session session = sessionFactory.openSession ( );
        List<Product> list = null;
        try {
            Criteria criteria = session.createCriteria (Product.class);
            list = criteria.add (Restrictions.gt ("productPrice", productPrice)).list ();
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    //Using Restrictions.in to retrieve products from table using multiple ids.
    public List<Product> getProductsByMultipleIds() {
        Session session = sessionFactory.openSession ( );
        List<Product> list=null ;
        try {
            list = session.createCriteria(Product.class).add(Restrictions.in("productId", 1,3)).list();
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    //Using Restrictions.between to retrieve products from table between specific range.
    public List<Product> getProductsBetweenRange() {
        Session session = sessionFactory.openSession ( );
        List<Product> list=null ;
        try {
            list = session.createCriteria(Product.class).add(Restrictions.between ("productId", 2,3)).list();

        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    //Using Projections.rowCount() to get the total count of the products in tables.
    public long getProductCount() {
        Session session = sessionFactory.openSession ( );
        long count = 0;
        try {
            List<Long> list = session.createCriteria(Product.class).setProjection (Projections.rowCount ()).list();
            if (!list.isEmpty()) {
                count = list.get (0);

            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return count;
    }

    //Using Projections.rowCount() to get the total count of the products in tables.
    public double getProductMaxProductPrice() {
        Session session = sessionFactory.openSession ( );
        double maxProductPrice = 0;
        try {
            List<Double> list = session.createCriteria(Product.class).setProjection (Projections.max ("productPrice")).list();
            if (!list.isEmpty()) {
                maxProductPrice = list.get (0);

            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return maxProductPrice;
    }

    //Using Projections.rowCount() to get the total count of the products in tables.
    public double getProductMinProductPrice() {
        Session session = sessionFactory.openSession ( );
        double minProductPrice = 0;
        try {
            List<Double> list = session.createCriteria(Product.class).setProjection (Projections.min ("productPrice")).list();
            if (!list.isEmpty()) {
                minProductPrice = list.get (0);

            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return minProductPrice;
    }

    //Retrieve all records using HQL Query.
    public List<Product> queryEx1(){
        Session session = sessionFactory.openSession ( );
        List<Product> list = null ;
        try {
            String hql = "FROM Product";
            Query query = session.createQuery (hql);
            list = query.list ();
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    //Retrieve specific columns information's using HQl Query.
    public List<Object[]> queryEx2(){
        Session session = sessionFactory.openSession ( );
        List<Object[]> list = null ;
        try {
            String hql = "SELECT productId, productName, productQty FROM Product";
            Query query = session.createQuery (hql);
            list = query.list ();
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }

    //Retrieve specific Product using specific ProductName.
    public List<Product> queryEx3(){
        Session session = sessionFactory.openSession ( );
        List<Product> list = null ;
        try {
            String hql = "FROM Product where productName=:pName";
            Query query = session.createQuery (hql);
            query.setString ("pName", "Book");
            list = query.list ();
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return list;
    }
}