package com.andre.furn.service;

import com.andre.furn.bean.Furn;

import java.util.List;

/**
 * @author Andre Wang
 * @version 1.0
 */
public interface FurnService {

    public void save(Furn furn);

    public List<Furn> findAll();

    public void update(Furn furn);

    public void del(Integer id);

    public Furn findById(Integer id);

    public List<Furn> findByCondition(String name);

}
