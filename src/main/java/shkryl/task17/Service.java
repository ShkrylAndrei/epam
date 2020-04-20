package shkryl.task17;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String LOGIN = "postgres";
    private final String PASSWORD = "1";
    private Connection connection;



    public Service() throws SQLException {
        connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }

    public List<Product> readAllProductsByTitle(String title) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM products where title LIKE  ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "%"+title+"%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Product product = new Product();
            product.setProd_id(rs.getInt("prod_id"));
            product.setTitle(rs.getString("title"));
            product.setActor(rs.getString("actor"));
            product.setPrice(rs.getDouble("price"));
            product.setSpecial(rs.getInt("special"));;
            product.setCommon_prod_id(rs.getInt("common_prod_id"));
            productList.add(product);
        }
        return productList;
    }

    public boolean removeProductById(int id) throws SQLException {
        String query = "DELETE FROM products WHERE prod_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        if(ps.executeUpdate()==0){
            return false;
        }
        return true;
    }

    public boolean editProductById(int id, String newTitle) throws SQLException {
        String query = "UPDATE products SET title = ? where prod_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, newTitle);
        ps.setInt(2, id);
        if(ps.executeUpdate()==0){
            return false;
        }
        return true;
    }





}
