package dev.shiza.honey.iridium;

import dev.shiza.honey.HoneyImpl;
import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.evaluator.PlaceholderContext;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.PlaceholderResolver;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;
import dev.shiza.honey.processor.ProcessorRegistry;

class IridiumHoneyImpl extends HoneyImpl<String> implements IridiumHoney {

  IridiumHoneyImpl(
      final MessageCompiler<String> messageCompiler,
      final PlaceholderContext placeholderContext,
      final PlaceholderResolver placeholderResolver,
      final PlaceholderSanitizer placeholderSanitizer,
      final PlaceholderEvaluator placeholderEvaluator,
      final ProcessorRegistry processorRegistry) {
    super(
        messageCompiler,
        placeholderContext,
        placeholderResolver,
        placeholderSanitizer,
        placeholderEvaluator,
        processorRegistry);
  }
}
