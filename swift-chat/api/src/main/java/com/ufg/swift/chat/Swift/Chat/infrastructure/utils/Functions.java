package com.ufg.swift.chat.Swift.Chat.infrastructure.utils;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *
 *  A class that contains Util Static Generic Functions.                                                                 <br>
 *  For correct behavior, this class must be within a Project in Java 8 or more.                                         <br><br>
 *
 *  Author: Robert Martins                                                                                               <br>
 *  Github: github.com/Robert-Martins
 *
 */
public final class Functions {

    /**
     *
     * Runs an Empty Action if a Boolean assertion is True
     *
     * @param value Boolean assertion
     * @param action Empty Action that may be run
     *
     */
    public static void acceptTrue(Boolean value, EmptyAction action) {
        if (Boolean.TRUE.equals(value))
            action.run();
    }

    /**
     *
     * Runs an Empty Action if a Boolean assertion is True or another if it isn't
     *
     * @param value Boolean assertion
     * @param action Empty Action that may be run
     * @param elseAction Empty Action that will run if it isn't True
     *
     */
    public static void acceptTrueOrElse(Boolean value, EmptyAction action, EmptyAction elseAction) {
        if (Boolean.TRUE.equals(value))
            action.run();
        else
            elseAction.run();
    }

    /**
     *
     * Runs an Empty Action if a Boolean assertion is True or throw an Exception if it isn't
     *
     * @param value Boolean assertion
     * @param action Empty Action that may be run
     * @param supplier Supplier Function that throws an Exception if value isn't True
     *
     */
    public static <X extends Throwable> void acceptTrueOrElseThrow(Boolean value, EmptyAction action, Supplier<? extends X> supplier) throws X {
        if (Boolean.TRUE.equals(value))
            action.run();
        else
            throw supplier.get();
    }

    /**
     *
     * Runs an Empty Action if a Boolean assertion is False
     *
     * @param value Boolean assertion
     * @param action Empty Action that may be run
     *
     */
    public static void acceptFalse(Boolean value, EmptyAction action) {
        if (Boolean.FALSE.equals(value))
            action.run();
    }

    /**
     *
     * Runs an Empty Action if a Boolean assertion is False or another if it isn't
     *
     * @param value Boolean assertion
     * @param action Empty Action that may be run
     * @param elseAction Empty Action that will run if it isn't False
     *
     */
    public static void acceptFalseOrElse(Boolean value, EmptyAction action, EmptyAction elseAction) {
        if (Boolean.FALSE.equals(value))
            action.run();
        else
            elseAction.run();
    }

    /**
     *
     * Runs an Empty Action if a Boolean assertion is False or throw an Exception if it isn't
     *
     * @param value Boolean assertion
     * @param action Empty Action that may be run
     * @param supplier Supplier Function that throws an Exception if value isn't False
     *
     */
    public static <X extends Throwable> void acceptFalseOrElseThrow(Boolean value, EmptyAction action, Supplier<? extends X> supplier) throws X {
        if (Boolean.FALSE.equals(value))
            action.run();
        else
            throw supplier.get();
    }

    /**
     *
     * Check if a value is Present, and it's equal to another
     *
     * @param value Value that will be checked if it is Present and equal to the other
     * @param toBeEqualTo Value that if the first is Present will check equality between then
     *
     * @return Statement Returns Boolean Statement composed with the isPresent() and equals() check
     *
     */
    public static <T> Boolean isPresentAndEqualTo(T value, T toBeEqualTo) {
        return Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo);
    }

    /**
     *
     * Do something with a value if it's Present, and it's equal to another
     *
     * @param value Value that will be checked if it is Present and equal to the other
     * @param toBeEqualTo Value that if the first is Present will check equality between then
     * @param consumer Consumer Function that accepts value
     *
     */
    public static <T> void ifPresentAndEqualToDo(T value, T toBeEqualTo, Consumer<T> consumer) {
        if (Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo))
            consumer.accept(value);
    }

    /**
     *
     * Do something with a value if it's Present, and it's equal to another or, if it isn't, run an action
     *
     * @param value Value that will be checked if it is Present and equal to the other
     * @param toBeEqualTo Value that if the first is Present will check equality between then
     * @param consumer Consumer Function that accepts value
     * @param action Empty Action that will be executed it value isn't present and doesn't match with another
     *
     */
    public static <T> void ifPresentAndEqualToDoOrElse(T value, T toBeEqualTo, Consumer<T> consumer, EmptyAction action) {
        if (Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo))
            consumer.accept(value);
        else
            action.run();
    }

    /**
     *
     * Do something with a value if it's Present, and it's equal to another or, if it isn't, run an action
     *
     * @param value Value that will be checked if it is Present and equal to the other
     * @param toBeEqualTo Value that if the first is Present will check equality between then
     * @param consumer Consumer Function that accepts value
     * @param supplier Supplier Function that will throw an Exception it value isn't present and doesn't match with another
     *
     */
    public static <T, X extends Throwable> void ifPresentAndEqualToDoOrElseThrow(T value, T toBeEqualTo, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(value).isPresent() && value.equals(toBeEqualTo))
            consumer.accept(value);
        else
            throw supplier.get();
    }

    /**
     *
     * Check if a value is Present and a Boolean Statement is True
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     *
     * @return Statement Returns Boolean Statement composed with the isPresent() and assertion is True
     *
     */
    public static <T> Boolean isPresentAndItsTrue(T value, Boolean assertion) {
        return Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion);
    }

    /**
     *
     * Do something with a value it's Present and a Boolean Statement is True
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     * @param consumer Consumer Function that accepts value
     *
     */
    public static <T> void ifPresentAndItsTrueDo(T value, Boolean assertion, Consumer<T> consumer) {
        if (Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion))
            consumer.accept(value);
    }

    /**
     *
     * Do something with a value if it's Present and a Boolean Statement is True or, if any don't match, execute and action
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     * @param consumer Consumer Function that accepts value
     * @param action Empty Action that will be executed if value isn't present or assertion isn't True
     *
     */
    public static <T> void ifPresentAndItsTrueDoOrElse(T value, Boolean assertion, Consumer<T> consumer, EmptyAction action) {
        if (Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion))
            consumer.accept(value);
        else
            action.run();
    }

    /**
     *
     * Do something if a value is Present and a Boolean Statement is True or, if any don't match, throw exception
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     * @param consumer Consumer Function that accepts value
     * @param supplier Supplier Function that will throw an Exception if value isn't present or assertion isn't True
     *
     */
    public static <T, X extends Throwable> void ifPresentAndItsTrueDoOrElseThrow(T value, Boolean assertion, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(value).isPresent() && Boolean.TRUE.equals(assertion))
            consumer.accept(value);
        else
            throw supplier.get();
    }

    /**
     *
     * Check if a value is Present and a Boolean Statement is False
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     *
     * @return Statement Returns Boolean Statement composed with the isPresent() and assertion is False
     *
     */
    public static <T> Boolean isPresentAndItsFalse(T value, Boolean assertion) {
        return Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion);
    }

    /**
     *
     * Do something with a value it's Present and a Boolean Statement is False
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     * @param consumer Consumer Function that accepts value
     *
     */
    public static <T> void ifPresentAndItsFalseDo(T value, Boolean assertion, Consumer<T> consumer) {
        if (Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion))
            consumer.accept(value);
    }

    /**
     *
     * Do something with a value if it's Present and a Boolean Statement is False or, if any don't match, execute and action
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     * @param consumer Consumer Function that accepts value
     * @param action Empty Action that will be executed if value isn't present or assertion isn't False
     *
     */
    public static <T> void ifPresentAndItsFalseDoOrElse(T value, Boolean assertion, Consumer<T> consumer, EmptyAction action) {
        if (Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion))
            consumer.accept(value);
        else
            action.run();
    }

    /**
     *
     * Do something if a value is Present and a Boolean Statement is False or, if any don't match, throw exception
     *
     * @param value Value that will be checked if it is Present
     * @param assertion Boolean statement that will be checked
     * @param consumer Consumer Function that accepts value
     * @param supplier Supplier Function that will throw an Exception if value isn't present or assertion isn't False
     *
     */
    public static <T, X extends Throwable> void ifPresentAndItsFalseDoOrElseThrow(T value, Boolean assertion, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(value).isPresent() && Boolean.FALSE.equals(assertion))
            consumer.accept(value);
        else
            throw supplier.get();
    }

    /**
     *
     * Do something with a Value if it is empty
     *
     * @param value Value to be checked if it is Empty
     * @param action Empty Action that will be executed if value isn't present
     *
     */
    public static <T> void ifEmptyDo(T value, EmptyAction action) {
        if(Optional.ofNullable(value).isEmpty())
            action.run();
    }

    /**
     *
     * Do something with a Value if it is empty o , if it isn't, do something with it
     *
     * @param value Value to be checked if it is Empty
     * @param action Empty Action that will be executed if value isn't present
     * @param consumer Consumer Function that accepts value
     *
     */
    public static <T> void ifEmptyDoOrElse(T value, EmptyAction action, Consumer<T> consumer) {
        if(Optional.ofNullable(value).isEmpty())
            action.run();
        else
            consumer.accept(value);
    }

    /**
     *
     * Do something with a Value if it is empty o , if it isn't, do something with it
     *
     * @param value Value to be checked if it is Empty
     * @param action Empty Action that will be executed if value isn't present
     * @param supplier Supplier Function that throws an exception if value is present
     *
     */
    public static <T, X extends Throwable> void ifEmptyDoOrElseThrow(T value, EmptyAction action, Supplier<? extends X> supplier) throws X {
        if(Optional.ofNullable(value).isEmpty())
            action.run();
        else
            throw supplier.get();
    }

    /**
     *
     * Do something with a Collection if it isn't empty
     *
     * @param collection Collection to be checked if it isn't Empty
     * @param consumer Consumer Function that accepts collection
     *
     */
    public static <T, U extends Collection<T>> void ifNotEmptyDo(U collection, Consumer<U> consumer) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            consumer.accept(collection);
    }

    /**
     *
     * Do something with a Collection if it isn't empty or, if it is, execute and action
     *
     * @param collection Collection to be checked if it isn't Empty
     * @param consumer Consumer Function that accepts collection
     * @param action Empty Action that will be executed if it is Empty
     *
     */
    public static <T, U extends Collection<T>> void ifNotEmptyDoOrElse(U collection, Consumer<U> consumer, EmptyAction action) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            consumer.accept(collection);
        else
            action.run();
    }

    /**
     *
     * Do something with a Collection if it isn't empty or, if it is, throw exception
     *
     * @param collection Collection to be checked if it isn't Empty
     * @param consumer Consumer Function that accepts collection
     * @param supplier Supplier Function that throws Exception if Collection is Empty
     *
     */
    public static <T, U extends Collection<T>, X extends Throwable> void ifNotEmptyDoOrElseThrow(U collection, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            consumer.accept(collection);
        else
            throw supplier.get();
    }

    /**
     *
     * Do something with each Element of a Collection if it isn't empty
     *
     * @param collection Collection to be checked if it isn't Empty
     * @param consumer Consumer Function that accepts a collection element
     *
     */
    public static <T, U extends Collection<T>> void ifNotEmptyDoForEach(U collection, Consumer<T> consumer) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            collection.forEach(consumer);
    }

    /**
     *
     * Do something with each Element of a Collection if it isn't empty or, if it is, execute an action
     *
     * @param collection Collection to be checked if it isn't Empty
     * @param consumer Consumer Function that accepts a collection element
     * @param action Empty Action that will be executed if the collection is empty
     *
     */
    public static <T, U extends Collection<T>> void ifNotEmptyDoForEachOrElse(U collection, Consumer<T> consumer, EmptyAction action) {
        if(Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            collection.forEach(consumer);
        else
            action.run();
    }

    /**
     *
     * Do something with each Element of a Collection if it isn't empty or, if it is, throws exception
     *
     * @param collection Collection to be checked if it isn't Empty
     * @param consumer Consumer Function that accepts a collection element
     * @param supplier Supplier Function that throws an Exception if the Collection is Empty
     *
     */
    public static <T, U extends Collection<T>, X extends Throwable> void ifNotEmptyDoForEachOrElseThrow(U collection, Consumer<T> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(collection).isPresent() && !collection.isEmpty())
            collection.forEach(consumer);
        else
            throw supplier.get();
    }

    /**
     *
     * Do something with a Collection if all of its Elements matches a Predicate
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     *
     */
    public static <T, U extends Collection<T>> void ifAllMatchDo(U collection, Predicate<T> predicate, Consumer<U> consumer) {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().allMatch(predicate))
            consumer.accept(collection);
    }

    /**
     *
     * Do something with a Collection if all of its Elements matches a Predicate or, if any doesn't, execute an action
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     * @param action Empty Action that will be executed if any Element doesn't match the Predicate
     *
     */
    public static <T, U extends Collection<T>> void ifAllMatchDoOrElse(U collection, Predicate<T> predicate, Consumer<U> consumer, EmptyAction action) {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().allMatch(predicate))
            consumer.accept(collection);
        else
            action.run();
    }

    /**
     *
     * Do something with a Collection if all of its Elements matches a Predicate or, if any doesn't, throws exception
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     * @param supplier Supplier Function that throws an Exception if any Element doesn't match the Predicate
     *
     */
    public static <T, U extends Collection<T>, X extends Throwable> void ifAllMatchDoOrElseThrow(U collection, Predicate<T> predicate, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().allMatch(predicate))
            consumer.accept(collection);
        else
            throw supplier.get();
    }

    /**
     *
     * Do something with a Collection if any of its Elements matches a Predicate
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     *
     */
    public static <T, U extends Collection<T>> void ifAnyMatchDo(U collection, Predicate<T> predicate, Consumer<U> consumer) {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().anyMatch(predicate))
            consumer.accept(collection);
    }

    /**
     *
     * Do something with a Collection if all of its Elements matches a Predicate or, if none does, execute an action
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     * @param action Empty Action that will be executed if none of the Elements doesn't match the Predicate
     *
     */
    public static <T, U extends Collection<T>> void ifAnyMatchDoOrElse(U collection, Predicate<T> predicate, Consumer<U> consumer, EmptyAction action) {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().anyMatch(predicate))
            consumer.accept(collection);
        else
            action.run();
    }

    /**
     *
     * Do something with a Collection if all of its Elements matches a Predicate or, if none does, throws exception
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     * @param supplier Supplier Function that throws Exception if none of the Elements doesn't match the Predicate
     *
     */
    public static <T, U extends Collection<T>, X extends Throwable> void ifAnyMatchDoOrElseThrow(U collection, Predicate<T> predicate, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().anyMatch(predicate))
            consumer.accept(collection);
        else
            throw supplier.get();
    }

    /**
     *
     * Do something with a Collection if none of its Elements matches a Predicate
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     *
     */
    public static <T, U extends Collection<T>> void ifNoneMatchDo(U collection, Predicate<T> predicate, Consumer<U> consumer) {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().noneMatch(predicate))
            consumer.accept(collection);
    }

    /**
     *
     * Do something with a Collection if none of its Elements matches a Predicate or, if any does, execute an action
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     * @param action Empty Action that will be executed if any of the Elements does match the Predicate
     *
     */
    public static <T, U extends Collection<T>> void ifNoneMatchDoOrElse(U collection, Predicate<T> predicate, Consumer<U> consumer, EmptyAction action) {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().noneMatch(predicate))
            consumer.accept(collection);
        else
            action.run();
    }

    /**
     *
     * Do something with a Collection if none of its Elements matches a Predicate or, if any does, execute an action
     *
     * @param collection Collection which all Elements will be checked
     * @param predicate Predicate Function that will be used to Evaluate each Collection Element
     * @param consumer Consumer Function that accepts the collection
     * @param supplier Supplier Function that will throw an Exception if any of the Elements does match the Predicate
     *
     */
    public static <T, U extends Collection<T>, X extends Throwable> void ifNoneMatchDoOrElseThrow(U collection, Predicate<T> predicate, Consumer<U> consumer, Supplier<? extends X> supplier) throws X {
        if (Optional.ofNullable(collection).isPresent() && collection.stream().noneMatch(predicate))
            consumer.accept(collection);
        else
            throw supplier.get();
    }

}
