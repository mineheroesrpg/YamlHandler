package com.github.mineheroesrpg.YamlHandler;

import org.jetbrains.annotations.NotNull;


public class MemoryConfigurationOptions extends ConfigurationOptions {
    protected MemoryConfigurationOptions(@NotNull MemoryConfiguration configuration) {
        super(configuration);
    }

    @NotNull
    @Override
    public MemoryConfiguration configuration() {
        return (MemoryConfiguration) super.configuration();
    }

    @NotNull
    @Override
    public MemoryConfigurationOptions copyDefaults(boolean value) {
        super.copyDefaults(value);
        return this;
    }

    @NotNull
    @Override
    public MemoryConfigurationOptions pathSeparator(char value) {
        super.pathSeparator(value);
        return this;
    }
}
