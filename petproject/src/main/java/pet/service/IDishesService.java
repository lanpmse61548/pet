package pet.service;

import java.util.List;

import pet.dom.Dishes;
import pet.dom.DishesDTO;
import pet.dom.Restaurant;

public interface IDishesService {
	public  List<DishesDTO>  searchAll();
	public Dishes updateDish(Dishes dish);
}
