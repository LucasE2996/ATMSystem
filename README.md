# ATMSystem

**Regras de Negócio:**

 - verificar numero de account

 - Executar as seguintes funções:
 	1. saldo
 	2. saque
 	3. depósito
 	4. tranferencia
 	5. extrato
 	6. sair

 - valor inicial do caixa: R$ 1.000
 	- variar entre as notas 100, 50, 20, 10.

 - 4 contas disponiveis:
 	João da Silva – 54125-9 – R$ 10.854,78
	Pedro Otávio Magalhães – 25214-8 – R$1.050,99
	Maria Green – 88452-1 – R$ 7.696,00
	Stephan Pereira – 15935-7 – R$ 412,13

- Cada correntista tem apenas uma account corrente


PLAYERS:
- Correntista (externo, não entra no software)
- Conta
- Caixa eletronico

FEATURES:
- verificar account (login)
- verificar saldo
- fazer saque
- fazer depósito
- fazer tranferencia
- verificasr extrato

VERIFICAR CONTA:
- verificar se o número da account digitada está cadastrada.

SALDO:
 - retorna saldo disponivel, mesmo negativo ou zerado(0).
 - substituir saldo por depósito inicial.
 - utilizar Event Sourcing para pegar saldo.

 SAQUE:
 - verifica se saldo é suficiente.
 - separa o valor solicitado em notas de 100, 50, 20 e 10.
 - retorna o valor solicitado explicitando a quantidade de notas de cada tipo.
 - retorna saldo atual.
 - caso tenha 300 reais no caixa, eu queira sacar 250 reais, porém eu tenho apenas notas de 100... ????

=============================================
Documentação de erros:

01 - Conta não existe

=============================================

*Qual padrão de design usar?
	- Command ( )
	- Chain of Responsability (x)

*Dicas: 
	-- utilizar byte para o valor das notas (V)
	-- utilizar flyweight em uma lista de notas ()
	-- utilizar proxy para fazer login
	-- criar uma exception para Caixa Eletronico	
	---- tentar utilizar strategy para as funções de caixa



