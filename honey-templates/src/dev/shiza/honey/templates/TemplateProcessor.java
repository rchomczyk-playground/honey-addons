package dev.shiza.honey.templates;

import dev.shiza.honey.placeholder.evaluator.PlaceholderContext;
import dev.shiza.honey.processor.Processor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TemplateProcessor implements Processor {

  private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\{\\{([^}]+)}}");
  private static final Pattern TEMPLATE_PATTERN = Pattern.compile("<<([^>]+)>>");
  private final PlaceholderContext placeholderContext;

  public TemplateProcessor(final PlaceholderContext placeholderContext) {
    this.placeholderContext = placeholderContext;
  }

  @Override
  public String process(final String content) {
    final TemplateByStrippedContent templateByStrippedContent =
        getTemplateByStrippedContent(content);
    if (templateByStrippedContent == null) {
      return content;
    }
    final Template template = templateByStrippedContent.template();

    String processedContent = templateByStrippedContent.content();

    final Matcher matcher = PLACEHOLDER_PATTERN.matcher(processedContent);
    while (matcher.find()) {
      final String placeholderGroup = matcher.group();
      processedContent =
          processedContent.replace(
              placeholderGroup, template.value() + placeholderGroup + template.content());
    }

    return processedContent;
  }

  private TemplateByStrippedContent getTemplateByStrippedContent(final String content) {
    final Matcher matcher = TEMPLATE_PATTERN.matcher(content);
    if (matcher.find()) {
      final String templateTag = matcher.group();
      final String templateName = matcher.group(1);
      final Template template = (Template) placeholderContext.getValue(templateName);
      final String strippedContent = content.replace(templateTag, template.initial());
      final String prefix = strippedContent.substring(0, template.initial().length() + 1);
      final String suffix =
          strippedContent.substring(template.initial().length() + 1, strippedContent.length() - 1);
      return new TemplateByStrippedContent(template, prefix + template.content() + suffix);
    }

    return null;
  }

  private record TemplateByStrippedContent(Template template, String content) {}
}
