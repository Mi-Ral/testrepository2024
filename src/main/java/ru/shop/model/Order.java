package ru.shop.model;

public record Order(String id, String customerId, String productId, long count, long amount) {
}
