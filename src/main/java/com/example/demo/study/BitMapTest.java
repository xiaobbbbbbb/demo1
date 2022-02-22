package com.example.demo.study;

import cn.hutool.bloomfilter.bitMap.BitMap;
import cn.hutool.bloomfilter.bitMap.IntMap;

/**
 * BitMapTest
 *
 * @author: niko
 * @date: 2021/12/24 14:56
 */
public class BitMapTest {

    public static void main(String[] args) {
        IntMap bitMap = new IntMap();
        bitMap.add(5);
        bitMap.add(5);
        bitMap.add(7);
        bitMap.add(222);
        bitMap.add(145);
        bitMap.add(678);
        bitMap.add(777);

    }

}
