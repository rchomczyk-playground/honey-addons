package dev.shiza.honey.iridium;

import dev.shiza.honey.message.MessageCompiler;

public final class IridiumMessageCompilerFactory {

  private IridiumMessageCompilerFactory() {}

  public static MessageCompiler<String> create() {
    return new IridiumMessageCompiler();
  }
}
