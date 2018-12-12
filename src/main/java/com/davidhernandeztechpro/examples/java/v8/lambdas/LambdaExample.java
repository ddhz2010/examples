package com.davidhernandeztechpro.examples.java.v8.lambdas;


public class LambdaExample {

    public interface StringTransformation {
        String transform(String str);
    }

    public static String apply(String str, StringTransformation transformation) {
        return transformation.transform(str);
    }

    public static void main(String[] args) {
        LambdaExample lambdaExample = new LambdaExample();
        lambdaExample.runnableLambda();
        lambdaExample.basicLambdaExample();
        lambdaExample.lambdaArgument();
    }

    public void runnableLambda() {
        System.out.println("=== RunnableTest ===");

        // Anonymous Runnable
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world one (anonymous method)!");
            }
        };

        // Lambda Runnable
        // DH Note: this works because Runnable is a functional (i.e. an interface with a single method).
        // See how interface has no arguments and returns nothing.  So lambda has no arguments and returns nothing.
        // public abstract void run();
        Runnable r2 = () -> System.out.println("Hello world two (lambda)!");

        // Run em!
        r1.run();
        r2.run();
    }

    public void basicLambdaExample() {
        StringTransformation toUpperTransformer = (str) -> str.toUpperCase();
        StringTransformation toLowerTransformer = (str) -> str.toLowerCase();
        String inputStr = "Hello World";
        System.out.println("Input String: " +  inputStr);
        System.out.println("toUpperTransformer.transform(): " + toUpperTransformer.transform(inputStr));
        System.out.println("toLowerTransformer.transform(): " + toLowerTransformer.transform(inputStr) );

    }

    public void lambdaArgument() {
        System.out.println(LambdaExample.apply("Hello",
                (String str) -> {
                    // reverse
                    return str.toUpperCase();
                }
        ));
    }
}
