# Use uma imagem Maven mais atual com Java 17 LTS
FROM maven:3.9.4-eclipse-temurin-17 AS builder

LABEL authors="erickaugs@gmail.com"

# Define o diretório de trabalho
WORKDIR /home/app

# Copia apenas os arquivos essenciais para o build para evitar cache excessivo
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copia o restante do código-fonte
COPY . .

# Executa o build sem testes, com detalhes de depuração
RUN mvn clean install -DskipTests=true -e -X

# Segunda etapa para imagens menores em produção
FROM eclipse-temurin:17-jre-jammy AS runtime

WORKDIR /home/app

# Copia apenas o .jar final do build
COPY --from=builder /home/app/target/*.jar app.jar

# Porta que será exposta (ajuste conforme necessário)
EXPOSE 8080

# Comando de inicialização da aplicação
CMD ["java", "-jar", "app.jar"]
