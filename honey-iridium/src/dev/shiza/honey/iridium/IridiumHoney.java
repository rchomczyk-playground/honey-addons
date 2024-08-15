package dev.shiza.honey.iridium;

import dev.shiza.honey.Honey;
import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.opel.OpelPlaceholderEvaluatorFactory;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.PlaceholderResolver;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;
import dev.shiza.honey.reflection.ReflectivePlaceholderEvaluatorFactory;
import pl.allegro.tech.opel.OpelEngine;
import pl.allegro.tech.opel.OpelEngineBuilder;

public interface IridiumHoney extends Honey<String> {

  static IridiumHoney createReflective() {
    return create(
        IridiumMessageCompilerFactory.create(),
        PlaceholderResolver.create(),
        PlaceholderSanitizer.create(),
        ReflectivePlaceholderEvaluatorFactory.create());
  }

  static IridiumHoney createOpel() {
    return createOpel(OpelEngineBuilder.create().build());
  }

  static IridiumHoney createOpel(final OpelEngine opelEngine) {
    return create(
        IridiumMessageCompilerFactory.create(),
        PlaceholderResolver.create(),
        PlaceholderSanitizer.create(),
        OpelPlaceholderEvaluatorFactory.create(opelEngine));
  }

  private static IridiumHoney create(
      final MessageCompiler<String> messageCompiler,
      final PlaceholderResolver placeholderResolver,
      final PlaceholderSanitizer placeholderSanitizer,
      final PlaceholderEvaluator placeholderEvaluator) {
    return new IridiumHoneyImpl(
        messageCompiler, placeholderResolver, placeholderSanitizer, placeholderEvaluator);
  }
}
