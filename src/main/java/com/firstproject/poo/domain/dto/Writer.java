package com.firstproject.poo.domain.dto;

public class Writer {

    private Long writerID;
    private String name;
    private String nacionality;

    public Long getWriterID() {
        return writerID;
    }

    public void setWriterID(Long writerID) {
        this.writerID = writerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }
}
