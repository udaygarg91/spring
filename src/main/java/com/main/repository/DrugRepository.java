package com.main.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Drug;

@Repository
@Transactional
public interface DrugRepository extends JpaRepository<Drug, Long> {
	
	//JPA will delete the data as per the method name. No need to write any query.
	public int deleteByRepresentativeEmployeeId(int representativeEmployeeId);

	//JPA will find the data as per the method name. No need to write any query.
	public List<Drug> findByNameInAndRepresentativeEmployeeId(List<String> name, int id);

	//JPA will find the data as per the method name. No need to write any query.
	public Drug findByNameAndRepresentativeEmployeeId(String name, int id);

	//JPA will find the data as per the method name. No need to write any query.
	public Set<Drug> findByRepresentativeEmployeeId(int id);

}
