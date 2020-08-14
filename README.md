# Sorting

##Benchmarking Performance

    mvn clean install

    java -jar target/benchmarks.jar

This repo is created using jmh-java-benchmark archetype.

     mvn archetype:generate \
               -DinteractiveMode=false \
               -DarchetypeGroupId=org.openjdk.jmh \
               -DarchetypeArtifactId=jmh-java-benchmark-archetype \
               -DgroupId=com.arunapi \
               -DartifactId=Sorting \
               -Dversion=0.0.1
               