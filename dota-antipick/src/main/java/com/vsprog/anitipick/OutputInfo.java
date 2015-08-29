package com.vsprog.anitipick;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsa
 * @date 29.08.2015.
 */
public class OutputInfo {
    private List<Bunch> bunches;
    private Bunch pickBunch;

    public OutputInfo() {
        bunches = new ArrayList<Bunch>();
    }

    public List<Bunch> getBunches() {
        return bunches;
    }

    public void addBunch(Bunch bunch) {
        bunches.add(bunch);
    }

    public void clearOutputInfo() {
        bunches.clear();
    }

    public Bunch getPickBunch() {
        return pickBunch;
    }

    public void setPickBunch(Bunch pickBunch) {
        this.pickBunch = pickBunch;
    }
}
