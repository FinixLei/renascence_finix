package org.appfuse.model.product_list_handler;

import java.util.Comparator;

public class PuUnitPriceDescComparator implements Comparator<PuUnit> {
    public int compare(PuUnit p1, PuUnit p2) {
        return p2.getPu_price().compareTo(p1.getPu_price());
    }
}
