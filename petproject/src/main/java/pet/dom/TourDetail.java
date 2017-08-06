package pet.dom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TourDetail")
public class TourDetail {

	
    private Long id;
	
	
	 private String content;
	
	private Tour tour;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tour_id", nullable = false)
	public Tour getTour() {
		return this.tour;
	}

	@Id
	@GeneratedValue
	@Column(name = "tour_detail_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "content",nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public void setTour(Tour tour) {
		this.tour = tour;
	}
	
	
}
