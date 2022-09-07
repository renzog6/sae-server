package ar.nex.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.nex.entity.Item;
import ar.nex.repository.ItemRepository;

/**
 *
 * @author Renzo O. Gorosito O. Gorosito
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/item") // @RequestMapping("api/item")
public class ItemController {

  @Autowired
  ItemRepository repository;

  @GetMapping("/list")
  public ResponseEntity<List<Item>> getAllItems(@RequestParam(required = false) String name) {
    try {
      List<Item> lista = new ArrayList<Item>();

      System.out.println("name: " + name);

      if (name == null)
        repository.findAll().forEach(lista::add);
      else
        repository.findByNombreContains(name).forEach(lista::add);

      if (lista.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(lista, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<Item> getItemById(@PathVariable("uuid") long uuid) {
    Optional<Item> itemData = repository.findById(uuid);

    if (itemData.isPresent()) {
      return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/create")
  public ResponseEntity<Item> createItem(@RequestBody Item item) {
    try {
      System.out.println("@PostMapping(/create)::: ");
      Item _item = repository.save(new Item(item.getNombre(), item.getInfo()));
      return new ResponseEntity<>(_item, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/update/{uuid}")
  public ResponseEntity<Item> updateItem(@PathVariable("uuid") String uuid, @RequestBody Item item) {
    try {
      Optional<Item> itemData = repository.findByUuid(uuid); // .findById(uuid);
      if (itemData.isPresent()) {
        Item _item = itemData.get();
        _item.setNombre(item.getNombre());
        _item.setInfo(item.getInfo());
        return new ResponseEntity<>(repository.save(_item), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/delete/{uuid}")
  public ResponseEntity<String> deleteItem(@PathVariable("uuid") String uuid) {
    try {
      Optional<Item> itemData = repository.findByUuid(uuid);
      if (itemData.isPresent()) {
        Item _item = itemData.get();
        repository.delete(_item);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>("ITEM::: " + uuid + " NO exite", HttpStatus.BAD_GATEWAY);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/delete")
  public ResponseEntity<HttpStatus> deleteAllItems() {
    try {
      repository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
