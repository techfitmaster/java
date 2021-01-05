package com.huzhengxing.demo.database;

/**
 * @author 2020/10/9 15:59  zhengxing.hu
 * @version 1.0.0
 * @file Item
 * @brief
 * @par
 * @warning
 */
public class Item {
    private String title;
    private int playingTime;
    private String comment;
    private int numOfTracks;
    private boolean gotIt;

    public void print() {
        System.out.println("this is item");
    }

    public Item(String title, int playingTime, String comment, int numOfTracks) {
        this.title = title;
        this.playingTime = playingTime;
        this.comment = comment;
        this.numOfTracks = numOfTracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = numOfTracks;
    }

    public boolean isGotIt() {
        return gotIt;
    }

    public void setGotIt(boolean gotIt) {
        this.gotIt = gotIt;
    }
}
