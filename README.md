# lanches-api
- Projeto desenvolvido com springboot, por ser um facilitador no desenvolvimento, controle de dependências pelo maven, testes unitários junit.

# Pré Requisitos
- Possuir docker instalado.
- Possuir maven instalado.

# Instruções

- Clonar o projeto git clone https://github.com/viniciusperalrodrigues/lanches-api.git
- Entrar na pasta clonada e executar o seguinte comando: "mvn clean package docker:build"
- Para verificar se a imagem do docker foi criada, executar o comando: "docker images"
- Deverá aparecer algo parecido com isso:

REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
lanches-api         latest              a29188f125ac        3 minutes ago       659MB

- Executar o comando docker run -i -t -p8080:8080 lanches-api, este comando irá inicializar o projeto dentro do docker.
