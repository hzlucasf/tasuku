# Tasuku

A API **Tasuku** permite o gerenciamento de tarefas. Com ela, você pode criar, atualizar, listar e excluir tarefas, além de acompanhar o status e a prioridade de cada uma.

## Tecnologias

- Java
- Spring Boot
- PostgreSQL

## Endpoints

A API possui dois endpoints disponíveis:

- `/tasks` - Para criar e listar tarefas.
- `/tasks/{id}` - Para acessar, atualizar ou excluir uma tarefa específica.

## Campos da Tarefa

Cada tarefa possui os seguintes campos:

- `name`: Nome da tarefa (obrigatório).
- `description`: Descrição da tarefa (obrigatório).
- `finished`: Estado da tarefa. Indica se a tarefa foi concluída (`true`) ou não (`false`).
- `priority`: Prioridade da tarefa. Pode ser `"LOW"`, `"MEDIUM"` ou `"HIGH"`.

## Exemplos

1. Criar uma tarefa

- Método: `POST`
- Caminho: `/tasks`
- Corpo da solicitação:

```json
{
    "name": "Foo",
    "description": "Bar",
    "finished": false,
    "priority": "HIGH"
}
```

- Corpo da resposta:

```json
{
    "id": 1,
    "name": "Foo",
    "description": "Bar",
    "finished": false,
    "priority": "HIGH"
}
```

- Status da resposta: `201 (CREATED)`

2. Obter as tarefas cadastradas

- Método: `GET`
- Caminho: `/tasks`
- Corpo da resposta:

```json
[
    {
        "id": 1,
        "name": "Foo",
        "description": "Bar",
        "finished": false,
        "priority": "HIGH"
    },
    {
        "id": 2,
        "name": "Bar",
        "description": "Foo",
        "finished": true,
        "priority": "LOW"
    }
]
```

- Status da resposta: `200 (OK)`

3. Obter uma tarefa específica

- Método: `GET`
- Caminho: `/tasks/{id}`
- Corpo da resposta:

```json
{
    "id": 1,
    "name": "Foo",
    "description": "Bar",
    "finished": false,
    "priority": "HIGH"
}
```

- Status da resposta: `200 (OK)`

4. Atualizar uma tarefa

- Método: `PUT`
- Caminho: `/tasks/{id}`
- Corpo da solicitação:

```json
{
    "name": "Foo Bar Foo",
    "description": "Bar Foo Bar",
    "finished": true,
    "priority": "HIGH"
}
```

- Corpo da resposta:

```json
{
    "id": 1,
    "name": "Foo Bar Foo",
    "description": "Bar Foo Bar",
    "finished": true,
    "priority": "HIGH"
}
```

- Status da resposta: `200 (OK)`

5. Deletar uma tarefa

- Método: `DELETE`
- Caminho: `/tasks/1`
- Status da resposta: `204 (NO CONTENT)`
