package com.martinrist.thinkingInJava.generics;

import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Utility class for use with Generators
 */
public class Generators {


    /**
     * Generic utility method that fills a Collection with objects generated from a generator.
     *
     * @param coll - The Collection to be filled.  The Collection is mutated by the method (yuck).
     * @param gen  - The generator to be used to fill the Collection.
     * @param n    - The number of items to put into the Collection.
     *
     * @return The updated Collection.
     */
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {

        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;

    }

    /**
     * Generic utility method that fills a List with objects generated from a generator.
     *
     * @param list - The List to be filled.  The List is mutated by the method (yuck).
     * @param gen  - The generator to be used to fill the List.
     * @param n    - The number of items to put into the List.
     *
     * @return The updated List.
     */
    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {

        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }
        return list;

    }

    /**
     * Generic utility method that fills a Queue with objects generated from a generator.
     *
     * @param queue - The Queue to be filled.  The Queue is mutated by the method (yuck).
     * @param gen   - The generator to be used to fill the Queue.
     * @param n     - The number of items to put into the Queue.
     *
     * @return The updated Queue.
     */
    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {

        for (int i = 0; i < n; i++) {
            queue.add(gen.next());
        }
        return queue;

    }

    /**
     * Generic utility method that fills a Set with objects generated from a generator.
     *
     * @param set  - The Set to be filled.  The Set is mutated by the method (yuck).
     * @param gen  - The generator to be used to fill the Set.
     * @param n    - The number of items to put into the Set.
     *
     * @return The updated Set.
     */
    public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {

        for (int i = 0; i < n; i++) {
            set.add(gen.next());
        }
        return set;

    }


}
