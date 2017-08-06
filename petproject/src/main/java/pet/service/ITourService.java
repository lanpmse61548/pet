package pet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pet.dom.Tour;
import pet.dom.TourDTO;
import pet.dom.TourShort;


public interface ITourService {
	public List<TourDTO> searchAll() ;
	public Iterable<TourShort> searchSortAll();
	public Iterable<Tour> searchJoin();
	public Iterable<Tour> searchAllTour();
	public void MergeUpdateSave();
}
