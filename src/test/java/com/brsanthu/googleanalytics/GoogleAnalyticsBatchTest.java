package com.brsanthu.googleanalytics;

import static com.brsanthu.googleanalytics.internal.Constants.TEST_TRACKING_ID;

import org.junit.BeforeClass;
import org.junit.Test;

public class GoogleAnalyticsBatchTest {

    private static GoogleAnalytics ga = null;

    @BeforeClass
    public static void setup() {
//        ga = GoogleAnalytics.builder().withTrackingId(TEST_TRACKING_ID).withAppName("Junit Test").withAppVersion("1.0.0")
        ga = new GoogleAnalyticsBuilder().withTrackingId(TEST_TRACKING_ID).withAppName("Junit Test").withAppVersion("1.0.0")
                .withConfig(new GoogleAnalyticsConfig().setBatchingEnabled(true).setBatchSize(10)).build();
    }

    @Test
    public void testPageView() throws Exception {
        for(int i = 0; i<50; i++){
            ga.pageView("http://www.google.com", "Search").send();
        }
//        IntStream.range(0, 50).forEach(i -> {
//            ga.pageView("http://www.google.com", "Search").send();
//        });
    }
}