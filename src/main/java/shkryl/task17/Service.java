package shkryl.task17;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String LOGIN = "postgres";
    private final String PASSWORD = "1";
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    private static Logger logger = LoggerFactory.getLogger(Service.class);


    public Service() throws SQLException {
        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

    public List<Product> readAllProductsByTitle(String title) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products where title LIKE  ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, "%" + title + "%");
        rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            product.setProdId(rs.getInt("prod_id"));
            product.setCategory(rs.getInt("category"));
            product.setTitle(rs.getString("title"));
            product.setActor(rs.getString("actor"));
            product.setPrice(rs.getDouble("price"));
            product.setSpecial(rs.getInt("special"));
            product.setCommonProdId(rs.getInt("common_prod_id"));
            productList.add(product);
        }
        return productList;
    }

    public boolean removeProductById(int id) throws SQLException {
        String query = "DELETE FROM products WHERE prod_id = ?";
        ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        if (ps.executeUpdate() == 0) {
            return false;
        }
        return true;
    }

    public boolean editProductById(int id, String newTitle) throws SQLException {
        String query = "UPDATE products SET title = ? where prod_id = ?";
        ps = connection.prepareStatement(query);
        ps.setString(1, newTitle);
        ps.setInt(2, id);
        if (ps.executeUpdate() == 0) {
            return false;
        }
        return true;
    }


    public boolean addProductById(int category, String title, String actor, int price, int common_prod_id) throws SQLException {
        String query = "INSERT INTO products(category,title,actor,price,common_prod_id) VALUES(?,?,?,?,?)";

        ps = connection.prepareStatement(query);
        ps.setInt(1, category);
        ps.setString(2, title);
        ps.setString(3, actor);
        ps.setInt(4, price);
        ps.setInt(5, common_prod_id);
        if (ps.executeUpdate() == 0) {
            return false;
        }
        return true;
    }

    public void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.error("Произошло исключение, при попытке закрыть базу данных");
        }
    }
}
