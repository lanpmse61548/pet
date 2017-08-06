package pet.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.hibernate.HibernateQuery;

import pet.dao.IDishesDAO;
import pet.dao.IShit;
import pet.dom.Dishes;
import pet.dom.QDishes;
import pet.dom.RestaurantMapper;
import pet.dom.QDishes;
import pet.dom.Dishes;
import pet.dom.DishesDTO;

@Service
@Transactional(rollbackOn = Throwable.class)
public class DishesService implements IDishesService {

	@Autowired
	private IDishesDAO dishesDAO;
//	@Autowired
//	IShit shit;
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
//	@PersistenceContext
//	private Session session;
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public  List<DishesDTO>  searchAll() {
		   
		//	JPAQuery tmp = new JPAQuery(em);
			
			JPQLQuery tmp = new HibernateQuery( factory.getCurrentSession());
	       
	      //  DishesDAO.findAll(predicate);
		//	return  tmp.list(QDishes.Dishes);
	       
	        Iterable<Dishes> rs =tmp.from(QDishes.dishes).list(QDishes.dishes);
	        List<DishesDTO> dishesList = new  ArrayList<DishesDTO>();
	        RestaurantMapper mapper
	        = Mappers.getMapper( RestaurantMapper.class);
	        for (Dishes Dishes : rs) {
	       	// Dishes.getDishesDetails(); lazy
			//	Hibernate.initialize(Dishes.getDishesDetails());
	          // DishesList.add(this.convertToDto(Dishes));
	        //	System.out.println("rsnae " +Dishes.getRes_name());
	       
//	         Hibernate.initialize(Dishes.getListDishes());
//	          for (Dishes dishes : Dishes.getListDishes()) {
//				System.out.println(dishes.getDis_name());
	        	dishesList.add(mapper.sourceToDestinationDishes(Dishes));
//			}
//	       	 
//			}
	        
	        }
			return dishesList;
	}

	@Override
	public Dishes updateDish(Dishes dish) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Dishes updateDish(Dishes dish) {
//		dishesDAO.save(dish);
//		return dish;
//	}
//
//	public IDishesDAO getDishesDAO() {
//		return dishesDAO;
//	}
//
//	public void setDishesDAO(IDishesDAO dishesDAO) {
//		this.dishesDAO = dishesDAO;
//	}

	
}
