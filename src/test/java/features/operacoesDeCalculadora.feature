#language: pt

Funcionalidade: Operações Básicas da Calculadora
  Como usuário
  Quero realizar operações aritméticas básicas
  Para que eu possa validar a funcionalidade da calculadora

  Esquema do Cenario: Validando operações aritimeticas
    Dado eu abro o aplicativo
    Quando escolho a "<operacao>" depois informo os "<num1>" e "<num2>"
    Entao o resultado esperado é mostrado corretamente "<resultadoEsperado>"

    Exemplos:
      | operacao      | num1 | num2 | resultadoEsperado |
      | adicao        | 5    | 3    | 8              |
      | subtracao     | 10   | 4    | 6              |
      | multiplicacao | 7    | 2    | 14             |
      | divisao       | 12   | 4    | 3              |