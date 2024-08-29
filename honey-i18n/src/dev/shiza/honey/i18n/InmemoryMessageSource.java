package dev.shiza.honey.i18n;

import java.util.Locale;
import java.util.Map;

class InmemoryMessageSource implements MessageSource {

  private final Locale fallbackLocale;
  private final Map<Locale, Map<String, String>> messages;

  InmemoryMessageSource(
      final Locale fallbackLocale, final Map<Locale, Map<String, String>> messages) {
    this.fallbackLocale = fallbackLocale;
    this.messages = messages;
  }

  @Override
  public void register(final Locale locale, final Map<String, String> localizedMessages) {
    messages.put(locale, localizedMessages);
  }

  @Override
  public String getMessage(final Locale locale, final String key) {
    Map<String, String> localizedMessages = messages.get(locale);
    if (localizedMessages == null) {
      if (fallbackLocale == null) {
        throw new MessageResolvingException(locale);
      }
      localizedMessages = messages.get(fallbackLocale);
    }

    final String localizedMessage = localizedMessages.get(key);
    if (localizedMessage == null) {
      throw new MessageResolvingException(key);
    }

    return localizedMessage;
  }
}
