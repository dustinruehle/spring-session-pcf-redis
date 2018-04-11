# Using PCF Redis tile as a session backing service


This is a small sample demonstrating using Spring Session and the PCF 
Redis Tile as a backing service to store the Http Session.

## Running the sample

`mvnw clean package`

`cf create-service p-redis shared-vm redis`

`cf update-service redis -t session-replication`
  
`cf push`

## See it in action

### Deploy a _Redis Reader_ app

To interact with the redis instance in your space, Craig Olrich
(github id: colrich), built a simple app using Jedis to connect to the Redis
Instance. It was forked and added a couple of methods to flush and retireve
all keys making it a little easier to work with this sample.

https://github.com/dustinruehle/RedisForPCF-Java-Example

- clone, package and push this app

### To see the session with Redis working

- from a terminal, `curl <path to your redis reader app>/flush` - to clear the redis cache
- from a terminal, `curl <path to your redis reader app>/keys` - prove to yourself it's empty
- open a browser
- navigate to `<path to your session redis sample app>/now` - returns a timestamp
- from a terminal, `curl <path to your redis reader app>/keys` - see a bunch of redis session keys
- navigate to `<path to your session redis sample app>/value` - to see the timestamp from above retrieved from the http session

### References:

https://redis.io/topics/security - #**Disabling of specific commands**m section

http://docs.pivotal.io/redis/1-11/quickstart.html


