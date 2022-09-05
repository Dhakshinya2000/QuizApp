package com.application.result;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ResultRepository extends CrudRepository<Result, Integer>{

	List<Result> findByUsername(String username);

}
