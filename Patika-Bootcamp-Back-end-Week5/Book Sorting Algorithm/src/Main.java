import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> library = new TreeSet<>(new NameComparator());

        library.add(new Book("The Hobbit",310,"J. R. R. Tolkien","21 September 1937"));
        library.add(new Book("The Fellowship of the Ring",423,"J. R. R. Tolkien","29 July 1954"));
        library.add(new Book("The Two Towers",352,"J. R. R. Tolkien","11 November 1954"));
        library.add(new Book("The Return of the King",416,"J. R. R. Tolkien","20 October 1955"));
        library.add(new Book("The Silmarillion",365,"J. R. R. Tolkien","15 September 1977"));
        library.add(new Book("The Children of Hurin",320,"J. R. R. Tolkien","16 April 2007"));
        library.add(new Book("Beren and Luthien",297,"J. R. R. Tolkien","1 June 2017"));
        library.add(new Book("The Fall of Gondolin",304,"J. R. R. Tolkien","30 August 2018"));

        Iterator<Book> itr = library.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next().getBookName());
        }

        TreeSet<Book> library2 = new TreeSet<>(new PageNumberComparator().reversed());

        library2.add(new Book("The Hobbit",310,"J. R. R. Tolkien","21 September 1937"));
        library2.add(new Book("The Fellowship of the Ring",423,"J. R. R. Tolkien","29 July 1954"));
        library2.add(new Book("The Two Towers",352,"J. R. R. Tolkien","11 November 1954"));
        library2.add(new Book("The Return of the King",416,"J. R. R. Tolkien","20 October 1955"));
        library2.add(new Book("The Silmarillion",365,"J. R. R. Tolkien","15 September 1977"));
        library2.add(new Book("The Children of Hurin",320,"J. R. R. Tolkien","16 April 2007"));
        library2.add(new Book("Beren and Luthien",297,"J. R. R. Tolkien","1 June 2017"));
        library2.add(new Book("The Fall of Gondolin",304,"J. R. R. Tolkien","30 August 2018"));

        Iterator<Book> itr2 = library2.iterator();

        while (itr2.hasNext()) {
            System.out.println(itr2.next().getBookPageNumber());
        }
    }
}
