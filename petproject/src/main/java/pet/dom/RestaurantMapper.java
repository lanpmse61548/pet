package pet.dom;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
	RestaurantDTO sourceToDestination(Restaurant source);  
	DishesDTO sourceToDestinationDishes(Dishes source);  
}
