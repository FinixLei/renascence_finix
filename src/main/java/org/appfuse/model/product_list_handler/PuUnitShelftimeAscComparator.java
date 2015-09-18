package org.appfuse.model.product_list_handler;

import java.util.Comparator;

public class PuUnitShelftimeAscComparator implements Comparator<PuUnit> {
    public int compare(PuUnit p1, PuUnit p2) {
        return p1.getPu_shelf_time().compareTo(p2.getPu_shelf_time());
    }
}
