package com.ss.ch.hibernateCreate;

import com.ss.ch.dao.*;
import com.ss.ch.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class CreateDatabaseTest {


    @Autowired
    private GenreDao genreDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Test
    public void createInsertDatabase() {

        Genre genre1 = new Genre();
        Genre genre2 = new Genre();
        Genre genre3 = new Genre();
        Genre genre4 = new Genre();
        Genre genre5 = new Genre();

        genre1.setName("Test genre1");
        genre2.setName("Test genre2");
        genre3.setName("Test genre3");
        genre4.setName("Test genre4");
        genre5.setName("Test genre5");

        genreDao.save(genre1);
        genreDao.save(genre2);
        genreDao.save(genre3);
        genreDao.save(genre4);
        genreDao.save(genre5);


        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();


        user1.setLogin("Test Login1");
        user1.setPassword("Test Password1");
        user1.seteMail("Test eMail1");
        user1.setName("Test Name1");
        user1.setSurname("Test  Surname1");
        user1.setUrlPicture("Test UrlPicture1");
        user1.setUserRole(UserRole.ADMIN);

        user2.setLogin("Test Login2");
        user2.setPassword("Test Password2");
        user2.seteMail("Test eMail2");
        user2.setName("Test Name2");
        user2.setSurname("Test  Surname2");
        user2.setUrlPicture("Test UrlPicture2");
        user2.setUserRole(UserRole.UN_LOGIN_USER);

        user3.setLogin("Test Login3");
        user3.setPassword("Test Password3");
        user3.seteMail("Test eMail3");
        user3.setName("Test Name3");
        user3.setSurname("Test  Surname2");
        user3.setUrlPicture("Test UrlPicture2");
        user3.setUserRole(UserRole.ADMIN);

        user4.setLogin("Test Login2");
        user4.setPassword("Test Password2");
        user4.seteMail("Test eMail2");
        user4.setName("Test Name2");
        user4.setSurname("Test  Surname2");
        user4.setUrlPicture("Test UrlPicture2");
        user4.setUserRole(UserRole.USER);

        user5.setLogin("Test Login2");
        user5.setPassword("Test Password2");
        user5.seteMail("Test eMail2");
        user5.setName("Test Name2");
        user5.setSurname("Test  Surname2");
        user5.setUrlPicture("Test UrlPicture2");
        user5.setUserRole(UserRole.UN_LOGIN_USER);

        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
        userDao.save(user4);
        userDao.save(user4);

        Comment comment1 = new Comment();
        Comment comment2 = new Comment();
        Comment comment3 = new Comment();
        Comment comment4 = new Comment();
        Comment comment5 = new Comment();

        comment1.setUser(user1);
        comment1.setCreatedDate(new Date());
        comment1.setComment("Test comment1");

        comment2.setUser(user1);
        comment2.setCreatedDate(new Date());
        comment2.setComment("Test comment2");


        comment3.setUser(user2);
        comment3.setCreatedDate(new Date());
        comment3.setComment("Test comment3");

        comment4.setUser(user2);
        comment4.setCreatedDate(new Date());
        comment4.setComment("Test comment4");

        comment5.setUser(user3);
        comment5.setCreatedDate(new Date());
        comment5.setComment("Test comment5");

        commentDao.save(comment1);
        commentDao.save(comment2);
        commentDao.save(comment3);
        commentDao.save(comment4);
        commentDao.save(comment5);


        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();

        Author author1 = new Author();
        Author author2 = new Author();
        Author author3 = new Author();
        Author author4 = new Author();
        Author author5 = new Author();


        book1.setTitle("Test title1");
        book1.setDescription("Test description1");
        book1.setDownloadCounter(2);
        book1.setGenre(genre1);
        book1.setRating(StarRating.NO_STARS);
        book1.setUrlPicture("Test urlPicture1");
        book1.setUser(user1);


        book2.setTitle("Test title2");
        book2.setDescription("Test description2");
        book2.setDownloadCounter(55);
        book2.setGenre(genre2);
        book2.setRating(StarRating.ONE_STARS);
        book2.setUrlPicture("Test urlPicture2");
        book2.setUser(user2);

        book3.setTitle("Test title3");
        book3.setDescription("Test description3");
        book3.setDownloadCounter(33);
        book3.setGenre(genre3);
        book3.setRating(StarRating.THREE_STARS);
        book3.setUrlPicture("Test urlPicture1");
        book3.setUser(user3);

        book4.setTitle("Test title4");
        book4.setDescription("Test description4");
        book4.setDownloadCounter(44);
        book4.setGenre(genre4);
        book4.setRating(StarRating.FOUR_STARS);
        book4.setUrlPicture("Test urlPicture4");
        book4.setUser(user4);

        book5.setTitle("Test title5");
        book5.setDescription("Test description5");
        book5.setDownloadCounter(555);
        book5.setGenre(genre5);
        book5.setRating(StarRating.FIVE_STARS);
        book5.setUrlPicture("Test urlPicture5");
        book5.setUser(user1);


        author1.setName("Test name 1");
        author1.setSurname("Test surname 1");
        author1.setPenName("Test penName 1");
        author1.setDescription("Test description 1");
        author1.setRating(StarRating.ONE_STARS);
        author1.setUrlPicture("Test name 1");
        author1.setUser(user1);

        author2.setName("Test name 2");
        author2.setSurname("Test surname 2");
        author2.setPenName("Test penName 2");
        author2.setDescription("Test description 2");
        author2.setRating(StarRating.TWO_STARS);
        author2.setUrlPicture("Test name 2");
        author2.setUser(user2);


        author3.setName("Test name 3");
        author3.setSurname("Test surname 3");
        author3.setPenName("Test penName 3");
        author3.setDescription("Test description 3");
        author3.setRating(StarRating.THREE_STARS);
        author3.setUrlPicture("Test name 3");
        author3.setUser(user3);


        author4.setName("Test name 4 ");
        author4.setSurname("Test surname 4");
        author4.setPenName("Test penName 4");
        author4.setDescription("Test description 4");
        author4.setRating(StarRating.FOUR_STARS);
        author4.setUrlPicture("Test name 4");
        author4.setUser(user1);

        author5.setName("Test name 5");
        author5.setSurname("Test surname 5");
        author5.setPenName("Test penName 5");
        author5.setDescription("Test description 5");
        author5.setRating(StarRating.ONE_STARS);
        author5.setUrlPicture("Test name 5");
        author5.setUser(user1);

        Set<Author> authorsSet = new HashSet();
        authorsSet.add(author2);
        authorsSet.add(author3);
        authorsSet.add(author4);

        Set<Book> booksSet = new HashSet();
        booksSet.add(book2);
        booksSet.add(book3);

        book1.setAuthors(authorsSet);
        author1.setBooks(booksSet);

        bookDao.save(book1);
        bookDao.save(book2);
        bookDao.save(book3);
        bookDao.save(book4);
        bookDao.save(book5);

        authorDao.save(author1);
        authorDao.save(author2);
        authorDao.save(author3);
        authorDao.save(author4);
        authorDao.save(author5);


    }


}
