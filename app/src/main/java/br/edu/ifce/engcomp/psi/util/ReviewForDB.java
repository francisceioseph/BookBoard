package br.edu.ifce.engcomp.psi.util;

import android.content.Context;

import br.edu.ifce.engcomp.psi.dao.ReviewBookDAO;
import br.edu.ifce.engcomp.psi.model.Book;
import br.edu.ifce.engcomp.psi.model.Person;
import br.edu.ifce.engcomp.psi.model.ReviewBook;

/**
 * Created by FAMÍLIA on 09/04/2015.
 */
public class ReviewForDB {

    public static void insertReviewBookDB(Context context) {
        ReviewBookDAO reviewBookDAO = new ReviewBookDAO(context);

        //Tres Resenhas para cada livro
        ReviewBook reviewBook = new ReviewBook();
        reviewBook.setDescription(ReviewRepository.gt1_review1);
        reviewBook.setBook(new Book(1));
        reviewBook.setPerson(new Person(4));

        reviewBookDAO.insert(reviewBook);

        ReviewBook reviewBook2 = new ReviewBook();
        reviewBook2.setDescription(ReviewRepository.gt1_review2);
        reviewBook2.setBook(new Book(1));
        reviewBook2.setPerson(new Person(5));

        reviewBookDAO.insert(reviewBook2);

        ReviewBook reviewBook3 = new ReviewBook();
        reviewBook3.setDescription(ReviewRepository.gt1_review3);
        reviewBook3.setBook(new Book(1));
        reviewBook3.setPerson(new Person(6));

        reviewBookDAO.insert(reviewBook3);

        //-------------------------
        ReviewBook reviewBook4 = new ReviewBook();
        reviewBook4.setDescription(ReviewRepository.gt2_review1);
        reviewBook4.setBook(new Book(2));
        reviewBook4.setPerson(new Person(7));

        reviewBookDAO.insert(reviewBook4);

        ReviewBook reviewBook5 = new ReviewBook();
        reviewBook5.setDescription(ReviewRepository.gt2_review2);
        reviewBook5.setBook(new Book(2));
        reviewBook5.setPerson(new Person(8));

        reviewBookDAO.insert(reviewBook5);

        ReviewBook reviewBook6 = new ReviewBook();
        reviewBook6.setDescription(ReviewRepository.gt2_review3);
        reviewBook6.setBook(new Book(2));
        reviewBook6.setPerson(new Person(9));

        reviewBookDAO.insert(reviewBook6);
        //----------------------------------

        ReviewBook reviewBook7 = new ReviewBook();
        reviewBook7.setDescription(ReviewRepository.umabreve_review1);
        reviewBook7.setBook(new Book(3));
        reviewBook7.setPerson(new Person(4));

        reviewBookDAO.insert(reviewBook7);

        ReviewBook reviewBook8 = new ReviewBook();
        reviewBook8.setDescription(ReviewRepository.umabreve_review2);
        reviewBook8.setBook(new Book(3));
        reviewBook8.setPerson(new Person(5));

        reviewBookDAO.insert(reviewBook8);

        ReviewBook reviewBook9 = new ReviewBook();
        reviewBook9.setDescription(ReviewRepository.umabreve_review3);
        reviewBook9.setBook(new Book(3));
        reviewBook9.setPerson(new Person(10));

        reviewBookDAO.insert(reviewBook9);

        //---------------------------------
        ReviewBook reviewBook10 = new ReviewBook();
        reviewBook10.setDescription(ReviewRepository.contato_review1);
        reviewBook10.setBook(new Book(4));
        reviewBook10.setPerson(new Person(5));

        reviewBookDAO.insert(reviewBook10);

        ReviewBook reviewBook11 = new ReviewBook();
        reviewBook11.setDescription(ReviewRepository.contato_review2);
        reviewBook11.setBook(new Book(4));
        reviewBook11.setPerson(new Person(7));

        reviewBookDAO.insert(reviewBook11);

        ReviewBook reviewBook12 = new ReviewBook();
        reviewBook12.setDescription(ReviewRepository.contato_review3);
        reviewBook12.setBook(new Book(4));
        reviewBook12.setPerson(new Person(8));

        reviewBookDAO.insert(reviewBook12);

        //-------------------------------

        ReviewBook reviewBook13 = new ReviewBook();
        reviewBook13.setDescription(ReviewRepository.ailha_review1);
        reviewBook13.setBook(new Book(5));
        reviewBook13.setPerson(new Person(4));

        reviewBookDAO.insert(reviewBook13);

        ReviewBook reviewBook14 = new ReviewBook();
        reviewBook14.setDescription(ReviewRepository.ailha_review2);
        reviewBook14.setBook(new Book(5));
        reviewBook14.setPerson(new Person(5));

        reviewBookDAO.insert(reviewBook14);

        ReviewBook reviewBook15 = new ReviewBook();
        reviewBook15.setDescription(ReviewRepository.ailha_review3);
        reviewBook15.setBook(new Book(5));
        reviewBook15.setPerson(new Person(9));

        reviewBookDAO.insert(reviewBook15);

        //----------------------------------------

        ReviewBook reviewBook16 = new ReviewBook();
        reviewBook16.setDescription(ReviewRepository.farenheit_review1);
        reviewBook16.setBook(new Book(6));
        reviewBook16.setPerson(new Person(7));

        reviewBookDAO.insert(reviewBook16);

        ReviewBook reviewBook17 = new ReviewBook();
        reviewBook17.setDescription(ReviewRepository.farenheit_review2);
        reviewBook17.setBook(new Book(6));
        reviewBook17.setPerson(new Person(8));

        reviewBookDAO.insert(reviewBook17);

        ReviewBook reviewBook18 = new ReviewBook();
        reviewBook18.setDescription(ReviewRepository.farenheit_review3);
        reviewBook18.setBook(new Book(6));
        reviewBook18.setPerson(new Person(10));

        reviewBookDAO.insert(reviewBook18);

        //----------------------------------------------

        ReviewBook reviewBook19 = new ReviewBook();
        reviewBook19.setDescription(ReviewRepository.onomedovento_review1);
        reviewBook19.setBook(new Book(7));
        reviewBook19.setPerson(new Person(5));

        reviewBookDAO.insert(reviewBook19);

        ReviewBook reviewBook20 = new ReviewBook();
        reviewBook20.setDescription(ReviewRepository.onomedovento_review2);
        reviewBook20.setBook(new Book(7));
        reviewBook20.setPerson(new Person(6));

        reviewBookDAO.insert(reviewBook20);

        ReviewBook reviewBook21 = new ReviewBook();
        reviewBook21.setDescription(ReviewRepository.onomedovento_review3);
        reviewBook21.setBook(new Book(7));
        reviewBook21.setPerson(new Person(10));

        reviewBookDAO.insert(reviewBook21);

        //-----------------------------------------------------

        ReviewBook reviewBook22 = new ReviewBook();
        reviewBook22.setDescription(ReviewRepository.otemordosabio_review1);
        reviewBook22.setBook(new Book(8));
        reviewBook22.setPerson(new Person(4));

        reviewBookDAO.insert(reviewBook22);

        ReviewBook reviewBook23 = new ReviewBook();
        reviewBook23.setDescription(ReviewRepository.otemordosabio_review2);
        reviewBook23.setBook(new Book(8));
        reviewBook23.setPerson(new Person(7));

        reviewBookDAO.insert(reviewBook23);

        ReviewBook reviewBook24 = new ReviewBook();
        reviewBook24.setDescription(ReviewRepository.otemordosabio_review3);
        reviewBook24.setBook(new Book(8));
        reviewBook24.setPerson(new Person(9));

        reviewBookDAO.insert(reviewBook24);

        //----------------------------------------------------------
        ReviewBook reviewBook25 = new ReviewBook();
        reviewBook25.setDescription(ReviewRepository.teoremadefermat_review1);
        reviewBook25.setBook(new Book(9));
        reviewBook25.setPerson(new Person(5));

        reviewBookDAO.insert(reviewBook25);

        ReviewBook reviewBook26 = new ReviewBook();
        reviewBook26.setDescription(ReviewRepository.teoremadefermat_review2);
        reviewBook26.setBook(new Book(9));
        reviewBook26.setPerson(new Person(6));

        reviewBookDAO.insert(reviewBook26);

        ReviewBook reviewBook27 = new ReviewBook();
        reviewBook27.setDescription(ReviewRepository.teoremadefermat_review3);
        reviewBook27.setBook(new Book(9));
        reviewBook27.setPerson(new Person(8));

        reviewBookDAO.insert(reviewBook27);

        //---------------------------------------

        ReviewBook reviewBook28 = new ReviewBook();
        reviewBook28.setDescription(ReviewRepository.poderhabito_review1);
        reviewBook28.setBook(new Book(10));
        reviewBook28.setPerson(new Person(5));

        reviewBookDAO.insert(reviewBook28);

        ReviewBook reviewBook29 = new ReviewBook();
        reviewBook29.setDescription(ReviewRepository.poderhabito_review2);
        reviewBook29.setBook(new Book(10));
        reviewBook29.setPerson(new Person(6));

        reviewBookDAO.insert(reviewBook29);

        ReviewBook reviewBook30 = new ReviewBook();
        reviewBook30.setDescription(ReviewRepository.poderhabito_review3);
        reviewBook30.setBook(new Book(10));
        reviewBook30.setPerson(new Person(10));

        reviewBookDAO.insert(reviewBook30);

    }
}
