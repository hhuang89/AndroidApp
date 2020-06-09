package com.example.myapplication;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    public static Map<Integer, List<String>> generateFictionInfo() {
        Map<Integer, List<String>> book =
                new LinkedHashMap<Integer, List<String>>();
        //Title,Author
        List<String> book1 = new ArrayList<String>();
        book1.add("Harry Potter and the Sorcerer's Stone");
        book1.add("J.K. Rowling");
        book.put(1,book1);

        List<String> book2 = new ArrayList<String>();
        book2.add("Harry Potter et la Chambre des Secrets");
        book2.add("J.K. Rowling");
        book.put(2,book2);

        List<String> book3 = new ArrayList<String>();
        book3.add("Harry Potter et le Prisonnier d'Azkaban");
        book3.add("J.K. Rowling");
        book.put(3,book3);

        List<String> book4 = new ArrayList<String>();
        book4.add("Harry Potter et la Coupe de Feu");
        book4.add("J.K. Rowling");
        book.put(4,book4);

        List<String> book5 = new ArrayList<String>();
        book5.add("Harry Potter et l'Ordre du Phénix");
        book5.add("J.K. Rowling");
        book.put(5,book5);

        List<String> book6 = new ArrayList<String>();
        book6.add("Harry Potter et le Prince de Sang-Mêlé");
        book6.add("J.K. Rowling");
        book.put(6,book6);

        List<String> book7 = new ArrayList<String>();
        book7.add("Harry Potter et les Reliques de la Mort");
        book7.add("J.K. Rowling");
        book.put(7,book7);

        List<String> book8 = new ArrayList<String>();
        book8.add("The Fellowship of the Ring");
        book8.add("J.R.R. Tolkien");
        book.put(8,book8);

        List<String> book9 = new ArrayList<String>();
        book9.add("The Two Towers");
        book9.add("J.R.R. Tolkien");
        book.put(9,book9);

        List<String> book10 = new ArrayList<String>();
        book10.add("The Return of the King");
        book10.add("J.R.R. Tolkien");
        book.put(10,book10);


        return book;
    }

    public static List<Book> getBooks() {
        List<Book> booksList = new ArrayList<Book>();
        Map<Integer, List<String>> books = generateFictionInfo();
        for (Integer key : books.keySet()) {
            String bookCoverName = "f"+String.valueOf(key)+"_1";
            String titleName = books.get(key).get(0);
            String authorName = books.get(key).get(1);

            Book book = new Book(bookCoverName, titleName, authorName);
            booksList.add(book);
        }

        return booksList;
    }

    public static Map<Integer, List<String>> generateHistoryInfo() {
        Map<Integer, List<String>> hisBook =
                new LinkedHashMap<Integer, List<String>>();
        //Title,Author
        List<String> book1 = new ArrayList<String>();
        book1.add("Empires of the Sea: The Final Battle for the Mediterranean");
        book1.add("Roger Crowley");
        hisBook.put(1, book1);

        List<String> book2 = new ArrayList<String>();
        book2.add("Osman's Dream: The History of the Ottoman Empire");
        book2.add("Caroline Finkel");
        hisBook.put(2, book2);

        List<String> book3 = new ArrayList<String>();
        book3.add("The Art of Sword Combat: A 1568 German Treatise on Swordmanship");
        book3.add("Joachim Meyer");
        hisBook.put(3,book3);

        List<String> book4 = new ArrayList<String>();
        book4.add("Mirrors of a Disaster: The Spanish Military Conquest of America");
        book4.add("Gérard Chaliand");
        hisBook.put(4,book4);

        List<String> book5 = new ArrayList<String>();
        book5.add("Samurai vs Ashigaru: Japan 1543–75");
        book5.add("Stephen Turnbull");
        hisBook.put(5,book5);

        List<String> book6 = new ArrayList<String>();
        book6.add("The Six Wives Of Henry VIII");
        book6.add("Antonia Fraser");
        hisBook.put(6,book6);

        List<String> book7 = new ArrayList<String>();
        book7.add("Sir Henry Lee (1533-1611): Elizabethan Courtier");
        book7.add("Sue Simpson");
        hisBook.put(7,book7);

        List<String> book8 = new ArrayList<String>();
        book8.add("The Sword in the Age of Chivalry");
        book8.add("Ewart Oakeshott");
        hisBook.put(8,book8);

        List<String> book9 = new ArrayList<String>();
        book9.add("Tenochtitlan 1519–21: Clash of Civilizations");
        book9.add("Si Sheppard");
        hisBook.put(9,book9);

        List<String> book10 = new ArrayList<String>();
        book10.add("Armada Pa 05");
        book10.add("Garrett Mattingly");
        hisBook.put(10,book10);

        return hisBook;
    }

    public static List<Book> getFictionBooks() {
        List<Book> booksList = new ArrayList<Book>();
        Map<Integer, List<String>> books = generateHistoryInfo();
        for (Integer key : books.keySet()) {
            String bookCoverName = "h"+String.valueOf(key)+"_1";
            String titleName = books.get(key).get(0);
            String authorName = books.get(key).get(1);

            Book book = new Book(bookCoverName, titleName, authorName);
            booksList.add(book);
        }

        return booksList;
    }

    public static Map<Integer, List<String>> generateBusinessInfo() {
        Map<Integer, List<String>> bisBook =
                new LinkedHashMap<Integer, List<String>>();
        //Title,Author
        List<String> book1 = new ArrayList<String>();
        book1.add("Leaders Eat Last: Why Some Teams Pull Together and Others Don't");
        book1.add("Simon Sinek");
        bisBook.put(1, book1);

        List<String> book2 = new ArrayList<String>();
        book2.add("Drive: The Surprising Truth About What Motivates Us");
        book2.add("Daniel H. Pink");
        bisBook.put(2, book2);

        List<String> book3 = new ArrayList<String>();
        book3.add("The Daily Stoic: 366 Meditations on Wisdom, Perseverance, and the Art of Living");
        book3.add("Ryan Holiday");
        bisBook.put(3,book3);

        List<String> book4 = new ArrayList<String>();
        book4.add("Getting to Yes: Negotiating Agreement Without Giving In");
        book4.add("Roger Fisher");
        bisBook.put(4,book4);

        List<String> book5 = new ArrayList<String>();
        book5.add("The Challenger Sale: Taking Control of the Customer Conversation");
        book5.add("Matthew Dixon");
        bisBook.put(5,book5);

        List<String> book6 = new ArrayList<String>();
        book6.add("Originals: How Non-conformists Change the World");
        book6.add("Adam Grant");
        bisBook.put(6,book6);

        List<String> book7 = new ArrayList<String>();
        book7.add("Difficult Conversations: How to Discuss What Matters Most");
        book7.add("Douglas Stone");
        bisBook.put(7,book7);

        List<String> book8 = new ArrayList<String>();
        book8.add("Stillness is the Key: An Ancient Strategy for Modern Life");
        book8.add("Ryan Holiday");
        bisBook.put(8,book8);

        List<String> book9 = new ArrayList<String>();
        book9.add("High Output Management");
        book9.add("Andrew S. Grove");
        bisBook.put(9,book9);

        List<String> book10 = new ArrayList<String>();
        book10.add("The Infinite Game");
        book10.add("Simon Sinek");
        bisBook.put(10,book10);

        return bisBook;
    }

    public static List<Book> getBusinessBooks() {
        List<Book> booksList = new ArrayList<Book>();
        Map<Integer, List<String>> books = generateBusinessInfo();
        for (Integer key : books.keySet()) {
            String bookCoverName = "b"+String.valueOf(key)+"_1";
            String titleName = books.get(key).get(0);
            String authorName = books.get(key).get(1);

            Book book = new Book(bookCoverName, titleName, authorName);
            booksList.add(book);
        }

        return booksList;
    }
}
