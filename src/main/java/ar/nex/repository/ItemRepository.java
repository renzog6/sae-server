package ar.nex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.nex.entity.Item;


/**
 *
 * @author Renzo O. Gorosito
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  Optional<Item> findByUuid(String uuid);
  void deleteByUuid(String uuid);
}