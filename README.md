# Dice

WeatherForecastProject

Steps for setup springBoot project

mvn clean
mvn compile
Run the main class now

Apis endpoints are 

curl --location 'http://localhost:8066/weather/forecast/summary/Berlin' \
--header 'client-id: 95495ENJRFNRDFNDR3949345N4KEFND' \
--header 'client-secret: DFJDJGNJ09583095KNGFMCDMWDKSLEQ43853894KNFKDRH892U2984J' \
--header 'Cookie: JSESSIONID=C0AFE31E2A29DC4055C3C55E1DA74B47'


curl --location 'http://localhost:8066/weather/forecast/summary/hourly/Berlin' \
--header 'client-id: 95495ENJRFNRDFNDR3949345N4KEFND' \
--header 'client-secret: DFJDJGNJ09583095KNGFMCDMWDKSLEQ43853894KNFKDRH892U2984J' \
--header 'Cookie: JSESSIONID=C0AFE31E2A29DC4055C3C55E1DA74B47'

Client Id and secret are randomly added 
As the request comes , first we do filteration and check whether it contains the correct client id and client secret.
After filteration , it will hit the third party api and also manages the exception and return the result.

**Note**: THis hourly based api is not subscribed in free subscription list (**weather/forecast/summary/hourly/Berlin**) . So it will not give the desired results .
