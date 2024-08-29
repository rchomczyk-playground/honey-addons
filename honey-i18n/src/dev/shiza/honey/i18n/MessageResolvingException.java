package dev.shiza.honey.i18n;

import java.util.Locale;

public class MessageResolvingException extends IllegalArgumentException {

  public MessageResolvingException(final Locale locale) {
    super("Could not resolve message for language with tag %s.".formatted(locale));
  }

  public MessageResolvingException(final String key) {
    super("Could not resolve message with key %s.".formatted(key));
  }
}
