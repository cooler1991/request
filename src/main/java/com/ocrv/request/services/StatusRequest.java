package com.ocrv.request.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.*;

public enum StatusRequest {

        NEW ("NEW","Новая"),
        IN_WORK ("IN_WORK","В работе"),
        SOLVED ("SOLVED","Решена"),
        REJECTED("REJECTED","Отклонена");

    private String name;
    private String describe;


    StatusRequest(String name, String describe) {
        this.name = name;
        this.describe = describe;

    }

    public String getDescribe() {
        return describe;
    }
    public String getName(){
        return name;
    }
    public static String fromName(String name) {
        for (StatusRequest  es : StatusRequest .values()) {
            if (es.name.equals(name)) {
                return es.getDescribe();
            }
        }
        return "UNKNOWN";
    }

    public static String fromDesc(String describe) {
        for (StatusRequest  es : StatusRequest .values()) {
            if (es.describe.equals(describe)) {
                return es.getName();
            }
        }
        return "UNKNOWN";
    }

    public static  List getListStatus(){
       List list = new ArrayList() ;
        for (StatusRequest  es : StatusRequest .values()) {
            list.add(es.describe);
        }
        return list;

    }
    @Override
    public String toString() {
        return describe;
    }


}
