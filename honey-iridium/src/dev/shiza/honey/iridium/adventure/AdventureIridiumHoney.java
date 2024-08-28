package dev.shiza.honey.iridium.adventure;

import dev.shiza.honey.Honey;
import dev.shiza.honey.iridium.IridiumMessageCompilerFactory;
import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.evaluator.PlaceholderContext;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.PlaceholderResolver;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;
import dev.shiza.honey.processor.ProcessorRegistry;
import dev.shiza.honey.reflection.ReflectivePlaceholderEvaluatorFactory;
import net.kyori.adventure.text.Component;

public interface AdventureIridiumHoney extends Honey<Component> {

  static AdventureIridiumHoney createReflective() {
    return createReflective(PlaceholderContext.create());
  }

  static AdventureIridiumHoney createReflective(final PlaceholderContext placeholderContext) {
    return create(
        IridiumMessageCompilerFactory.createAdventure(),
        placeholderContext,
        PlaceholderResolver.create(),
        PlaceholderSanitizer.create(),
        ReflectivePlaceholderEvaluatorFactory.create(),
        ProcessorRegistry.create());
  }

  private static AdventureIridiumHoney create(
      final MessageCompiler<Component> messageCompiler,
      final PlaceholderContext placeholderContext,
      final PlaceholderResolver placeholderResolver,
      final PlaceholderSanitizer placeholderSanitizer,
      final PlaceholderEvaluator placeholderEvaluator,
      final ProcessorRegistry processorRegistry) {
    return new AdventureIridiumHoneyImpl(
        messageCompiler,
        placeholderContext,
        placeholderResolver,
        placeholderSanitizer,
        placeholderEvaluator,
        processorRegistry);
  }
}
