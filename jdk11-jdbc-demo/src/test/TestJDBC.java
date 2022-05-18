package test;

public class TestJDBC {
	public static void main(String[] args) {
		
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("jdbc driver loading");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
