package person.flowerpowder.demo.spring.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import person.flowerpowder.demo.spring.mvc.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person/")
public class PersonController extends BaseController implements Serializable {

	private static final long serialVersionUID = 1324281204513252405L;
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);


	
	@RequestMapping(method=RequestMethod.GET,value="edit")
	public ModelAndView editPerson(@RequestParam(value="id",required=false) Long id) {		
		logger.debug("Received request to edit person id : "+id);				
		ModelAndView mav = new ModelAndView();		
 		mav.setViewName("edit");
 		Person person = new Person(1L, "John", "Smith");
 		mav.addObject("person", person);
		return mav;
		
	}

	@RequestMapping(method=RequestMethod.POST,value="edit")
	public String savePerson(@ModelAttribute Person person) {
		logger.debug("Received postback on person "+person);

		return "redirect:list";

	}
	
	@RequestMapping(method=RequestMethod.GET,value="list")
	public ModelAndView listPeople() {
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		List<Person> people = new ArrayList<Person>();
		Person personA = new Person(1L, "John", "Smith");
		Person personB = new Person(2L, "Black", "Smith");
		people.add(personA);
		people.add(personB);
		logger.debug("Person Listing count = "+people.size());
		mav.addObject("people",people);
		mav.setViewName("list");
		return mav;
		
	}

}
