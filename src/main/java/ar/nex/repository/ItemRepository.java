package ar.nex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.nex.entity.Item;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  Optional<Item> findByUuid(String uuid);

  void deleteByUuid(String uuid);

  List<Item> findByNombre(String nombre);

  List<Item> findByNombreContains(String nombre);

  // @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
  // List<Movie> searchByTitleLike(@Param("title") String title);

}