package com.yevdokymov;

import com.yevdokymov.figure.Figure3D;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Богдан Евдокимов
 * @version 1.0
 * Класс ListPlusArrays - реализация задания для лекций 1-2 Java Full Stack Developer 2022 ProfITSoft
 */
public class ListPlusArrays {
    /** Количество возвращаемых хеш-тегов для метода  findHash */
    private final int NUM_OF_HASH_WORD = 5;
    /**
     * Метод сортировки массива переменных типа int по убыванию и без учета отрицательных чисел
     * Реализовано двумя способами
     *
     * @param arr массив для сортировки.
     */
    public int[] sort(int[] arr){
        /*
        List<Integer> array = new ArrayList<>(Arrays.stream(arr).filter(x -> x > 0).
                sorted().boxed().toList());
        Collections.reverse(array);
        return  array.stream().mapToInt(i->i).toArray();
        */
        return  Arrays.stream(arr).filter(x -> x >= 0).map(i->-i).
                sorted().map(i->-i).boxed().mapToInt(Integer::intValue).toArray();
    }
    /**
     * Метод поиска хеш-тегов в списке строк
     *
     * @param text список строк, в которых могут быть хеш-теги
     * @return отсортированый по убыванию Map, с самыми популярными хеш-тегами
     */
    public Map<String,Integer> findHash (List<String> text) {
        Map<String,Integer> result = new HashMap<>();
        for (String oneString:text) {
            String[] splitText = oneString.split(" ");

            List<String> wordsWithHash = Arrays.stream(splitText).
                    filter(x -> x.startsWith("#")).
                    map(String::toLowerCase).
                    distinct().toList();
            for (String oneWord: wordsWithHash) {
                //из-за сплита по пробелу могут попасться слова с знаками припинания и так далее
                //replaceAll избавляется от знаков
                String replacedWord = oneWord.replaceAll("\\W","");
                result.merge(replacedWord,1,Integer::sum);
            }
        }
        return  result.entrySet().
                stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                limit(NUM_OF_HASH_WORD).
                collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (o1,o2)->o2,LinkedHashMap::new));
    }
    /**
     * Метод сортировки списка типа Figure3D по обьему фигур
     *
     * @param figures список обьектов, наследников класса Figure3D
     * @return отсортированый по возростанию список фигур
     */
    public List<Figure3D> sortFigure(List<Figure3D> figures){
        figures.sort(Comparator.comparing(Figure3D::getVolume));
        return figures;
    }
}
