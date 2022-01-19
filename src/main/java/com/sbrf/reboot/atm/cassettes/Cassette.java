package com.sbrf.reboot.atm.cassettes;

import java.util.ArrayList;
import java.util.List;

public class Cassette<T extends Banknote> {
    List<T> list;

    public Cassette(List<T> list) {
        this.list = list;
    }

    public int getCountBanknotes() {
        return list.size();
    }
}

