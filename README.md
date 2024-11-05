# 👗📚 Gerenciamento de Lookbooks Personalizados

## 🎯 Objetivo
A aplicação Gerenciamento de Lookbooks Personalizados (combinações de roupas) tem como foco ajudar os usuários a gerenciar seus lookbooks de forma fácil e intuitiva. O sistema permite a criação, edição, visualização e exclusão de lookbooks, além de associar peças de roupa a eles, ajudando o usuário a montar looks personalizados de acordo com suas preferências.

## 🏛️ Arquitetura do Projeto
Este projeto foi desenvolvido utilizando a seguinte stack de tecnologias:

- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Para facilitar o desenvolvimento da aplicação web com Java.
- **Thymeleaf**: Motor de templates para renderizar o HTML dinâmico no lado do servidor.
- **Bootstrap**: Framework de CSS para estilização das páginas HTML, proporcionando uma interface moderna e responsiva.
- **Maven** : Gerenciador de dependências
- **Spring Data JPA**: Para interação e persistência de dados no banco de dados.
- **Hibernate**: Para mapeamento objeto-relacional.
- **Lombok**: Para reduzir o boilerplate de getters, setters e construtores.
- **Oracle**: Banco de dados relacional para armazenar os lookbooks e as peças de roupas. **(Na entrega da sprint 3 por ora será pelo banco h2, pois a aplicação ainda está em desenvolvimento)**

## 📂 Estrutura de Pastas
```tree
  src/
  ├── main/
  │   ├── java/com/leadtech/lookbook/
  │   │   ├── controllers/
  │   │   ├── models/
  │   │   ├── repositories/
  │   │   └── services/
  │   └── resources/
  │       ├── templates/
  │       └── application.properties
  └── test/
```

## 💡 Dificuldades Encontradas
Durante o desenvolvimento, surgiram alguns desafios que foram superados ao longo do projeto:

- Problemas de Recursão: Enfrentamos um problema de recursão nos métodos toString() das classes de modelo Lookbook e ClothingItem, que foi corrigido com a implementação adequada do método.

## MER/DER

![image](https://github.com/user-attachments/assets/94ffbde2-404f-4451-8abe-4633da84cf34)


## 🌐 Funcionalidades Principais
- CRUD de Lookbooks: O usuário pode criar, editar, visualizar detalhes e deletar lookbooks.
- CRUD de Peças de Roupa: O usuário pode gerenciar suas peças de roupa associadas aos lookbooks.
- Visualização Detalhada: Exibe informações detalhadas sobre cada lookbook e suas peças associadas, incluindo imagens e valores.
- Fluxo de Autenticação do cliente (Admin poder ver os logs do actuator e user normal não)
- Implementação de um bot assistente(integrado a API do chat gpt)

# Vídeo
[link do video]()

## OBS:
Adicionar no application.properties a API key do chat gpt spring.ai.openai.api-key

### Integrantes do grupo
<table>
  <tr>
        <td align="center">
      <a href="https://github.com/biancaroman">
        <img src="https://avatars.githubusercontent.com/u/128830935?v=4" width="100px;" border-radius='50%' alt="Bianca Román's photo on GitHub"/><br>
        <sub>
          <b>Bianca Román</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/charlenefialho">
        <img src="https://avatars.githubusercontent.com/u/94643076?v=4" width="100px;" border-radius='50%' alt="Charlene Aparecida's photo on GitHub"/><br>
        <sub>
          <b>Charlene Aparecida</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/laiscrz">
        <img src="https://avatars.githubusercontent.com/u/133046134?v=4" width="100px;" alt="Lais Alves's photo on GitHub"/><br>
        <sub>
          <b>Lais Alves</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/LuccaRaphael">
        <img src="https://avatars.githubusercontent.com/u/127765063?v=4" width="100px;" border-radius='50%' alt="Lucca Raphael's photo on GitHub"/><br>
        <sub>
          <b>Lucca Raphael</b>
        </sub>
      </a>
    </td>
     <td align="center">
      <a href="https://github.com/Fabs0602">
        <img src="https://avatars.githubusercontent.com/u/111320639?v=4" width="100px;" border-radius='50%' alt="Fabricio Torres's photo on GitHub"/><br>
        <sub>
          <b>Fabricio Torres</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

