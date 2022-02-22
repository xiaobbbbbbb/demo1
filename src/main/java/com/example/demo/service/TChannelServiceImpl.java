package com.example.demo.service;


import com.example.demo.model.TChannel;
import com.example.demo.repository.TChannelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class TChannelServiceImpl implements TChannelService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private TChannelRepository elasticRepository;
    private Pageable pageable = PageRequest.of(0,10);

    @Override
    public void createIndex() {
        elasticsearchTemplate.createIndex(TChannel.class);

    }

    @Override
    public void deleteIndex(String index) {

    }

    @Override
    public void save(TChannel channel) {
        elasticRepository.save(channel);
    }

    @Override
    public void saveAll(List<TChannel> list) {
        try {
            elasticRepository.saveAll(list);
        }catch (Exception e){
            log.error("",e);
        }
    }

    @Override
    public Iterator<TChannel> findAll() {
        return elasticRepository.findAll().iterator();
    }

    @Override
    public Page<TChannel> findByContent(String content,int pageNo) {
        try {
            //这里页数参数由外部传入
            Pageable pageable = PageRequest.of(pageNo, 10);
            return elasticRepository.findByContent(content, pageable);
        }catch (Exception e){
            log.error("异常",e);
        }
        return null;
    }

    @Override
    public Page<TChannel> findByFirstCode(String firstCode) {
        return elasticRepository.findByFirstCode(firstCode,pageable);
    }

    @Override
    public Page<TChannel> findBySecordCode(String secordCode) {
        return elasticRepository.findBySecordCode(secordCode,pageable);
    }

    @Override
    public Page<TChannel> query(String key) {
        return elasticRepository.findByContent(key,pageable);
    }
}
