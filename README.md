# Descrição do Projeto - BACKEND_TRABALHOFINAL
________________________________________
## Nome: Caseirinhos da Márcia
Objetivo: Sistema de gerenciamento de um catálogo de produtos de padaria e confeitaria caseiros sem glúten, permitindo o cadastro de produtos, usuários, controle de carrinho e auditoria de alterações, que no momento está configurado para a entidade produto.
________________________________________
## Integrantes do grupo
* Eunice Correia
* Katleen Mendes
* Hian Rick
________________________________________
## Descrição do Problema
A venda de produtos caseiros requer controle de estoque, gerenciamento de pedidos e rastreabilidade de alterações nos produtos. O sistema visa automatizar essas operações com uma interface de API RESTful.
________________________________________
## Tecnologias Utilizadas

•	IntelliJ
•	Java 17+
•	Spring Boot
•	Spring Data JPA
•	H2 Database
•	Maven
•	Insomnia (para testes de API)
________________________________________
## Limitações do Projeto
*	Autenticação/autorização ainda não implementada
*	Sem interface gráfica (apenas backend)
*	Foco em funcionalidade básica (CRUD)
________________________________________
## Entidades (com Controllers, DTOs, Mappers, Repositorys, Services)
*	Produto
*	Usuário
*	ItemCarrinho
*	AuditoriaProduto
________________________________________
## Rotas da API
Abaixo um resumo das rotas. Exemplos completos de requisições/respostas.
### • /produto
Método	Rota	Descrição
* GET	/produto -> Listar produtos (paginado)
* GET	/produto/{id} -> Buscar por ID
* POST	/produto -> Criar produto
* PUT	/produto/{id} -> Atualizar produto
* DELETE	/produto/{id} -> Deletar produto
### • /usuario
Método	Rota	Descrição
* GET	/usuario -> Listar usuários (paginado)
* GET	/usuario/{id} ->Buscar por ID
* POST	/usuario ->	Criar usuário
* PUT	/usuario/{id} -> Atualizar usuário
* DELETE	/usuario/{id} -> Deletar usuário
### • /itemCarrinho
Método	Rota	Descrição
* GET	/itemCarrinho -> Listar todos os itens
* GET	/itemCarrinho/usuario/{id} -> Itens por usuário
* GET	/itemCarrinho/{id} -> Buscar item por ID
* POST	/itemCarrinho -> Adicionar item ao carrinho
* PUT	/itemCarrinho/{id} -> Atualizar item do carrinho
* DELETE	/itemCarrinho/{id} -> Remover item do carrinho
### • /auditoria
Método	Rota	Descrição
* GET	/auditoria -> Listar logs de auditoria (paginado)
* GET	/auditoria/produto/{produtoId} -> Listar auditoria por produto
________________________________________
## Exemplos de Erros HTTP
Código	Quando ocorre
• 400	Requisição malformada (ex: JSON errado)
• 404	Recurso não encontrado
• 500	Erro interno no servidor
________________________________________
## Como Executar o Projeto Localmente
* 1.	Clone o repositório:
Você pode usar Git Bash, terminal ou qualquer ferramenta Git:
git clone https://github.com/EuniceCorreia/BACKEND_TRABALHOFINAL.git
* 2.	Abra o projeto no IntelliJ IDEA:
o	Se você baixou o .zip, extraia os arquivos para uma pasta de sua preferência.
o	No IntelliJ IDEA, clique em File > Open, navegue até a pasta do projeto clonado e selecione-a.
o	Aguarde o carregamento e a indexação do projeto.
o	Execute a classe CaseirinhosdamarciaApplication clicando com o botão direito sobre ela e selecionando Run.
* 3.	Acesse a API:
Após a execução bem-sucedida do projeto, a API estará disponível no endereço:
http://localhost:8080/produto
Outras rotas também estarão disponíveis, como /usuario, /itemCarrinho e /auditoria.
________________________________________
## Outros conteúdos relevantes
*	Auditoria de alterações nos produtos.
*	Mapeamento DTO <-> Entidade usando Mapper.
*	Suporte a paginação nas rotas principais.
________________________________________
                                   
***Trabalho Final Backend***
