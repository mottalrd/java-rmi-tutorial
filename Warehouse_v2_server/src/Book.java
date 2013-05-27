public class Book extends Product{
	
	private static final long serialVersionUID = 1L;

	public Book(String title, String isbn, double price){
               super(title, price);
               this.isbn = isbn;
       }

       public String getDescription(){
               return super.getDescription() + " " + isbn;
       }

       private String isbn;
}

