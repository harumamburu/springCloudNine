./gradlew bootRun --args='--sentence.part=subject' >./subject.log 2>&1 &
./gradlew bootRun --args='--sentence.part=verb' >./verb.log 2>&1 &
./gradlew bootRun --args='--sentence.part=article' >./article 2>&1 &
./gradlew bootRun --args='--sentence.part=adjective' >./adjective.log 2>&1 &
./gradlew bootRun --args='--sentence.part=noun' >./noun.log 2>&1 &

if [[ "$1" == "addCold" ]]; then
  ./gradlew bootRun --args='--sentence.part=cold-adjective --app.name.postfix=adjective' >./cold-adjective.log 2>&1 &
  ./gradlew bootRun --args='--sentence.part=cold-noun --app.name.postfix=noun' >./cold-noun.log 2>&1 &
fi

ps T