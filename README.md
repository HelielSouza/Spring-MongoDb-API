# SPRING BOOT API - MONGODB 

### (pt-br)
## O que é:

Esse projeto trata-se API (Application programming interface) desenvolvida com SpringBoot 3 que implementa operações CRUD em rotas como usuário, postagens e comentários, algo que vemos com frequência em redes sociais. 
É utilizado MongoDB, um banco de dados orientado a documentos que trata  os objetos relacionado como uma unidade, de forma não normalizada, tendo uma leitura rápida, além de permitir obter uma escabilidade horizontal.

## Tecnologias utilizadas no desenvolvimento:
- **Spring boot 3**: Framework utilizado para facilitar o desenvolvimento de aplicações Java, automatizando configurações e inicializações.
- **MongoDB**: MongoDB é um banco de dados NoSQL orientado a documentos que armazena dados em um formato JSON-like (BSON), oferecendo flexibilidade e
  escalabilidade horizontal para aplicações de alta performance. É ideal para cenários onde os dados são dinâmicos e requerem esquemas flexíveis, como APIs de usuários, posts e comentários.

## Como funciona:
Envie requisições HTTP para as endpoints :
### GET
- ```/users```  
  Para retornar todos os usuários via JSON;
  
- ```/users/{id```  
  Para retornar um usuário pelo ID via JSON;
  
- ```/users/{id}/posts```  
  Para retornar todos as postagens de um usuário pelo seu ID via JSON;
  
- ```/posts```  
  Para retornar todos as postagens via JSON;
  
- ```/posts/{id}```  
  Para retornar uma postagem pelo ID via JSON;
  
- ```/posts/titlesearch?text={value}```  
  Para pesquisar postagem pelo título;
  
- ```/posts/fullsearch?text={value}&minDate{yyyy-MM-dd}&DmaxDate{yyyy-MM-dd}```    
  Para pesquisar postagem que contenha determinado conteúdo de texto, podendo acrescentar data mínima e data máxima como intervalo de tempo;

### POST
- ```/users```  
  Para criar um usuário.
  
![image](https://github.com/HelielSouza/Springboot3-MongoDb-API/assets/127799256/676d2790-24cf-4859-b5e1-01c5b485662f)

### PUT
- ```/users/{id}```  
  Para atualizar dados de determinado usuário.
  
![image](https://github.com/HelielSouza/Springboot3-MongoDb-API/assets/127799256/76522db0-a8f4-4046-ba98-5d88abeee34e)


### DELETE 
- ```/users/{id}```  
  Para apagar determinado usuário.

  ![image](https://github.com/HelielSouza/Springboot3-MongoDb-API/assets/127799256/63d9a405-dbdb-4e53-94b4-e13c7d77c371)
