package com.company;

import java.util.ArrayList;
import java.util.List;

public class FileMeasure implements IMeasure {
    List<Double> _factors = new ArrayList<>();
    int _index = 0;

    public FileMeasure(String file) {
        IReader reader = new FileReader(file);
        List<String> lines = reader.getLines();
        for (String line : lines) {
            _factors.add(Double.parseDouble(line));
        }
    }

    @Override
    public double measure() {
        if (_index >= _factors.size()) return -1;
        return _factors.get(_index++);
    }
}
