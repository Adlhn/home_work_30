package kg.attractor.java.homework;

import com.google.gson.Gson;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import kg.attractor.java.homework.domain.Item;
import kg.attractor.java.homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class RestaurantOrders {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private List<Order> orders;

    private RestaurantOrders(String fileName) {
        var filePath = Path.of("data", fileName);
        Gson gson = new Gson();
        try {
            orders = List.of(gson.fromJson(Files.readString(filePath), Order[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RestaurantOrders read(String fileName) {
        var ro = new RestaurantOrders(fileName);
        ro.getOrders().forEach(Order::calculateTotal);
        return ro;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!

    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    public Map<String, List<Order>> getOrderCroupedCustomerName() {
        return orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer().getFullName()));
    }

    public Map<String, List<Item>> getCustomerOrderStructure() {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getCustomer().getFullName(),
                        Collectors.flatMapping(order -> order.getItems().stream(), Collectors.toList())
                ));
    }

    public Optional<Order> getCustomerWithMaxTotal() {
        return orders.stream()
                .max(Comparator.comparingDouble(Order::getTotal));
    }

    public Optional<Order> getCustomerWithMinTotal() {
        return orders.stream()
                .min(Comparator.comparingDouble(Order::getTotal));
    }

    public Map<String, Long> getItemsGroupedCount() {
        return orders.stream()
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
    }

    public List<Order> getTopExpensiveOrders(int n) {
        return orders.stream()
                .sorted(Comparator.comparingDouble(Order::getTotal).reversed())
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Order> getTopCheapOrders(int n) {
        return orders.stream()
                .sorted(Comparator.comparingDouble(Order::getTotal))
                .limit(n)
                .collect(Collectors.toList());
    }

    public List<Order> getHomeDeliveryOrders() {
        return orders.stream()
                .filter(Order::isHomeDelivery)
                .collect(Collectors.toList());
    }

    public List<Order> getOrderTotalRange(double minTotal, double maxTotal) {
        return orders.stream()
                .filter(order -> order.getTotal() >= minTotal && order.getTotal() <= maxTotal)
                .collect(Collectors.toList());
    }

    public Set<String> getUniqueCustomerEmail() {
        return orders.stream()
                .map(order -> order.getCustomer().getEmail())
                .collect(Collectors.toSet());
    }

    public List<String> getSortedUniqueCustomerEmailWithoutSorted() {
        return orders.stream()
                .map(order -> order.getCustomer().getEmail())
                .distinct()
                .collect(Collectors.toCollection(() -> new TreeSet<>(String::compareTo)))
                .stream()
                .collect(Collectors.toList());
    }

    // Наполните этот класс решением домашнего задания.
    // Вам необходимо создать все необходимые методы
    // для решения заданий из домашки :)
    // вы можете добавлять все необходимые imports
    //
}
