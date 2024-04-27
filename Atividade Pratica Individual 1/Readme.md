# Sistema Bancário com Threads em Java

Este é um projeto em Java que simula um sistema bancário utilizando threads. O sistema inclui entidades como Banco, Loja, Funcionário, Cliente e Conta, e garante transações coordenadas e consistentes entre essas entidades.

## Funcionalidades

- O sistema inclui uma implementação básica de um sistema bancário com as seguintes funcionalidades:
  - Clientes realizam compras em lojas, alternando entre as lojas disponíveis e debitando de suas contas.
  - Lojas recebem pagamentos dos clientes e pagam os funcionários assim que possuem o valor dos salários.
  - Funcionários recebem salários das lojas, investem parte do salário em uma conta de investimentos e realizam operações de pagamento.
- O banco garante a consistência das transações e coordena as operações de forma síncrona.

## Requisitos

- Java 17 ou superior.

## Autor

[Cecilia Cortes Lopes](https://github.com/CeciliaCortesL)
