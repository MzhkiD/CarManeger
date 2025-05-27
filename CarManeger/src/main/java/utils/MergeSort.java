package utils;

import model.Car;
import java.util.List;

public class MergeSort {
    public static void sort(List<Car> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        List<Car> left = list.subList(0, mid);
        List<Car> right = list.subList(mid, list.size());

        sort(left);
        sort(right);
        merge(list, left, right);
    }

    private static void merge(List<Car> result, List<Car> left, List<Car> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getPrice() <= right.get(j).getPrice())
                result.set(k++, left.get(i++));
            else
                result.set(k++, right.get(j++));
        }
        while (i < left.size()) result.set(k++, left.get(i++));
        while (j < right.size()) result.set(k++, right.get(j++));
    }
}
