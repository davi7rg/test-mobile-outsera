# Test Mobile Outsera

Este repositório contém um projeto para testes automatizados de aplicações mobile utilizando **Java** e o framework **Cucumber**.

## Pré-requisitos

1. **Java 8+**: Certifique-se de que o JDK está instalado e configurado no seu ambiente.
2. **Maven**: Necessário para gerenciar as dependências do projeto.
3. **Android SDK**: Para executar testes em dispositivos Android.

## Configuração

1. Clone este repositório:
   ```bash
   git clone https://github.com/davi7rg/test-mobile-outsera.git
   cd test-mobile-outsera
2. Instale as dependências usando o Maven:
   ```bash
   mvn clean install
3. Configure os dispositivos de teste:
   - Certifique-se de que um emulador ou dispositivo físico Android está disponível e configurado.
   - Atualize o arquivo de configuração de teste, caso necessário.

## Execução dos Testes

1. Para rodar os testes, use o comando Maven:
   ```bash
   mvn test
2. Relatórios gerados podem ser encontrados no diretório target.

## Visualizando o Relatório

Após a execução dos testes, o relatório em HTML estará disponível no seguinte caminho:

```bash
target/cucumber-reports/cucumber.html
