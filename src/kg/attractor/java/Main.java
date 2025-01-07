package kg.attractor.java;

import kg.attractor.java.homework.RestaurantOrders;

public class Main {

    public static void main(String[] args) {

        // это для домашки
        // выберите любое количество заказов, какое вам нравится.
        var orders = RestaurantOrders.read("orders_100.json");
        System.out.println("Заказы по клиентам.");
        System.out.println(orders.getOrderCroupedCustomerName());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Структура заказов клиентов.");
        System.out.println(orders.getCustomerOrderStructure());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Клиент с макс суммой.");
        System.out.println(orders.getCustomerWithMaxTotal());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Клиент с мин суммой.");
        System.out.println(orders.getCustomerWithMinTotal());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Распределение товаров по количеству.");
        System.out.println(orders.getItemsGroupedCount());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("3 самых дорогих заказов.");
        System.out.println(orders.getTopExpensiveOrders(3));
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("3 самых дешевых заказов.");
        System.out.println(orders.getTopCheapOrders(3));
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Заказы с доставкой.");
        System.out.println(orders.getHomeDeliveryOrders());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Заказы от 100 до 500.");
        System.out.println(orders.getOrderTotalRange(100, 500));
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("email клиентов.");
        System.out.println(orders.getUniqueCustomerEmail());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Сортированные email.");
        System.out.println(orders.getSortedUniqueCustomerEmailWithoutSorted());
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        //var orders = RestaurantOrders.read("orders_100.json").getOrders();
        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
    }
}
