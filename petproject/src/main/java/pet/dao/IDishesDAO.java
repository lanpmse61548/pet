package pet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.sym.Name;

import pet.dom.Dishes;

@Repository
public interface IDishesDAO extends JpaRepository<Dishes, Long>, QueryDslPredicateExecutor<Dishes> {

}


