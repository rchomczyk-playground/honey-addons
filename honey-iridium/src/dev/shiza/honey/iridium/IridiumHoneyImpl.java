package dev.shiza.honey.iridium;

import dev.shiza.honey.HoneyImpl;
import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.PlaceholderResolver;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;

class IridiumHoneyImpl extends HoneyImpl<String> implements IridiumHoney {

  IridiumHoneyImpl(
      final MessageCompiler<String> messageCompiler,
      final PlaceholderResolver placeholderResolver,
      final PlaceholderSanitizer placeholderSanitizer,
      final PlaceholderEvaluator placeholderEvaluator) {
    super(messageCompiler, placeholderResolver, placeholderSanitizer, placeholderEvaluator);
  }
}
