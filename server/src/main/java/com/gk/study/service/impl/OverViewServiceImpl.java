package com.gk.study.service.impl;

import com.gk.study.entity.OverView;
import com.gk.study.mapper.OverViewMapper;
import com.gk.study.service.OverViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wzl_9597(微信)
 * @version 1.0
 */
@Service
public class OverViewServiceImpl implements OverViewService {
    @Autowired
    private OverViewMapper overViewMapper;


    @Override
    public OverView getList() {
        OverView overView = new OverView();

        OverView overView1 = overViewMapper.list1();  //spzs, null
        OverView overView2 = overViewMapper.list2(); //spzsew
        OverView overView3 = overViewMapper.list3();
        OverView overView4 = overViewMapper.list4();

        overView = overViewMapper.list5();  //


        overView.setSpzs(overView1.getSpzs());
        overView.setQrxz(overView2.getQrxz());
        overView.setWfdd(overView3.getWfdd());
        overView.setWfddrs(overView3.getWfddrs());
        overView.setYfdd(overView4.getYfdd());
        overView.setYfddrs(overView4.getYfddrs());
        return overView;
    }
}
