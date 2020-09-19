package com.williamdsw.dspesquisa.repositories;

import java.time.Instant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.williamdsw.dspesquisa.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

	@Query(" SELECT rec FROM Record rec WHERE (coalesce(:min, null) IS NULL OR rec.moment >= :min) AND (coalesce(:max, null) IS NULL OR rec.moment <= :max) ")
	public Page<Record> findByMoments(Instant min, Instant max, Pageable pageable);
}
