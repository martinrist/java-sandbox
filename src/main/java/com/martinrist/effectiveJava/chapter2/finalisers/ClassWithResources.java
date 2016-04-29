package com.martinrist.effectiveJava.chapter2.finalisers;

import java.io.PrintStream;

/**
 * Example of a class with an external resource that includes an
 * explicit termination method.  A finaliser includes a check to see that
 * the object has been terminated properly.
 * <p>
 * Also uses a 'Finaliser Guardian' to ensure that finalisation can't be
 * skipped by a subclass.
 */
public class ClassWithResources {

    private boolean terminated;
    private PrintStream output;

    public ClassWithResources(PrintStream output) {
        this.output = output;
    }

    /**
     * Writes the content to the PrintStream associated with this class.
     *
     * @param content Content to be written.
     * @throws IllegalStateException if the object has already been terminated.
     */
    public void write(String content) {
        checkTermination();
        output.print(content);
    }

    private void checkTermination() {
        if (terminated) {
            throw new IllegalStateException("Method called on terminated object");
        }
    }

    /**
     * 'Terminates' ths object by setting the terminated flag.
     *
     * @throws IllegalStateException if the object has already been terminated.
     */
    public void terminate() {
        checkTermination();
        output = null;
        terminated = true;
    }


    private final Object finaliserGuardian = new Object() {
        @Override
        protected void finalize() throws Throwable {
            try {
                if (!terminated || output != null) {
                    System.err.println("Object has been finalised before termination");
                    // perform other finalisation for this class
                }
            } finally {
                // if the outer object extended something other than Object...
                // super.finalize();
            }
        }
    };
}
