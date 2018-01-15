package com.company;

import java.util.List;

public class MockMeasure implements IMeasure {

    List<Double> _factors = List.of(150.0, 123.0, -1.0, 200.0, -1.0);
    int _index = 0;

    @Override
    public double measure() {
        if (_index >= _factors.size()) return -1;
        return _factors.get(_index++);
    }
}
