import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr{

	List<Product> product = new ArrayList<Product>();
	
	private static ProductMgrImpl instance;
	private ProductMgrImpl(){
		
	}
	
	public static ProductMgrImpl getInstance() {
		if(instance == null) instance = new ProductMgrImpl();
		return instance;
	}
	
	public void getListData() {
		GetDataThread st = new GetDataThread();
		st.start();
	}

	public void input(Product pro) throws DuplicateException{
		for(Product p : product) {
			if(p.getProductNum().equals(pro.getProductName()))
				throw new DuplicateException();
		}
		product.add(pro);
	}

	
	public List<Product> searchAll() {
			return product;
	}

	
	public Product searchProductNum(String productNumber) throws CodeNotFoundException {
		for(Product p : product) {
			if(p.getProductNum().equals(productNumber)) {
				return p;
			}
		}
		
		throw new CodeNotFoundException();
	}
	
	public List<Product> searchProductName(String productName) {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p.getProductName().contains(productName)) {
				b.add(p);
			}
		}

		return b;
	}
	
//	모르는 부분
	public List<Product> searchTV() {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof TV) {
				b.add(p);
			}
		}
		
		return b;
	}
	
	public List<Product> searchRef() {
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof Refrigerator) {
				b.add(p);
			}
		}
		
		return b;
	}
	
	
	public boolean delete(String productNum) {
		for(int i = 0; i < product.size(); i++) {
			if(product.get(i).getProductNum().equals(productNum)) {
				product.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int totalPrice() {
		int sum = 0;
		for(Product p : product) {
			sum += p.getPrice();
		}
		return sum;
	}

	@Override
	public List<Product> over400Ref() throws ProductNotFoundException{
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof Refrigerator && ((Refrigerator) p).getL() > 400 ) {
				b.add(p);
			}
		}
		if(b.size() == 0)
			throw new ProductNotFoundException();
		
		return b;
	}

	@Override
	public List<Product> over50TV() throws ProductNotFoundException{
		List<Product> b = new ArrayList<Product>();

		for(Product p : product) {
			if(p instanceof TV && ((TV) p).getInch() > 50 ) {
				b.add(p);
			}
		}
		
		if(b.size() == 0)
			throw new ProductNotFoundException();
		
		return b;
	}

	@Override
	public boolean update(String productNum, int price) {
		for(int i = 0; i < product.size(); i++) {
			if(product.get(i).getProductNum().equals(productNum)) {
				Product tmp = product.get(i);
				tmp.setPrice(price);
				product.set(i, tmp);
				return true;
			}
		}
		return false;
	}

	public void sendToServers() {
		ServerThread st = new ServerThread();
		st.start();
		try {
			st.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public class GetDataThread extends Thread{
		public void run() {
			String ip = "localhost";
			int port = 10010;
			List<Product> temp = null;
			
			try ( Socket socket = new Socket(ip, port) ) {
				ObjectOutputStream bro = new ObjectOutputStream(socket.getOutputStream());
				bro.writeObject("open");
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				try {
					temp = (List<Product>) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(Product p : temp) {
					if(p instanceof TV) {
						product.add(p);
					}
				}
				for(Product p : temp) {
					if(p instanceof Refrigerator) {
						product.add(p);
					}
				}
				
				bro.close();
			 } catch ( IOException e) {
				 e.printStackTrace();
			 }
		}
	}
	
	public class ServerThread extends Thread{
		public void run() {
			String ip = "localhost";
			int port = 10010;
			
			try ( Socket socket = new Socket(ip, port) ) {
				
				ObjectOutputStream bro = new ObjectOutputStream(socket.getOutputStream());
				bro.writeObject("close");
				bro.writeObject(product);

				bro.close();
			 } catch ( IOException e) {
				 System.out.println("NetworkSimpleClient exception: " + e.getMessage());
				 e.printStackTrace();
			 }
		}
	}

	public int totalPriceLess(int price) {
		int sum = 0;
		for(Product p : product) {
			if(p.getPrice() <= price)
				sum += p.getPrice();
		}
		return sum;
	}




}