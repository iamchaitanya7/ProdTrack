# Product360 - Product Tracking System.

This project implements a product tracking system using Hibernate and Java. It provides functionalities to manage product information, including adding, deleting, updating, and retrieving product details.

## Features

* **Add Product:** Add new products with details such as name, quantity, price, manufacturing date, and expiry date.
* **Delete Product:** Delete existing products by ID.
* **View Product by ID:** Retrieve product details by providing the product ID.
* **Update Product:** Update existing product information, such as quantity and price.
* **View All Products:** List all products in the system.
* **View Products by Order:** List products sorted by a specific attribute (e.g., product name).
* **View Limited Products:** Retrieve a limited number of products.
* **View Product by Name:** Search for products by name.
* **View Product by Price (Greater Than):** Retrieve products with a price greater than a specified value.
* **View Product by Multiple IDs:** Retrieve products matching a list of IDs.
* **View Products Between Range:** Retrieve products within a specified ID range.
* **View All Products Count:** Get the total number of products in the system.
* **View Max Product Price:** Retrieve the highest product price.
* **View Min Product Price:** Retrieve the lowest product price.
* **HQL Query Examples:** Includes examples demonstrating Hibernate Query Language (HQL) usage.


## Technologies Used

* **Java:** Programming language for application logic.
* **Hibernate:** ORM framework for database interaction.
* **MySQL:** Database for storing product information.
* **Maven:** Build tool for dependency management (optional).

## Setup Instructions

1. **Database Setup:**
    * Create a MySQL database named `db195`.
    * Configure the database connection in `hibernate.cfg.xml`.
2. **Build (if using Maven):**
    * Use Maven to build the project and resolve dependencies.
3. **Run:**
    * Execute the `ProductApp` class to start the application.

## Usage

The application provides a menu-driven interface to interact with the product tracking system. Follow the on-screen prompts to perform various operations.

## Code Structure

* **`com.jbk.entity`:** Contains entity classes representing database tables (e.g., `Product`).
* **`com.jbk.operations`:** Contains classes responsible for database operations (e.g., `ProdOperations`).
* **`com.jbk.util`:** Contains utility classes (e.g., `InputUtil`).
* **`com.jbk.config`:** Contains the `HibernateUtil` class with method to get `SessionFactory` object.
* **`com.jbk.validations`:** Contains the `ProductValidator` class to validate the Product (Not implemented in provided code).
* **`com.jbk.exceptions`:** Contains custom exceptions `InvalidProductException` to handle exceptions (Not implemented in provided code).
* **`hibernate.cfg.xml`:** Hibernate configuration file.
* **`ProductApp.java`:** Main application class.

## Future Enhancements

* **User Interface:** Implement a graphical user interface for better user experience.
* **Reporting:** Generate reports based on product data.
* **Advanced Search:** Implement more advanced search functionalities.
* **Security:** Add user authentication and authorization.
* **Implement Validation and Exception Handling:** Fully implement the `ProductValidator` and custom exception classes.

## Contributing

Contributions are welcome. Please fork the repository and submit pull requests.

## License

This project is licensed under the MIT License.