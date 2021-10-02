# Redis - Spring Boot 
- Basically Spring boot uses hash property of the redis to work with (refer to redis-nodejs repo to learn more) so , it serializes everything and stores it under hash which we specify using `@RedisHash` in entity class.
- Note : In Redis we store json value in serialized form ( remember using JSON.stringify before storing the value in redis )
```angular2html 
Basic Structure Involves : ObjectName ( referred To As Key Here ) 
  - It Contains Properties ( ref Field Here ) 
   - Each Property has Some Value 
```
