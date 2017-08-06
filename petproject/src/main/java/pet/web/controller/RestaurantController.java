package pet.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pet.dom.Restaurant;
import pet.dom.RestaurantDTO;
import pet.dom.Tour;
import pet.dom.TourShort;
import pet.service.IRestaurantService;

@Controller
public class RestaurantController {
	
	@Autowired
	private IRestaurantService res;
	@RequestMapping(value = "/allRes", method = RequestMethod.GET)
	public @ResponseBody
	List<RestaurantDTO> searchAll() {
		List<RestaurantDTO> rs= res.searchAll();
		return rs;

	}
	
	
	
}
