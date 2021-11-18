package com.github.mineheroesrpg.YamlHandler.file;


import com.github.mineheroesrpg.YamlHandler.Configuration;
import com.github.mineheroesrpg.YamlHandler.InvalidConfigurationException;
import com.github.mineheroesrpg.YamlHandler.MemoryConfiguration;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;

/*
File Configuration
 */
public abstract class FileConfiguration extends MemoryConfiguration {

    public FileConfiguration() {
        super();
    }

    public FileConfiguration(@Nullable Configuration defaults) {
        super(defaults);
    }

    public void save(@NotNull File file) throws IOException {
        Validate.notNull(file, "File cannot be null");

        Files.createParentDirs(file);

        String data = saveToString();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file), Charsets.UTF_8);

        try {
            writer.write(data);
        } finally {
            writer.close();
        }
    }

    public void save(@NotNull String file) throws IOException {
        Validate.notNull(file, "File cannot be null");

        save(new File(file));
    }

    @NotNull
    public abstract String saveToString();


    public void load(@NotNull File file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        Validate.notNull(file, "File cannot be null");

        final FileInputStream stream = new FileInputStream(file);

        load(new InputStreamReader(stream, Charsets.UTF_8));
    }

    public void load(@NotNull Reader reader) throws IOException, InvalidConfigurationException {
        BufferedReader input = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);

        StringBuilder builder = new StringBuilder();

        try {
            String line;

            while ((line = input.readLine()) != null) {
                builder.append(line);
                builder.append('\n');
            }
        } finally {
            input.close();
        }

        loadFromString(builder.toString());
    }

    public void load(@NotNull String file) throws FileNotFoundException, IOException, InvalidConfigurationException {
        Validate.notNull(file, "File cannot be null");

        load(new File(file));
    }

    public abstract void loadFromString(@NotNull String contents) throws InvalidConfigurationException;

    @NotNull
    protected abstract String buildHeader();

    @NotNull
    @Override
    public FileConfigurationOptions options() {
        if (options == null) {
            options = new FileConfigurationOptions(this);
        }

        return (FileConfigurationOptions) options;
    }
}
