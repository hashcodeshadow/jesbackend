package demo.controllers;

import demo.model.Person;
import demo.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@Slf4j
@RestController
@Api(value = "/person", description = "Person controller")
public class PersonController {

    @Autowired
    PersonRepository repository;

    @ApiOperation(value = "Lista todas ")
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = "application/json")
    public List<Person> list() {
        return repository.getList();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Person getById(@PathVariable Integer id) {
        return repository.byId(id);
    }

    //@PostMapping()
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public void create(@RequestBody Person person) {
        repository.insert(person.firstName,person.lastName,person.email,person.active);
    }

    //@PutMapping("/")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public void update(@PathVariable Integer id,@RequestBody Person person) {
        repository.update(person.id,person.firstName,person.lastName,person.email,true);
    }

    //@DeleteMapping("/")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delete(@PathVariable Integer id) {
        log.info("Delete id:{}"+id);
        repository.delete(id);
    }

}
