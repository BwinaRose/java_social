package bwina.java_social_server.core.exceptions;

import java.util.function.Supplier;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
