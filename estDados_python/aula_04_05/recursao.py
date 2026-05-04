#recursão é um processo onde uma função chama a si mesma, direta ou indiretamente, para resolver um problema.
# inicialização da variavel de controle
#condição de parada

def contagem_regressiva(n):
    if n > 0:
        print(n)
        contagem_regressiva(n - 1) # atualiza a variável n para a próxima chamada recursiva

def contagem_progressiva(n):
    if n > 0:
        contagem_progressiva(n - 1) # atualiza a variável n para a próxima chamada recursiva
        print(n) # codigo executando no desempilhamento de progresso

def soma_elementos(n):#inicialização da variavel de controle
    if n > 0:
        return n + soma_elementos(n - 1)
    else:
        return 0
    #if n > 0:
    #    soma = n + soma_elementos(n - 1) #empilhamento com a atualização da variavel de controle
    #    return soma
    #else:
    #    return 0
def soma_lista(lista, n):
    if n >0:
        return lista[n-1] + soma_lista(lista, n-1)
    else:
        return 0

def conta_pares(lista, n):
    if n > 0:
        if lista[n-1] % 2 == 0:
            return 1 + conta_pares(lista, n-1)
        else:
            return 0 + conta_pares(lista, n-1)
    else:
        return 0

#main
#contagem_regressiva(10)
#contagem_progressiva(10)
#soma_elementos(10)

lista = [10, 15, 20, 25, 30]
#print(soma_lista(lista, len(lista)))
print(conta_pares(lista, len(lista)))