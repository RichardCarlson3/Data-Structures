/*
 * Copyright 2023 Marc Liberatore.
 */

package comparators;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Comparator;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.gradescope.jh61b.grader.GradedTest;

public class ComparatorsTest {
    // @Rule
    // public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds

    final WebPageRecord google = new WebPageRecord("http://www.google.com/", Instant.parse("2002-01-01T10:15:30.00Z"),
            100, "Welcome to Google. Don't be evil.");
    final WebPageRecord googleLater = new WebPageRecord("http://www.google.com/",
            Instant.parse("2017-06-15T00:30:00.00Z"),
            1000, "Welcome to Google. Don't be TOO evil.");
    final WebPageRecord amazon = new WebPageRecord("http://www.amazon.com/", Instant.parse("2003-05-01T12:00:00.00Z"),
            5000, "Get in the AmaZone!");
    final WebPageRecord google2 = new WebPageRecord("http://www.google.com/", Instant.parse("2005-01-01T10:15:30.00Z"),
            100, "Welcome to Google. Don't be evil. For now.");
    final WebPageRecord google3 = new WebPageRecord("http://www3.google.com/", Instant.parse("2002-03-03T03:03:03.00Z"),
            100, "Welcome to Google. Don't be evil.");
    final WebPageRecord googleI = new WebPageRecord("http://www.google.com/", Instant.now(),
            100, "Welcome to Google. Don't be evil.");
    final WebPageRecord googleShouting = new WebPageRecord("http://www.GOOGLE.com/",
            Instant.parse("2002-01-01T10:15:30.00Z"),
            100, "Welcome to Google. Don't be evil.");
    final WebPageRecord amazonShouting = new WebPageRecord("http://www.AMAZON.com/",
            Instant.parse("2003-05-01T12:00:00.00Z"),
            5000, "Get in the AmaZone!");

    final Comparator<WebPageRecord> largestPageComparator = new LargestPageComparator();
    final Comparator<WebPageRecord> caseSensitivePageComparator = new CasedURLComparator(false);
    final Comparator<WebPageRecord> caseInsensitivePageComparator = new CasedURLComparator(true);

    @Test
    @GradedTest(name = "testNaturalIdentical", max_score = 1)
    public void testNaturalIdentical() {
        assertEquals(0, google.compareTo(google));
    }

    @Test
    @GradedTest(name = "testNaturalDifferentURL", max_score = 1)
    public void testNaturalURL() {
        assertTrue(google.compareTo(amazon) > 0);
        assertTrue(amazon.compareTo(google) < 0);
    }

    @Test
    @GradedTest(name = "testNaturalSameURL", max_score = 1)
    public void testNaturalSameURL() {
        assertTrue(google.compareTo(googleLater) < 0);
        assertTrue(googleLater.compareTo(google) > 0);
    }

    @Test
    @GradedTest(name = "testLargestIdentical", max_score = 1)
    public void testLargestIdentical() {
        assertEquals(0, largestPageComparator.compare(google, googleI));
    }

    @Test
    @GradedTest(name = "testLargestSimple", max_score = 1)
    public void testLargestSimple() {
        assertTrue(largestPageComparator.compare(amazon, googleLater) < 0);
        assertTrue(largestPageComparator.compare(googleLater, amazon) > 0);
    }

    @Test
    @GradedTest(name = "testLargestFirstTieBreaker", max_score = 1)
    public void testLargestFirstTieBreaker() {
        assertTrue(largestPageComparator.compare(google, google2) > 0);
        assertTrue(largestPageComparator.compare(google2, google) < 0);
    }

    @Test
    @GradedTest(name = "testLargestSecondTieBreaker", max_score = 1)
    public void testLargestSecondTieBreaker() {
        assertTrue(largestPageComparator.compare(google, google3) < 0);
        assertTrue(largestPageComparator.compare(google3, google) > 0);
    }

    @Test
    @GradedTest(name = "testLargestTied", max_score = 1)
    public void testLargestTied() {
        assertEquals(0, largestPageComparator.compare(google, googleI));
    }

    @Test
    @GradedTest(name = "testCaseSensitiveIdentical", max_score = 1)
    public void testCaseSensitiveIdentical() {
        assertEquals(0, caseSensitivePageComparator.compare(google, googleI));
    }

    @Test
    @GradedTest(name = "testCaseSensitive", max_score = 1)
    public void testCaseSensitive() {
        assertTrue(caseSensitivePageComparator.compare(amazon, google) < 0);
        assertTrue(caseSensitivePageComparator.compare(google, amazon) > 0);
    }

    @Test
    @GradedTest(name = "testCaseSensitiveCaseCheckDiffering", max_score = 1)
    public void testCaseSensitiveCaseCheckDiffering() {
        assertTrue(caseSensitivePageComparator.compare(googleShouting, amazon) < 0);
        assertTrue(caseSensitivePageComparator.compare(amazon, googleShouting) > 0);
    }

    @Test
    @GradedTest(name = "testCaseSensitiveCaseCheckSame", max_score = 1)
    public void testCaseSensitiveCaseCheckSame() {
        assertTrue(caseSensitivePageComparator.compare(googleShouting, google) < 0);
        assertTrue(caseSensitivePageComparator.compare(google, googleShouting) > 0);
    }

    @Test
    @GradedTest(name = "testCaseInsensitiveIdentical", max_score = 1)
    public void testCaseInsensitiveIdentical() {
        assertEquals(0, caseInsensitivePageComparator.compare(google, googleI));
        assertEquals(0, caseInsensitivePageComparator.compare(google, googleShouting));
    }

    @Test
    @GradedTest(name = "testCaseInsensitive", max_score = 1)
    public void testCaseInsensitive() {
        assertTrue(caseInsensitivePageComparator.compare(amazon, google) < 0);
        assertTrue(caseInsensitivePageComparator.compare(google, amazon) > 0);
    }

    @Test
    @GradedTest(name = "testCaseInsensitiveCaseCheckDiffering", max_score = 1)
    public void testCaseInsensitiveCaseCheckDiffering() {
        assertTrue(caseInsensitivePageComparator.compare(googleShouting, amazon) > 0);
        assertTrue(caseInsensitivePageComparator.compare(amazon, googleShouting) < 0);
    }

    @Test
    @GradedTest(name = "testCaseInsensitiveCaseCheckSame", max_score = 1)
    public void testCaseInsensitiveCaseCheckSame() {
        assertTrue(caseInsensitivePageComparator.compare(googleShouting, google) == 0);
        assertTrue(caseInsensitivePageComparator.compare(google, googleShouting) == 0);
    }
}
