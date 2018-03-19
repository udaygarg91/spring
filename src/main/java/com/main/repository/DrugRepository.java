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
	public int deleteByRepresentativeEmployeeId(int representativeEmployeeId);

	public List<Drug> findByNameInAndRepresentativeEmployeeId(List<String> name, int id);

	public Drug findByNameAndRepresentativeEmployeeId(String name, int id);

	public Set<Drug> findByRepresentativeEmployeeId(int id);

}
