package io.primeval.saga.annotations.internal;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.primeval.saga.action.ActionKey;

public final class MethodActionKey extends ActionKey {

    public final Method method;

    public MethodActionKey(Method method) {
        this.method = method;
    }

    @Override
    public String repr() {
        return method.getDeclaringClass().getName() + "#" + method.getName() + "("
                + Stream.of(method.getParameterTypes()).map(c -> c.getName()).collect(Collectors.joining(",")) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        MethodActionKey other = (MethodActionKey) o;
        return Objects.equals(method, other.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method);
    }

}
