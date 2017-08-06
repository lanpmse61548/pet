package pet.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.query.spi.HQLQueryPlan;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.hibernate.HibernateQuery;
import com.mysema.query.jpa.impl.JPAQuery;

import pet.dom.QRestaurant;
import pet.dom.Dishes;
import pet.dom.Restaurant;
import pet.dom.RestaurantDTO;
import pet.dom.RestaurantMapper;

@Service
@Transactional(rollbackOn = Throwable.class)
public class IRestaurantServiceImpl implements IRestaurantService {
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
//	@PersistenceContext
//	private Session session;
	
	@Autowired
	SessionFactory factory;
	@Override
	public List<RestaurantDTO> searchAll() {
		//Iterable<Project> rs = new ArrayList<>();
    
	//	JPAQuery tmp = new JPAQuery(em);
		
		JPQLQuery tmp = new HibernateQuery( factory.getCurrentSession());
       
      //  RestaurantDAO.findAll(predicate);
	//	return  tmp.list(QRestaurant.Restaurant);
        
        Iterable<Restaurant> rs =tmp.from(QRestaurant.restaurant).list(QRestaurant.restaurant);
        List<RestaurantDTO> restaurantList = new  ArrayList<RestaurantDTO>();
        RestaurantMapper mapper
        = Mappers.getMapper(RestaurantMapper.class);
        for (Restaurant restaurant : rs) {
       	// Restaurant.getRestaurantDetails(); lazy
		//	Hibernate.initialize(Restaurant.getRestaurantDetails());
          // RestaurantList.add(this.convertToDto(Restaurant));
        //	System.out.println("rsnae " +restaurant.getRes_name());
       
//         Hibernate.initialize(restaurant.getListDishes());
//          for (Dishes dishes : restaurant.getListDishes()) {
//			System.out.println(dishes.getDis_name());
        	restaurantList.add(mapper.sourceToDestination(restaurant));
//		}
       	 
		}
		return restaurantList;

	}

}
