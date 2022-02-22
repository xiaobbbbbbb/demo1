package com.example.demo.repository;

import com.example.demo.model.TChannel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TChannelRepository extends ElasticsearchRepository<TChannel,String> {
    //默认的注释 elasticsearch 查询语句 query 单条，bool复合查询
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<TChannel> findByContent(String content, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"firstCode.keyword\" : \"?0\"}}}}")
    Page<TChannel> findByFirstCode(String firstCode, Pageable pageable);

    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"secordCode.keyword\" : \"?0\"}}}}")
    Page<TChannel> findBySecordCode(String secordCode, Pageable pageable);
}
