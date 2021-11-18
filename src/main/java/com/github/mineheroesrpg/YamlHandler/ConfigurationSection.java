package com.github.mineheroesrpg.YamlHandler;


import com.github.mineheroesrpg.YamlHandler.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConfigurationSection {
    @NotNull
    public Set<String> getKeys(boolean deep);

    @NotNull
    public Map<String, Object> getValues(boolean deep);

    public boolean contains(@NotNull String path);

    public boolean contains(@NotNull String path, boolean ignoreDefault);

    public boolean isSet(@NotNull String path);

    @Nullable
    public String getCurrentPath();

    @NotNull
    public String getName();

    @Nullable
    public Configuration getRoot();

    @Nullable
    public ConfigurationSection getParent();

    @Nullable
    public Object get(@NotNull String path);

    @Contract("_, !null -> !null")
    @Nullable
    public Object get(@NotNull String path, @Nullable Object def);

    public void set(@NotNull String path, @Nullable Object value);

    @NotNull
    public ConfigurationSection createSection(@NotNull String path);

    @NotNull
    public ConfigurationSection createSection(@NotNull String path, @NotNull Map<?, ?> map);

    // Primitives

    @Nullable
    public String getString(@NotNull String path);

    @Contract("_, !null -> !null")
    @Nullable
    public String getString(@NotNull String path, @Nullable String def);

    public boolean isString(@NotNull String path);

    public int getInt(@NotNull String path);

    public int getInt(@NotNull String path, int def);

    public boolean isInt(@NotNull String path);

    public boolean getBoolean(@NotNull String path);

    public boolean getBoolean(@NotNull String path, boolean def);

    public boolean isBoolean(@NotNull String path);

    public double getDouble(@NotNull String path);

    public double getDouble(@NotNull String path, double def);

    public boolean isDouble(@NotNull String path);

    public long getLong(@NotNull String path);

    public long getLong(@NotNull String path, long def);

    public boolean isLong(@NotNull String path);

    // Java

    @Nullable
    public List<?> getList(@NotNull String path);

    @Contract("_, !null -> !null")
    @Nullable
    public List<?> getList(@NotNull String path, @Nullable List<?> def);

    public boolean isList(@NotNull String path);

    @NotNull
    public List<String> getStringList(@NotNull String path);

    @NotNull
    public List<Integer> getIntegerList(@NotNull String path);

    @NotNull
    public List<Boolean> getBooleanList(@NotNull String path);

    @NotNull
    public List<Double> getDoubleList(@NotNull String path);

    @NotNull
    public List<Float> getFloatList(@NotNull String path);

    @NotNull
    public List<Long> getLongList(@NotNull String path);

    @NotNull
    public List<Byte> getByteList(@NotNull String path);

    @NotNull
    public List<Character> getCharacterList(@NotNull String path);

    @NotNull
    public List<Short> getShortList(@NotNull String path);

    @NotNull
    public List<Map<?, ?>> getMapList(@NotNull String path);

    @Nullable
    public <T extends Object> T getObject(@NotNull String path, @NotNull Class<T> clazz);

    @Contract("_, _, !null -> !null")
    @Nullable
    public <T extends Object> T getObject(@NotNull String path, @NotNull Class<T> clazz, @Nullable T def);

    @Nullable
    public <T extends ConfigurationSerializable> T getSerializable(@NotNull String path, @NotNull Class<T> clazz);

    @Contract("_, _, !null -> !null")
    @Nullable
    public <T extends ConfigurationSerializable> T getSerializable(@NotNull String path, @NotNull Class<T> clazz, @Nullable T def);

    @Nullable
    public ConfigurationSection getConfigurationSection(@NotNull String path);

    public boolean isConfigurationSection(@NotNull String path);

    @Nullable
    public ConfigurationSection getDefaultSection();

    public void addDefault(@NotNull String path, @Nullable Object value);
}
