package pet.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pet.dom.Dishes;
import pet.dom.DishesDTO;
import pet.service.IDishesService;

@Controller
public class DishesController {
	@Autowired
	private IDishesService res;

	@RequestMapping(value = "/allDish", method = RequestMethod.GET)
	public @ResponseBody  List<DishesDTO>  searchAll() {
		 List<DishesDTO>  rs = res.searchAll();
		return rs;

	}
}
