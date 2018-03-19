package com.main.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Representative;

@Transactional
@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {

	public int deleteByRepresentativeEmployeeId(int id);

	public Representative findByRepresentativeEmployeeId(int id);
}
