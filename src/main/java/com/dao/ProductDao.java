import com.dao.IProductDao;
import com.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            //pt.setBinaryStream(3, product.getPicture());
            //for mysql
            pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryID());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productID, Connection con) throws SQLException {
        int n = 0;
        String sql = "delete * from product where ProductID=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productID);
        n = pt.executeUpdate();
        if (n>0) {
            return n;
        }
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        int n = 0;
        String sql = "update product set ProductName=?,ProductDescription=?,Picture=?,price=?,CategoryID=? where ProductID=?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, instance.getProductName());
        pt.setString(2, instance.getProductDescription());
        if(instance.getPicture()!=null) {
            //for sql server
            //pt.setBinaryStream(3, instance.getPicture());
            //for mysql
            pt.setBlob(3, instance.getPicture());
        }
        pt.setDouble(4, instance.getPrice());
        pt.setInt(5, instance.getCategoryID());
        pt.setInt(6,instance.getProductID());
        n = pt.executeUpdate();
        if (n>0) {
            return n;
        }
        return  0;
    }

    @Override
    public Product findById(Integer productID, Connection con) throws SQLException {
        String sql = "select * from product where ProductID = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1, productID);
        ResultSet rs = pt.executeQuery();
        Product product = null;
        if (rs.next()){
            product = new Product();
            product.setProductID(rs.getInt("ProductID"));
            product.setProductName(rs.getString("ProductName"));
            product.setPrice(rs.getDouble("Price"));
            product.setProductDescription(rs.getString("ProductDescription"));
            product.setCategoryID(rs.getInt("CategoryID"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryID, Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "select * from product where CategoryID = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, categoryID);
            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setPicture(rs.getBlob("Picture").getBinaryStream());
                product.setPrice(rs.getDouble("Price"));
                product.setProductDescription(rs.getString("ProductDescription"));
                product.setCategoryID(rs.getInt("CategoryID"));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "select * from product where Price >="+minPrice+" and Price <="+maxPrice;
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            Product productList = null;
            while (rs.next()){
                productList = new Product();
                productList.setProductID(rs.getInt("ProductID"));
                productList.setProductName(rs.getString("ProductName"));
                productList.setPicture(rs.getBlob("Picture").getBinaryStream());
                productList.setPrice(rs.getDouble("Price"));
                productList.setProductDescription(rs.getString("ProductDescription"));
                productList.setCategoryID(rs.getInt("CategoryID"));
                list.add(productList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        try{
            String sql = "select * from product";
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            Product productList = null;
            while (rs.next()){
                productList = new Product();
                productList.setProductID(rs.getInt("ProductID"));
                productList.setProductName(rs.getString("ProductName"));
                productList.setPrice(rs.getDouble("Price"));
                productList.setProductDescription(rs.getString("ProductDescription"));
                productList.setCategoryID(rs.getInt("CategoryID"));
                list.add(productList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public byte[] getPictureById(Integer productID, Connection con) throws SQLException {
        byte[] imgByte = null;
        String sql = "select picture from product where productID = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,productID);
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            Blob blob = rs.getBlob("picture");
            imgByte = blob.getBytes(1,(int)blob.length());
        }
        return imgByte;
    }
    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "select * from product where ProductName like '%+"+productName+"%'";
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            Product productList = null;
            while (rs.next()){
                productList = new Product();
                productList.setProductID(rs.getInt("ProductID"));
                productList.setProductName(rs.getString("ProductName"));
                productList.setPicture(rs.getBlob("Picture").getBinaryStream());
                productList.setPrice(rs.getDouble("Price"));
                productList.setProductDescription(rs.getString("ProductDescription"));
                productList.setCategoryID(rs.getInt("CategoryID"));
                list.add(productList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Product> getPicture(Integer productID, Connection con) throws SQLException {
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "select * from product where ProductID = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, productID);
            ResultSet rs = pt.executeQuery();
            Product productList = null;
            while (rs.next()){
                productList = new Product();
                productList.setProductID(rs.getInt("ProductID"));
                productList.setProductName(rs.getString("ProductName"));
                productList.setPicture(rs.getBlob("Picture").getBinaryStream());
                productList.setPrice(rs.getDouble("Price"));
                productList.setProductDescription(rs.getString("ProductDescription"));
                productList.setCategoryID(rs.getInt("CategoryID"));
                list.add(productList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}