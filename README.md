## Пример реализации Spring Data JPA

Приложение выполняет CRUD операции над представленными сущностями, используя Spring Data JPA.
Запросы принимаются в формате POST/GET запросов create, read, update, delete.
(Например http://localhost:8080/api/gear/create)
Передача информации осуществляется в формате JSON

пример: POST запрос: http://localhost:8080/api/engine/create/
Данные в формате JSON:
```json
{
"type": "V8 petrol engine",
"gears":[
{"size": 4},
{"size": 15}
]
}
```
Создаст двигатель автомобиля "V8 petrol engine" имеющего шестеренки размером 4 и 15.

Приложение создавалось на скорую руку, и далеко от идеала.
Приложению требуется подключение к базе данных.

Применяемые технологии:
* Spring Boot
* Spring MVC
* Spring Data JPA
* REST

