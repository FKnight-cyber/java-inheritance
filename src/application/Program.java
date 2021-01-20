package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException{
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		List<Product> productsList = new ArrayList<>();
		
		System.out.println("Enter the number of products");
		int n = sc.nextInt();
		
		for(int i = 1;i <= n; i++) {
			System.out.print("common, used or imported? ");
			char ch = sc.next().charAt(0);
			
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if(ch == 'i') {
				System.out.print("Customs Fee: ");
				Double customsFee = sc.nextDouble();
				productsList.add(new ImportedProduct(name, price, customsFee));
			}
			else if(ch == 'u') {
				System.out.print("Manufacture Date: ");
				Date manufactureDate = sdf.parse(sc.next());
				productsList.add(new UsedProduct(name, price, manufactureDate));
			}else
			productsList.add(new Product(name, price));
		}
		
		for(Product p : productsList) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}
}
