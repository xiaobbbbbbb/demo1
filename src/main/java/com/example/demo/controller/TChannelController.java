package com.example.demo.controller;

import com.example.demo.model.TChannel;
import com.example.demo.service.TChannelService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Slf4j
@Api(tags = "es渠道接口")
@RestController
@RequestMapping("/channel")
public class TChannelController {

    @Autowired
    private TChannelService tChannelService;


    @RequestMapping("/init")
    public void init(){
//        tChannelService.createIndex();
        List<TChannel> list =new ArrayList<>();
        list.add(new TChannel("a","9527","2021-11-23 00:34:35",334l,"张三","雷克萨的积分临时冻结"));
        list.add(new TChannel("b","9527","2021-11-23 00:34:35",334l,"张三","雷克萨efe的积分临时冻结"));
        list.add(new TChannel("c","9527","2021-11-23 00:34:35",334l,"张三","希望啊的"));
        list.add(new TChannel("a","9527","2021-11-23 00:34:35",334l,"张三","希望的田野"));
        tChannelService.saveAll(list);

    }

    @RequestMapping("/all")
    public Iterator<TChannel> all(){
        log.info("查询所有数据");
        return tChannelService.findAll();
    }

    @RequestMapping(value = "/getPage",method = RequestMethod.GET)
    public Page<TChannel> getPage(String key,int pageNo){
        log.info("查询分页数据,pageNo:"+pageNo);
        return tChannelService.findByContent(key,pageNo);
    }

}
