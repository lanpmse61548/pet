package pet.service;

import java.util.List;

import pet.dom.Restaurant;
import pet.dom.RestaurantDTO;


public interface IRestaurantService {
	public List<RestaurantDTO> searchAll();
}
