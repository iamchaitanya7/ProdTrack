package com.jbk;

import java.util.List;
import java.util.Scanner;
import com.jbk.entity.Product;
import com.jbk.operations.ProdOperations;
import com.jbk.util.InputUtil;

public class ProductApp {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        ProdOperations operation = new ProdOperations ( );
        int choice;
        boolean wantToContinue = true;
        do {
            System.out.println ("Press 1 to Add Product");
            System.out.println ("Press 2 to Delete Product By Id");
            System.out.println ("Press 3 to View Product By Id");
            System.out.println ("Press 4 to Update Product");
            System.out.println ("Press 5 to View all Products");
            System.out.println ("Press 6 to View all Products as per order");
            System.out.println ("Press 7 to View Limited Products");
            System.out.println ("Press 8 to View Product by name");
            System.out.println ("Press 9 to View Product by Price Greater Than Specific Price");
            System.out.println ("Press 10 to View Products by Multiple Ids (IN)");
            System.out.println ("Press 11 to View Products by Between Specific Range (BETWEEN)");
            System.out.println ("Press 12 to View All Products Count");
            System.out.println ("Press 13 to View Product of Max Product Price");
            System.out.println ("Press 14 to View Product of Min Product Price");

            System.out.println ("Press 15 to View Product Query Example 1");
            System.out.println ("Press 16 to View Product Query Example 2");
            System.out.println ("Press 17 to View Product Query Example 3");

            System.out.println ("Press 0 to Exit");
            choice = scanner.nextInt ( );
            switch (choice) {
                case 0: {
                    wantToContinue = false;
                    break;
                }
                case 1: {
                    Product product = InputUtil.getProductInfoFromUser ( );
                    String msg = operation.addProduct (product);
                    System.out.println (msg);
                    break;
                }
                case 2: {
                    System.out.println ("Enter Product Id");
                    int productId = scanner.nextInt ( );
                    String msg = operation.deleteProduct (productId);
                    System.out.println (msg);
                    break;
                }
                case 3: {
                    System.out.println ("Enter Product Id");
                    int productId = scanner.nextInt ( );
                    Object obj = operation.getProductById (productId);
                    System.out.println (obj);
                    break;
                }
                case 4: {
                    System.out.println ("Enter product Id");
                    int id = scanner.nextInt ( );
                    Product product = InputUtil.getProductInfoFromUser ( );
                    product.setProductId (id);
                    String msg = operation.updateProduct (product);
                    System.out.println (msg);
                    break;
                }
                case 5: {
                    List<Product> list = operation.viewAllProducts ( );
                    if (!list.isEmpty ( )) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("no record found");
                    }
                    break;
                }
                case 6: {
                    List<Product> list = operation.viewAllProductsByOrder ( );
                    if (!list.isEmpty ( )) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("no record found");
                    }
                    break;
                }
                case 7: {
                    List<Product> list = operation.viewLimitedProducts ();
                    if (!list.isEmpty ( )) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }
                case 8: {
                    System.out.println ("Enter Product Name: " );
                    String productName = scanner.next ();
                    List<Product> list = operation.getProductByName (productName);
                    if (!list.isEmpty ()) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }

                case 9: {
                    System.out.println ("Enter Price Range: " );
                    double productPrice = scanner.nextDouble ();
                    List<Product> list = operation.getProductByPriceGreaterThan (productPrice);
                    if (!list.isEmpty ()) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }

                case 10: {
                    List<Product> list = operation.getProductsByMultipleIds();
                    if (!list.isEmpty ()) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }

                case 11: {
                    List<Product> list = operation.getProductsBetweenRange ();
                    if (!list.isEmpty ()) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }

                case 12: {
                    long count = operation.getProductCount ();
                    System.out.println ("Total Product Count: " +count);
                    break;
                }

                case 13: {
                    double maxProductPrice = operation.getProductMaxProductPrice ();
                    System.out.println ("Max ProductPrice: " +maxProductPrice);
                    break;
                }

                case 14: {
                    double minProductPrice = operation.getProductMinProductPrice ();
                    System.out.println ("Min ProductPrice: " + minProductPrice);
                    break;
                }


                case 15: {
                    List<Product> list = operation.queryEx1 ();
                    if (!list.isEmpty ()) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }

                case 16: {
                    List<Object[]> list = operation.queryEx2 ();
                    if (!list.isEmpty ()) {
                        for (Object [] object : list) {
                            System.out.print (object[0]);
                            System.out.print (object[1]);
                            System.out.println (object[2]);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }

                case 17: {
                    List<Product> list = operation.queryEx3 ();
                    if (!list.isEmpty ()) {
                        for (Product product : list) {
                            System.out.println (product);
                        }
                    } else {
                        System.out.println ("No record found");
                    }
                    break;
                }

                default:
                    System.out.println ("Invalid choice");
                    break;
            }
        } while (wantToContinue);
        System.out.println ("App Terminated");
    }
}