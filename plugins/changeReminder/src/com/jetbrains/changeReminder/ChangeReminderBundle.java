// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.jetbrains.changeReminder;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

public class ChangeReminderBundle extends DynamicBundle {
  @NonNls private static final String BUNDLE = "messages.ChangeReminderBundle";
  private static final ChangeReminderBundle INSTANCE = new ChangeReminderBundle();

  private ChangeReminderBundle() {
    super(BUNDLE);
  }

  @NotNull
  public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object @NotNull ... params) {
    return INSTANCE.getMessage(key, params);
  }

  @NotNull
  public static Supplier<String> lazyMessage(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object @NotNull ... params) {
    return INSTANCE.getLazyMessage(key, params);
  }
}
