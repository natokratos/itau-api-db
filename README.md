# itau-api-db

Este projeto funciona como o servidor do banco de dados H2 para o projeto **itau-api-todo**. Com apenas um banco de dados central todas as instâncias do projeto **itau-api-todo** acessarão o mesmo banco e podemos deixá-lo com alta disponibilidade.

# Pré-requisitos

- Linux ou MacOS. É possível fazê-lo, mas este documento não cobre os comandos e procedimentos para rodar no Windows;
- Docker versão mais atual;
- Docker Compose versão mais atual;
- Maven versão mais atual;
- Git client versão mais atual;
- IDE para Desenvolvimento: STS, Eclipse ou IntelliJ;
- Criar um diretório na estação chamado workpsace que conterá os códigos-fonte;
- Editar o arquivo /etc/hosts e adicionar os seguintes IP's:
	
	127.0.0.1		itau-api-db
	
# Baixar o código-fonte

- Via linha de comando, entrar no diretório que conterá os códigos-fonte e executar os comandos abaixo, caso esteja vazio:

	cd $HOME/workspace
	git init
	git clone https://github.com/natokratos/itau-api-db.git

- Abrir a IDE de desenvolvimento, importar como projeto Maven existente.

# Compilar a aplicação

- Via linha de comando, mudar para o diretório itau-api-todo dentro do diretório de códigos-fonte:
  
	cd $HOME/workspace/itau-api-db
  
- Via linha de comando, executar o comando abaixo para gerar as classes, executar os testes e gerar o relatório de cobertura:

	mvn clean install

- A partir daqui basta usar a IDE de desenvolvimento para construir o código, compilar e testar a aplicação.

# Relatório de Cobertura

- O relatório estará disponível em:

	$HOME/workspace/itau-api-db/target/site/jacoco/index.html

- Deve ser acessado usando um browser de sua escolha.

# Rodando a aplicação local
  
- Para rodar basta executar a aplicação pelo IDE de desenvolvimento.

# Rodando a aplicação no Docker

- A aplicação já deve estar compilada para que funcione no Docker, veja na seção **Compilar a Aplicação**. Ao final da compilação, o jar será copiado para o diretório do docker, permitindo que o processo continue;


- Via linha de comando, mudar para o diretório:

	cd $HOME/workspace/itau-api-db/src/main/docker

- Via linha de comando, executar o comando abaixo:

	make build 

- As imagens serão criadas e/ou baixadas no registry do docker local;


- Via linha de comando, executar o comando abaixo:

	make run
	
- Ele vai criar o container do banco de dados e a rede compartilhada entre eles;


- Aguarde alguns instantes até que aplicação suba corretamente, via linha de comando verifique da seguinte forma:

	docker logs itau-api-db

- No browser veja se o console do banco de dados aparece:

	http://localhost:9010/h2

# Atualizar a Aplicação no Docker

- Para atualizar a aplicação no docker, primeiro pare os containers:

	docker stop itau-api-db

- Compile a aplicação novamente conforme descrito na seção **Compilar a Aplicação**;


- Via linha de comando execute os comandos a seguir:

	cd $HOME/workspace/itau-api-db/src/main/docker
	docker cp itau-api-db*.jar itau-api-db:/root/itau-api-db.jar
	
- Reinicie os containers:
	
	docker start itau-api-db

# Banco em memória

- A versão atual do banco não persiste os dados em disco;

- Para acessar o H2 (banco em memória) local use o seguinte endereço:

	http://localhost:9010/h2
    
- Coloque no campo JDBC_URL o valor para testar a conexão local:

	jdbc:h2:mem:itaudb

- Ou para testar a conexão via TCP:

	jdbc:h2:tcp://localhost:9000/mem:itaudb
  
- Coloque no campo Username o valor:

	sa
  
- Deixe o campo Password vazio
  
- Clique em Connect
