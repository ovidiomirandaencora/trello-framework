package com.ovidiomiranda.framework.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Pause functions are useful in all utility services.
 *
 * @author Ovidio Miranda
 */
public final class Pause {

  private static final Logger LOGGER = LogManager.getLogger(Pause.class);

  /**
   * Default Private Constructor.
   */
  private Pause() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  /**
   * Sleeps for the specified time.
   *
   * @param ms the time to sleep in milliseconds.
   */
  @SuppressWarnings("unused")
  public static void pause(final long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      LOGGER.error("Exception when executing a pause", e);
      Thread.currentThread().interrupt();
    }
  }
}
