package com.huzhengxing.demo.database;

/**
 * @author 2020/10/9 11:25  zhengxing.hu
 * @version 1.0.0
 * @file CD
 * @brief
 * @par
 * @warning
 */
public class CD extends Item {
    private String artist;

    public CD(String title, String artist, int playingTime, String comment, int numOfTracks) {
        super(title,playingTime,comment,numOfTracks);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "CD{" +
                "title='" + super.getTitle() + '\'' +
                ", artist='" + artist + '\'' +
                ", playingTime='" + super.getPlayingTime() + '\'' +
                ", comment='" + super.getComment() + '\'' +
                ", numOfTracks=" + super.getNumOfTracks() +
                ", gotIt=" + super.isGotIt() +
                '}';
    }
}
