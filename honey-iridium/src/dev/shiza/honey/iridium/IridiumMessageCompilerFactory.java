package dev.shiza.honey.iridium;

import com.iridium.colors.IridiumColors;
import dev.shiza.honey.message.MessageCompiler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.IridiumComponentSerializer;

public final class IridiumMessageCompilerFactory {

  private static final IridiumComponentSerializer COMPONENT_SERIALIZER =
      IridiumComponentSerializer.create();

  private IridiumMessageCompilerFactory() {}

  public static MessageCompiler<String> create() {
    return new IridiumMessageCompiler<>(IridiumColors::process);
  }

  public static MessageCompiler<Component> createAdventure() {
    return new IridiumMessageCompiler<>(COMPONENT_SERIALIZER::deserialize);
  }
}
