package pet.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysema.query.jpa.impl.JPAQuery;

import pet.dom.QTour;
import pet.dom.QTourDetail;
import pet.dom.QTourShort;
import pet.dom.SimpleSourceDestinationMapper;
import pet.dom.Tour;
import pet.dom.TourDTO;
import pet.dom.TourShort;

@Service
@Transactional(rollbackOn = Throwable.class)
public class TourService implements ITourService {
	@PersistenceContext // (type = PersistenceContextType.EXTENDED)
	private EntityManager em;



	// @Autowired
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	SessionFactory factory;
	// @Autowired
	// private ITourDAO tourDAO;

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public List<TourDTO> searchAll() {
		 //Iterable<Project> rs = new ArrayList<>();
		 JPAQuery tmp = new JPAQuery(em);
		
		 // tourDAO.findAll(predicate);
		 // return tmp.list(QTour.tour);
		
		 Iterable<Tour> rs =tmp.from(QTour.tour).list(QTour.tour);
		 List<TourDTO> tourList = new ArrayList<TourDTO>();
		 SimpleSourceDestinationMapper mapper
		 = Mappers.getMapper(SimpleSourceDestinationMapper.class);
		 for (Tour tour : rs) {
		 // tour.getTourDetails(); lazy
		 // Hibernate.initialize(tour.getTourDetails());
		// tourList.add(this.convertToDto(tour));
			 tourList.add(mapper.sourceToDestination(tour));
		 }

		// SessionFactory factory = pet.dao.HibernateUtils.getSessionFactory();

	
		return tourList;
		

	}
	
	
	public void MergeUpdateSave(){
	
		Session session = factory.getCurrentSession();
		try {
           
/*if the entity is detached, it is copied upon an existing persistent entity;
if the entity is transient, it is copied upon a newly created persistent entity;
this operation cascades for all relations with cascade=MERGE or cascade=ALL mapping;
if the entity is persistent, then this method call does not have effect on it (but the cascading still takes place).
*/
			
			Tour tmp2 = new Tour();
			tmp2.setEndplace("some");
			tmp2.setPrice(new Long(21));
			tmp2.setStartplace("random");
			tmp2.setTourname("shit");
			
            //if transient and have no id ->create new
			//if transient and mannually insert id  tmp2.setId(new Long(9)) -> update
			session.merge(tmp2);
			
			
			/*
			// update persistent object,return new persistent object
			Tour tmp2=(Tour)session.get(Tour.class,new Long(9));
			tmp2.setTourname("after update");
			session.merge(tmp2);
			*/
			
			/*
			// update detached object,return new persistent object
						Tour tmp2=(Tour)session.get(Tour.class,new Long(9));
						session.evict(tmp2);
						tmp2.setTourname("after evic update");
						session.merge(tmp2);
			*/
			
			/////////////
			
//			session.update(tmp2);
/*it acts upon passed object (its return type is void); the update method transitions the passed object from detached to persistent state;
this method throws an exception if you pass it a transient entity.

saveOrUpdate method is that it does not throw exception when applied to a transient instance;
 instead, it makes this transient instance persistent.
*/
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	

	public Iterable<TourShort> searchSortAll() {
		// Iterable<Project> rs = new ArrayList<>();
		JPAQuery tmp = new JPAQuery(em);
		// tourDAO.findAll(predicate);
		// return tmp.list(QTour.tour);

		return tmp.from(QTourShort.tourShort).list(QTourShort.tourShort);

	}

	public Iterable<Tour> searchJoin() {
		// Iterable<Project> rs = new ArrayList<>();
		JPAQuery tmp = new JPAQuery(em);
		// tourDAO.findAll(predicate);
		// return tmp.list(QTour.tour);

		QTour tour = QTour.tour;
		QTourDetail tourDetail = QTourDetail.tourDetail;
		//
		// n new JPAQuery(em).from(provider)
		// .innerJoin(provider.contact, contact)
		// .where(provider.id.eq(providerId), contact.id.eq(contactId))
		// .singleResult(contact);
		Iterable<Tour> rs = null;
		try {
			rs = tmp.from(tour).innerJoin(tour.tourDetails, tourDetail).list(tour);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;

	}

	public Iterable<Tour> searchAllTour() {
		// Iterable<Project> rs = new ArrayList<>();
		JPAQuery tmp = new JPAQuery(em);
		// tourDAO.findAll(predicate);
		// return tmp.list(QTour.tour);
		return tmp.from(QTour.tour).list(QTour.tour);

	}

	private TourDTO convertToDto(Tour tour) {
		TourDTO tourDTO = modelMapper.map(tour, TourDTO.class);
		return tourDTO;
	}

}
