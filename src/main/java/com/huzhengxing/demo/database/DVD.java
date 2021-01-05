package com.huzhengxing.demo.database;

/**
 * @author 2020/10/9 11:34  zhengxing.hu
 * @version 1.0.0
 * @file DVD
 * @brief
 * @par
 * @warning
 */
public class DVD extends Item {
    private String director;

    public DVD(String title, String director, int playingTime, String comment, int numOfTracks) {
        super(title, playingTime, comment, numOfTracks);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "CD{" +
                "title='" + super.getTitle() + '\'' +
                ", director='" + director + '\'' +
                ", playingTime='" + super.getPlayingTime() + '\'' +
                ", comment='" + super.getComment() + '\'' +
                ", numOfTracks=" + super.getNumOfTracks() +
                ", gotIt=" + super.isGotIt() +
                '}';
    }
}
