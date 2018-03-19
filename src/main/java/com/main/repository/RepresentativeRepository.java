package com.main.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Representative;

@Transactional
@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {
	
	//JPA will delete the data as per the method name. No need to write any query.
	public int deleteByRepresentativeEmployeeId(int id);

	//JPA will find the data as per the method name. No need to write any query.
	public Representative findByRepresentativeEmployeeId(int id);
}
