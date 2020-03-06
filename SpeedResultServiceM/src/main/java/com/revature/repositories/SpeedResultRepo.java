package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.SpeedResult;

public interface SpeedResultRepo extends JpaRepository<SpeedResult, Long>{

	public List<SpeedResult> findBySubjectName(String sName);
}
