package pet.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import pet.dom.Tour;

@Repository
public interface ITourDAO extends JpaRepository<Tour, Long>, QueryDslPredicateExecutor<Tour> {

}
