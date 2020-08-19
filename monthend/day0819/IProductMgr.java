import java.util.List;

public interface IProductMgr {
	
	 void input(Product tv) throws DuplicateException;
	 List<Product> searchAll();
	 Product searchProductNum(String productNumber) throws CodeNotFoundException;
	 List<Product> searchProductName(String productName);
	 List<Product> searchTV();
	 List<Product> searchRef();
	 List<Product> over400Ref() throws ProductNotFoundException;
	 List<Product> over50TV() throws ProductNotFoundException;
	 boolean update(String productNum, int price);
	 boolean delete(String productNum);
	 int totalPrice();
}