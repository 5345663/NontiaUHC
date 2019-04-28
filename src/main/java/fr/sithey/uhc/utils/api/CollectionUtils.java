package fr.sithey.uhc.utils.api;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <T> List<List<T>> split(final List<T> toSplit, final int howOften) {
        final List<List<T>> list = new ArrayList<>(howOften);
        for (int i = 0; i < howOften; ++i) {
            list.add(new ArrayList<T>());
        }
        int i = 0;
        for (final T t : toSplit) {
            list.get(i).add(t);
            i = (i + 1) % howOften;
        }
        return list;
    }

}
