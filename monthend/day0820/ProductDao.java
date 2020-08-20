import java.util.List;

public interface ProductDao {
	//insert, select, update, delete
	//상품 정보 저장
	int insertProduct(Product product);
	//상품 전체 정보 검색
	List<Product> selectProduct();
	//상품명 검색 ( 상품명을 포함한 모든 상품의 정보)
	List<Product> selectProductByName(String name);
	//상품 가격 검색 ( 상품 가격을 입력하면 그 가격이하의 모든 상품 정보 보여줌)
	List<Product> selectProductByPrice(int price);
	//제품 번호로 검색
	Product selectProductByNum(String num);
	//제품 번호로 삭제
	int deleteProduct(String num);
	//제품번호와 가격으로 같은 번호를 같아 가격 업데이트 
	int updateProduct(Product product);
}

