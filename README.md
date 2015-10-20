This repository demonstrates an error when attempting to run integration tests
which involve more than one SpringApplicationConfiguration while using Gemfire
caching.

There are two test classes `ContextsApplicationTests` and
`ContextsApplicationWithCustomTests`.

The first uses a standard SpringApplicationConfiguration based on the
`ContextsApplication` class. The other attempts to also include the
`CustomConfiguration` class to override a Bean.

However, having Gemfire configured cases an issue with the context loader
throwing an `IllegalArgumentException`:

    Caused by: java.lang.IllegalArgumentException:
        a beanFactoryReference already exists for key cacheFactoryBean

The full output is included in the file `mvn-clean-install.txt`.
