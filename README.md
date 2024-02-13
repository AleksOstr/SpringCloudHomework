Что было сделано в ходе выполнения домашнего задания:

Подключены PostrgeSQL, Eureka Server
Реализованы сервисы Reader Service, Book Service, Issuance Service с соответствующими Rest-контроллерами и JPA репозиториями 
Реализовано взаимодействие Issuance Service с Book Service и Reader Service через WebClient

Домашнее задание:

Восстановить пример, рассмотренный на уроке (запустить эврику и 2 сервиса; заставить их взаимодействовать)
Сдать скриншот страницы /eureka/apps с зарегистрированными приложениями.
На скрине должно быть видно оба сервиса (book-service, issuer-service)

2.* Добавить третий сервис: сервис читателей.
Обогатить ручку GET /issue, чтобы она возвращала подробную информацию:

[
  {
    "id": "733a8a9f-7fbf-4eb6-9900-f3338007d848",
    "issuedAt": "2024-11-28",
    "book": {
      "id": "78a0d4d5-67db-45f8-b846-da410f01aa11",
      "name": "Absalom, Absalom!",
      "author": {
        "id": "4deeeb5b-f263-4c5f-9c8c-62b83b0977ee",
        "firstName": "Justen",
        "lastName": "Huels"
      }
    },
    "reader": {
      "id": "78a0d4d5-67db-45f8-b846-da410f01bc34",
      "firstName": "Имя читателя",
      "lastName": "Фамилия читателя"
    }
  }
]
