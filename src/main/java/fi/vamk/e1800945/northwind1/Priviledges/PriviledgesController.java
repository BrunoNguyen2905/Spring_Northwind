package fi.vamk.e1800945.northwind1.Priviledges  ;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class PriviledgesController {
    @Autowired
    private PriviledgesRepository repository;

    @RequestMapping(value = "/privileges", method = RequestMethod.POST)
    public @ResponseBody Privileges create(@RequestBody final Privileges item) {
        return repository.save(item);
    }

    @RequestMapping(value = "/privileges", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
    public Iterable<Privileges> orderDetails(@RequestParam(value = "name", defaultValue = "World") final String name) {
        return repository.findAll();
    }

    @RequestMapping(value = "/privileges/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.GET)
    public Optional<Privileges> get(@PathVariable("id") final int id) {
        return repository.findById(id);
    }  

    @RequestMapping(value = "/privileges", method = RequestMethod.DELETE)
	public void delete(@RequestBody Privileges item) {
		repository.delete(item);
	}
}