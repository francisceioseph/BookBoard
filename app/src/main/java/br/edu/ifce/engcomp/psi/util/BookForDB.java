package br.edu.ifce.engcomp.psi.util;

import android.content.Context;
import android.content.res.Resources;

import br.edu.ifce.engcomp.psi.bookboard.R;
import br.edu.ifce.engcomp.psi.dao.BookDAO;
import br.edu.ifce.engcomp.psi.model.Book;

/**
 * Created by FAMÍLIA on 25/03/2015.
 */
public class BookForDB {

    public static void getBookForDB(Resources resource, Context context){
        BookDAO bookDAO = new BookDAO(context);

        Book book = new Book();
        book.setTitle("Grerra dos Tronos - As Crônicas de Gelo e Fogo");
        book.setAuthor("George R.R. Martin");
        book.setPublisher("LeYa");
        book.setImage(ImageUtil.getImage(resource,R.drawable.guerradostronos1));
        book.setNumberPage(592);
        book.setSynopsis(SynopsiRepository.gt1);
        bookDAO.insert(book);

        Book book2 = new Book();
        book2.setTitle("Guerra dos Tronos - A Fúria dos Reis");
        book2.setAuthor("George R.R. Martin");
        book2.setPublisher("LeYa");
        book2.setImage(ImageUtil.getImage(resource,R.drawable.guerradostronos2));
        book2.setNumberPage(656);
        book2.setSynopsis(SynopsiRepository.gt2);

        bookDAO.insert(book2);

        Book book3 = new Book();
        book3.setTitle("Uma Breve História do Tempo");
        book3.setAuthor("Stephen Hawking");
        book3.setPublisher("Intrinseca");
        book3.setNumberPage(256);
        book3.setSynopsis(SynopsiRepository.umabreve);
        book3.setImage(ImageUtil.getImage(resource,R.drawable.brevehistoriadotempo));

        bookDAO.insert(book3);

        Book book4 = new Book();
        book4.setTitle("Contato");
        book4.setAuthor("Carl Sagan");
        book4.setPublisher("Companhia de bolso");
        book4.setImage(ImageUtil.getImage(resource,R.drawable.contato));
        book4.setNumberPage(437);
        book4.setSynopsis(SynopsiRepository.contato);
        bookDAO.insert(book4);

        Book book5 = new Book();
        book5.setTitle("A Ilha do Conhecimento");
        book5.setAuthor("Marcelo Gleiser");
        book5.setPublisher("Record");
        book5.setNumberPage(364);
        book5.setSynopsis(SynopsiRepository.ailha);
        book5.setImage(ImageUtil.getImage(resource,R.drawable.ailhadoconhecimento));

        bookDAO.insert(book5);

        Book book6 = new Book();
        book6.setTitle("Fahrenheit 451");
        book6.setAuthor("Ray Bradbury");
        book6.setPublisher("Globo Livros");
        book6.setImage(ImageUtil.getImage(resource,R.drawable.fahrenheit451));
        book6.setNumberPage(215);
        book6.setSynopsis(SynopsiRepository.farenheit);

        bookDAO.insert(book6);

        Book book7 = new Book();
        book7.setTitle("O Nome do Vento");
        book7.setAuthor("Patrick Rothfuss");
        book7.setPublisher("Arqueiro");
        book7.setImage(ImageUtil.getImage(resource,R.drawable.onomedovento));
        book7.setNumberPage(656);
        book7.setSynopsis(SynopsiRepository.onomedovento);

        bookDAO.insert(book7);

        Book book8 = new Book();
        book8.setTitle("O Temor do Sábio");
        book8.setAuthor("Patrick Rothfuss");
        book8.setPublisher("Arqueiro");
        book8.setImage(ImageUtil.getImage(resource,R.drawable.otemordosabio));
        book8.setNumberPage(960);
        book8.setSynopsis(SynopsiRepository.otemordosabio);

        bookDAO.insert(book8);

        Book book9 = new Book();
        book9.setTitle("O Último Teorema de Fermat");
        book9.setAuthor("Simon Singh");
        book9.setPublisher("Record");
        book9.setImage(ImageUtil.getImage(resource,R.drawable.teoremadefermat));
        book9.setNumberPage(328);
        book9.setSynopsis(SynopsiRepository.teoremadefermat);

        bookDAO.insert(book9);

        Book book10 = new Book();
        book10.setTitle("O Poder do Hábito");
        book10.setAuthor("Charles Duhigg");
        book10.setPublisher("Objetiva");
        book10.setImage(ImageUtil.getImage(resource,R.drawable.opoderdohabito));
        book10.setNumberPage(408);
        book10.setSynopsis(SynopsiRepository.poderhabito);

        bookDAO.insert(book10);
    }
}
