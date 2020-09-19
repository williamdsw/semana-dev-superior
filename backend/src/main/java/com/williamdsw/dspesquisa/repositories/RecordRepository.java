package com.williamdsw.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.williamdsw.dspesquisa.entities.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {

}
