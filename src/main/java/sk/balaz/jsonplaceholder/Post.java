package sk.balaz.jsonplaceholder;

public record Post(
        Integer userId,
        Integer id,
        String title,
        String body) { }
