import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDao{

	private static ProductDAOImpl instance;
	private ProductDAOImpl(){
		
	}
	
	public static ProductDAOImpl getInstance() {
		if(instance == null) instance = new ProductDAOImpl();
		return instance;
	}
	
	@Override
	public int insertProduct(Product product) {
		
		int changenum = -1;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch( ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb?serverTimezone=UTC&useUnicode=yes&characoerEncoding=UTF-8", "root", "1234"))
		{
			String sql = "insert into product values(?,?,?,?,?,?,?)";
			int index = 1;
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(index++, product.getNum());
				ps.setString(index++, product.getName());
				ps.setInt(index++, product.getPrice());
				ps.setInt(index++, product.getAmount());
				ps.setInt(index++, product.getInch());
				ps.setInt(index++, product.getLiter());
				ps.setString(index++, product.getGubun());
				changenum = ps.executeUpdate();
			}catch(Exception e){
				e.getStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return changenum;
	}

	@Override
	public List<Product> selectProduct() {
		List<Product> list = new ArrayList<Product>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch( ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb?serverTimezone=UTC&useUnicode=yes&characoerEncoding=UTF-8", "root", "1234"))
		{
			String sql = "select * from product";
			
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					Product tmp = new Product();
					tmp.setNum(rs.getString("num"));
					tmp.setName(rs.getString("name"));
					tmp.setPrice(rs.getInt("price"));
					tmp.setAmount(rs.getInt("amount"));
					tmp.setInch(rs.getInt("inch"));
					tmp.setLiter(rs.getInt("liter"));
					tmp.setGubun(rs.getString("gubun"));
					list.add(tmp);
				}
				return list;
			}catch(Exception e){
				e.getStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<Product> selectProductByName(String name) {
		List<Product> list = new ArrayList<Product>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch( ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb?serverTimezone=UTC&useUnicode=yes&characoerEncoding=UTF-8", "root", "1234"))
		{
			String sql = "select * " + 
						 "from product " + 
						 "where name Like " + "'%" + name + "%'";

			try(PreparedStatement ps = con.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					Product tmp = new Product();
					tmp.setNum(rs.getString("num"));
					tmp.setName(rs.getString("name"));
					tmp.setPrice(rs.getInt("price"));
					tmp.setAmount(rs.getInt("amount"));
					tmp.setInch(rs.getInt("inch"));
					tmp.setLiter(rs.getInt("liter"));
					tmp.setGubun(rs.getString("gubun"));
					list.add(tmp);
				}
				return list;
			}catch(Exception e){
				e.getStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<Product> selectProductByPrice(int price) {
		List<Product> list = new ArrayList<Product>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch( ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb?serverTimezone=UTC&useUnicode=yes&characoerEncoding=UTF-8", "root", "1234"))
		{
			String sql = "select * " + 
						 "from product " + 
						 "where price <= ?";
			int index = 1;
			
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(index++, price);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					Product tmp = new Product();
					tmp.setNum(rs.getString("num"));
					tmp.setName(rs.getString("name"));
					tmp.setPrice(rs.getInt("price"));
					tmp.setAmount(rs.getInt("amount"));
					tmp.setInch(rs.getInt("inch"));
					tmp.setLiter(rs.getInt("liter"));
					tmp.setGubun(rs.getString("gubun"));
					list.add(tmp);
				}
				return list;
			}catch(Exception e){
				e.getStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public Product selectProductByNum(String num) {
		Product product = new Product();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch( ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb?serverTimezone=UTC&useUnicode=yes&characoerEncoding=UTF-8", "root", "1234"))
		{
			String sql = "select * " + 
						 "from product " + 
						 "where num Like " + "'" + num + "'";
			
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ResultSet rs = ps.executeQuery();
				
				rs.next();

				product.setNum(rs.getString("num"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setAmount(rs.getInt("amount"));
				product.setInch(rs.getInt("inch"));
				product.setLiter(rs.getInt("liter"));
				product.setGubun(rs.getString("gubun"));
				return product;
			}catch(Exception e){
				e.getStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public int deleteProduct(String num) {
		int changenum = -1;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch( ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb?serverTimezone=UTC&useUnicode=yes&characoerEncoding=UTF-8", "root", "1234"))
		{
			String sql = "delete from product " + 
						 "where num Like " + "'" + num + "'";
			try(PreparedStatement ps = con.prepareStatement(sql)){
				changenum = ps.executeUpdate();
			}catch(Exception e){
				e.getStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return changenum;
	}

	@Override
	public int updateProduct(Product product) {
		int changenum = -1;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch( ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/productdb?serverTimezone=UTC&useUnicode=yes&characoerEncoding=UTF-8", "root", "1234"))
		{
			String sql = "UPDATE product " + 
						 "SET price = ? " + 
						 "where num Like " + "'" + product.getNum() + "'";
			int index = 1;
			
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(index++, product.getPrice());
				
				changenum = ps.executeUpdate();
			}catch(Exception e){
				e.getStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return changenum;
	}
	
}
