package com.github.mineheroesrpg.YamlHandler.serialization;

import org.jetbrains.annotations.NotNull;

import java.util.Map;


public interface ConfigurationSerializable {

    @NotNull
    public Map<String, Object> serialize();
}
