package com.wh.log;
import org.apache.log4j.Logger;
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public Application() {
    }

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 10; ++i) {
            LOGGER.debug("Info log [" + i + "].");
            Thread.sleep(500L);
        }

    }

    public void xxx(Person p) {
    }
}
