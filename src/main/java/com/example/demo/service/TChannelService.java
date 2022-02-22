package com.example.demo.service;


import com.example.demo.model.TChannel;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

public interface TChannelService {
    void createIndex();

    void deleteIndex(String index);

    void save(TChannel channel);

    void saveAll(List<TChannel> list);

    Iterator<TChannel> findAll();

    Page<TChannel> findByContent(String content,int pageNo);

    Page<TChannel> findByFirstCode(String firstCode);

    Page<TChannel> findBySecordCode(String secordCode);

    Page<TChannel> query(String key);
}
