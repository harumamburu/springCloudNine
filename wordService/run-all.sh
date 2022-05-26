./gradlew bootRun --args='--sentence.part=subject' >./logs/subject.log 2>&1 &
./gradlew bootRun --args='--sentence.part=verb' >./logs/verb.log 2>&1 &
./gradlew bootRun --args='--sentence.part=article.log' >./logs/article.log 2>&1 &
./gradlew bootRun --args='--sentence.part=adjective' >./logs/adjective.log 2>&1 &
./gradlew bootRun --args='--sentence.part=noun' >./logs/noun.log 2>&1 &

if [[ "$1" == "addCold" ]]; then
  ./gradlew bootRun --args='--sentence.part=cold-adjective --app.name.postfix=adjective' >./logs/cold-adjective.log 2>&1 &
  ./gradlew bootRun --args='--sentence.part=cold-noun --app.name.postfix=noun' >./logs/cold-noun.log 2>&1 &
fi

ps T