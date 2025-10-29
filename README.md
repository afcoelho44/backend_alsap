# 🗺️ Backend ALSAP

Backend da aplicação **ALSAP (Atlas Linguístico Sonoro do Amapá)** — desenvolvido em **Java com Spring Boot**.  
O sistema fornece uma API REST responsável por gerenciar os dados linguísticos, processar requisições e integrar o banco de dados da aplicação web.

---

## 📖 Sobre o Projeto

O **ALSAP** é uma aplicação web que visa **facilitar a visualização e o acesso aos dados geolinguísticos** coletados pelo projeto **Atlas Linguístico do Amapá (ALAP)**.  
A plataforma permite a exploração das variações linguísticas através de **mapas interativos** e **áudios das pronúncias locais**, democratizando o acesso às pesquisas tanto para especialistas quanto para o público geral.

O **backend** foi projetado para dar suporte a essas funcionalidades, oferecendo endpoints RESTful seguros e eficientes.

---

## ⚙️ Funcionalidades do Backend

- Gerencia a **lógica de negócio** e o acesso ao banco de dados.  
- Fornece **endpoints REST** para o frontend (React + Leaflet).  
- Manipula **dados de áudios, perguntas, respostas, cidades e narrativas**.    
- Suporta **upload e associação de arquivos sonoros** às localidades.  
- Permite **visualização e filtragem dos dados linguísticos** via API.  

---

## 🧩 Estrutura do Projeto

O backend segue o padrão **Model–View–Controller (MVC)**, organizado em camadas independentes:
src/
├── main/java/br/udesc/alsap/
│ ├── config/ # Configurações globais (CORS, exceções, etc.)
│ ├── controller/ # Endpoints da API
│ ├── service/ # Lógica de negócio
│ ├── repository/ # Comunicação com o banco (Spring Data JPA)
│ ├── entity/ # Entidades do banco (mapeadas via JPA)
│ ├── model/ # DTOs para transporte de dados
│ └── mapper/ # Conversão entre entidades e DTOs
└── resources/
└── application.properties


A biblioteca **Lombok** é utilizada para reduzir a verbosidade do código (getters, setters, construtores automáticos).

---

## 🧠 Tecnologias Utilizadas

- **Java 17**  
- **Spring Boot**  
- **Spring Data JPA**  
- **PostgreSQL**  
- **Lombok**  
- **Docker**  
- **Render (implantação)**  

---

## 🗄️ Banco de Dados

O **PostgreSQL** é utilizado para armazenar todas as informações do sistema, como:

- Perguntas e respostas dos questionários linguísticos  
- Localidades e cidades pesquisadas  
- Áudios das pronúncias e narrativas  
- Dados de usuários e pesquisadores  

A integração com o banco é feita via **Spring Data JPA**, que automatiza operações CRUD e garante integridade e consistência dos dados.

---
## 👩‍💻 Autora

**Ana Fábia Coelho dos Santos**  
Bacharela em Engenharia de Software – UDESC  
[GitHub: afcoelho44](https://github.com/afcoelho44)

---

## 📝 Licença

Este projeto está licenciado sob a **MIT License**.



