package me.rmullin.missing.util;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public final class Maps {
    private Maps() {
    }

    public static <K, K2, V> Function<Map.Entry<K, V>, Map.Entry<K2, V>> onKey(Function<? super K, ? extends K2> mapper) {
        return entry -> Map.entry(mapper.apply(entry.getKey()), entry.getValue());
    }

    public static <K, V, V2> Function<Map.Entry<K, V>, Map.Entry<K, V2>> onValue(Function<? super V, ? extends V2> mapper) {
        return entry -> Map.entry(entry.getKey(), mapper.apply(entry.getValue()));
    }

    public static <K> Predicate<Map.Entry<K, ?>> whenKey(Predicate<K> predicate) {
        return entry -> predicate.test(entry.getKey());
    }

    public static <V> Predicate<Map.Entry<?, V>> whenValue(Predicate<V> predicate) {
        return entry -> predicate.test(entry.getValue());
    }

    public static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> collectEntries() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
    }
}
