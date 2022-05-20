package ds.hashtable;

public class App {

	public static void main(String[] args) {
		HashTable table = new HashTable(140);
		table.insert("Apple");
		table.insert("Orange");
		table.insert("Water");
		table.insert("Banana");
		table.insert("Phone");
		table.insert("Africe");
		table.insert("Feeling");
		table.insert("Java");
		table.insert("Algorithm");
		table.insert("Juice");
		
		
		table.displayTable();
		
		System.out.println("---------FIND ELEMENTS-------");
		System.out.println(table.find("Apple"));
		System.out.println(table.find("Algorithm"));
		System.out.println(table.find("Zebra"));
		System.out.println(table.find("Banana"));
		System.out.println(table.find("Orange"));
		System.out.println(table.find("Juice"));
		System.out.println(table.find("Phone"));
		
	}

}
