/*
 * Copyright 2023 Marc Liberatore.
 */

package comparators;

import java.util.Comparator;

/**
 * A comparator to determine the order of two web pages. The two web pages are
 * compared lexicographically. However, if the CasedURLComparator is created
 * with ignoreCase set to true, then the comparison should be case-insensitive.
 */
public class CasedURLComparator implements Comparator<WebPageRecord> {
    final boolean ignoreCase;

    public CasedURLComparator(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    @Override
    public int compare(WebPageRecord x, WebPageRecord y) {
        // PART 3 Comparators
        // TASK: Implement the compare method to compare two WebPageRecord
        // objects based on their URL. Consider whether case should be ignored
        // or not when performing the comparison.
        if(ignoreCase==true){
            String first = x.URL.toLowerCase();
            String second = y.URL.toLowerCase();
            return first.compareTo(second);
        }
        else{
            String first=x.URL;
            String second=y.URL;
            return first.compareTo(second);
        }
    }

}