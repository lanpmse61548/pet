package pet.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pet.dom.Tour;
import pet.dom.TourDTO;
import pet.dom.TourShort;
import pet.service.IRestaurantService;
import pet.service.ITourService;
import pet.service.TourService;

@Controller
public class JSONController {

	@Autowired
	private ITourService sv;
	
	@Autowired
	private IRestaurantService rs;
	
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public @ResponseBody
	List<TourDTO> getTourInJSON() {
		List<TourDTO> ls = null;
		try {
			ls = sv.searchAll();
		//	rs.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
         return ls;

	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody
	List<TourDTO> updateMergeSave() {
		
		sv.MergeUpdateSave();
         return null;

	}
	
	
	
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public @ResponseBody
	Iterable<TourShort> searchParamTourInJSON(@RequestParam("id") int id) {
     
		return sv.searchSortAll();

	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody
	Iterable<Tour> searchAll() {
		Iterable<Tour> rs= sv.searchAllTour();
		return rs;

	}
	

	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public @ResponseBody
	Iterable<Tour> searchJoinJSON() {
		System.out.println("fuck this shit");
		Iterable<Tour> joinRs =null;
		 try {
			 joinRs = sv.searchJoin() ;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return joinRs;

	}

	public ITourService getSv() {
		return sv;
	}


	public void setSv(ITourService sv) {
		this.sv = sv;
	}

	
	
	@RequestMapping(value = "/css", method = RequestMethod.GET)
	public String css() {
	return "css";
	}
	
	@RequestMapping(value = "/css2", method = RequestMethod.GET)
	public String css2() {
		 List<TourDTO> es = sv.searchAll();
//		 for (Tour tour : es) {
//		try {
//			String a=	tour.getTourDetails().get(0).getContent();
//			System.out.println(a);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		}
	return "css2";
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
     
		
	return "header";
	}
	
	
	@RequestMapping(value = "/body", method = RequestMethod.GET)
	public String body() {
     
		
	return "body";
	}
}