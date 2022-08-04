package com.validatesong.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id; //0

    @NotBlank(message = "Khong de trong")
    @Size(max = 800,message = "Ten bai hat khong vuot qua 800 ki tu")
    @Pattern(regexp = "^[\\w\\s]+$",message = "Khong duoc nhap ki tu dac biet")
    private String name;
    @NotBlank(message = "Khong de trong")
    @Size(max = 300,message = "Ten bai hat khong vuot qua 300 ki tu")
    @Pattern(regexp = "^[\\w\\s]+$",message = "Khong duoc nhap ki tu dac biet")
    private String artist;
    @NotBlank(message = "Khong de trong")
    @Size(max = 1000,message = "Ten bai hat khong vuot qua 1000 ki tu")
    @Pattern(regexp = "^[\\w\\s,]+$",message = "Khong duoc nhap ki tu dac biet ngoai trừ dấu ,")
    private String kind;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


}
