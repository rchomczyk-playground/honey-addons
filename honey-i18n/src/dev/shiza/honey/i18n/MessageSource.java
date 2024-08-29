package dev.shiza.honey.i18n;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public interface MessageSource {

  static MessageSource create(
      final Locale fallbackLocale, final Map<Locale, Map<String, String>> messages) {
    return new InmemoryMessageSource(fallbackLocale, messages);
  }

  static MessageSource create(final Map<Locale, Map<String, String>> messages) {
    return create(null, messages);
  }

  static MessageSource create() {
    return create(new HashMap<>());
  }

  void register(final Locale locale, final Map<String, String> messages);

  String getMessage(final Locale locale, final String key);
}
