package com.andre.furn.service.impl;

import com.andre.furn.bean.Furn;
import com.andre.furn.dao.FurnMapper;
import com.andre.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Andre Wang
 * @version 1.0
 */
@Service
public class FurnServiceImpl implements FurnService {

    @Resource
    private FurnMapper furnMapper;


    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    @Override
    public List<Furn> findAll() {
        return furnMapper.selectByExample(null);
    }

    @Override
    public void update(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public void del(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Furn findById(Integer id) {
        return null;
    }

    @Override
    public List<Furn> findByCondition(String name) {
        return null;
    }
}
