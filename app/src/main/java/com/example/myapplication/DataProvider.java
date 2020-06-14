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
        book1.add("A global phenomenon and cornerstone of contemporary children’s literature, J.K. Rowling’s Harry Potter series is both universally adored and critically acclaimed. Now, experience the magic as you’ve never heard it before.");
        book.put(1,book1);

        List<String> book2 = new ArrayList<String>();
        book2.add("Harry Potter et la Chambre des Secrets");
        book2.add("J.K. Rowling");
        book2.add("Peu avant la rentrée, Harry Potter reçoit l'elfe Dobby, qui lui conseille étrangement de ne pas retourner à l'école des sorciers Poudlard. Le jeune héro ignore l'avertissement... Entre deux matches de Quidditch, Harry et ses fidèles amis Ron et Hermione cherchent coûte que coûte à percer le mystère de la Secrets.");

        book.put(2,book2);

        List<String> book3 = new ArrayList<String>();
        book3.add("Harry Potter et le Prisonnier d'Azkaban");
        book3.add("J.K. Rowling");
        book3.add("Sirius Black, un dangereux criminel proche de Voldemort, s'est échappé de la forteresse d'Azkaban et recherche Harry Potter. La troisième rentrée de notre célèbre sorcier à l'école Poudlard est donc particulièrement dangereuse... Avec Ron et Hermione, il prend des cours de divination, apprend à lancer un Patronus, dresse des hippogriffes... ");
        book.put(3,book3);

        List<String> book4 = new ArrayList<String>();
        book4.add("Harry Potter et la Coupe de Feu");
        book4.add("J.K. Rowling");
        book4.add("Harry Potter a quatorze ans, il débute sa quatrième année à Poudlard avec Ron et Hermione. Une grande nouvelle attend les élèves de Poudlard : ils vont participer au grand tournoi de magie où s'affronteront les plus célèbres écoles de sorcellerie venues du monde entier. Harry se réjouit... Trop vite. Il va se trouver plongé au cœur des événements les plus dramatiques qu'il ait jamais eu à affronter.");
        book.put(4,book4);

        List<String> book5 = new ArrayList<String>();
        book5.add("Harry Potter et l'Ordre du Phénix");
        book5.add("J.K. Rowling");
        book5.add("L'école de sorcellerie Poudlard n'a plus rien de secret pour Harry Potter. Mais il est très anxieux... L'adolescence, les examens, la présence des membres de l'Ordre du Phénix et ces étranges cauchemars... Car Voldemort est bel et bien de retour. Le ministère de la Magie semble ne pas prendre la menace au sérieux, contrairement à Dumbledore. ");
        book.put(5,book5);

        List<String> book6 = new ArrayList<String>();
        book6.add("Harry Potter et le Prince de Sang-Mêlé");
        book6.add("J.K. Rowling");
        book6.add("Lors de cette sixième rentrée à l'école de sorcellerie Poudlard, Harry Potter se prépare à retrouver ses amis Ron et Hermione. Pourquoi Dumbledore vient-il chercher Harry en personne chez les Dursley ? Dans quels extraordinaires voyages au cœur de la mémoire va-t-il l'entraîner ? Émotion, humour, art du suspense...");
        book.put(6,book6);

        List<String> book7 = new ArrayList<String>();
        book7.add("Harry Potter et les Reliques de la Mort");
        book7.add("J.K. Rowling");
        book7.add("Cette année, Harry a dix-sept ans et ne retourne pas à Poudlard. Avec Ron et Hermione, il se consacre à la dernière mission confiée par Dumbledore. Mais le Seigneur des Ténèbres règne en maître. Traqués, les trois fidèles amis sont contraints à la clandestinité. D'épreuves en révélations, le courage, les choix et les sacrifices.");
        book.put(7,book7);

        List<String> book8 = new ArrayList<String>();
        book8.add("The Fellowship of the Ring");
        book8.add("J.R.R. Tolkien");
        book8.add("Inspired by The Hobbit and begun in 1937, The Lord of the Rings is a trilogy that J.R.R. Tolkien created to provide the necessary background of history for Elvish tongues\". From these academic aspirations was born one of the most popular and imaginative works in English literature");
        book.put(8,book8);

        List<String> book9 = new ArrayList<String>();
        book9.add("The Two Towers");
        book9.add("J.R.R. Tolkien");
        book9.add("The Two Towers is the second volume of J.R.R. Tolkien's epic saga, The Lord of the Rings. The Fellowship has been forced to split up. Frodo and Sam must continue alone towards Mount Doom, where the One Ring must be destroyed. Meanwhile, at Helm’s Deep and Isengard, the first great battles of the War of the Ring take shape.");
        book.put(9,book9);

        List<String> book10 = new ArrayList<String>();
        book10.add("The Return of the King");
        book10.add("J.R.R. Tolkien");
        book10.add("The Return of the King is the towering climax to J. R. R. Tolkien’s trilogy that tells the saga of the hobbits of Middle-earth and the great War of the Rings. In this concluding volume, Frodo and Sam make a terrible journey to the heart of the Land of the Shadow in a final reckoning with the power of Sauron.");
        book.put(10,book10);


        return book;
    }

    public static List<Book> getFictionBooks() {
        List<Book> booksList = new ArrayList<Book>();
        Map<Integer, List<String>> books = generateFictionInfo();
        for (Integer key : books.keySet()) {
            String bookCoverName = "f"+String.valueOf(key)+"_1";
            String titleName = books.get(key).get(0);
            String authorName = books.get(key).get(1);
            String content = books.get(key).get(2);
            String image2 = "f"+String.valueOf(key)+"_2";
            String image3 = "f"+String.valueOf(key)+"_3";
            int count = (int) (Math.random()*50);
            Book book = new Book(bookCoverName, titleName, authorName, content, image2, image3, count);
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
        book1.add("In 1521, Suleiman the Magnificent, Muslim ruler of the Ottoman Empire at the height of its power, dispatched an invasion fleet to the Christian island of Rhodes. This would prove to be the opening shot in an epic struggle between rival empires and faiths for control of the Mediterranean and the center of the world.");
        hisBook.put(1, book1);

        List<String> book2 = new ArrayList<String>();
        book2.add("Osman's Dream: The History of the Ottoman Empire");
        book2.add("Caroline Finkel");
        book2.add("The Ottoman Empire was one of the largest and most influential empires in world history. Its reach extended to three continents and it survived for more than six centuries, but its history is too often colored by the memory of its bloody final throes on the battlefields of World War I. ");
        hisBook.put(2, book2);

        List<String> book3 = new ArrayList<String>();
        book3.add("The Art of Sword Combat: A 1568 German Treatise on Swordmanship");
        book3.add("Joachim Meyer");
        book3.add("Following the success of Jeffrey L. Forgeng’s translation of Joachim Meyer’s The Art of Sword Combat the author was alerted to an earlier recension of the work which was discovered in Lund University Library in Sweden.The manuscript is illustrated with thirty watercolor images and seven ink diagrams.");
        hisBook.put(3,book3);

        List<String> book4 = new ArrayList<String>();
        book4.add("Mirrors of a Disaster: The Spanish Military Conquest of America");
        book4.add("Gérard Chaliand");
        book4.add("In Mirrors of a Disaster, Gérard Chaliand narrates the major events that followed the Spanish conquest of Mexico and Peru with the scope and rhythm of an epic poem. He seeks to make meaningful the strict chronicle of a conquest through those who lived it.");
        hisBook.put(4,book4);

        List<String> book5 = new ArrayList<String>();
        book5.add("Samurai vs Ashigaru: Japan 1543–75");
        book5.add("Stephen Turnbull");
        book5.add("During the 16th century, Japan underwent a military revolution, characterized by the deployment of large armies, the introduction of firearms, and an eventual shift towards fighting on foot. This study encapsulates these great changes through an exploration of the experience at the ground of three key battles");
        hisBook.put(5,book5);

        List<String> book6 = new ArrayList<String>();
        book6.add("The Six Wives Of Henry VIII");
        book6.add("Antonia Fraser");
        book6.add("This acclaimed best seller from popular historian Alison Weir is a fascinating look at the Tudor family dynasty and its most infamous ruler. The Six Wives of Henry VIII brings to life England’s oft-married monarch and the six wildly different but equally fascinating women who married him. Gripping from the first sentence to the last and loaded with fascinating details.");
        hisBook.put(6,book6);

        List<String> book7 = new ArrayList<String>();
        book7.add("Sir Henry Lee (1533-1611): Elizabethan Courtier");
        book7.add("Sue Simpson");
        book7.add("A favourite of Queen Elizabeth I, Sir Henry Lee was known as ’the most accomplished cavaliero’ in England. This handsome, entertaining and highly convivial gentleman was an important participant in life at court as Elizabeth’s tournament champion. ");
        hisBook.put(7,book7);

        List<String> book8 = new ArrayList<String>();
        book8.add("The Sword in the Age of Chivalry");
        book8.add("Ewart Oakeshott");
        book8.add("The resplendent image of the medieval knight is symbolised by his sword, a lethal weapon on the battlefield and a badge of chivalry in that complex social code. Ewart Oakeshott draws on his extensive research to recount the history of the sword from the knightly successors of the Viking weapon to the emergence of the Renaissance sword - roughly from 1050 to 1550.");
        hisBook.put(8,book8);

        List<String> book9 = new ArrayList<String>();
        book9.add("Tenochtitlan 1519–21: Clash of Civilizations");
        book9.add("Si Sheppard");
        book9.add("In 1519, the Conquistador Hernán Cortés landed on the mainland of the Americas. His quest to serve God, win gold, and achieve glory drove him into the heartland of what is now Mexico, where no European had ever set foot before. He marched towards to the majestic city of Tenochtitlan, floating like a jewel in the midst of Lake Texcoco.");
        hisBook.put(9,book9);

        List<String> book10 = new ArrayList<String>();
        book10.add("Armada Pa 05");
        book10.add("Garrett Mattingly");
        book10.add("Chronicling one of the most spectacular events of the sixteenth century, The Armada is the definitive story of the English fleet’s infamous defeat of the Spanish Armada in 1588. The esteemed and critically acclaimed historian Garrett Mattingly explores all dimensions of the naval campaign, which captured the attention of the European world and played a deciding role in the settlement of the New World.");
        hisBook.put(10,book10);

        return hisBook;
    }

    public static List<Book> getHistoryBooks() {
        List<Book> booksList = new ArrayList<Book>();
        Map<Integer, List<String>> books = generateHistoryInfo();
        for (Integer key : books.keySet()) {
            String bookCoverName = "h"+String.valueOf(key)+"_1";
            String titleName = books.get(key).get(0);
            String authorName = books.get(key).get(1);
            String content = books.get(key).get(2);
            String image2 = "h"+String.valueOf(key)+"_2";
            String image3 = "h"+String.valueOf(key)+"_3";
            int count = (int) (Math.random()*50);
            Book book = new Book(bookCoverName, titleName, authorName, content, image2, image3, count);

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
        book1.add("Imagine a world where almost everyone wakes up inspired to go to work, feels trusted and valued during the day, then returns home feeling fulfilled. This is not a crazy, idealized notion. ");
        bisBook.put(1, book1);

        List<String> book2 = new ArrayList<String>();
        book2.add("Drive: The Surprising Truth About What Motivates Us");
        book2.add("Daniel H. Pink");
        book2.add("Most people believe that the best way to motivate is with rewards like money—the carrot-and-stick approach. That's a mistake, says Daniel H. Pink. In this provocative and persuasive new book, he asserts that the secret to high performance and satisfaction-at work, at school, and at home—is the deeply human need to direct our own lives, to learn and create new things, and to do better by ourselves and our world.");
        bisBook.put(2, book2);

        List<String> book3 = new ArrayList<String>();
        book3.add("The Daily Stoic: 366 Meditations on Wisdom, Perseverance, and the Art of Living");
        book3.add("Ryan Holiday");
        book3.add("Why have history's greatest minds—from George Washington to Frederick the Great to Ralph Waldo Emerson, along with today's top performers from Super Bowl-winning football coaches to CEOs and celebrities—embraced the wisdom of the ancient Stoics? Because they realize that the most valuable wisdom is timeless and that philosophy is for living a better life, not a classroom exercise.");
        bisBook.put(3,book3);

        List<String> book4 = new ArrayList<String>();
        book4.add("Getting to Yes: Negotiating Agreement Without Giving In");
        book4.add("Roger Fisher");
        book4.add("Since its original publication nearly thirty years ago, Getting to Yes has helped millions of people learn a better way to negotiate. One of the primary business texts of the modern era, it is based on the work of the Harvard Negotiation Project, a group that deals with all levels of negotiation and conflict resolution.");
        bisBook.put(4,book4);

        List<String> book5 = new ArrayList<String>();
        book5.add("The Challenger Sale: Taking Control of the Customer Conversation");
        book5.add("Matthew Dixon");
        book5.add("The need to understand what top-performing reps are doing that their average performing colleagues are not drove Matthew Dixon, Brent Adamson, and their colleagues at Corporate Executive Board to investigate the skills.");
        bisBook.put(5,book5);

        List<String> book6 = new ArrayList<String>();
        book6.add("Originals: How Non-conformists Change the World");
        book6.add("Adam Grant");
        book6.add("With Give and Take, Adam Grant introduced a landmark new paradigm for success. In Originals he again addresses the challenge of improving the world, but now from the perspective of becoming original: choosing to champion novel ideas and values that go against the grain, battle conformity, and buck outdated traditions.");
        bisBook.put(6,book6);

        List<String> book7 = new ArrayList<String>();
        book7.add("Difficult Conversations: How to Discuss What Matters Most");
        book7.add("Douglas Stone");
        book7.add(" Difficult Conversations provides a step-by-step approach to having those tough conversations with less stress and more success. you'll learn how to:* Decipher the underlying structure of every difficult conversation\n" +
                "* Start a conversation without defensiveness\n" +
                "* Listen for the meaning of what is not said\n" +
                "* Stay balanced in the face of attacks and accusations\n" +
                "* Move from emotion to productive problem solving");
        bisBook.put(7,book7);

        List<String> book8 = new ArrayList<String>();
        book8.add("Stillness is the Key: An Ancient Strategy for Modern Life");
        book8.add("Ryan Holiday");
        book8.add("All great leaders, thinkers, artists, athletes, and visionaries share one indelible quality. It enables them to conquer their tempers. To avoid distraction and discover great insights. To achieve happiness and do the right thing. Ryan Holiday calls it stillness--to be steady while the world spins around you.");
        bisBook.put(8,book8);

        List<String> book9 = new ArrayList<String>();
        book9.add("High Output Management");
        book9.add("Andrew S. Grove");
        book9.add("Grove covers techniques for creating highly productive teams, demonstrating methods of motivation that lead to peak performance—throughout, High Output Management is a practical handbook for navigating real-life business scenarios and a powerful management manifesto with the ability to revolutionize the way we work.");
        bisBook.put(9,book9);

        List<String> book10 = new ArrayList<String>();
        book10.add("The Infinite Game");
        book10.add("Simon Sinek");
        book10.add("In this revelatory new book, Simon Sinek offers a framework for leading with an infinite mindset. On one hand, none of us can resist the fleeting thrills of a promotion earned or a tournament won, yet these rewards fade quickly. In pursuit of a Just Cause, we will commit to a vision of a future world so appealing that we will build it day after day. Although we do not know the exact form this world will take, working toward it gives our work and our life meaning.");
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
            String content = books.get(key).get(2);
            String image2 = "b"+String.valueOf(key)+"_2";
            String image3 = "b"+String.valueOf(key)+"_3";
            int count = (int) (Math.random()*50);
            Book book = new Book(bookCoverName, titleName, authorName, content, image2, image3, count);
            booksList.add(book);
        }

        return booksList;
    }
}
