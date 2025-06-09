package utils;

import model.Car;
import model.CarList;

public class MergeSort {
        public static void sort(CarList<Car> list) {
            if (list.size() <= 1) return;

            int mid = list.size() / 2;

            CarList<Car> left = list.subList(0, mid);
            CarList<Car> right = list.subList(mid, list.size());

            sort(left);
            sort(right);
            merge(list, left, right);
        }

            private static void merge(CarList<Car> result, CarList<Car> left, CarList<Car> right) {
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
