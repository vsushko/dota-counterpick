package com.vsprog.counterpick;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vsa
 * @date 29.08.2015.
 */
public class OutputInfo {
    private List<Bunch> bunches;
    private List<Bunch> rawBunches;
    private List<Bunch> oneHeroBunches;
    private Bunch pickBunch;

    public OutputInfo() {
        bunches = new ArrayList<Bunch>();
        rawBunches = new ArrayList<Bunch>();
        oneHeroBunches = new ArrayList<Bunch>();
    }

    public List<Bunch> getRawBunches() {
        return rawBunches;
    }

    public List<Bunch> getOneHeroBunches() {
        return oneHeroBunches;
    }

    public List<Bunch> getBunches() {
        return bunches;
    }

    public void addBunch(Bunch bunch) {
        bunches.add(bunch);
    }

    public void addRawBunch(Bunch bunch) {
        rawBunches.add(bunch);
    }

    public void addOneHeroBunch(Bunch bunch) {
        rawBunches.add(bunch);
    }

    public void clearOutputInfo() {
        bunches.clear();
        rawBunches.clear();
    }

    public Bunch getPickBunch() {
        return pickBunch;
    }

    public void setPickBunch(Bunch pickBunch) {
        this.pickBunch = pickBunch;
    }
}
