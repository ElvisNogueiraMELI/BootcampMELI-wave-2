# SQL 3 - MOVIES DB


## 1. Explique o conceito de normalização e para que é usado.
A normalizaão é um processo de oganização de bancos de dados de acordo com regras projetadas e é usada para proteger os dados e tornar o banco de dados mais flexível, eliminar redund6ancia e a dependência inconsistente.

## 2. Adicione um filme à tabela de filmes.

```sql 

insert into movies (created_at, title, rating, awards, release_date,length,genre_id) values (now(), "Thor Ragnarok", 7.9, 0, '2017-10-26', 130, 1);
```

## 3. Adicione um gênero à tabela de gêneros.
```sql 
insert into genres (created_at, name, ranking, active) values (now(),"Thriller", 13, 1);
```

## 4. Associe o filme do Ex 2. ao gênero criado no Ex. 3.
```sql
update movies set updated_at = now(), genre_id=13 where id=23;
```

## 5. Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2.

```sql
update actors set updated_at=now(),favorite_movie_id=23 where id=47;
```

## 6. Crie uma cópia temporária da tabela de filmes.
```sql
create temporary table temporary_movies select id, created_at, updated_at, title, rating, awards,release_date,length, genre_id from movies;
```
## 7. Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.
```sql
delete from temporary_movies where awards<5;
```

## 8. Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
```sql
select g.name, count(m.id) from genres g, movies m where m.genre_id=g.id group by g.name;
```

## 9. Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
```sql
select a.first_name,a.last_name, m.title from actors a, movies m where a.favorite_movie_id=m.id and m.awards>5;
```

## 10. Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.
```sql
explain delete from temporary_movies where awards<5;
```

## 11. O que são os índices? Para que servem?
Um índice é uma tabela de busca rápida para encontrar os registros. Eles são usados para fazer buscas que são feitas com frequência em tabelas grandes.

## 12. Crie um índice sobre o nome na tabela de filmes.

```sql
create index index_name_movies on movies(title);
```

## 13. Verifique se o índice foi criado corretamente.
```sql
show index from movies;
```
