package dev.shiza.honey.iridium;

import static com.iridium.colors.IridiumColors.stripColorFormatting;

import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.sanitizer.SanitizedPlaceholder;
import java.util.List;
import java.util.function.Function;

class IridiumMessageCompiler<T> implements MessageCompiler<T> {

  private static final char TAG_RESOLVER_INIT = '<';
  private static final char TAG_RESOLVER_STOP = '>';
  private final Function<String, T> transformation;

  IridiumMessageCompiler(final Function<String, T> transformation) {
    this.transformation = transformation;
  }

  @Override
  public T compile(final String sanitizedContent, final List<SanitizedPlaceholder> placeholders) {
    String processedContent = sanitizedContent;
    for (final SanitizedPlaceholder placeholder : placeholders) {
      final String evaluatedValue = placeholder.evaluatedValue().toString();
      final String sanitizedValue = stripColorFormatting(evaluatedValue);
      processedContent =
          processedContent.replace(getResolvableTag(placeholder.key()), sanitizedValue);
    }
    return transformation.apply(processedContent);
  }

  private String getResolvableTag(final String key) {
    return TAG_RESOLVER_INIT + key + TAG_RESOLVER_STOP;
  }
}
