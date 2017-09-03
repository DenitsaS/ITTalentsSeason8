package clients;
import products.ProductByCount;
import products.ProductByWeight;

public interface IClient {
	void addProductByWeight(String name, int weight);
	void addProductByCount(String name, int count);
	void removeProductByWeight(String name);
	void removeProductByCount(String name);
	void buyProductsinCart();



}
