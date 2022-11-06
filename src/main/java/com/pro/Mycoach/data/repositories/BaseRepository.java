package com.pro.Mycoach.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.pro.Mycoach.data.entities.BaseEntity;


@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, Long> {

}