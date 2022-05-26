./gradlew bootRun >./eureka-prime.log 2>&1 &
./gradlew bootRun --args='--spring.profiles.active=secondary' >./eureka-second.log 2>&1 &
./gradlew bootRun --args='--spring.profiles.active=tertiary' >./eureka-third.log 2>&1 &
ps T