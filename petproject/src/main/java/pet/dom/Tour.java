package pet.dom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tour")
public class Tour {
	
    private Long id;
	
	 
	 private String tourname;
	 


	 private Long price;
	 
	
	 private String startplace;

	 @Column(name = "end_place",nullable = false)
	 private String endplace;

	 
	 private List<TourDetail> tourDetails = new ArrayList<TourDetail>();

	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "tour")
		public List<TourDetail> getTourDetails() {
			return this.tourDetails;
		}
	 
	 
	



	public void setTourDetails(List<TourDetail> tourDetails) {
		this.tourDetails = tourDetails;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tour_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "tour_name",nullable = false)
	public String getTourname() {
		return tourname;
	}

	public void setTourname(String tourname) {
		this.tourname = tourname;
	}

	@Column(name = "price",nullable = false)
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	 @Column(name = "start_place",nullable = false)
	public String getStartplace() {
		return startplace;
	}

	public void setStartplace(String startplace) {
		this.startplace = startplace;
	}

	 @Column(name = "end_place",nullable = false)
	public String getEndplace() {
		return endplace;
	}

	public void setEndplace(String endplace) {
		this.endplace = endplace;
	}
	 
	 
}
