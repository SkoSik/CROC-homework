package crocHomeWork;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * GsonParser - JSON парсер на основе библиотеки GSON
 */
public class GsonParser {
    Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy").create();

    /**
     * Парсинг json файла
     *
     * @param clazz - класс, лист экземляров которого будет создан на основании их json представлений
     * @param path  - путь до файла json
     */
    public <T> List<T> parse(Class<T[]> clazz, String path) throws FileNotFoundException {
        return Arrays.asList(gson.fromJson(new FileReader(path), clazz));
    }

    /**
     * Запись json файла
     *
     * @param results - результаты обработки
     * @param path    - путь до файла json
     */
    public <T> void write(LinkedHashMap<T, Integer> results, String path) throws FileNotFoundException {
        String result = gson.toJson(results);
        PrintWriter printWriter = new PrintWriter(path);
        printWriter.println(result);
        printWriter.close();
    }
}