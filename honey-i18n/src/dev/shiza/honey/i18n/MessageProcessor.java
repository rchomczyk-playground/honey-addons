package dev.shiza.honey.i18n;

import dev.shiza.honey.processor.Processor;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageProcessor implements Processor {

  private static final Pattern MESSAGE_PATTERN = Pattern.compile("\\[\\[(\\w+):([^]]+)]]");
  private final MessageSource messageSource;

  public MessageProcessor(final MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @Override
  public String process(final String content) {
    final Matcher matcher = MESSAGE_PATTERN.matcher(content);
    if (matcher.find()) {
      final Locale locale = Locale.forLanguageTag(matcher.group(1));
      final String key = matcher.group(2);
      return messageSource.getMessage(locale, key);
    }
    return content;
  }
}
