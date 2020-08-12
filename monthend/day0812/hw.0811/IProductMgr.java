import java.util.List;

public interface IProductMgr {
	
	 void input(Product tv);
	 List<Product> searchAll();
	 Product searchProductNum(String productNumber);
	 List<Product> searchProductName(String productName);
	 List<Product> searchTV();
	 List<Product> searchRef();
	 List<Product> over400Ref();
	 List<Product> over50TV();
	 boolean update(String productNum, int price);
	 boolean delete(String productNum);
	 int totalPrice();
}