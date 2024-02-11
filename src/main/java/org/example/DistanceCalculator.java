package org.example;

import java.io.*;
import java.util.Scanner;

public class DistanceCalculator {
    private static final double EARTH_RADIUS = 6371; // Средний радиус Земли в километрах

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки:");
        double lat1 = scanner.nextDouble(); // Широта первой точки
        double lon1 = scanner.nextDouble(); // Долгота первой точки

        System.out.println("Введите координаты второй точки:");
        double lat2 = scanner.nextDouble(); // Широта второй точки
        double lon2 = scanner.nextDouble(); // Долгота второй точки

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между точками: " + distance + " км");

        scanner.close();
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Переводим градусы в радианы
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Вычисляем разницу между широтами и долготами
        double latDiff = lat2Rad - lat1Rad;
        double lonDiff = lon2Rad - lon1Rad;

        // Вычисляем расстояние с использованием формулы гаверсинусов
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }
}