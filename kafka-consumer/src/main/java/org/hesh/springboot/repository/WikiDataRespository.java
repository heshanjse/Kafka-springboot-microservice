package org.hesh.springboot.repository;

import org.hesh.springboot.entity.WikiData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiDataRespository extends JpaRepository<WikiData,Long> {
}
