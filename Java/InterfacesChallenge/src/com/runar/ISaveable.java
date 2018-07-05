package com.runar;

import java.util.List;

/**
 * Created by rsverrisson on 04-07-2018.
 */
public interface ISaveable {

    public List<String> write();

    public void read(List<String> values);

}
