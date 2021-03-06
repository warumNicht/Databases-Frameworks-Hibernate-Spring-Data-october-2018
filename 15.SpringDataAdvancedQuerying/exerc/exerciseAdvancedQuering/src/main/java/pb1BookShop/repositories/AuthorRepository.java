package pb1BookShop.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pb1BookShop.models.Author;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByLastName(String lastName);

    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN 'true' ELSE 'false' END FROM Author a WHERE a.firstName=?1 AND a.lastName = ?2 ")
    boolean existsAuthorByLastName(String firstName, String lastName);

    Author getAuthorById(long id);

    long countByIdAfter(long id);

    @Query(value = "SELECT a.id,a.first_name,a.last_name,IFNULL((count(b.id)),0) AS `count` FROM authors AS a\n" +
            "LEFT JOIN books AS b ON b.author_id=a.id\n" +
            "GROUP BY a.id\n" +
            "ORDER BY `count` DESC", nativeQuery = true)
    Iterable<Author> findAuthorsByOrderByBooksDesc();


    @Query(value = "SELECT a.id,a.first_name,a.last_name FROM authors AS a\n" +
            "INNER JOIN books AS b ON b.author_id=a.id\n" +
            "  WHERE b.release_date<:date\n" +
            "GROUP BY a.id;", nativeQuery = true)
    Iterable<Author> getAuthorsWithAtLeastOneBookBefore(@Param("date") Date date);

    List<Author> getAllByFirstNameEndsWith(String firstName);

    @Query(value = "SELECT a.firstName,a.lastName, SUM (b.copies) AS cont  FROM Author AS a JOIN a.books AS b GROUP BY a.id ORDER BY cont DESC ")
    List<Object[]> getBySumBooks();

}
