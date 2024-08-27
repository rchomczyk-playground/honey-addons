package dev.shiza.honey.iridium.adventure;

import dev.shiza.honey.HoneyImpl;
import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.evaluator.PlaceholderContext;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.PlaceholderResolver;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;
import net.kyori.adventure.text.Component;

class AdventureIridiumHoneyImpl extends HoneyImpl<Component> implements AdventureIridiumHoney {

  AdventureIridiumHoneyImpl(
      final MessageCompiler<Component> messageCompiler,
      final PlaceholderContext globalContext,
      final PlaceholderResolver placeholderResolver,
      final PlaceholderSanitizer placeholderSanitizer,
      final PlaceholderEvaluator placeholderEvaluator) {
    super(messageCompiler, globalContext, placeholderResolver, placeholderSanitizer, placeholderEvaluator);
  }
}
