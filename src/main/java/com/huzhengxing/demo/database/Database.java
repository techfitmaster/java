package com.huzhengxing.demo.database;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 2020/10/9 11:24  zhengxing.hu
 * @version 1.0.0
 * @file Database
 * @brief 资料库
 */
public class Database {

//    private final List<CD> listCD = new ArrayList<>();
//    private final List<DVD> listDVD = new ArrayList<>();

    private final List<Item> listItem = new ArrayList<>();

//    public void add(CD cd) {
//        listCD.add(cd);
//    }
//
//    public void add(DVD dvd) {
//        listDVD.add(dvd);
//    }

    public void add(Item item) {
        listItem.add(item);
    }

    public void list() {
//        for (CD cd : listCD) {
//            cd.print();
//        }
//
//        for (DVD dvd : listDVD) {
//            dvd.print();
//        }
        for (Item item : listItem) {
            item.print();
        }
    }

    public static void main(String[] args) {
        Database database = new Database();
        database.add(new CD("cd", "dvd artist", 60, "...", 3));
        database.add(new DVD("dvd name", "dvd artist", 120, "...", 6));
        database.list();
    }
}
