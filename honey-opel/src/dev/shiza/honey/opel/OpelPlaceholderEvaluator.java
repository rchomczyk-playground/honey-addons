package dev.shiza.honey.opel;

import dev.shiza.honey.placeholder.evaluator.EvaluatedPlaceholder;
import dev.shiza.honey.placeholder.evaluator.PlaceholderContext;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.Placeholder;
import dev.shiza.honey.placeholder.visitor.PlaceholderVisitor;
import pl.allegro.tech.opel.EvalContext;
import pl.allegro.tech.opel.EvalContextBuilder;
import pl.allegro.tech.opel.OpelEngine;

class OpelPlaceholderEvaluator implements PlaceholderEvaluator {

  private final OpelEngine opelEngine;

  OpelPlaceholderEvaluator(final OpelEngine opelEngine) {
    this.opelEngine = opelEngine;
  }

  @Override
  public EvaluatedPlaceholder evaluate(
      final PlaceholderContext context,
      final PlaceholderVisitor<?> visitor,
      final Placeholder placeholder) {
    return new EvaluatedPlaceholder(
        placeholder, opelEngine.eval(placeholder.expression(), getAsEvalContext(context)));
  }

  private EvalContext getAsEvalContext(final PlaceholderContext context) {
    return EvalContextBuilder.create().withValues(context.getPromisedValues()).build();
  }
}
