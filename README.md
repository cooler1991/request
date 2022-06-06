# request
Тестовое задание  JAVA SPRING BOOT
ttt
Http запросы 
Запросы GET:
http://localhost:8080/request/findAll  - получить все заявки
http://localhost:8080/comment/findAll - получить все комментарии
http://localhost:8080/request/getListStatus - получить все возможные статусы
http://localhost:8080/request/findById/{id} -получить заявку по ID

Запросы POST:
http://localhost:8080/request/create - создать заявку(с комментарием)
JSON

{
  "describe" : "Новая заявка"  			
}

С комментариями
{
   "describe": "Заявка_моя",
   "comments":[{"text":"Новая"},{"text":"Новая2"}]
}


http://localhost:8080/comment/add/{id} - добавить комментарий к заявке по id
JSON
{
    "text" : "тест_комментарий"
}

Запросы PUT:
http://localhost:8080/request/update_status/{id} - обновить статус по id заявки
JSON
{
    "status" : "В работе"
}

Запросы DELETE:
http://localhost:8080/request/delete/{id} - удалить заявку по id и все комментарии к этой заявке
http://localhost:8080/comment/delete/{id} - удалить комментарий по id



