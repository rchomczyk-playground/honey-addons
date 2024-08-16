package dev.shiza.honey.iridium.adventure;

import dev.shiza.honey.Honey;
import dev.shiza.honey.iridium.IridiumMessageCompilerFactory;
import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.PlaceholderResolver;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;
import dev.shiza.honey.reflection.ReflectivePlaceholderEvaluatorFactory;
import net.kyori.adventure.text.Component;

public interface AdventureIridiumHoney extends Honey<Component> {

  static AdventureIridiumHoney createReflective() {
    return create(
        IridiumMessageCompilerFactory.createAdventure(),
        PlaceholderResolver.create(),
        PlaceholderSanitizer.create(),
        ReflectivePlaceholderEvaluatorFactory.create());
  }

  private static AdventureIridiumHoney create(
      final MessageCompiler<Component> messageCompiler,
      final PlaceholderResolver placeholderResolver,
      final PlaceholderSanitizer placeholderSanitizer,
      final PlaceholderEvaluator placeholderEvaluator) {
    return new AdventureIridiumHoneyImpl(
        messageCompiler, placeholderResolver, placeholderSanitizer, placeholderEvaluator);
  }
}
