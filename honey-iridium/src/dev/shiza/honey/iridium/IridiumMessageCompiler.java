package dev.shiza.honey.iridium;

import static com.iridium.iridiumcolorapi.IridiumColorAPI.process;
import static com.iridium.iridiumcolorapi.IridiumColorAPI.stripColorFormatting;

import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.sanitizer.SanitizedPlaceholder;
import java.util.List;

class IridiumMessageCompiler implements MessageCompiler<String> {

  private static final char TAG_RESOLVER_INIT = '<';
  private static final char TAG_RESOLVER_STOP = '>';

  IridiumMessageCompiler() {}

  @Override
  public String compile(
      final String sanitizedContent, final List<SanitizedPlaceholder> placeholders) {
    String processedContent = sanitizedContent;
    for (final SanitizedPlaceholder placeholder : placeholders) {
      final String evaluatedValue = placeholder.evaluatedValue().toString();
      final String sanitizedValue = stripColorFormatting(evaluatedValue);
      processedContent =
          processedContent.replace(getResolvableTag(placeholder.key()), sanitizedValue);
      processedContent = process(processedContent);
    }
    return processedContent;
  }

  private String getResolvableTag(final String key) {
    return TAG_RESOLVER_INIT + key + TAG_RESOLVER_STOP;
  }
}
