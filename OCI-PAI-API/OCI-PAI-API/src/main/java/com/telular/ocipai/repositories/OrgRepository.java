package com.telular.ocipai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telular.ocipai.entity.Org;


@Repository
public interface OrgRepository extends JpaRepository<Org,Integer> {

}
